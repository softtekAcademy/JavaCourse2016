package test;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.softtek.java.academy.io.buffered.FileBufferedStreamResource;

public class FileBufferedStreamResourceTest {

    @Before
    public void setup() {

        String basePath = System.getProperty("user.dir");
        StringBuilder targetPath = new StringBuilder();
        targetPath.append(basePath);
        targetPath.append("/copy/Collection.pptx");

        File file = new File(targetPath.toString());

        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void shouldCopyFileByBufferStream() {

        String basePath = System.getProperty("user.dir");
        StringBuilder sourcePath = new StringBuilder();
        sourcePath.append(basePath);
        sourcePath.append("/work/JavaAcademy-Collections.pptx");

        StringBuilder targetPath = new StringBuilder();
        targetPath.append(basePath);
        targetPath.append("/copy/Collection.pptx");

        FileBufferedStreamResource fileBufferedStreamResource =
            new FileBufferedStreamResource();

        fileBufferedStreamResource.copy(sourcePath.toString(),
            targetPath.toString());

        File file = new File(targetPath.toString());

        assertTrue(file.exists());

    }
}
