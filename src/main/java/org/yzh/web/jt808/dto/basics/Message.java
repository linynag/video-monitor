package org.yzh.web.jt808.dto.basics;

import org.yzh.framework.annotation.Property;
import org.yzh.framework.annotation.Ps;
import org.yzh.framework.enums.DataType;
import org.yzh.framework.message.AbstractBody;
import org.yzh.framework.message.AbstractMessage;

/**
 * @author zhihao.ye (1527621790@qq.com)
 * @home http://gitee.com/yezhihao/jt808-server
 */
public class Message<T extends AbstractBody> extends AbstractMessage<T> {

    /** 消息类型 */
    protected int messageId;
    /** 消息体属性 */
    protected int properties;
    /** 协议版本号 */
    protected int versionNo;
    /** 手机号 */
    protected String mobileNo;
    /** 消息序列号 */
    protected Integer serialNo;
    /** 包总数 */
    protected int packageTotal;
    /** 包序号 */
    protected int packageNo;

    public Message() {
    }

    public Message(Integer messageId, String mobileNo, T body) {
        this.messageId = messageId;
        this.mobileNo = mobileNo;
        this.body = body;
    }

    public Message(Integer messageId, Integer serialNo, String mobileNo, T body) {
        this.messageId = messageId;
        this.serialNo = serialNo;
        this.mobileNo = mobileNo;
        this.body = body;
    }

    @Property(index = 0, type = DataType.WORD, desc = "消息ID", version = {0, 1})
    @Override
    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    @Property(index = 2, type = DataType.WORD, desc = "消息体属性", version = {0, 1})
    public Integer getProperties() {
        return properties;
    }

    public void setProperties(Integer properties) {
        this.properties = properties;
    }

    @Property(index = 4, type = DataType.BYTE, desc = "协议版本号", version = 1)
    @Override
    public int getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(int versionNo) {
        this.versionNo = versionNo;
    }

    @Ps({@Property(index = 4, type = DataType.BCD8421, length = 6, desc = "终端手机号", version = 0),
            @Property(index = 5, type = DataType.BCD8421, length = 10, desc = "终端手机号", version = 1)})
    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Ps({@Property(index = 10, type = DataType.WORD, desc = "流水号", version = 0),
            @Property(index = 15, type = DataType.WORD, desc = "流水号", version = 1)})
    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    @Ps({@Property(index = 12, type = DataType.WORD, desc = "消息包总数", version = 0),
            @Property(index = 17, type = DataType.WORD, desc = "消息包总数", version = 1)})
    @Override
    public Integer getPackageTotal() {
        if (isSubpackage())
            return packageTotal;
        return null;
    }

    public void setPackageTotal(int packageTotal) {
        this.packageTotal = packageTotal;
    }

    @Ps({@Property(index = 14, type = DataType.WORD, desc = "包序号", version = 0),
            @Property(index = 19, type = DataType.WORD, desc = "包序号", version = 1)})
    @Override
    public Integer getPackageNo() {
        if (isSubpackage())
            return packageNo;
        return null;
    }

    public void setPackageNo(int packageNo) {
        this.packageNo = packageNo;
    }

    /** 消息头长度 */
    @Override
    public int getHeadLength() {
        if (isVersion())
            return isSubpackage() ? 21 : 17;
        return isSubpackage() ? 16 : 12;
    }

    private static final int BODY_LENGTH = 0b0000_0011_1111_1111;
    private static final int ENCRYPTION  = 0b00011_100_0000_0000;
    private static final int SUBPACKAGE  = 0b0010_0000_0000_0000;
    private static final int VERSION     = 0b0100_0000_0000_0000;
    private static final int RESERVED    = 0b1000_0000_0000_0000;

    /** 消息体长度 */
    @Override
    public int getBodyLength() {
        return this.properties & BODY_LENGTH;
    }

    public void setBodyLength(int bodyLength) {
        this.properties ^= (properties & BODY_LENGTH);
        this.properties |= bodyLength;
    }

    /** 加密方式 */
    @Override
    public int getEncryption() {
        return (properties & ENCRYPTION) >> 10;
    }

    public void setEncryption(int encryption) {
        this.properties ^= (properties & ENCRYPTION);
        this.properties |= (encryption << 10);
    }

    /** 是否分包 */
    @Override
    public boolean isSubpackage() {
        return (properties & SUBPACKAGE) == SUBPACKAGE;
    }

    public void setSubpackage(boolean subpackage) {
        if (subpackage)
            this.properties |= SUBPACKAGE;
        else
            this.properties ^= (properties & SUBPACKAGE);
    }

    /** 是否有版本 */
    @Override
    public boolean isVersion() {
        return (properties & VERSION) == VERSION;
    }

    public void setVersion(boolean version) {
        if (version)
            this.properties |= VERSION;
        else
            this.properties ^= (properties & VERSION);
    }

    /** 保留位 */
    public boolean isReserved() {
        return (properties & RESERVED) == RESERVED;
    }

    public void setReserved(boolean reserved) {
        if (reserved)
            this.properties |= RESERVED;
        else
            this.properties ^= (properties & RESERVED);
    }

    @Override
    public String getClientId() {
        return mobileNo;
    }
}