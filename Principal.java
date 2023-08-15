import java.util.Scanner;

public class Principal{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Venta venta = new Venta();
        System.out.println("-----------Registro de primer Inicio----------");
        venta.CrearUsuaio();
        System.out.println("----------------------------------------------");

        int opcion;
        do{
            System.out.println("----------------------Menú----------------------");
            System.out.println("1. Nuevo comprador");
            System.out.println("2. Nuevo solicitud de boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Reporte de caja");
            System.out.println("6. Salir ");
            System.out.println("------------------------------------------------");
            System.out.print("Ingrese su opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("----------------------Crear Usuario----------------------");
                    venta.CrearUsuaio();
                    break;
                
                case 2:
                    
                    System.out.println("----------------------Solicitud de Compra----------------------");
                    int ticket = venta.GenerarTicket();

                    if (venta.ValidarTicket(ticket)) {
                        System.out.println("El ticket " + ticket + " puede comprar boletos.");
                        venta.ComprarBoleto();
                    } else {
                        System.out.println("El ticket " + ticket + " no puede comprar boletos.");
                    }

                    break;

                case 3:
                    venta.DisponibilidadTotal();
                    break;

                case 4:
                    System.out.println("----------------------Localidades----------------------");
                    System.out.println("1. Localidad 1");
                    System.out.println("2. Localidad 5");
                    System.out.println("3. Localidad 10");
                    System.out.println("------------------------------------------------");
                    System.out.print("Ingrese su opción: ");
                    venta.LeerLocalidad();
                    break;
                
                case 5:
                    venta.ReporteDeCaja();
                    break;

                case 6:
                    System.out.println("Vuelva pronto!");
                    break;
            
                default:
                    System.out.println("Ingrese una opción valida");
                    break;
            }
        }while(opcion <= 5);
    }

}