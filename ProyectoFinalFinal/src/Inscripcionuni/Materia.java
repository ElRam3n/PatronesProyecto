package inscripcionuni;

public class Materia {
    private String nombre;
    private int cupos;

    public Materia(String nombre, int cupos) {
        this.nombre = nombre;
        this.cupos = cupos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCupos() {
        return cupos;
    }

    public boolean inscribir() {
        if (cupos > 0) {
            cupos--;
            return true;
        }
        return false;
    }
}
