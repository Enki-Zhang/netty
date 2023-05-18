package com.enki.nettydemo.demos.netty;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Enki
 * @Version 1.0
 */
@Slf4j
public class ChannelDemo1 {
    public static void main(String[] args) {

//        twr会自动释放资源
        try (RandomAccessFile rw = new RandomAccessFile("D:\\object.txt", "rw")) {
//            数据读写通道
            FileChannel channel = rw.getChannel();
//            缓冲区 初始化缓冲区大小
            ByteBuffer buffer = ByteBuffer.allocate(10);
            while (true) {
//            从channel中读取 向buffer中写入
                int read = channel.read(buffer);
                buffer.put((byte) 172);
                if (read == -1) {
                    break;
                }
//                切换为读模式
                buffer.flip();
                while (buffer.hasRemaining()) {
                    System.out.println((char) channel.write(buffer));
                }
            }
            buffer.clear();//调用 clear() 或 compact() 切换至写模式
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
