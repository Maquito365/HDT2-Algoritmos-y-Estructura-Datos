import java.util.Vector;
/**
 * Implementación de la pila usando Vector
 * El último elemento del Vector es el tope de la pila
 */
public class PilaStack<T> implements Stack<T>{
    
    private Vector<T> pila;

    public PilaStack(){
        pila = new Vector<>();
    }
//Este método agrega un elemento al tope de la pila
    @Override
    public void push(T element){
        pila.add(element);
    }
//Este método elimina y retorna el elemento del tope de la pila
    @Override
    public T pop(){
        if(pila.isEmpty()){
            throw new RuntimeException("La pila está vacía");   
        }
        return pila.remove(pila.size() - 1);
    }
//Este método retorna el elemento del tope de la pila sin eliminarlo
    @Override
    public T peek(){
        if(pila.isEmpty()){
            throw new RuntimeException("La pila está vacía");   
        }
        return pila.lastElement();
    }
//Este método retorna el número de elementos en la pila
    @Override
    public int size(){
        return pila.size();
    }
} 
    

