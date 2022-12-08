//Name Rachel Reich
//Touro ID: T00416601

package mod3Assignment;

import java.util.*;

public class ContextSwitchSimulation {

	public static void main(String[] args) {

		//create an object of SimProcessor class
		SimProcessor processor = new SimProcessor();

		//list to hold ready processes
		ArrayList<SimProcess> readyProcesses = new ArrayList<SimProcess>();


		//list to hold blocked processes
		ArrayList<SimProcess> blockedProcesses = new ArrayList<SimProcess>();

		//list for PCB
		ArrayList<ProcessControlBlock> PCBlist = new ArrayList<>();

		//amount of processes
		int ttlNumProcesses = 10;

		//substantiate ten processes and assign each
		//process a pcb and add it to array of pcbs
		for(int i = 0; i < ttlNumProcesses; i++) {
			SimProcess newProcess = createSimProcess(i);
			readyProcesses.add(newProcess);
			ProcessControlBlock pcb = new ProcessControlBlock(newProcess);
			PCBlist.add(pcb);
		}

		//each processor gets up to 5 cycles of processor
		final int QUANTUM = 5;

		//put first process in processor
		putFirstProcessInProcessor(processor, readyProcesses);
		System.out.println(processor.getSimProcess().getPID());

		//run processor 3000 times
		runProcessor3000(processor, QUANTUM, readyProcesses, PCBlist, 
				blockedProcesses );

	}

	/**
	 * the CreateSimProcess creates a process and returns it
	 * @param x the number process its up to creating
	 * @return the SimProcess obj
	 */
	public static SimProcess createSimProcess(int x) {
		if (x == 0) {
			SimProcess process = createProc1();
			return process;
		}
		else if (x == 1) {
			SimProcess process =createProc2();
			return process;
		}
		else if (x == 2) {
			SimProcess process =createProc3();
			return process;
		}
		else if (x == 3) {
			SimProcess process =createProc4();
			return process;
		}
		else if (x == 4) {
			SimProcess process =createProc5();
			return process;
		}
		else if (x == 5) {
			SimProcess process =createProc6();
			return process;
		}
		else if (x == 6) {
			SimProcess process =createProc7();
			return process;
		}
		else if (x == 7) {
			SimProcess process =createProc8();
			return process;
		}
		else if (x == 8) {
			SimProcess process =createProc9();
			return process;
		}
		else {
			SimProcess process =createProc10();
			return process;
		}

	}

	private static SimProcess createProc1() {
		int pid = 1; 
		String name = "Proc1";
		int ttlInstruction = 255;
		SimProcess process = new SimProcess(pid, name, ttlInstruction);
		return process;

	}

	private static SimProcess createProc2() {
		int pid = 2; 
		String name = "Proc2"; 
		int ttlInstruction = 291;
		SimProcess process = new SimProcess(pid, name, ttlInstruction);
		return process;
	}

	private static SimProcess createProc3() {
		int pid = 3; 
		String name = "Proc3"; 
		int ttlInstruction = 198;
		SimProcess process = new SimProcess(pid, name, ttlInstruction);
		return process;
	}

	private static SimProcess createProc4() {
		int pid = 4; 
		String name = "Proc4"; 
		int ttlInstruction = 304;
		SimProcess process = new SimProcess(pid, name, ttlInstruction);
		return process;
	}

	private static SimProcess createProc5() {
		int pid = 5; 
		String name = "Proc5"; 
		int ttlInstruction = 234;
		SimProcess process = new SimProcess(pid, name, ttlInstruction);
		return process; 
	}

	private static SimProcess createProc6(){
		int pid = 6; 
		String name = "Proc6"; 
		int ttlInstruction = 208;
		SimProcess process = new SimProcess(pid, name, ttlInstruction);
		return process;
	}

	private static SimProcess createProc7() {
		int pid = 7; 
		String name = "Proc7"; 
		int ttlInstruction = 223;
		SimProcess process = new SimProcess(pid, name, ttlInstruction);
		return process;
	}

	private static SimProcess createProc8() {
		int pid = 8; 
		String name = "Proc8"; 
		int ttlInstruction = 326;
		SimProcess process = new SimProcess(pid, name, ttlInstruction);
		return process;
	}

	private static SimProcess createProc9() {
		int pid = 9; 
		String name = "Proc9";
		int ttlInstruction = 206;
		SimProcess process = new SimProcess(pid, name, ttlInstruction);
		return process;
	}

	private static SimProcess createProc10() {
		int pid = 10; 
		String name = "Proc10"; 
		int ttlInstruction = 101;
		SimProcess process = new SimProcess(pid, name, ttlInstruction);
		return process;
	}

