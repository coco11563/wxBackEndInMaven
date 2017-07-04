package wxB.Controller;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wxB.DAO.wxUserJPA;
import wxB.POJO.content.rec.recContent;
import wxB.POJO.identifiedField;
import wxB.POJO.receive.postStuff;
import wxB.Service.XMLUtils;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by coco1 on 2017/6/15.
 */
@RestController
public class wxController {
    @Autowired
    private XMLUtils xmlUtils;
    @RequestMapping(value = "/wx", method = GET)
    public String identified(@RequestParam("signature") String sinature, @RequestParam("timestamp") String timestamp,
                             @RequestParam("nonce") String nonce, @RequestParam("echostr") String echostr) {
        identifiedField identifiedField = new identifiedField(sinature, timestamp, nonce, echostr);
        return identifiedField.getRetStr();
    }
    @RequestMapping(value = "/wx", method = POST)
    public String repostAndPrint(@RequestBody String s) {
        wxUserJPA wxUserJPA = new wxUserJPA();
            System.out.println(s);
        try {
            Document doc = DocumentHelper.parseText(s);
            Element root = doc.getRootElement();
            postStuff postInform = (postStuff) xmlUtils.fromXmlToBean(root, postStuff.class);
            recContent con = postInform.getContent();
            String Text = con.getText();
            String ret = postInform.switchToReturnText("肖濛小可爱：" + Text).toString();
            System.out.println(ret);
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "sucess";
    }

}
