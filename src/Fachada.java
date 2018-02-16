import java.util.ArrayList;

public class Fachada {
	
	private ArrayList<Livro> livros = new ArrayList<Livro>();
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private static Fachada instancia;


	private Fachada () {

	}

	public static Fachada getInstancia() {
		return Fachada.instancia;
	}

	public Usuario getUsuario(String codigo) {
	for(int i=0;i<this.usuarios.size();i++) {
			if(this.usuarios.get(i).getCodigo().equals(codigo)) {
				return this.usuarios.get(i);
			}
			
		}
		throw new IllegalArgumentException("O codigo de usuário informado não existe!");
	}

	public Livro getLivro(String codigo) {
		for(int i=0;i<this.livros.size();i++) {
			if(this.livros.get(i).getCodigo().equals(codigo)) {
				//System.out.println("chegou aqui");
				return this.livros.get(i);
			}
		}
		throw new IllegalArgumentException("O codigo de livro informado não existe!");
	}
	
	public ArrayList<Livro> RetornaLivros(){
		return this.livros;
	}

	public void cadastrarLivro(String codigo, String titulo, String editora, String autores, String edicao, String anoDePublicacao) {
		Livro livro = new Livro(codigo,titulo,editora,autores,edicao,anoDePublicacao);
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

	public String cadastrarObservador(Subject subject, Observer observador) {
		subject.registerObserver(observador);
		return "O observador foi cadastrado com sucesso.";
	}
	
	/*public void cadastrarObservador2(String usuario, String livro) {
		Observer observador = null;
		Livro liv = null;
		cadastrarObservador(liv,observador);
	}*/

	public String realizarEmprestimo(String codigoUsuario, String codigoLivro) {
		String mensagem ="";
		/*Usuario usuarioencontrado = getUsuario(codigoUsuario);
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
				
				return "Livro nÃ£o encontrado";
			}

	}
		return "Usuario nÃ£o encontrado";*/
		
		try {
			Usuario usuario = getUsuario(codigoUsuario);
			Livro livro = getLivro(codigoLivro);
			if(usuario.podeEmprestar(livro)) {
				if (usuario.possuiReserva(livro)) {
					usuario.excluirReserva(livro);
				}
				usuario.realizarEmprestimo(livro.getExemplarDisponivel());
				mensagem = "O empréstimo foi realizado com sucesso. Usuário: "+usuario.getNome()+" Livro: "+livro.getTitulo();
			}
		} catch (IllegalArgumentException e) {
			return (e.getMessage());
		} catch (LivroIndisponivelException e) {
			return (e.getMessage());
		} catch (UsuarioDevedorException e) {
			return (e.getMessage());
		} catch (LimiteDeEmprestimosException e) {
			return (e.getMessage());
		} catch (LivroReservadoException e) {
			return (e.getMessage());
		} catch (ConflitoDeEmprestimoException e) {
			return (e.getMessage());
		}
		return mensagem;
	}

	public String realizarDevolucao(String codigoUsuario, String codigoLivro) {
		String mensagem ="";
		/*Usuario usuarioencontrado = getUsuario(codigoUsuario);
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
						
							return "Devolução realizada com sucesso";
						}
}
 else {
				
				return "Livro não encontrado";
				
			}

		return "Usuario não encontrado";*/
		
		try {
			Usuario usuario = getUsuario(codigoUsuario);
			Livro livro = getLivro(codigoLivro);
			if(usuario.possuiEmprestimo(livro)) {
				Emprestimo emprestimo = usuario.retornaEmprestimo(livro);
				usuario.realizarDevolucao(emprestimo);
				mensagem = "A devolução foi realizada com sucesso. Usuário: "+usuario.getNome()+" Livro: "+livro.getTitulo();
			} else {
				mensagem = "Não existe empréstimo aberto do livro "+livro.getTitulo()+" para o usuário "+usuario.getNome();
			}
		} catch (IllegalArgumentException e) {
			return (e.getMessage());
		}
		return mensagem;
	}

	public String realizarReserva(String codigoUsuario, String codigoLivro) {
		String mensagem ="";
		/*Usuario usuarioencontrado = getUsuario(codigoUsuario);
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
		return "Usuario não encontrado";*/
		
		try {
			Usuario usuario = getUsuario(codigoUsuario);
			Livro livro = getLivro(codigoLivro);
			if(usuario.podeReservar()) {
				usuario.realizarReserva(livro);
				mensagem = "A reserva do livro "+livro.getTitulo()+" para o usuário "+usuario.getNome()+" foi realizada com sucesso.";
			} else {
				mensagem = "A reserva do livro "+livro.getTitulo()+" não pôde ser realizada, pois o usuário "+usuario.getNome()+" já possui o limite de 3 (três) reservas.";
			}
		} catch (IllegalArgumentException e) {
			return (e.getMessage());
		}
		return mensagem;
	}

	public String consultarUsuario(String codigoUsuario) {
		Usuario usuarioencontrado = getUsuario(codigoUsuario);
		
		if(usuarioencontrado!=null) {
			

				String reservastring="";

			for(int i=0;i< usuarioencontrado.getReservas().size();i++) {
					
						reservastring+= usuarioencontrado.getReservas().get(i).getNome() + " ";
					
					
				}
			
							java.lang.String resultado = usuarioencontrado.getNome() + " " 
							+ usuarioencontrado.getCodigo() +" "+ usuarioencontrado.getEmprestimosCorrentes() + 
							" " + usuarioencontrado.getEmprestimosPassados() + " " + reservastring + " " + usuarioencontrado.estaDevedor();
							return resultado;
						
					}

		return "Usuario não encontrado";
	}

	public String consultarLivro(String codigoLivro) {
	/*Dado o cÃ³digo de um livro, o sistema deve apresentar suas informaÃ§Ãµes da seguinte
forma: (i) tÃ­tulo, (ii) quantidade de reservas para aquele livro, e, se diferente de zero,
devem ser tambÃ©m apresentados o nome dos usuÃ¡rios que realizaram cada reserva, (iii)
para cada exemplar, deve ser apresentado seu cÃ³digo, seu status (disponÃ­vel ou
emprestado), e em caso do exemplar estar emprestado deverÃ¡ ser exibido o nome do
usuÃ¡rio que realizou o emprÃ©stimo, a data de emprÃ©stimo e a data prevista para
devoluÃ§Ã£o. Para solicitar tal consulta, o usuÃ¡rio deverÃ¡ digitar o comando â€œlivâ€�, seguido
do cÃ³digo do livro.
		 * 
		 */
		String resultado ="";
		try {
			Livro livroencontrado = getLivro(codigoLivro);
			int quantidadeReservas=livroencontrado.getReservas().size();
			resultado = "Titulo: "+livroencontrado.getTitulo() + "\n Quantidade de reservas: " + quantidadeReservas+"\n";
			if(quantidadeReservas!=0) {
				resultado+="--RESERVAS--\n";
				for(int i=0;i<livroencontrado.getReservas().size();i++) {
					Reserva reserva = livroencontrado.getReservas().get(i);
					resultado+="Usuário: "+reserva.getUsuario().getNome()+"\n";
				}
			}
			resultado+="--EXEMPLARES--\n";
			for(int i=0;i<livroencontrado.getExemplares().size();i++) {
				String status = "";
				String emprestimo="";
				Exemplar exemplar = livroencontrado.getExemplares().get(i);
				if (exemplar.getDisponibilidade()) {
					status = "Disponível";
					emprestimo="";
				} else {
					status = "Emprestado";
					emprestimo = "Dados do empréstimo:\nUsuário: "+exemplar.getEmprestimo().getUsuario().getNome()+" Data de empréstimo: "+exemplar.getEmprestimo().getDataDeEmprestimo()+" Data prevista da devolução: " + exemplar.getEmprestimo().getDataDeDevolucao()+"\n";
				}
				resultado+="Código: "+exemplar.getCodigo()+" Status: "+status+"\n"+emprestimo;
			}	
					
		} catch (IllegalArgumentException e) {
			return (e.getMessage());
		}
		return resultado;
		
		/*
		if(livroencontrado!=null) {
			int quantidadeReservas=livroencontrado.getReservas().size();
			
			
			String resultado = livroencontrado.getTitulo() + " " + quantidadeReservas;

			if(quantidadeReservas!=0) {
				String caracteristicas="";
				for(int i=0;i<livroencontrado.getExemplares().size();i++) {
					if(livroencontrado.getExemplares().get(i).getDisponibilidade()==true) {
						caracteristicas+= livroencontrado.getExemplares().get(i).getCodigo() + "Disponível";
					} else {
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
		return "Livro não encontrado";*/
	}

	
	
	
	
	
	public String consultarProfessor(String CodigoProfessor) {
		/*Dado um professor, o sistema deve retornar a quantidade de vezes que ele foi notificado
sobre mais de duas reservas simultÃ¢neas em livros observados por ele. Para solicitar tal
consulta, o usuÃ¡rio deverÃ¡ digitar o comando â€œntfâ€�, seguido do cÃ³digo do usuÃ¡rio. NÃ£o hÃ¡
necessidade de checar se o cÃ³digo se refere realmente a um professor.
		 * 
		 */
		
		Professor professor = (Professor) getUsuario(CodigoProfessor);
		
		
		return "O professor " + professor.getNome() + "foi notificado" + professor.getNotificacoes() + " vezes";
		

	}
	




}
