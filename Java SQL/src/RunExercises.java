import java.sql.Connection;
import java.sql.DriverManager;

public class RunExercises {
	public static void main(String[] args) {
		int whatToDo;
		Reader scanner = new Reader();
		
		while (true) {
			printOptions();
			whatToDo = scanner.nextInt();
			
			switch (whatToDo) {
			case 22:
				try {
					Exercise22.run();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 23:
				try {
					Exercise23.run();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
			
			if (whatToDo == 0) {
				break;
			}
		}
	}
	
	public static void printOptions() {
		System.out.println("What to do?");
		System.out.println("Enter 0 to exit");
		System.out.println("Enter \"22\" to run Exercise22");
	}
}
