package AmazonOA;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TransactionLogsTest {

    @Test
    public void getFraudIds() {
        TransactionLogs test = new TransactionLogs();
        List<String> result  = test.getFraudIds( new String[] { "345366 89921 45", "029323 38239 23", "38239 345366 15", "029323 38239 77",
                "345366 38239 23", "029323 345366 13", "38239 38239 23" },3);
    }
}