import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;

public abstract class Usuario {
	
    private ArrayList<Emprestimo> emprestimosCorrentes = new ArrayList<Emprestimo>();
    private ArrayList<Emprestimo> emprestimosPassados = new ArrayList<Emprestimo>();
    private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	private String codigo;
	private String nome;
	private RegraEmprestimo regra;

	public Usuario(String codigo, String nome, RegraEmprestimo regra) {
		this.codigo=codigo;
		this.nome=nome;
		this.regra=regra;
	}

	public boolean estaDevedor() {
		ZoneId zoneId = ZoneId.of( "America/Montreal" );
		ZonedDateTime now = ZonedDateTime.now( zoneId );
		java.util.Date utilDate = java.util.Date.from ( now.toInstant() ) ;
		
		for(int i=0;i<this.emprestimosCorrentes.size();i++) {
			if(this.emprestimosCorrentes.get(i).getDataDeDevolucao().before(utilDate)) {
					return true;
			}			
		}
		return false;
	}

	public void realizarEmprestimo(Exemplar exemplar) {
		Emprestimo novoEmprestimo= new Emprestimo(this,exemplar);
		this.emprestimosCorrentes.add(novoEmprestimo);
		exemplar.cadastrarEmprestimo(novoEmprestimo);
	}

	public void realizarDevolucao(Emprestimo emprestimo) {
		Exemplar exemplar = emprestimo.getExemplar();
		exemplar.realizarDevolucao();
		/*for(int i=0;i<this.emprestimosCorrentes.size();i++) {
			
			if(this.emprestimosCorrentes.get(i).getExemplar()==exemplar) {
				this.emprestimosCorrentes.remove(i);
				break;
			}*/
		emprestimo.realizarDevolucao();
		this.emprestimosCorrentes.remove(emprestimo);
		this.emprestimosPassados.add(emprestimo);
	}
	
	public void realizarReserva(Livro livro) {
		Reserva novaReserva = new Reserva(this, livro);
		reservas.add(novaReserva);
		livro.cadastrarReserva(novaReserva);
	}

	public void excluirReserva(Livro livro) {
		/*Preciso que ele receba um livro, procure a reserva no ArrayList reservas e depois 
		 * remova a reserva do ArrayList. Não precisa conferir se a reserva existe.; 
		 * */
		for(int i=0;i<this.reservas.size();i++) {
			if(this.reservas.get(i).getLivro()==livro) {
				this.reservas.remove(this.reservas.get(i));
				
			}
			
			
		}
	}
	
	public boolean possuiReserva(Livro livro){
/*Obs.: recebe um livro e verifica se o usuario possui 
* reserva desse livro (tem que percorrer o ArrayList reservas), retorna true ou false.*/
		for(int i=0;i<this.reservas.size();i++) {
			if(this.reservas.get(i).getUsuario().getNome().equals(this.nome)) {
				return true;
				
			}
			
			
		}
		
		return false;
		
	}
	
	public boolean possuiEmprestimo(Livro livro){
		/*Obs.: Recebe um livro e verifica se o usuário possui emprestimo para 
		 * esse livro, retorna true ou false (tem que percorrer o ArrayList emprestimosCorrentes).*/
		 
		for(int i=0;i<this.emprestimosCorrentes.size();i++) {
			if(this.emprestimosCorrentes.get(i).getExemplar().getLivro().equals(livro)) {
				return true;
			}
		}
		return false;
	}
		
	public Emprestimo retornaEmprestimo(Livro livro){
		for(int i=0;i<this.emprestimosCorrentes.size();i++) {
			if(this.emprestimosCorrentes.get(i).getExemplar().getLivro().equals(livro)) {
				return this.emprestimosCorrentes.get(i);
			}
		}
		return null;
	}	
	

	public ArrayList<Emprestimo> getEmprestimosCorrentes() {
		return this.emprestimosCorrentes;
	}

	public ArrayList<Emprestimo> getEmprestimosPassados() {
		return this.emprestimosPassados;
	}

	public ArrayList<Reserva> getReservas() {
		return reservas;
	}
	

	public boolean podeEmprestar(Livro livro) {
		return regra.podeEmprestar(this, livro);
	}

	public boolean podeReservar() {
		return (this.getReservas().size()<3);
	}

	public String getCodigo() {
		return this.codigo;
	}

	public String getNome() {
		return this.nome;
	}
	public abstract int getTempoDeEmprestimo();
	public abstract int getLimiteDeEmprestimos();

	

}
