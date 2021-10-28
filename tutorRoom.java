/**
 * tutorRoom.java
 *
 *
 */
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class tutorRoom
{
	static int hallCount = 0;
	static int roomCount=0;
   public static void main(String args[]) {
   	dashboard board = new dashboard();
      String[] names = {"Mary", "Emma","Jennifer","Mike","Alan","Bruce","Tom"};
      Thread[] collegestudents = new Thread[7];
      ReentrantLock officeLock = new ReentrantLock(); // Remove if you use other tools
      Semaphore studentSem = new Semaphore(3);
     

      String  TAname= "David";

      Thread  teachingAssistant = new Thread(new TA(board,officeLock,studentSem,TAname));
      for(int i = 0; i < 7; i++)
         collegestudents[i] = new Thread(new students(board,officeLock,studentSem,names[i]));

      teachingAssistant.start();
      for (int i = 0; i < 7; i++)
         collegestudents[i].start();
   }
}

