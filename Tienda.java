public class Tienda {
    private String nombre;
    private ArbolProductos inventario;
    private ColaClientes colaClientes;

    public Tienda(String nombre) {
        this.nombre = nombre;
        this.inventario = new ArbolProductos();
        this.colaClientes = new ColaClientes();
    }

    // Getters
    public String getNombre() { return nombre; }
    public ArbolProductos getInventario() { return inventario; }
    public ColaClientes getColaClientes() { return colaClientes; }

    // Agregar producto al inventario
    public void agregarProductoInventario(Producto producto) {
        inventario.insertar(producto);
        System.out.println("✅ Producto '" + producto.getNombre() + "' agregado al inventario.");
    }

    // Buscar producto en inventario
    public Producto buscarProductoInventario(String nombre) {
        return inventario.buscar(nombre);
    }

    // Mostrar inventario completo
    public void mostrarInventario() {
        inventario.mostrarInventario();
    }

    // Listar productos disponibles (nombre y precio)
    public void listarProductosDisponibles() {
        inventario.listarProductosDisponibles();
    }

    // Agregar cliente a la cola
    public void agregarCliente(Cliente cliente) {
        colaClientes.encolar(cliente);
    }

    // Atender siguiente cliente
    public void atenderSiguienteCliente() {
        Cliente cliente = colaClientes.atenderSiguiente();
        if (cliente != null) {
            System.out.println("\n" + "⭐".repeat(60));
            System.out.println("🎉 ATENDIENDO A CLIENTE: " + cliente.getNombre().toUpperCase());
            System.out.println("⭐".repeat(60));

            // Mostrar factura
            cliente.mostrarFactura();

            // Actualizar inventario después de la compra
            actualizarInventario(cliente);

            // Vaciar carrito del cliente
            cliente.vaciarCarrito();

            System.out.println("✅ Cliente atendido exitosamente.");
        }
    }

    // Actualizar inventario después de una compra
    private void actualizarInventario(Cliente cliente) {
        Producto actual = cliente.getCarrito().getPrimero();
        while (actual != null) {
            Producto productoInventario = inventario.buscar(actual.getNombre());

            if (productoInventario != null) {
                // Reducir el inventario
                boolean exito = productoInventario.reducirInventario(actual.getCantidad());
                if (exito) {
                    System.out.println("✅ Inventario actualizado: " + actual.getNombre() +
                            " -" + actual.getCantidad() + " unidades");
                } else {
                    System.out.println("❌ Error al actualizar inventario para: " + actual.getNombre());
                }
            }
            actual = actual.getSiguiente();
        }
    }

    // Mostrar estado de la tienda
    public void mostrarEstadoTienda() {
        System.out.println("\n" + "🏪".repeat(60));
        System.out.println("📊 ESTADO DE LA TIENDA: " + nombre.toUpperCase());
        System.out.println("🏪".repeat(60));

        // Estado del inventario
        System.out.println("\n📦 INVENTARIO:");
        if (inventario.estaVacio()) {
            System.out.println("   No hay productos en el inventario.");
        } else {
            System.out.println("   Productos registrados: " + (contarProductosInventario(inventario.getRaiz())) + " productos");
        }

        // Estado de la cola
        colaClientes.mostrarEstadoCola();
    }

    // Método auxiliar para contar productos en el inventario
    private int contarProductosInventario(Producto nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + contarProductosInventario(nodo.getIzquierdo()) + contarProductosInventario(nodo.getDerecho());
    }

    // Verificar disponibilidad de producto
    public boolean verificarDisponibilidad(String nombreProducto, int cantidad) {
        Producto producto = inventario.buscar(nombreProducto);
        return producto != null && producto.haySuficienteInventario(cantidad);
    }
}