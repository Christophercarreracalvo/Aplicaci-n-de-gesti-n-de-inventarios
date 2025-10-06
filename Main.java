import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    private static ListaProductos listaProductos = new ListaProductos();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        menu();
    }
public static void menu() {
    int opcion = -1;
    do {
        try {
            System.out.println("\n=== SISTEMA DE GESTIÓN DE PRODUCTOS ===");
            System.out.println("1. Agregar producto al inicio");
            System.out.println("2. Agregar producto al final");
            System.out.println("3. Mostrar todos los productos");
            System.out.println("4. Buscar producto");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Imprimir reporte de costos");
            System.out.println("7. Agregar imagen a producto");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            String input = reader.readLine();
            opcion = Integer.parseInt(input);

            switch (opcion) {
                case 1:
                    agregarProductoInicio();
                    break;
                case 2:
                    agregarProductoFinal();
                    break;
                case 3:
                    listaProductos.mostrarTodosProductos();
                    break;
                case 4:
                    buscarProducto();
                    break;
                case 5:
                    eliminarProducto();
                    break;
                case 6:
                    listaProductos.imprimirReporteCostos();
                    break;
                case 7:
                    agregarImagenProducto();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un número válido.");
        }
    } while (opcion != 0);
}

private static void agregarProductoInicio() {
    try {
        System.out.println("\n--- AGREGAR PRODUCTO AL INICIO ---");
        Producto producto = leerDatosProducto();
        listaProductos.insertarInicio(producto);
        System.out.println("Producto agregado al inicio exitosamente.");
    } catch (IOException e) {
        System.out.println("Error al leer los datos: " + e.getMessage());
    }
}

private static void agregarProductoFinal() {
    try {
        System.out.println("\n--- AGREGAR PRODUCTO AL FINAL ---");
        Producto producto = leerDatosProducto();
        listaProductos.insertarFinal(producto);
        System.out.println("Producto agregado al final exitosamente.");
    } catch (IOException e) {
        System.out.println("Error al leer los datos: " + e.getMessage());
    }
}

private static Producto leerDatosProducto() throws IOException {
    System.out.print("Nombre: ");
    String nombre = reader.readLine();

    System.out.print("Precio: ");
    double precio = Double.parseDouble(reader.readLine());

    System.out.print("Categoría: ");
    String categoria = reader.readLine();

    System.out.print("Fecha de vencimiento (o Enter si no aplica): ");
    String fechaVencimiento = reader.readLine();
    if (fechaVencimiento.isEmpty()) {
        fechaVencimiento = null;
    }

    System.out.print("Cantidad para carrito: ");
    int cantidad = Integer.parseInt(reader.readLine());

    System.out.print("Cantidad en inventario: ");
    int inventario = Integer.parseInt(reader.readLine());

    Producto producto = new Producto(nombre, precio, categoria, fechaVencimiento, cantidad, inventario);

    // Opción para agregar imágenes
    System.out.print("¿Desea agregar una imagen? (s/n): ");
    String respuesta = reader.readLine();
    if (respuesta.equalsIgnoreCase("s")) {
        System.out.print("Ruta de la imagen: ");
        String rutaImagen = reader.readLine();
        producto.agregarImagen(rutaImagen);
    }

    return producto;
}

private static void buscarProducto() {
    try {
        System.out.print("\nIngrese el nombre del producto a buscar: ");
        String nombre = reader.readLine();
        Producto producto = listaProductos.buscarProducto(nombre);
        if (producto != null) {
            producto.mostrarProducto();
        }
    } catch (IOException e) {
        System.out.println("Error al leer el nombre: " + e.getMessage());
    }
}

private static void eliminarProducto() {
    try {
        System.out.print("\nIngrese el nombre del producto a eliminar: ");
        String nombre = reader.readLine();
        listaProductos.eliminarProducto(nombre);
    } catch (IOException e) {
        System.out.println("Error al leer el nombre: " + e.getMessage());
    }
}

private static void agregarImagenProducto() {
    try {
        System.out.print("\nIngrese el nombre del producto al que agregará la imagen: ");
        String nombre = reader.readLine();

        Producto producto = listaProductos.buscarProducto(nombre);
        if (producto != null) {
            System.out.print("Ingrese la ruta de la imagen: ");
            String rutaImagen = reader.readLine();
            producto.agregarImagen(rutaImagen);
            System.out.println("Imagen agregada exitosamente.");
        }
    } catch (IOException e) {
        System.out.println("Error al leer los datos: " + e.getMessage());
    }
}

}

//        ArrayList<Producto> listaProductos = new ArrayList<>();
//
//        // Agregar todos los productos del listado
//        listaProductos.add(new Producto("FIFA World Cup 26 Trionda Pro Ball", 170, "Futbol clasico", null, 0, 100));
//        listaProductos.add(new Producto("FIFA World Cup 26 Trionda Competition Ball", 65, "Futbol clasico", null, 0, 100));
//        listaProductos.add(new Producto("FIFA World Cup 26 Trionda Pro Beach Ball", 60, "Futbol playa", null, 0, 100));
//        listaProductos.add(new Producto("FIFA World Cup 26 Trionda Pro Sala Ball", 60, "Futbol sala", null, 0, 100));
//        listaProductos.add(new Producto("FIFA World Cup 26 Trionda League Beach Ball", 45, "Futbol playa", null, 0, 100));
//        listaProductos.add(new Producto("FIFA World Cup 26 Trionda League Ball", 45, "Futbol clasico", null, 0, 100));
//        listaProductos.add(new Producto("FIFA World Cup 26 Trionda Training Sala Ball", 40, "Futbol sala", null, 0, 100));
//        listaProductos.add(new Producto("FIFA World Cup 26 Trionda Training Foil Ball", 38, "Futbol clasico", null, 0, 100));
//        listaProductos.add(new Producto("FIFA World Cup 26 Trionda Training Ball", 32, "Futbol clasico", null, 0, 100));
//        listaProductos.add(new Producto("FIFA World Cup 26 Trionda Club Ball", 25, "Futbol clasico", null, 0, 100));
//        listaProductos.add(new Producto("Conext 25 League Ball", 40, "Futbol clasico", null, 0, 100));
//        listaProductos.add(new Producto("Tango Glider Ball", 25, "Futbol clasico", null, 0, 100));
//
//        // Mostrar productos
//        for (Producto p : listaProductos) {
//            p.mostrarProducto();
//        }
//    }


