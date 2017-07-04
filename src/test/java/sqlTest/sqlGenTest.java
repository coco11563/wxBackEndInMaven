package sqlTest;

import org.junit.Test;
import wxB.DAO.wxReceive.recArgsType;

import static wxB.Service.sqlGen.insertRecSqlGen;

/**
 * Created by coco1 on 2017/6/30.
 */
public class sqlGenTest {
    @Test
    public void insertRecSqlGenTest() {
        System.out.println(insertRecSqlGen(recArgsType.text));
    }

}
