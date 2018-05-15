import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    private static Academia academia;
    private static ArrayList<GerenciadorClientesAtividades> gerenciadores;
    private static ArrayList<GerenciadorInstrutores> administradores;
    private static GerenciadorClientesAtividades gerenLogado = null;
    private static GerenciadorInstrutores adminLogado = null;

    public static void main(String[] args) {
        carregarUsuariosPadrao();
        while (!login()) {
            System.out.println("Usuário ou senha incorretos.");
        }
        menu();
    }

    public static void menu() {
        if (gerenLogado != null) {
            gerenLogado.incluirCliente(academia);
            gerenLogado.incluirAtividade(academia);
        }
        if (adminLogado != null) {

        }
    }

    public static void carregarUsuariosPadrao() {
        academia = new Academia();
        gerenciadores = new ArrayList<>();
        administradores = new ArrayList<>();

        GerenciadorInstrutores admin = new GerenciadorInstrutores("admin", "admin");
        GerenciadorClientesAtividades geren = new GerenciadorInstrutores("geren", "geren");

        gerenciadores.add(geren);
        administradores.add(admin);
    }

    public static boolean login() {
        Scanner input = new Scanner(System.in);
        System.out.println("Username: ");
        String username = input.next();
        System.out.println("Senha: ");
        String senha = input.next();

        for (GerenciadorInstrutores admin : administradores) {
            if (admin.getUsername().equals(username) && admin.getSenha().equals(senha)) {
                adminLogado = admin;
                return true;
            }
        }

        for (GerenciadorClientesAtividades geren : gerenciadores) {
            if (geren.getUsername().equals(username) && geren.getSenha().equals(senha)) {
                gerenLogado = geren;
                return true;
            }
        }

        return false;
    }
}
