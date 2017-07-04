package wxB.POJO.content.rec;

import org.dom4j.Element;
import wxB.POJO.content.recMsgTypeEnum;

/**
 * Created by coco1 on 2017/6/30.
 */
public abstract class recContent {
    public String getText() {return " ";}
    public String cdataCover(String s) {
        return "<![CDATA[" + s + "]]>";
    }
    public String toString() {
        return "abstruct content";
    }
    public static recContent parseRecContent(Element rootElt, recMsgTypeEnum type){
        recContent c = null;
        switch (type) {
            case voice: c =  voiceContent.parseContent(rootElt); break;
            case video: c = videoContent.parseContent(rootElt); break;
            case image: c = picContent.parseContent(rootElt); break;
            case text: c = textContent.parseContent(rootElt); break;
            case url: c = urlContent.parseContent(rootElt); break;
            case location: locationContent.parseContent(rootElt); break;
            case shortvideo: shortVideoContent.parseContent(rootElt); break;
        }
        return c;
    }

}
