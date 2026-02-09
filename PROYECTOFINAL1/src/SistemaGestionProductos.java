import java.util.Scanner;

public class SistemaGestionProductos {

    // Variables estáticas del producto
    static String nombre = "N/A";
    static double precio = 0.0;
    static int cantidad = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    registrarProducto(sc);
                    break;
                case 2:
                    mostrarProducto();
                    break;
                case 3:
                    calcularValorInventario();
                    break;
                case 4:
                    mostrarResumenProducto();
                    break;
                case 5:
                    limpiarProducto();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }

    // 1. Mostrar menú
    static void mostrarMenu() {
        System.out.println("\n--- Sistema de Gestión de Productos ---");
        System.out.println("1. Registrar nuevo producto");
        System.out.println("2. Mostrar información del producto actual");
        System.out.println("3. Calcular valor total del inventario");
        System.out.println("4. Mostrar resumen completo del producto");
        System.out.println("5. Limpiar datos del producto actual");
        System.out.println("0. Salir");
        System.out.print("Ingrese su opción: ");
    }

    
}
