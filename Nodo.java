public class Nodo {
    private Estudiante dato;
    private Nodo siguiente;

    public Nodo(Estudiante dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Estudiante getDato() {
        return dato;
    }

    public void setDato(Estudiante dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
