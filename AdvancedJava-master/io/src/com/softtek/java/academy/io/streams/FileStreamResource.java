package com.softtek.java.academy.io.streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileStreamResource {

    public void copy(String source, String target) {

        File sourceFile = new File(source);
        File targetFile = new File(target);

        try {

            InputStream fileInputStream = new FileInputStream(sourceFile);
            OutputStream fileOutputStream = new FileOutputStream(targetFile);

            while (true) {

                int i = fileInputStream.read();

                if (i == -1) {
                    break;
                }

                fileOutputStream.write(i);
            }

            fileInputStream.close();
            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
