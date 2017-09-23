package learning.exp.dao;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Nameet on 2/10/2016.
 */
public class TestDBConnection {

    @Test
    public void testExecuteQuery() throws SQLException {
        DBConnection dbConnn = new DBConnection();
        dbConnn.connect();

        ResultSet rs = dbConnn.executeQuery("select 1");
        while(rs.next()){
            System.out.println(rs.getString("1"));
        }


    }
}
