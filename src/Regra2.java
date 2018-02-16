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
		
	
	private boolean livroEstaDisponivel(Livro livro) {
		if (!livro.estaDisponivel()) {
			throw new LivroIndisponivelException();
		} else {
			return true;
		}
	}
	
	private boolean usuarioEstaDevedor(Usuario usuario) {
		if (usuario.estaDevedor()) {
			throw new UsuarioDevedorException();
		}else {
			return false;
		}
	}
	
	private boolean usuarioTemLimiteDeEmprestimos(Usuario usuario) {
		if (usuario.getEmprestimosCorrentes().size()==usuario.getLimiteDeEmprestimos()) {
			throw new LimiteDeEmprestimosException();
		}else {
			return false;
		}
	}
	
	private boolean livroEstaReservado(Livro livro) { 
		if ((livro.getReservas().size()>=livro.getExemplaresDisponiveis()) && (!usuario.possuiReserva(livro))) {
			throw new LivroReservadoException();
		} else {
			return false;
		}
	}
	
	private boolean usuarioPossuiEmprestimo(Usuario usuario, Livro livro) {
		if (usuario.possuiEmprestimo(livro)) {
			throw new ConflitoDeEmprestimoException();
		} else {
			return false;
		}
	}
	

}
