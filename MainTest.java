import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    @DisplayName("Test de operaciones aritméticas")
    public void TestOperaciones() {
        OperacionesAritmeticas operaciones = new OperacionesAritmeticas();

        assertEquals(5, operaciones.sumar(2, 3));
        assertEquals(-1, operaciones.restar(2, 3));
        assertEquals(6, operaciones.multiplicar(2, 3));
        assertEquals(2, operaciones.dividir(6, 3));

        // Prueba de división por cero
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            operaciones.dividir(6, 0);
        });
        assertEquals("No se puede dividir por cero", exception.getMessage());
        
    }

    @Test
    @DisplayName("Test de la pila")
    public void TestPila(){
        PilaStack<Integer> pila = new PilaStack<>();

        pila.push(1);
        pila.push(2);
        pila.push(3);

        assertEquals(3, pila.peek());
        assertEquals(3, pila.pop());
        assertEquals(2, pila.size());
        assertEquals(2, pila.peek());

    }

    @Test
    @DisplayName ("Test del archivo .txt")
    public void TestArchivo(){
        Main.evaluarDesdeArchivo();
    }

    
}
