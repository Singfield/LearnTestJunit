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

   

    @Test
    void testBadNameCurrency() {
        try {
            assertThrows(Exception.class, () -> {
                Money mtest=new Money(10,"ABC");
            });
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    @Test
    void testBadInitialisationWithBadObj() {
        try {
           Money mtest=new Money(10, "USD");
           String verify="{" +
           " fAmount='" + mtest.getFAmount() + "'" +
           ", fCurrency='" + mtest.getFCurrency() + "'" +
           "}";
           assertEquals(mtest.toString(),verify);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }


    @Test
    void testGettingFinalNegativeTotalAmount() {
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
    void testaddbadObjectWithbadCurrencyValue() {
        try {
            Money mBase=new Money(10,"USD");
            Money mtest=new Money(10,"EUR");
            assertThrows(Exception.class, () -> {
               mBase.add(mtest);
            });
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    void testaddbadObjectWithbadAmountValue() {
        try {
            Money mBase=new Money(10,"EUR");
            Money mtest=new Money(-10,"EUR");
            assertThrows(Exception.class, () -> {
               mBase.add(mtest);
            });
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    @Test
    void testaddbadCurrencyValue(){
        try {
            Money mBase=new Money(10,"EUR");

            assertThrows(Exception.class, () -> {
               mBase.add(-5,"USD");
            });
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
