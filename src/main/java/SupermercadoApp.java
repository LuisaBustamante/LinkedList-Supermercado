
import java.util.LinkedList;

public class SupermercadoApp {
 
    public static void main(String[] args) {
         
        //Creamos la lista de productos
        //ListaEnlazada<Producto> productos=new ListaEnlazada<>();
        LinkedList<Producto> productos=new LinkedList<>();
         
        //Generamos los productos
        generarProductos(productos);
         
        //Declaramos variables que necesitaremos
        String ticket="******Cantidad***Precio***Total\n\n";
        double precioTotal=0;
        Producto productoActual;
         
        //Recorremos la lista
        for(int i=0;!productos.isEmpty();i++){
             
            productoActual=productos.removeFirst();
            precioTotal+=productoActual.precioFinal();
            ticket+="Producto"+(i+1)+"\n\n"+productoActual.getCantidad()+
                    "\n\n"+productoActual.getPrecio()+
                    "\n\n"+productoActual.precioFinal()+"\n\n";
             
        }
         
        ticket+="Precio final\n\n"+precioTotal;
         
        System.out.println(ticket);
         
    }
     
     /**
     * Genera productos que se almacenan en la lista
     * @param lista
     */
    public static void generarProductos(LinkedList<Producto> lista){
         
       int numeroPersonas=generaNumeroAleatorio(1,8);
        
       int cantidad;
       double precio;
        
       for(int i=0;i<numeroPersonas;i++){
           cantidad=generaNumeroAleatorio(1,10);;
           precio=generaNumeroRealAleatorio(0.05, 50);
           lista.addLast(new Producto(cantidad, precio));
       } 
         
    }
     
   /**
     * Genera un numero aleatorio entre dos numeros.
     * Entre el minimo y el maximo incluidos
     * @param minimo Número mínimo
     * @param maximo Número máximo
     * @return Número entre minimo y maximo
     */
    public static int generaNumeroAleatorio(int minimo, int maximo){
         
        int num=(int)Math.floor(Math.random()*(minimo-(maximo+1))+(maximo+1));
        return num;
    }
     
    /**
     * Genera un numero aleatorio entre dos numeros reales.
     * Entre el minimo y el maximo incluidos
     * Devuelve un numero con dos decimales.
     * @param minimo Número mínimo
     * @param maximo Número máximo
     * @return Número entre minimo y maximo
     */
    public static double generaNumeroRealAleatorio(double minimo, double maximo){
         
        double num=Math.rint(Math.floor(Math.random()*(minimo-((maximo*100)+1))+((maximo*100)+1)))/100;
        return num;
         
    }
     
}