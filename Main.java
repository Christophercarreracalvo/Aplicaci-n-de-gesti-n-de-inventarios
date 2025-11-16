import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    private static Tienda tienda = new Tienda("Mi Tienda Deportiva");
    private static ListaProductos listaGlobal = new ListaProductos();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        System.out.println("🚀 INICIANDO SISTEMA DE GESTIÓN DE TIENDA...");
        inicializarDatosEjemplo();
        menuPrincipal();
    }

    private static void inicializarDatosEjemplo() {
        // Productos para el inventario de la tienda
        tienda.agregarProductoInventario(new Producto("FIFA World Cup 26 Trionda Pro Ball", 170, "Futbol clasico", null, 0, 100));
        tienda.agregarProductoInventario(new Producto("FIFA World Cup 26 Trionda Competition Ball", 65, "Futbol clasico", null, 0, 100));
        tienda.agregarProductoInventario(new Producto("FIFA World Cup 26 Trionda Pro Beach Ball", 60, "Futbol playa", null, 0, 100));
        tienda.agregarProductoInventario(new Producto("Conext 25 League Ball", 40, "Futbol clasico", null, 0, 100));
        tienda.agregarProductoInventario(new Producto("Tango Glider Ball", 25, "Futbol clasico", null, 0, 100));

        // Productos para la lista global
        listaGlobal.insertarFinal(new Producto("FIFA World Cup 26 Trionda Pro Ball", 170, "Futbol clasico", null, 2, 100));
        listaGlobal.insertarFinal(new Producto("Tango Glider Ball", 25, "Futbol clasico", null, 5, 100));

        System.out.println("✅ Datos de ejemplo cargados exitosamente.");
    }

    public static void menuPrincipal() {
        int opcion = -1;
        do {
            try {
                System.out.println("\n" + "═".repeat(50));
                System.out.println("🏪  SISTEMA INTEGRADO DE GESTIÓN DE TIENDA  🏪");
                System.out.println("═".repeat(50));
                System.out.println("1. 📋  Gestión de Lista de Productos ");
                System.out.println("2. 🏬  Gestión de Tienda Completa ");
                System.out.println("3. 📊  Estado General del Sistema");
                System.out.println("0. 🚪  Salir");
                System.out.println("═".repeat(50));
                System.out.print("Seleccione una opción: ");

                String input = reader.readLine();
                opcion = Integer.parseInt(input);

                switch (opcion) {
                    case 1:
                        menuGestionListaProductos();
                        break;
                    case 2:
                        menuGestionTienda();
                        break;
                    case 3:
                        mostrarEstadoGeneral();
                        break;
                    case 0:
                        System.out.println("👋 ¡Gracias por usar el sistema! ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("❌ Opción no válida. Por favor, intente nuevamente.");
                }
            } catch (IOException e) {
                System.out.println("❌ Error de entrada/salida: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("❌ Por favor, ingrese un número válido.");
            }
        } while (opcion != 0);
    }

    // MENÚ PARA GESTIÓN DE LISTA DE PRODUCTOS
    private static void menuGestionListaProductos() {
        int opcion = -1;
        do {
            try {
                System.out.println("\n" + "─".repeat(60));
                System.out.println("📋  GESTIÓN DE LISTA DE PRODUCTOS ");
                System.out.println("─".repeat(60));
                System.out.println("1. ➕  Agregar producto al INICIO de la lista");
                System.out.println("2. ➕  Agregar producto al FINAL de la lista");
                System.out.println("3. 👁️  Mostrar TODOS los productos de la lista");
                System.out.println("4. 🔍  Buscar producto por nombre");
                System.out.println("5. 🗑️   Eliminar producto de la lista");
                System.out.println("6. 📈  Imprimir REPORTE DE COSTOS de la lista");
                System.out.println("7. 🖼️   Agregar imagen a producto existente");
                System.out.println("8. 🔄  Cargar productos de ejemplo");
                System.out.println("0. ↩️   Volver al menú principal");
                System.out.println("─".repeat(60));
                System.out.print("Seleccione una opción: ");

                opcion = Integer.parseInt(reader.readLine());

                switch (opcion) {
                    case 1:
                        agregarProductoInicio();
                        break;
                    case 2:
                        agregarProductoFinal();
                        break;
                    case 3:
                        listaGlobal.mostrarTodosProductos();
                        break;
                    case 4:
                        buscarProductoLista();
                        break;
                    case 5:
                        eliminarProductoLista();
                        break;
                    case 6:
                        listaGlobal.imprimirReporteCostos();
                        break;
                    case 7:
                        agregarImagenProductoLista();
                        break;
                    case 8:
                        cargarProductosEjemploLista();
                        break;
                    case 0:
                        System.out.println("↩️ Volviendo al menú principal...");
                        break;
                    default:
                        System.out.println("❌ Opción no válida.");
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("❌ Error: " + e.getMessage());
            }
        } while (opcion != 0);
    }

    // MENÚ PARA GESTIÓN DE TIENDA
    private static void menuGestionTienda() {
        int opcion = -1;
        do {
            try {
                System.out.println("\n" + "─".repeat(60));
                System.out.println("🏬  GESTIÓN COMPLETA DE TIENDA ");
                System.out.println("─".repeat(60));
                System.out.println("1. 📦  Gestión de INVENTARIO");
                System.out.println("2. 👥  Gestión de CLIENTES");
                System.out.println("3. ⚡  ATENDER siguiente cliente en cola");
                System.out.println("4. 📊  Estado ACTUAL de la tienda");
                System.out.println("5. 🔄  Cargar datos de ejemplo");
                System.out.println("0. ↩️   Volver al menú principal");
                System.out.println("─".repeat(60));
                System.out.print("Seleccione una opción: ");

                opcion = Integer.parseInt(reader.readLine());

                switch (opcion) {
                    case 1:
                        menuGestionInventario();
                        break;
                    case 2:
                        menuGestionClientes();
                        break;
                    case 3:
                        tienda.atenderSiguienteCliente();
                        break;
                    case 4:
                        tienda.mostrarEstadoTienda();
                        break;
                    case 5:
                        cargarDatosEjemploTienda();
                        break;
                    case 0:
                        System.out.println("↩️ Volviendo al menú principal...");
                        break;
                    default:
                        System.out.println("❌ Opción no válida.");
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("❌ Error: " + e.getMessage());
            }
        } while (opcion != 0);
    }

    // SUBMENÚ PARA GESTIÓN DE INVENTARIO
    private static void menuGestionInventario() throws IOException {
        int opcion = -1;
        do {
            System.out.println("\n" + "─".repeat(50));
            System.out.println("📦  GESTIÓN DE INVENTARIO");
            System.out.println("─".repeat(50));
            System.out.println("1. ➕  Agregar producto al inventario");
            System.out.println("2. 👁️  Mostrar inventario COMPLETO");
            System.out.println("3. 📋  Listar productos disponibles");
            System.out.println("4. 🔍  Buscar producto en inventario");
            System.out.println("0. ↩️   Volver al menú anterior");
            System.out.println("─".repeat(50));
            System.out.print("Seleccione una opción: ");

            opcion = Integer.parseInt(reader.readLine());

            switch (opcion) {
                case 1:
                    agregarProductoInventario();
                    break;
                case 2:
                    tienda.mostrarInventario();
                    break;
                case 3:
                    tienda.listarProductosDisponibles();
                    break;
                case 4:
                    buscarProductoInventario();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("❌ Opción no válida.");
            }
        } while (opcion != 0);
    }

    // 👥 SUBMENÚ PARA GESTIÓN DE CLIENTES
    private static void menuGestionClientes() throws IOException {
        int opcion = -1;
        do {
            System.out.println("\n" + "─".repeat(50));
            System.out.println("👥  GESTIÓN DE CLIENTES");
            System.out.println("─".repeat(50));
            System.out.println("1. ➕  Agregar cliente a la COLA");
            System.out.println("2. 📊  Mostrar estado de la COLA");
            System.out.println("0. ↩️   Volver al menú anterior");
            System.out.println("─".repeat(50));
            System.out.print("Seleccione una opción: ");

            opcion = Integer.parseInt(reader.readLine());

            switch (opcion) {
                case 1:
                    agregarClienteCola();
                    break;
                case 2:
                    tienda.getColaClientes().mostrarEstadoCola();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("❌ Opción no válida.");
            }
        } while (opcion != 0);
    }

    //MÉTODO PARA MOSTRAR ESTADO GENERAL
    private static void mostrarEstadoGeneral() {
        System.out.println("\n" + "⭐".repeat(60));
        System.out.println("📊  ESTADO GENERAL DEL SISTEMA");
        System.out.println("⭐".repeat(60));

        // Estado de la lista global
        System.out.println("\n📋  LISTA GLOBAL DE PRODUCTOS:");
        if (listaGlobal.getPrimero() == null) {
            System.out.println("   No hay productos en la lista global");
        } else {
            System.out.println("   Total de productos: " + listaGlobal.obtenerTamano());
            listaGlobal.imprimirReporteCostos();
        }

        // Estado de la tienda
        tienda.mostrarEstadoTienda();
    }

    // 🎯 MÉTODOS PARA GESTIÓN DE LISTA
    private static void agregarProductoInicio() throws IOException {
        System.out.println("\n🎯 AGREGAR PRODUCTO AL INICIO DE LA LISTA");
        Producto producto = leerDatosProducto();
        listaGlobal.insertarInicio(producto);
        System.out.println("✅ Producto agregado al INICIO de la lista exitosamente.");
    }

    private static void agregarProductoFinal() throws IOException {
        System.out.println("\n🎯 AGREGAR PRODUCTO AL FINAL DE LA LISTA");
        Producto producto = leerDatosProducto();
        listaGlobal.insertarFinal(producto);
        System.out.println("✅ Producto agregado al FINAL de la lista exitosamente.");
    }

    private static void buscarProductoLista() throws IOException {
        System.out.print("\n🔍 Ingrese el nombre del producto a buscar: ");
        String nombre = reader.readLine();
        Producto producto = listaGlobal.buscarProducto(nombre);
        if (producto != null) {
            producto.mostrarProducto();
        }
    }

    private static void eliminarProductoLista() throws IOException {
        System.out.print("\n🗑️  Ingrese el nombre del producto a eliminar: ");
        String nombre = reader.readLine();
        listaGlobal.eliminarProducto(nombre);
    }

    private static void agregarImagenProductoLista() throws IOException {
        System.out.print("\n🖼️  Ingrese el nombre del producto: ");
        String nombre = reader.readLine();
        Producto producto = listaGlobal.buscarProducto(nombre);
        if (producto != null) {
            System.out.print("📁 Ingrese la ruta de la imagen: ");
            String rutaImagen = reader.readLine();
            producto.agregarImagen(rutaImagen);
            System.out.println("✅ Imagen agregada exitosamente.");
        }
    }

    private static void cargarProductosEjemploLista() {
        listaGlobal.insertarFinal(new Producto("Balón de Práctica", 15, "Futbol", null, 10, 50));
        listaGlobal.insertarFinal(new Producto("Balón Profesional", 80, "Futbol", null, 3, 30));
        System.out.println("✅ Productos de ejemplo cargados en la lista global.");
    }

    // 🏬 MÉTODOS PARA GESTIÓN DE TIENDA
    private static void agregarProductoInventario() throws IOException {
        System.out.println("\n📦 AGREGAR PRODUCTO AL INVENTARIO DE LA TIENDA");
        Producto producto = leerDatosProducto();
        tienda.agregarProductoInventario(producto);
    }

    private static void buscarProductoInventario() throws IOException {
        System.out.print("\n🔍 Ingrese el nombre del producto a buscar: ");
        String nombre = reader.readLine();
        Producto producto = tienda.buscarProductoInventario(nombre);
        if (producto != null) {
            producto.mostrarProducto();
        } else {
            System.out.println("❌ Producto no encontrado en el inventario.");
        }
    }

    private static void agregarClienteCola() throws IOException {
        tienda.crearClienteConCarrito();
    }



    private static void cargarDatosEjemploTienda() {
        // Agregar algunos clientes de ejemplo
        Cliente cliente1 = new Cliente("Juan Pérez", 1);
        cliente1.agregarAlCarrito(tienda.buscarProductoInventario("Tango Glider Ball"), 2);

        Cliente cliente2 = new Cliente("María García", 2);
        cliente2.agregarAlCarrito(tienda.buscarProductoInventario("FIFA World Cup 26 Trionda Pro Ball"), 1);

        Cliente cliente3 = new Cliente("Carlos López", 3);
        cliente3.agregarAlCarrito(tienda.buscarProductoInventario("Conext 25 League Ball"), 3);

        tienda.agregarCliente(cliente1);
        tienda.agregarCliente(cliente2);
        tienda.agregarCliente(cliente3);

        System.out.println("✅ Datos de ejemplo cargados en la tienda.");
    }

    // MÉTODO COMPARTIDO PARA LEER DATOS DE PRODUCTO
    private static Producto leerDatosProducto() throws IOException {
        System.out.println("\n📝 INGRESE LOS DATOS DEL PRODUCTO:");
        System.out.print("   Nombre: ");
        String nombre = reader.readLine();

        System.out.print("   Precio: $");
        double precio = Double.parseDouble(reader.readLine());

        System.out.print("   Categoría: ");
        String categoria = reader.readLine();

        System.out.print("   Fecha de vencimiento (Enter si no aplica): ");
        String fechaVencimiento = reader.readLine();
        if (fechaVencimiento.isEmpty()) {
            fechaVencimiento = null;
        }

        System.out.print("   Cantidad inicial: ");
        int cantidad = Integer.parseInt(reader.readLine());

        System.out.print("   Inventario disponible: ");
        int inventario = Integer.parseInt(reader.readLine());

        Producto producto = new Producto(nombre, precio, categoria, fechaVencimiento, cantidad, inventario);

        // Opción para agregar imágenes
        System.out.print("   ¿Desea agregar una imagen? (s/n): ");
        String respuesta = reader.readLine();
        if (respuesta.equalsIgnoreCase("s")) {
            System.out.print("   Ruta de la imagen: ");
            String rutaImagen = reader.readLine();
            producto.agregarImagen(rutaImagen);
        }

        return producto;
    }
}