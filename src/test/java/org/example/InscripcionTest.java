package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InscripcionTest {

    @Test
    public void testInscripcionAprobadaCuandoTodasLasCorrelativasEstanAprobadas() {
        Materia algebra = new Materia("Álgebra");
        Materia analisis = new Materia("Análisis");
        Materia fisica = new Materia("Física", List.of(algebra, analisis));

        Alumno alumnoQueAprobo = new Alumno(List.of(algebra, analisis));

        Inscripcion inscripcionConCorrelativas = new Inscripcion(List.of(fisica), alumnoQueAprobo);

        assertTrue(inscripcionConCorrelativas.aprobada());
    }

    @Test
    public void testInscripcionNoAprobadaCuandoFaltaCorrelativa() {
        Materia algebra = new Materia("Álgebra");
        Materia analisis = new Materia("Análisis");
        Materia fisica = new Materia("Física", List.of(algebra, analisis));

        Alumno alumno = new Alumno(List.of(algebra));

        Inscripcion inscripcion = new Inscripcion(List.of(fisica), alumno);

        assertFalse(inscripcion.aprobada());
    }

    @Test
    public void testInscripcionAprobadaCuandoMateriaNoTieneCorrelativas() {
        Materia filosofia = new Materia("Filosofía");

        Alumno alumno = new Alumno(List.of());

        Inscripcion inscripcion = new Inscripcion(List.of(filosofia), alumno);

        assertTrue(inscripcion.aprobada());
    }

}
