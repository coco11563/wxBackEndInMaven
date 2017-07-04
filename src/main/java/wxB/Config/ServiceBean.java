package wxB.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import wxB.Service.XMLUtils;

/**
 * Created by coco1 on 2017/6/22.
 */
@Component
public class ServiceBean {
    //XMLbean
    @Bean
    @Scope("singleton")
    public XMLUtils xmlUtils() {
        return new XMLUtils();
    }
}
