package utilities;

import java.sql.*;
import java.util.ArrayList;

public class JDBC1 {

    public static void main(String[] args) throws SQLException {

        Connection cnn = DriverManager.getConnection(
                "jdbc:postgresql://localhost/HR_production",
                "postgres",
                "admin"
        );

        Statement stt = cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet rs = stt.executeQuery("Select * from jobs");

        rs.next();
        System.out.println(rs.getString("job_title"));



     //  printCountries(stt);

      //  printDepartmentsByCountries(stt);

        updateAllemails(stt);
    }

    private static void updateAllemails(Statement stt) throws SQLException {
        //1 write a query to get all emails in a result set
        String emailQuery = "Select email from employees";
        ResultSet rs = stt.executeQuery(emailQuery);

        //iterate through your rs and put all emails into arraylist
        ArrayList<String> emailList = new ArrayList<>();
        while (rs.next()){
            emailList.add(rs.getString("email"));
        }

      //iterate through arraylist and change emails from @tutorial.org to @mindtek.edu
        System.out.println(emailList);

        ArrayList<String> newEmailsList = new ArrayList<>();
        for (String email : emailList) {
            email = email.substring(0,email.indexOf('@')) + "@mindtek.edu";
            newEmailsList.add(email);
            }
        System.out.println(emailList);
        System.out.println(newEmailsList);

        //put to db
       String updateQuery = "update employees set email= newEmail where employees.email = oldEmail ";
        int i =0;
        for (String em : emailList) {
            updateQuery = "update employees set email= '"+ newEmailsList.get(i)+ "' where employees.email ='"+ emailList.get(i)+ "'";
            System.out.println(updateQuery);
          //  stt.executeUpdate(updateQuery);
            i++;
        }

        }

    private static void printDepartmentsByCountries(Statement stt) throws SQLException {
        ResultSet rs = stt.executeQuery("select locations.country_id, count(departments.department_name) from locations, departments \n" +
                "where locations.location_id= departments.location_id\n" +
                "group by locations.country_id;");
        while(rs.next()){
            System.out.println(rs.getString("country_id") + " -> "+ rs.getString("count"));
        }
    }

    private static void printCountries(Statement stt) throws SQLException {

        ResultSet rs = stt.executeQuery("Select country_name from countries");

        int count=1;
        while (rs.next()) {
            System.out.println(count + " -> " + (rs.getString("country_name")));
            count++;
        }
    }
}
