package tarea.models;

import lombok.Data;

import java.io.Serializable;


@Data
public class Pelicula implements Serializable {

    private Integer id;
    private String titulo;
    private String genero;
    private Integer año;





}
