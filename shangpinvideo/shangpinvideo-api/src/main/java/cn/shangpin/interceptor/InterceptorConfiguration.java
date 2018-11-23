package cn.shangpin.interceptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by qujie on 2018/11/23
 * 资源配置和拦截器
 * */
@Configuration
public class InterceptorConfiguration extends WebMvcConfigurerAdapter {

    @Value("${web.upload-img-path}")
    String imgPath;

    /**
     * 自定义静态资源映射
     * */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("file:" + imgPath);
    }


}
