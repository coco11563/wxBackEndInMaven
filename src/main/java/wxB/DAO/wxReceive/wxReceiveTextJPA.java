package wxB.DAO.wxReceive;

import org.apache.commons.lang3.ArrayUtils;
import wxB.POJO.content.recMsgTypeEnum;
import wxB.POJO.receive.postStuff;
import wxB.Service.sqlGen;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static wxB.DAO.JdbcWxRepository.jdbcOperations;

/**
 * Created by coco1 on 2017/6/19.
 */
public class wxReceiveTextJPA implements wxRecJPA<postStuff> {
    private final static String RECEIVE_INSERT_SQL = "INSERT INTO RECEIVE_MSG_TEXT (msg_id, fromusername,createtime,msgtype,content,tousername) VALUES (?,?,?,?,?,?)";
    private final static String RECEIVE_UPDATE__SQL = "";
    private final static String RECEIVE_DEL_SQL="";
    private final static String RECEIVE_SELECT_SQL = "";

    @Override
    public List<postStuff> wxSelect(String sql , recMsgTypeEnum recMsgTypeEnum) {
        return null;
    }
    //"msg_id","fromusername" , "createtime" , "msgtype" , "tousername" , "content"
    @Override
    public void wxInser(postStuff post, recMsgTypeEnum recMsgTypeEnum) {
        String insertSQL = null;
        recArgsType argsType = null;
        switch (recMsgTypeEnum) {
            case url: argsType = recArgsType.url; insertSQL = sqlGen.insertRecSqlGen(argsType); break;
            case text:argsType = recArgsType.text; insertSQL = sqlGen.insertRecSqlGen(argsType); break;
            case image:argsType = recArgsType.pic; insertSQL = sqlGen.insertRecSqlGen(argsType); break;
            case video:argsType = recArgsType.video; insertSQL = sqlGen.insertRecSqlGen(argsType); break;
            case voice:argsType = recArgsType.voice; insertSQL = sqlGen.insertRecSqlGen(argsType); break;
            case location:argsType = recArgsType.location; insertSQL = sqlGen.insertRecSqlGen(argsType); break;
            case shortvideo:argsType = recArgsType.shortVideo; insertSQL = sqlGen.insertRecSqlGen(argsType); break;
        }
        String[] args = {post.getMsgID(), post.getFromUserName(), post.getCreateTime() , post.getMsgType(),
                post.getToUserName()};
        ArrayUtils.addAll(args, post.getContent().toSQL());
        jdbcOperations.update(insertSQL,args);
    }

    @Override
    public void wxUpdate(postStuff post , recMsgTypeEnum recMsgTypeEnum) {

    }

    @Override
    public void wxDel(postStuff postText, recMsgTypeEnum recMsgTypeEnum) {

    }
//    public static String inserSQLGen(recMsgTypeEnum type) {
//        String insert_sql = null;
//        switch (type) {
//            case voice: insert_sql =
//            case video:
//            case image:
//            case text:
//            case url:
//            case location:
//            case shortvideo:
//        }
//        return insert_sql;
//    }

}
