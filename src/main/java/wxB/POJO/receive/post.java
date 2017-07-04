package wxB.POJO.receive;

/**
 * Created by coco1 on 2017/6/24.
 */
public abstract class post {

    public String cdataCover(String s) {
        return "<![CDATA[" + s + "]]>";
    }
}
