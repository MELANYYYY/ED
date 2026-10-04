import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class ListaSimplementeEnlazada {
    private static final String[] MESES = {
        "enero", "febrero", "marzo", "abril", "mayo", "junio",
        "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"
    };

    private Nodo cabeza;
    private int tamano;

    public ListaSimplementeEnlazada() {
        this.cabeza = null;
        this.tamano = 0;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public int getTamano() {
        return tamano;
    }

    public void agregar(Estudiante estudiante) {
        Nodo nuevo = new Nodo(estudiante);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
        tamano++;
    }

    private int numeroDeMes(String mes) {
        if (mes == null) {
            return -1;
        }
        String limpio = Normalizer.normalize(mes.trim().toLowerCase(), Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
        for (int i = 0; i < MESES.length; i++) {
            if (MESES[i].equals(limpio)) {
                return i + 1;
            }
        }
        try {
            int numero = Integer.parseInt(limpio);
            return (numero >= 1 && numero <= 12) ? numero : -1;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public List<String> Cumpleaños(String mes) {
        List<String> nombres = new ArrayList<>();
        int numeroMes = numeroDeMes(mes);
        if (numeroMes == -1) {
            return nombres;
        }
        Nodo actual = cabeza;
        while (actual != null) {
            Estudiante e = actual.getDato();
            if (e.getMesNacimiento() == numeroMes) {
                nombres.add(e.getNombreCompleto());
            }
            actual = actual.getSiguiente();
        }
        return nombres;
    }

    public List<String> CantMilitantes() {
        List<Estudiante> ordenados = new ArrayList<>();
        Nodo actual = cabeza;
        while (actual != null) {
            Estudiante e = actual.getDato();
            if (e.isMilitanteUJC()) {
                int pos = 0;
                while (pos < ordenados.size() && ordenados.get(pos).getAnno() <= e.getAnno()) {
                    pos++;
                }
                ordenados.add(pos, e);
            }
            actual = actual.getSiguiente();
        }

        List<String> resultado = new ArrayList<>();
        for (Estudiante e : ordenados) {
            resultado.add(e.toString());
        }
        return resultado;
    }

    public int CantBecados() {
        int cantidad = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.getDato().isBecado()) {
                cantidad++;
            }
            actual = actual.getSiguiente();
        }
        return cantidad;
    }
}
