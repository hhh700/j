package richardlab21g01project2.config;

import org.springframework.context.annotation.*;
import org.springframework.beans.factory.annotation.Value;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.core.env.Environment;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;


@Configuration
public class ThymeleafConfig {    
    // @Autowired Environment env;

    @Value("${thymeleaf.external.template.path}")
    private String externalTemplatePath;

    @Bean
    public FileTemplateResolver secondaryTemplateResolver() {
        FileTemplateResolver secondaryTemplateResolver = new FileTemplateResolver();
        secondaryTemplateResolver.setPrefix(externalTemplatePath);  
        secondaryTemplateResolver.setSuffix(".html");
        secondaryTemplateResolver.setTemplateMode(TemplateMode.HTML);
        secondaryTemplateResolver.setCharacterEncoding("UTF-8");
        secondaryTemplateResolver.setOrder(1);
        secondaryTemplateResolver.setCheckExistence(true);
        return secondaryTemplateResolver;
    }
}