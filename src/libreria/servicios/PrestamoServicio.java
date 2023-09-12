
package libreria.servicios;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import libreria.entidad.Cliente;
import libreria.entidad.Libro;
import libreria.entidad.Prestamo;
import libreria.persistencia.PrestamoDAO;


public class PrestamoServicio {
    
    private final PrestamoDAO dao;
    private final LibroServicio ls;
    private final ClienteServicio cs;
    Scanner consola = new Scanner(System.in);

    public PrestamoServicio() {
        this.dao = new PrestamoDAO();
        this.ls = new LibroServicio();
        this.cs = new ClienteServicio();
    }
    
    public void registrarPrestamo() throws ParseException{
        System.out.println("----- REGISTRO DE PRESTAMO -----");
        
        Prestamo prestamo = new Prestamo();
        
        //cliente
        boolean flag = true;
        Cliente cliente;
        do{
            cs.listarCliente();
            System.out.println("");
            System.out.println("¿El Cliente se encuentra en la Lista (Y/N)?");
            System.out.println("");
            String op = consola.nextLine();
            
            switch(op.toUpperCase()){
                case "Y":
                    System.out.print("Digite el Id del Cliente: ");
                    int id = consola.nextInt();
                    cliente = cs.buscarClientePorId(id);
                    prestamo.setCliente(cliente);
                    flag = false;
                    consola.nextLine();
                    break;
                case "N":
                    cliente = cs.crearCliente();                    
                    System.out.println(cliente.toString());
                    prestamo.setCliente(cliente);                    
                    flag = false;
                    break;
                default:
                    System.out.println("Opción invalida");
            }
        }while(flag);
        
        flag = true;
        Libro libro;
        
        int cantidadLibros;
        int cantidadLibrosPrestados;
        int cantidadLibrosRestantes;
        
        do{
            ls.listarLibros();
            System.out.println("");
            System.out.println("¿El Libro se encuentra en la Lista (Y/N)?");
            System.out.println("");
            String op = consola.nextLine();
            
            switch(op.toUpperCase()){
                case "Y":
                    System.out.print("Digite el ISBN del Libro: ");
                    
                    Long id = consola.nextLong();
                    libro = ls.buscarLibroPorId(id);
                    
                    cantidadLibrosRestantes = libro.getEjemplaresRestantes();
                    cantidadLibrosPrestados = libro.getEjemplaresPrestados();
                    
                    consola.nextLine();
                    if(cantidadLibrosRestantes == 0){
                        System.out.println("No hay ejemplares para prestar.");
                    }else{
                        cantidadLibrosRestantes-=1;
                        cantidadLibrosPrestados+=1;
                        
                        //actualizo registro del libro
                        libro.setEjemplaresPrestados(cantidadLibrosPrestados);
                        libro.setEjemplaresRestantes(cantidadLibrosRestantes);
                        
                        ls.actualizarLibro(libro);  
                        prestamo.setLibro(libro);
                        System.out.println(libro.toString());
                        flag = false;                       
                    }                   
                    break;
                    
                case "N":
                    libro = ls.crearLibro();      
                    
                    cantidadLibrosRestantes = libro.getEjemplaresRestantes();
                    cantidadLibrosPrestados = libro.getEjemplaresPrestados();
                    
                    if(cantidadLibrosRestantes == 0){
                        System.out.println("No hay ejemplares para prestar.");
                    }else{
                        cantidadLibrosRestantes-=1;
                        cantidadLibrosPrestados+=1;
                        
                        //actualizo registro del libro
                        libro.setEjemplaresPrestados(cantidadLibrosPrestados);
                        libro.setEjemplaresRestantes(cantidadLibrosRestantes);
                        
                        ls.actualizarLibro(libro);  
                        prestamo.setLibro(libro);
                        System.out.println(libro.toString());
                        flag = false;                       
                    }                   
                    break;
                default:
                    System.out.println("Opción invalida");
            }
        }while(flag);
        
        //fecha de registro
        
        System.out.print("Fecha de Prestamo: ");
        String fecha = consola.nextLine();
        
        DateFormat fechaFormato = new SimpleDateFormat("dd/MM/yyyy");        
        
        Date actual = fechaFormato.parse(fecha);
        
        
        
//        System.out.print("Fecha de Devolucion: ");     
//        Date fechaDevolucion = fechaFormato.parse(consola.nextLine());
        prestamo.setFechaPrestamo(actual);
        
        dao.guardar(prestamo);
        
    }
    
}
