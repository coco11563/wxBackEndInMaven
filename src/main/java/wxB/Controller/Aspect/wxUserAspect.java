package wxB.Controller.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import wxB.DAO.wxUserJPA;
import wxB.POJO.User;
import wxB.POJO.receive.postStuff;

/**
 * Created by coco1 on 2017/6/21.
 * 检查用户是否存在并插入用户访问记录
 */
@Aspect
public class wxUserAspect {
    @Autowired
    private wxUserJPA wxUserJPA;
    @Pointcut("execution(* wxB.Service.XMLUtils.fromXmlToBean(..))")
    public void postXMLdef() {}
    @Before("postXMLdef()")
    public void checkUser(JoinPoint joinPoint) {

    }
    /**
     * @param joinPoint
     * @param rvt
     */
    @AfterReturning(value = "postXMLdef()", returning = "rvt")
    public void insertUser(JoinPoint joinPoint, Object rvt) {
        User user = new User((postStuff) rvt);
        if (!wxUserJPA.wxIsExist(user)) {
            wxUserJPA.wxInser(user);
        } else {
            wxUserJPA.wxCountAdd(user);
        }
    }

}
