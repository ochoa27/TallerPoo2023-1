package agenda.app;

import agenda.domain.Agenda;
import agenda.domain.Contacto;

public class appAgenda {

    public static void main(String[] args) {
        Agenda simcard=new Agenda();


        simcard.crearContacto("andres","rodriguez","321");
        simcard.crearContacto("daniel","ochoa","123");
        simcard.crearContacto("juan","henao","444");
        simcard.crearContacto("cristiano","siuuu","777");
        simcard.crearContacto("andres","ochoa","999");

        System.out.println("\n");
        System.out.println("la lista de contactos es\n");
        for (Contacto item:simcard.getContactos()) {
            System.out.println(item.getNombre()+" "+item.getApellido());

        }
        System.out.println("\n");


        Contacto contactoEncontrado =simcard.buscarContactoXNombre("andres");
        System.out.println("el numero del contacto buscado es  " +contactoEncontrado.getNumero());

        Contacto contactoEncontradoXApellido=simcard.buscarContactoXApellido("siuuu");
        System.out.println("el contacto encontrado por apellido es: " +contactoEncontradoXApellido.getNombre()+", su numero es : "+contactoEncontradoXApellido.getNumero());

        System.out.println(simcard.eliminarContacto("444"));
        for (Contacto item:simcard.getContactos()) {
            System.out.println(item.getNombre()+" "+item.getNumero());

        }
        System.out.println(simcard.cambiarNumeroDCelular("123","555"));
        for (Contacto item:simcard.getContactos()) {
            System.out.println(item.getNombre()+" "+item.getNumero());}

        simcard.ordenarContactosXOrdenNombreApellido();
        System.out.println("La Lista de contactos ordenada es ");
        for (Contacto item:simcard.getContactos()) {
            System.out.println(item.getNombre()+" "+item.getApellido()+" "+item.getNumero());

        }

    }


}
