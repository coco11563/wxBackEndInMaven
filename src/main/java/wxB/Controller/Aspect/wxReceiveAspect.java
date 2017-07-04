package wxB.Controller.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import wxB.DAO.wxReceive.wxReceiveTextJPA;
import wxB.POJO.receive.postStuff;

/**
 * Created by coco1 on 2017/6/23.
 */
@Aspect
public class wxReceiveAspect {
    @Autowired
    private wxReceiveTextJPA wxReceiveTextJPA;

    @Pointcut("execution(* wxB.Service.XMLUtils.fromXmlToBean(..))")
    public void postXMLdef() {}

    /**
     * @param joinPoint
     * @param rvt
     */
    @AfterReturning(value = "postXMLdef()", returning = "rvt")
    public void insertUser(JoinPoint joinPoint, Object rvt) {
        if (rvt instanceof postStuff);
//            wxReceiveTextJPA.wxInser((postStuff)rvt);
    }
}
