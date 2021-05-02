package AmazonOA;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReorderDataLogFilesTest {

    @Test
    public void reorderLogFiles() {
        ReorderDataLogFiles test  = new ReorderDataLogFiles();
        test.reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"});
    }
}