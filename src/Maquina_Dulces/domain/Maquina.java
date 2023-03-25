package Maquina_Dulces.domain;

import agenda.domain.Contacto;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Maquina {
    public static final byte CAPACIDAD = 20;
    private List<Snack> snacks;

    public List<Snack> getSnacks() {
        return snacks;
    }

    public void setSnacks(List<Snack> snacks) {
        this.snacks = snacks;
    }


    public Maquina() {
        this.snacks = new ArrayList<>();
    }

    public boolean agregarSnack(String nombreEntra, String codigoEntra, long valorEntra) {
        Snack snackAgregar = new Snack(nombreEntra, codigoEntra, valorEntra);
        if (this.snacks.size() <= CAPACIDAD) {
            this.snacks.add(snackAgregar);
            System.out.println("el Snack " + snackAgregar.getNombre() + "se ha agregado con " + snackAgregar.getCantidad());
            return true;

        }
        System.out.println("el snack no se ha podido agregar");
        return false;
    }

    public String sacarSnackXCodigo(String codigoSnack) {

        Snack snackObtenidoXCodigo = this.snacks.stream().filter(item -> item.getCodigo()
                        .equals(codigoSnack))
                .findFirst()
                .orElse(null);

        if (snackObtenidoXCodigo != null) {
            snackObtenidoXCodigo.setCantidad(snackObtenidoXCodigo.getCantidad() - 1);
            return "El snack obtendio es " + snackObtenidoXCodigo.getNombre() + '\n' +
                    "la cantidad que tiene ahora es " + snackObtenidoXCodigo.getCantidad() + '\n' +
                    "su valor es " + snackObtenidoXCodigo.getValor();

        } else {
            return "El snack no se encontro";
        }


    }

    public String obtenerNombreSnackYcantidad(String codigoEntrante) {
        Snack snackNYC = this.snacks.stream().filter(item -> item.getCodigo()
                        .equals(codigoEntrante))
                        .findFirst()
                        .orElse(null);
        if (snackNYC != null) {
            return "el nombre es " + snackNYC.getNombre() + " su cantidad es " + snackNYC.getCantidad();
        }
        return "no existe un snack para este codigo";
    }

    public String sacarSnackXNombre(String nombreSnackEntrante) {

        Snack snackObtenidoXNombre = this.snacks.stream().filter(item -> item.getNombre()
                        .equals(nombreSnackEntrante))
                .findFirst()
                .orElse(null);

        if (snackObtenidoXNombre != null) {
            snackObtenidoXNombre.setCantidad(snackObtenidoXNombre.getCantidad() - 1);
            return "El snack obtenido es " + snackObtenidoXNombre.getNombre() + '\n' +
                    "la cantidad que tiene ahora es " + snackObtenidoXNombre.getCantidad();

        } else {
            return "El snack no se encontro";

        }
    }

    public String aumentarUnidadesSnackXCodigo(String codigoSnackEntrante, int cantidadesParaAumentar) {
        Snack snackObtenidoXCodigo = this.snacks.stream().filter(item -> item.getCodigo()
                        .equals(codigoSnackEntrante))
                .findFirst()
                .orElse(null);
        if (snackObtenidoXCodigo != null) {
            int cantidadAntes = snackObtenidoXCodigo.getCantidad();
            if (cantidadAntes + cantidadesParaAumentar <= 6) {
                snackObtenidoXCodigo.setCantidad(snackObtenidoXCodigo.getCantidad() + cantidadesParaAumentar);
                return "El snack obtendio es " + snackObtenidoXCodigo.getNombre() + '\n' +
                        "la cantidad que tenía antes era  " + cantidadAntes + '\n' +
                        "la cantidad que tiene ahora es " + snackObtenidoXCodigo.getCantidad();

            } else {
                return "La cantidad del snack es mayor a la permitida por la máquina";
            }

        } else {
            return "El snack no se encontro";
        }

    }
    public String eliminarSnack (String nombreEliminar){
        Snack snackAborrar = this.snacks.stream().filter(item -> item.getNombre()
                        .equals(nombreEliminar))
                        .findFirst()
                        .orElse(null);
        if (snackAborrar!=null){
            this.snacks.remove(snackAborrar);
            return "el snack se ha eliminado correctamente";
        }
        return "no se ha podido eliminar por que no se ha encontrado";


    }
    public List<Snack> ordenarSnacksXMayorValor (){
        List<Snack> snacksOrganizados =  this.snacks.stream()
                .sorted(Comparator.comparingLong(Snack::getValor).reversed())
                .collect(Collectors.toList());
        return snacksOrganizados;
    }

    public List<Snack> ordenarSnacksxMenorCantidad(){
        List<Snack> snacksOrganizadosXCantidad=this.snacks.stream()
                .sorted(Comparator.comparing(Snack::getCantidad)).collect(Collectors.toList());
        return snacksOrganizadosXCantidad;
    }
    public List<Snack> obtenerSnacksAgotados() {
        List<Snack> snacksAgotados = new ArrayList<>();
        for (Snack item : this.snacks) {
            if (item.getCantidad() == 0) {
                snacksAgotados.add(item);
            }

        }
        if (snacksAgotados != null) {

            return snacksAgotados;
        } else {
            return null;
        }

    }
    public String obtenerCantidadesXNombre(String nombreSnackBuscar){
        Snack snackCantidad = this.snacks.stream().filter(item -> item.getNombre()
                        .equals(nombreSnackBuscar))
                .findFirst()
                .orElse(null);
        if (snackCantidad != null) {
            return " su cantidad es " + snackCantidad.getCantidad();
        }
        return "no existe un snack con este nombre";
    }
}


