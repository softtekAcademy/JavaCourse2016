package com.softtek.java.academy.io.character;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class FileCharacterResource {

    public void copy(String source, String target) {

        File sourceFile = new File(source);
        File targetFile = new File(target);

        try {

            Reader fileReader = new FileReader(sourceFile);
            Writer fileWriter = new FileWriter(targetFile);

            while (true) {

                int i = fileReader.read();

                if (i == -1) {
                    break;
                }

                fileWriter.write(i);
            }

            fileReader.close();
            fileWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
