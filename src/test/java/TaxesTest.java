import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaxesTest {
    Taxes taxes = new Taxes();

    @Test
    public void testTaxEarningsMinusSpendings() {
        final int expected = 225;
        final int earnings = 2000;
        final int spendings = 500;
        final int result = taxes.taxEarningsMinusSpendings(earnings, spendings);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testTaxEarnings() {
        final int expected = 120;
        final int earnings = 2000;
        final int result = taxes.taxEarnings(earnings);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testText() {
        final String expected = "Ваш налог составит:" + "120" + " рублей" + "\n" +
                "Налог на другой системе:" + "225" + " рублей" + "\n" +
                "Экономия:" + "105" + " рублей";
        final int taxE = 120;
        final int taxEMS = 225;
        final String result = taxes.text(taxE, taxEMS);
        Assertions.assertEquals(expected, result);
    }
}

