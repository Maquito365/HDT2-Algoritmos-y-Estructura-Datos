import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase principal que lee expresiones postfix de un archivo
 * y calcula sus resultados
 */
public class Main {
    
    public static void main(String[] args) {
        CalculadoraPostfix calculadora = new CalculadoraPostfix();
        String rutaArchivo = "datos.txt";
        
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            int numeroLinea = 1;
            
            while ((linea = lector.readLine()) != null) {
                linea = linea.trim();
                
                // Ignorar líneas vacías
                if (linea.isEmpty()) {
                    continue;
                }
                
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
}
