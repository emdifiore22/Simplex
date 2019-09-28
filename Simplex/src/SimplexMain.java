import it.ssc.log.SscLogger;
import it.ssc.pl.milp.ConsType;
import it.ssc.pl.milp.Constraint;
import it.ssc.pl.milp.GoalType;
import it.ssc.pl.milp.LP;
import it.ssc.pl.milp.LinearObjectiveFunction;
import it.ssc.pl.milp.Solution;
import it.ssc.pl.milp.SolutionType;
import it.ssc.pl.milp.Variable;
import it.ssc.ref.InputString;
import it.ssc.pl.milp.ListConstraints;
import java.util.ArrayList;


public class SimplexMain {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		String lp_string = 
                " 4    1    1		min      .    \n" +  
                " 2    1	2       eq       4    \n" +   
                " 3    3    1		eq       3    \n" +  
                " 1    -1   3       eq       5";
 
		InputString lp_input = new InputString(lp_string); 
		lp_input.setInputFormat("X1:double, X2:double, X3:double, TYPE:varstring(3), RHS:double"); 
		
		LP lp = new LP(lp_input); 
		SolutionType solution_type=lp.resolve();
		
		if(solution_type==SolutionType.OPTIMUM) { 
		Solution solution=lp.getSolution();
		
		for(Variable var:solution.getVariables()) {
		    SscLogger.log("Nome variabile :"+var.getName() + " valore:"+var.getValue());
		}
		SscLogger.log("Valore ottimo:"+solution.getOptimumValue());
		}   
		else SscLogger.log("Soluzione non ottima:"+solution_type); 
	}
}