	/**
	 * the putFirstProcessInProcessor method puts the first process in ready list on the processor
	 * @param processor the SimProcessor object
	 * @param readyProcesses the list of ready processes
	 */
	public static void putFirstProcessInProcessor(SimProcessor processor, ArrayList<SimProcess> readyProcesses) {
		//get first process in ready list
		SimProcess firstReadyProcess = readyProcesses.get(0);

		//put the first ready process in processor
		processor.setSimProcess(firstReadyProcess);	
	}

	/**
	 * the runProcessor3000 method runs the processor 3,000 cycles
	 * @param processor the SimProcessor obj
	 * @param quantum the FINAL int QUANTUM. Max number of times a process can run on a processor in a row
	 * @param readyProcesses the list of ready processes
	 * @param PCBlist the list of PCBs
	 * @param blockedProcesses the list of blocked Processes
	 */
	public static void runProcessor3000(SimProcessor processor, int quantum, ArrayList<SimProcess> readyProcesses,
			ArrayList<ProcessControlBlock> PCBlist, ArrayList<SimProcess> blockedProcesses){

		//initialize state of process to ready
		ProcessState state = ProcessState.READY;

		//run processor for 3,000 cycles
		for (int x = 0; x < 3000; x++) {

			//as long as state is ready processor should execute next instruction and decrease the quantum
			if(state == ProcessState.READY && quantum >= 1) {

				//run the  process on processor. Add process to appropriate lis if necessary, and display msg about its state. Return its state
				state = runProcessInProcessor(processor, readyProcesses, blockedProcesses, quantum, x);

				//decrease quantum by one
				quantum--;
			}

			//perform context switch if blocked, finished or quantum expired
			else {

				if(state == ProcessState.BLOCKED || quantum == 0) {

					//reset quantum to five
					quantum = 5;

					//save the process that is running
					saveRunningProcess(processor, PCBlist, x);

				}
				//restore next process
				restoreNextProcess(readyProcesses, PCBlist, processor, blockedProcesses);

				//processor runs another cycle and executes the next instruction
				x++;

				if(x<3000) {
					//run the  process on processor. Add process to appropriate lis if necessary, and display msg about its state. Return its state
					state = runProcessInProcessor(processor, readyProcesses, blockedProcesses, quantum, x);

					//decrease quantum by one
					quantum--;
				}
			}
		}

		unblock30Percent(blockedProcesses, readyProcesses);
	}

	/**
	 * the runProcessInProcessor method executes the next instruction of process on processor
	 * @param processor the processor object
	 * @param readyProcesses list of ready processes
	 * @param blockedProcesses list of blocked Processes
	 * @param quantum the Final value for QUANTUM
	 * @param x the step number processor is up to
	 *@return the ProcessState of the process on processor
	 */
	public static ProcessState runProcessInProcessor(SimProcessor processor, ArrayList<SimProcess> readyProcesses, 
			ArrayList<SimProcess> blockedProcesses, int quantum, int x) {

		//display step number
		System.out.print("Step " + (x + 1) + " ");

		//run the next instruction of process in processor
		ProcessState state = processor.executeNextInstruction();


		// if process is finished or blocked or quantum expired, remove it from ready list. 
		//Add process to appropriate list. Display Message about state
		if (state != ProcessState.READY || quantum == 1) {
			determineProcessList(state, readyProcesses, blockedProcesses, quantum, processor);	
		}


		//return the state the process is in
		return state;

	}


	/**
	 * the determineProcessList method removes method from ready list if needed, and adds method to appropriate list	
	 * @param state the ProcessState of process on processor
	 * @param readyProcesses the list of ready processes
	 * @param blockedProcesses the list of blocked processes
	 * @param quantum the number of cycles the process has been on processor for
	 */
	public static void determineProcessList(ProcessState state, ArrayList<SimProcess> readyProcesses, 
			ArrayList<SimProcess> blockedProcesses, int quantum, SimProcessor processor){

		//if process is finished, remove from ready list and display msg that process is completed
		if (state == ProcessState.FINISHED) {
			readyProcesses.remove(0);
			System.out.println("*** Process completed ***");
		}
		//if process is blocked add to blocked list and remove from ready list. display msg that process is blocked
		else if (state == ProcessState.BLOCKED) {
			blockedProcesses.add(processor.getSimProcess());		
			readyProcesses.remove(0);
			System.out.println("*** Process blocked ***");
		}
		//if quantum equals zero, remove process from beginning of ready list and add to end. display msg that quantum expired.
		else if(quantum == 1) {
			readyProcesses.add(readyProcesses.remove(0));
			System.out.println("*** Quantum expired ***");
		}
	}


