package academy.learnprogramming.config;


import academy.learnprogramming.interceptor.RequestInterceptor;
import academy.learnprogramming.util.ViewNames;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    //== bean methods ==
    @Bean
    public LocaleResolver localeResolver() {
        return new SessionLocaleResolver();
    }

    // registering ViewController
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName(ViewNames.HOME);
    }

    // registering Interceptor
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestInterceptor());

        // we setup a new LocaleInterceptor so we can change the languange of the web from the URL
//        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
//        localeChangeInterceptor.setParamName("lang");

        // /?locale=ro - in the URL if we want to change to other language
        registry.addInterceptor(new LocaleChangeInterceptor());
    }


}
