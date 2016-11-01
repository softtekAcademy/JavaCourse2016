package test;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.softtek.java.academy.io.buffered.FileBufferedStreamResource;


public class FileStreamResourceTest {
    
    @Before
    public void setup() {

        String basePath = System.getProperty("user.dir");
        StringBuilder targetPath = new StringBuilder();
        targetPath.append(basePath);
        targetPath.append("/copy/Softtek.jpg");

        File file = new File(targetPath.toString());

        if (file.exists()) {
            file.delete();
        }
    }

    
    @Test
    public void shouldCopyFileByStream() {

        String basePath = System.getProperty("user.dir");
        StringBuilder sourcePath = new StringBuilder();
        sourcePath.append(basePath);
        sourcePath.append("/work/Softtek.jpg");

        StringBuilder targetPath = new StringBuilder();
        targetPath.append(basePath);
        targetPath.append("/copy/Softtek.jpg");

        FileBufferedStreamResource fileBufferedStreamResource =
            new FileBufferedStreamResource();

        fileBufferedStreamResource.copy(sourcePath.toString(),
            targetPath.toString());

        File file = new File(targetPath.toString());

        assertTrue(file.exists());

    }

}
