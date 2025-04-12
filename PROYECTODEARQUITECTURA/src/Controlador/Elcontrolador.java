package Controlador;

import Modelo.*;
import java.util.ArrayList;

public class Elcontrolador {
    Departamento departamento;

    public Elcontrolador() {
        departamento = Departamento.singleton();
    }

    // CRUD Departamento
    public void crearDepartamento(String nombre) {
        departamento.setNombre(nombre);
    }

    public boolean adicionarDepartamento(String nombre) {
        if (departamento.getNombre() == null || departamento.getNombre().isEmpty()) {
            departamento.setNombre(nombre);
            return true;
        }
        return false;
    }

    public String consultarDepartamento(String nombre) {
        return departamento.getNombre();
    }

    public boolean modificarDepartamento(String nombreNuevo, String nuevo) {
        if (!departamento.getNombre().isEmpty()) {
            departamento.setNombre(nombreNuevo);
            return true;
        }
        return false;
    }

    // Gestión de estudiantes en el departamento
    public boolean registrarEstudianteEnDepartamento(String nombres, String apellidos, String tipoDoc, String numDoc) {
        // Concatenamos nombres y apellidos para obtener el nombre completo
        String nombreCompleto = nombres + " " + apellidos;
        // Se crea el estudiante con: nombreCompleto, numDoc (como código) y tipoDoc (como tipo)
        Estudiante e = new Estudiante(nombreCompleto, numDoc, tipoDoc);
        return departamento.registrarEstudiante(e);
    }

    public String consultarEstudianteEnDepartamento(String tipo, String num) {
        Estudiante e = departamento.consultarEstudiante(tipo, num);
        if (e != null) {
            return "Estudiante: " + e.getNombre();
        }
        return "Estudiante no encontrado";
    }

    public boolean modificarEstudianteEnDepartamento(String tipo, String num, String nuevosNombres, String nuevosApellidos, String nuevoTipoDoc) {
        // Se actualiza el nombre concatenando los nuevos nombres y apellidos
        String nombreCompleto = nuevosNombres + " " + nuevosApellidos;
        return departamento.modificarEstudiante(tipo, num, nombreCompleto, nuevoTipoDoc);
    }

    // Consultar estudiantes en asignatura
    public String consultarEstudiantesEnAsignatura(String codigoAsignatura, String seccion, String semestre) {
        Asignatura a = departamento.consultarAsignatura(codigoAsignatura, seccion, semestre);
        if (a != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Lista de estudiantes en la asignatura:\n");
            for (Estudiante e : a.getEstudiantes()) {
                sb.append("Tipo: ").append(e.getTipo())
                        .append(", Código: ").append(e.getCodigo())
                        .append(", Nombre: ").append(e.getNombre())
                        .append("\n");
            }
            return sb.toString();
        }
        return "Asignatura no encontrada";
    }

    public Asignatura consultarAsignatura(String codigo, String seccion, String semestre) {
        return departamento.consultarAsignatura(codigo, seccion, semestre);
    }

    public boolean modificarAsignatura(String codigo, String seccion, String semestre, String nombre, int creditos) {
        return departamento.actualizarAsignatura(codigo, seccion, semestre, nombre, creditos);
    }

    // Gestión de estudiantes en asignatura
    public boolean registrarEstudianteEnAsignatura(String tipoDoc, String numDoc, String codigo, String seccion, String semestre) {
        // Se busca el estudiante en el departamento
        Estudiante e = departamento.consultarEstudiante(tipoDoc, numDoc);
        if (e == null) {
            System.out.println("Estudiante no registrado en el departamento.");
            return false;
        }
        // Se busca la asignatura en el departamento
        Asignatura a = departamento.consultarAsignatura(codigo, seccion, semestre);
        if (a == null) {
            System.out.println("Asignatura no encontrada.");
            return false;
        }
        // Verifica si el estudiante ya está registrado en la asignatura (para evitar duplicados)
        for (Estudiante est : a.getEstudiantes()) {
            if (est.getTipo().equalsIgnoreCase(tipoDoc) &&
                    est.getCodigo().equalsIgnoreCase(numDoc)) {
                System.out.println("El estudiante ya está registrado en la asignatura.");
                return false;
            }
        }
        // Registra el estudiante en la asignatura
        return a.registrarEstudiante(e);
    }

    // Gestión de asistencia en asignatura
    public boolean crearListaAsistencia(String codigo, String seccion, String semestre, String fecha, String horaInicio, String horaFinal) {
        Asignatura a = departamento.consultarAsignatura(codigo, seccion, semestre);
        if (a != null) {
            return a.crearListaAsistencia(fecha, horaInicio, horaFinal);
        }
        return false;
    }

    public boolean llenarAsistencia(String codigo, String seccion, String semestre, String fecha, String horaInicio, String horaFinal,
                                    String claveEstudiante, String nuevoEstado) {
        Asignatura a = departamento.consultarAsignatura(codigo, seccion, semestre);
        if (a != null) {
            Asistencia asistencia = a.consultarAsistencia(fecha, horaInicio, horaFinal);
            if (asistencia != null) {
                return asistencia.modificarAsistencia(claveEstudiante, nuevoEstado);
            }
        }
        return false;
    }

    public String listarAsistencias(String codigo, String seccion, String semestre, String fecha, String horaInicio, String horaFinal) {
        Asignatura a = departamento.consultarAsignatura(codigo, seccion, semestre);
        if (a != null) {
            Asistencia asistencia = a.consultarAsistencia(fecha, horaInicio, horaFinal);
            if (asistencia != null) {
                StringBuilder sb = new StringBuilder();
                ArrayList<String> codigos = asistencia.getCodigos();
                ArrayList<String> estados = asistencia.getEstados();
                for (int i = 0; i < codigos.size(); i++) {
                    sb.append(codigos.get(i)).append(": ").append(estados.get(i)).append("\n");
                }
                return sb.toString();
            }
        }
        return "No se encontró la asistencia";
    }

    public boolean adicionarAsignatura(String codigo, String nombre, int creditos, String seccion, String semestre) {
        Asignatura asignatura = new Asignatura(codigo, nombre, seccion, semestre, creditos);
        return departamento.registrarAsignatura(asignatura);
    }

}