	/**
	 * the saveRunningProcess method updates the corresponding PCB with values of 
	 * registers and current instruction
	 * @param processor the SimProcessor object
	 * @param PCBlist the list of PCBs
	 * @param x the step number the processor is up to
	 */
	public static void saveRunningProcess(SimProcessor processor, ArrayList<ProcessControlBlock> PCBlist, int x) {
		//get the process that is in the processor
		SimProcess processInProcessor = processor.getSimProcess();

		//get the corresponding PCB to the process that's running
		ProcessControlBlock correspondingPCB = null;
		for(int y = 0; y < PCBlist.size(); y++ ) {
			if (PCBlist.get(y).getSimProcess() == processInProcessor ) {
				correspondingPCB = PCBlist.get(y);
			}
		}

		//update values of all registers, and the currentIntsruction
		correspondingPCB.setReg1(processor.getReg1());
		correspondingPCB.setReg2(processor.getReg2());
		correspondingPCB.setReg3(processor.getReg3());
		correspondingPCB.setReg4(processor.getReg4());
		correspondingPCB.setCurrInstruction(processor.getCurrInstruction());

		//display msg
		System.out.println("Step " + (x + 1) + " Context switch: Saving process: " + processor.getSimProcess().getPID());
		System.out.println("\tInstruction: " + processor.getCurrInstruction() + ", " +
				"R1: " + processor.getReg1() + " R2: " + processor.getReg2() + " R3: " + processor.getReg3()
				+ " R4: " + processor.getReg4());
	}

	/**
	 * the restoreNextProcess method puts the next ready process on the processor and restores its register
	 * values and current instruction number from the pcb list
	 * @param readyProcesses the list of ready processes
	 * @param PCBlist the list of PCBs 
	 * @param processor the SimProcessor object
	 * @param blockedProcesses the list of blocked processes
	 */
	public static void restoreNextProcess(ArrayList<SimProcess> readyProcesses, ArrayList<ProcessControlBlock> PCBlist,
			SimProcessor processor, ArrayList<SimProcess> blockedProcesses ) {

		//get the next PCB and ready process

		//if the readyProcesses list is empty, display msg that machine is idling 
		//and loop through block list and unblock each process with 30 percent
		while (readyProcesses.isEmpty()) {
			//if the blockedProcesses list is also empty, display msg and end program
			if(blockedProcesses.isEmpty()) {
				System.out.println("All process have successfully completed. \nGoodbye!");
				System.exit(0);
			}
			System.out.println("The processor is idling...");

			//unblock each process in BlockedProcesses with 30% probability	
			unblock30Percent(blockedProcesses, readyProcesses);

		}
		//get the next ready process
		SimProcess nextReadyProcess = readyProcesses.get(0);

		//get the ready process's corresponding PCB
		ProcessControlBlock nextReadyPCB = null;
		for(int y = 0; y < PCBlist.size(); y++ ) {
			if (PCBlist.get(y).getSimProcess() == nextReadyProcess ) {
				nextReadyPCB = PCBlist.get(y);
			}
		}

		//set next process in processor and restore values of registers and current instruction
		processor.setSimProcess(nextReadyProcess);
		processor.setReg1(nextReadyPCB.getReg1());
		processor.setReg2(nextReadyPCB.getReg2());
		processor.setReg3(nextReadyPCB.getReg3());
		processor.setReg4(nextReadyPCB.getReg4());
		processor.setCurrInstruction(nextReadyPCB.getCurrentInstruction());

		//display msg
		System.out.println("Restoring process: " + processor.getSimProcess().getPID());
		System.out.println("\tInstruction: " + processor.getCurrInstruction() + ", " +
				"R1: " + processor.getReg1() + " R2: " + processor.getReg2() + " R3: " + processor.getReg3()
				+ " R4: " + processor.getReg4());
	}

	/**
	 * the unblock30Percent method loops through the blocked list and unblocks each process with 30% probability
	 * @param blockedProcesses the list of blocked processes
	 * @param readyProcesses the list of readyProcesses
	 */
	private static void unblock30Percent(ArrayList<SimProcess> blockedProcesses, ArrayList<SimProcess> readyProcesses) {
		//create a random object
		Random randDouble = new Random();

		//get a random double to test for 30 percent
		Double testValue = randDouble.nextDouble();

		//for each process in blockedProcesses list, unblock it with thirty percent and add it to the ready list
		for (int y = 0; y < blockedProcesses.size(); y++) {
			if (testValue < .30) {
				readyProcesses.add(0, blockedProcesses.get(y));
				blockedProcesses.remove(y);
			}
		}

	}

}