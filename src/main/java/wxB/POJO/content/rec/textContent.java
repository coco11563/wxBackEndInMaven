package wxB.POJO.content.rec;

import org.dom4j.Element;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by coco1 on 2017/6/24.
 */
public class textContent extends recContent {
    public textContent(String s) {
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

    public static textContent parse(String s) {
        return new textContent(s);
    }

    public String toString() {
        return "<Content>" +cdataCover(getContent())+ "</Content>";
    }

    public static recContent parseContent(Element rootElt){
        return new textContent(rootElt.elementText("Content"));
    }
}
