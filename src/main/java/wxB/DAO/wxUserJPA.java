package wxB.DAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wxB.POJO.User;

import java.util.List;

import static wxB.DAO.JdbcWxRepository.jdbcOperations;

/**
 * Created by coco1 on 2017/6/19.
 */

public class wxUserJPA {
    Logger logger = LoggerFactory.getLogger(wxUserJPA.class);
    private final static String USER_INSERT_SQL = "INSERT INTO USER_TABLE (USERNAME, USERTYPE, HISTORYMSGCOUNT) VALUES (?,?,?)";
    private final static String USER_UPDATE_PRIVILEGE_SQL = "UPDATE USER_TABLE SET USERTYPE = ? WHERE USERNAME = ?";
    private final static String USER_COUNT_ADDING = "update USER_TABLE set HISTORYMSGCOUNT = HISTORYMSGCOUNT + 1 WHERE USERNAME = ?";
    private final static String USER_DEL_SQL="DELETE FROM user_table WHERE username = ?";
    private final static String USER_SELECT_SQL = "SELECT USERTYPE from user_table where UserName=?";
    private final static String USER_IS_EXIST = "select case when (SELECT username from user_table where UserName=?) is null then 0 ELSE 1 end";


    public List<User> wxSelect(String key) {
        return null;
    }


    public void wxInser(User user) {
        jdbcOperations.update(USER_INSERT_SQL, user.getUserName(), user.getPrivilege(), "1");
    }

    public void wxUpdate(User user) {
    }
    public void wxCountAdd(User user) {
        jdbcOperations.update(USER_COUNT_ADDING, user.getUserName());
        logger.debug(user.getUserName() + " is send msg one times");
    }
    public void wxDel(User user) {

    }

    public boolean wxIsExist(User user) {
        return jdbcOperations.queryForObject(USER_IS_EXIST, new String[] {user.getUserName()}, Integer.class) != 0;
    }
}
