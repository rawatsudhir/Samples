/**
 * @author sudhir rawat
 * Description :- In this class we are calculating commission and returning commission and status 
 * Input1:- 0 index is for sales
 * Input2:- 1 index is for target
 * If sales > target then commission is given else 0
 * if sales > target then commission is 8% of sales and status is 1 
 * if sales < target then commission is 0 and status is -1
 * return commission and status
 */
package salescommission;
import java.io.IOException;
import org.apache.pig.EvalFunc; /* importing org.apache.pig.EvalFunc for extending Evalfunc class */
import org.apache.pig.data.Tuple; /* importing org.apache.pig.data.Tuple since we'll be refer it in the class */
public class calculatecommission extends EvalFunc<String> { /* Extend EvalFunc class which is used to implement function on data set */
	public String exec(Tuple input) throws IOException { /* Expecting Tuple as input for example (100,200). Raise exception if any error during IO */
		Long sales= (Long) input.get(0); /* first index value of Tuple contains sales value*/
		Long target= (Long) input.get(1); /* second index value of Tuple contains target value */
		Double commission=0.0; /* variable will contain commission value */
		Integer status=0;	 /* variable will contain status */
		try {
			if (sales>target) /* Checking if sales is greater than target means employee able to achieve the target */
			{
				commission = sales * 0.08; /* Calculating commission 8% */
				status=1; /* Setting status 1*/
			}
			if (sales<target) /* Checking if sales is less than target means employee not able to achieve the target */
			{
				commission=0.0; /* No commission given */
				status=-1; /* Setting status -1*/
			}
			return commission + "," + status; /* Returning commission and status based on above calculation */
			} catch (Exception e) {
		// Throwing an exception will cause the task to fail.
				throw new IOException("Error while processing the data." + e.getMessage(), e);
			}
		}
}
