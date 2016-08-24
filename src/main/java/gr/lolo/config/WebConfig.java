package gr.lolo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    private static final String[] WEBAPP_MAPPINGS = {"/foo", "/bar"};
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        for (String mapping : WEBAPP_MAPPINGS) {
            registry.addViewController(mapping).setViewName("forward:/index.html");
        }
    }
}
