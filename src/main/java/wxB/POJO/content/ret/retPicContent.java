package wxB.POJO.content.ret;


import org.dom4j.Element;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by coco1 on 2017/6/24.
 */
@XmlRootElement(name ="")
public class retPicContent extends retContent {
    public retPicContent(String picUrl, String mediaId) {
        setMediaId(mediaId);
        setPicUrl(picUrl);
    }
    public retPicContent() {}
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



    public static retPicContent parse(String picUrl, String mediaId) {
        return new retPicContent(picUrl, mediaId);
    }
    public static retContent parseContent(Element rootElt){
        return null;
    }

}
