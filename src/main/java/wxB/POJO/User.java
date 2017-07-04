package wxB.POJO;

import wxB.POJO.receive.postStuff;

/**
 * Created by coco1 on 2017/6/19.
 */
public class User {
    private String UserName;
    private String HistoryMsgNum;
    private String Privilege;
    public User(postStuff postText) {
        setUserName(postText.getFromUserName());
        setPrivilege("0");
        setHistoryMsgNum("1");
    }
    public User() {}
    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getHistoryMsgNum() {
        return HistoryMsgNum;
    }

    public void setHistoryMsgNum(String historyMsgNum) {
        HistoryMsgNum = historyMsgNum;
    }

    public String getPrivilege() {
        return Privilege;
    }

    public void setPrivilege(String privilege) {
        Privilege = privilege;
    }
}
