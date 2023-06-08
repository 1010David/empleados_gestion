package com.myapp.empleados_gestion;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080") // Reemplaza con el origen de tu aplicación frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("Content-Type")
                .allowCredentials(true);
    }
}
