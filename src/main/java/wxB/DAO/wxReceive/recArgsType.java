package wxB.DAO.wxReceive;

/**
 * Created by coco1 on 2017/6/30.
 */
public enum recArgsType {
    text(new String[]{"msg_id","fromusername" , "createtime" , "msgtype" , "tousername" , "content"} , "receive_msg_text") ,
    location(new String[]{"msg_id","fromusername" , "createtime" , "msgtype" , "tousername", "location_x" , "location_y" , "scale" , "label"} ,  "receive_msg_location"),
    pic(new String[]{"msg_id","fromusername" , "createtime" , "msgtype" , "tousername", "picurl" , "mediaid"} ,  "receive_msg_pic") ,
    shortVideo(new String[]{"msg_id","fromusername" , "createtime" , "msgtype" , "tousername" , "ThumbMediaId" , "mediaid"} ,  "receive_msg_shortvideo"),
    url(new String[]{"msg_id","fromusername" , "createtime" , "msgtype" , "tousername" , "title" , "description" , "url"} ,  "receive_msg_url"),
    video(new String[]{"msg_id","fromusername" , "createtime" , "msgtype" , "tousername" , "ThumbMediaId" , "mediaid"} ,  "receive_msg_video"),
    voice(new String[]{"msg_id","fromusername" , "createtime" , "msgtype" , "tousername" , "format" , "mediaid" , "Recongnition"} ,  "receive_msg_voice");
    private String[] args;
    private String table_name;
    recArgsType(String[] args , String table_name) {
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
