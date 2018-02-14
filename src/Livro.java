import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Livro implements Subject {
	
	
    private ArrayList<Exemplar> exemplares = new ArrayList();
    private ArrayList<Reserva> reservas = new ArrayList();
    private ArrayList<Observer> observers = new ArrayList();

	private String codigo;

	private String titulo;

	private String editora;

	private String autores;

	private String edicao;

	private String anoDePublicacao;

	public Livro(String codigo, String titulo, String editora, String autores, String edicao, String anoDePublicacao) {

		this.codigo=codigo;
		this.titulo=titulo;
		this.editora=editora;
		this.autores=autores;
		this.edicao=edicao;
		this.anoDePublicacao=anoDePublicacao;
		
	}

	public void registerObserver(Observer observer) {

	}

	public void removeObserver(Observer observer) {

	}

	public void notifyObservers() {

	}

	public void cadastrarExemplar(String codigo) {
		Exemplar exemplar = new Exemplar(codigo);
		this.exemplares.add(exemplar);
	}

	public String getTitulo() {
		return this.getTitulo();
	}

	public String getCodigo() {
		return this.codigo;
	}
	
	public Reserva getReservas(String codigo) {
	for(int i=0;i<this.reservas.size();i++) {
			
			if(this.reservas.get(i).getLivro().getCodigo()==codigo) {
				return this.reservas.get(i);
			}
			
		}
	return null;
	}

	public void cadastrarReserva(Reserva reserva) {
		
		
		this.reservas.add(reserva);
		
		
		if(this.reservas.size()>=2) {
			notifyObservers();
			
		}
			

	}

	public void excluirReserva(Reserva reserva) {
		
		this.reservas.remove(reserva);

	}
	
	
	public boolean getDisponibilidadeDoLivro() {
for(int i=0;i<this.exemplares.size();i++) {
				if(this.exemplares.get(i).getDisponibilidade()==true)
				return true;
			}
	return false;
		
	}
	
	
	public String getCodigodoExemplarDisponivel() {
for(int i=0;i<this.exemplares.size();i++) {
				if(this.exemplares.get(i).getDisponibilidade()==true)
				return this.exemplares.get(i).getCodigo();
			}
	return null;
		
	}
	
	
	public int quantidadeDeReservas() {
	return this.reservas.size();
				
			}
	
	

	public String NomeDosUsuariosQueFizeramAsReservas() {
		
	for(int i=0;i<this.reservas.size();i++) {
			
				return this.reservas.get(i).getUsuario().getNome();
				
			}
	return null;
	}
	
	public String caracteristicasdosexemplares() {
		String caracteristicas="";
		
		for(int i=0;i<this.exemplares.size();i++) {
			if(this.exemplares.get(i).getDisponibilidade()==true) {
		 caracteristicas+= this.exemplares.get(i).getCodigo() + "Disponível";
			}
			else {
				caracteristicas+= this.exemplares.get(i).getCodigo() + "Emprestado";
				caracteristicas+= this.exemplares.get(i).getEmprestimo().getUsuario().getNome();
				caracteristicas+= this.exemplares.get(i).getEmprestimo().getDataDeEmprestimo();
				caracteristicas+= this.exemplares.get(i).getEmprestimo().getDataDeDevolucao();
			}
					
		}
		
	return caracteristicas;	
	}
	
	
	

}
