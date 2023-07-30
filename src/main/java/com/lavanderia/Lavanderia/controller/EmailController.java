/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavanderia.Lavanderia.controller;

import com.lavanderia.Lavanderia.model.Email;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author oscar
 */
@RestController
@RequestMapping("/api/email")
public class EmailController {

  @Autowired
    private JavaMailSender mail;


    @PostMapping("/sentCodeVerification")
    public ResponseEntity<?> enviarCorreo(@RequestParam(value = "adjunto", required = false) MultipartFile adjunto,
                                          @RequestBody Email e) {
        String mensaje = "Datos " + e.getText();

        try {
            MimeMessage message = mail.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(e.getTo());
            helper.setFrom("oscar.cabrera.est@tecazuay.edu.ec");
            helper.setSubject(e.getSubject());
            helper.setText(mensaje);

            if (adjunto != null) {
                helper.addAttachment(adjunto.getOriginalFilename(), adjunto);
            }

            mail.send(message);
        } catch (MessagingException ex) {
            return new ResponseEntity<>("Error al enviar el correo: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
