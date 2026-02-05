/**
 * Interfaz Stack (Pila)
 * Define las operaciones básicas de una pila genérica
 */
public interface Stack<T>{
    void push(T element);
    T pop();
    T peek();
    int size();
}