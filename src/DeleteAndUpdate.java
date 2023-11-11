import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class DeleteAndUpdate {
    String url = "jdbc:mysql://localhost:3306/project_one";
    String myName = "root";
    String myPassword ="Obianuju#1";

    public void deleteRecord() {
        try (Connection connect = DriverManager.getConnection(url, myName, myPassword)) {
            String delete = "DELETE FROM students WHERE name = ?";
            PreparedStatement deleteStatement = connect.prepareStatement(delete);
            Scanner scan = new Scanner(System.in);

            System.out.print("Enter the name of student you want to delete: ");
            String name1 = scan.nextLine();
            deleteStatement.setString(1, name1);
            deleteStatement.execute();

            System.out.println("Student record deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Something went wrong");
        }
    }
    void updateRecord(){

    }

}
