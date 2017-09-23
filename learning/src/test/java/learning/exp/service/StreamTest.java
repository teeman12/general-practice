package learning.exp.service;

import learning.exp.dao.DBConnection;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.*;

/**
 * Created by Nameet on 5/29/2016.
 */
public class StreamTest {

    @Test
    public void testExecuteQuery() throws SQLException {
        System.out.println("This is a test stream");

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);

        List<Integer> num = numbers.stream()
                .filter(e -> e%2 == 0)
                .map(e -> e * 2)
                .collect(toList());

        System.out.println(" after processing " + num);


    }

}
