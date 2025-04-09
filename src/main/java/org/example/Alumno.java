package org.example;

import java.util.List;

public class Alumno {
    private List<Materia> materiasAprobadas;

    public Alumno(List<Materia> materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }

    public boolean aproboCorrelativasDe(Materia materia) {
        return materia.getMateriasCorrelativas().stream().allMatch(m -> materiasAprobadas.contains(m));
    }
}
