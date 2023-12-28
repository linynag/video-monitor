package com.yiwei.common.component.excelNew;

import com.yiwei.common.component.config.MyException;
import com.yiwei.common.component.utils.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.util.ResourceUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;

/**
 * @author JY
 * @date 2022-01-05
 */
public class ExcelExport<R> {
    /*临时文件目录*/
    private static volatile String applicationParentFilePath;
    private static final ReentrantLock reentrantLock = new ReentrantLock();
    private List<Title<R>> titles = new ArrayList<>();
    private static Workbook WORKBOOK;
    public static final String IS_USED = "xiaocai=oqoqbobo"; //蔡镜波加的，请不要质疑我好吗？！

    /* 多级表头时会用到 全局标题深度  initTitle方法会给其赋值
     *
     *   |       title               |     深度=3    rowIndex=0
     *   |   titleA    |    titleB   |     深度=2    rowIndex=1
     *   |title1|title2|title3|title4|     深度=1    rowIndex=2
     * */
    public Integer MAX_TITLE_DEPTH = null;
    /* 多级表头时会用到    深度 和 标题集合的映射关系*/
    HashMap<Integer, List<Title>> depth2Titles = new HashMap<>();

    /*唯一识别名称*/
    private String uniqueName;
    /*自定义的名称*/
    private String excelName;


    private ExcelExport() {

    }

    /**
     * 不指定导入类型
     *
     * @param excelName
     * @return
     */
    public static ExcelExport<Object> create(String excelName) {
        return ExcelExport.create(excelName, Object.class);
    }

    public static <T> ExcelExport<T> create(String excelName, Class<T> c) {
        WORKBOOK = null;
        ExcelExport<T> excelExport = new ExcelExport();
        excelExport.excelName = excelName;
        return excelExport;
    }


    public ExcelExport<R> addTitleNew(String titleName, Function<R, Object> valueFunction) {
        Title<R> title = Title.ofCai(titleName, valueFunction);
        titles.add(title);
        this.MAX_TITLE_DEPTH = (this.MAX_TITLE_DEPTH == null || this.MAX_TITLE_DEPTH < title.depth) ? title.depth : this.MAX_TITLE_DEPTH;
        return this;
    }

    private static CellStyle getHeadCellStyle(Workbook workbook){
        CellStyle style = workbook.createCellStyle();
        //设置样式对齐方式：水平垂直居中
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        //设置边框
        style.setBorderBottom(BorderStyle.THIN); //下边框
        style.setBorderLeft(BorderStyle.THIN);//左边框
        style.setBorderTop(BorderStyle.THIN);//上边框
        style.setBorderRight(BorderStyle.THIN);//右边框
        //设定填充单色
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //设定背景颜色
        style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
        Font font = workbook.createFont();
        //设置字体颜色，颜色和上述的颜色对照表是一样的
        font.setColor(IndexedColors.WHITE.getIndex());
        //将字体样式设置到单元格样式中
        style.setFont(font);
        return style;
    }
    private static void setColumnWidth(Sheet sheet, Integer index,String value){
        int num = value.length()>8?value.length():8;
        sheet.setColumnWidth(index,num*2*256);
    }

