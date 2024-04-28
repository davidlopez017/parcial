import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Producto {
    private final Map<String, Integer> inventario;

    public Producto() {
        this.inventario = new HashMap<>();
    }

    public void agregarProducto(Scanner scanner) {
        System.out.print("\nIngrese el nombre de la fruta que desea añadir: ");
        String nombreProducto = scanner.next().trim();
        System.out.print("Ingrese la cantidad de frutas: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor, ingrese un número válido: ");
            scanner.next();
        }
        int cantidad = scanner.nextInt();
        inventario.put(nombreProducto, cantidad);
        System.out.println("Fruta agregada exitosamente al inventario.");
    }

    public void mostrarInventario() {
        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            System.out.println("Inventario:");
            for (Map.Entry<String, Integer> entry : inventario.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    public void duplicarProducto(Scanner scanner) {
        System.out.print("\nIngrese el nombre de la fruta que desea duplicar: ");
        String nombreProducto = scanner.next().trim();
        if (!inventario.containsKey(nombreProducto)) {
            System.out.println("La fruta no está en el inventario.");
        } else {
            int cantidad = inventario.get(nombreProducto);
            inventario.put(nombreProducto, cantidad * 2);
            System.out.println("Inventario duplicado exitosamente para la fruta '" + nombreProducto + "'.");
        }
    }

    public void venderProducto(Scanner scanner) {
        System.out.print("\nIngrese el nombre de la fruta a vender: ");
        String nombreProducto = scanner.next().trim();
        if (!inventario.containsKey(nombreProducto)) {
            System.out.println("La fruta no está en el inventario.");
        } else {
            int cantidadDisponible = inventario.get(nombreProducto);
            System.out.print("Ingrese la cantidad a vender: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Por favor, ingrese un número válido: ");
                scanner.next();
            }
            int cantidadVenta = scanner.nextInt();
            if (cantidadVenta > cantidadDisponible) {
                System.out.println("No hay suficiente stock disponible para esta venta.");
            } else {
                inventario.put(nombreProducto, cantidadDisponible - cantidadVenta);
                System.out.println("Venta realizada correctamente. Inventario actualizado.");
            }
        }
    }
}

