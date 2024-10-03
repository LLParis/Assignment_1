import java.io.PrintWriter;

public class TestAggregationClass {

    /**
     * All tests for Aggregation
     * @return total score for Aggregation  part of assignment
     */
    public static boolean tests(PrintWriter out)
    { 
    	out.println("\r\n----Aggregation Class TEST SETS -------------------------------------------------------\r\n");
       
        boolean t1 = testSet01AggregationClass(out);
        boolean t2 = testSet02AggregationClass(out);
        boolean t3 = testSet03AggregationClass(out);

        return t1 && t2 && t3;   
    }

	/**
	 * Set of unit tests for Aggregation no-argument constructor and constructor with parameters
	 * @param outputStream stream to direct output into
	 * @return true is returned if all tests passed, false when even one of the tests failed
	 */   
   public static boolean testSet01AggregationClass(PrintWriter outputStream)
   {
       int count = 0;
       int expectedCount = 4;
           
   // Test #1 -- Test for non-argument constructor and toString()
       Aggregation obj1 = new Aggregation();
      
       if(obj1.toString().equals("Fraction: 0/1 or 0; Array: [{Length:1.0, Width:1.0}]; Double: 0.0")) 
       {
           outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for no-argument constructor",  "PASSED");
           count++;
       }
       else  outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for no-argument constructor",  "FAILED");

   // Test #2 -- Test for constructor with parameters
       Fraction f2 = new Fraction(3, 4);   
       Rectangle[] array2 = {new Rectangle(10, 30), new Rectangle(11, 22), new Rectangle(7, 2)};
       Aggregation obj2 = new Aggregation(f2, array2, 3.4);
       
       if(obj2.toString().equals("Fraction: 3/4; Array: [{Length:10.0, Width:30.0},{Length:11.0, Width:22.0},{Length:7.0, Width:2.0}]; Double: 3.4")) 
       {
           outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for array with parameters",  "PASSED");
           count++;
       }
       else  outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for array with parameters",  "FAILED");        

   // Test #3 -- Test for for constructor with parameters and deep copy of the fraction field
       f2.set(5, 6);// changing the fraction that was used to set the obj2 fraction field. It must not affect the object
       if(obj2.toString().equals("Fraction: 3/4; Array: [{Length:10.0, Width:30.0},{Length:11.0, Width:22.0},{Length:7.0, Width:2.0}]; Double: 3.4")) 
       {
           outputStream.printf("%-80s%-10s\r\n", "Test Set 01: constructor and fraction deep copy",  "PASSED");
           count++;
       }
       else  outputStream.printf("%-80s%-10s\r\n", "Test Set 01: constructor and fraction deep copy",  "FAILED");        

   // Test #4 -- Test for for constructor with parameters and deep copy of the array field
       array2[0] = new Rectangle(1, 2);// changing the array that was used to set the obj2 fraction field. It must not affect the object
       if(obj2.toString().equals("Fraction: 3/4; Array: [{Length:10.0, Width:30.0},{Length:11.0, Width:22.0},{Length:7.0, Width:2.0}]; Double: 3.4")) 
       {
           outputStream.printf("%-80s%-10s\r\n", "Test Set 01: constructor and array deep copy",  "PASSED");
           count++;
       }
       else  outputStream.printf("%-80s%-10s\r\n", "Test Set 01: constructor and array deep copy",  "FAILED"); 

   // Test #5 -- Test for for constructor with parameters, deep copy of each element of the array
       array2[1].setWidth(100);// changing the original Rectangle object in array
       if(obj2.toString().equals("Fraction: 3/4; Array: [{Length:10.0, Width:30.0},{Length:11.0, Width:22.0},{Length:7.0, Width:2.0}]; Double: 3.4")) 
       {
           outputStream.printf("%-80s%-10s\r\n", "Test Set 01: constructor and each Rectangle element deep copy",  "PASSED");
           count++;
       }
       else  outputStream.printf("%-80s%-10s\r\n", "Test Set 01: constructor and each Rectangle element deep copy",  "FAILED"); 
       if (count==expectedCount) return true;
       else return false;

       } 
   
   
	   /**
	 * Set of unit tests for Aggregation accessor and mutator methods
	 * @param outputStream stream to direct output into
	 * @return true is returned if all tests passed, false when even one of the tests failed
	 */   
   public static boolean testSet02AggregationClass(PrintWriter outputStream)
   {
       int count = 0;
       int expectedCount = 6;

       
       Fraction f1 = new Fraction(3, 4);  
       Rectangle[] array1 = {new Rectangle(10, 30), new Rectangle(11, 22), new Rectangle(7, 2)};
       Aggregation obj1 = new Aggregation(f1,array1, 3.4);
       
// Test #1 -- Test for accessors - getFraction(). Accessors must make deep copies of the fields when returning objects
       Fraction f2 = obj1.getFraction();
       boolean areEqual = f2.equals(f1); 
       f2.set(4, 5); // fraction that has been returned from the object is being changed. This should not affect the object if a deep copy to set fraction field was made
       if(obj1.toString().equals("Fraction: 3/4; Array: [{Length:10.0, Width:30.0},{Length:11.0, Width:22.0},{Length:7.0, Width:2.0}]; Double: 3.4") && areEqual ) 
       {
           outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for deep copy in getFraction()",  "PASSED");
           count++;
       }
       else  outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for deep copy in getFraction()",  "FAILED");
    
   // Test #2 -- Test for accessors - getArray(). Accessors must make deep copies of the fields when returning objects
       Rectangle[]array2 = obj1.getArray(); 
       areEqual = equalArrays(array1, array2);
       array2[0] = new Rectangle(10, 10); // copy of array field returned from objects is being changed. If a deep copy of this object was not made in constructor, this change will affect the Aggregation object
       array2[1].setLength(50); // copy of array field returned from objects is being changed. If a deep copy of each element is not made, this change will affect the Aggregation object
       if(obj1.toString().equals("Fraction: 3/4; Array: [{Length:10.0, Width:30.0},{Length:11.0, Width:22.0},{Length:7.0, Width:2.0}]; Double: 3.4") && areEqual) 
       {
           outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for deep copy in getArray()",  "PASSED");
           count++;
       }
       else  outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for deep copy in getArray()",  "FAILED");

   // Test #3 -- Test for accessors - getDouble(). Double is a primitive type field - no deep copy possible
       if(obj1.getDouble()==3.4) 
       {
           outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for getDouble()",  "PASSED");
           count++;
       }
       else  outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for getDouble()",  "FAILED");

   // Test #4 -- Test for setFraction()  - were the original objects copied correctly?
       Fraction f3 = new Fraction(5, 7);  
       obj1.setFraction(f3);
       f3.set(1,3); // fraction object that was used to set field is being changed. This must not affect the object
       
       if(obj1.toString().equals("Fraction: 5/7; Array: [{Length:10.0, Width:30.0},{Length:11.0, Width:22.0},{Length:7.0, Width:2.0}]; Double: 3.4")) 
       {
           outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for setFraction() method deep copy",  "PASSED");
           count++;
       }
       else  outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for setFraction() method deep copy",  "FAILED");

       f3.set(5,7);
   // Test #5 -- Test for setArray()  - were the original objects copied correctly?

       obj1 = new Aggregation(f3,array1, 3.4);
       Rectangle []array3 = {new Rectangle(3, 3), new Rectangle(4, 4)};  
       obj1.setArray(array3);
       
       array3[0]=new Rectangle(100, 3); // array object that was used to set field is being changed. This must not affect the object
       array3[1].setLength(50); // copy of array field returned from objects is being changed. If a deep copy of each element is not made, this change will affect the Aggregation object
       if(obj1.toString().equals("Fraction: 5/7; Array: [{Length:3.0, Width:3.0},{Length:4.0, Width:4.0}]; Double: 3.4")) 
       {
           outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for setArray() method deep copy",  "PASSED");
           count++;
       }
       else  outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for setArray() method deep copy",  "FAILED");       

   // Test #6 -- Test for setDouble()  - no deep copy possible, it is a primitive type field
       array3[0] = new Rectangle(3, 3);
       array3[1] = new Rectangle(4, 4);
       obj1 = new Aggregation(f3,array3, 3.4);
       obj1.setDouble(1.2);
       if(obj1.toString().equals("Fraction: 5/7; Array: [{Length:3.0, Width:3.0},{Length:4.0, Width:4.0}]; Double: 1.2")) 
       {
           outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for setDouble() method",  "PASSED");
           count++;
       }
       else  outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for setDouble() method",  "FAILED"); 

       
       if (count==expectedCount) return true;
       else return false;

       }   
	   /**
	 * Set of unit tests for Aggregation copy constructor
	 * @param outputStream stream to direct output into
	 * @return true is returned if all tests passed, false when even one of the tests failed
	 */  
   public static boolean testSet03AggregationClass(PrintWriter outputStream)
   {
       int count = 0;
       int expectedCount = 3;

       
       Fraction f1 = new Fraction(3, 4);  
       Rectangle[] array1 = {new Rectangle(10, 30), new Rectangle(11, 22), new Rectangle(7, 2)};
       Aggregation obj1 = new Aggregation(f1,array1, 3.4);
       
// Test #1 -- Test for copy constructor to do a copy correctly
       Aggregation objCopy = new Aggregation(obj1);
       if(objCopy.toString().equals("Fraction: 3/4; Array: [{Length:10.0, Width:30.0},{Length:11.0, Width:22.0},{Length:7.0, Width:2.0}]; Double: 3.4")) 
       {
           outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Test for copy constructor basic functionality",  "PASSED");
           count++;
       }
       else  outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Test for copy constructor basic functionality",  "FAILED");

   // Test #2 -- Test for deep copy of the fraction field by copy constructor
       Fraction f3 = new Fraction(5, 7);  
       obj1.setFraction(f3);// any changes to obj1 must not affect obj2

       if(objCopy.toString().equals("Fraction: 3/4; Array: [{Length:10.0, Width:30.0},{Length:11.0, Width:22.0},{Length:7.0, Width:2.0}]; Double: 3.4")) 
       {
           outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Test for deep copy of fraction by copy constructor",  "PASSED");
           count++;
       }
       else  outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Test for deep copy of fraction by copy constructor",  "FAILED");        
   // Test #3 -- Test for deep copy of all Rectangle array elements 
       
       Rectangle []array3 = {new Rectangle(3, 3), new Rectangle(4, 4)}; 
       obj1.setArray(array3);// any changes to obj1 must not affect objCopy

       if(objCopy.toString().equals("Fraction: 3/4; Array: [{Length:10.0, Width:30.0},{Length:11.0, Width:22.0},{Length:7.0, Width:2.0}]; Double: 3.4")) 
       {
           outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Test for deep copy of array by copy constructor",  "PASSED");
           count++;
       }
       else  outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Test for deep copy of array by copy constructor",  "FAILED");        

   // Test #4 -- Test for deep copy of all Rectangle array elements 
       
       obj1.forDeepCopyTesting(100);// changing one of the elements of the inner array of obj1. If each elment was shallow-copied, this will cause changes in the objCopy
       if(objCopy.toString().equals("Fraction: 3/4; Array: [{Length:10.0, Width:30.0},{Length:11.0, Width:22.0},{Length:7.0, Width:2.0}]; Double: 3.4")) 
       {
           outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Test for deep copy of array elments by copy constructor",  "PASSED");
           count++;
       }
       else  outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Test for deep copy of array elments by copy constructor",  "FAILED");        
       if (count==expectedCount) return true;
       else return false;

   }   
/**
* Compares two arrays of Rectangles
* @param one first array to compare
* @param two second array to compare
* @return returns true if arrays are the same, false if not
*/    
   public static boolean equalArrays(Rectangle[] one, Rectangle[] two)
   {
       if(one.length!=two.length) return false;
       for(int i= 0; i<one.length; i++)  
       {
           if(!one[i].equals(two[i])) return false;
       }
       return true;
   }

}
