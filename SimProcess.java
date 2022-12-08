//Name Rachel Reich
//Touro ID: T00416601

package mod3Assignment;
import java.util.*;

public class SimProcess {

	private int pid;
	private String procName;
	private int totalInstructions;
	
	/**
	 * Constuctor
	 * @param pid sets the pid
	 * @param procName sets the procName
	 * @param totalInstructions sets the totalInstructions
	 */
	public SimProcess(int pid, String procName, int totalInstructions) {
		this.pid = pid;
		this.procName = procName;
		this.totalInstructions = totalInstructions;
	}
	
	/**
	 * the getPID method returns the process's PId
	 * @return the pid
	 */
	public int getPID() {
		return this.pid;
	}
	
	/**
	 * The execute method displays a message about details of product
	 * and returns the State of the process
	 * @param i the number instruction the process is up to
	 * @return the state of the process
	 */
	public ProcessState execute(int i){
		System.out.println("Proc " + procName + " PID: " + pid + " executing instruction: " + i);
		
		
		//Create a Random object
		Random randomDouble = new Random();
		double testerValue = randomDouble.nextDouble();
		
		if (i >= totalInstructions) {
			return ProcessState.FINISHED;			
		}
		else if( testerValue < .15 ) {
			return ProcessState.BLOCKED;
	    }
		else {
			return ProcessState.READY;
		}
		
	}
}
