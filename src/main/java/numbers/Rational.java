package numbers;

import java.math.BigInteger;

/**
 * Hello world!
 *
 */
public class Rational 
{

    private int numerator;
    private int denominator;
    
    public Rational() {
        this(0);
    }

    public Rational(int num) {
        this(num, 1);
    }

    Rational(int num, int den) {
        if(den == 0) {
            throw new IllegalArgumentException("Denominator cannot be equal to zero");
        }
        numerator = num;
        denominator = den;
        simplify();
    }

    public Rational(Rational other) {
        numerator = other.numerator;
        denominator = other.denominator;
    }

    public Rational opposite() {
        return new Rational(-1*numerator, denominator);
    }

    public Rational reciprocal() {
        return new Rational(denominator, numerator);
    }

    public int numerator() {
        return numerator;
     }
     
     public int denominator() {
        return denominator;
     }

     public void simplify() {
        int GCD = gcd(numerator, denominator);
        numerator /=  GCD;
        denominator /= GCD;
        if(numerator < 0 && denominator < 0) {
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
        } else if(numerator > 0 && denominator < 0) {
            denominator = Math.abs(denominator);
            numerator *= -1;
        }
     }
     
     public static int gcd(int a, int b)
    {
        BigInteger bigA = BigInteger.valueOf(Math.abs(a));
        BigInteger bigB = BigInteger.valueOf(Math.abs(b));
        BigInteger gcd = bigA.gcd(bigB);
        return gcd.intValue();
    }
}  

