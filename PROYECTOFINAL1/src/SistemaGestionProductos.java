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

    // 2. Metodo para registrar producto
    static void registrarProducto(Scanner sc) {

        if (!nombre.equals("N/A")) {
            System.out.print("Ya existe un producto. ¿Desea sobrescribirlo? (s/n): ");
            String respuesta = sc.nextLine();

            if (!respuesta.equalsIgnoreCase("s")) {
                System.out.println("Registro cancelado.");
                return;
            }
        }

        String nuevoNombre;
        double nuevoPrecio;
        int nuevaCantidad;

        do {
            System.out.print("Ingrese nombre del producto: ");
            nuevoNombre = sc.nextLine();
        } while (!validarNombre(nuevoNombre));

        do {
            System.out.print("Ingrese precio unitario: ");
            nuevoPrecio = sc.nextDouble();
        } while (!validarPrecio(nuevoPrecio));

        do {
            System.out.print("Ingrese cantidad en inventario: ");
            nuevaCantidad = sc.nextInt();
        } while (!validarCantidad(nuevaCantidad));

        nombre = nuevoNombre;
        precio = nuevoPrecio;
        cantidad = nuevaCantidad;

        System.out.println("Producto registrado correctamente.");
    }

    // 3. Metodo para mostrar producto
    static void mostrarProducto() {
        if (nombre.equals("N/A")) {
            System.out.println("No hay datos de producto registrados actualmente.");
            return;
        }

        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Cantidad: " + cantidad);
    }

    // 4. Metodo para calcular valor del inventario
    static double calcularValorInventario() {
        if (nombre.equals("N/A")) {
            System.out.println("No hay datos para calcular el inventario.");
            return 0.0;
        }

        double total = precio * cantidad;
        System.out.printf("Valor total del inventario: $%.2f%n", total);
        return total;
    }

    // 5. Metodo para mostrar un resumen completo
    static void mostrarResumenProducto() {
        if (nombre.equals("N/A")) {
            System.out.println("No hay producto registrado.");
            return;
        }

        double total = precio * cantidad;
        String estadoStock;

        if (cantidad < 5) {
            estadoStock = "Stock bajo";
        } else if (cantidad <= 20) {
            estadoStock = "Stock suficiente";
        } else {
            estadoStock = "Stock alto";
        }

        System.out.println("\n--- Resumen del Producto ---");
        System.out.println("Nombre: " + nombre);
        System.out.printf("Precio Unitario: $%.2f%n", precio);
        System.out.println("Cantidad en Inventario: " + cantidad);
        System.out.printf("Valor Total en Inventario: $%.2f%n", total);
        System.out.println("Estado del Stock: " + estadoStock);
    }

    // 6. Metodo para limpiar datos
    static void limpiarProducto() {
        nombre = "N/A";
        precio = 0.0;
        cantidad = 0;
        System.out.println("Los datos del producto actual han sido borrados exitosamente.");
    }

    // 7. Metodo para validar precio 
    static boolean validarPrecio(double p) {
        if (p <= 0) {
            System.out.println("El precio debe ser mayor que 0.");
            return false;
        }
        return true;
    }

    // 8. Metodo para validar cantidad
    static boolean validarCantidad(int c) {
        if (c < 0) {
            System.out.println("La cantidad no puede ser negativa.");
            return false;
        }
        return true;
    }

    // 9. Metodo para validar nombre
    static boolean validarNombre(String n) {
        if (n == null || n.trim().isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            return false;
        }
        return true;
    }

    
}
