/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.note.my.noteApp.controller;

import com.note.my.noteApp.domain.notas.NotaDataGetDTO;
import com.note.my.noteApp.domain.notas.NotaDataSendDTO;
import com.note.my.noteApp.domain.notas.NotaEntity;
import com.note.my.noteApp.domain.notas.NotaService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author kedwin
 */

@Controller
@ResponseBody
@RequestMapping("/notas")
public class notasController {
    
    @Autowired
    NotaService service;
    
    @GetMapping
    public ResponseEntity<List> get(){
        List<NotaEntity> datos = service.getAll();
        return ResponseEntity.ok(datos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<NotaDataSendDTO> getOne(@PathVariable String id){
        NotaDataSendDTO dato = service.getOne(id);
        return ResponseEntity.ok(dato);
    }
    
    @PostMapping
    public ResponseEntity post(@RequestBody @Valid NotaDataGetDTO data){
        service.saveOne(data);
        return ResponseEntity.ok().build();
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity put( @RequestBody @Valid NotaDataGetDTO dato,@PathVariable String id){
        service.update(dato,id);
        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){
        service.deleteOne(id);
        return ResponseEntity.ok().build();
    }
}
