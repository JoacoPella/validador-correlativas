import java.util.Set;

public class Materia {
    private String nombre;
    private Set<Materia> correlativas;

    public Materia(String nombre, Set<Materia> correlativas) {
        this.nombre = nombre;
        this.correlativas = correlativas;
    }

    public String getNombre() {
        return nombre;
    }

    public Set<Materia> getCorrelativas() {
        return correlativas;
    }

    public boolean cumpleCorrelativas(Set<Materia> materias) {
        return materias.containsAll(correlativas);
    }
}
