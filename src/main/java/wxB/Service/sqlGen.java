package wxB.Service;

import wxB.DAO.wxReceive.recArgsType;

/**
 * Created by coco1 on 2017/6/30.
 */
public class sqlGen {
    //INSERT INTO RECEIVE_MSG_TEXT (msg_id, fromusername,createtime,msgtype,content,tousername) VALUES (?,?,?,?,?,?)
    public static String insertRecSqlGen(recArgsType recArgsType) {
        String tablename = recArgsType.getTableName();
        StringBuilder sql = new StringBuilder("insert into " + tablename + "(");
        String[] args = recArgsType.getArgs();
        int j = 0;
        for (j = 0 ; j < args.length - 1 ; j ++) {
            sql.append(args[j]).append(",");
        }
        sql.append(args[j]);
        sql.append(") values (");
        for (int i = 0 ; i < args.length  - 1; i ++) {
            sql.append("?,");
        }
        sql.append("?)");
        return sql.toString();
    }

}
