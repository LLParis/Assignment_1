/**
London Paris
*/

public class Fraction {
    /**
     Instance fields
     */
    private int numerator;
    private int denominator;

    /**
     Non-argument Constructor
     */
    public Fraction() {
        this.numerator = 1;
        this.denominator = 1;
    }

    /**
     Constructor 1: Accepts numerator and denominator
     * @param numerator
     * @param denominator
     */
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cant be zero.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    /**
     Constructor 2
     * @param wholeNum
     * @param numerator
     * @param denominator
     */
    public Fraction(int wholeNum, int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cant be zero.");
        }
        if (numerator < 0) {
            throw new IllegalArgumentException("Numerator cant be negative.");
        }
        if (denominator < 0) {
            throw new IllegalArgumentException("Denominator cant be negative.");
        }

        /**
         Convert mixed fraction to improper fraction
         */
        if (wholeNum < 0) {
            numerator = -Math.abs(wholeNum * denominator * numerator);
        }
        simplify(); // Make sure fraction is in simplest form
    }
    /**
     Copy Constructor
     */

    /**
     Accessor methods
     * @return
     */
    public int getNum() {
        return this.numerator;
    }
    public int getDenom() {
        return this.denominator;
    }

    /**
     Mutator method
     * @param n
     * @param d
     */
    public void set(int n, int d) {
        if (d == 0) {
            throw new IllegalArgumentException("Denominator cant be zero.");
        }
        this.numerator = n;
        this.denominator = d;
        simplify();
    }

    /**
     Simplify method
     */
    private void simplify() {
        int gcd = gcd(Math.abs(numerator), denominator);
        numerator /= gcd;
        denominator /= gcd;

        // Adjust for negative denominator
        if (denominator < 0) {
            numerator = -numerator;
            denominator = - denominator;
        }
    }

    /**
     Calculate the greatest common divisor
     */
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     Addition method
     * @param obj
     * @return
     */
    public Fraction add(Fraction obj) {

        return obj;
    }

    /**
     Subtraction method
     * @param obj
     * @return
     */
    public Fraction subtract(Fraction obj) {

        return obj;
    }

    /**
     Multiplication
     * @param obj
     * @return
     */
    public Fraction multiply(Fraction obj) {
        return obj;
    }

    // Division

    // @Override
    // String

    // Less

    // More
    // Equals
  
}
