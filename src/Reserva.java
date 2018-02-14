public class Reserva {

	private Usuario usuario;

	private Livro livro;

	private String dataDeRealizacao;
	
	public void Reserva(Usuario usuario, Livro livro) {
		
		this.usuario=usuario;
		this.livro=livro;

	}

	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public Livro getLivro() {
		return this.livro;
	}
	
	
	public String GetNome() {
		
		return this.livro.getTitulo();
		
		
		
	}

}
