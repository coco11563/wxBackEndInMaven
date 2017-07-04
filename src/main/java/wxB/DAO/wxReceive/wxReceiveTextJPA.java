package wxB.DAO.wxReceive;

import wxB.POJO.content.recMsgTypeEnum;
import wxB.POJO.receive.postStuff;

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
    public List<postStuff> wxSelect(String key , recMsgTypeEnum recMsgTypeEnum) {
        return null;
    }

    @Override
    public void wxInser(postStuff post, recMsgTypeEnum recMsgTypeEnum) {
        jdbcOperations.update(RECEIVE_INSERT_SQL, post.getMsgID(), post.getFromUserName(), post.getCreateTime() , post.getMsgType(), post.getContent().getText(),
                post.getToUserName());
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
