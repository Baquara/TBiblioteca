public class Exemplar {

	private String codigo;

	private Livro livro;

	private boolean estaDisponivel;

	private Emprestimo emprestimo;


	public Exemplar(String codigo) {
		
		this.codigo=codigo;

	}

	public void cadastrarEmprestimo(Emprestimo emprestimo) {
		
		this.emprestimo=emprestimo;

	}

	public void realizarDevolucao() {

	}

	public String getCodigo() {
		return null;
	}

	public Emprestimo getEmprestimo() {
		return this.emprestimo;
	}

	public boolean getDisponibilidade() {
		return this.estaDisponivel;
	}

	public void setDisponibilidade(boolean estaDisponivel) {
		
		this.estaDisponivel=estaDisponivel;

	}

	public void excluirEmprestimo() {

	}

}
