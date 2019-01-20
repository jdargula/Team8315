package com.example.notam;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database_Layout_Manager extends Database_Connection {

    public void createTables(){
        try{
            stmt = conn.createStatement();
            //this is the columns of the table
            String sql = "CREATE TABLE IF NOT EXISTS notams (" +
                    "raw_notam VARCHAR(100) PRIMARY KEY NOT NULL, " +
                    "second_column VARCHAR(100) NOT NULL, " +
                    "third_column VARCHAR(100) NOT NULL )";

            stmt.executeUpdate(sql);
            stmt.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void testAddEntry(){
        try{
            PreparedStatement st = conn.prepareStatement(
                    "INSERT INTO NOTAMS " +
                            "(raw_notam, second_column, third_column) " +
                            "VALUES(?, ?, ?)");
            st.setString(1,"test_raw_notam_value");
            st.setString(2,"test_column_2_value");
            st.setString(3,"test_column_3_value");
            st.executeUpdate();
            st.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void countEntres(){
        int number_of_rows = -1;
        try{
            PreparedStatement st = conn.prepareStatement(
                    "SELECT count(*) FROM notams");
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                number_of_rows = rs.getInt(1);
            }
            System.out.println("There are " + number_of_rows +" Rows");
        } catch(SQLException e) {
            e.printStackTrace();

        }
    }


}
