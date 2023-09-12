/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package libreria;

import java.text.ParseException;
import java.util.Scanner;
import libreria.servicios.AutorServicio;
import libreria.servicios.ClienteServicio;
import libreria.servicios.EditorialServicio;
import libreria.servicios.LibroServicio;
import libreria.servicios.PrestamoServicio;


public class MainClass {

    public static void main(String[] args) throws ParseException {
        //instanciando los servicios        
        LibroServicio ls = new LibroServicio();
        AutorServicio as = new AutorServicio();
        EditorialServicio es = new EditorialServicio();
        ClienteServicio cs = new ClienteServicio();
        PrestamoServicio ps = new PrestamoServicio();
        
        Scanner consola = new Scanner(System.in).useDelimiter("\t");
        
        Boolean flag = true;
        
        do{
            System.out.println("------ MENU ------");
            System.out.println("1. Ingresar Libro. ");
            System.out.println("2. Ingresar Autor. ");
            System.out.println("3. Ingresar Editorial. ");
            System.out.println("4. Busqueda de Autor. ");
            System.out.println("5. Busqueda de Editorial. ");
            System.out.println("6. Buscar Libro por Titulo: ");
            System.out.println("7. Buscar Libro por Autor. ");
            System.out.println("8. Buscar Libro por Editorial. ");
            System.out.println(" ----------------------------");
            System.out.println("A. Ingresar Cliente. "); 
            System.out.println("B. Ingresar Prestamo. ");         
            System.out.println(" ----------------------------");
            System.out.println("9. Salir.");
            System.out.println("Seleccione una Opcion: ");
            
            String op = consola.nextLine().toUpperCase();   
            
            switch (op) {
                case "1":
                    System.out.println("----- INGRESE LIBRO -----");
                    ls.crearLibro();                    
                    break;
                case "2":
                    System.out.println("----- INGRESE AUTOR -----");
                    System.out.print("Nombre Autor: ");
                    String autor = consola.nextLine();
                    as.crearAutor(autor, true);
                    break;
                case "3":
                    System.out.println("----- INGRESE EDITORIAL -----");
                    System.out.print("Nombre Editorial: ");
                    String editorial = consola.nextLine();
                    es.crearEditorial(editorial, true);
                    break;
                case "4":
                    as.buscarAutorPorNombre();
                    break;
                case "5":
                    es.buscarEditorialPorNombre();
                    break;
                case "6":
                    ls.buscarLibroTitulo();
                    break;
                case "7":
                    ls.buscarLibroPorAutor();
                    break;
                case "8":
                    ls.buscarLibroPorEditorial();
                    break;
                case "9":
                    System.out.println("Saliendo!!!");
                    flag = false;
                    break;
                case "A":
                    cs.crearCliente();
                    break;
                case "B":
                    ps.registrarPrestamo();
                    break;
                default:
                    System.out.println("Ingreso un opcion invalida!!");;
            }
        
        }while(flag);
    } 
    
}
