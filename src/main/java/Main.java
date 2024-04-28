import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Producto producto = new Producto();
        Scanner scanner = new Scanner(System.in);

        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            int opcion = obtenerOpcion(scanner);

            switch (opcion) {
                case 1:
                    producto.agregarProducto(scanner);
                    break;
                case 2:
                    producto.mostrarInventario();
                    break;
                case 3:
                    producto.duplicarProducto(scanner);
                    break;
                case 4:
                    producto.venderProducto(scanner);
                    break;
                case 5:
                    salir = true;
                    System.out.println("Gracias y vuelva pronto :D");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.");
            }
        }
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\nBienvenidos A la Tienda de Frutas");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Agregar una nueva fruta");
        System.out.println("2. Mostrar el inventario");
        System.out.println("3. Duplicar la cantidad de fruta");
        System.out.println("4. Vender fruta");
        System.out.println("5. Salir");
    }

    private static int obtenerOpcion(Scanner scanner) {
        System.out.print("Ingrese el número de opción: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor, ingrese un número válido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
