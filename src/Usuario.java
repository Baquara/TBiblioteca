import java.util.ArrayList;
import java.util.Date;

public abstract class Usuario {
	
    private ArrayList<Emprestimo> emprestimosCorrentes = new ArrayList();
    private ArrayList<Emprestimo> emprestimosPassados = new ArrayList();
    private ArrayList<Reserva> reservas = new ArrayList();

	private String codigo;

	private String nome;
	
	private Date dataatual = new Date();

	private RegraEmprestimo regras;

	private RegraEmprestimo regraEmprestimo;


	public Usuario(String codigo, String nome, RegraEmprestimo regras) {
this.codigo=codigo;
this.nome=nome;
this.regras=regras;
		
		
		
	}

	public boolean estaDevedor() {
		
		
		for(int i=0;i<this.emprestimosCorrentes.size();i++) {
			
			if(this.emprestimosCorrentes.get(i).getDataDeDevolucao().before(this.dataatual)) {
				
				
			}
			
		}
		
		return false;
	}

	public void realizarEmprestimo(Exemplar exemplar) {
		//Usuario usuario= new Usuario(this.codigo,this.nome,this.regras);
		Emprestimo emprestimo= exemplar.getEmprestimo();
		this.emprestimosCorrentes.add(emprestimo);
	}

	public void realizarDevolucao(Emprestimo emprestimo) {
		
		Exemplar exemplar = emprestimo.getExemplar();
		
		exemplar.setDisponibilidade(true);
		
	for(int i=0;i<this.emprestimosCorrentes.size();i++) {
			
			if(this.emprestimosCorrentes.get(i).getExemplar()==exemplar) {
				this.emprestimosCorrentes.remove(i);
				break;
			}
			
		}
	
		
		
	}

	public Reserva realizarReserva(Livro livro) {
		return null;
	}

	public void excluirReserva(Reserva reserva) {
		
		this.reservas.remove(reserva);

	}

	public ArrayList getEmprestimosCorrentes() {
		return null;
	}

	public ArrayList getEmprestimosPassados() {
		return null;
	}

	public Reserva getReservas(String codigo) {
	for(int i=0;i<this.reservas.size();i++) {
			
			if(this.reservas.get(i).getLivro().getCodigo()==codigo) {
				return this.reservas.get(i);
			}
			
		}
	return null;
	}
	
	public String getReservasString() {
	for(int i=0;i<this.reservas.size();i++) {
			
			if(this.reservas.get(i).getLivro().getCodigo()==codigo) {
				return this.reservas.get(i).GetNome();
			}
			
		}
	return null;
	}

	public boolean podeEmprestar() {
		return false;
	}

	public boolean podeReservar() {
		return false;
	}

	public String getCodigo() {
		return null;
	}

	public String getNome() {
		return null;
	}

}
