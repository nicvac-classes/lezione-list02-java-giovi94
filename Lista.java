import java.util.NoSuchElementException;

public class Lista<T> {
    private Nodo<T> head;

    public Lista() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
    }

    public void aggiungiInTesta(T dato) {
        head = new Nodo<>(dato, head);
    }

    public void aggiungiInCoda(T dato) {
        Nodo<T> nuovo = new Nodo<>(dato);

        if (isEmpty()) {
            head = nuovo;
            return;
        }

        Nodo<T> corrente = head;
        while (corrente.next != null) {
            corrente = corrente.next;
        }
        corrente.next = nuovo;
    }

    public T leggiTesta() {
        if (isEmpty()) {
            throw new NoSuchElementException("Lista vuota");
        }
        return head.dato;
    }

    public T leggiCoda() {
        if (isEmpty()) {
            throw new NoSuchElementException("Lista vuota");
        }

        Nodo<T> corrente = head;
        while (corrente.next != null) {
            corrente = corrente.next;
        }
        return corrente.dato;
    }

    public int size() {
        int count = 0;
        for (Nodo<T> c = head; c != null; c = c.next) {
            count++;
        }
        return count;
    }

    public boolean contiene(T dato) {
        for (Nodo<T> c = head; c != null; c = c.next) {
            if (dato == null ? c.dato == null : dato.equals(c.dato)) {
                return true;
            }
        }
        return false;
    }

    public int indiceDi(T dato) {
        int i = 0;
        for (Nodo<T> c = head; c != null; c = c.next, i++) {
            if (dato == null ? c.dato == null : dato.equals(c.dato)) {
                return i;
            }
        }
        return -1;
    }

    public boolean cancella(T dato) {
        if (isEmpty()) return false;

        if (dato == null ? head.dato == null : dato.equals(head.dato)) {
            head = head.next;
            return true;
        }

        Nodo<T> prev = head;
        Nodo<T> curr = head.next;

        while (curr != null) {
            if (dato == null ? curr.dato == null : dato.equals(curr.dato)) {
                prev.next = curr.next;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Nodo<T> c = head; c != null; c = c.next) {
            sb.append(c.dato).append(" -> ");
        }
        sb.append("NULL");
        return sb.toString();
    }
}
