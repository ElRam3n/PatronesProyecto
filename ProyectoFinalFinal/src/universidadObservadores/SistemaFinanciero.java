package universidadObservadores;

public class SistemaFinanciero implements Observador {
    @Override
    public void actualizar(String materia) {
        System.out.println("Sistema Financiero: Calculando el costo por inscripción en " + materia + ".");
    }
}
