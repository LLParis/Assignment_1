
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
     Constructor 1
     * @param numerator
     * @param denominator
     */
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Value cant be zero.");
        }
        this.numerator = numerator;
        this.denominator = denominator;

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
