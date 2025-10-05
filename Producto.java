import java.util.ArrayList;

public class Producto {
    // Atributos principales
    private String nombre;
    private double precio;
    private String categoria;
    private String fechaVencimiento; // puede ser null si no aplica
    private int cantidad;            // cantidad que se maneja en el carrito
    private int inventario;          // cantidad en inventario de la tienda
    private ArrayList<String> listaImagenes; // rutas de imágenes del producto

    // Constructor
    public Producto(String nombre, double precio, String categoria, String fechaVencimiento, int cantidad, int inventario) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.fechaVencimiento = fechaVencimiento;
        this.cantidad = cantidad;
        this.inventario = inventario;
        this.listaImagenes = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(String fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public int getInventario() { return inventario; }
    public void setInventario(int inventario) { this.inventario = inventario; }

    public ArrayList<String> getListaImagenes() { return listaImagenes; }

    // Método para añadir imágenes
    public void agregarImagen(String rutaImagen) {
        listaImagenes.add(rutaImagen);
    }

    // Método para calcular el costo total de este producto según la cantidad
    public double calcularCostoTotal() {
        return cantidad * precio;
    }

    // Método para mostrar información del producto
    public void mostrarProducto() {
        System.out.println("=== Producto ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Categoría: " + categoria);
        if (fechaVencimiento != null) {
            System.out.println("Fecha de Vencimiento: " + fechaVencimiento);
        } else {
            System.out.println("Fecha de Vencimiento: No aplica");
        }
        System.out.println("Cantidad (carrito): " + cantidad);
        System.out.println("Inventario disponible: " + inventario);
        System.out.println("Imágenes: " + listaImagenes);
        System.out.println("Costo total del producto: $" + calcularCostoTotal());
        System.out.println("===================");
    }
}
