public class Funcionario extends Usuario {

	private static int tempoDeEmprestimo = 2;

	private static int limiteDeEmprestimos = 3;

	public Funcionario(String codigo, String nome) {
		super(codigo,nome,new Regra2());
	}

	public static int getTempoDeEmprestimo() {
		return 0;
	}

	public static int getLimiteDeEmprestimos() {
		return 0;
	}

}
