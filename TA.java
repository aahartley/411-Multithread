/**
 * Worker.java
 * 
 * This thread is used to demonstrate the operation of a semaphore.
 * 
 */

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TA implements Runnable {

	private dashboard board;
	private String name;
	private ReentrantLock lockx;
	private Semaphore studentSem;

	public TA(dashboard board,ReentrantLock loc,Semaphore studentSem, String name) {
		this.name = name;
		this.board = board;
		this.lockx = loc;
		this.studentSem = studentSem;
	}

	public void run() {
		

		while (true) {
			
			
		if(tutorRoom.roomCount==0&& tutorRoom.hallCount==0) {
			board.officeMessage("TA "+name +" is sleeping");
			SleepUtilities.nap();
		}
		else if(tutorRoom.roomCount==0) {
				board.officeMessage("TA "+name +" is done with students");
				SleepUtilities.nap();
			}
		else if(tutorRoom.roomCount>0) {
			board.officeMessage("TA "+name +" is working with students");
			SleepUtilities.nap();
			
			}
	
	
		}
	}

}
