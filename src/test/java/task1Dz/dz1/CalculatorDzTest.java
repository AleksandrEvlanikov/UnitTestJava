package task1Dz.dz1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CalculatorDzTest {
    public CalculatorDzTest() {
    }
    private Calculator calculator;
    @BeforeEach
    public void setup() {
        calculator = new Calculator();
// Инициализация ресурсов
    }

    @AfterEach
    public void teardown() {
        calculator = null;
// Очистка ресурсов
    }

    @Test
    @DisplayName("Проверка правильности вычисления суммы с учетом скидки")
    public void testValidDiscountCalculation() {
        int sumShop = 1000;
        int discountSum = 20;

        int resultSum = Calculator.calculateDiscount(sumShop, discountSum);


        assertThat(resultSum).isEqualTo(800);
    }

    @Test
    @DisplayName("Проверка при нулевой скидки")
    void testZeroDiscount() {
        int sumShop = 1000;
        int discountSum = 0;

        int resultSum = Calculator.calculateDiscount(sumShop, discountSum);

        assertThat(resultSum).isEqualTo(1000);
    }

    @Test
    @DisplayName("Проверка выбрасование исключения при неправильной скидке.")
    void testInvalidDiscount() {
        int sumShop = 1000;
        int discountSum = 110;

        assertThatThrownBy(() -> Calculator.calculateDiscount(sumShop, discountSum))
                .isInstanceOf(ArithmeticException.class);


    }



}
