package domain.entities;

import lombok.*;

import java.util.Set;

public class Alumno {
    @Setter
    @Getter
    private String nombre;
    @Setter
    @Getter
    private String apellido;
    @Setter
    @Getter
    private Set<Materia> materiasAprobadas;

    public Alumno(String nombre, String apellido, Set<Materia> materiasAprobadas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.materiasAprobadas = materiasAprobadas;
    }

    public void agregarMateriaAprobada(Materia materia){
        materiasAprobadas.add(materia);
    }
}