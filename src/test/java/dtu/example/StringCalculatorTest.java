package dtu.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class StringCalculatorTest {

    @Test
    public void empty_string_returns_zero() {
        StringCalculator sc = new StringCalculator();
        assertEquals(0, sc.add(""));
    }

    @Test
    public void single_number_returns_the_number() {
        StringCalculator sc = new StringCalculator();
        assertEquals(1, sc.add("1"));
    }

    @Test
    public void two_numbers_are_summed() {
        StringCalculator sc = new StringCalculator();
        assertEquals(3, sc.add("1,2"));
    }

    @Test
    public void newlines_are_treated_as_commas() {
        StringCalculator sc = new StringCalculator();
        assertEquals(6, sc.add("1\n2,3"));
    }

    @Test
    public void custom_delimiter_is_supported() {
        StringCalculator sc = new StringCalculator();
        assertEquals(3, sc.add("//;\n1;2"));
    }

    @Test
    public void negatives_throw_exception_with_message() {
        try {
            StringCalculator sc = new StringCalculator();
            sc.add("1,-2,3");
            fail("Exception was expected");
        } catch (IllegalArgumentException e) {
            assertEquals("negatives not allowed: [-2]", e.getMessage());
        }
    }




}

