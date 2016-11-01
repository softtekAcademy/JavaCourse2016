package com.softtek.java.academy.io.buffered;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileBufferedStreamResource {

    public void copy(String source, String target) {

        File sourceFile = new File(source);
        File targetFile = new File(target);

        try {

            InputStream fileBufferedInputStream =
                new BufferedInputStream(new FileInputStream(sourceFile), 2048);
            
            OutputStream fileBufferedOutputStream =
                new BufferedOutputStream(new FileOutputStream(targetFile), 2048);

            while (true) {

                int i = fileBufferedInputStream.read();

                if (i == -1) {
                    break;
                }

                fileBufferedOutputStream.write(i);
            }

            fileBufferedOutputStream.flush();
            fileBufferedInputStream.close();
            fileBufferedOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
