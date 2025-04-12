package Vista;

import java.util.Scanner;
import Controlador.Elcontrolador;
import Modelo.Asignatura;

public class Principal {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Elcontrolador controlador = new Elcontrolador();
        String opcion = "";

        //menu
        do {
            System.out.println(" SISTEMA ASISTENCIA");
            System.out.println("1. Consultar Departamento");
            System.out.println("2. Modificar Departamento");
            System.out.println("3. Registrar Estudiante en Departamento");
            System.out.println("4. Consultar Estudiante en Departamento");
            System.out.println("5. Modificar Estudiante en Departamento");
            System.out.println("6. Agregar Asignatura");
            System.out.println("7. Consultar Asignatura");
            System.out.println("8. Modificar Asignatura");
            System.out.println("9. Registrar Estudiante en Asignatura");
            System.out.println("10. Consultar Estudiantes en Asignatura");
            System.out.println("11. Crear Lista de Asistencia Vacía");
            System.out.println("12. Llenar Asistencia");
            System.out.println("13. Modificar Asistencia (cambiar estado)");
            System.out.println("14. Listar Asistencias");
            System.out.println("15. Salir");
            System.out.print("Seleccione la opción que desee: ");
            opcion = input.nextLine();

            if (opcion.equals("1")) {

                // Consultar departamento

                System.out.println("Nombre del Departamento: " + controlador.consultarDepartamento(""));
            } else if (opcion.equals("2")) {
                // Modificar departamento
                System.out.print("Nuevo nombre del Departamento: ");
                String nuevoDep = input.nextLine();
                if (controlador.modificarDepartamento(nuevoDep, nuevoDep)) {
                    System.out.println("Departamento modificado a: " + nuevoDep);
                } else {
                    System.out.println("No se pudo modificar el departamento");
                }
            } else if (opcion.equals("3")) {
                // Registrar estudiante en departamento
                System.out.print("Nombres del estudiante: ");
                String nombres = input.nextLine();
                System.out.print("Apellidos del estudiante: ");
                String apellidos = input.nextLine();
                System.out.print("Tipo de documento: ");
                String tipoDoc = input.nextLine();
                System.out.print("Número de documento: ");
                String numDoc = input.nextLine();
                if (controlador.registrarEstudianteEnDepartamento(nombres, apellidos, tipoDoc, numDoc)) {
                    System.out.println("Estudiante registrado en el departamento.");
                } else {
                    System.out.println("No se pudo registrar el estudiante.");
                }
            } else if (opcion.equals("4")) {

                // Consultar estudiante en departamento

                System.out.print("Tipo de documento del estudiante a consultar: ");
                String tipoConsulta = input.nextLine();
                System.out.print("Número de documento del estudiante: ");
                String numConsulta = input.nextLine();
                System.out.println(controlador.consultarEstudianteEnDepartamento(tipoConsulta, numConsulta));
            } else if (opcion.equals("5")) {

                // Modificar estudiante en departamento

                System.out.print("Tipo de documento del estudiante a modificar: ");
                String tipoMod = input.nextLine();
                System.out.print("Número de documento del estudiante: ");
                String numMod = input.nextLine();
                System.out.print("Nuevos nombres: ");
                String nuevosNombres = input.nextLine();
                System.out.print("Nuevos apellidos: ");
                String nuevosApellidos = input.nextLine();
                System.out.print("Nuevo tipo de documento: ");
                String nuevoTipo = input.nextLine();
                if (controlador.modificarEstudianteEnDepartamento(tipoMod, numMod, nuevosNombres, nuevosApellidos, nuevoTipo)) {
                    System.out.println("Estudiante modificado.");
                } else {
                    System.out.println("No se encontró el estudiante.");
                }
            } else if (opcion.equals("6")) {
                // Agregar asignatura
                System.out.print("Código de la asignatura: ");
                String codigo = input.nextLine();

                System.out.print("Nombre de la asignatura: ");
                String nombre = input.nextLine();

                System.out.print("Numero de Créditos: ");
                int creditos = Integer.parseInt(input.nextLine());

                System.out.print("Sección: ");
                String seccion = input.nextLine();

                System.out.print("Numero de Semestre: ");
                String semestre = input.nextLine();


                if (controlador.adicionarAsignatura(codigo, nombre, creditos, seccion, semestre)) {
                    System.out.println("Asignatura adicionada correctamente.");
                } else {
                    System.out.println("La asignatura ya existe.");
                }

            } else if (opcion.equals("7")) {

                // Consultar asignatura

                System.out.print("Código de la asignatura: ");
                String codConsulta = input.nextLine();
                System.out.print("Sección: ");
                String secConsulta = input.nextLine();
                System.out.print("Numero de Semestre: ");
                String semConsulta = input.nextLine();
                Asignatura asig = controlador.consultarAsignatura(codConsulta, secConsulta, semConsulta);
                if (asig != null) {
                    System.out.println("Nombre: " + asig.getNombre() + ", Numero de Créditos: " + asig.getCreditos());
                } else {
                    System.out.println("Asignatura no encontrada.");
                }
            } else if (opcion.equals("8")) {
                // Modificar asignatura
                System.out.print("Código de la asignatura a modificar: ");
                String codMod = input.nextLine();
                System.out.print("Sección: ");
                String secMod = input.nextLine();
                System.out.print("Numero de Semestre: ");
                String semMod = input.nextLine();
                System.out.print("Nuevo nombre (dejar vacío si no se cambia): ");
                String nuevoNomAsig = input.nextLine();
                System.out.print("Nuevos créditos (0 si no se cambian): ");
                int nuevosCred = Integer.parseInt(input.nextLine());
                Asignatura asig = controlador.consultarAsignatura(codMod, secMod, semMod);
                if (asig != null) {
                    if (controlador.modificarAsignatura(codMod, secMod, semMod,
                            nuevoNomAsig.isEmpty() ? asig.getNombre() : nuevoNomAsig,
                            nuevosCred == 0 ? asig.getCreditos() : nuevosCred)) {
                        System.out.println("Asignatura modificada.");
                    } else {
                        System.out.println("No se pudo modificar la asignatura.");
                    }
                } else {
                    System.out.println("Asignatura no encontrada.");
                }
            } else if (opcion.equals("9")) {

                // Registrar estudiante en asignatura

                System.out.print("Tipo de documento del estudiante: ");
                String tipoEst = input.nextLine();
                System.out.print("Número de documento del estudiante: ");
                String numEst = input.nextLine();
                System.out.print("Código de la asignatura: ");
                String codAsigEst = input.nextLine();
                System.out.print("Sección: ");
                String secAsigEst = input.nextLine();
                System.out.print("Numero de Semestre: ");
                String semAsigEst = input.nextLine();
                if (controlador.registrarEstudianteEnAsignatura(tipoEst, numEst, codAsigEst, secAsigEst, semAsigEst)) {
                    System.out.println("Estudiante registrado en la asignatura.");
                } else {
                    System.out.println("No se pudo registrar el estudiante en la asignatura.");
                }
            } else if (opcion.equals("10")) {

                // Consultar estudiantes en asignatura

                System.out.print("Código de la asignatura: ");
                String codigoAsignatura = input.nextLine();
                System.out.print("Sección: ");
                String seccion = input.nextLine();
                System.out.print("Numero de Semestre: ");
                String semestre = input.nextLine();
                System.out.println(controlador.consultarEstudiantesEnAsignatura(codigoAsignatura, seccion, semestre));

            } else if (opcion.equals("11")) {

                // Crear lista de asistencia vacía

                System.out.print("Código de la asignatura: ");
                String codAsis = input.nextLine();
                System.out.print("Sección: ");
                String secAsis = input.nextLine();
                System.out.print("Numero de Semestre: ");
                String semAsis = input.nextLine();
                System.out.print("Fecha (ejemplo: 2025-03-15): ");
                String fecha = input.nextLine();
                System.out.print("Hora de inicio: ");
                String horaInicio = input.nextLine();
                System.out.print("Hora final: ");
                String horaFinal = input.nextLine();
                if (controlador.crearListaAsistencia(codAsis, secAsis, semAsis, fecha, horaInicio, horaFinal)) {
                    System.out.println("Lista de asistencia creada con estado 'No asistió' para todos los estudiantes.");
                } else {
                    System.out.println("No se pudo crear la lista de asistencia.");
                }
            } else if (opcion.equals("12")) {

                // Llenar asistencia

                System.out.print("Código de la asignatura: ");
                String codLLenar = input.nextLine();
                System.out.print("Sección: ");
                String secLLenar = input.nextLine();
                System.out.print("Numero de Semestre: ");
                String semLLenar = input.nextLine();
                System.out.print("Fecha de la lista: ");
                String fechaLLenar = input.nextLine();
                System.out.print("Hora de inicio de la lista: ");
                String horaIniLLenar = input.nextLine();
                System.out.print("Hora final de la lista: ");
                String horaFinLLenar = input.nextLine();
                System.out.print("Clave del estudiante (tipo-numero, ejemplo: CC-123): ");
                String claveEst = input.nextLine();
                System.out.print("Nuevo estado (llegó, no llegó, llegó tarde): ");
                String nuevoEstado = input.nextLine();
                if (controlador.llenarAsistencia(codLLenar, secLLenar, semLLenar, fechaLLenar, horaIniLLenar, horaFinLLenar, claveEst, nuevoEstado)) {
                    System.out.println("Asistencia actualizada.");
                } else {
                    System.out.println("No se pudo actualizar la asistencia.");
                }
            } else if (opcion.equals("13")) {

                // Modificar asistencia (similar a llenar, se puede reutilizar el método llenarAsistencia )

                System.out.print("Código de la asignatura: ");
                String codModAsis = input.nextLine();
                System.out.print("Sección: ");
                String secModAsis = input.nextLine();
                System.out.print("Numero de Semestre: ");
                String semModAsis = input.nextLine();
                System.out.print("Fecha de la lista: ");
                String fechaModAsis = input.nextLine();
                System.out.print("Hora de inicio de la lista: ");
                String horaIniModAsis = input.nextLine();
                System.out.print("Hora final de la lista: ");
                String horaFinModAsis = input.nextLine();
                System.out.print("Clave del estudiante (tipo-numero): ");
                String claveModAsis = input.nextLine();
                System.out.print("Nuevo estado (llegó, no llegó, llegó tarde): ");
                String estadoModAsis = input.nextLine();
                if (controlador.llenarAsistencia(codModAsis, secModAsis, semModAsis, fechaModAsis, horaIniModAsis, horaFinModAsis, claveModAsis, estadoModAsis)) {
                    System.out.println("Asistencia modificada.");
                } else {
                    System.out.println("No se pudo modificar la asistencia.");
                }
            } else if (opcion.equals("14")) {

                // Listar asistencias

                System.out.print("Código de la asignatura: ");
                String codListAsis = input.nextLine();
                System.out.print("Sección: ");
                String secListAsis = input.nextLine();
                System.out.print("Numero de Semestre: ");
                String semListAsis = input.nextLine();
                System.out.print("Fecha de la lista: ");
                String fechaListAsis = input.nextLine();
                System.out.print("Hora de inicio de la lista: ");
                String horaIniListAsis = input.nextLine();
                System.out.print("Hora final de la lista: ");
                String horaFinListAsis = input.nextLine();
                System.out.println(controlador.listarAsistencias(codListAsis, secListAsis, semListAsis, fechaListAsis, horaIniListAsis, horaFinListAsis));
            } else if (opcion.equals("15")) {
                System.out.println("Saliendo...");
            } else {
                System.out.println("Opción no válida, intente de nuevo.");
            }

        } while (!opcion.equals("15"));

        input.close();
    }
}