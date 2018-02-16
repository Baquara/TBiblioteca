public class Regra1 implements RegraEmprestimo {

	public boolean podeEmprestar(Usuario usuario, Livro livro) {
		return ((livroEstaDisponivel(livro))&&(!usuarioPossuiEmprestimo(usuario,livro)));
	}
		
	
	private boolean livroEstaDisponivel(Livro livro) {
		if (!livro.estaDisponivel()) {
			throw new livroIndisponivelException("O empr�stimo n�o p�de ser realizado. O livro informado n�o possui exemplar dispon�vel. Usuario: "+usuario.getNome()+" Livro: "+livro.getTitulo());
		} else {
			return true;
		}
	}
	
	private boolean usuarioPossuiEmprestimo(Usuario usuario, Livro livro) {
		if (usuario.possuiEmprestimo(livro)) {
			throw new conflitoDeEmprestimoException("O empr�stimo n�o p�de ser realizado. O usu�rio j� possui empr�stimo de um exemplar do livro informado. Usuario: "+usuario.getNome()+" Livro: "+livro.getTitulo());
		} else {
			return false;
		}
	}

}
