/**
London Paris
*/

public class Aggregation {
    
    private Fraction fractionField;
    private Rectangle [] arrayField;
    private double doubleField;

    /**
     * No-argument constructor that initializes:
     * fractionField to 0/1
     * arrayField to an array with one Rectangle width width and length 1
     * doubleField to 0.0
     */
   public Aggregation() {
       this.fractionField = new Fraction(0,1); // Fraction initialized to 0/1
       this.arrayField = new Rectangle[1]; // Array of 1 Rectangle
       this.arrayField[0] = new Rectangle(1, 1); // Rectangle with width and length 1
       this.doubleField = 0.0; // Double initialized to 0.0
   }

    /**
     * Constructor that accepts a Fraction, an array of Rectangles, and a double value.
     * Deep copies are made for the Fraction and the array of Rectangles.
     *
     * @param fraction The Fraction object to be deep copied
     * @param array The array of Rectangle objects to be deep copied
     * @param doubleField The double value to be set
     */
   public Aggregation(Fraction fraction, Rectangle[] array, double doubleField) {
       // Deep copy of Fraction
       this.fractionField = new Fraction(fraction);
       // Deep copy of the Rectanlge array
       this.arrayField = new Rectangle[array.length];
       for (int i = 0; i < array.length; i++) {
           this.arrayField[i] = new Rectangle(array[i]);
       }
       this.doubleField = doubleField;
   }

    /**
     * Copy Constructor: Creates a new Aggregation object by deep copying another Aggregation object.
     *
     * @param other The Aggregation object to be deep copied
     */
   public Aggregation(Aggregation other) {
       // Deep copy of Fraction
       this.fractionField = new Fraction(other.fractionField);
       // Deep copy of the Rectangle array
       this.arrayField = new Rectangle[other.arrayField.length];
       for (int i = 0; i < other.arrayField.length; i++) {
           this.arrayField[i] = new Rectangle(other.arrayField[i]);
       }
       // Copy the double value
       this.doubleField = other.doubleField;
   }

    /**
     * Accessor method for fractionField.
     * Returns a deep copy of the Fraction object.
     *
     * @return A deep copy of the fractionField
     */
   public Fraction getFraction() {
       return new Fraction(this.fractionField);
   }

    /**
     * Accessor method for arrayField.
     * Returns a deep copy of the Rectangle array.
     *
     * @return A deep copy of the arrayField
     */
   public Rectangle[] getArray() {
       Rectangle[] arrayCopy = new Rectangle[this.arrayField.length];
       for (int i =  0; i < this.arrayField.length; i++) {
           arrayCopy[i] = new Rectangle(this.arrayField[i]);
       }
       return arrayCopy;
   }

    /**
     * Accessor method for doubleField.
     * Returns the double value directly (since it's a primitive type).
     *
     * @return
     */
   public double getDouble() {
       return this.doubleField;
   }

    /**
     * Mutator method for fractionField.
     * Sets the fractionField by making a deep copy of the input Fraction.
     *
     * @param fraction The Fraction to set (deep copied)
     */
   public void setFraction(Fraction fraction) {
       this.fractionField = new Fraction(fraction);
   }

    /**
     * Mutator method for arrayField.
     * Sets the arrayField by making a deep copy of the input Rectangle array.
     *
     * @param array The Rectangle array to be set (deep copied)
     */
   public void setArray(Rectangle[] array) {
       this.arrayField = new Rectangle[array.length];
       for (int i = 0; i < array.length; i++) {
           this.arrayField[i] = new Rectangle(array[i]);
       }
   }

    /**
     * Mutator method for doubleField.
     * Sets the doubleField.
     *
     * @param doubleField The double value to set
     */
   public void setDouble(double doubleField) {
       this.doubleField = doubleField;
   }

    public String toString()
    {
        StringBuilder strB = new StringBuilder("Fraction: "+fractionField.toString());
        strB.append("; Array: [");
        int i;
        for(i = 0; i<arrayField.length-1; i++)
        {
            strB.append(arrayField[i]+",");
        }
        strB.append(arrayField[i]+"]; Double: "+doubleField);
        
        return strB.toString();
    }
    
    /**
     * Method needed only to test for a deep copy
     * @param a value to set an element with 
     */
    public void forDeepCopyTesting(int a)
    {
    	this.arrayField[0].setLength(a);
    }
}
