package telran;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalcTest {
    private Calculator calc;

    @BeforeEach
    public void init(){
        calc = new Calculator();
    }

    @Test
    public void testAdd() {
        Assertions.assertEquals(4, calc.add(2, 2));
    }

    @Test
    public void testSub(){
        Assertions.assertEquals(0, calc.sub(2, 2));
    }
}
