package wxB.POJO.content.rec;


import org.dom4j.Element;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by coco1 on 2017/6/24.
 */
@XmlRootElement(name ="")
public class picContent extends recContent {
    public picContent(String picUrl, String mediaId) {
        setMediaId(mediaId);
        setPicUrl(picUrl);
    }
    public picContent() {}
   private String picUrl;
   private String MediaId;
    @XmlElement(name = "MediaId")
    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
    @XmlElement(name = "PicUrl")
    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
    public String toString() {
        return "<PicUrl>" +
                cdataCover(this.getPicUrl()) +
                "</PicUrl>" +
                "<MediaId>" +
                cdataCover(this.getMediaId()) +
                "</MediaId>";
    }

    @Override
    public String[] toSQL() {
        return new String[] {getPicUrl() , getMediaId()};
    }

    public static picContent parse(String picUrl, String mediaId) {
        return new picContent(picUrl, mediaId);
    }
    public static recContent parseContent(Element rootElt){
        return null;
    }

}
