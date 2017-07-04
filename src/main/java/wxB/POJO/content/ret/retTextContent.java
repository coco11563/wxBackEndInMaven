package wxB.POJO.content.ret;

import org.dom4j.Element;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by coco1 on 2017/6/24.
 */
public class retTextContent extends retContent {
    public retTextContent(String s) {
        setContent(s);
    }
    @Override
    public String getText() {
        return getContent();
    }
    private String content;
    @XmlElement(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static retTextContent parse(String s) {
        return new retTextContent(s);
    }

    public String toString() {
        return "<Content>" +cdataCover(getContent())+ "</Content>";
    }

    public static retContent parseContent(Element rootElt){
        return new retTextContent(rootElt.elementText("Content"));
    }
}
