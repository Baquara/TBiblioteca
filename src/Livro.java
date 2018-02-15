import java.util.*;

public class Livro implements Subject {
		
    private ArrayList<Exemplar> exemplares = new ArrayList<Exemplar>();
    private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    private ArrayList<Observer> observers = new ArrayList<Observer>();
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
		this.observers.add(observer);
	}

	public void removeObserver(Observer observer) {
		int i = this.observers.indexOf(observer);
		if (i >= 0) {
			this.observers.remove(i);
		}
	}

	public void notifyObservers() {
		for (int i = 0; i < this.observers.size(); i++) {
			Observer observer = this.observers.get(i);
			observer.update();
		}
	}

	public void cadastrarExemplar(String codigo) {
		Exemplar novoExemplar= new Exemplar(codigo,this);
		this.exemplares.add(novoExemplar);
	}

	public String getTitulo() {
		return this.titulo;
	}

	public String getCodigo() {
		return this.codigo;
	}
		
	public ArrayList<Reserva> getReservas(String codigo) {
		return this.reservas;
	}
	
	
	public ArrayList<Exemplar> getExemplares() {
		return this.exemplares;
	}

	public void cadastrarReserva(Reserva reserva) {
		this.reservas.add(reserva);
		if(this.reservas.size()>=2) {
			this.notifyObservers();
			}	
	}

	public void excluirReserva(Reserva reserva) {
		this.reservas.remove(reserva);
	}
	


}