package Modelo;

public class Estudiante {
    private String nombre;
    private String codigo;
    private String Tipo;

    public Estudiante(String nombre, String codigo, String tipoDoc) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.Tipo=Tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTipo(){
        return Tipo;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String Tipo){
        this.Tipo = Tipo;
    }
}