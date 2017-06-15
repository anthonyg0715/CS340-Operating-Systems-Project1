/**
 * @author Anthony Garzon
 * */

public class Teacher implements Runnable{
	
	public static boolean professorArrives=false;//variable to see if professorArrived
	
	@Override
	public void run() {
		// Professor arrives
		try {		
			Thread.sleep((int) (Math.random()*1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		professorArrives=true;
		System.out.println("Professor Arrived");
		
		//Instructor sleeping during exam allowing student's to cheat as much as they want
		System.out.println("Students take exam and Professor allows student's to cheat");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		this.StudentsEnter();//Method that test whether students in the student class can enter or not		
					
	}
	
	public void StudentsEnter(){
		if(Classroom.notOpen==true){
			Classroom.notOpen=false;//changing notOpen to false so students can enter
		}
	}

}
