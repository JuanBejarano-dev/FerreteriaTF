
package ferreteriatf;

import java.io.*;
import javax.swing.JOptionPane;

public class ArchivoStock {
    
    public void RegistrarProducto(Productos nuevo){
        try{
        File f = new File("Pruebadato3.txt");
            
        FileWriter fw;//escribir en el archivo
        BufferedWriter bw;//optimizacion
        
        if(f.exists())
         {
         fw =new FileWriter(f,true);
         bw=new BufferedWriter(fw);
         bw.newLine();
         
         bw.write(nuevo.Producto+" "+nuevo.IdProducto+" ");
         }
        else
         {
          fw =new FileWriter(f);
          bw=new BufferedWriter(fw);
          bw.write(nuevo.Producto+" "+nuevo.IdProducto+" ");
        
         }
        bw.close();
        fw.close();
                      
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error en la escritura del archivo");
        }
    
    
    }
    
    public void MostrarProducto(){
       try
       {
        File f = new File("Pruebadato3.txt");
        
         if(f.exists())
         {
          FileReader fr= new FileReader(f);
          BufferedReader br= new BufferedReader(fr);
          
          String linea;
          while((linea=br.readLine())!=null)
           {
            String []contacto=linea.split(" ");
            Productos p =new Productos(contacto[0],contacto[1]);
            p.MostrarProducto();
           }
         }
         else
         {
         JOptionPane.showMessageDialog(null, "el archivo no existe");
         }
       } 
       catch(Exception e){
          JOptionPane.showMessageDialog(null,"Error en lectura del Archivo");
          }
        }   
      
    public void EliminarProducto(String producto, String idProducto) {
        
    File archivo = new File("Pruebadato3.txt");
    StringBuilder contenidoNuevo = new StringBuilder();

    try {
        
        BufferedReader reader = new BufferedReader(new FileReader(archivo));
        String linea;
        
        while ((linea = reader.readLine()) != null) {
            
            if (!linea.trim().equals(producto + " " + idProducto)) {
                
                contenidoNuevo.append(linea).append(System.lineSeparator());
            }
        }
        reader.close();

        BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
        writer.write(contenidoNuevo.toString());
        writer.close();

        } catch (Exception e) {
            
        JOptionPane.showMessageDialog(null, "Error al eliminar el producto del archivo.");
      }
    
    }

    
}
