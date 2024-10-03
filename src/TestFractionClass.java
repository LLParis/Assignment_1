import java.io.PrintWriter;

public class TestFractionClass {

    /**
     * All tests for Fraction class
     * @return total score for Fraction class part of assignment
     */
    public static boolean tests(PrintWriter out)
    { 
 
    	out.println("\r\n----Fraction Class TEST SETS -------------------------------------------------------\r\n");
        boolean t1 = testSet01FractionClass(out);
        boolean t2 = testSet02FractionClass(out);
        boolean t3 = testSet03FractionClass(out);
        boolean t4 = testSet04FractionClass(out);
        boolean t5 = testSet05FractionClass(out);
        boolean t6 = testSet06FractionClass(out);
 
        return t1 && t2 && t3 && t4 && t5 && t6;   
    }
    
/**
 * Set of unit tests for Fraction's no-argument constructor, copy constructor and mutator methods; simplify() method
 * @param outputStream stream to direct output into
 * @return number of points earned for this unit. 0 is returned if even one of the tests failed
 */   
   public static boolean testSet01FractionClass(PrintWriter outputStream)
   {
       int count = 0;
       int expectedCount = 5;
    
           
   // Test #1 -- Test for non-argument constructor. Accessor methods used here too.
       Fraction f1 = new Fraction();
       if(f1.getNum()==1 && f1.getDenom()==1) 
       {
           outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for no-argument constructor and accessor methods",  "PASSED");
           count++;
       }
       else  outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for no-argument constructor and accessor methods",  "FAILED");

   // Test #2 -- Test for copy constructor. Mutator methods are being used but not tested thoroughly 
       // f1 being copied with a copy constructor
       Fraction f2 = new Fraction(f1);
       // f1 being changed
       f1.set(1,3);
       // f1 being copied again with a copy constructor
       Fraction f3 = new Fraction(f1);
       if((f2.getNum()==1 && f2.getDenom()==1) && (f3.getNum()==1)&& f3.getDenom()==3) 
       {
           outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for copy constructor",  "PASSED");
           count++;
       }
       else  outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for copy constructor",  "FAILED");
    // Test #3 -- Test for simplify() and mutator methods. 
       // the expectation is that mutator methods call on simplify()
       // simplify() cannot be explicitly called as it is a private method
       f1 = new Fraction();
       f1.set(78, 130);
       f2 = new Fraction();
       f2.set(9, 6);      
       if((f1.getNum()==3 && f1.getDenom()==5) && (f2.getNum()==3 && f2.getDenom()==2)) 
       {
           outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for simplify() method",  "PASSED");
           count++;
       }
       else  outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for simplify() method",  "FAILED");
       

    // Test #4 -- Test for exception thrown by set() method
       f3 = new Fraction();
       try
       {
           f3.set(1, 0); // this must trigger exception
           outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for set() method and exception it must throw",  "FAILED");
       }
       catch (IllegalArgumentException e)
       {
            outputStream.printf("%-80s%-10s\n", "Test Set 02: Test for set() method and exception it must throw",  "PASSED");
                count++;
           }
   // Test #5 -- Test for mutator methods and negative fractions. 
       f1.set(-6, -7);// f1== 6/7
       f2.set(-9, 6); //f2== 3/2
       f3.set(5, -7);//f3== -5/7
       if((f1.getNum()==6 && f1.getDenom()==7)&& (f2.getNum()==-3 && f2.getDenom()==2)&& (f3.getNum()==-5 && f3.getDenom()==7)) 
       {
           outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test fraction sign change in set() method",  "PASSED");
           count++;
       }
       else  outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test fraction sign change in set() method",  "FAILED");
       if(count==expectedCount) return true;
       else return false;
   }


/**
 * Set of unit tests for Fraction's two constructors with parameters
 * @param outputStream stream to direct output into
 * @return number of points earned for this unit. 0 is returned if even one of the tests failed
 */   
   public static boolean testSet02FractionClass(PrintWriter outputStream)
   {
       int count = 0;
       int expectedCount = 8;
       
       
           
   // Test #1 -- Test for constructor with 2 parameters and its upkeep of negative fractions. 
       Fraction f1 = new Fraction(5,3);// 5/3
       Fraction f2 = new Fraction(-3, -5);// 3/5
       Fraction f3 = new Fraction(3, -5); //-3/5
       Fraction f4 = new Fraction(-3, 5); //-3/5
       
       if((f1.getNum()==5 && f1.getDenom()==3) && (f2.getNum()==3 && f2.getDenom()==5)&&(f3.getNum()==-3 && f3.getDenom()==5)&&(f4.getNum()==-3 && f4.getDenom()==5)) 
       {
           outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Test for first constructor and negative fractions",  "PASSED");
           count++;
       }
       else  outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Test for first constructor and negative fractions",  "FAILED");

   // Test #2 -- Test for constructor with 2 parameters and its call for simplify() method. 
       f1 = new Fraction(16, 36); //4/9
       f2 = new Fraction(12, 3); //4/1
       Fraction f5 = new Fraction(0, 3); //0/1
       if((f1.getNum()==4 && f1.getDenom()==9) && (f2.getNum()==4 && f2.getDenom()==1)&& (f5.getNum()==0 && f5.getDenom()==1)) 
       {
           outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Test for constructor with 2 parameters and simplify()",  "PASSED");
           count++;
       }
       else  outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Test for constructor with 2 parameters and simplify()",  "FAILED");

   // Test #3 -- Test for exception thrown by constructor with 2 parameters
       try
       {
           f1 = new Fraction(16, 0);  // this must trigger exception
           outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Test for constructor with 2 parameters and exception",  "FAILED");
       }
       catch (IllegalArgumentException e)
       {
            outputStream.printf("%-80s%-10s\n", "Test Set 03: Test for constructor with 2 parameters and exception",  "PASSED");
                count++;
           }
   // Test #4 -- Test for constructor with 3 parameters, calculations and simplify(). 
       f1 = new Fraction(0, 5, 3);// 5/3
       f2 = new Fraction(3, 5, 3);// 14/3
       f3 = new Fraction(3, 0, 3); //3/1
       f4 = new Fraction(2, 12, 4); //5/1
       
       if((f1.getNum()==5 && f1.getDenom()==3) && 
    		   (f2.getNum()==14 && f2.getDenom()==3) &&
    		   (f3.getNum()==3 && f3.getDenom()==1) &&
    		   (f4.getNum()==5 && f4.getDenom()==1)) 
       {
           outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Test for constructor with 3 parameters and simplify()",  "PASSED");
           count++;
       }
       else  outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Test for constructor with 3 parameters and simplify()",  "FAILED");

   // Test #5 -- Test for constructor with 3 parameters and its upkeep of negative fractions. 
       f1 = new Fraction(-1, 3, 5);// -8/5
       f2 = new Fraction(1, 3, 5);// 8/5     
       if((f1.getNum()==-8 && f1.getDenom()==5) && (f2.getNum()==8 && f2.getDenom()==5)) 
       {
           outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Test constructor with 3 parameters and negative fractions",  "PASSED");
           count++;
       }
       else  outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Test constructor with 3 parameters and negative fractions",  "FAILED");
                   
   // Test #6 -- Test for exception thrown by constructor with 3 parameters
       try
       {
           f1 = new Fraction(1, 16, 0);  // this must trigger exception
           outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Test for constructor with 3 parameters and denominator=0 exception",  "FAILED");
       }
       catch (IllegalArgumentException e)
       {
            outputStream.printf("%-80s%-10s\n", "Test Set 03: Test for constructor with 3 parameters and denominator=0 exception",  "PASSED");
            count++;
       }  
       try
       {
           f1 = new Fraction(1, -5, 3);  // this must trigger exception
           outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Test for constructor with 3 parameters and numerator<0 exception",  "FAILED");
       }
       catch (IllegalArgumentException e)
       {
            outputStream.printf("%-80s%-10s\n", "Test Set 03: Test for constructor with 3 parameters and numerator<0 exception",  "PASSED");
            count++;
       }        
       try
       {
           f1 = new Fraction(1, 5, -3);  // this must trigger exception
           outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Test for constructor with 3 parameters and denominator<0 exception",  "FAILED");
       }
       catch (IllegalArgumentException e)
       {
            outputStream.printf("%-80s%-10s\n", "Test Set 03: Test for constructor with 3 parameters and denominator<0 exception",  "PASSED");
            count++;
       }        
       if(count==expectedCount) return true;
       else return false;
   }
 /**
 * Set of unit tests for Fraction's add() and subtract() methods
 * @param outputStream stream to direct output into
 * @return number of points earned for this unit. 0 is returned if even one of the tests failed
 */   
   public static boolean testSet03FractionClass(PrintWriter outputStream)
   {
       int count = 0;
       int expectedCount = 2;
       
           
   // Test #1 -- Test for add() 
       Fraction f1 = new Fraction(3, 22);
       Fraction f2 = new Fraction(5, 12); 
       Fraction f3 = f1.add(f2);
       f1.set(2, 15);
       f2.set(-1,25);
       Fraction f4 = f1.add(f2);
       Fraction f5 = f2.add(f1);
       if((f3.getNum()==73 && f3.getDenom()==132) && (f4.getNum()==7 && f4.getDenom()==75)&&(f5.getNum()==7 && f5.getDenom()==75)) 
       {
           outputStream.printf("%-80s%-10s\r\n", "Test Set 04: Test for add() method",  "PASSED");
           count++;
       }
       else  outputStream.printf("%-80s%-10s\r\n", "Test Set 04: Test for add() method",  "FAILED");
// Test #2 -- Test for subtract()
       f1.set(3, 22);
       f2.set(5, 12);
       f3 = f1.subtract(f2);
       f1.set(2, 15);
       f2.set(-1,25);
       f4 = f1.subtract(f2);
       if((f3.getNum()==-37 && f3.getDenom()==132) && (f4.getNum()==13 && f4.getDenom()==75)) 
       {
           outputStream.printf("%-80s%-10s\r\n", "Test Set 04: Test for subtract() method",  "PASSED");
           count++;
       }
       else  outputStream.printf("%-80s%-10s\r\n", "Test Set 04: Test for subtract() method",  "FAILED");

       if(count==expectedCount) return true;
       else return false;
   }
  

