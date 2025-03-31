import java.util.Set;

public class Inscripcion {
    private Alumno alumno;
    private Set<Materia> materiasACursar;
    private boolean fueAprobada;

    public Inscripcion(Set<Materia> materiasACursar, Alumno alumno) {
        this.materiasACursar = materiasACursar;
        this.alumno = alumno;
    }

    public boolean aprobada(){
        return this.materiasACursar.stream().allMatch(m -> m.cumpleCorrelativas(alumno.getMateriasAprobadas()));
    }
}