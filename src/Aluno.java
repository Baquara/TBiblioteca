public class Aluno extends Usuario {

	private static int tempoDeEmprestimo = 5;

	private static int limiteDeEmprestimos = 4;

	public Aluno(String codigo, String nome) {
		super(codigo,nome,new Regra2());
	}

	public static int getTempoDeEmprestimo() {
		return 0;
	}

	public static int getLimiteDeEmprestimos() {
		return 0;
	}

}
