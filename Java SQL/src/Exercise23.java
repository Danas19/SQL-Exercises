import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Exercise23 {
	public static void run() throws Exception {
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "");
		Statement myStmt = myConn.createStatement();
		int filmoId = insertFilmoId();
		ResultSet myRs = myStmt.executeQuery("select * from filmas "
				+ "where FilmoId = " + filmoId);
		
		System.out.println(myRs.getString(1) + "'" + myRs.getString(2) + "', " + myRs.getString(3) + ", "
				+ myRs.getString(4) + ", " + myRs.getString(5) + ", '" + myRs.getString(6) + "', "
					+ myRs.getString(7) + ")");
	}
	
	public static int insertFilmoId() {
		Reader scanner = new Reader();
		
		System.out.println("FilmoId: ");
		return scanner.nextInt();
	}
}
