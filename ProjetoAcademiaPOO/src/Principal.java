import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    private static Academia academia;
    private static ArrayList<Usuario> usuarios;
    private static ArrayList<Administrador> administradores;
    private static Usuario usuarioLogado = null;
    private static Administrador administradorLogado = null;

    public static void main(String[] args) {
        carregarUsuariosPadrao();
        while (!login()) {
            System.out.println("Usuário ou senha incorretos.");
        }
        menu();
    }

    public static void menu() {
        if (usuarioLogado != null) {
            usuarioLogado.incluirCliente(academia);
            usuarioLogado.incluirCliente(academia);
            Academia.exibirClientes();
            usuarioLogado.incluirAtividade(academia);
            usuarioLogado.incluirAtividade(academia);
            Academia.exibirAtividades();
            usuarioLogado.incluirTurma(academia);
            usuarioLogado.incluirTurma(academia);
            usuarioLogado.incluirTurma(academia);
            Academia.exibirTurmasPorAtividade();
            usuarioLogado.relacionarTurmaCliente(academia);
            usuarioLogado.relacionarTurmaInstrutor(academia);
        }
        if (administradorLogado != null) {
            administradorLogado.incluirInstrutor(academia);
            administradorLogado.incluirAtividade(academia);
            Academia.exibirInstrutores();
            administradorLogado.incluirUsuario(usuarios);
            administradorLogado.incluirUsuario(usuarios);
            administradorLogado.imprimirUsuarios(usuarios);
            administradorLogado.incluirTurma(academia);
            administradorLogado.relacionarTurmaInstrutor(academia);
        }
    }

    public static void carregarUsuariosPadrao() {
        academia = new Academia();
        usuarios = new ArrayList<>();
        administradores = new ArrayList<>();

        Administrador admin = new Administrador("admin", "admin");
        Usuario usuario = new Administrador("geren", "geren");

        usuarios.add(usuario);
        administradores.add(admin);
    }

    public static boolean login() {
        Scanner input = new Scanner(System.in);
        System.out.println("Username: ");
        String username = input.next();
        System.out.println("Senha: ");
        String senha = input.next();

        for (Administrador admin : administradores) {
            if (admin.getUsername().equals(username) && admin.getSenha().equals(senha)) {
                administradorLogado = admin;
                return true;
            }
        }

        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username) && usuario.getSenha().equals(senha)) {
                usuarioLogado = usuario;
                return true;
            }
        }

        return false;
    }
}
