import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;
import java.sql.*;
import java.util.Scanner;

public class testFindByAll {
    public static void main(String[] args) throws SQLException {
//        String sqlDelete = "delete from testFind where id = ?";
//        String sqlInsert = "INSERT INTO testFind VALUES(?, ?, ?, ?)";
//        String sqlPrint = "select * from testFind";
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/test",
                        "root", ""
                );

                PreparedStatement preparedStatement = connection.prepareStatement("delete from testFind where id = ?");
                PreparedStatement preparedStatement1 = connection.prepareStatement("INSERT INTO testFind VALUES(?, ?, ?, ?)");
                PreparedStatement preparedStatement2 = connection.prepareStatement("select * from testFind");
                Statement statement = connection.createStatement();
        ) {
//
                preparedStatement.setString(1,"find09");
                int rowDelete = preparedStatement.executeUpdate();
            System.out.println(rowDelete+" Colum delete done");
                ResultSet resultset = preparedStatement2.executeQuery();
                while (resultset.next()){
                    String id = resultset.getString("id");
                    String name = resultset.getString("name");
                    int age = resultset.getInt("age");
                    String gender = resultset.getString("gender");
                    System.out.println("Data:"+id + ", " + name + ", " + age + ", " + gender);
                }
            System.out.println();
//
            preparedStatement1.setString(1,"find09");
            preparedStatement1.setString(2,"hieu");
            preparedStatement1.setInt(3,22);
            preparedStatement1.setString(4,"nam");
            int row = preparedStatement1.executeUpdate();
            System.out.println(row+" Colum update done");
            ResultSet resultSet = preparedStatement2.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                System.out.println("Data:"+id + ", " + name + ", " + age + ", " + gender);
            }
            System.out.println();
//

            Scanner scanner = new Scanner(System.in);  // Create a Scanner scanner
            System.out.println("Enter data to search: ");
            String findData = scanner.next();
            System.out.println("Data to search is: " + findData);
            System.out.println();
////
            String findbyID = "SELECT * FROM testFind where id like '%"+findData+"%'";
            String findbyName = "SELECT * FROM testFind where name like '%"+findData+"%'";
            String findbyAge = "SELECT * FROM testFind where age like '%"+findData+"%'";
            String findbyGender = "SELECT * FROM testFind where gender like '%"+findData+"%'";
            String query[] ={findbyID,
                    findbyName,findbyAge
                    ,findbyGender};
            for(String q : query){
////
                ResultSet resultSet1 = statement.executeQuery(q);
                System.out.println("Corresponding searched data at column: "+q+":");
////
                while (resultSet1.next()) {
                    String id = resultSet1.getString("id");
                    String name = resultSet1.getString("name");
                    int age = resultSet1.getInt("age");
                    String gender = resultSet1.getString("gender");
                    System.out.println("Data:"+id + ", " + name + ", " + age + ", " + gender);
//
//                    String str = String.valueOf(age);
//                    String all[] = {id,name,str,gender};
//                    String nullElemnt[]={};
//                    if (all != nullElemnt){
//                        System.out.println("Success");
//                    }else {
//                        System.out.println("NULL");
//                    }
//                    boolean s = Arrays.equals(all,nullElemnt);
//                    if (s==false){
//                        System.out.println("Success");
//                    }else {
//                        System.out.println("NULL");
//                    }
//
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


