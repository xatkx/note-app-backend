/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.note.my.noteApp.domain.notas;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author kedwin
 */
public record NotaDataGetDTO( 
        @NotBlank
        String titulo, 
        @NotBlank
        String mensaje) {
}
