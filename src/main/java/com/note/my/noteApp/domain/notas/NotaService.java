/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.note.my.noteApp.domain.notas;

import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kedwin
 */
@Service
public class NotaService {
    
    @Autowired
    NotaRespository repository;

    public List getAll() {
        
        List<NotaEntity> list = repository.findAll();
        
        List<NotaDataSendDTO> send = list.stream().
                map(dato -> {
            return new NotaDataSendDTO( dato.getId(), dato.getTitulo(), dato.getMensaje());
        }).toList();
 
        return send;
    }
    
//    public List<NotaDataSendDTO> getAll() {
//        List<NotaEntity> list = repository.findAll();
//
//        return list.stream()
//                   .map(nota::convertirEntityADTO)
//                   .collect(Collectors.toList());
//    }

    public void saveOne(NotaDataGetDTO data) {
        NotaEntity Nota = new NotaEntity(data.titulo(),data.mensaje());
        repository.save(Nota);
    }

    public void deleteOne(String id) {
        if(id.isBlank()){
            throw new RuntimeException("id invalido");
        }
        
        long indenty = Integer.valueOf(id);
        
        repository.deleteById(indenty);
    }

    @Transactional
    public void update(NotaDataGetDTO dato, String id) {
        
        if(id.isBlank()){
            throw new RuntimeException("id invalido");
        }
        long ids = Integer.valueOf(id);
        NotaEntity nota = repository.getReferenceById(ids);
        
        nota.setTitulo(dato.titulo());
        nota.setMensaje(dato.mensaje());
    }

    public NotaDataSendDTO getOne(String id) {
        if(id.isBlank())
        {
            throw new RuntimeException("en blanco inmundo animal animal rastrero rata de dos pata :u");
        }
        long ids = Integer.valueOf(id);
        NotaEntity nota = repository.getReferenceById(ids);
        
        return new NotaDataSendDTO(nota.getId(), nota.getTitulo(), nota.getMensaje());
    }  
    
}
