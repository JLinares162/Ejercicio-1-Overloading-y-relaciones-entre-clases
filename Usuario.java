public class Usuario {

    //Variables de instancia (Atributos)
    private String nombre;
    private String email;
    private int presupuesto;
    private int numBoletos;

    // Constructor
    public Usuario(String nombre, String email, int presupuesto, int numBoletos){
        this.nombre = nombre;
        this.email = email;
        this.presupuesto = presupuesto;
        this.numBoletos = numBoletos;
    }

    // Metodos

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public int getNumBoletos() {
        return numBoletos;
    }

    public void setNumBoletos(int numBoletos) {
        this.numBoletos = numBoletos;
    }

    @Override
    public String toString() {
        return "Usuario [nombre=" + nombre + ", email=" + email + ", presupuesto=" + presupuesto + ", numBoletos="
                + numBoletos + "]";
    }
}
