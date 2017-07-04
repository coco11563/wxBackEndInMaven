package wxB.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

/**
 * Created by coco1 on 2017/6/19.
 */
@Repository
public class JdbcWxRepository  {
    public static JdbcOperations jdbcOperations;
    @Autowired
    public JdbcWxRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }
}
