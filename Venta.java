import java.util.Scanner;

public class Venta {
    
    //Variables de instancia (Atributos)
    private Usuario usuario;
    private Localidad localidadBarata;
    private Localidad localidadMedia;
    private Localidad localidadCara; 

    // Contructor
    public Venta() {
        this.usuario = new Usuario(null, null, 0, 0);
        this.localidadBarata = new Localidad(1, 100, 20);
        this.localidadMedia = new Localidad(5, 500, 20);
        this.localidadCara = new Localidad(10, 1000, 20);
    }

    //Metodos

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Localidad getLocalidadBarata() {
        return localidadBarata;
    }

    public void setLocalidadBarata(Localidad localidadBarata) {
        this.localidadBarata = localidadBarata;
    }

    public Localidad getLocalidadMedia() {
        return localidadMedia;
    }

    public void setLocalidadMedia(Localidad localidadMedia) {
        this.localidadMedia = localidadMedia;
    }

    public Localidad getLocalidadCara() {
        return localidadCara;
    }

    public void setLocalidadCara(Localidad localidadCara) {
        this.localidadCara = localidadCara;
    }

    @Override
    public String toString() {
        return "Venta [usuario=" + usuario + ", localidadBarata=" + localidadBarata + ", localidadMedia="
                + localidadMedia + ", localidadCara=" + localidadCara + "]";
    }

   public void CrearUsuaio(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresar Nombre:");
        String nombre = scanner.nextLine();

        System.out.print("Ingresar Email: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese presupuesto:");
        int presupuesto = scanner.nextInt();

        System.out.print("Ingrese numero de boletos: ");
        int numBoletos =  scanner.nextInt();

        usuario = new Usuario(nombre, email, presupuesto, numBoletos);

        System.out.println("--------Usuario creado exitosamente--------");
        System.out.println(usuario);
   }
    
   public int GenerarTicket(){
        int aleatorio = (int)(Math.random() * 15000 + 1);
        return aleatorio;
    }

    public boolean ValidarTicket(int ticket){
        int a = GenerarTicket();
        //System.out.println(a);
        int b = GenerarTicket();
        //System.out.println(b);

        int lowerBound  = Math.min(a, b);
        int upperBound  = Math.max(a, b); 

        return ticket >= lowerBound && ticket <= upperBound;
    }

    public void ComprarBoleto(){
        int aleatorio = (int)(Math.random()* 3 + 1);
        aleatorio = 1;
        if(aleatorio == 1){
            System.out.println(localidadBarata);
            ValidarEspacio(localidadBarata);
            if (Espacio = true){
                ValidarDisponibilidad(localidadBarata);
                if (Disponible = true){
                    ValidarPrecio(localidadBarata);
                    if (Precio = false){
                    
                    }
                }
            }
        }
        if(aleatorio == 2){
            System.out.println(localidadMedia);
            ValidarEspacio(localidadMedia);
            if (Espacio = true){
                ValidarDisponibilidad(localidadMedia);
                if (Disponible = true){
                    ValidarPrecio(localidadMedia);
                    if (Precio = false){
                    
                    }
                }
            }
        }
        if(aleatorio == 3){
            System.out.println(localidadCara);
            ValidarEspacio(localidadCara);
            if (Espacio = true){
                ValidarDisponibilidad(localidadCara);
                if (Disponible = true){
                    ValidarPrecio(localidadCara);
                    if (Precio = false){
                    
                    }
                }
            }
        }
    }

    boolean Espacio;

    public void ValidarEspacio(Localidad localidad){
        if(localidad.getCapacidad() == 0){
            System.out.println("Ya no es posible comprar mas boletos para esta localidad");
            System.out.println("**Capacidad maxima alcanzada**");
            Espacio = true;
        }else{
            Espacio = false;
        }
    }

