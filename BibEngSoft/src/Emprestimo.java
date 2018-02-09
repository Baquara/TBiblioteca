import java.util.Date;

public class Emprestimo {

	private Usuario usuario;

	private Date dataDeRealizacao;

	private Date dataDeDevolucao;

	private Exemplar exemplar;

	private boolean emCurso;


	public void Emprestimo(Usuario usuario, Exemplar exemplar) {

		this.usuario=usuario;
		this.exemplar=exemplar;
		this.emCurso=true;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public Date getDataDeEmprestimo() {
		return this.dataDeRealizacao;
	}

	public Date getDataDeDevolucao() {
		return this.dataDeDevolucao;
	}
	
	public void setDevolucao() {
		
		this.emCurso=false;
		
	}

	public Exemplar getExemplar() {
		return this.exemplar;
	}

}
