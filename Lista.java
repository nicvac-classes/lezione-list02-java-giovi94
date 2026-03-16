class Lista<T> {

    private Nodo<T> head;

    public boolean isEmpty() {
        return head == null;
    }

    public void aggiungiInTesta(T dato) {
        head = new Nodo<>(dato, head);
    }

    public void aggiungiInCoda(T dato) {
        if (head == null) {
            head = new Nodo<>(dato, null);
            return;
        }
        Nodo<T> curr = head;
        while (curr.next != null) curr = curr.next;
        curr.next = new Nodo<>(dato, null);
    }

    public void aggiungiInPosizione(T dato, int pos) {
        if (pos == 0) {
            aggiungiInTesta(dato);
            return;
        }
        Nodo<T> curr = head;
        for (int i = 0; curr != null && i < pos - 1; i++)
            curr = curr.next;

        if (curr == null) throw new IndexOutOfBoundsException();
        curr.next = new Nodo<>(dato, curr.next);
    }

    public int size() {
        int count = 0;
        for (Nodo<T> curr = head; curr != null; curr = curr.next)
            count++;
        return count;
    }

    public int indiceDi(T dato) {
        int i = 0;
        for (Nodo<T> curr = head; curr != null; curr = curr.next, i++)
            if (curr.dato.equals(dato)) return i;
        return -1;
    }

    public boolean cancella(T dato) {
        if (head == null) return false;
        if (head.dato.equals(dato)) {
            head = head.next;
            return true;
        }
        Nodo<T> curr = head;
        while (curr.next != null) {
            if (curr.next.dato.equals(dato)) {
                curr.next = curr.next.next;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public T cancellaInPosizione(int pos) {
        if (head == null) throw new IndexOutOfBoundsException();
        if (pos == 0) {
            T dato = head.dato;
            head = head.next;
            return dato;
        }
        Nodo<T> curr = head;
        for (int i = 0; curr.next != null && i < pos - 1; i++)
            curr = curr.next;

        if (curr.next == null) throw new IndexOutOfBoundsException();
        T dato = curr.next.dato;
        curr.next = curr.next.next;
        return dato;
    }

    public void concatena(Lista<T> altra) {
        if (altra == null || altra.head == null) return;
        if (head == null) {
            head = altra.head;
            return;
        }
        Nodo<T> curr = head;
        while (curr.next != null) curr = curr.next;
        curr.next = altra.head;
    }
    public void concatena(Lista<T> altraLista) {
    if (altraLista == null || altraLista.head == null) {
        return;
    }
    
    if (head == null) {
        head = altraLista.head;
        return;
    }
    
    Nodo<T> corrente = head;
    while (corrente.next != null) {
        corrente = corrente.next;
    }
    corrente.next = altraLista.head;
}

public String toString() {
    StringBuilder sb = new StringBuilder();
    Nodo<T> corrente = head;
    
    while (corrente != null) {
        sb.append(corrente.dato);
        sb.append(" -> ");
        corrente = corrente.next;
    }
    sb.append("NULL");
    
    return sb.toString();
}


   