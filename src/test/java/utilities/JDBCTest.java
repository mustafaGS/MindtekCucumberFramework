package utilities;

import java.sql.*;
import java.util.ArrayList;

public class JDBCTest {

    public static void main(String[] args) throws SQLException {
        //create connection:

        Connection cnn = DriverManager.getConnection(
                "jdbc:postgresql://localhost/HR_production",
                "postgres",
                "admin"
        );
        // statement
        Statement stt = cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        //read data
//        ResultSet rs = stt.executeQuery("Select * from jobs");

//        while(rs.next()) {
//            System.out.println(rs.getString("job_title"));
//            System.out.println(rs.getString("min_salary"));
//        }
        // print "full name of parent" is a parent of "full_name of child"
        //Penelope Gietz is a parent of Jack Gietz

//        ResultSet rs = stt.executeQuery(
//                "select concat(e.first_name, ' ', e.last_name) as p_full_name, concat(d.first_name, ' ', d.last_name) as d_full_name from employees e, dependents d where e.employee_id = d.employee_id");
//
//        while (rs.next()) System.out.println(rs.getString("p_full_name") + " is a parent of " + rs.getString("d_full_name"));
//
//


        // find out if there are any emials not ending with @sqltutorial.org
        // 1 query to get all emails and put them into rs
        // 2 put those to arraylist
        // 3 find out if there any emails not ending with @sqltutorial.org
        // 4 if there is such email then print "Found different email"
        // 5 if all emails end with @sqltutorial.org then print "All emails are same "


        // System.out.println(rs.getString("job_title"));
        //  System.out.println(rs.getInt(1));
        findDifferentEmail(cnn, stt);
        System.out.println("-----");
    }
        private static void findDifferentEmail(Connection cnn, Statement stt) throws SQLException {
            ResultSet rs = stt.executeQuery("Select email from employees");

            ArrayList<String> emailList = new ArrayList<>();

            while(rs.next()) emailList.add(rs.getString("email"));

            boolean isWrongEmail = false;

            for (String em : emailList) {
                if (!em.endsWith("@sqltutorial.org")) {
                    System.out.println("Wrong email: " + em);
                    isWrongEmail = true;
                }
            }
           if(isWrongEmail) System.out.println("Found different email");
            else System.out.println("All emails are the same");
        }

    }

