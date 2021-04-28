package com.gcit.calculator;

import androidx.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(JUnit4.class)
@SmallTest
public class ExampleUnitTest {
    private calculator mcalculator;
    @Before
    public void setUp(){
        mcalculator = new calculator();
    }
    @Test
    public void addTwoNumber() {
       double result = mcalculator.add(1d,2d);
       assertThat(result,is(equalTo(3d)));
    }
    @Test
    public void addTwoNumberForNegative() {
        double result = mcalculator.add(-1d,2d);
        assertThat(result,is(equalTo(1d)));
    }

    @Test
    public void addTwoNumberFloat() {
        double result = mcalculator.add(1.111f,1.111d);
        assertThat(result,is(closeTo(2.222d,0.01)));
    }

    @Test
    public void subtractTwoNumber() {
        double result = mcalculator.sub(1d,4d);
        assertThat(result,is(equalTo(-3d)));
    }

    @Test
    public void subWorksWithNegativeResults() {
        double result = mcalculator.sub(1d,-4d);
        assertThat(result,is(equalTo(5d)));
    }

    @Test
    public void mulTwoNumbers() {
        double result = mcalculator.mul(1d,4d);
        assertThat(result,is(equalTo(4d)));
    }

    @Test
    public void mulTwoNumbersZero() {
        double result = mcalculator.mul(2d,0d);
        assertThat(result,is(equalTo(0d)));
    }

    @Test
    public void divTwoNumbers()  {
        double result = mcalculator.div(10d,2d);
        assertThat(result,is(equalTo(5d)));
    }

    @Test
    public void divTwoNumbersZero()  {
        double result = mcalculator.div(4d,0d);
       assertEquals("Number cannot be divide by 0",true,Double.isInfinite(result));
    }

}