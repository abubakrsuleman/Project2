import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static Connection connect()
	{
		//String fileName = "C:/Users/Abubakr/git/Project2/Project2(Group 52)/Database/LoginDetails.db";
		//String url = "jdbc:sqlite:" + fileName;
		String fileName = "jdbc:sqlite:SMSDatabase.db";
		// SQLite connection string
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(fileName);
            System.out.println("Db connection successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
	}
}


