package universidadObservadores;

public class SistemaAcademico implements Observador {
    @Override
    public void actualizar(String materia) {
        System.out.println("Sistema Académico: Actualizando los cupos de " + materia + ".");
    }
}

