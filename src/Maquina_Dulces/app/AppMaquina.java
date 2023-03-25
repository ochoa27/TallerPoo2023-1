package Maquina_Dulces.app;
import Maquina_Dulces.domain.Maquina;
import Maquina_Dulces.domain.Snack;
public class AppMaquina {

    public static void main(String[] args) {
        Maquina maquina = new Maquina();


        maquina.agregarSnack("Chocolatina", "001", 100);
        maquina.agregarSnack("Papitas", "002", 200);
        maquina.agregarSnack("Galletas", "003", 300);
        maquina.agregarSnack("Panes", "004", 400);
        maquina.agregarSnack("Gaseosa", "005", 500);


        System.out.println("La lista de snacks es ");
        for (Snack item:maquina.getSnacks()) {
            System.out.println(item.getNombre()+" "+item.getValor()+" "+item.getCodigo()+" "+item.getCantidad());

        }

        System.out.println(maquina.sacarSnackXCodigo("003"));

        System.out.println(maquina.obtenerNombreSnackYcantidad("005"));
        System.out.println("\n");
        System.out.println(maquina.sacarSnackXNombre("Panes"));
        System.out.println();
        System.out.println(maquina.aumentarUnidadesSnackXCodigo("003",5));
        System.out.println(maquina.eliminarSnack("Gaseosa"));


        System.out.println("La lista de snacks es ");
        for (Snack item:maquina.getSnacks()) {
            System.out.println(item.getNombre()+" "+item.getValor()+" "+item.getCodigo()+" "+item.getCantidad());

        }
        System.out.println();

        System.out.println("La lista de snacks organizados por mayor valor es ");
        for (Snack item: maquina.ordenarSnacksXMayorValor()) {
            System.out.println(item.getNombre()+" "+item.getValor()+" "+item.getCodigo()+" "+item.getCantidad());

        }

        System.out.println("la lista de Snacks organizados por menor cantidad es :");
        for (Snack item: maquina.ordenarSnacksxMenorCantidad()) {
            System.out.println(item.getNombre()+" "+item.getValor()+" "+item.getCodigo()+" "+item.getCantidad());

        }

        System.out.println(maquina.aumentarUnidadesSnackXCodigo("001",-6));
        System.out.println("la lista de snacks que no tienen ninguna cantidad es: ");
        for (Snack item: maquina.obtenerSnacksAgotados()) {
            System.out.println(item.getNombre() + " " + item.getValor() + " " + item.getCodigo() + " " + item.getCantidad());
        }

        System.out.println(maquina.obtenerCantidadesXNombre("Chocolatina"));
    };





}
