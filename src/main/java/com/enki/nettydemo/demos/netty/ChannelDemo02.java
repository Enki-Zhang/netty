package com.enki.nettydemo.demos.netty;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @author Enki
 * @Version 1.0
 */
public class ChannelDemo02 {
    public static void main(String[] args) {
        String FROM = "D:\\object.txt";
        String TO = "D:\\to.txt";
        long start = System.nanoTime();
        try (FileChannel from = new FileInputStream(FROM).getChannel();
             FileChannel to = new FileOutputStream(TO).getChannel();
        ) {
            from.transferTo(1, from.size(), to);
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        System.out.println("transferTo 用时：" + (end - start) / 1000_000.0);
    }
}
