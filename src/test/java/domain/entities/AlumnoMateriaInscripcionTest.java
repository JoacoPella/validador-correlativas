package domain.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;


class AlumnoMateriaInscripcionTest {

    @Test
    public void testCrearAlumno() {
        Alumno alumno = new Alumno("Joaco", "Pella", Set.of());

        Assertions.assertEquals("Joaco", alumno.getNombre());
        Assertions.assertEquals("Pella", alumno.getApellido());
        Assertions.assertTrue(alumno.getMateriasAprobadas().isEmpty());
    }

    @Test
    public void testAgregarMateriaAprobada() {
        Alumno alumno = new Alumno("Joaco", "Pella", Set.of());
        Materia dds = new Materia("DDS", Set.of());

        alumno.agregarMateriaAprobada(dds);
        Assertions.assertTrue(alumno.getMateriasAprobadas().contains(dds));
    }

    @Test
    public void testMateriaCumpleCorrelativas() {
        Materia ads = new Materia("ADS", Set.of());
        Materia dds = new Materia("DDS", Set.of(ads));

        Assertions.assertTrue(dds.cumpleCorrelativas(Set.of(ads)));
        Assertions.assertFalse(dds.cumpleCorrelativas(Set.of()));
    }

    @Test
    public void testMateriaSinCorrelativas() {
        Materia am1 = new Materia("AM1", Set.of());

        Assertions.assertTrue(am1.cumpleCorrelativas(Set.of()));
    }

    @Test
    public void testInscripcionAprobada() {
        Materia ads = new Materia("ADS", Set.of());
        Materia dds = new Materia("DDS", Set.of(ads));
        Alumno alumno = new Alumno("Joaco", "Pella", Set.of(ads));

        Inscripcion inscripcion = new Inscripcion(Set.of(dds), alumno);

        Assertions.assertTrue(inscripcion.aprobada());
    }

    @Test
    public void testInscripcionNoAprobada() {
        Materia ads = new Materia("ADS", Set.of());
        Materia dds = new Materia("DDS", Set.of(ads));
        Alumno alumno = new Alumno("Joaco", "Pella", Set.of());

        Inscripcion inscripcion = new Inscripcion(Set.of(dds), alumno);

        Assertions.assertFalse(inscripcion.aprobada());
    }
}
