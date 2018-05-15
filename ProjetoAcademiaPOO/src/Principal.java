import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    private static Academia academia;
    private static ArrayList<GerenciadorClientesAtividades> gerenciadores;
    private static ArrayList<GerenciadorInstrutores> administradores;

    public static void main(String[] args) {
        carregarUsuariosPadrao();
        while (!login()) {
            System.out.println("Usuário ou senha incorretos.");
        }
        System.out.println("Menu:");
        //TODO: opções
    }

    public static void carregarUsuariosPadrao() {
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
            if (admin.getUsername().equals(username) && admin.getSenha().equals(senha))
                return true;
        }

        for (GerenciadorClientesAtividades geren : gerenciadores) {
            if (geren.getUsername().equals(username) && geren.getSenha().equals(senha))
                return true;
        }

        return false;
    }
}
