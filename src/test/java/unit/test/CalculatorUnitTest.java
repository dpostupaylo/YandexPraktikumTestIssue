package unit.test;

import com.postupaylo.yandex.praktikum.exceptions.NondeliverableException;
import com.postupaylo.yandex.praktikum.properties.DeliveryDepartmentLoad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class CalculatorUnitTest extends TestBase{

    @Test
    @DisplayName("Throw exception on Nondeliverable cargo")
    public void shouldThrowNondeliverableException() {
        float distance = 31.0f;
        Assertions.assertThrows(NondeliverableException.class, () -> calculator.calculatePriceOfDelivery(
                distance,
                false,
                true,
                DeliveryDepartmentLoad.Highload.getRatio()
        ));
    }

    @ParameterizedTest
    @MethodSource("provideSetsForCalculatorDeliveryTest")
    public void shouldReturnCorrectPrice(float distance, boolean isBig, boolean fragile, double departmentLoad, float expectedPrice) throws NondeliverableException{
        Assertions.assertEquals(expectedPrice, calculator.calculatePriceOfDelivery(distance, isBig, fragile, departmentLoad));
    }

    public static Stream<Arguments> provideSetsForCalculatorDeliveryTest() {
        return
                Stream.of(
                        Arguments.of(2.0f, true, false, DeliveryDepartmentLoad.Normalload.getRatio(), 770.0f)
                        ,Arguments.of(10.0f, false, true, DeliveryDepartmentLoad.Normalload.getRatio(), 1100.0f)
                        ,Arguments.of(30.0f, false, false, DeliveryDepartmentLoad.Highload.getRatio(),  1120.0f)
                        ,Arguments.of(15.0f, true, false, DeliveryDepartmentLoad.Middleload.getRatio(), 960.0f)
                        ,Arguments.of(22.0f, true, false, DeliveryDepartmentLoad.Overload.getRatio(), 1280.0f)
                        ,Arguments.of(22.0f, false, false, DeliveryDepartmentLoad.Normalload.getRatio(), 770.0f)
                        ,Arguments.of(22.0f, true, true, DeliveryDepartmentLoad.Overload.getRatio(), 1760.0f)
                        ,Arguments.of(22.0f, false, true, DeliveryDepartmentLoad.Normalload.getRatio(), 1100.0f)
                );
    }
}
