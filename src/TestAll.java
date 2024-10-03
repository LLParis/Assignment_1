
import java.io.*;

public class TestAll {

	public static void main(String[] args)
	{
		try
		{
			System.out.println("Starting...");
			File file = new File("_gradingLog.txt");
			if(file.exists())
			{
				file.delete();
			}
			FileWriter fw = new FileWriter(file,true);
			PrintWriter out = new PrintWriter(fw,true);	
			
			// Fraction class test calls
			TestFractionClass.tests(out);
         
			// Aggregation Class test calls        
			TestAggregationClass.tests(out);

			
			out.close();
			System.out.println("Testing complete. See results in file \"_gradingLog.txt\"");
		}
		catch (IOException e)
		{
			System.out.println("File IO troubles"+ e.getMessage());
		}
	}
}

