package test;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.softtek.java.academy.io.character.FileCharacterResource;

public class FileCharacterResourceTest {

	@Before
	public void setup() {

		String basePath = System.getProperty("user.dir");
		StringBuilder targetPath = new StringBuilder();
		targetPath.append(basePath);
		targetPath.append("/copy/object.txt");

		File file = new File(targetPath.toString());

		if (file.exists()) {
			file.delete();
		}
	}

	@Test
	public void shouldCopyFileByCharacterStream() {

		String basePath = System.getProperty("user.dir");
		StringBuilder sourcePath = new StringBuilder();
		sourcePath.append(basePath);
		sourcePath.append("/work/object.txt");

		StringBuilder targetPath = new StringBuilder();
		targetPath.append(basePath);
		targetPath.append("/copy/object-COPY.txt");

		FileCharacterResource fileCharacterResource =
				new FileCharacterResource();

		fileCharacterResource.copy(sourcePath.toString(),
				targetPath.toString());

		File file = new File(targetPath.toString());

		assertTrue(file.exists());

	}

}
