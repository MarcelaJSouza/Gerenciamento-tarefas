package ProjetoTarefas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InterfaceUsuario {
	
	public static void main(String[] args) {
		
		GerenciamentoTarefas gerenciador = new GerenciamentoTarefas();
		Scanner scanner = new Scanner(System.in);
		boolean executado = true;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		while(executado) {
			System.out.println("\n=== Sistema de Gerenciamento de Tarefas ===");
			System.out.println("1. Cadastrar Usuário");
			System.out.println("2. Adicionar Tarefa");
			System.out.println("3. Remover Tarefa");
			System.out.println("4. Exibir Tarefas");
			System.out.println("5. Marcar Tarefa como Concluída");
			System.out.println("0. Sair");
			System.out.println("Escolha uma opção: ");
			
			int opcao = scanner.nextInt();
			scanner.nextLine();
			
			switch(opcao) {
			case 1:
				System.out.print("Digite o nome do usuário: ");
				String nomeUsuario = scanner.nextLine();
				System.out.println("\nDigite o e-mail do usuário: ");
				String emailUsuario = scanner.nextLine();
				Usuario novoUsuario = new Usuario(nomeUsuario,emailUsuario);
				gerenciador.cadastrarUsuario(novoUsuario);
				System.out.println("Usuário cadastrado com sucesso.");
				break;
				
			case 2:
				System.out.print("Digite o e-mail do usuário: ");
				String emailTarefa = scanner.nextLine();
				Usuario usuarioParaTarefa = gerenciador.buscarUsuario(emailTarefa);
				if(usuarioParaTarefa != null) {
					System.out.print("Digite o nome da tarefa: ");
					String nomeTarefa = scanner.nextLine();
					System.out.print("Digite a descrição da tarefa: ");
					String descricaoTarefa = scanner.nextLine();
					System.out.print("Digite a data limite (yyyy-MM-dd): ");
					String dataLimite = scanner.nextLine();
					LocalDate data = LocalDate.parse(dataLimite, formatter);
					
					Tarefas novaTarefa = new Tarefas(nomeTarefa, descricaoTarefa, data);
					usuarioParaTarefa.adicionarTarefa(novaTarefa);
					System.out.println("Tarefa adicionada com sucesso." );
				} else {
					System.out.println("Usuário não encontrado.");
				}
				break;
				
			case 3:
				System.out.print("Digite o e-mail do usuário: ");
				String emailRemoverTarefa = scanner.nextLine();
				Usuario usuarioParaRemoverTarefa = gerenciador.buscarUsuario(emailRemoverTarefa);
				if(usuarioParaRemoverTarefa != null) {
					System.out.print("Digite o nome da tarefa que deseja remover: ");
					String nomeTarefaRemover = scanner.nextLine();
					usuarioParaRemoverTarefa.removerTarefa(nomeTarefaRemover);
					System.out.println("Tarefa movida com sucesso.");
				} else {
					System.out.println("Usuário não encontrado.");
				}
				break;
				
			case 4:
				System.out.print("Digite o e-mail do usuário: ");
				String emailExibirTarefas = scanner.nextLine();
				gerenciador.exibirTarefas(emailExibirTarefas);
				break;
				
			case 5:
				System.out.print("Digite o e-mail do usuário: ");
				String emailConcluirTarefa = scanner.nextLine();
				System.out.print("Digite o nome da tarefa que deseja marcar como concluída.");
				String nomeTarefaConcluir = scanner.nextLine();
				gerenciador.marcarTarefaComoConcluida(emailConcluirTarefa, nomeTarefaConcluir);
				break;
				
			case 0:
				executado = false;
				System.out.println("Encerrando o sistema.");
				break;
				
				default:
					System.out.println("Opção inválida! Tente novamente.");
			}
		}
		
		scanner.close();
		
	}
}
