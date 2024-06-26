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

    private static  String pathToFirstNestedJsonFixture;
    private static  String pathToSecondNestedJsonFixture;


    private static String pathToFirstYAMLFixture;
    private static String pathToSecondYAMLFixture;

    private static String pathToResultTextFixture;
    private static String pathToResultTextForNestedFixtures;

    @BeforeAll
    public static void setupTestResultFiles() {
        pathToFirstJsonFixture = "src/test/resources/fixtures/Json's/TestFile1.json";
        pathToSecondJsonFixture = "src/test/resources/fixtures/Json's/TestFile2.json";

        pathToFirstNestedJsonFixture = "src/test/resources/fixtures/Json's/NestedTestFile1.json";
        pathToSecondNestedJsonFixture = "src/test/resources/fixtures/Json's/NestedTestFile2.json";

        pathToFirstYAMLFixture = "src/test/resources/fixtures/Yaml's/TestFile1.yaml";
        pathToSecondYAMLFixture = "src/test/resources/fixtures/Yaml's/TestFile2.yaml";

        pathToResultTextFixture = "src/test/resources/fixtures/ResultTest.txt";
        pathToResultTextForNestedFixtures = "src/test/resources/fixtures/ResultForNestedFiles.txt";

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
        String expected = readFileAsString(pathToResultTextFixture);
        assertEquals(expected, actual);
    }

    @Test
    public void testDefaultFunctionalityYaml() throws IOException {
        String actual = Differ.generate(pathToFirstYAMLFixture,pathToSecondYAMLFixture);
        String expected = readFileAsString(pathToResultTextFixture);
        assertEquals(expected,actual);
    }
    @Test
    public void testNestedFunctionalityJson() throws IOException {
        String actual = Differ.generate(pathToFirstNestedJsonFixture,pathToSecondNestedJsonFixture);
        String expected = readFileAsString(pathToResultTextForNestedFixtures);
        assertEquals(expected,actual);
    }




}
