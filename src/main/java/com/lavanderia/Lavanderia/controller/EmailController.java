/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavanderia.Lavanderia.controller;

import com.lavanderia.Lavanderia.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author oscar
 */
@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private JavaMailSender mail;
   

    //? = enviar cualquier tipo de dato
    @PostMapping("/sentCodeVerification")
    public ResponseEntity<?> enviarCorreo(@RequestBody Email e){
        String mensaje ="Su codigo de Verificación es:";
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(e.getTo());
        email.setFrom("reservcompany5b@gmail.com");
        email.setSubject(e.getSubject());
        email.setText(mensaje+"\n "+e.getText());
        //
        mail.send(email);

        return new ResponseEntity<>(true,HttpStatus.OK);
    }
}
