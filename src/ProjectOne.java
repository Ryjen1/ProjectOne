import java.sql.*;
import java.util.Scanner;

public class ProjectOne{
    String url = "jdbc:mysql://localhost:3306/project_one";
    String myUser = "root";
    String myPassword = "Obianuju#1";

    Connection connect;

    {
        try {
            connect = DriverManager.getConnection(url,myUser,myPassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createTable(){

        String creator = "create Table if not exists students(Name text,Email Text, Age int, Location Text, Designation Text)";
        try {
            Statement statement = connect.createStatement();
            statement.execute(creator);
            System.out.println("Table Created Successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    int populateTable(){
        int countRows = 0;
        try {
            try (Scanner scan = new Scanner(System.in)) {
                String insert = "insert into table students(name,email,age,location,designation) values(?,?,?,?,?)";
                PreparedStatement preparedStatement = connect.prepareStatement(insert);

                System.out.print("What is your name: ");
                String name = scan.nextLine();
                System.out.print("Enter your email: ");
                String email = scan.nextLine();
                System.out.print("How old are you: ");
                int age = scan.nextInt();
                scan.nextLine();
                System.out.print("Enter your location: ");
                String location = scan.nextLine();
                System.out.print("Enter your designation: ");
                String designation = scan.nextLine();

                preparedStatement.setString(1,name);
                preparedStatement.setString(2,email);
                preparedStatement.setInt(3,age);
                preparedStatement.setString(4,location);
                preparedStatement.setString(5,designation);

                preparedStatement.execute(insert);
            }

        } catch (SQLException e) {
            System.out.println("Something went wrong");
        }
        return countRows;


    }

}
