public class Localidad {

    public static Localidad x;
    //Variables de instancia (Atributos)
    private int numLocalidad;
    private int precio;
    private int capacidad;
    
    // Constructor
    public Localidad(int numLocalidad, int precio, int capacidad) {
        this.numLocalidad = numLocalidad;
        this.precio = precio;
        this.capacidad = capacidad;
    }

    // Metodos
    public int getNumLocalidad() {
        return numLocalidad;
    }

    public void setNumLocalidad(int numLocalidad) {
        this.numLocalidad = numLocalidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Localidad [numLocalidad=" + numLocalidad + ", precio=" + precio + ", capacidad=" + capacidad + "]";
    }
}
