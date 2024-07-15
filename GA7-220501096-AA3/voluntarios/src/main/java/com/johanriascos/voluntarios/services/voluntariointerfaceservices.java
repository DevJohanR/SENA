/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.johanriascos.voluntarios.services;

import com.johanriascos.voluntarios.model.voluntario;

/**
 *
 * @author ejoha
 */
public interface voluntariointerfaceservices {
voluntario newVoluntario (voluntario newVoluntario); //Descripción: Este método se utiliza para crear un nuevo voluntario. Recibe un objeto voluntario y lo devuelve después de haberlo procesado (generalmente, guardado en la base de datos).
Iterable<voluntario>getAll();//Descripción: Este método se utiliza para obtener todos los voluntarios. Devuelve una colección de todos los objetos voluntario almacenados en la base de datos. Usar Iterable permite iterar sobre la colección de voluntarios.
voluntario modifyvoluntario (voluntario voluntario); //Este método se utiliza para modificar los detalles de un voluntario existente. Recibe un objeto voluntario con los datos actualizados y devuelve el objeto voluntario después de haber sido modificado.
Boolean deletevoluntario (Long iduser); //Descripción: Este método se utiliza para eliminar un voluntario. Recibe el iduser del voluntario que se quiere eliminar y devuelve true si la eliminación fue exitosa o false si no lo fue.
}
