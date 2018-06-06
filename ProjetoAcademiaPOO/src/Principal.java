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
    
    public static void mensagem() {
        String opcoes = "Bem vindo! Digite o número da operação correspondente.\n" +
                "0. Sair\n" +
                "1. Incluir cliente\n" +
                "2. Alterar cliente\n" +
                "3. Desativar cliente\n" +
                "4. Incluir instrutor\n" +
                "5. Alterar instrutor\n" +
                "6. Desativar instrutor\n" +
                "7. Incluir atividade\n" +
                "8. Alterar atividade\n" +
                "9. Excluir atividade\n" +
                "10. Incluir turma\n" +
                "11. Alterar turma\n" +
                "12. Excluir turma\n" +
                "13. Associar instrutor à turma\n" +
                "14. Associar cliente à turma\n" +
                "15. Desassociar instrutor e turma\n" +
                "16. Desassociar cliente e turma\n" +
                "\n" +
                "Consultas\n" +
                "---------\n" +
                "17. Todos os clientes\n" +
                "18. Todos os instrutores\n" +
                "19. Todas as atividades\n" +
                "20. Turmas por atividade específica\n" +
                "21. Clientes que fazem uma atividade específica\n" +
                "22. Instrutores que cuidam de uma atividade específica\n" +
                "23. Quantidade de clientes que fazem uma atividade específica\n" +
                "24. Clientes que estão em uma turma específica\n" +
                "25. Atividade com maior número de clientes\n" +
                "26. Atividade com menor número de clientes\n" +
                "27. Atividade com maior preço\n" +
                "28. Atividade com menor preço\n" +
                "29. Turmas por cliente específico\n" +
                "30. Turmas por instrutor específico";
        System.out.println(opcoes);
    }

    @SuppressWarnings("resource")
	public static void menu() {
        mensagem();
        Scanner input = new Scanner(System.in);
        int operacao = -1;
        while (operacao != 0) {
            operacao = input.nextInt();
            switch (operacao) {
                //Inclusões, exclusões e alterações
                case 1: {
                    //Incluir cliente
                    gerenciadorLogado.incluirCliente("1", "Ana", "Rua do IC", "40028922", "20/05/2017", null);
                    break;
                }
                case 2: {
                    //Alterar cliente
                    gerenciadorLogado.alterarCliente("1", "Gabriel", "Rua do IC", "40028922", "20/05/2018", null);
                    break;
                }
                case 3: {
                    //Desativar cliente
                    gerenciadorLogado.desativarCliente("1");
                    break;
                }
                case 4: {
                    //Incluir instrutor
                    gerenciadorLogado.incluirInstrutor("2", "Bruno", "Rua da Fef", "40028922", "20/05/0218", (float)500.0, null);
                    break;
                }
                case 5: {
                    //Alterar instrutor
                    gerenciadorLogado.alterarInstrutor("2", "Victor", "Rua da Fef", "40028922", "20/05/2017", (float)500.0, null);
                    break;
                }
                case 6: {
                    //Desativar instrutor
                    gerenciadorLogado.desativarInstrutor("2");
                    break;
                }
                case 7: {
                    //Incluir atividade
                    gerenciadorLogado.incluirAtividade("Natacao", (float) 50);
                    break;
                }
                case 8: {
                    //Alterar atividade
                    gerenciadorLogado.alterarAtividade("Natacao", (float) 45);
                    break;
                }
                case 9: {
                    //Excluir atividade
                    gerenciadorLogado.excluirAtividade("Natacao");
                    break;
                }
                case 10: {
                    //Incluir turma
                    gerenciadorLogado.incluirTurma("Natacao", "8:00", 25, "1");
                    break;
                }
                case 11: {
                    //Alterar turma
                    gerenciadorLogado.alterarTurma("Natacao", "8:30", "1", 30);
                    break;
                }
                case 12: {
                    //Excluir turma
                    gerenciadorLogado.excluirTurma("Natacao", "1");
                    break;
                }
                //Relacionamentos
                case 13: {
                    //Associar instrutor à turma
                    gerenciadorLogado.relacionarTurmaInstrutor("1", "Natacao", "5");
                    break;
                }
                case 14: {
                    //Associar cliente à turma
                    gerenciadorLogado.relacionarTurmaCliente("2", "Natacao", "3");
                    break;
                }
                case 15: {
                    //Desassociar instrutor e turma
                    gerenciadorLogado.desrelacionarTurmaInstrutor("1", "Natacao", "5");
                    break;
                }
                case 16: {
                    //Desassociar cliente e turma
                    gerenciadorLogado.desrelacionarTurmaCliente("2", "Natacao", "3");
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
                    gerenciadorLogado.clientesDeUmaAtividade("Natacao");
                    break;
                }
                case 22: {
                    //Instrutores que cuidam de uma atividade específica
                    gerenciadorLogado.instrutoresDeUmaAtividade("Natacao");
                    break;
                }
                case 23: {
                    //Quantidade de clientes que fazem uma atividade específica
                    gerenciadorLogado.qtdClientesDeUmaAtividade("Natacao");
                    break;
                }
                case 24: {
                    //Clientes que estão em uma turma específica
                    gerenciadorLogado.verificarClientesPorTurma("Natacao", "5");
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
                    gerenciadorLogado.turmasDeUmCliente("1");
                    break;
                }
                case 30: {
                    //Turmas por instrutor específico
                    gerenciadorLogado.turmasDeUmInstrutor("2");
                    break;
                }
            }
        }
    }

    public static void carregarUsuariosPadrao() {
        gerenciadores = new ArrayList<>();

        //Gerenciador gerenciador = new Gerenciador("admin", "admin");
        //gerenciador.setPermissoes(Permissoes.ADMIN);

        //gerenciadores.add(gerenciador);
    }

    public static boolean login() {
        Scanner input = new Scanner(System.in);
        System.out.println("Username: ");
        String username = input.next();
        System.out.println("Senha: ");
        String senha = input.next();

        for (Gerenciador gerenciador : gerenciadores) {
            //if (gerenciador.getUsername().equals(username) && gerenciador.getSenha().equals(senha)) {
            //    gerenciadorLogado = gerenciador;
            //    return true;
            //}
        }

        return false;
    }
}
