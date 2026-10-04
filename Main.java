import java.util.List;

public class Main {

    public static void main(String[] args) {
        ListaSimplementeEnlazada lista = new ListaSimplementeEnlazada();
        lista.agregar(new Estudiante("05030112345", "Ana", "Pérez", 'F', 2, true, true));
        lista.agregar(new Estudiante("04071554321", "Luis", "Gómez", 'M', 1, true, false));
        lista.agregar(new Estudiante("03031298765", "María", "Díaz", 'F', 3, false, true));
        lista.agregar(new Estudiante("02110234567", "Carlos", "Ruiz", 'M', 4, true, true));
        lista.agregar(new Estudiante("06030345678", "Elena", "Torres", 'F', 1, true, false));
        lista.agregar(new Estudiante("01091167890", "Jorge", "Núñez", 'M', 2, false, false));

        System.out.println("===== CASO 1: lista con datos variados =====");
        probar(lista, "Marzo",
               List.of("Ana Pérez", "María Díaz", "Elena Torres"),
               List.of("04071554321", "06030345678", "05030112345", "02110234567"),
               3);
        probar(lista, "07", List.of("Luis Gómez"), null, -1);
        probar(lista, "diciembre", List.of(), null, -1);

        ListaSimplementeEnlazada vacia = new ListaSimplementeEnlazada();
        System.out.println("\n===== CASO 2: lista vacía =====");
        probar(vacia, "marzo", List.of(), List.of(), 0);

        ListaSimplementeEnlazada sinCoincidencias = new ListaSimplementeEnlazada();
        sinCoincidencias.agregar(new Estudiante("05080212345", "Rosa", "Mena", 'F', 1, false, false));
        sinCoincidencias.agregar(new Estudiante("04050367890", "Raúl", "Soto", 'M', 2, false, false));
        System.out.println("\n===== CASO 3: sin militantes ni becados =====");
        probar(sinCoincidencias, "enero", List.of(), List.of(), 0);
    }

    private static void probar(ListaSimplementeEnlazada lista, String mes,
                               List<String> esperadoCumple, List<String> esperadoCisMilitantes,
                               int esperadoBecados) {
        System.out.println("\n-- Cumpleaños(\"" + mes + "\") --");
        List<String> cumple = lista.Cumpleaños(mes);
        System.out.println(cumple.isEmpty() ? "(ninguno)" : cumple);
        System.out.println("Esperado: " + esperadoCumple
                + " -> " + (cumple.equals(esperadoCumple) ? "OK" : "FALLO"));

        if (esperadoCisMilitantes != null) {
            System.out.println("\n-- CantMilitantes() (año de menor a mayor) --");
            List<String> militantes = lista.CantMilitantes();
            if (militantes.isEmpty()) {
                System.out.println("(ninguno)");
            }
            for (String linea : militantes) {
                System.out.println(linea);
            }
            boolean ok = militantes.size() == esperadoCisMilitantes.size();
            for (int i = 0; ok && i < militantes.size(); i++) {
                ok = militantes.get(i).startsWith(esperadoCisMilitantes.get(i));
            }
            System.out.println("Orden esperado por CI: " + esperadoCisMilitantes
                    + " -> " + (ok ? "OK" : "FALLO"));
        }

        if (esperadoBecados >= 0) {
            int becados = lista.CantBecados();
            System.out.println("\n-- CantBecados() --");
            System.out.println(becados);
            System.out.println("Esperado: " + esperadoBecados
                    + " -> " + (becados == esperadoBecados ? "OK" : "FALLO"));
        }
    }
}
