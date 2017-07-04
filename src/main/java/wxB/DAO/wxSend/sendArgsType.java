package wxB.DAO.wxSend;

/**
 * Created by coco1 on 2017/6/30.
 */
public enum sendArgsType {
    text(new String[]{"fromusername", "createtime", "msgtype", "tousername", "content"}, "send_msg_text"),
    pic(new String[]{"fromusername", "createtime", "msgtype", "tousername", "mediaid"}, "send_msg_pic"),
    video(new String[]{"fromusername", "createtime", "msgtype", "tousername", "title", "mediaid", "description"}, "send_msg_video"),
    voice(new String[]{"fromusername", "createtime", "msgtype", "tousername", "mediaid"}, "send_msg_voice"),
    music(new String[]{"tousername", "fromusername", "createtime", "msgtype", "musicurl", "hqmusicurl", "thumbmediaid", "title", "description"}, "send_msg_music"),
    news(new String[]{}, "sebd_msg_news");
    private String[] args;
    private String table_name;

    sendArgsType(String[] args, String table_name) {
        this.table_name = table_name;
        this.args = args;
    }

    public String[] getArgs() {
        return args;
    }

    public String getTableName() {
        return table_name;
    }
}
