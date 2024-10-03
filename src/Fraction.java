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
     * Constructor 1: Accepts numerator and denominator.
     * If the denominator is 0, it throws an IllegalArgumentException.
     * The fraction is simplified after creation.
     *
     * @param numerator
     * @param denominator
     * @throws IllegalArgumentException if the denominator is zero
     */
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify(); // Simplify the fraction after initialization
    }

    /**
     * Constructor 2 Mixed Fractions:
     * The whole part, numerator, and denominator are used to represent a mixed fraction.
     * If the denominator is 0, an IllegalArgumentException is thrown.
     * The sign of the fraction is determined by the whole part (wholeNum).
     * If the whole part is negative, the entire fraction will be negative. The fraction is simplified.
     *
     * @param wholeNum The whole part of the mixed fraction
     * @param numerator The numerator of the fraction
     * @param denominator The denominator of the fraction
     * @throws IllegalArgumentException If the denominator is zero or if the numerator or denominator is negative.
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
     * Copy Constructor: Creates a new Fraction object by copying another Fraction object.
     *
     * @param obj
     */
    public Fraction(Fraction obj) {
        this.numerator = obj.numerator;
        this.denominator = obj.denominator;
        simplify(); // Simplify copied fraction
    }

    /**
     * Accessor method for the numerator.
     *
     * @return The numerator of the fraction
     */
    public int getNum() {
        return this.numerator;
    }

    /**
     * Accessor method for the denominator.
     *
     * @return The denominator of the fraction
     */
    public int getDenom() {
        return this.denominator;
    }

    /**
     * Mutator method: Sets both the numerator and denominator.
     * If the denominator is zero, an IllegalArgumentException is thrown.
     * The fraction is simplified after the values are set.
     *
     * @param n The new numerator
     * @param d The new denominator
     * @throws IllegalArgumentException If the denominator is zero
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
     * Simplifies the fraction by dividing the numerator and denominator
     * by their greatest common divisor (GCD).
     * If the denominator is negative, the sign is transferred to the numerator
     * to keep the denominator positive.
     */
    private void simplify() {
        int gcd = gcd(Math.abs(numerator), denominator);
        numerator /= gcd;
        denominator /= gcd;

        // If the numerator is 0, set the fraction to 0/1
        if (numerator == 0) {
            denominator = 1;
        }

        // Adjust for negative denominator
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    /**
     * Calculates the greatest common divisor of two numbers using the Euclidean Algorithm.
     * @param a The first number
     * @param b The second number
     * @return The greatest common divisor of a and b
     */
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     * Addition method: Adds two fractions and returns the result as a new Fraction object.
     * The fractions are first converted to have a common denominator, and numerators are adjusted.
     * The Fraction is simplified.
     *
     * @param obj The Fraction to add
     * @return A new Fraction representing the sum
     */
    public Fraction add(Fraction obj) {
        // Find the common denominator
        int commonDenom = this.denominator * obj.denominator;
        // Adjust the numerators and add
        int newNumerator = (this.numerator * obj.denominator) + (obj.numerator * this.denominator);
        simplify();
        // Return the new simplified Fraction
        return new Fraction(newNumerator, commonDenom);
    }

    /**
     * Subtraction Method: Subtracts a fraction from another fraction and returns the result.
     * The fractions are first converted to have a common denominator, and the numerators are adjusted.
     * The resulting fraction is simplified.
     *
     * @param obj The Fraction to subtract from this fraction
     * @return A new Fraction representing the difference between this fraction and obj
     */
    public Fraction subtract(Fraction obj) {
        // Find the common denominator
        int commonDenom = this.denominator * obj.denominator;
        // Adjust the numerators and subtract
        int newNumerator = (this.numerator * obj.denominator) - (obj.numerator * this.denominator);
        simplify();
        return new Fraction(newNumerator, commonDenom);
    }

    /**
     * Multiplies two fractions and returns the result as a new Fraction object.
     * The numerators are multiplied together, and the denominators are multiplied together.
     * The resulting fraction is simplified.
     *
     * @param obj The Fraction to multiply by
     * @return A new Fraction representing the product of this fraction and obj
     */
    public Fraction multiply(Fraction obj) {
        Fraction product = new Fraction(this.numerator * obj.numerator, this.denominator * obj.denominator);
        product.simplify();
        return product;
    }

    /**
     * Divides two fractions and returns the result as a new Fraction object.
     * The current fraction is divided by multiplying it by the reciprocal of obj.
     * The resulting fraction is simplified.
     *
     * @param obj The Fraction to divide by
     * @return A new Fraction representing the quotient
     * @throws ArithmeticException If the numerator of obj is zero (cannot divide by zero)
     */

    public Fraction divide(Fraction obj) {
        if (obj.numerator == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }

        Fraction quotient = new Fraction(this.numerator * obj.denominator, this.denominator * obj.numerator);
        quotient.simplify();
        return quotient;
    }


    /**
     * Less Method: Compares two fractions and returns true if this fraction is less than the parameter fraction.
     * Both fractions are converted to have a common denominator before comparing their numerators.
     * @param obj The Fraction to compare with
     * @return True if this fraction is smaller than obj
     */
    public boolean less(Fraction obj) {
        int thisNumerator = this.numerator * obj.denominator;
        int otherNumerator = obj.numerator * this.denominator;

        return thisNumerator < otherNumerator;
    }

    /**
     * Compares two fractions and returns true if this fraction is greater than the parameter fraction.
     * Both fractions are converted to have a common denominator before comparing their numerators.
     *
     * @param obj the Fraction to compare with
     * @return true if this fraction is greater than obj
     */
    public boolean more(Fraction obj) {
        int newNumerator = this.numerator * obj.denominator;
        int otherNumerator = this.denominator * obj.numerator;

        return newNumerator > otherNumerator;
    }

    /**
     * Equals Method: Compares two fractions and returns true if they are equal.
     * Both fractions are converted to have a common denominator before comparing their numerators.
     *
     * @param obj The Fraction to compare with
     * @return true if this fraction is equal to obj
     */
    public boolean equals(Fraction obj) {
        int newNumerator = this.numerator * obj.denominator;
        int otherNumerator = this.denominator * obj.numerator;
        this.simplify();
        obj.simplify();

        return newNumerator == otherNumerator;
    }

    /**
     * Converts the fraction into a string.
     * Proper fractions are represented as numerator/denominator.
     * Improper fractions are represented as numerator/denominator or wholePart and remainder/denominator.
     * Zero fractions are represented as 0/1 or 0.
     * For negative fractions, the negative sign is handled in both the improper and mixed form.
     *
     * @return A string representation of the fraction.
     */
    @Override
    public String toString() {
        if (this.numerator == 0) {
            // Case for zero fraction (0/1 or 0)
            return "0/1 or 0";
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
