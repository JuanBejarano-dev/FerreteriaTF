
package ferreteriatf;

import java.io.*;
import javax.swing.JOptionPane;

public class ArchivoStock {
    
    public void RegistrarProducto(Productos nuevo){
        try{
        File f = new File("Pruebadato10.txt");
            
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
        File f = new File("Pruebadato10.txt");
        
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
      
    public void EliminarProducto(String productoEliminar, String idEliminar) {
        
    File archivoOriginal = new File("Pruebadato10.txt");
    File archivoTemporal = new File("temp.txt");
    
    try (
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTemporal))
    ) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(" ");
            if (partes.length >= 2) {
                String producto = partes[0];
                String id = partes[1];
                
                // Si no es el que queremos eliminar, lo escribimos en el archivo temporal
                if (!producto.equals(productoEliminar) || !id.equals(idEliminar)) {
                    bw.write(producto + " " + id);
                    bw.newLine();
                }
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar del archivo");
        return;
    }

    // Reemplazar archivo original con el temporal
    if (archivoOriginal.delete()) {
        archivoTemporal.renameTo(archivoOriginal);
    } else {
        JOptionPane.showMessageDialog(null, "No se pudo actualizar el archivo");
    }
}

    
}
