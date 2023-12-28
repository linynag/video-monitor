package com.yiwei.common.component.excelNew;


import com.yiwei.common.component.config.MyException;
import com.yiwei.common.component.utils.StringUtils;
import com.yiwei.common.gridControl.vo.ExportCloumsModel;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ExcelUtils {

    private static Logger log = LoggerFactory.getLogger(ExcelUtils.class);

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 解析excel
     *
     * @param file
     * @return
     * @author: chenxin
     * @date: 2018年4月24日 下午9:42:40
     */
    public static ExcelObjModel readExcel(MultipartFile file) {
        return readExcel(file,1);
    }

    public static ExcelObjModel readExcel(MultipartFile file, int num) {
        ExcelObjModel model = new ExcelObjModel();
        model.setCode(0);
        try {
            // 不是excel文件
            if (file == null && file.isEmpty()) {
                model.setCode(ExcelObjModel.constant.IMPORT_EXCEL_NOT_FILE);
                model.setMsg("导入文件为空");
                return model;
            }
            String fileName = file.getOriginalFilename();
            // 不是excel文件
            if (!fileName.matches("^.+\\.(?i)((xls)|(xlsx))$")) {
                model.setCode(ExcelObjModel.constant.IMPORT_EXCEL_NOT_FILE);
                model.setMsg("导入的表不是excel文件");
                return model;
            }
            long fileSize = file.getSize();
            // 不是有效的文件，无文件内容。
            if (fileSize <= 0) {
                model.setCode(ExcelObjModel.constant.IMPORT_EXCEL_FILE_SIZE_ZERO);
                model.setMsg("导入的表不是有效的文件，无文件内容");
                return model;
            }
            String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
            List<Object> varList = null;
            if ("xls".equalsIgnoreCase(fileType)) {
                varList = importExcel2003(model,file, num);
            } else {
                varList = importExcel2007(model,file, num);
            }
            model.setList(varList);
            return model;
        } catch (MyException e) {
            model.setCode(400);
            model.setMsg("导入的表不是有效的文件或数据为空");
            return model;
        } catch (Exception e) {
            model.setCode(ExcelObjModel.constant.IMPORT_EXCEL_ERROT);
            model.setMsg("导入的表不是有效的文件");
            return model;
        }
    }

    /**
     * 遍历excel2007
     *
     * @param file
     * @param num
     * @return
     * @throws IOException
     * @author: chenxin
     * @date: 2018年4月24日 下午9:44:13
     */
    private static List<Object> importExcel2007(ExcelObjModel model,MultipartFile file, int num) throws Exception {
        List<Object> list = new ArrayList<>();
        InputStream in = file.getInputStream();
        XSSFWorkbook wb = new XSSFWorkbook(in);
        int sheetNumber = wb.getNumberOfSheets();
        if (sheetNumber < 0) {
            if (in != null) in.close();
            throw new MyException("导入的表不是有效的文件，无文件内容");
        }
        XSSFSheet sheet = wb.getSheetAt(0);//默认读取第一个页签的内容！！！
        int rows = sheet.getPhysicalNumberOfRows();
        if (rows <= 1) {
            throw new MyException("导入的表不是有效的文件或数据为空");
        }
        List<Object> objects = setHeadTitleList(num-1, sheet);
        if(objects.size()<=0){
            throw new MyException("标题不存在，请给模板取标题！");
        }
        //读取title对应的中文，存放到columns中
        Map<String,String> titleMap = (Map)objects.get(0);
        List<ExportCloumsModel> collect = new ArrayList<>();
        for (String key : titleMap.keySet()) {
            ExportCloumsModel other = new ExportCloumsModel();
            other.setTitle(titleMap.get(key));
            collect.add(other);
        }
        model.setCloums(collect);

        list = setListXXSData(num,rows,sheet);
        if (in != null) in.close();
        return list;
    }

    /**
     * 遍历excel2003
     *
     * @param file
     * @param num
     * @return
     * @throws IOException
     * @author: chenxin
     * @date: 2018年4月48日 下午9:44:13
     */
    @SuppressWarnings({"deprecation", "static-access"})
    private static List<Object> importExcel2003(ExcelObjModel model,MultipartFile file, int num) throws Exception {
        if(num <= 0){
            throw new MyException("参数定于错误");
        }
        List<Object> list = new ArrayList<>();
        POIFSFileSystem in = new POIFSFileSystem(file.getInputStream());
        HSSFWorkbook wb = new HSSFWorkbook(in);
        int sheetNumber = wb.getNumberOfSheets();
        if (sheetNumber < 0) {//没有sheets页
            if (in != null) in.close();
            throw new MyException("导入的表不是有效的文件，无文件内容");
        }
        HSSFSheet sheet = wb.getSheetAt(0);                    //sheet 从0开始
        int rowNum = sheet.getLastRowNum() + 1;                //取得最后一行的行号
        if (rowNum <= num) {
            throw new MyException("导入的表不是有效的文件或数据为空");
        }
        //读取title对应的中文，存放到columns中，注意模板title必须完整，底下跟属性有关的不能合并
        List<Object> objects = setHeadTitleList(num-1, sheet);
        if(objects.size()<=0){
            throw new MyException("标题不存在，请给模板取标题！");
        }
        Map<String,String> titleMap = (Map)objects.get(0);
        List<ExportCloumsModel> collect = new ArrayList<>();
        for (String key : titleMap.keySet()) {
            ExportCloumsModel other = new ExportCloumsModel();
            other.setTitle(titleMap.get(key));
            collect.add(other);
        }
        model.setCloums(collect);

        list = setListHSSData(num,rowNum,sheet);

        if (in != null) in.close();
        return list;
    }
    private static List<Object> setHeadTitleList(int num, Sheet sheet){
        Map<String,String> varpd = new LinkedHashMap<>(); //i -> value
        Integer columnIndex = 0;
        while (num >= 0){ //压缩
            columnIndex = 0;
            for (Cell cell : sheet.getRow(num)) {
                //没有值就把当前的值附上，不管当前的值是不是空
                if(StringUtils.isBlank(varpd.get(columnIndex.toString()))){
                    varpd.put("var" + columnIndex.toString(),cell.toString());
                }
                columnIndex++;
            }
            num--;
        }
        List<Object> result = new ArrayList<>();
        if(varpd.size() > 0){
            result.add(varpd);
        }
        return result;
    }
    private static List<Object> setListHSSData(int start, int end, HSSFSheet sheet) throws MyException {
        if(start <= end){
            throw new MyException("赋值参数出错");
        }
        List<Object> list = new ArrayList<>();
        PageData varpd = null;
        for (int i = start; i < end; i++) {                    //行循环开始
            HSSFRow row = sheet.getRow(i);                        //行
            int blankRow = CheckHSSFRowNull(row);
            int cellNum = row.getLastCellNum();                    //每行的最后一个单元格位置
            if (blankRow >= cellNum - 1) {// 检查每行的空格数
                continue;
            }
            varpd = new PageData();
            int isemEmpty = 0;
            for (int j = 0; j < cellNum; j++) {                //列循环开始
                HSSFCell cell = row.getCell(Short.parseShort(j + ""));
                String cellValue = null;
                if (cell != null) {
                    cellValue = getColumnValue(cell);
                    if (cellValue == null) isemEmpty++;
                } else {
                    cellValue = "";
                    isemEmpty++;
                }
                varpd.put("var" + j, cellValue);
            }
            if (varpd != null && isemEmpty != cellNum) {
                list.add(varpd);
            }
        }
        return list;
    }
    private static List<Object> setListXXSData(int start, int end, XSSFSheet sheet) throws MyException {
        if(start >= end){
            throw new MyException("赋值参数出错");
        }
        List<Object> list = new ArrayList<>();
        XSSFRow row = sheet.getRow(0);
        PageData varpd = null;
        for (int i = start; i < end; i++) {
            row = sheet.getRow(i);
            int cells = row.getLastCellNum();
            int blankRow = CheckXSSFRowNull(row);
            if (blankRow >= cells - 1) {// 检查每行的空格数，如果大于2固定为空值整行
                continue;
            }
            varpd = new PageData();
            for (int j = 0; j < cells; j++) {
                XSSFCell cell = row.getCell(j);
                String cellValue = null;
                if (cell != null) {
                    cellValue = getColumnValue(cell);
                } else {
                    cellValue = "";
                }
                varpd.put("var" + j, cellValue);
            }
            if (varpd != null) {
                list.add(varpd);
            }
        }
        return list;
    }

    /**
     * 解析excel列，根据列类型转换为String
     *
     * @param cell
     * @return
     */
    private static String getColumnValue(Cell cell) {
        CellType cellType = cell.getCellTypeEnum();
        String temp = "";
        switch (cellType) {
            case _NONE:
                break;
            case STRING:
                temp = cell.getStringCellValue().trim();
                //temp = StringUtils.isEmpty(temp) ? "NULL" : temp;
                break;
            case FORMULA:
                temp = cell.getCellFormula().trim();
                break;
            case NUMERIC:
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    //temp = df.format(cell.getDateCellValue());
                    short format = cell.getCellStyle().getDataFormat();
                    //System.out.println("format:"+format+";;;;;value:"+cell.getNumericCellValue());
                    SimpleDateFormat sdf = null;
                    if (format == 14 || format == 31 || format == 57 || format == 58
                            || (176 <= format && format <= 178) || (182 <= format && format <= 196)
                            || (210 <= format && format <= 213) || (208 == format)) { // 日期
                        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    } else if (format == 20 || format == 32 || format == 183 || (200 <= format && format <= 209)) { // 时间
                        sdf = new SimpleDateFormat("HH:mm");
                    } else { // 不是日期格式
                        return String.valueOf(cell.getNumericCellValue());
                    }
                    double value = cell.getNumericCellValue();
                    Date date = DateUtil.getJavaDate(value);
                    if (date == null || "".equals(date)) {
                        return "";
                    }
                    try {
                        temp = sdf.format(date);
                    } catch (Exception e) {
                        e.printStackTrace();
                        temp = "";
                    }
                } else {
                    temp = new DecimalFormat("#.######").format(cell.getNumericCellValue()).trim();
                }
                break;
            case BOOLEAN:
                temp = String.valueOf(cell.getBooleanCellValue());
                break;
            case BLANK:
                temp = null;
                break;
            case ERROR:
                temp = "ERROR";
                break;
            default:
                temp = cell.toString().trim();
                break;
        }
        return temp;
    }

    //判断行为空
    @SuppressWarnings("deprecation")
    private static int CheckHSSFRowNull(HSSFRow hssfRow) {
        int num = 0;
        Iterator<Cell> cellItr = hssfRow.iterator();
        while (cellItr.hasNext()) {
            Cell c = cellItr.next();
            if (c.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
                num++;
            }
        }
        return num;
    }

    //判断行为空
    @SuppressWarnings("deprecation")
    private static int CheckXSSFRowNull(XSSFRow hssfRow) {
        int num = 0;
        Iterator<Cell> cellItr = hssfRow.iterator();
        while (cellItr.hasNext()) {
            Cell c = cellItr.next();
            if (c.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
                num++;
            }
        }
        return num;
    }

    public static ExcelObjModel getExcelObjModel(List<String> titleList, List resultList) {
        ExcelObjModel model = new ExcelObjModel();
        model.setCode(0); // 0没添加1添加成功，否则有添加不成功的
        List<ExportCloumsModel> cloums = new ArrayList<>();
        titleList.add("导入描述");
        if (resultList.size() > 0) {
            Map<String,String> valueMap = (Map)resultList.get(0);
            int i=0;
            for (String keyField : valueMap.keySet()) {
                cloums.add(new ExportCloumsModel(titleList.get(i), keyField));
                i++;
            }
        }
        model.setList(resultList);
        model.setCloums(cloums);
        return model;
    }

    public static void main(String[] args) throws Exception {

    }

}
