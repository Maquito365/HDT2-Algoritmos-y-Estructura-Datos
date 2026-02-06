/**
 * Implementación de la interfaz Calculator
 * Realiza operaciones aritméticas básicas
 */
public class OperacionesAritmeticas implements Calculator {
    
    @Override
    public int sumar(int a, int b) {
        return a + b;
    }
    
    @Override
    public int restar(int a, int b) {
        return a - b;
    }
    
    @Override
    public int multiplicar(int a, int b) {
        return a * b;
    }
    
    @Override
    public int dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return a / b;
    }
}
