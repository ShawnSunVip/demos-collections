import com.sun.demo.config.JedisConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author sunxiang
 * @date 2020-12-18 9:45
 **/

public class RedisTest {

    @Test
    public void beanTest(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JedisConfig.class);
        String[] beanNamesForAnnotation = applicationContext.getBeanDefinitionNames();
        for (String name: beanNamesForAnnotation){
            System.out.println(name);
        }
    }

}
