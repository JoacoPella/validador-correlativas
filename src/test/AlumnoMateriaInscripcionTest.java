import static org.junit.jupiter.api.Assertions.*;

import domain.entities.Alumno;
import domain.entities.Inscripcion;
import domain.entities.Materia;
import org.junit.jupiter.api.Test;

import java.util.Set;


class AlumnoMateriaInscripcionTest {

    @Test
    void testCrearAlumno() {
        Alumno alumno = new Alumno("Joaco", "Pella", Set.of());
        
        assertEquals("Joaco", alumno.getNombre());
        assertEquals("Pella", alumno.getApellido());
        assertTrue(alumno.getMateriasAprobadas().isEmpty());
    }

    @Test
    void testAgregarMateriaAprobada() {
        Alumno alumno = new Alumno("Joaco", "Pella", Set.of());
        Materia dds = new Materia("DDS", Set.of());
        
        alumno.agregarMateriaAprobada(dds);
        assertTrue(alumno.getMateriasAprobadas().contains(dds));
    }

    @Test
    void testMateriaCumpleCorrelativas() {
        Materia ads = new Materia("ADS", Set.of());
        Materia dds = new Materia("DDS", Set.of(ads));
        
        assertTrue(dds.cumpleCorrelativas(Set.of(ads))); 
        assertFalse(dds.cumpleCorrelativas(Set.of()));   
    }

    @Test
    void testMateriaSinCorrelativas() {
        Materia am1 = new Materia("AM1", Set.of());
        
        assertTrue(am1.cumpleCorrelativas(Set.of()));  
    }

    @Test
    void testInscripcionAprobada() {
        Materia ads = new Materia("ADS", Set.of());
        Materia dds = new Materia("DDS", Set.of(ads));
        Alumno alumno = new Alumno("Joaco", "Pella", Set.of(ads));
        
        Inscripcion inscripcion = new Inscripcion(Set.of(dds), alumno);
        
        assertTrue(inscripcion.aprobada()); 
    }

    @Test
    void testInscripcionNoAprobada() {
        Materia ads = new Materia("ADS", Set.of());
        Materia dds = new Materia("DDS", Set.of(ads));
        Alumno alumno = new Alumno("Joaco", "Pella", Set.of());
        
        Inscripcion inscripcion = new Inscripcion(Set.of(dds), alumno);
        
        assertFalse(inscripcion.aprobada()); 
    }
}
