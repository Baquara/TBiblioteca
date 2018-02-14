import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Biblioteca {

	

	private Fachada fachada = new Fachada();

	private Comando[] commando;

	private ParametrosCommand[] parametrosCommand;
	
	private static Biblioteca instancia = null;

	private ArrayList<Usuario> usuarios;
	private ArrayList<Livro> livros;

	public static void main(String[] args) {
		Biblioteca.get().initCasosDeTeste();
		while (true) {
			Sistema.get().esperarComando();
		}
	}

	private Biblioteca() {
		this.usuarios = new ArrayList<Usuario>();
		this.livros = new ArrayList<Livro>();
	}

	public static Biblioteca get() {
		if (instancia == null) {
			instancia = new Biblioteca();
		}
		return instancia;
	}

	private void initCasosDeTeste() {}
	

	public void novoAluno(String codigo, String nome) {
		Usuario usr = new Aluno(codigo, nome);
		usuarios.add(usr);
	}

	public void novoFuncionario(String codigo, String nome) {
		Usuario usr = new Funcionario(codigo, nome);
		usuarios.add(usr);
	}

	public void Professor(String codigo, String nome) {
		Usuario usr = new Professor(codigo, nome);
		usuarios.add(usr);
	}

	public Fachada usarFacade() {
		return this.fachada;
	}


	


}
