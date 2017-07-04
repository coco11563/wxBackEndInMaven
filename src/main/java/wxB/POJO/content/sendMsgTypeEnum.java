package wxB.POJO.content;

/**
 * Created by coco1 on 2017/6/18.
 */
public enum sendMsgTypeEnum {
    text("text"),image("image"),video("video")
    ,voice("voice"),music("music"),news("news");
    private String msgtype;
    sendMsgTypeEnum(String s) {
        this.msgtype = s;
    }
    @Override
    public String toString() {
        return this.msgtype;
    }
}
