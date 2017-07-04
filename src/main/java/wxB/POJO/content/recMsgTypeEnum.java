package wxB.POJO.content;

/**
 * Created by coco1 on 2017/6/18.
 */
public enum recMsgTypeEnum {
    text("text"),image("image"),video("video")
    ,voice("voice"),url("url"),shortvideo("news"),location("location");
    private String msgtype;
    recMsgTypeEnum(String s) {
        this.msgtype = s;
    }
    @Override
    public String toString() {
        return this.msgtype;
    }
}
