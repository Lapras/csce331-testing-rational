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

    public void testTimes() {
        Rational p = new Rational(2, 3);
        Rational q = new Rational(5, 7);
        Rational result = p.times(q);
        assertThat("2 * 5 = 10", result.numerator(), is(10));
        assertThat("3 * 7 = 21", result.denominator(), is(21));
    }

    public void testIsZero() {
        Rational zero = new Rational(0);
        Rational num = new Rational(5);
        assertThat("0 == 0", zero.isZero(), is(true));
        assertThat("5 != 0", num.isZero(), is(false));
    }

    public void testIsOne() {
        Rational one = new Rational(1);
        Rational num = new Rational(-2);
        assertThat("1 == 1", one.isOne(), is(true));
        assertThat("-2 != 1", num.isOne(), is(false));
    }

    public void testIsMinusOne() {
        Rational one = new Rational(-1);
        Rational num = new Rational(-9);
        assertThat("-1 == 1", one.isMinusOne(), is(true));
        assertThat("-9 != -1", num.isMinusOne(), is(false));
    }

    public void testToString() {
        Rational zero = new Rational(0);
        Rational two = new Rational (2);
        Rational negThree = new Rational(-3);
        Rational simplify = new Rational (10,2);
        Rational frac = new Rational(5,7);
        Rational negFrac = new Rational(-5,7);
        Rational negFrac2 = new Rational(7,-5);

        assertThat("0", zero.toString(), is("0"));
        assertThat("2", two.toString(), is("2"));
        assertThat("-3", negThree.toString(), is("-3"));
        assertThat("10/2->5", simplify.toString(), is("5"));
        assertThat("5/7",  frac.toString(), is("5/7"));
        assertThat("-5/7", negFrac.toString(), is("-5/7"));
        assertThat("7/-5 -> -7/5", negFrac2.toString(), is("-7/5"));
    }

    public void testEquals() {
        Rational four = new Rational(4);
        Rational four2 = new Rational(4,1);
        Rational frac = new Rational(23,4);
        String string = "hello";

        assertThat("is Self", four.equals(four), is(true));
        assertThat("4(r) == 4(r)", four.equals(four2), is(true));
        assertThat("4(r) == 4", four.equals(4), is(true));
        assertThat("4(r) != 2", four.equals(2), is(false));
        assertThat("23/4(r) == 23.0/4.0", frac.equals(23.0/4.0), is(true));
        assertThat("4(r) != string", four.equals(string), is(false));
    }

    public void testPlus() {
        Rational five = new Rational(5);
        Rational negFive = new Rational(-5);
        Rational frac = new Rational(7,4);
        Rational negFrac = new Rational (4,-7);
        Rational frac2 = new Rational(239,197);

        assertThat("5+5 = 10", five.plus(five), is(new Rational(10)));
        assertThat("-5+5 = 0", negFive.plus(five), is(0));
        assertThat("7/4+7/4=7/2", frac.plus(frac), is(new Rational(7,2)));
        assertThat("7/4+(-4/7) = 33/28", frac.plus(negFrac), is(new Rational(33, 28)));
        assertThat("(-4/7)+239/197=885/1379", negFrac.plus(frac2), is(new Rational(885, 1379)));
    }
}
