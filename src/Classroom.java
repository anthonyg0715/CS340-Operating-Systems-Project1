/**
 * @author Anthony Garzon
 * */

public class Classroom {
	
	private int capacity=1;
	public static boolean notOpen;//boolean variable notOpen to if student's can enter or not
	public static boolean exam1 = false;//exam1 boolean variable to see if exam1 started or not
	public static boolean exam2 = false;//exam2 boolean variable to see if exam2 started or not
	public static boolean exam3 = false;//exam3 boolean variable to see if exam3 started or not

	public synchronized int getCapacity() {
		return capacity++;
	}//synchronized method to implement mutual exclusion 
	
}
