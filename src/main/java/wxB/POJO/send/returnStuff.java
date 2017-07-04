package wxB.POJO.send;


import wxB.POJO.content.ret.*;
import wxB.POJO.content.sendMsgTypeEnum;
import wxB.POJO.content.*;
import wxB.POJO.receive.postStuff;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by coco1 on 2017/6/17.
 */

@XmlRootElement(name = "xml")
public class returnStuff extends repost {
    private String MsgId;
    private String ToUserName;
    private String FromUserName;
    private String CreateTime;
    private String MsgType;
    private retContent Content;
    public returnStuff() {}
    public returnStuff(postStuff postInform, sendMsgTypeEnum msgTypeEnum, Object... content) {
        setFromUserName(postInform.getToUserName());
        setToUserName(postInform.getFromUserName());
        setCreateTime(String.valueOf(new Date().getTime()));
        setMsgType(msgTypeEnum.toString());
        switch (msgTypeEnum) {
            case news: setContent( new retNewContent());
                break;
            case text: setContent( new retTextContent((String) content[0]));
                break;
            case image: setContent( new retPicContent());
                break;
            case music: setContent( new retMusicContent());
                break;
            case video: setContent( new retVideoContent());
                break;
            case voice: setContent( new retVoiceContent());
                break;
            default: break;
        }

    }
    public String getToUserName() {
        return ToUserName;
    }
    @XmlElement(name = "ToUserName")
    //cover
    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }
    @XmlElement(name = "FromUserName")
    //cover
    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public String getCreateTime() {
        return CreateTime;
    }
    @XmlElement(name = "CreateTime")
    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }
    @XmlElement(name = "MsgType")
    //cover
    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public retContent getContent() {
        return Content;
    }
    @XmlElement(name = "Content")
    public void setContent(retContent content) {
        Content = content;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }
    @Override
    public String toString() {
        return "<xml>" +
                "<ToUserName>" +
                cdataCover(this.getToUserName()) +
                "</ToUserName>" +
                "<FromUserName>" +
                cdataCover(this.getFromUserName()) +
                "</FromUserName>" +
                "<CreateTime>" +
                this.getCreateTime() +
                "</CreateTime>" +
                "<MsgType>" +
                cdataCover(this.getMsgType()) +
                "</MsgType>" +
                this.getContent().toString() +
                "</xml>";
    }
}
