package ProjetoTarefas;

import java.util.ArrayList;
import java.util.List;

public class GerenciamentoTarefas { 
	
	private List<Usuario> usuarios;
	
	GerenciamentoTarefas() {
		this.usuarios = new ArrayList<>();		
	}
	
	
	public void cadastrarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public Usuario buscarUsuario(String email) {
		for(Usuario usuario : usuarios) {
			if(usuario.getEmail().equals(email)) {
				return usuario;
			}
		}
		return null;
	}
	
	public void exibirTarefas(String email) {
		Usuario usuario = buscarUsuario(email);
		if (usuario != null) {
			List<Tarefas> tarefas = usuario.getTarefas();
			for(Tarefas tarefa : tarefas) {
				System.out.println(tarefa);
			}
		} else {
			System.out.println("Usuário não encontrado.");
		}
	}
	
	public void marcarTarefaComoConcluida(String email, String nomeTarefa) {
		Usuario usuario = buscarUsuario(email);
		if(usuario != null) {
			for(Tarefas tarefa : usuario.getTarefas()) {
				if(tarefa.getNome().equals(nomeTarefa)) {
					tarefa.setConcluida(true);
					System.out.println("Tarefa marcada como concluída: " + tarefa);
					return;
				}
			}
			System.out.println("Tarefa não encontrada.");
			} else {
				System.out.println("Usuário não encontrado.");
		}
	}
}
