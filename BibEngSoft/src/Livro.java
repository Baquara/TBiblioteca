import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Livro implements Subject {
	
	
    private ArrayList<String> exemplares = new ArrayList();
    private ArrayList<Reserva> reservas = new ArrayList();
    private ArrayList<String> observers = new ArrayList();

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
		this.exemplares.add(codigo);
	}

	public String getTitulo() {
		return null;
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

}
