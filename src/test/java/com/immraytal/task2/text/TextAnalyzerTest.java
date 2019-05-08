package com.immraytal.task2.text;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextAnalyzerTest {
    Path path = Paths.get("\\Users\\Surv\\Desktop\\task2\\src\\main\\resources\\text.txt");
    String text = "Hello world! \nHey \n";
    TextParser textParser;

    @Before
    public void InitTest() {

        textParser= new TextAnalyzer(path);
        System.out.println(textParser.getFullElement());
    }

    @Test
    public void GetFullTextTest() {
        TextParser tx = new TextAnalyzer(text);
            Assert.assertEquals(tx.getFullElement(),text);
    }

    @Test
    public void GetUniqueWord() {
       Assert.assertEquals(((TextAnalyzer) textParser).getUniqueWord(), "First");
    }
}
