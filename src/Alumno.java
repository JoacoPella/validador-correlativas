import java.util.Set;

public class Alumno {
    private String nombre;
    private String apellido;
    private Set<Materia> materiasAprobadas;

    public Alumno(String nombre, String apellido, Set<Materia> materiasAprobadas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.materiasAprobadas = materiasAprobadas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void agregarMateriaAprobada(Materia materia){
        materiasAprobadas.add(materia);
    }

    public Set<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }
}
