
package ferreteriatf;

import javax.swing.JOptionPane;


public class Productos {
    
    String Producto, IdProducto;

    public Productos(String Producto, String IdProducto) {
        this.Producto = Producto;
        this.IdProducto = IdProducto;
    }
    
    public void MostrarProducto(){
     JOptionPane.showMessageDialog(null,"Nombre:\n"+ Producto);
     JOptionPane.showMessageDialog(null,"Id:\n"+ IdProducto);
     
    }
}