 /**
 * Set of unit tests for Fraction's multiply() and divide() methods
 * @param outputStream stream to direct output into
 * @return number of points earned for this unit. 0 is returned if even one of the tests failed
 */   
   public static boolean testSet04FractionClass(PrintWriter outputStream)
   {
       int count = 0;
       int expectedCount = 2;

           
   // Test #1 -- Test for multiply() 
       Fraction f1 = new Fraction(2, 3);
       Fraction f2 = new Fraction(3, 5); 
       Fraction f3 = f1.multiply(f2);
       f1.set(2, 3);
       f2.set(-3, 5);
       Fraction f4 = f1.multiply(f2);
      
       if((f3.getNum()==2 && f3.getDenom()==5) && (f4.getNum()==-2 && f4.getDenom()==5)) 
       {
           outputStream.printf("%-80s%-10s\r\n", "Test Set 05: Test for multiply() method",  "PASSED");
           count++;
       }
       else  outputStream.printf("%-80s%-10s\r\n", "Test Set 05: Test for add() method",  "FAILED");
// Test #2 -- Test for divide()
       f1.set(2, 3);
       f2.set(4, 15);
       f3 = f1.divide(f2);
       f1.set(-2, 3);
       f2.set(4, 15);
       f4 = f2.divide(f1);
       if((f3.getNum()==5 && f3.getDenom()==2) && (f4.getNum()==-2 && f4.getDenom()==5)) 
       {
           outputStream.printf("%-80s%-10s\r\n", "Test Set 05: Test for divide() method",  "PASSED");
           count++;
       }
       else  outputStream.printf("%-80s%-10s\r\n", "Test Set 05: Test for divide() method",  "FAILED");

       if(count==expectedCount) return true;
       else return false;
   } 
 /**
 * Set of unit tests for Fraction's less() and more() methods
 * @param outputStream stream to direct output into
 * @return number of points earned for this unit. 0 is returned if even one of the tests failed
 */   
   public static boolean testSet05FractionClass(PrintWriter outputStream)
   {
       int count = 0;
       int expectedCount = 2;
           
   // Test #1 -- Test for less() 
       Fraction f1 = new Fraction(13, 33);
       Fraction f2 = new Fraction(6, 11); 
       Fraction f3 = new Fraction(-1, 2);
       Fraction f4 = new Fraction(3, 12);
      
       if(f1.less(f2)&& f3.less(f4)) 
       {
           outputStream.printf("%-80s%-10s\r\n", "Test Set 06: Test for less() method",  "PASSED");
           count++;
       }
       else  outputStream.printf("%-80s%-10s\r\n", "Test Set 06: Test for less() method",  "FAILED");
    
   // Test #2 -- Test for more()

       if(f2.more(f1)&& f4.more(f3)) 
       {
           outputStream.printf("%-80s%-10s\r\n", "Test Set 06: Test for more() method",  "PASSED");
           count++;
       }
       else  outputStream.printf("%-80s%-10s\r\n", "Test Set 06: Test for more() method",  "FAILED");

       if(count==expectedCount) return true;
       else return false;
   }    
 /**
 * Set of unit tests for Fraction's equals() and toString() methods
 * @param outputStream stream to direct output into
 * @return number of points earned for this unit. 0 is returned if even one of the tests failed
 */   
   public static boolean testSet06FractionClass(PrintWriter outputStream)
   {
       int count = 0;
       int expectedCount = 2;

           
   // Test #1 -- Test for equals() 
       Fraction f1 = new Fraction(13, 33);
       Fraction f2 = new Fraction(6, 11); 
       Fraction f3 = new Fraction(1, 2);
       Fraction f4 = new Fraction(3, 6);
      
       if(!f1.equals(f2)&& f3.equals(f4)) 
       {
           outputStream.printf("%-80s%-10s\r\n", "Test Set 07: Test for equals() method",  "PASSED");
           count++;
       }
       else  outputStream.printf("%-80s%-10s\r\n", "Test Set 07: Test for equals() method",  "FAILED");
    
   // Test #2 -- Test for toString()
       f2 = new Fraction(3, 6, 11);
       f3 = new Fraction(-1, 1, 2);
       f4 = new Fraction(0, 3);
       if(f1.toString().equals("13/33")&& 
          f2.toString().equals("39/11 or 3 and 6/11")&&
          f3.toString().equals("-3/2 or -1 and -1/2")&&
          f4.toString().equals("0/1 or 0")) 
       {
           outputStream.printf("%-80s%-10s\r\n", "Test Set 07: Test for toString() method",  "PASSED");
           count++;
       }
       else  outputStream.printf("%-80s%-10s\r\n", "Test Set 07: Test for toString() method",  "FAILED");

       if(count==expectedCount) return true;
       else return false;
   }   
}
