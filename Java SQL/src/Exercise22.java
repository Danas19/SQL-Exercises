import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Exercise22 {
	public static void run() throws Exception {
		List<String> values = new ArrayList<>();
		
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "");
		Statement myStmt = myConn.createStatement();
		
		setValues(values, myConn, myStmt); //set values from list
		insertValues(myStmt, values);
		
		System.out.println("Filmas \"" + values.get(1) + "\" buvo ikeltas.\n\n");
	}
	
	private static void insertValues(Statement myStmt, List<String> values) throws Exception {
		myStmt.executeUpdate("insert into filmas values(" + values.get(0) + ", '" + values.get(1) + "', "
				+ values.get(2) + ", " + values.get(3) + ", " + values.get(4) + ", '" + values.get(5) + "', "
					+ values.get(6) + ");");
	}
	
	private static void setValues(List<String> values, Connection myConn, Statement myStmt) throws Exception {
		Reader scanner = new Reader();
		
		boolean doWhileFirstTime = true;
		
		do  {
			System.out.print("FilmoId: ");
			if (doWhileFirstTime) {
				values.add(scanner.nextLine());
				doWhileFirstTime = false;
			} else {
				values.set(0, scanner.nextLine());
			}
			
		} while (checkIfFilmoIdExists(values.get(0), myConn, myStmt));
		
		System.out.print("Pavadinimas: ");
		values.add(scanner.nextLine());
		System.out.print("Pastatymo Metai: ");
		values.add(scanner.nextLine());
		System.out.print("Trukme: ");
		values.add(scanner.nextLine());
		System.out.print("KalbosId: ");
		values.add(scanner.nextLine());
		System.out.print("Premjera: ");
		values.add(scanner.nextLine());
		System.out.print("Sukurimo Valstybes Id: ");
		values.add(scanner.nextLine());
	}
	
	private static boolean checkIfFilmoIdExists(String filmoId, Connection myConn, Statement myStmt) throws Exception {
		ResultSet myRs = myStmt.executeQuery("select FilmoId from filmas "
				+ "where FilmoId = " + filmoId);
		
		if (myRs.next()) {
			System.out.println("Filmo Id already exists. List of unavailable movie Ids:");
			myRs = myStmt.executeQuery("select FilmoId from filmas "
					+ "order by FilmoId desc");
			while (myRs.next()) {
				System.out.print(myRs.getString(1) + " ");
			}
			System.out.println("\n\n");
			return true;
		}
		return false;
	}
}
