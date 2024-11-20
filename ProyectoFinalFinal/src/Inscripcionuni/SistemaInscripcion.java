package inscripcionuni;

import universidadObservadores.Observador;
import java.util.ArrayList;
import java.util.List;

public class SistemaInscripcion {
    private static SistemaInscripcion instancia;
    private List<Materia> materias = new ArrayList<>();
    private List<Observador> observadores = new ArrayList<>();

    private SistemaInscripcion() {
        // Crear materias por defecto
        materias.add(new Materia("Matematicas", 5));
        materias.add(new Materia("Programacion", 3));
        materias.add(new Materia("Fisica", 4));
        materias.add(new Materia("Quimica", 2));
    }

    public static SistemaInscripcion getInstance() {
        if (instancia == null) {
            instancia = new SistemaInscripcion();
        }
        return instancia;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void inscribirMateria(String nombreMateria) {
        for (Materia materia : materias) {
            if (materia.getNombre().equalsIgnoreCase(nombreMateria)) {
                if (materia.inscribir()) {
                    System.out.println("Inscripcion exitosa en " + nombreMateria + ".");
                    notificarSistemas(nombreMateria);
                } else {
                    System.out.println("No hay cupos disponibles en " + nombreMateria + ".");
                }
                return;
            }
        }
        System.out.println("Materia no encontrada.");
    }

    private void notificarSistemas(String materia) {
        for (Observador observador : observadores) {
            observador.actualizar(materia);
        }
    }
}
