package hexlet.code;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    private static final String JSON_FILE_1 = "src/test/resources/fixtures/Json's/TestFile1.json";
    private static final String JSON_FILE_2 = "src/test/resources/fixtures/Json's/TestFile2.json";

    private static final String YAML_FILE_1 = "src/test/resources/fixtures/Yaml's/TestFile1.yml";
    private static final String YAML_FILE_2 = "src/test/resources/fixtures/Yaml's/TestFile2.yml";

    private static final String NESTED_JSON_FILE_1 = "src/test/resources/fixtures/Json's/NestedTestFile1.json";
    private static final String NESTED_JSON_FILE_2 = "src/test/resources/fixtures/Json's/NestedTestFile2.json";

    private static final String NESTED_YAML_FILE_1 = "src/test/resources/fixtures/Yaml's/NestedTestFile1.yml";
    private static final String NESTED_YAML_FILE_2 = "src/test/resources/fixtures/Yaml's/NestedTestFile2.yml";


    private static final String RESULT_NOT_NESTED_FILE = "src/test/resources/fixtures/ResultTest.txt";
    private static final String RESULT_NESTED_FILE = "src/test/resources/fixtures/ResultForNestedFiles.txt";
    private static final String RESULT_NESTED_FILE_PLAIN = "src/test/resources/fixtures/ResultForPlainFormat";
    private static final String RESULT_NESTED_FILE_JSON = "src/test/resources/fixtures/ResultForJsonFormat.json";


    public static String readFileAsString(String path) {
        try {
            return Files.readString(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @ParameterizedTest
    @MethodSource("provideTestArguments")
    public void testDiffer(String outputFormat, String firstFilePath, String secondFilePath,
                           String expectedResultPath) throws IOException {
        String actual = Differ.generate(firstFilePath, secondFilePath, outputFormat);
        String expected = readFileAsString(expectedResultPath);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideTestArguments() {
        return Stream.of(
                Arguments.of("stylish", JSON_FILE_1,
                        JSON_FILE_2, RESULT_NOT_NESTED_FILE),
                Arguments.of("stylish", YAML_FILE_1,
                        YAML_FILE_2, RESULT_NOT_NESTED_FILE),

                Arguments.of("stylish", NESTED_JSON_FILE_1,
                        NESTED_JSON_FILE_2, RESULT_NESTED_FILE),
                Arguments.of("stylish", NESTED_YAML_FILE_1,
                        NESTED_YAML_FILE_2, RESULT_NESTED_FILE),

                Arguments.of("plain", NESTED_JSON_FILE_1,
                        NESTED_JSON_FILE_2, RESULT_NESTED_FILE_PLAIN),
                Arguments.of("plain", NESTED_YAML_FILE_1,
                        NESTED_YAML_FILE_2, RESULT_NESTED_FILE_PLAIN),

                Arguments.of("json", NESTED_JSON_FILE_1,
                        NESTED_JSON_FILE_2, RESULT_NESTED_FILE_JSON),
                Arguments.of("json", NESTED_YAML_FILE_1,
                        NESTED_YAML_FILE_2, RESULT_NESTED_FILE_JSON)
        );

    }
}
