/**
London Paris
*/

public class Aggregation {
    
    private Fraction fractionField;
    private Rectangle [] arrayField;
    private double doubleField;
    
   
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
     * Mathod needed only to test for a deep copy
     * @param a value to set an element with 
     */
    public void forDeepCopyTesting(int a)
    {
    	this.arrayField[0].setLength(a);
    }
}
