import org.example.exception.DiscountPercentException;
import org.example.model.*;
import org.example.service.CheckoutService;
import org.example.util.CalendarUtil;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class RentalAppTest {

    private static CheckoutService checkoutService;

    @BeforeAll
    public static void setUp() {
        checkoutService = new CheckoutService();
    }

    @Test
    public void Test_1() {
        Calendar calendar = new GregorianCalendar(2015, Calendar.SEPTEMBER, 15);
        Exception exception = assertThrows(DiscountPercentException.class, () -> {
            checkoutService.checkout(ToolCode.JAKR, 5, 101, calendar.getTime());
        });
        System.out.println(exception.getMessage());
        assertTrue(exception.getClass() == DiscountPercentException.class);
    }

    @Test
    public void Test_2() throws Exception {
        Calendar checkoutDate = new GregorianCalendar(2020, Calendar.JULY, 2);
        RentalAgreement rentalAgreement = checkoutService.checkout(ToolCode.LADW, 3, 10,
                checkoutDate.getTime());
        rentalAgreement.print();
        int expectedChargeDays = 2;
        assertTrue(rentalAgreement.getChargeDays() == expectedChargeDays);
    }

    @Test
    public void Test_3() throws Exception {
        Calendar checkoutDate = new GregorianCalendar(2015, Calendar.JULY, 2);
        RentalAgreement rentalAgreement = checkoutService.checkout(ToolCode.CHNS, 5, 25,
                checkoutDate.getTime());
        rentalAgreement.print();
        int expectedChargeDays = 3;
        assertTrue(rentalAgreement.getChargeDays() == expectedChargeDays);
    }

    @Test
    public void Test_4() throws Exception {
        Calendar checkoutDate = new GregorianCalendar(2015, Calendar.SEPTEMBER, 3);
        RentalAgreement rentalAgreement = checkoutService.checkout(ToolCode.JAKD, 6, 0,
                checkoutDate.getTime());
        rentalAgreement.print();
        int expectedChargeDays = 3;
        assertTrue(rentalAgreement.getChargeDays() == expectedChargeDays);
    }

    @Test
    public void Test_5() throws Exception {
        Calendar checkoutDate = new GregorianCalendar(2015, Calendar.JULY, 2);
        RentalAgreement rentalAgreement = checkoutService.checkout(ToolCode.JAKR, 9, 0,
                checkoutDate.getTime());
        rentalAgreement.print();
        int expectedChargeDays = 5;
        assertTrue(rentalAgreement.getChargeDays() == expectedChargeDays);
    }

    @Test
    public void Test_6() throws Exception {
        Calendar checkoutDate = new GregorianCalendar(2020, Calendar.JULY, 2);
        RentalAgreement rentalAgreement = checkoutService.checkout(ToolCode.JAKR, 4, 50,
                checkoutDate.getTime());
        rentalAgreement.print();
        int expectedChargeDays = 1;
        assertTrue(rentalAgreement.getChargeDays() == expectedChargeDays);
    }
}
