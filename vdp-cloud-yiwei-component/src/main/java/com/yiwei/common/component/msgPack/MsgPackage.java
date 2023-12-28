package com.yiwei.common.component.msgPack;

import java.io.Serializable;

/**   
 * @ClassName:  MsgPackage   
 * @Description:通信消息定义，作为底层RPC通信的协议使用。   
 * @author: guozhen 
 * @date:   2017年10月23日 下午8:17:48   
 *     
 */
public class MsgPackage  implements Serializable{
	protected int msgType_;//消息类型 根据次类型调用不同的处理器处理
	protected int msgLength_;//业务消息字节组数量
	protected long msgSN;//业务消息序列号
	protected byte[] msgData_;//业务数据字节组
	
	protected byte[] packData_;//通信消息数据字节组
	private String clnId_;
	boolean isChange = true;

	public MsgPackage() {

	}

	public MsgPackage(int msgtype, long msgsn, byte[] data) {
		this.msgType_ = msgtype;
		this.msgData_ = data;
		this.msgSN = msgsn;
		this.msgLength_ = data == null ? 0 : data.length;
	}

	public int getMsgType() {
		return msgType_;
	}

	public void setMsgType(int msgType_) {
		this.msgType_ = msgType_;
		isChange = true;
	}

	public int getMsgLength() {
		return msgLength_;
	}

	public byte[] getMsgData() {
		return msgData_;
	}

	public void setMsgData(byte[] msgBuff_) {
		this.msgData_ = msgBuff_;
		this.msgLength_ = msgBuff_.length;
		isChange = true;
	}

	public void setMsgData(String msg) {
		this.msgData_ = msg.getBytes();
		this.msgLength_ = this.msgData_.length;
		isChange = true;
	}

	public Long getMsgSN() {
		return msgSN;
	}

	public void setMsgSN(long msgSN) {
		this.msgSN = msgSN;
		isChange = true;
	}

	public byte[] getPackData() {
		if (packData_ == null || isChange) {

			packData_ = MsgPacker.pack(msgType_, msgSN, msgData_);
			isChange = false;
		}
		return packData_;
	}

	public byte[] getUnpackData() {
		return msgData_;
	}

	public static byte[] getUnpackData(byte[] msgData) {
		byte[] protodata = new byte[msgData.length - 16];
		System.arraycopy(msgData, 16, protodata, 0, protodata.length);
		return protodata;
	}

	public String getClnId_() {
		return clnId_;
	}

	public void setClnId_(String clnId_) {
		this.clnId_ = clnId_;
	}
	/**   
	 * <p>Title: clone</p>   
	 * <p>克隆消息对象</p>   
	 * @return   
	 * @see Object#clone()
	 */
	public MsgPackage clone(){
		MsgPackage msg=new MsgPackage();
		msg.setClnId_(this.getClnId_());
		msg.setMsgData(this.getMsgData());
		msg.setMsgSN(this.getMsgSN());
		msg.setMsgType(this.getMsgType());
		return msg;
	}
}
