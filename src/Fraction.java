/**
* @author London Paris
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

        this.numerator = numerator;
        this.denominator = denominator;

        /**
         Convert mixed fraction to improper fraction
         */
        if (wholeNum < 0) {
            numerator = -Math.abs(wholeNum * denominator + numerator);
        } else {
            numerator = wholeNum * denominator + numerator;
        }
        simplify(); // Make sure fraction is in its most simple form
    }
    /**
     Copy Constructor
     @param obj
     */
    public Fraction(Fraction obj) {
        this.numerator = obj.numerator;
        this.denominator = obj.denominator;
    }

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
            throw new IllegalArgumentException("Denominator cannot be zero.");
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
            denominator = -denominator;
        }
    }

    /**
     * Calculate the greatest common divisor using Euclidean Algorithm
     * @param a
     * @param b
     * @return
     */
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     * Addition method
     * @param obj
     * @return
     */
    public Fraction add(Fraction obj) {
        int commonDenom = this.denominator * obj.denominator;
        int newNumerator = (this.numerator * obj.denominator) + (obj.numerator * this.denominator);

        return new Fraction(newNumerator, commonDenom);
    }

    /**
     * Subtraction method
     * @param obj
     * @return
     */
    public Fraction subtract(Fraction obj) {
        int commonDenom = this.denominator * obj.denominator;
        int newNumerator = (this.numerator * obj.denominator) - (obj.numerator * this.denominator);

        return new Fraction(newNumerator, commonDenom);
    }

    /**
     * Multiplication
     * @param obj
     * @return j
     */
    public Fraction multiply(Fraction obj) {
        return new Fraction(this.numerator * obj.denominator, this.denominator * obj.numerator);
    }

    /**
     * Division
     * @param obj
     * @return
     */
    public Fraction divide(Fraction obj) {
        if (obj.numerator == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return new Fraction(this.numerator * obj.denominator, this.denominator * obj.numerator);
    }


    /**
     * Less
     * @param obj
     * @return
     */
    public boolean less(Fraction obj) {
        int thisNumerator = this.numerator * obj.denominator;
        int otherNumerator = obj.numerator * this.denominator;

        return thisNumerator < otherNumerator;
    }

    /**
     * More
     * @param obj
     * @return
     */
    public boolean more(Fraction obj) {
        int newNumerator = this.numerator * obj.denominator;
        int otherNumerator = this.denominator * obj.numerator;

        return newNumerator > otherNumerator;
    }

    /**
     * Equals
     * @param obj
     * @return true if fractions are equal
     */
    public boolean equals(Fraction obj) {
        int newNumerator = this.numerator * obj.denominator;
        int otherNumerator = this.denominator * obj.numerator;
        this.simplify();
        obj.simplify();

        return newNumerator == otherNumerator;
    }


    @Override
    public String toString() {
        if (this.numerator == 0) {
            // Case for zero fraction (0/1 or 0)
            return this.numerator + "/" + this.denominator + " or " + this.numerator;
        } else if (Math.abs(this.numerator) < this.denominator) {
            // Case for proper fractions (numerator < denominator) 3/22
            return this.numerator + "/" + this.denominator;
        } else {
            // Case for improper fractions (numerator >= denominator)
            int wholePart = this.numerator / this.denominator; // Whole part can be negative if numerator or denominator is negative
            int remainder = Math.abs(this.numerator % this.denominator); // Remainder is always positive

            if (remainder == 0) {
                // Case where the fraction is a whole number (-6/3 becomes -2)
                return this.numerator + "/" + this.denominator + " or " + wholePart;
            } else {
                // Case for mixed fractions (-25/24 or -1 and 1/24)
                return this.numerator + "/" + this.denominator + " or " + wholePart + " and " + remainder + "/" + Math.abs(this.denominator);
            }
        }
    }
}
