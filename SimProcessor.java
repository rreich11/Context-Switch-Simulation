//Name Rachel Reich
//Touro ID: T00416601

package mod3Assignment;
import java.util.Random;  // Needed for the Random class

public class SimProcessor {
	
	private SimProcess process;
	private int reg1;
	private int reg2;
	private int reg3;
	private int reg4;
	private int currInstruction;

	
	//QUESTION does it need constructor with reference of SimProcess passed in??
	/**
	 * the setSimProcess sets a reference to the SimProcess object
	 * @param process the SimProcess object
	 */
	public void setSimProcess(SimProcess process) {
		this.process = process;
	}
	
	/**
	 * the getSimProcess returns the reference to the process
	 * @return the SimProcess object
	 */
	public SimProcess getSimProcess(){
		return this.process;
	}
	
	/**
	 * the setReg1 method set the value of register one
	 * @param reg1 the value of reg1
	 */
	public void setReg1(int reg1) {
	 this.reg1 = reg1;	
	}
	
	/**
	 * the setReg2 method set the value of register two
	 * @param reg2 the value of reg2
	 */
	public void setReg2(int reg2) {
	 this.reg2 = reg2;	
	}
	
	/**
	 * the setReg3 method set the value of register three
	 * @param reg3 the value of reg3
	 */
	public void setReg3(int reg3) {
	 this.reg3= reg3;	
	}
	
	/**
	 * the setReg4 method set the value of register four
	 * @param reg4 the value of reg4
	 */
	public void setReg4(int reg4) {
	 this.reg4 = reg4;	
	}
	
	/**
	 * the getReg1 method returns the value of register one
	 * @return the getReg1 value
	 */
	public int getReg1() {
		return this.reg1;
	}
	
	/**
	 * the getReg2 method returns the value of register two
	 * @return the getReg2 value
	 */
	public int getReg2() {
		return this.reg2;
	}
	
	/**
	 * the getReg3 method returns the value of register three
	 * @return the getReg3 value
	 */
	public int getReg3() {
		return this.reg3;
	}
	
	/**
	 * the getReg4 method returns the value of register four
	 * @return the getReg4 value
	 */
	public int getReg4() {
		return this.reg4;
	}
	
	/**
	 * the setCurrInstruction method sets the current Instruction number
	 * that process is up to
	 * @param currInstruction the value of the current instruction
	 */
	public void setCurrInstruction(int currInstruction) {
		this.currInstruction = currInstruction;
	}
	
	/**
	 * the getCurrInstruction method returns the current instruction number
	 * that process is up to
	 * @return the currInstruction value
	 */
	public int getCurrInstruction() {
		return this.currInstruction;
	}
	
	
	//create a Random class object to generate random numbers
	Random randNum = new Random();
	
	/**
	 * the executeNextInstruction method calls the execute method of the current 
     * process, passing in the value of currInstruction, increments currInstruction, and returns 
     * the result of the execute method.
	 * @return the state value
	 */
	public ProcessState executeNextInstruction() {
		
		//call the execute method of SimProcess object and pass it the 
		//instruction number it's up to. Assign its result to variable state.
		ProcessState state = process.execute(this.currInstruction);
		
		//increment current instruction
		currInstruction++; 
		
		//generate random numbers for the four registers
		this.reg1 = randNum.nextInt();
		this.reg2 = randNum.nextInt();
		this.reg3 = randNum.nextInt();
		this.reg4 = randNum.nextInt();
		
		return state;
	}
	
	
}
