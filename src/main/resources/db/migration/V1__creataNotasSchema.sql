/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  kedwin
 * Created: Nov 3, 2023
 */

create table notas (
    id bigint auto_increment,
    titulo varchar(255),
    mensaje varchar(255),
    primary key(id)
);