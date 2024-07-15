/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.johanriascos.voluntarios.repository;

import com.johanriascos.voluntarios.model.voluntario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ejoha
 */
public interface voluntariointerface extends JpaRepository <voluntario, Long> {
    
}
