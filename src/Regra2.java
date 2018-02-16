public class Regra2 implements RegraEmprestimo {
	/*if (!livro.estaDisponivel()) {
	throw new livroIndisponivelException();
} else {
	if (usuario.estaDevedor()) {
		throw new usuarioDevedorException();
	}else {
		if (usuario.getEmprestimosCorrentes().size()==usuario.getLimiteDeEmprestimos()) {
			throw new limiteDeEmprestimosException();
		}else {
			if ((livro.getReservas().size()>=livro.getExemplaresDisponiveis()) && (!usuario.possuiReserva(livro))) {
					throw new livroReservadoException();
				} else {
					if (usuario.possuiEmprestimo(livro)) {
						throw new conflitoDeEmprestimoException();
					} else {
						return true;
					}
			}
		}
	}
}
}*/
	public boolean podeEmprestar(Usuario usuario, Livro livro) {
		return ((livroEstaDisponivel(livro))&&(!usuarioEstaDevedor(usuario))&&(!usuarioTemLimiteDeEmprestimos(usuario))&&(!livroEstaReservado(livro))&&(!usuarioPossuiEmprestimo(usuario,livro)));
	}
		
	
	private boolean livroEstaDisponivel(Usuario usuario, Livro livro) {
		if (!livro.estaDisponivel()) {
			throw new LivroIndisponivelException("O empr�stimo n�o p�de ser realizado. O livro informado n�o possui exemplar dispon�vel. Usuario: "+usuario.getNome()+" Livro: "+livro.getTitulo());
		} else {
			return true;
		}
	} 
	
	private boolean usuarioEstaDevedor(Usuario usuario, Livro livro) {
		if (usuario.estaDevedor()) {
			throw new UsuarioDevedorException("O empr�stimo n�o p�de ser realizado. O usu�rio informado possui empr�stimo com atraso. Usuario: "+usuario.getNome()+" Livro: "+livro.getTitulo());
		}else {
			return false;
		}
	}
	
	private boolean usuarioTemLimiteDeEmprestimos(Usuario usuario, Livro livro) {
		if (usuario.getEmprestimosCorrentes().size()==usuario.getLimiteDeEmprestimos()) {
			throw new LimiteDeEmprestimosException("O empr�stimo n�o p�de ser realizado. O usu�rio informado j� possui a quantidade limite de empr�stimos. Usuario: "+usuario.getNome()+" Livro: "+livro.getTitulo());
		}else {
			return false;
		}
	}
	
	private boolean livroEstaReservado(Usuario usuario,Livro livro) { 
		if ((livro.getReservas().size()>=livro.getExemplaresDisponiveis()) && (!usuario.possuiReserva(livro))) {
			throw new LivroReservadoException("O empr�stimo n�o p�de ser realizado. Todos os exemplares do livro informado est�o reservados. Usuario: "+usuario.getNome()+" Livro: "+livro.getTitulo());
		} else {
			return false;
		}
	}
	
	private boolean usuarioPossuiEmprestimo(Usuario usuario, Livro livro) {
		if (usuario.possuiEmprestimo(livro)) {
			throw new ConflitoDeEmprestimoException("O empr�stimo n�o p�de ser realizado. O usu�rio j� possui empr�stimo de um exemplar do livro informado. Usuario: "+usuario.getNome()+" Livro: "+livro.getTitulo());
		} else {
			return false;
		}
	}
	

}
