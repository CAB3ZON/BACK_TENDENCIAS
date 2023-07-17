package com.lavanderia.Lavanderia;

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
//              Date fecha = new Date();
//
//        // creamos una instancia de SimpleDateFormat con el formato deseado
//        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
//
//        // formateamos la fecha en el formato deseado
//        String fechaFormateada = formatoFecha.format(fecha);
//
//        System.out.println("La fecha formateada es: " + fechaFormateada);
//;
		SpringApplication.run(LavanderiaApplication.class, args);
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
