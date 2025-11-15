public class Cliente {
    private String nombre;
    private int prioridad; // 1: básico, 2: afiliado, 3: premium
    private ListaProductos carrito;

    public Cliente(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.carrito = new ListaProductos();
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getPrioridad() { return prioridad; }
    public void setPrioridad(int prioridad) {
        if (prioridad >= 1 && prioridad <= 3) {
            this.prioridad = prioridad;
        }
    }

    public ListaProductos getCarrito() { return carrito; }

    // Método para agregar producto al carrito
    public void agregarAlCarrito(Producto producto, int cantidad) {
        // Crear una copia del producto con la cantidad deseada
        Producto productoCarrito = producto.crearCopiaParaCarrito(cantidad);
        carrito.insertarFinal(productoCarrito);
    }

    // Calcular total del carrito
    public double calcularTotalCarrito() {
        return carrito.calcularTotalCarrito();
    }

    // Mostrar factura
    public void mostrarFactura() {
        System.out.println("\n" + "═".repeat(50));
        System.out.println("🎫 FACTURA - " + nombre.toUpperCase());
        System.out.println("═".repeat(50));
        System.out.println("👤 Cliente: " + nombre);
        System.out.println("🎯 Tipo: " + getTipoCliente());
        System.out.println("📦 Productos en carrito: " + carrito.obtenerTamano());
        System.out.println("\n--- PRODUCTOS COMPRADOS ---");

        if (carrito.estaVacia()) {
            System.out.println("El carrito está vacío.");
        } else {
            Producto actual = carrito.getPrimero();
            int contador = 1;
            while (actual != null) {
                System.out.print(contador + ". ");
                actual.mostrarInfoCarrito();
                actual = actual.getSiguiente();
                contador++;
            }
        }

        System.out.println("\n" + "─".repeat(30));
        System.out.println("💰 TOTAL A PAGAR: $" + calcularTotalCarrito());
        System.out.println("═".repeat(50));
    }

    public String getTipoCliente() {
        switch (prioridad) {
            case 1: return "🟢 Básico";
            case 2: return "🟡 Afiliado";
            case 3: return "🔴 Premium";
            default: return "Desconocido";
        }
    }

    // Método para vaciar carrito después de la compra
    public void vaciarCarrito() {
        this.carrito = new ListaProductos();
    }
}