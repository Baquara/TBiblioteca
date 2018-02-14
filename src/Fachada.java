import java.util.ArrayList;

public class Fachada {
	
	   private ArrayList<Livro> livros = new ArrayList();
	    private ArrayList<Usuario> usuarios = new ArrayList();

	private static Fachada instancia;


	private static void Fachada() {

	}

	public static Fachada getInstancia() {
		return null;
	}

	public Usuario getUsuario(String codigo) {
	for(int i=0;i<this.usuarios.size();i++) {
			
			if(this.usuarios.get(i).getCodigo()==codigo) {
				return this.usuarios.get(i);
			}
			
		}
		
		return null;
	}

	public Livro getLivro(String codigo) {
for(int i=0;i<this.livros.size();i++) {
			
			if(this.livros.get(i).getCodigo()==codigo) {
				return this.livros.get(i);
			}
			
		}
		
		return null;
	}

	public void cadastrarLivro(String codigo, String titulo, String editora, String autores, String edição, String anoDePublicação) {
		Livro livro = new Livro(codigo,titulo,editora,autores,edição,anoDePublicação);
		this.livros.add(livro);
	}

	public void cadastrarExemplar(String codigo, Livro livro) {
		livro.cadastrarExemplar(codigo);

	}

	public void cadastrarFuncionario(String codigo, String nome) {
		
		Funcionario funcionario = new Funcionario(codigo,nome);
		this.usuarios.add(funcionario);
		

	}

	public void cadastrarAluno(String codigo, String nome) {
		
		
		Aluno aluno = new Aluno(codigo,nome);
		this.usuarios.add(aluno);
		

	}

	public void cadastrarProfessor(String codigo, String nome) {
		
		
		Professor professor = new Professor(codigo,nome);
		this.usuarios.add(professor);

	}

	public void cadastrarObservador(Livro livro, Observer observador) {
livro.registerObserver(observador);
	}
	
	public void cadastrarObservador2(String usuario, String livro) {
		Observer observador = null;
		Livro liv = null;
		cadastrarObservador(liv,observador);
		
	}

	public java.lang.String realizarEmprestimo(String codigoUsuario, String codigoLivro) {
		Usuario usuarioencontrado = getUsuario(codigoUsuario);
		Livro livroencontrado = getLivro(codigoLivro);
		if(usuarioencontrado!=null) {
			if(livroencontrado!=null) {
						
						if(usuarioencontrado.podeEmprestar()==true) {
							//fazer tentativa de emprestimo
							//DESCOMENTAR QUANDO SOLUCIONAR - if(exemplar.getDisponibilidade()==true)
							//DESCOMENTAR QUANDO SOLUCIONAR -usuarioencontrado.realizarEmprestimo(livroencontrado);
							Reserva reserva = usuarioencontrado.getReservas(codigoLivro);
							if(reserva!=null) {
							usuarioencontrado.excluirReserva(reserva);
							livroencontrado.excluirReserva(reserva);
							}
							return "Emprestimo realizado com sucesso";
						}
					}
			else {
				
				return "Livro não encontrado";
			}

	}
		return "Usuario não encontrado";
	}

	public java.lang.String realizarDevolucao(String codigoUsuario, String codigoLivro) {
		Usuario usuarioencontrado = getUsuario(codigoUsuario);
		Livro livroencontrado = getLivro(codigoLivro);
		if(usuarioencontrado!=null) {
			if(livroencontrado!=null) {
				/* DESCOMENTAR QUANDO ENCONTRAR SOLUÇÃO
						if(usuarioencontrado.getEmprestimosCorrentes()==livroencontrado){
							//fazer devolucao de emprestimo
							Emprestimo emprestimo = usuarioencontrado.getEmprestimosCorrentes();
							usuarioencontrado.realizarDevolucao(emprestimo);
*/
							}
							return "Devolucao realizada com sucesso";
						}
		/*	}
	 DESCOMENTAR QUANDO ENCONTRAR SOLUÇÃO else {
				
				return "Livro não encontrado";
				
			}
	*/
		return "Usuario não encontrado";
	}

	public java.lang.String realizarReserva(String codigoUsuario, String codigoLivro) {
		Usuario usuarioencontrado = getUsuario(codigoUsuario);
		Livro livroencontrado = getLivro(codigoLivro);
		if(usuarioencontrado!=null) {
			if(livroencontrado!=null) {
						
						if(usuarioencontrado.estaDevedor()==false) {
							//fazer tentativa de emprestimo
							if(usuarioencontrado.podeReservar()==true)
							usuarioencontrado.realizarReserva(livroencontrado);
							return "Reserva realizada com sucesso";
						}
					}
			else {
				
				return "Livro não encontrado";
			}

	}
		return "Usuario não encontrado";
	}

	public java.lang.String consultarUsuario(String codigoUsuario) {
		Usuario usuarioencontrado = getUsuario(codigoUsuario);
		if(usuarioencontrado!=null) {

							java.lang.String resultado = usuarioencontrado.getNome() + " " 
							+ usuarioencontrado.getCodigo() +" "+ usuarioencontrado.getEmprestimosCorrentes() + 
							" " + usuarioencontrado.getEmprestimosPassados() + " " + usuarioencontrado.getReservasString() + " " + usuarioencontrado.estaDevedor();
							return resultado;
						
					}

		return "Usuario não encontrado";
	}

	public String consultarLivro(String codigoLivro) {
		return null;
	}

	public String consultarProfessor(String CodigoProfessor) {
		return null;
	}



}
