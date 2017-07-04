package wxB.DAO.wxReceive;

import wxB.POJO.content.recMsgTypeEnum;

import java.util.List;

/**
 * Created by coco1 on 2017/6/19.
 */
public interface wxRecJPA<T> {
    List<T> wxSelect(String key, recMsgTypeEnum recMsgTypeEnum) ;
    void wxInser(T t, recMsgTypeEnum recMsgTypeEnum);
    void wxUpdate(T t, recMsgTypeEnum recMsgTypeEnum);
    void wxDel(T t, recMsgTypeEnum recMsgTypeEnum);
}
