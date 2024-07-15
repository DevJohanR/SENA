package com.johanriascos.voluntarios.controller;

import com.johanriascos.voluntarios.model.actividad;
import com.johanriascos.voluntarios.repository.actividadinterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/actividades")
public class actividadController {

    @Autowired
    private actividadinterface actividadRepo; // Usando la interfaz correcta

    @PostMapping
    public ResponseEntity<actividad> createActividad(@RequestBody actividad actividad) {
        actividad savedActividad = actividadRepo.save(actividad);
        return ResponseEntity.ok(savedActividad);
    }

    @GetMapping
    public ResponseEntity<Iterable<actividad>> getAllActividades() {
        Iterable<actividad> actividades = actividadRepo.findAll();
        return ResponseEntity.ok(actividades);
    }

    @PutMapping("/{idActividad}")
    public ResponseEntity<actividad> updateActividad(@PathVariable Long idActividad, @RequestBody actividad actividad) {
        if (actividadRepo.existsById(idActividad)) {
            actividad.setIdActividad(idActividad);
            actividad updatedActividad = actividadRepo.save(actividad);
            return ResponseEntity.ok(updatedActividad);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idActividad}")
    public ResponseEntity<Void> deleteActividad(@PathVariable Long idActividad) {
        if (actividadRepo.existsById(idActividad)) {
            actividadRepo.deleteById(idActividad);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
