/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.johanriascos.voluntarios.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author ejoha
 */


@Entity
@Data
public class actividad {
    
      @Id
      @Column
    private Long idActividad;
      
      @Column
      private String descripcion;
      
      @ManyToOne
      private voluntario voluntario;
}
