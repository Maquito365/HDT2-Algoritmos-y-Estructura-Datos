/**
 * Calculadora de expresiones en notación Postfix
 * Utiliza una pila para evaluar expresiones postfix
 */
public class CalculadoraPostfix {
    
    private Stack<Integer> pila;
    private Calculator calculadora;
    
    public CalculadoraPostfix() {
        this.pila = new PilaStack<>();
        this.calculadora = new OperacionesAritmeticas();
    }
    
    /**
     * Evalúa una expresión en notación postfix
     * @param expresion - String con la expresión postfix separada por espacios
     * @return el resultado de la evaluación
     */
    public int evaluar(String expresion) {
        String[] tokens = expresion.trim().split("\\s+");
        
        // Limpiar la pila antes de evaluar
        pila = new PilaStack<>();
        
        for (String token : tokens) {
            // Verificar si el token es un operador
            if (esOperador(token)) {
                // Pop dos operandos
                if (pila.size() < 2) {
                    throw new RuntimeException("Expresión postfix inválida: operadores insuficientes");
                }
                int b = pila.pop();  // Segundo operando
                int a = pila.pop();  // Primer operando
                
                int resultado = realizarOperacion(a, b, token);
                pila.push(resultado);
            } else {
                // Es un número, agregarlo a la pila
                try {
                    int numero = Integer.parseInt(token);
                    pila.push(numero);
                } catch (NumberFormatException e) {
                    throw new RuntimeException("Token inválido: " + token);
                }
            }
        }
        
        // Al final debe quedar un solo número en la pila
        if (pila.size() != 1) {
            throw new RuntimeException("Expresión postfix inválida");
        }
        
        return pila.pop();
    }
    
    /**
     * Verifica si un token es un operador
     */
    private boolean esOperador(String token) {
        return token.equals("+") || token.equals("-") || 
               token.equals("*") || token.equals("/");
    }
    
    /**
     * Realiza la operación aritmética según el operador
     */
    private int realizarOperacion(int a, int b, String operador) {
        switch (operador) {
            case "+":
                return calculadora.sumar(a, b);
            case "-":
                return calculadora.restar(a, b);
            case "*":
                return calculadora.multiplicar(a, b);
            case "/":
                return calculadora.dividir(a, b);
            default:
                throw new RuntimeException("Operador desconocido: " + operador);
        }
    }
}
