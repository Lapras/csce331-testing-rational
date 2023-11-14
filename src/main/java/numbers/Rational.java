package numbers;

/**
 * Hello world!
 *
 */
public class Rational 
{

    private int numerator;
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    public Rational() {
        this(0);
    }

    public Rational(int num) {
        numerator = num;
    }

    public int numerator() {
        return numerator;
     }
     
     public int denominator() {
        return 1;
     }
}
