/**
 * Student.java
 * 
 * 
 * 
 */
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class students implements Runnable {

	private dashboard board;
	private ReentrantLock lockX;   // Please remove it if you use other synchroization tools. 
	private String name;
	private Semaphore studentSem;



	public students(dashboard board,ReentrantLock loc,Semaphore studentSem, String name) {
		this.name = name;
		this.board = board;
		this.lockX = loc;  // Please remove it if you use other synchroization tools. 
		this.studentSem = studentSem;  
	}

	public void run() {
		

		while (true) {
			//programming for a while
			SleepUtilities.nap(25);		
			//seek help from TA
			
            //post the status of the students whenever their status change.
			board.postMessage(name+" need help"); 

			// if the waiting room has space,  wait in hallway. 
			// Otherwise do more programming.
			
			
			if(studentSem.tryAcquire()){ 
				try{
			
					board.waitHallway(name);
				//	System.out.println(name+" in hallway");
					tutorRoom.hallCount++;
				//	System.out.println(tutorRoom.hallCount);
					SleepUtilities.nap(25);
		
			
					//enter the office if TA is available
					//wait in hallway if TA is not available
					//leave if the hallway is full
					lockX.lock();
					studentSem.release();
					board.leaveHallway(name);
					tutorRoom.hallCount--;
				//	System.out.println(name+" leave hallway");
					board.enterRoom(name);
					tutorRoom.roomCount++;
				//	System.out.println("ROOM COUNT: " +tutorRoom.roomCount);
					//System.out.println(name+" in room");
					SleepUtilities.nap(25);

					//leave the office and go back 
					board.leaveRoom(name);
				//	System.out.println(name+" leave room");
					tutorRoom.roomCount--;
					SleepUtilities.nap(25);

					lockX.unlock();
				
				}
				catch(Exception e){
				}
			}
			else{
				System.out.println(name+" has no room");
				
			}

			
		
		}
	}
}


