package agenda.domain;

import java.util.*;
//import java.util.Comparator;

//import java.util.Optional;
//import java.util.stream.Stream;

public class Agenda {
    public static final byte CAPACIDAD=50;
    private List<Contacto>contactos;

    public Agenda(){
        this.contactos=new ArrayList<>();

    }
    public List<Contacto>getContactos(){return this.contactos;}
    public void setContactos(List<Contacto>contactosNuevos){this.contactos=contactosNuevos;}


    public boolean crearContacto(String nombreEntrante,String apellidoEntrante,String numeroEntrante){
        Contacto contactoParaAgregar= new Contacto(nombreEntrante,apellidoEntrante,numeroEntrante);
        if (this.contactos.size()<CAPACIDAD ){
            this.contactos.add(contactoParaAgregar);
            System.out.println("el contacto "+contactoParaAgregar.getNombre()+" ha agregado satisfactoriamente");
            return true;
        }
        System.out.println("el contacto no se pudo agregar, agenda ha alcanzado el limite");
        return false;
    }
    public String eliminarContacto(String numeroAEliminar) {
        Contacto contactoEliminar = buscarContactoXNumero(numeroAEliminar);
        boolean verificarEliminado = this.contactos.remove(contactoEliminar);
        if (verificarEliminado == true) {
            return "el contacto "+contactoEliminar.getNombre()+"  se ha eliminado ";
        }
        return "el contacto no se ha encontrado ";
    }
    public Contacto buscarContactoXNombre(String nombreEntrante){
        Contacto respuestaNombre = this.contactos.stream().filter(item->item.getNombre()
                .equals(nombreEntrante))
                .findFirst()
                .orElse(null);
        return respuestaNombre;
    }
    public Contacto buscarContactoXApellido(String apellidoEntrante){
        Contacto respuestaApellido=this.contactos.stream().filter(item->item.getApellido()
                .equals(apellidoEntrante))
                .findFirst()
                .orElse(null);

        return respuestaApellido;
    }
    public Contacto buscarContactoXNumero(String numeroEntrante){
        Contacto respuestaNumero=this.contactos.stream().filter(item->item.getNumero().equals(numeroEntrante))
                .findFirst()
                .orElse(null);
        return respuestaNumero;
    }
    public String cambiarNumeroDCelular(String numeroViejo,String numeroNuevo){
        Contacto cambiarNumeroDcontacto=buscarContactoXNumero(numeroViejo);

        if (cambiarNumeroDcontacto!=null){
            cambiarNumeroDcontacto.setNumero(numeroNuevo);
            return "se cambio el numero de contacto";
        }
        return "no se encontro el numero para cambiar";
    }


    public void ordenarContactosXOrdenNombreApellido (){
        this.contactos.sort(new Comparator<Contacto>() {
            @Override
//            contacto1-contacto2=0  // son iguales los contactos
//            contacto1-contacto2=1 // contacto 1 es mayor
//            contacto1-contacto2=-1 // contacto 2 es mayor
//            ochoa-rodriguez = 1

            public int compare(Contacto contacto1, Contacto contacto2) {
                if (contacto1.getNombre().compareToIgnoreCase(contacto2.getNombre())==0){
                    return contacto1.getApellido().compareToIgnoreCase(contacto2.getApellido());
                }
                return contacto1.getNombre().compareToIgnoreCase(contacto2.getNombre()) ;
            }
        });

    }
}


