package com.johanriascos.voluntarios.controller;

import com.johanriascos.voluntarios.model.voluntario;
import com.johanriascos.voluntarios.services.voluntariointerfaceservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



/**
 * Controlador REST para gestionar voluntarios
 */
@RestController
@RequestMapping("/voluntarios")
public class voluntarioController {

    @Autowired
    private voluntariointerfaceservices voluntarioService;

    /**
     * Endpoint para crear un nuevo voluntario
     * @param voluntario el voluntario a crear
     * @return el voluntario creado
     */
    @PostMapping
    public ResponseEntity<voluntario> createVoluntario(@RequestBody voluntario voluntario) {
        voluntario newVoluntario = voluntarioService.newVoluntario(voluntario);
        return ResponseEntity.ok(newVoluntario);
    }

    /**
     * Endpoint para obtener todos los voluntarios
     * @return iterable con todos los voluntarios
     */
    @GetMapping
    public ResponseEntity<Iterable<voluntario>> getAllVoluntarios() {
        Iterable<voluntario> voluntarios = voluntarioService.getAll();
        return ResponseEntity.ok(voluntarios);
    }

    /**
     * Endpoint para modificar un voluntario
     * @param voluntario el voluntario con los datos actualizados
     * @return el voluntario modificado
     */
    @PutMapping
    public ResponseEntity<voluntario> updateVoluntario(@RequestBody voluntario voluntario) {
        try {
            voluntario updatedVoluntario = voluntarioService.modifyvoluntario(voluntario);
            return ResponseEntity.ok(updatedVoluntario);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpoint para eliminar un voluntario por su ID
     * @param iduser el ID del voluntario a eliminar
     * @return respuesta indicando si la eliminación fue exitosa
     */
    @DeleteMapping("/{iduser}")
    public ResponseEntity<Void> deleteVoluntario(@PathVariable Long iduser) {
        boolean deleted = voluntarioService.deletevoluntario(iduser);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
