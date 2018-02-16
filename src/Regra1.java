public class Regra1 implements RegraEmprestimo {

	public boolean podeEmprestar(Usuario usuario, Livro livro) {
		return ((livroEstaDisponivel(livro))&&(!usuarioPossuiEmprestimo(usuario,livro)));
	}
		
	
	private boolean livroEstaDisponivel(Livro livro) {
		if (!livro.estaDisponivel()) {
			throw new livroIndisponivelException();
		} else {
			return true;
		}
	}
	
	private boolean usuarioPossuiEmprestimo(Usuario usuario, Livro livro) {
		if (usuario.possuiEmprestimo(livro)) {
			throw new conflitoDeEmprestimoException();
		} else {
			return false;
		}
	}

}
