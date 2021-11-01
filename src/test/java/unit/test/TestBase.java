package unit.test;

import com.postupaylo.yandex.praktikum.calculator.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    Calculator calculator;

    @BeforeEach
    public void setUpCalculator() {
        calculator = new Calculator();
    }

    @AfterEach
    public void clearCalculator() {
        calculator = null;
    }
}
