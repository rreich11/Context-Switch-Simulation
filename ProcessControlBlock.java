//Name Rachel Reich
//Touro ID: T00416601

package mod3Assignment;

public class ProcessControlBlock {

	private SimProcess process;
	private int currentInstruction = 0;
	private int reg1=0, reg2=0, reg3=0, reg4=0;
	
	/**
	 * Constructor, one parameter = A SimProcess object, sets the value of process
	 * @param process the SimProcess Object
	 */
	public ProcessControlBlock(SimProcess process) {
		this.process = process;
	}
	
	/**
	 * the getSimProcess method returns the SimProcess class object
	 * @return the SimProcess object
	 */
	public SimProcess getSimProcess() {
		return this.process;
	}

	/**
	 * the setCurrentInstruction method sets the current Instruction number
	 * that process is up to
	 * @param currentInstruction the value of the current instruction
	 */
	public void setCurrInstruction(int currentInstruction) {
		this.currentInstruction = currentInstruction;
	}
	
	/**
	 * the getCurrentInstruction method returns the current instruction number
	 * that process is up to
	 * @return the currentInstruction value
	 */
	public int getCurrentInstruction() {
		return this.currentInstruction;
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
}
