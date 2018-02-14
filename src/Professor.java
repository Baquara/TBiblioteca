public class Professor extends Usuario implements Observer {

	private static int tempoDeEmprestimo = 7;

	private static int limideDeEmprestimos = 0;

	private int qtdNotificacoes = 0;

	public Professor(String codigo, String nome) {
    super(codigo,nome,new Regra1());
	}

	public static int getTempoDeEmprestimo() {
		return 0;
	}

	public static int getLimiteDeEmprestimos() {
		return 0;
	}

	public int getNotificacoes() {
		return this.qtdNotificacoes;
	}

	public void update() {
		this.qtdNotificacoes++;

	}

}
