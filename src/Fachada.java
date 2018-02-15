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
			
			if(this.usuarios.get(i).getCodigo().equals(codigo)) {
				return this.usuarios.get(i);
			}
			
		}
		
		return null;
	}

	public Livro getLivro(String codigo) {
for(int i=0;i<this.livros.size();i++) {

			
			if(this.livros.get(i).getCodigo().equals(codigo)) {
				//System.out.println("chegou aqui");
				return this.livros.get(i);
			}
			
		}
		
		return null;
	}
	
	public ArrayList<Livro> RetornaLivros(){
			
	return this.livros;
	
	
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
		Exemplar exemplar=null;
		//System.out.println(codigoUsuario + " " + codigoLivro);
		
		if(usuarioencontrado!=null) {
			if(livroencontrado!=null) {
						
						if(usuarioencontrado.podeEmprestar()==true) {
							
							
							for(int i=0;i<livroencontrado.getExemplares().size();i++) {
						if(livroencontrado.getExemplares().get(i).getDisponibilidade()==true) {
							 exemplar = livroencontrado.getExemplares().get(i);
						break;
						}
							}
								
							if(exemplar.getDisponibilidade()==true)
							usuarioencontrado.realizarEmprestimo(exemplar);
							ArrayList<Reserva> reservas = usuarioencontrado.getReservas();
							Reserva reserva=null;
							for(int i=0;i<reservas.size();i++) {
								if(reservas.get(i).getUsuario()==usuarioencontrado && reservas.get(i).getLivro()==livroencontrado)
								reserva=reservas.get(i);
								
							};
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
		Emprestimo emprestimo = null;
		if(usuarioencontrado!=null) {
			if(livroencontrado!=null) {
				for(int i=0;i<usuarioencontrado.getEmprestimosCorrentes().size();i++) {
					if(usuarioencontrado.getEmprestimosCorrentes().get(i).getExemplar().getLivro()==livroencontrado)
					{
						emprestimo=usuarioencontrado.getEmprestimosCorrentes().get(i);
						usuarioencontrado.realizarDevolucao(emprestimo);
						break;
					}
					
					
				}
						
							return "Devolucao realizada com sucesso";
						}
}
 else {
				
				return "Livro não encontrado";
				
			}

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
		
		
		/*Dado o código de um livro, o sistema deve apresentar suas informações da seguinte
forma: (i) título, (ii) quantidade de reservas para aquele livro, e, se diferente de zero,
devem ser também apresentados o nome dos usuários que realizaram cada reserva, (iii)
para cada exemplar, deve ser apresentado seu código, seu status (disponível ou
emprestado), e em caso do exemplar estar emprestado deverá ser exibido o nome do
usuário que realizou o empréstimo, a data de empréstimo e a data prevista para
devolução. Para solicitar tal consulta, o usuário deverá digitar o comando “liv”, seguido
do código do livro.
		 * 
		 */
		Livro livroencontrado = getLivro(codigoLivro);
		if(livroencontrado!=null) {
			int quantidadeReservas=livroencontrado.getReservas().size();
			
			
java.lang.String resultado = livroencontrado.getTitulo() + " " + quantidadeReservas;

if(quantidadeReservas!=0) {

		String caracteristicas="";
		
		for(int i=0;i<livroencontrado.getExemplares().size();i++) {
			if(livroencontrado.getExemplares().get(i).getDisponibilidade()==true) {
		 caracteristicas+= livroencontrado.getExemplares().get(i).getCodigo() + "Disponível";
			}
			else {
				caracteristicas+= livroencontrado.getExemplares().get(i).getCodigo() + "Emprestado";
				caracteristicas+= livroencontrado.getExemplares().get(i).getEmprestimo().getUsuario().getNome() +" ";
				caracteristicas+= livroencontrado.getExemplares().get(i).getEmprestimo().getDataDeEmprestimo() + " ";
				caracteristicas+= livroencontrado.getExemplares().get(i).getEmprestimo().getDataDeDevolucao() + " ";
			}
					
		}
	
	
	
resultado+=" " + caracteristicas;

						
					}
//System.out.println(resultado);
return resultado;
			}
		return "Livro não encontrado";
	}

	
	
	
	
	
	public String consultarProfessor(String CodigoProfessor) {
		/*Dado um professor, o sistema deve retornar a quantidade de vezes que ele foi notificado
sobre mais de duas reservas simultâneas em livros observados por ele. Para solicitar tal
consulta, o usuário deverá digitar o comando “ntf”, seguido do código do usuário. Não há
necessidade de checar se o código se refere realmente a um professor.
		 * 
		 */
		
		Professor professor = (Professor) getUsuario(CodigoProfessor);
		
		
		return "O professor " + professor.getNome() + "foi notificado" + professor.getNotificacoes() + " vezes";
		

	}
	




}