    public void sendWorkBook(HttpServletResponse response, HttpServletRequest request) throws IOException, MyException {
        if(WORKBOOK == null){
            throw new MyException("请先设置WorkBook对像");
        }
        response.reset();
        //文件名称
        String fileName = StringUtils.isNotBlank(this.excelName) ? this.excelName : "导出文件";
        fileName += ".xlsx";  //文件类型默认
        fileName = URLEncoder.encode(fileName,"UTF-8");

        response.setContentType("application/OCTET-STREAM;charset=UTF-8");
        response.setHeader("Content-disposition", "attachment;fileName=" + fileName);
        response.setHeader("Access-Control-Expose-Headers","Content-Disposition"); //让前端可以通过headers获取content-disposition的值
        response.addHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
        response.addHeader("Access-Control-Allow-Credentials", "true");
        ServletOutputStream outputStream = response.getOutputStream();
        WORKBOOK.write(outputStream);
        outputStream.close();
        outputStream.flush();
    }
    public Workbook getWorkBook(List<R> data) throws MyException {
        setWorkBook(data);
        return WORKBOOK;
    }
    public ExcelExport setWorkBook(List<R> data) throws MyException {
        Workbook workbook = new SXSSFWorkbook(100);
        CellStyle style = getHeadCellStyle(workbook);
        Sheet sheet = workbook.createSheet();
        sheet.createFreezePane(0, MAX_TITLE_DEPTH, 0, MAX_TITLE_DEPTH);//row1 row2 column1 column2
        String [][] headData = new String[MAX_TITLE_DEPTH][titles.size()];
        int columnIndex = 0,rowIndex = 0;
        String titleStr = "";
        //因为特殊的遍历关系，需要先初始化headData才能给sheet新建内容
        for (Title<R> title : titles) {
            setColumnWidth(sheet,columnIndex,title.titleName);
            rowIndex = 0;
            do {
                titleStr = title == null ? titleStr : title.titleName;
                headData[rowIndex][columnIndex] = titleStr;//反射
                title = title == null ? null : title.chileTitle;
                rowIndex++;
            }while (rowIndex < MAX_TITLE_DEPTH);
            columnIndex++;
        }
        rowIndex = 0;
        Row row = null;
        for (String[] rowData : headData) {
            row = sheet.createRow(rowIndex);
            columnIndex = 0;
            for (String value : rowData) {
                Cell cell = row.createCell(columnIndex);
                cell.setCellStyle(style);
                cell.setCellValue(value);
                columnIndex++;
            }
            rowIndex++;
        }
        //合并表头
        mergedRegion(headData,sheet);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("------------------处理表头结束："+sdf.format(new Date()));
        //处理表数据！！
        for (R dataRow : data) {
            row = sheet.createRow(rowIndex);
            columnIndex = 0;
            for (Title<R> title : titles) {
                Object apply = title.valueFunction.apply(dataRow);
                row.createCell(columnIndex).setCellValue(apply==null?"":apply.toString());
                columnIndex++;
            }
            rowIndex++;
        }
        WORKBOOK = workbook;
        return this;
    }

    private static void setHeadDataUsed(String [][] headData,int rowIndex,int start,int end){
        for(int i=start;i<=end;i++){
            headData[rowIndex][i] = IS_USED+"_"+rowIndex;
        }
    }

    /**
     * 自创的表头合并方法，虽然笨了点，但是没问题
     * @param headData
     * @param sheet
     * @throws MyException
     */
    private static void mergedRegion(String [][] headData,Sheet sheet) throws MyException {
        String firstCellValue = "";
        int firstIndex;
        int rowNum = headData.length;
        if(rowNum <= 0){
            throw new MyException("参数请初始化！！！");
        }
        int columnNum = headData[0].length;
        if(columnNum <= 0){
            throw new MyException("参数请初始化！！！");
        }
        //横向合并
        /**
         * 合并思路：
         * 从左致右，遇到
         */
        for (int rowIndex=0;rowIndex<rowNum;rowIndex++) {
            firstIndex = 0;
            firstCellValue = "";
            for (int lastIndex = 0;lastIndex < columnNum;lastIndex++) {
                String value = headData[rowIndex][lastIndex];
                if(StringUtils.isNotBlank(value)){
                    if(lastIndex == 0 && StringUtils.isBlank(firstCellValue)){
                        firstCellValue = value;
                    }
                    //多个才进行合并
                    if(lastIndex-1 > firstIndex && !value.equals(firstCellValue)){
                        //把之前的合并，不包括当前非空的对象
                        CellRangeAddress rangeAddress = new CellRangeAddress(rowIndex, rowIndex, firstIndex, lastIndex-1);
                        sheet.addMergedRegion(rangeAddress);
                        firstCellValue = value;
                        //用特定的字符串占用，避免后续纵向合并时出问题
                        setHeadDataUsed(headData,rowIndex,firstIndex,lastIndex-1);
                        firstIndex = lastIndex;
                    }else if(lastIndex-1 == firstIndex && !value.equals(firstCellValue)){
                        //不合并，但要往前挪一格
                        firstIndex = lastIndex;
                        firstCellValue = value;
                    }else if(lastIndex == columnNum-1){
                        //进入此处肯定为 value.equals(firstCellValue) == true 的情况！！！！所以要合并
                        CellRangeAddress rangeAddress = new CellRangeAddress(rowIndex, rowIndex, firstIndex, lastIndex);
                        sheet.addMergedRegion(rangeAddress);
                        //用特定的字符串占用，避免后续纵向合并时出问题
                        setHeadDataUsed(headData,rowIndex,firstIndex,lastIndex);
                    }
                }else if(lastIndex == columnNum-1){
                    //如果最后一个正好为空，需要和上一个非空的下标进行合并！！！  包括自己本身
                    CellRangeAddress rangeAddress = new CellRangeAddress(rowIndex, rowIndex, firstIndex, lastIndex);
                    sheet.addMergedRegion(rangeAddress);
                    //用特定的字符串占用，避免后续纵向合并时出问题
                    setHeadDataUsed(headData,rowIndex,firstIndex,lastIndex);
                }
            }
        }

        int lastIndex = rowNum-1;
        String lastCellValue = "";
        //纵向合并
        for (int columnIndex = 0;columnIndex < columnNum;columnIndex++) {

            lastIndex = rowNum-1;
            for (firstIndex = rowNum-1; firstIndex >= 0; firstIndex--) {
                String value = headData[firstIndex][columnIndex];
                if(firstIndex == rowNum-1){
                    lastCellValue = value;
                }
                if(CheckUtils.selfJudge(value,IS_USED+"_\\d")){
                    //不考虑本身
                    if(lastIndex > firstIndex+1){
                        CellRangeAddress rangeAddress = new CellRangeAddress(firstIndex+1, lastIndex, columnIndex, columnIndex);
                        sheet.addMergedRegion(rangeAddress);
                        Row row = sheet.getRow(firstIndex+1);
                        row.getCell(columnIndex).setCellValue(lastCellValue);
                    }
                    //再向前挪一位
                    lastIndex = firstIndex - 1;
                    if(lastIndex >= 0){
                        lastCellValue = headData[lastIndex][columnIndex]; //提前置为空，以后判断需要
                    }
                    continue;
                }
                if(StringUtils.isNotBlank(value)){
                    if(value.equals(lastCellValue)){
                        if(firstIndex == 0 && firstIndex+1 <= lastIndex){
                            CellRangeAddress rangeAddress = new CellRangeAddress(firstIndex, lastIndex, columnIndex, columnIndex);
                            sheet.addMergedRegion(rangeAddress);
                            Row row = sheet.getRow(firstIndex);
                            row.getCell(columnIndex).setCellValue(lastCellValue);
                        }
                    }else{
                        //不包括自己本身
                        if(firstIndex+1 < lastIndex){
                            CellRangeAddress rangeAddress = new CellRangeAddress(firstIndex+1, lastIndex, columnIndex, columnIndex);
                            sheet.addMergedRegion(rangeAddress);
                            Row row = sheet.getRow(firstIndex+1);
                            row.getCell(columnIndex).setCellValue(lastCellValue);
                            lastIndex = firstIndex;
                            lastCellValue = value;
                        }else{
                            lastIndex = firstIndex;
                            lastCellValue = value;
                        }
                    }

                }else if(firstIndex == 0){
                    //值为空，但是参考值不为空，结合实际进行合并
                    if(firstIndex+1 <= lastIndex){
                        CellRangeAddress rangeAddress = new CellRangeAddress(firstIndex, lastIndex, columnIndex, columnIndex);
                        Row row = sheet.getRow(firstIndex);
                        row.getCell(columnIndex).setCellValue(lastCellValue);
                        sheet.addMergedRegion(rangeAddress);
                    }
                }

            }
        }
    }

