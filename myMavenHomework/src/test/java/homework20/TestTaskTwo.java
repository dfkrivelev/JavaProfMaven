package homework20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestTaskTwo {

    private TaskTwo task;

    @BeforeEach
    public void init() {
        task = new TaskTwo();
    }

    @ParameterizedTest
    @MethodSource("dataForTest")
    public void testTaskTwo(int[] array, boolean result) {
        Assertions.assertTrue(task.fourAndOne(result, array));
    }

    public static Stream<Arguments> dataForTest() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 1, 1, 4, 4, 1, 4, 4}, true));
        out.add(Arguments.arguments(new int[]{1, 1, 1, 1, 1, 1}, false));
        out.add(Arguments.arguments(new int[]{4, 4, 4, 4}, false));
        out.add(Arguments.arguments(new int[]{1, 4, 4, 1, 1, 4, 3}, false));
        return out.stream();
    }
}
