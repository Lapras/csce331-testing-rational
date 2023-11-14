package numbers;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThrows;

/**
 * Unit test for simple App.
 */
public class RationalTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public RationalTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( RationalTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testRational()
    {
        // Given no preconditions

        // When I create a default `Rational` value
        Rational value = new Rational();
        // Then the value should have numerator 0
        assertThat("the numerator should be 0", value.numerator(), is(0));
        // And the value should have denominator 1
        assertThat("the denominator should be 1", value.denominator(), is(1));
    }

    public void testSingleConstructor() {
        // Given that I have constructed a `Rational` value using the argument `2`
        Rational value = new Rational(2);
        // Then the value should have numerator `2`
        assertThat("the numerator should be 2", value.numerator(), is(2));
        // And the value should have denominator `1`
        assertThat("the denominator should be 1", value.denominator(), is(1));
    }

    public void testDoubleConstructor() {
        // Given that I have created a Rational value using arguments `2`` and `3`
        Rational value = new Rational(2, 3);
        // Then the value should have numerator `2`
        assertThat("the numerator should be 2", value.numerator(), is(2));
        // And the value should have denominator `3`
        assertThat("the denominator should be 3", value.denominator(), is(3));
    }

    public void testSimplify() {
        // Given I have created a `Rational` value using `48` and `-72`
        Rational value = new Rational(48, -72);
        // Then the value should have numerator `-2`
        assertThat("48 / -72 = -2 / 3", value.numerator(), is(-2));
        // And the value should have denominator `3`
        assertThat("48 / -72 = -2 / 3", value.denominator(), is(3));
    }

    public void testZeroDen() {
        assertThrows(IllegalArgumentException.class, () -> new Rational(1,0));
    }

    public void testNumNeg() {
        Rational value = new Rational(-6,4);
        assertThat("-6/4=-3/2", value.numerator(), is(-3));
        assertThat("-6/4=-3/2", value.denominator(), is(2));
    }

    public void testDoubleNeg() {
        Rational value = new Rational(-3, -3);
        assertThat("-3/-3 = 1/1", value.numerator(), is(1));
        assertThat("-3/-3 =1/1", value.denominator(), is(1));
    }

    public void testDenNeg() {
        Rational value = new Rational(3, -3);
        assertThat("3/-3 = -1/1", value.numerator(), is(-1));
        assertThat("3/-3 = -1/1", value.denominator(), is(1));
    }

    public void testPos() {
        // Given I have created a `Rational` value using `48` and `-72`
        Rational value = new Rational(32, 6);
        // Then the value should have numerator `-2`
        assertThat("32 / 4 = 16 / 3", value.numerator(), is(16));
        // And the value should have denominator `3`
        assertThat("32/ 4 = 16 / 3", value.denominator(), is(3));
    }

    public void testNeg() {
        // Given I have created a `Rational` value using `48` and `-72`
        Rational value = new Rational(-32, 6);
        // Then the value should have numerator `-2`
        assertThat("32 / 4 = 16 / 3", value.numerator(), is(-16));
        // And the value should have denominator `3`
        assertThat("32/ 4 = 16 / 3", value.denominator(), is(3));
    }

    public void testEq() {
        // Given I have created a `Rational` value using `48` and `-72`
        Rational value = new Rational(16, 16);
        // Then the value should have numerator `-2`
        assertThat("16/16 = 1/1", value.numerator(), is(1));
        // And the value should have denominator `3`
        assertThat("16/16 = 1/1", value.denominator(), is(1));
    }

    public void testCopy() {
        // Given that I have created the `Rational` value `2/3`
        Rational original = new Rational(2, 3);
        // When I create a `Rational` value as a copy of the original `Rational` value
        Rational value = new Rational(original);
        // Then the copy's value should have numerator 2
        assertThat("the numerator should be 2", value.numerator(), is(2));
        // And the copy's value should have denominator 3
        assertThat("the denominator should be 3", value.denominator(), is(3));
    }

    public void testOpposite() {
        Rational value = new Rational(2, 3);
        Rational opposite = value.opposite();
        assertThat("the opposite of 2 is -2", opposite.numerator(), is(-2));
        assertThat("the denominator should be 3", opposite.denominator(), is(3));
    }

    public void testReciprocalHappy() {
        Rational value = new Rational(2, 3);
        Rational reciprocal = value.reciprocal();
        assertThat("the numerator should be 3", reciprocal.numerator(), is(3));
        assertThat("the denominator should be 2", reciprocal.denominator(), is(2));
    }

    public void testReciprocalSad() {
        Rational value = new Rational(0);
        assertThrows(IllegalArgumentException.class, value::reciprocal);
    }
}