    /*获取项目路径*/
    private static String getApplicationParentFilePath() {
        if (applicationParentFilePath == null) {
            reentrantLock.lock();
            try {
                if (applicationParentFilePath == null) {
                    applicationParentFilePath = new File(ResourceUtils.getURL("classpath:").getPath()).getParentFile().getParentFile().getParent();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }
        return applicationParentFilePath;
    }

    /**
     * 标题类  是个单向链表 会指向自己的父表头
     *
     * @param <T>
     */
    public static class Title<T> {
        public Title parentTitle;
        public Title chileTitle;
        public Integer depth;
        public String titleName;
        public Function<T, Object> valueFunction;
        /* 父标题分隔符*/
        public static String PARENT_TITLE_SEPARATOR = "::";
        /* 列坐标 开始于第几列  */
        public int startColIndex;
        /* 列坐标 结束于第几列 */
        public int endColIndex;

        public Title(String titleName, Function<T, Object> valueFunction) {
            this.titleName = titleName;
            this.valueFunction = valueFunction;
        }

        private Title() {

        }

        public static <R> Title<R> ofCai(String titleName, Function<R, Object> valueFunction) {

            String[] split = titleName.split(PARENT_TITLE_SEPARATOR);
            int i = 0;

            Title<R> newTitle = nextTitle(split,valueFunction,i);

            return newTitle;
        }

        private static <R> Title<R> nextTitle(String[] split, Function<R, Object> valueFunction,int i){
            Title<R> newTitle = new Title<>();
            newTitle.titleName = split[i];
            newTitle.valueFunction = valueFunction;
            newTitle.depth = split.length;
            if(++i<split.length){
                newTitle.chileTitle = nextTitle(split,valueFunction,i);
//                newTitle.chileTitle.parentTitle = newTitle;
            }
            return newTitle;
        }

    }
}
