import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    private static BaseDados academia;
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
        Scanner input = new Scanner(System.in);
        int operacao = -1;
        while (operacao != 0) {
            operacao = input.nextInt();
            switch (operacao) {
                //Inclusões, exclusões e alterações
                case 1: {
                    //Incluir cliente
                    usuarioLogado.incluirCliente(academia);
                    break;
                }
                case 2: {
                    //Alterar cliente
                    usuarioLogado.alterarCliente(academia);
                    break;
                }
                case 3: {
                    //Desativar cliente
                    usuarioLogado.desativarCliente(academia);
                    break;
                }
                case 4: {
                    //Incluir instrutor
                    if (administradorLogado != null)
                        administradorLogado.incluirInstrutor(academia);
                    break;
                }
                case 5: {
                    //Alterar instrutor
                    if (administradorLogado != null)
                        administradorLogado.alterarInstrutor(academia);
                    break;
                }
                case 6: {
                    //Desativar instrutor
                    if (administradorLogado != null)
                        administradorLogado.desativarInstrutor(academia);
                    break;
                }
                case 7: {
                    //Incluir atividade
                    usuarioLogado.incluirAtividade(academia);
                    break;
                }
                case 8: {
                    //Alterar atividade
                    usuarioLogado.alterarAtividade(academia);
                    break;
                }
                case 9: {
                    //Excluir atividade
                    usuarioLogado.excluirAtividade(academia);
                    break;
                }
                case 10: {
                    //Incluir turma
                    usuarioLogado.incluirTurma(academia);
                    break;
                }
                case 11: {
                    //Alterar turma
                    usuarioLogado.alterarTurma(academia);
                    break;
                }
                case 12: {
                    //Excluir turma
                    usuarioLogado.excluirTurma(academia);
                    break;
                }
                //Relacionamentos
                case 13: {
                    //Associar instrutor à turma
                    usuarioLogado.relacionarTurmaInstrutor(academia);
                    break;
                }
                case 14: {
                    //Associar cliente à turma
                    usuarioLogado.relacionarTurmaCliente(academia);
                    break;
                }
                case 15: {
                    //Desassociar instrutor e turma
                    usuarioLogado.desrelacionarTurmaInstrutor(academia);
                    break;
                }
                case 16: {
                    //Desassociar cliente e turma
                    usuarioLogado.desrelacionarTurmaCliente(academia);
                    break;
                }
                //Consultas - passar da base para a classe de interação
                case 17: {
                    //Todos os clientes
                    usuarioLogado.exibirClientes(academia);
                    break;
                }
                case 18: {
                    //Todos os instrutores
                    usuarioLogado.exibirInstrutores(academia);
                    break;
                }
                case 19: {
                    //Todas as atividades
                    usuarioLogado.exibirAtividades(academia);
                    break;
                }
                case 20: {
                    //Turmas por atividade específica
                    usuarioLogado.exibirTurmasPorAtividade(academia);
                    break;
                }
                case 21: {
                    //Clientes que fazem uma atividade específica
                    usuarioLogado.verificarClientesPorTurma(academia);
                    break;
                }
                case 22: {
                    //Instrutores que cuidam de uma atividade específica
                    //TODO
                }
                case 23: {
                    //Quantidade de clientes que fazem uma atividade específica
                    //TODO
                }
                case 24: {
                    //Clientes que estão em uma turma específica
                    //TODO
                }
                case 25: {
                    //Atividade com maior número de clientes
                    //TODO
                }
                case 26: {
                    //Atividade com menor número de clientes
                    //TODO
                }
                case 27: {
                    //Atividade com maior preço
                    //TODO
                }
                case 28: {
                    //Atividade com menor preço
                    //TODO
                }
                case 29: {
                    //Turmas por cliente específico
                    //TODO
                }
                case 30: {
                    //Turmas por instrutor específico
                    //TODO
                }
            }
        }
    }

    public static void carregarUsuariosPadrao() {
        academia = new BaseDados();
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
                usuarioLogado = admin;
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
