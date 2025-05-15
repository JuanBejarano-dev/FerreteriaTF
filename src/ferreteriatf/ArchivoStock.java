
package ferreteriatf;

import java.io.*;
import javax.swing.JOptionPane;

public class ArchivoStock {
    
    public void RegistrarProducto(Productos nuevo){
        try{
        File f = new File("Pruebadato2.txt");
            
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
        File f = new File("Pruebadato2.txt");
        
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
    
}
