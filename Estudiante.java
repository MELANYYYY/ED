public class Estudiante {
    private final String ci;
    private final String nombre;
    private final String apellido;
    private final char sexo;
    private final int anno;
    private final boolean militanteUJC;
    private final boolean becado;

    public Estudiante(String ci, String nombre, String apellido, char sexo, int anno,
                      boolean militanteUJC, boolean becado) {
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.anno = anno;
        this.militanteUJC = militanteUJC;
        this.becado = becado;
    }

    public String getCi() {
        return ci;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public char getSexo() {
        return sexo;
    }

    public int getAnno() {
        return anno;
    }

    public boolean isMilitanteUJC() {
        return militanteUJC;
    }

    public boolean isBecado() {
        return becado;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public int getMesNacimiento() {
        return Integer.parseInt(ci.substring(2, 4));
    }

    @Override
    public String toString() {
        return ci + " | " + getNombreCompleto() + " | Sexo: " + sexo + " | Año: " + anno
                + " | UJC: " + (militanteUJC ? "Sí" : "No")
                + " | Becado: " + (becado ? "Sí" : "No");
    }
}
