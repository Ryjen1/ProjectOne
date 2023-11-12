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
        try (Connection connect = DriverManager.getConnection(url,myName,myPassword)){
            String update = "UPDATE students SET email = ? WHERE name = ?";
            PreparedStatement updateStatement = connect.prepareStatement(update);
            Scanner scan = new Scanner(System.in);

            System.out.print("Enter the name of student record you want to update");
            String name1 = scan.nextLine();
            System.out.print("Enter new email address for student");
            String email = scan.nextLine();

            updateStatement.setString(1,name1);
            updateStatement.setString(2,email);
            updateStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        DeleteAndUpdate deleteOrUpdateRecord = new DeleteAndUpdate();
        //deleteOrUpdateRecord.deleteRecord();
        deleteOrUpdateRecord.updateRecord();
    }

}
