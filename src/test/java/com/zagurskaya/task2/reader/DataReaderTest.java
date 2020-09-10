package com.zagurskaya.task2.reader;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataReaderTest extends Assert {
    private DataReader dataReader;
    private String fileName;

    @BeforeTest
    public void setUp() {
        dataReader = new DataReader();
    }

    @Test
    public void readTextToRowListTest() {
        fileName = "data/dataTest.txt";
        String expected = "It has  6+9*(3-4) unchanged. It was (5- --j + 4)-3, and more recently!\n\tIt is a layout. The point of using (71-(2*i--*(3*(2-1/2*2)-2)-10/2))*++i.\nIt its layout.";
        String actual = dataReader.readText(fileName);
        assertEquals(actual, expected);
    }
}
