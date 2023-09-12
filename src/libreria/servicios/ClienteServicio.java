
package libreria.servicios;

import java.util.ArrayList;
import java.util.Scanner;
import libreria.entidad.Cliente;
import libreria.persistencia.ClienteDAO;


public class ClienteServicio {
    
    private final ClienteDAO dao;
    Scanner consola;

    public ClienteServicio() {
       this.dao = new ClienteDAO();
       this.consola = new Scanner(System.in);
    }
    
    public Cliente crearCliente(){
        System.out.println("---- CREAR CLIENTE NUEVO ---");
        
        Cliente cliente = new Cliente();
        do{
            System.out.print("Ingrese DNI: ");
            Long dni = consola.nextLong();
            
            if(!buscarClientePorDNI(dni)){
                cliente.setDocumento(dni);
                break;
            }
        }while(true);
        
        consola.nextLine();
        
        do{
            System.out.print("Ingrese Nombre: ");
            String nombre = consola.nextLine();
            
            if(!nombre.isBlank()){
                cliente.setNombre(nombre);
                break;
            }else{
                System.out.println("Error en el nombre");
            }
        }while(true);
        
        do{
            System.out.print("Ingrese Apellido: ");
            String apellido = consola.nextLine();
            
            if(!apellido.isBlank()){
                cliente.setApellido(apellido);
                break;
            }else{
                System.out.println("Error en el Apellido");
            }
        }while(true);
        
        do{
            System.out.print("Ingrese Telefono: ");
            String telefono = consola.nextLine();
            
            if(!telefono.isBlank()){
                cliente.setTelefono(telefono);
                break;
            }else{
                System.out.println("Error en el Telefono");
            }
        }while(true);
        
        dao.guardar(cliente);
        System.out.println("Cliente Registrado");
        return cliente;
    }
    
    public boolean buscarClientePorDNI(Long dni){
        ArrayList<Cliente> cliente = new ArrayList(dao.buscarClientePorDNI(dni));
        if(cliente.isEmpty()){
            return false;
        }else{
            System.out.println("El DNI esta registrado");
            return true;            
        }
    }
    
    public void listarCliente(){
        try{
            ArrayList<Cliente> clientes = new ArrayList(dao.listarCliente());
        
            if(clientes.isEmpty()){
                System.out.println("No hay clientes registrados");
            }else{
                System.out.println("----- LISTA DE CLIENTES -----");
                System.out.println("Id \tNombre \tApellido \tDNI \tTelefono");
                for(Cliente cliente: clientes){
                    System.out.println(cliente.getId()+"\t"+cliente.getNombre()+"\t"+
                            cliente.getApellido()+"\t"+cliente.getDocumento()+"\t"+
                            cliente.getTelefono());                
                }
            }
        }catch(Exception e){
            throw e;
        }        
    }
    
    public Cliente buscarClientePorId(Integer id){
        System.out.println("Hola");
        Cliente cliente = dao.buscarClientePorId(id);
        return cliente;
    }
}
