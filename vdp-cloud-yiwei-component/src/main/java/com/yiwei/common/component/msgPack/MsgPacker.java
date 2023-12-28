package com.yiwei.common.component.msgPack;

import com.yiwei.common.component.bytebuffPool.FixedByteBufPool;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


/**   
 * @ClassName:  MsgPacker   
 * @Description:通信消息拆分包工具类   
 * @author: guozhen 
 * @date:   2017年10月23日 下午8:20:46   
 *     
 */
@Slf4j
public class MsgPacker {
	ByteBuf msgbuf_;

	public MsgPacker() {
		msgbuf_ = Unpooled.buffer(1024 * 10);
	}

	/**   拆包
	 * @param data
	 * @return      
	 */ 
	public List<MsgPackage> unpack(byte[] data) {
		// logger.logDebug("PARSE DATA:" + data.length);
		List<MsgPackage> ret = new ArrayList<MsgPackage>();
		msgbuf_.writeBytes(data);
		// logger.logDebug("PARSE DATA: READ ONE MSG");

		while (true) {
			int readeridx = msgbuf_.readerIndex();
			MsgPackage obj = readOnePck();
			// logger.logDebug("PARSE DATA: READ ONE MSG DONE");
			if (null != obj) {
				ret.add(obj);
			} else {
				msgbuf_.readerIndex(readeridx);
				break;
			}
		}
		msgbuf_.discardReadBytes();
		return ret;

	}

	/**   读取一个通信包
	 * @return      
	 */ 
	public MsgPackage readOnePck() {
		if (msgbuf_.readableBytes() < 16) {
			return null;
		}
		int msglength = msgbuf_.readInt();
		int msgtype = msgbuf_.readInt();
		long msgsn = msgbuf_.readLong();

		if (msgbuf_.readableBytes() < (msglength)) {
			// msgbuf_.readerIndex(msgbuf_.readerIndex() - 12);
			return null;
		}
		byte[] msg = new byte[msglength];
		// msgbuf_.readerIndex(msgbuf_.readerIndex() - 16);
		msgbuf_.readBytes(msg);
		// msgbuf.readerIndex(msgbuf.readerIndex() + msg.length);

		return new MsgPackage(msgtype, msgsn, msg);
	}

	public static MsgPackage unpackone(byte[] data) {
		ByteBuf msgbuf = FixedByteBufPool.getInstance().borrowObject(
				data.length);
		try {
			msgbuf.writeBytes(data);
			if (msgbuf.readableBytes() < 16) {
				return null;
			}
			int msglength = msgbuf.readInt();
			int msgtype = msgbuf.readInt();
			long msgsn = msgbuf.readLong();

			if (msgbuf.readableBytes() < (msglength)) {
				msgbuf.readerIndex(msgbuf.readerIndex() - 16);
				return null;
			}
			byte[] msg = null;
			if (msglength != 0) {
				msg = new byte[msglength];
				// msgbuf.readerIndex(msgbuf.readerIndex() - 16);
				msgbuf.readBytes(msg);
			}
			return new MsgPackage(msgtype, msgsn, msg);
		} catch (Exception e) {
			log.error(e.getMessage().toString(),e);
			return null;
		} finally {
			FixedByteBufPool.getInstance().returnObject(data.length, msgbuf);
		}

	}

	public static byte[] pack(int msgType, long msgSn, byte[] data) {
		int msglength = 0;
		if (data != null) {
			msglength = (data.length);
		}

		byte[] newbyte = new byte[msglength + 16];

		newbyte[0] = (byte) ((msglength >> 24) & 0xff);
		newbyte[1] = (byte) ((msglength >> 16) & 0xff);
		newbyte[2] = (byte) ((msglength >> 8) & 0xff);
		newbyte[3] = (byte) (msglength & 0xff);

		newbyte[4] = (byte) ((msgType >> 24) & 0xff);
		newbyte[5] = (byte) ((msgType >> 16) & 0xff);
		newbyte[6] = (byte) ((msgType >> 8) & 0xff);
		newbyte[7] = (byte) (msgType & 0xff);

		newbyte[8] = (byte) ((msgSn >> 56) & 0xff);
		newbyte[9] = (byte) ((msgSn >> 48) & 0xff);
		newbyte[10] = (byte) ((msgSn >> 40) & 0xff);
		newbyte[11] = (byte) (msgSn >> 32 & 0xff);

		newbyte[12] = (byte) ((msgSn >> 24) & 0xff);
		newbyte[13] = (byte) ((msgSn >> 16) & 0xff);
		newbyte[14] = (byte) ((msgSn >> 8) & 0xff);
		newbyte[15] = (byte) (msgSn & 0xff);
		if (msglength != 0) {
			System.arraycopy(data, 0, newbyte, 16, msglength);
		}
		return newbyte;
	}

	public static byte[] pack(int msgType, byte[] data) {
		return pack(msgType, 0L, data);
	}
}
