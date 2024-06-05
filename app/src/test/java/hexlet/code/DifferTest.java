package hexlet.code;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    private static String pathToFirstJsonFixture;
    private static String pathToSecondJsonFixture;
    private static String pathToResultText;

    @BeforeAll
    public static void setupTestResultFiles() {
        pathToFirstJsonFixture = "src/test/resources/fixtures/TestFile1.json";
        pathToSecondJsonFixture = "src/test/resources/fixtures/TestFile2.json";
        pathToResultText = "src/test/resources/fixtures/ResultTest.txt";
    }

    public static String readFileAsString(String path) {
        try {
            return Files.readString(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }


    @Test
    public void testDefaultFunctionalityJson() throws Exception {
        String actual = Differ.generate(pathToFirstJsonFixture, pathToSecondJsonFixture);
        String expected = readFileAsString(pathToResultText);
        assertEquals(expected, actual);
    }




}
