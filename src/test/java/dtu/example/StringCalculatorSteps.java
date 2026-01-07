package dtu.example;

import dtu.example.StringCalculator;
import io.cucumber.java.en.*;
import org.junit.Before;

import static org.junit.Assert.*;


public class StringCalculatorSteps {

    private String input;
    private int result;
    private Exception exception;
    @Before
    public void setUp() {
        input = null;
        result = 0;
        exception = null;
    }

    @Given("the input is {string}")
    public void the_input_is(String input) {
        this.input = input.replace("\\n", "\n");
//        this.input = input;
    }

    @When("I add the numbers")
    public void i_add_the_numbers() {
        try {
            StringCalculator sc = new StringCalculator();
            result = sc.add(input);
        } catch (Exception e) {
            exception = e;
        }
    }

    @Then("the result should be {int}")
    public void the_result_should_be(int expected) {
        assertEquals(expected, result);
    }

    @Then("an error should be thrown")
    public void an_error_should_be_thrown() {
        assertNotNull(exception);
    }


}
