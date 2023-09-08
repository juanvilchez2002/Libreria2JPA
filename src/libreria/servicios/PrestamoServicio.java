
package libreria.servicios;

import java.util.Scanner;
import libreria.entidad.Prestamo;
import libreria.persistencia.PrestamoDAO;


public class PrestamoServicio {
    
    private final PrestamoDAO dao;
    private final LibroServicio ls;
    private final ClienteServicio cs;
    Scanner consola = new Scanner(System.in).useDelimiter("\t");

    public PrestamoServicio() {
        this.dao = new PrestamoDAO();
        this.ls = new LibroServicio();
        this.cs = new ClienteServicio();
    }
    
    public void registrarPrestamo(){
        System.out.println("----- REGISTRO DE PRESTAMO -----");
        
        Prestamo prestamo = new Prestamo();
        
        //cliente
        do{
            cs.listarCliente();
            
        }while(true);
    }
    
}
