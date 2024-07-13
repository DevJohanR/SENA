/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.johanriascos.voluntarios.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/**
 *
 * @author ejoha
 */

//recursos para la comunicacion
@Entity
@Data


public class voluntario {
    
    //configuro la llave primaria y luego los atributos
    @Id
    //indentifico las colulmnas
    @Column
    private Long iduser;
    
    @Column
    private String username;
    

   
    @Column
    private String email;
   
    
    
}
