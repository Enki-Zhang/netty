package com.enki.nettydemo.demos.netty;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Enki
 * @Version 1.0
 */
public class ByteBufferDemo01 {
    public static void main(String[] args) {
        String s = "ddd";
        try (RandomAccessFile file = new RandomAccessFile("D:\\object.txt", "rw")) {
            FileChannel channel = file.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(10);
            while (true) {
                int read = channel.read(buffer);
                if (read == -1) {
                    break;
                }
                buffer.flip();
                while (buffer.hasRemaining()) {
                    System.out.println((char) buffer.get());
                }
                buffer.clear();
            }



        } catch (IOException e) {
        }

    }
}
