/**
 * @author Anthony Garzon
 * */

import java.util.Random;

public class Student extends Thread{
	
	Classroom c = new Classroom();//instantiating an object classroom called c 
	Random rand = new Random();//importing random function for grades
	public int grades = rand.nextInt(90);//grades variable that randomizes between 90 and 0
	//After each exam we check if each one is finished by setting it to true
	public static boolean finishedExam1;
    public static boolean finishedExam2;
    public static boolean finishedExam3;
    
	@Override
	public void run() {
		System.out.println("Students Arrived and waiting");
		try {		
			Thread.sleep((long) (Math.random()*1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		while(Teacher.professorArrives==false){System.out.print("");}//busy wait until professor arrives
		
		if(Classroom.notOpen == true){
			while(Classroom.notOpen){System.out.print("");}
		}else if(Classroom.notOpen == false && Teacher.professorArrives==true){
			Student[] s = new Student[14];//only 14 students total
			for(int i=0; i<s.length; i++){
				Classroom.exam1=true;
				s[i]=new Student();
				//since class capacity is 10 we check with getCapacity() if there are only 10 students in the class
				if(c.getCapacity() <= 10 && Classroom.exam1 == true){
					s[i].setPriority(s[i].getPriority()+1);//incrementing priority to simulate students rushing
					System.out.println(s[i].getName() + " Is entering classroom with priority " + s[i].getPriority());
					try {
						Thread.sleep(1000);
						s[i].setPriority(Thread.NORM_PRIORITY);
						//resetting priority once in classroom
						System.out.println( s[i].getName() + " Is resetting priority to normal priority " + s[i].getPriority());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					//working on exam simulated by sleep of long time
					try {
						Thread.sleep(3000);
						System.out.println(s[i].getName() + " Is Working on Exam1 " + "and got grade: " + s[i].grades + " but got grade of 0 on exams 2 and 3");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
					
					Classroom.exam1=false;
					finishedExam1=true;	
					Classroom.exam2=true;
				}else if(c.getCapacity() <= 10 && Classroom.exam2==true){
					//working on exam2 simulated by sleep of long time
					try {
						Thread.sleep(3000);
						System.out.println(s[i].getName() + " Is Working on Exam2 " + "and got grade: " + s[i].grades);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Classroom.exam2=false;
					finishedExam2=true;
					Classroom.exam3=true;					
				}else if(c.getCapacity()<=10 && (Classroom.exam3=true)){
					//working on exam3 simulated by sleep of long time
					try {
						Thread.sleep(3000);
						System.out.println(s[i].getName() + " Is Working on Exam3 " + "and got grade: " + s[i].grades);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					finishedExam3=true;
					Classroom.exam3=false;
				}
				else{
					//didn't make it to the exams
					System.out.println(s[i].getName() + " Didn't make it " + "and got grades of 0 on all exams");
					Thread.yield();
					Thread.yield();	
				}				

			}//for
			
		}//checking if student can enter or not	for exam1		
		
	}//run method
	
}//class