import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Producto> listaProductos = new ArrayList<>();

        // Agregar todos los productos del listado
        listaProductos.add(new Producto("FIFA World Cup 26 Trionda Pro Ball", 170, "Futbol clasico", null, 0, 100));
        listaProductos.add(new Producto("FIFA World Cup 26 Trionda Competition Ball", 65, "Futbol clasico", null, 0, 100));
        listaProductos.add(new Producto("FIFA World Cup 26 Trionda Pro Beach Ball", 60, "Futbol playa", null, 0, 100));
        listaProductos.add(new Producto("FIFA World Cup 26 Trionda Pro Sala Ball", 60, "Futbol sala", null, 0, 100));
        listaProductos.add(new Producto("FIFA World Cup 26 Trionda League Beach Ball", 45, "Futbol playa", null, 0, 100));
        listaProductos.add(new Producto("FIFA World Cup 26 Trionda League Ball", 45, "Futbol clasico", null, 0, 100));
        listaProductos.add(new Producto("FIFA World Cup 26 Trionda Training Sala Ball", 40, "Futbol sala", null, 0, 100));
        listaProductos.add(new Producto("FIFA World Cup 26 Trionda Training Foil Ball", 38, "Futbol clasico", null, 0, 100));
        listaProductos.add(new Producto("FIFA World Cup 26 Trionda Training Ball", 32, "Futbol clasico", null, 0, 100));
        listaProductos.add(new Producto("FIFA World Cup 26 Trionda Club Ball", 25, "Futbol clasico", null, 0, 100));
        listaProductos.add(new Producto("Conext 25 League Ball", 40, "Futbol clasico", null, 0, 100));
        listaProductos.add(new Producto("Tango Glider Ball", 25, "Futbol clasico", null, 0, 100));

        // Mostrar productos
        for (Producto p : listaProductos) {
            p.mostrarProducto();
        }
    }
}
