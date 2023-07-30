package com.lavanderia.Lavanderia;

import com.lavanderia.Lavanderia.controller.EmailController;
import com.lavanderia.Lavanderia.model.Email;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@SpringBootApplication

public class LavanderiaApplication {

	public static void main(String[] args) {
	SpringApplication.run(LavanderiaApplication.class, args);
        EmailController email = new  EmailController();
        EmailController e= new EmailController();
        Email em= new Email();
        em.setTo("osmanycaber4321@gmail.com");
        e.enviarCorreo(em);
	}
        
        
@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*");
            }
        };
    }
    

}
