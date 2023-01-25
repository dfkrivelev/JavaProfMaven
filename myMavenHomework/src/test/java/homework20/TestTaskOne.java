package homework20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestTaskOne {
    private Homework20 hm;

    @BeforeEach
    public void init() {
        hm = new Homework20();
    }

    @ParameterizedTest
    @MethodSource("dataForTest")
    public void testNewArray(int[] array, int[] result) {
        Assertions.assertArrayEquals(result, hm.newArray(array));
    }

    @Test
    public void testArray() {
        Assertions.assertThrows(RuntimeException.class, () ->
                hm.newArray(new int[]{1, 5, 2, 3}));
    }

    public static Stream<Arguments> dataForTest() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1, 7}));
        out.add(Arguments.arguments(null, null));
        return out.stream();
    }
}
