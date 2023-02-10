package web.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("web")
public class WebConfig implements WebMvcConfigurer {

    private final ApplicationContext applicationContext;

    public WebConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/pages/");
        templateResolver.setSuffix(".html");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }


    //реализация метода интерфейса WebMvcConfigurer
// реализация шаблонизатора Thymeleaf вместо стандартного шаблонизатора
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) { //
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        registry.viewResolver(resolver);
    }
}

/*

1.Скачиваем томкат 9 версию(с 10 у меня ничего не работало, так что если хотите сэкономить время , то лучше сразу
        9 ставьте)
2.Настраиваем проект по инструкции из задания
3.Создаем папку model  в ней создаем наш класс Car(ну и дальше по заданию)
4.В папке controller создаем наш CarController по анологии с HelloController (не теряйте анотации , как я)
5.Дальше создаем папку service, в ней создаем интерфейс и класс для нашей Car(интерфейс CarService ,
        класс CarServiceImpl(можете назвать как хотите это просто для примера)).
6.Список из машин создаем в классе сервиса(поможет видео Алишева https://www.youtube.com/watch?v=D58pIymCew4&list=PLAma_mKffTOR5o0WNHnY0mTjKxnCgSXrZ&index=21)
7.В webApp добавляем cars.html , там все по аналогии с index.html
8. Ну а дальше я думаю что вы самостоятельно догадаетесь как сделать, если внимательно посмотреть Алишева , видео
        из 6-го пункта , то думаю справитесь гораздо быстрее меня, удачи )))


отображение всей таблицы и усеченной можно реализовать в одном методе, что существенно сократит код
 (@RequestParam(value = "count", defaultValue = "5"))

 Задание:
1. Создайте еще один контроллер, замаппленный на /cars.
2. Создайте модель Car с тремя произвольными полями.
3. Создайте список из 5 машин.
4. Создайте сервис с методом, который будет возвращать указанное число машин из созданного списка.
5. Создайте страницу cars.html. Реализуйте создание таблицы с машинами из сервиса с помощью
thymeleaf.
6. При запросе /cars выводить весь список. При запросе /cars?count=2 должен отобразиться список из
 2 машин,
при /cars?count=3 - из 3, и тд. При count ≥ 5 выводить весь список машин.
*/