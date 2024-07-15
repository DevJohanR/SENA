package com.johanriascos.voluntarios.services;

import com.johanriascos.voluntarios.model.voluntario;
import com.johanriascos.voluntarios.repository.voluntariointerface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio para gestionar los voluntarios
 */
@Service
public class voluntariointerfaceservicesclass implements voluntariointerfaceservices {

    @Autowired
    private voluntariointerface voluntarioRepo;

    /**
     * Crear un nuevo voluntario
     * @param newVoluntario el voluntario a crear
     * @return el voluntario creado
     */
    @Override
    public voluntario newVoluntario(voluntario newVoluntario) {
        return voluntarioRepo.save(newVoluntario);
    }

    /**
     * Obtener todos los voluntarios
     * @return iterable con todos los voluntarios
     */
    @Override
    public Iterable<voluntario> getAll() {
        return voluntarioRepo.findAll();
    }

    /**
     * Modificar un voluntario existente
     * @param voluntario el voluntario con los datos actualizados
     * @return el voluntario modificado
     */
    @Override
    public voluntario modifyvoluntario(voluntario voluntario) {
        if (voluntarioRepo.existsById(voluntario.getIduser())) {
            return voluntarioRepo.save(voluntario);
        } else {
            throw new RuntimeException("Voluntario no encontrado");
        }
    }

    /**
     * Eliminar un voluntario por su ID
     * @param iduser el ID del voluntario a eliminar
     * @return true si la eliminación fue exitosa, false si no
     */
    @Override
    public Boolean deletevoluntario(Long iduser) {
        if (voluntarioRepo.existsById(iduser)) {
            voluntarioRepo.deleteById(iduser);
            return true;
        } else {
            return false;
        }
    }
}
