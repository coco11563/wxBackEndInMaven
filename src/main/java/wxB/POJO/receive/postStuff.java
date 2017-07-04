package wxB.POJO.receive;


import org.dom4j.Element;

import org.springframework.beans.factory.annotation.Autowired;
import wxB.POJO.content.rec.recContent;
import wxB.POJO.content.sendMsgTypeEnum;
import wxB.POJO.send.returnStuff;
import wxB.Service.XMLUtils;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Created by coco1 on 2017/6/17.
 */


@XmlRootElement(name = "xml")
public class postStuff extends post {
    @Autowired
    private XMLUtils xmlUtils;
    private String ToUserName;
    private String FromUserName;
    private String CreateTime;
    private String MsgType;
    private recContent Content;
    private String MsgId;
    public postStuff(Element element) {
        xmlUtils.listNodes(element);
    }

    public postStuff() {
    }

    public String getCreateTime() {
        return CreateTime;
    }
    @XmlElement(name = "CreateTime")
    public void setCreateTime(String createTime) {
        this.CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }
    @XmlElement(name = "MsgType")
    public void setMsgType(String msgType) {
        this.MsgType = msgType;
    }

    public recContent getContent() {
        return Content;
    }
    @XmlElement(name = "Content")
    public void setContent(recContent content) {
        Content = content;
    }

    public String getMsgID() {
        return MsgId;
    }
    @XmlElement(name = "MsgId")
    public void setMsgID(String msgID) {
        this.MsgId = msgID;
    }
    @Override
    //没有使用CDATA包裹
    public String toString() {
        return "<xml>" +
                "<ToUserName>" +
                this.getToUserName() +
                "</ToUserName>" +
                "<FromUserName>" +
                this.getFromUserName() +
                "</FromUserName>" +
                "<CreateTime>" +
                this.getCreateTime() +
                "</CreateTime>" +
                "<MsgType>" +
                this.getMsgType() +
                "</MsgType>" +
                "<MsgId>" +
                this.getMsgID() +
                "</MsgId>" +
                Content.toString() +
                "</xml>";
    }

    public String getToUserName() {
        return ToUserName;
    }
    @XmlElement(name = "ToUserName")
    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }
    @XmlElement(name = "FromUserName")
    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }
    public returnStuff switchToReturnText( String content) {
        return new returnStuff(this, sendMsgTypeEnum.text, content);
    }




}
