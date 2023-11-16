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

    public Rational times(Rational r) {
        return new Rational(numerator*r.numerator, denominator*r.denominator);
    }

    public Rational dividedBy(Rational r) {
        Rational divisor = new Rational(r.denominator(), r.numerator());
        return this.times(divisor);
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

     public Rational plus(Rational r) {
        int num1 = numerator * r.denominator;
        int num2  = r.numerator * denominator;
        int den  = denominator * r.denominator;

        return new Rational(num1+num2, den);
     }

     public Rational minus(Rational r) {
        return plus(new Rational(r.numerator()*-1, r.denominator()));
     }

     public boolean isZero() {
        if(numerator == 0) {
            return true;
        } else {
            return false;
        }
     }

     public boolean isOne() {
        simplify();
        if(numerator == 1 && denominator == 1) {
            return true;
        } else {
            return false;
        }
     }

     public boolean isMinusOne() {
        simplify();
        if(numerator == -1 && denominator == 1) {
            return true;
        } else {
            return false;
        }
     }

     public Rational raisedToThePowerOf(int n) {
        if(n < 0) {
            n = Math.abs(n);
            return new Rational((int)Math.pow(denominator, n), (int)Math.pow(numerator, n));
        }
        return new Rational((int)Math.pow(numerator, n), (int)Math.pow(denominator, n));
     }

     public boolean equals(Object other) {
        if(other instanceof Number) {
            Number num = (Number) other;
            double dub = num.doubleValue();
            if((double)numerator/(double)denominator == dub) {
                return true;
            } else {
                return false;
            }
        } else if (other instanceof Rational) {
            Rational rat = (Rational) other;
            if(rat.numerator == numerator && rat.denominator == denominator) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
     }

     /*I want to put in the comments here that implementing greaterThan, and by extension the other comparison methods, presents an interesting challenge. Java does not store irrational numbers fully and MUST round them. And unlike equals(), this roudning
      * is something that I'm not sure garuntees complete accuracy. Meaning converting a Rational to a double value and comparing using the Number method might not be the best option with garunteed accuracy. but using double values is probably the best way to implement this when
      passed a number as an argument. I'm sure due to some Java stuff I don't know that simply converting the Rational to a double and assuming the rounding won't cause issues will work. But I'm going to implement this one the safe side and do seperate implementations for each
      */
     public boolean greaterThan(Number n) {
        double d = (double)numerator/(double)denominator;
        System.out.println("d: " + d + " n: " + n.doubleValue());
        if(d > n.doubleValue()) {
            return true;
        } else {
            return false;
        }
     }

     public boolean greaterThan(Rational r) {
        int GCD = gcd(denominator, r.denominator());
        if(numerator * GCD > r.numerator() * GCD) {
            return true;
        } else {
            return false;
        }
     }

     public String toString() {
        simplify();
        if(denominator == 1 || numerator == 0) {
            return Integer.toString(numerator);
        } else {
            return (Integer.toString(numerator) + "/" + Integer.toString(denominator));
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

