package wxB.POJO;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Arrays;

/**
 * Created by coco1 on 2017/6/15.
 */
public class identifiedField {
    private String signature;
    private String timestamp;
    private String nonce;
    private String echostr;
    private String retStr;
    private String token = "sha0wissocool";
    public identifiedField(String signature, String timestamp, String nonce, String echostr) {
        setEchostr(echostr);
        setNonce(nonce);
        setSignature(signature);
        setTimestamp(timestamp);
        if (sha1(sortAndPlus())) {
            retStr = echostr;
        }
    }
    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getEchostr() {
        return echostr;
    }

    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }

    public String getRetStr() {
        return retStr;
    }

    public void setRetStr(String retStr) {
        this.retStr = retStr;
    }
    private String sortAndPlus() {
        String[] strs = new String[] {timestamp, nonce, token};
        Arrays.sort(strs);
        StringBuilder stringBuilder = new StringBuilder();
        for (String i : strs) {
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }
    private boolean sha1(String str) {
        if (DigestUtils.sha1Hex(str).equals(signature)) {
            return true;
        }
        return false;
    }
}
