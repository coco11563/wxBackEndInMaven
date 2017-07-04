package wxB.POJO.content.ret;

import org.dom4j.Element;
import wxB.POJO.content.sendMsgTypeEnum;

/**
 * Created by coco1 on 2017/6/30.
 */
public abstract class retContent {
    public String getText() {return " ";}
    public String cdataCover(String s) {
        return "<![CDATA[" + s + "]]>";
    }
    public String toString() {
        return "abstruct content";
    }
    public static retContent parseSendContent(Element rootElt, sendMsgTypeEnum type){
        retContent c = null;
        switch (type) {
            case voice: c =  retVoiceContent.parseContent(rootElt); break;
            case video: c = retVoiceContent.parseContent(rootElt); break;
            case music: c = retMusicContent.parseContent(rootElt); break;
            case image: c = retPicContent.parseContent(rootElt); break;
            case text: c = retTextContent.parseContent(rootElt); break;
            case news: c = retNewContent.parseContent(rootElt); break;
        }
        return c;
    }
}
