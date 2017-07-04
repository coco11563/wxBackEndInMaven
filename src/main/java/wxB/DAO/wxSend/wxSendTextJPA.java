package wxB.DAO.wxSend;

import wxB.POJO.send.returnStuff;

import java.util.List;

/**
 * Created by coco1 on 2017/6/19.
 */
public class wxSendTextJPA implements wxSendJPA<returnStuff> {
    private final static String SEND_INSERT_SQL = "";
    private final static String SEND_UPDATE__SQL = "";
    private final static String SEND_DEL_SQL="";
    private final static String SEND_SELECT_SQL = "";


    @Override
    public List<returnStuff> wxSelect(String key) {
        return null;
    }

    @Override
    public void wxInser(returnStuff returnStuff) {

    }

    @Override
    public void wxUpdate(returnStuff returnStuff) {

    }

    @Override
    public void wxDel(returnStuff returnStuff) {

    }
    public String inserSQLGen(String className) {
        return className;
    }

}
