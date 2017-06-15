/**
 * @author Anthony Garzon 
 * */

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// Instantiating objects of students and teacher and passing them into threads
		Student s = new Student();
		Teacher t = new Teacher();
		Thread t1 = new Thread(s);
		Thread t2 = new Thread(t);
		t1.start();//begin execution of student thread
		t2.start();//begin execution of teacher thread
		
		//tests if threads t1 and t2 are alive before killing them
		if(t1.isAlive() && t2.isAlive()){
			t1.join();//wait for thread t1 to die
			t2.join();//wait for thread t2 to die
			System.out.println("Students go home");
			System.out.println("Instructor goes home");
		}

	}

}
