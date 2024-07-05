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

    private static String pathToFirstYAMLFixture;
    private static String pathToSecondYAMLFixture;

    private static String pathToFirstNestedJsonFixture;
    private static String pathToSecondNestedJsonFixture;

    private static String pathToFirstNestedYAMLFixture;
    private static String pathToSecondNestedYAMLFixture;


    private static String pathToResultTextFixture;
    private static String pathToResultTextForNestedFixtures;
    private static String pathToResultTextForPlainFormat;
    private static String patToResultForJsonFormat;

    @BeforeAll
    public static void setupTestResultFiles() {
        pathToFirstJsonFixture = "src/test/resources/fixtures/Json's/TestFile1.json";
        pathToSecondJsonFixture = "src/test/resources/fixtures/Json's/TestFile2.json";

        pathToFirstYAMLFixture = "src/test/resources/fixtures/Yaml's/TestFile1.yml";
        pathToSecondYAMLFixture = "src/test/resources/fixtures/Yaml's/TestFile2.yml";

        pathToFirstNestedJsonFixture = "src/test/resources/fixtures/Json's/NestedTestFile1.json";
        pathToSecondNestedJsonFixture = "src/test/resources/fixtures/Json's/NestedTestFile2.json";

        pathToFirstNestedYAMLFixture = "src/test/resources/fixtures/Yaml's/NestedTestFile1.yml";
        pathToSecondNestedYAMLFixture = "src/test/resources/fixtures/Yaml's/NestedTestFile2.yml";



        pathToResultTextFixture = "src/test/resources/fixtures/ResultTest.txt";
        pathToResultTextForNestedFixtures = "src/test/resources/fixtures/ResultForNestedFiles.txt";
        pathToResultTextForPlainFormat = "src/test/resources/fixtures/ResultForPlainFormat";
        patToResultForJsonFormat = "src/test/resources/fixtures/ResultForJsonFormat.json";

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
        String actual = Differ.generate(pathToFirstJsonFixture, pathToSecondJsonFixture, "default");
        String expected = readFileAsString(pathToResultTextFixture);
        assertEquals(expected, actual);
    }

    @Test
    public void testDefaultFunctionalityYaml() throws IOException {
        String actual = Differ.generate(pathToFirstYAMLFixture, pathToSecondYAMLFixture, "default");
        String expected = readFileAsString(pathToResultTextFixture);
        assertEquals(expected, actual);
    }
    @Test
    public void testNestedFunctionalityJson() throws IOException {
        String actual = Differ.generate(pathToFirstNestedJsonFixture, pathToSecondNestedJsonFixture, "stylish");
        String expected = readFileAsString(pathToResultTextForNestedFixtures);
        assertEquals(expected, actual);
    }
    @Test
    public void testNestedFunctionalityYAML() throws IOException {
        String actual = Differ.generate(pathToFirstNestedYAMLFixture, pathToSecondNestedYAMLFixture, "stylish");
        String expected = readFileAsString(pathToResultTextForNestedFixtures);
        assertEquals(expected, actual);
    }
    @Test
    public void testPlainFunctionality() throws IOException {
        String actual = Differ.generate(pathToFirstNestedJsonFixture, pathToSecondNestedJsonFixture, "plain");
        String expected = readFileAsString(pathToResultTextForPlainFormat);
        assertEquals(expected, actual);
    }
    @Test
    public void testJsonFunctionality() throws IOException {
        String actual = Differ.generate(pathToFirstNestedJsonFixture, pathToSecondNestedJsonFixture, "json");
        String expected = readFileAsString(patToResultForJsonFormat);
        assertEquals(expected, actual);
    }

}