    boolean Precio;
    public void ValidarPrecio(Localidad localidad){
        if (usuario.getPresupuesto() < (localidad.getPrecio() *usuario.getNumBoletos())){
            System.out.println("No hay suficiente presupuesto para comprar " + usuario.getNumBoletos() + " boletos de la Localidad " + localidad.getNumLocalidad());
            Precio = false;
        } 
        else{
            System.out.println("Presupuesto aprobado para la compra de " + usuario.getNumBoletos() + " boletos para la localidad " + localidad.getNumLocalidad());
            System.out.println("---------------------------------------Factura boletos-----------------------------------------------");
            System.out.println("Compra de: " + usuario.getNumBoletos() + " boletos para la Localidad: " + localidad.getNumLocalidad() + " **Realizada**");
            System.out.println("Total a pagar: " + (usuario.getNumBoletos()*localidad.getPrecio()));
            System.out.println("-----------------------------------------------------------------------------------------------------");
            usuario.setPresupuesto(usuario.getPresupuesto() -(usuario.getNumBoletos()*localidad.getPrecio()));
            System.out.println("Presupuesto actual: " + usuario.getPresupuesto());
            Precio = true;
        }
    }

    boolean Disponible;
    public void ValidarDisponibilidad(Localidad localidad){
        Scanner scanner = new Scanner(System.in);
        if(usuario.getNumBoletos() > localidad.getCapacidad()){
           System.out.println("No hay suficiente espacio para la compra de " + usuario.getNumBoletos() + "de la localidad " + localidad.getNumLocalidad());
           System.out.println("Actualmente solo hay disponibles: " + localidad.getCapacidad());
           System.out.println("¿Desea continuar con la compra?");
           
           System.out.println("1. Si");
           System.out.println("2. No");
           System.out.print("Ingrese su opcción: ");
           int op = scanner.nextInt();
           if(op == 1){
                usuario.setNumBoletos(localidad.getCapacidad());
                int a = usuario.getNumBoletos();
                int b = localidad.getCapacidad();

                int nuevaCapacidad = b - a;

                localidad.setCapacidad(nuevaCapacidad);

                Disponible = true;                
           }else{
                System.out.println("**Compra cancelada**");
                Disponible = false;
           }
        }
        else{
            System.out.println("Si hay Boletos disponibles para su compra ");
            int a = usuario.getNumBoletos();
            int b = localidad.getCapacidad();

            int nuevaCapacidad = b - a;

            localidad.setCapacidad(nuevaCapacidad);
            Disponible = true;
        }
    }

    public void DisponibilidadTotal(){

        System.out.println("----------------------Vendidos----------------------");

        System.out.print("Localidad 1: ");
        System.out.println((localidadBarata.getCapacidad()-20)*-1);

        System.out.print("Localidad 5: ");
        System.out.println((localidadMedia.getCapacidad()-20)*-1);

        System.out.print("Localidad 10: ");
        System.out.println((localidadCara.getCapacidad()-20)*-1);

        System.out.println("----------------------Disponibles----------------------");

        System.out.print("Localidad 1: ");
        System.out.println(localidadBarata.getCapacidad());

        System.out.print("Localidad 5: ");
        System.out.println(localidadMedia.getCapacidad());

        System.out.print("Localidad 10: ");
        System.out.println(localidadCara.getCapacidad());
    }

    public void DisponibilidadIndividual(Localidad localidad){
        System.out.println("Hay *"+ localidad.getCapacidad() + "* boletos disponible para la *Localidad" + localidad.getNumLocalidad()+"*");
    }

    public void LeerLocalidad(){
        Scanner scanner = new Scanner(System.in);
        int localidad = scanner.nextInt();
            if (localidad == 1){
                DisponibilidadIndividual(localidadBarata);
            }
            if (localidad == 2){
                DisponibilidadIndividual(localidadMedia);
            }
            if (localidad == 3){
                DisponibilidadIndividual(localidadCara);;
            }
    }

    public void VentasPorLocalidad(Localidad localidad){
        System.out.println(localidad.getPrecio()*((localidad.getCapacidad()-20)*-1));
    }
    
    public void ReporteDeCaja(){
        System.out.println("------------Dinereo generado por localidad------------");
        System.out.print("Localidad 1: ");
        VentasPorLocalidad(localidadBarata);
        System.out.print("Localidad 5: ");
        VentasPorLocalidad(localidadMedia);
        System.out.print("Localidad 10: ");
        VentasPorLocalidad(localidadCara);
        System.out.println("--------------------Dinereo total---------------------");
        System.out.println((localidadBarata.getPrecio()*((localidadBarata.getCapacidad()-20)*-1))+(localidadMedia.getPrecio()*((localidadMedia.getCapacidad()-20)*-1))+
                                (localidadCara.getPrecio()*((localidadCara.getCapacidad()-20)*-1)));
    }
}
