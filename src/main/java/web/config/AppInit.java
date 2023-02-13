package web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
// класс заменяет файл настройки web xml
public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Метод, указывающий на класс конфигурации, его не используем поэтому возвращает null
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }


    // Добавление конфигурации, в которой инициализируем ViewResolver, для корректного отображения jsp.
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
                WebConfig.class // подставляем наш конфиг-класс WebConfig.java
        };
    }


    /* Данный метод указывает url, на котором будет базироваться приложение
    * указываем ,что все запросы после  "/"-- посылаем на диспетчерсервлет */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}