package org.main.java8practice;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class Java8ExperimentsTest {


    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    private Java8Experiments testVariable = new Java8Experiments();

    @Test
    public void whenExceptionThrown_thenRuleIsApplied() {
        exceptionRule.expect(NumberFormatException.class);
        exceptionRule.expectMessage("For input string");
        Integer.parseInt("1a");
    }

    @Test
    public void test1Test() {
        testVariable.test();
    }

    @Test(expected = RuntimeException.class)
    public void exceptionTest() {
        testVariable.exceptionThrown();
    }

    @Test
    public void exceptionMessageTest() {
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Exception Occured while processing");
        testVariable.exceptionThrown();
    }
}