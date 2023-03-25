package Maquina_Dulces.domain;

public class Snack {
    private String codigo;
    private long valor;
    private int cantidad;

    public Snack(String nombre,String codigo,long valor){
        this.nombre=nombre;
        this.codigo=codigo;
        this.valor=valor;
        this.cantidad=6;
    }


    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


}
