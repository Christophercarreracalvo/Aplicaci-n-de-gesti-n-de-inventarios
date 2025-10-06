public class ListaProductos {
    private NodoProducto primero;

    public ListaProductos() {
        primero = null;
    }

    public NodoProducto getPrimero() {
        return primero;
    }

    public void setPrimero(NodoProducto nuevoPrimero) {
        primero = nuevoPrimero;
    }

    // Insertar al inicio
    public void insertarInicio(Producto producto) {
        NodoProducto nuevoNodo = new NodoProducto(producto);
        nuevoNodo.setSiguiente(primero);
        setPrimero(nuevoNodo);
    }

    // Insertar al final
    public void insertarFinal(Producto producto) {
        NodoProducto nuevoNodo = new NodoProducto(producto);

        if (primero == null) {
            setPrimero(nuevoNodo);
            return;
        }

        NodoProducto nodoTemp = primero;
        while (nodoTemp.getSiguiente() != null) {
            nodoTemp = nodoTemp.getSiguiente();
        }
        nodoTemp.setSiguiente(nuevoNodo);
    }

    // Buscar producto por nombre
    public Producto buscarProducto(String nombreBuscar) {
        if (primero == null) {
            System.out.println("La lista se encuentra vacía.");
            return null;
        }

        NodoProducto nodoTemp = primero;
        while (nodoTemp != null) {
            if (nodoTemp.getProducto().getNombre().equalsIgnoreCase(nombreBuscar)) {
                System.out.println("El producto se encontró en la estructura.");
                return nodoTemp.getProducto();
            }
            nodoTemp = nodoTemp.getSiguiente();
        }

        System.out.println("El producto buscado no se encontró en la estructura.");
        return null;
    }

    // Eliminar producto por nombre
    public boolean eliminarProducto(String nombreEliminar) {
        if (primero == null) {
            System.out.println("La lista está vacía.");
            return false;
        }

        // Caso especial: eliminar el primer nodo
        if (primero.getProducto().getNombre().equalsIgnoreCase(nombreEliminar)) {
            primero = primero.getSiguiente();
            System.out.println("Producto eliminado exitosamente.");
            return true;
        }

        // Buscar el nodo a eliminar
        NodoProducto nodoTemp = primero;
        NodoProducto anterior = null;

        while (nodoTemp != null && !nodoTemp.getProducto().getNombre().equalsIgnoreCase(nombreEliminar)) {
            anterior = nodoTemp;
            nodoTemp = nodoTemp.getSiguiente();
        }

        if (nodoTemp == null) {
            System.out.println("Producto no encontrado.");
            return false;
        }

        anterior.setSiguiente(nodoTemp.getSiguiente());
        System.out.println("Producto eliminado exitosamente.");
        return true;
    }

    // Mostrar todos los productos
    public void mostrarTodosProductos() {
        if (primero == null) {
            System.out.println("No hay productos en la lista.");
            return;
        }

        NodoProducto nodoTemp = primero;
        int contador = 1;

        while (nodoTemp != null) {
            System.out.println("\nProducto #" + contador + ":");
            nodoTemp.getProducto().mostrarProducto();
            nodoTemp = nodoTemp.getSiguiente();
            contador++;
        }
    }


}