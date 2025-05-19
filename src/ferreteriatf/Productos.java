
package ferreteriatf;

import javax.swing.JOptionPane;


public class Productos { 
    
    String Producto, IdProducto, Cantidad;

    public Productos(String Producto, String IdProducto, String Cantidad) {
        this.Producto = Producto;
        this.IdProducto = IdProducto;
        this.Cantidad = Cantidad;
    }
    
    public void MostrarProducto(){
     JOptionPane.showMessageDialog(null,"Nombre:\n"+ Producto);
     JOptionPane.showMessageDialog(null,"Id:\n"+ IdProducto);
     
    }
    
      
    
}
