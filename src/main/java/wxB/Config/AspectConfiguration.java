package wxB.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import wxB.Controller.Aspect.wxReceiveAspect;
import wxB.Controller.Aspect.wxUserAspect;

/**
 * Created by coco1 on 2017/6/21.
 * 启用AOP的总体Bean配置java文件
 */

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class AspectConfiguration {
    @Bean
    public wxUserAspect wxUserAspect() {
        return new wxUserAspect();
    }
    @Bean
    public wxReceiveAspect wxReceiveAspect() {
        return new wxReceiveAspect();
    }
}
