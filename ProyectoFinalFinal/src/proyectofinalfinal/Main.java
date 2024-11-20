package proyectofinalfinal;


import inscripcionuni.Materia;
import inscripcionuni.SistemaInscripcion;
import universidadObservadores.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaInscripcion sistema = SistemaInscripcion.getInstance();

        // Agregar observadores
        sistema.agregarObservador(new SistemaFinanciero());
        sistema.agregarObservador(new SistemaAcademico());

        while (true) {
            System.out.println("\n--- Menu de Inscripcion ---");
            System.out.println("Materias disponibles:");

            int index = 1;
            for (Materia materia : sistema.getMaterias()) {
                System.out.println(index++ + ". " + materia.getNombre() + " (Cupos: " + materia.getCupos() + ")");
            }

            System.out.println("0. Salir");
            System.out.print("Selecciona una materia por su numero: ");
            int opcion = scanner.nextInt();

            if (opcion == 0) {
                System.out.println("Saliendo del sistema...");
                break;
            }

            if (opcion > 0 && opcion <= sistema.getMaterias().size()) {
                String nombreMateria = sistema.getMaterias().get(opcion - 1).getNombre();
                sistema.inscribirMateria(nombreMateria);
            } else {
                System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }

        scanner.close();
    }
}
