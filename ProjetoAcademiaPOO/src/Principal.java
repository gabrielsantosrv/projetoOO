import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    private static ArrayList<Gerenciador> gerenciadores;
    private static Gerenciador gerenciadorLogado;

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
                    gerenciadorLogado.incluirCliente();
                    break;
                }
                case 2: {
                    //Alterar cliente
                    gerenciadorLogado.alterarCliente();
                    break;
                }
                case 3: {
                    //Desativar cliente
                    gerenciadorLogado.desativarCliente();
                    break;
                }
                case 4: {
                    //Incluir instrutor
                    gerenciadorLogado.incluirInstrutor();
                    break;
                }
                case 5: {
                    //Alterar instrutor
                    gerenciadorLogado.alterarInstrutor();
                    break;
                }
                case 6: {
                    //Desativar instrutor
                    gerenciadorLogado.desativarInstrutor();
                    break;
                }
                case 7: {
                    //Incluir atividade
                    gerenciadorLogado.incluirAtividade();
                    break;
                }
                case 8: {
                    //Alterar atividade
                    gerenciadorLogado.alterarAtividade();
                    break;
                }
                case 9: {
                    //Excluir atividade
                    gerenciadorLogado.excluirAtividade();
                    break;
                }
                case 10: {
                    //Incluir turma
                    gerenciadorLogado.incluirTurma();
                    break;
                }
                case 11: {
                    //Alterar turma
                    gerenciadorLogado.alterarTurma();
                    break;
                }
                case 12: {
                    //Excluir turma
                    gerenciadorLogado.excluirTurma();
                    break;
                }
                //Relacionamentos
                case 13: {
                    //Associar instrutor à turma
                    gerenciadorLogado.relacionarTurmaInstrutor();
                    break;
                }
                case 14: {
                    //Associar cliente à turma
                    gerenciadorLogado.relacionarTurmaCliente();
                    break;
                }
                case 15: {
                    //Desassociar instrutor e turma
                    gerenciadorLogado.desrelacionarTurmaInstrutor();
                    break;
                }
                case 16: {
                    //Desassociar cliente e turma
                    gerenciadorLogado.desrelacionarTurmaCliente();
                    break;
                }
                //Consultas - passar da base para a classe de interação
                case 17: {
                    //Todos os clientes
                    gerenciadorLogado.exibirClientes();
                    break;
                }
                case 18: {
                    //Todos os instrutores
                    gerenciadorLogado.exibirInstrutores();
                    break;
                }
                case 19: {
                    //Todas as atividades
                    gerenciadorLogado.exibirAtividades();
                    break;
                }
                case 20: {
                    //Turmas por atividade específica
                    gerenciadorLogado.exibirTurmasPorAtividade();
                    break;
                }
                case 21: {
                    //Clientes que fazem uma atividade específica
                    gerenciadorLogado.clientesDeUmaAtividade();
                    break;
                }
                case 22: {
                    //Instrutores que cuidam de uma atividade específica
                    gerenciadorLogado.instrutoresDeUmaAtividade();
                    break;
                }
                case 23: {
                    //Quantidade de clientes que fazem uma atividade específica
                    gerenciadorLogado.qtdClientesDeUmaAtividade();
                    break;
                }
                case 24: {
                    //Clientes que estão em uma turma específica
                    gerenciadorLogado.verificarClientesPorTurma();
                    break;
                }
                case 25: {
                    //Atividade com maior número de clientes
                    gerenciadorLogado.atividadeComMaisClientes();
                    break;
                }
                case 26: {
                    //Atividade com menor número de clientes
                    gerenciadorLogado.atividadeComMenosClientes();
                    break;
                }
                case 27: {
                    //Atividade com maior preço
                    gerenciadorLogado.atividadeComMaiorPreco();
                    break;
                }
                case 28: {
                    //Atividade com menor preço
                    gerenciadorLogado.atividadeComMenorPreco();
                    break;
                }
                case 29: {
                    //Turmas por cliente específico
                    gerenciadorLogado.turmasDeUmCliente();
                    break;
                }
                case 30: {
                    //Turmas por instrutor específico
                    gerenciadorLogado.turmasDeUmInstrutor();
                    break;
                }
            }
        }
    }

    public static void carregarUsuariosPadrao() {
        gerenciadores = new ArrayList<>();

        Gerenciador gerenciador = new Gerenciador("admin", "admin");
        gerenciador.setPermissoes(Permissoes.ADMIN);

        gerenciadores.add(gerenciador);
    }

    public static boolean login() {
        Scanner input = new Scanner(System.in);
        System.out.println("Username: ");
        String username = input.next();
        System.out.println("Senha: ");
        String senha = input.next();

        for (Gerenciador gerenciador : gerenciadores) {
            if (gerenciador.getUsername().equals(username) && gerenciador.getSenha().equals(senha)) {
                gerenciadorLogado = gerenciador;
                return true;
            }
        }

        return false;
    }
}
