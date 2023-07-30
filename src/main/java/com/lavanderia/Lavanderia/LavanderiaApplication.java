package com.lavanderia.Lavanderia;

import com.lavanderia.Lavanderia.controller.EmailController;
import com.lavanderia.Lavanderia.model.Email;
import com.lavanderia.Lavanderia.service.EmailService;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@SpringBootApplication

public class LavanderiaApplication {

	 private final EmailService emailService;

    public static void main(String[] args) {
        SpringApplication.run(LavanderiaApplication.class, args);
    }

    public LavanderiaApplication(EmailService emailService) {
        this.emailService = emailService;
    }

    // Resto del código...

    // Método para enviar el correo electrónico en el momento de la aplicación
    // Aquí puedes llamar a este método en algún evento o en un horario específico si lo deseas.
  public void enviarCorreoEnMain() {
    Email em = new Email();
    em.setTo("oscar.cabrera.est@tecazuay.edu.ec");
    em.setSubject("Asunto del correo");
    em.setText("Contenido del correo");

    // Supongamos que la ruta del archivo adjunto es "ruta/del/archivo.pdf"
    String rutaArchivoAdjunto = "ruta/del/archivo.pdf";

    // Llama al método enviarCorreo() del servicio EmailService
    emailService.enviarCorreo(em, new File(rutaArchivoAdjunto));
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
