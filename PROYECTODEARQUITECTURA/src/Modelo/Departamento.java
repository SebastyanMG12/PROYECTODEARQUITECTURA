package Modelo;

import java.util.ArrayList;

public class Departamento {
    private static Departamento instancia;
    private String nombre;
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Asignatura> asignaturas;

    // Singleton
    public static Departamento singleton() {
        if (instancia == null) {
            instancia = new Departamento();
        }
        return instancia;
    }

    private Departamento() {
        this.nombre = "";
        this.estudiantes = new ArrayList<>();
        this.asignaturas = new ArrayList<>();
    }

    // Nombre del departamento
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Gestión de estudiantes
    public boolean registrarEstudiante(Estudiante e) {
        for (Estudiante est : estudiantes) {
            if (est.getTipo().equalsIgnoreCase(e.getTipo()) &&
                    est.getCodigo().equalsIgnoreCase(e.getCodigo())) {
                return false; // Ya registrado
            }
        }
        estudiantes.add(e);
        return true;
    }

    public Estudiante consultarEstudiante(String tipoDoc, String numDoc) {
        for (Estudiante est : estudiantes) {
            if (est.getTipo().equalsIgnoreCase(tipoDoc) &&
                    est.getCodigo().equalsIgnoreCase(numDoc)) {
                return est;
            }
        }
        return null;
    }

    public boolean modificarEstudiante(String tipo, String num, String nuevoNombreCompleto, String nuevoTipoDoc) {
        for (Estudiante e : estudiantes) {
            if (e.getTipo().equalsIgnoreCase(tipo) && e.getCodigo().equalsIgnoreCase(num)) {
                e.setNombre(nuevoNombreCompleto);
                e.setTipo(nuevoTipoDoc);
                return true;
            }
        }
        return false;
    }


    // Gestión de asignaturas
    public boolean registrarAsignatura(Asignatura asignatura) {
        for (Asignatura a : asignaturas) {
            if (a.getCodigo().equalsIgnoreCase(asignatura.getCodigo())
                    && a.getSeccion().equalsIgnoreCase(asignatura.getSeccion())
                    && a.getSemestre().equalsIgnoreCase(asignatura.getSemestre())) {
                return false; // ya existe
            }
        }
        asignaturas.add(asignatura);
        return true;
    }


    public Asignatura consultarAsignatura(String codigo, String seccion, String semestre) {
        for (Asignatura a : asignaturas) {
            if (a.getCodigo().equalsIgnoreCase(codigo) &&
                    a.getSeccion().equalsIgnoreCase(seccion) &&
                    a.getSemestre().equalsIgnoreCase(semestre)) {
                return a;
            }
        }
        return null;
    }

    public boolean actualizarAsignatura(String codigo, String seccion, String semestre, String nombreNuevo, int creditos) {
        Asignatura a = consultarAsignatura(codigo, seccion, semestre);
        if (a != null) {
            a.setNombre(nombreNuevo);
            a.setCreditos(creditos);
            return true;
        }
        return false;
    }

}