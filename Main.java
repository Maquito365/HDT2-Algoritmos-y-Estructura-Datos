import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final String ARCHIVO = "datos.txt";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== CALCULADORA POSTFIX =====");
            System.out.println("1. Evaluar expresiones desde archivo");
            System.out.println("2. Ingresar expresión postfix manualmente");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    evaluarDesdeArchivo();
                    break;

                case 2:
                    evaluarDesdeConsola(scanner);
                    break;

                case 3:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 3);

        scanner.close();
    }

    /**
     * Evalúa expresiones postfix desde el archivo datos.txt
     */
    public static void evaluarDesdeArchivo() {
        CalculadoraPostfix calculadora = new CalculadoraPostfix();

        try (BufferedReader lector = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            int numeroLinea = 1; // Contador para el número de línea

            while ((linea = lector.readLine()) != null) { //verifica si la línea no es nula
                linea = linea.trim(); // Elimina espacios en blanco al inicio y al final

                if (linea.isEmpty()) continue; // Si la línea está vacía, se salta a la siguiente iteración

                try {
                    int resultado = calculadora.evaluar(linea);
                    System.out.println("Línea " + numeroLinea + ": " + linea + " = " + resultado);
                } catch (Exception e) {
                    System.err.println("Error en línea " + numeroLinea + ": " + e.getMessage());
                }
                numeroLinea++;
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Evalúa una expresión ingresada por el usuario
     */
    private static void evaluarDesdeConsola(Scanner scanner) {
        CalculadoraPostfix calculadora = new CalculadoraPostfix();

        System.out.print("Ingrese la expresión postfix: ");
        String expresion = scanner.nextLine();

        try {
            int resultado = calculadora.evaluar(expresion);
            System.out.println("Resultado: " + resultado);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
