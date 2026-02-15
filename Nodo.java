class Nodo<T> {
    T dato;
    Nodo<T> next;

    Nodo(T dato, Nodo<T> next) {
        this.dato = dato;
        this.next = next;
    }
}
