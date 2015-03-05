package com.impatient.pgs;

import com.impatient.pgs.Chapter1;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

public class Chapter1Test {

    @Mock
    File mockFile;

    private Chapter1 chapter1;
    private File tempDir;
    private File testFile;
    private File testFile2;
    private File testFile3;

    @Before
    public void setUp() throws IOException {
        initMocks(this);
        chapter1 = new Chapter1();
        testFile = tempDir.createTempFile("test", ".tst");
        testFile2 = tempDir.createTempFile("test2", ".tst");
        testFile3 = tempDir.createTempFile("test3", ".tst");
        tempDir = testFile.getParentFile();
        testFile.deleteOnExit();
    }

    @After
    public void tearDown() throws IOException {
        testFile.delete();
        testFile2.delete();
        testFile3.delete();
    }

    @Test
    public void exercise1Test(){
        Integer[] unordered = {1,3,4,2,7,9,5,8,6};
        chapter1.exercise1(unordered);

        assertThat(unordered).isSortedAccordingTo(Comparator.<Integer>naturalOrder());
        Arrays.asList(unordered).forEach(System.out::print);
    }

    @Test
    public void exercise2TestAllReturnContentsForCurrentDirectory() {
        File[] old = chapter1.subDirectoryOld(tempDir);
        File[] lambda = chapter1.subDirectoryLambda(tempDir);
        File[] methRef = chapter1.subDirectoryMethRef(tempDir);

        assertThat(old).hasSameSizeAs(lambda);
        assertThat(lambda).hasSameSizeAs(methRef);
    }

    @Test
    public void exercise2TestAllReturnNullForAFileWhichIsNotADirectory() {
        File[] old = chapter1.subDirectoryOld(testFile);
        File[] lambda = chapter1.subDirectoryLambda(testFile);
        File[] methRef = chapter1.subDirectoryMethRef(testFile);

        assertThat(old).isNull();
        assertThat(lambda).isNull();
        assertThat(methRef).isNull();
    }

    @Test
    public void exercise3CurrentDirectoryReturnsFileNamesWithSetPrefix() {
        assertThat(chapter1.filterExtension(tempDir,".tst")).hasSize(3);
        assertThat(chapter1.filterExtension(tempDir,".bleh")).hasSize(0);
        assertThat(chapter1.filterExtension(testFile,".bleh")).isNull();
    }

    @Test
    public void exercise4OrderDirectoryByDirsThenFiles() throws IOException {
        chapter1.orderFiles(new File("").getAbsoluteFile());
    }
}
