package menu;

import hospital.Hospital;
import usuarios.medicos.Rol;
import usuarios.medicos.Usuario;
import usuarios.medicos.administradores.Administrador;
import usuarios.medicos.medicos.Medico;
import usuarios.medicos.pacientes.Paciente;

import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private Hospital hospital = new Hospital();


    public void login() {
        int intentosMaximos = 5, intentosUsuario = 0;
        Boolean bandera = true;
        while (bandera) {
            System.out.println("Bienvenido");
            System.out.println("Iniciar sesion para continuar");

            System.out.print("Ingresa tu usuario: ");
            String usuario = scanner.nextLine();

            System.out.print("Ingresa tu contraseña: ");
            String contrasenia = scanner.nextLine();

            Usuario usuarioEnSesion = hospital.validarInicioSesion(usuario, contrasenia);

            if (usuarioEnSesion instanceof Usuario) {
                if (usuarioEnSesion.getRol() == Rol.PACIENTE) {
                    Paciente pacienteEnSesion = (Paciente) usuarioEnSesion;
                    MenuPaciente menuPaciente = new MenuPaciente();
                    int opcion = 0;
                    while (opcion != 4) {
                        opcion = menuPaciente.mostrarMenu();
                        menuPaciente.procesarDatosMenu(opcion, hospital, pacienteEnSesion);
                    }
                    intentosUsuario = 0;

                } else if (usuarioEnSesion.getRol() == Rol.MEDICO) {
                    Medico medicoEnSesion = (Medico) usuarioEnSesion;
                    MenuMedico menuMedico = new MenuMedico();
                    int opcion = 0;
                    while (opcion != 7) {
                        opcion = menuMedico.mostrarMenu();
                        menuMedico.procesarDatosMenu(opcion, medicoEnSesion, hospital);
                    }
                    intentosUsuario = 0;

                } else {
                    Administrador adminEnSesion = (Administrador) usuarioEnSesion;
                    MenuAdmin menuAdmin = new MenuAdmin();
                    int opcion = 0;
                    while (opcion != 7) {
                        opcion = menuAdmin.mostrarMenu();
                        menuAdmin.procesarDatosMenu(opcion, adminEnSesion, hospital);
                    }
                    intentosUsuario = 0;

                }
            } else {
                intentosUsuario = mostrarErrorInicioSesion(intentosUsuario);
            }
            scanner.nextLine();
            if (intentosUsuario == intentosMaximos){
                System.out.println("Demasiados intentos de inicio de sesion. Intente mas tarde");
                bandera = false;
            }
        }
    }
    private int mostrarErrorInicioSesion(int    intentosUsuario) {
        System.out.println("\nUsuario o contraseña incorrectos, intenta de nuevo");
        return intentosUsuario +1;
    }
}
