/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavanderia.Lavanderia.service;

import com.lavanderia.Lavanderia.model.Email;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author oscar
 */
@Service
public class EmailService {

    private final JavaMailSender mailSender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void enviarCorreo(Email em, File archivoAdjunto) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true); // El segundo parámetro indica que el mensaje es multipart (permite adjuntos)

            String mensaje = "Datos" + em.getText();
            helper.setTo(em.getTo());
            helper.setFrom("oscar.cabrera.est@tecazuay.edu.ec");
            helper.setSubject(em.getSubject());
            helper.setText(mensaje);

            // Adjuntar el archivo PDF
            helper.addAttachment("Reporte.pdf", archivoAdjunto);

            mailSender.send(message);
        } catch (MessagingException e) {
            // Manejar cualquier excepción relacionada con el envío de correo
            e.printStackTrace();
        }
    }

}
