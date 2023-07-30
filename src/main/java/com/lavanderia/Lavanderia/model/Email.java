/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavanderia.Lavanderia.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author oscar
 */
@Data
public class Email {

    private String to;
    private String from;
    private String subject;
    private String text;
    private MultipartFile archivoAdjunto; 
}
