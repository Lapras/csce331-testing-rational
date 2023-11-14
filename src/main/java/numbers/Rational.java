package numbers;

/**
 * Hello world!
 *
 */
public class Rational 
{

    private int numerator;
    private int denominator;
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    public Rational() {
        this(0);
    }

    public Rational(int num) {
        numerator = num;
        denominator = 1;
    }

    Rational(int num, int den) {
        numerator = num;
        denominator = den;
    }

    public int numerator() {
        return numerator;
     }
     
     public int denominator() {
        return denominator;
     }
}
