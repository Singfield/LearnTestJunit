package junitItescia;

import junitItescia.services.Money;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("MoneyTest")
public class MoneyTest {
    private String[] currency = { "EUR", "USD", "CHF", "GBP" };

    void testObjMoney() {
    }

    @Test
    void testAddNegativeObj() {
        Money mBase;
        try {
            mBase = new Money(5, "USD");
           
            assertThrows(Exception.class, ()->{
                mBase.add(-10,"USD");
            });
        } catch (Exception ex) {
            fail(ex.getMessage());
        }

    }

    @Test
    void testNameCurrency() {
        try {
                
            assertThrows(Exception.class, () -> {
                Money mtest=new Money(10,"ABC");
            }, "incorrect currency value");
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
