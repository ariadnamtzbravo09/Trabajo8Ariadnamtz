
package papeleria_login;
import java.util.*;
import javax.swing.*;
import java.io.*;



public class Articulo 
{

    private Articulo(String codigo, String articulo, String descripcion, int preciounitario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Articulo(String codigo, String articulo, String descripcion, String preciounitario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String getcodigo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private String getdescripcion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String getpreciounitario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public class ArregloAlumnos {
    private ArrayList<Articulo> objarticulo;
    
    // Contructor
    public ArregloAlumnos() {
        objarticulo = new ArrayList<Articulo>();
        
    }
    
    // Métodos de manejo del ArrayList
    public void agregar(Articulo art) {
        objarticulo.add(art);
    }
    
    public void borrar(Articulo art) {
        objarticulo.remove(art);
    }
    
    public Articulo obtener(int pos) {
        return objarticulo.get(pos);
    }
    
    public Articulo buscar(String noControl) {
        for (int i = 0; i < objarticulo.size(); i++) {
            if(noControl.equals(objarticulo.get(i).getarticulo()))
                return objarticulo.get(i);
        }
        return null;
    }
    
    public int numElementos() {
        return objarticulo.size();
    }
    
    public void leerDatos() {
        cargar();
    }
    
    
    
    // Cargar lista de alumnos
    private void cargar() {
        try {
            
            File archivo = new File("articulos.txt");
            // Si el archivo existe
            if(archivo.exists()) {
                BufferedReader br = new BufferedReader(new FileReader("articulos.txt"));
                String linea;
                
                while((linea = br.readLine()) != null) {
                    StringTokenizer st = new StringTokenizer(linea, ",");
                    String codigo = st.nextToken().trim();
                    String articulo = st.nextToken().trim();
                    String descripcion = st.nextToken().trim();
                    int preciounitario =Integer.parseInt(st.nextToken().trim());
                    Articulo al = new Articulo(codigo, articulo, descripcion,preciounitario);
                    agregar(al);
                }
                       
                
            }
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error: " + e);
        }   
    }
    public void guardar() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("articulos.txt"));
            for(int i=0; i<numElementos(); i++) {
                pw.println(obtener(i).getcodigo()+","+obtener(i).getarticulo()+","+
                        obtener(i).getdescripcion()+","+obtener(i).getpreciounitario());
                pw.close();
            }
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo el siguiente error: " + e);
        }

    }
    }
    
}
