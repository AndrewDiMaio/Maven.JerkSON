package io.zipcoder;

import io.zipcoder.utils.FileReader;
import org.junit.Test;

import static org.junit.Assert.*;

public class GroceryReporterTest {

    @Test
    public void groceryListArray() {
        String fileName = "RawInput.JerkSON";
        String expected = FileReader.readFile("ExpectedOutput.txt");
        GroceryReporter reporter = new GroceryReporter(fileName);
        System.out.println(reporter.groceryListArray(null));
    }
}