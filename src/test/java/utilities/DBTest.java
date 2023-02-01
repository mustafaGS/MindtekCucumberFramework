package utilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBTest {

    public static void main(String[] args) throws SQLException {
        DB db = new DB();

     //   String query = "insert into countries values ('NK', 'North Korea', 3)";
     //   db.runInsertQuery(query);

        // select first_name, last_name, email, phone_number from employees
        //db.runSelectQuery("1","2", "jobs")

        ArrayList<String> columnNames = new ArrayList<>();
        columnNames.add("first_name");
        columnNames.add("last_name");
        columnNames.add("phone_number");
        columnNames.add("first_name");


        ResultSet rs = db.runSelectQuery(columnNames,"employees");
        while (rs.next()) System.out.println(rs.getString("first_name") + " " + rs.getString("phone_number"));


        //   List<Map<String, Object>> list= db.getTableForQuery(q);
        //  System.out.println(list);

        db.close(); // we should always do this for security purposes

        ResultSet rs1 = db.getRs();
        Connection cnn1 = db.getCnn();


    }
}
