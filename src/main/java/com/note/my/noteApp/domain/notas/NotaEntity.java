/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.note.my.noteApp.domain.notas;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author kedwin
 */


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity(name="NotaENtity")
@Table(name="notas")
public class NotaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String titulo;
    private String mensaje;

    NotaEntity(String titulo, String mensaje) {
        this.titulo = titulo;
        this.mensaje = mensaje;
    }
    
}
