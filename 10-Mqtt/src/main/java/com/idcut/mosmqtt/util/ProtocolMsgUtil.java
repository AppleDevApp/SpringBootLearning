package com.idcut.mosmqtt.util;

import com.idcut.mosmqtt.platform.ProtocolExtHeader;
import com.idcut.mosmqtt.platform.ProtocolHeader;
import com.idcut.mosmqtt.platform.ProtocolMsg;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.math.BigInteger;

@Slf4j
public final class ProtocolMsgUtil {

    public static byte[] messageToByte(ProtocolMsg msg) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
            //版本
            writeNumberToStream(stream, msg.getHeaderInfo().getVersion(), 1);
            byte[] headerBytes = getHeaderBytes(msg.getHeader());
            //基础线头类型,h_type=0表示没有基础线头,h_type=1表示有
            int h_type;
            //头长度,单位为byte;
            int h_length = headerBytes.length;
            //检查头,如果有数据,h_type=1,并计算h_length;否则h_type=0,h_length=0;
            if (h_length > 0) {
                h_type = 1;
                writeNumberToStream(stream, h_type, 1);
                writeNumberToStream(stream, h_length, 2);
            } else {
                h_type = 0;
                writeNumberToStream(stream, h_type, 1);
            }
            byte[] extHeaderBytes = getExtHeaderBytes(msg.getExtensionHeader());
            int ext_length = extHeaderBytes.length;
            //扩展头长度
            writeNumberToStream(stream, ext_length, 4);
            //写入基础线头数据
            if (h_length > 0) {
                stream.write(headerBytes);
            }
            //写入扩展头数据
            if (ext_length > 0) {
                stream.write(extHeaderBytes);

            }
            //写入业务数据
            if (msg.getBody() != null) {
                stream.write(msg.getBody().getBytes());
            }
        } catch (Exception ex) {
            log.error("协议编码错误:{}", ex);
        }
        return stream.toByteArray();
    }

    public static ProtocolMsg byteToMessage(byte[] b) {
        ProtocolMsg entity = new ProtocolMsg();
        ByteArrayInputStream stream = new ByteArrayInputStream(b);
        try {
            //这里会跳过读取一些暂时用不上的数据,如版本,基础线头数据等
            //跳过version和h_type
            stream.skip(2);
            int h_length = (int) readLongNumberFromStream(stream, 2);
            long ext_length = readLongNumberFromStream(stream, 4);
            if (h_length > 0) {
                //跳过基础线头数据
                stream.skip(h_length);
            }
            //扩展头数据
            if (ext_length > 0) {
                String extension = new String(readByteFromStream(stream, ext_length));
                entity.setExtensionHeader(JsonUtil.fromJson(extension, ProtocolExtHeader.class));
            }
            //业务数据
            String body = readAllFromStream(stream);
            entity.setBody(body);

        } catch (Exception e) {
            e.printStackTrace();
            entity = null;
        }
        return entity;

    }

    private static void writeNumberToStream(OutputStream stream, long num, int byteLength) throws IOException {
        writeNumberToStream(stream, num + "", byteLength);
    }

    private static void writeNumberToStream(OutputStream stream, String num, int byteLength) throws IOException {
        BigInteger bigInteger = new BigInteger(num);
        byte[] newBs = new byte[byteLength];
        byte[] oldBs = bigInteger.toByteArray();
        System.arraycopy(oldBs, 0, newBs, byteLength - oldBs.length, oldBs.length);
        stream.write(newBs, 0, newBs.length);
    }

    private static byte[] getHeaderBytes(ProtocolHeader header) throws IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        if (header != null) {
            writeNumberToStream(stream, header.getRequest_id(), 8);
            writeNumberToStream(stream, header.getTime_sec(), 8);
        }
        return stream.toByteArray();
    }

    private static byte[] getExtHeaderBytes(ProtocolExtHeader header) {
        try {
            if (header != null) {
                return JsonUtil.toJson(header).getBytes("UTF-8");
            }
        } catch (UnsupportedEncodingException e) {
            log.error("不支持的编码错误:{}", e);
        }
        return new byte[0];
    }

    private static String readAllFromStream(InputStream stream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int index = stream.read(buffer);
        if (index > 0) {
            outputStream.write(buffer, 0, index);
        }
        return new String(outputStream.toByteArray());
    }

    private static long readLongNumberFromStream(InputStream stream, int byteLength) throws IOException {
        String str = readNumberFromStream(stream, byteLength);
        return Long.parseLong(str);
    }

    private static String readNumberFromStream(InputStream stream, int byteLength) throws IOException {
        byte[] b = readByteFromStream(stream, byteLength);
        BigInteger oldBigInteger = new BigInteger(b);
        BigInteger newBigInteger = unsigned(oldBigInteger);
        return newBigInteger.toString();
    }

    private static byte[] readByteFromStream(InputStream stream, long byteLength) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        for (int bufferSize = 1024; byteLength > 0; byteLength -= byteLength) {
            if (bufferSize > byteLength) {
                bufferSize = (int) byteLength;
            }
            byte[] b = new byte[bufferSize];
            stream.read(b);
            outputStream.write(b);
        }
        return outputStream.toByteArray();
    }

    private static BigInteger unsigned(BigInteger b) {
        if (b.signum() >= 0)
            return b;
        byte[] a1 = b.toByteArray();
        byte[] a2 = new byte[a1.length + 1];
        a2[0] = 0;
        System.arraycopy(a1, 0, a2, 1, a1.length);
        return new BigInteger(a2);
    }
}
