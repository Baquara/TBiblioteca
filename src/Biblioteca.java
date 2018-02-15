import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Biblioteca {

	

	   private ArrayList<Livro> livros = new ArrayList();
	    private ArrayList<Usuario> usuarios = new ArrayList();
	

	private Fachada fachada = new Fachada();

	private Comando[] commando;

	private ParametrosCommand[] parametrosCommand;
	
	private static Biblioteca instancia = null;


	public static void main(String[] args) {
		Biblioteca.get().initCasosDeTeste();
		while (true) {
			Sistema.get().esperarComando();
		}
	}

	private Biblioteca() {
		this.usuarios = new ArrayList<Usuario>();
		this.livros = new ArrayList<Livro>();
	}

	public static Biblioteca get() {
		if (instancia == null) {
			instancia = new Biblioteca();
		}
		return instancia;
	}
	



	public Fachada usarFacade() {
		return this.fachada;
	}

	
	public void initCasosDeTeste(){
		Biblioteca.get().usarFacade().cadastrarFuncionario("123","João da Silva");
		Biblioteca.get().usarFacade().cadastrarAluno("456","Luiz Fernando Rodrigues");
		Biblioteca.get().usarFacade().cadastrarFuncionario("789","Pedro Paulo");
		Biblioteca.get().usarFacade().cadastrarProfessor("100","Carlos Lucena");
		Biblioteca.get().usarFacade().cadastrarLivro("100", "Engenharia de Software",	"AddisonWesley",	"Ian Sommervile",	"6ª",	"2000");					
		Biblioteca.get().usarFacade().cadastrarLivro("101",	"UML – Guia do Usuário", "Campus",	"Grady Booch,James Rumbaugh, Ivar Jacobson", "7ª", "2000");			
		Biblioteca.get().usarFacade().cadastrarLivro("200",	"Code Complete", "Microsoft Press",	"Steve McConnell",	"2ª",	"2014");
		Biblioteca.get().usarFacade().cadastrarLivro("201", "Agile Software Development, Principles, Patterns and Practices",	"Prentice Hall",	"Robert Martin",	"1ª", "2002");
		Biblioteca.get().usarFacade().cadastrarLivro("300",	"Refactoring:Improving the Design  of Existing Code","Addison-Wesley Professional",	"Martin Fowler","1ª","1999");
		Biblioteca.get().usarFacade().cadastrarLivro("301", "Software Metrics: A Rigorous and Practical Approach",	"CRC Press",	"Norman Fenton, James Bieman",	"3ª",	"2014");
		Biblioteca.get().usarFacade().cadastrarLivro("400","Design Patterns:Elements of Reusable Object-Oriented Software",	"Addison-Wesley Professional",	"Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides",	"1ª",	"1994");
		Biblioteca.get().usarFacade().cadastrarLivro("401",	"UML Distilled: A	Brief Guide to the Standard Object Modeling Language", "Addison-Wesley Professional",	"Martin Fowler","3ª","2003");
for(int i=0;i<Biblioteca.get().usarFacade().RetornaLivros().size();i++) {		
		Biblioteca.get().usarFacade().cadastrarExemplar("01", Biblioteca.get().usarFacade().RetornaLivros().get(i));	
		Biblioteca.get().usarFacade().cadastrarExemplar("02", Biblioteca.get().usarFacade().RetornaLivros().get(i));	
		Biblioteca.get().usarFacade().cadastrarExemplar("03", Biblioteca.get().usarFacade().RetornaLivros().get(i));	
		Biblioteca.get().usarFacade().cadastrarExemplar("04", Biblioteca.get().usarFacade().RetornaLivros().get(i));	
		Biblioteca.get().usarFacade().cadastrarExemplar("05", Biblioteca.get().usarFacade().RetornaLivros().get(i));	
		Biblioteca.get().usarFacade().cadastrarExemplar("06", Biblioteca.get().usarFacade().RetornaLivros().get(i));	
		Biblioteca.get().usarFacade().cadastrarExemplar("07", Biblioteca.get().usarFacade().RetornaLivros().get(i));	
		Biblioteca.get().usarFacade().cadastrarExemplar("08", Biblioteca.get().usarFacade().RetornaLivros().get(i));	
		Biblioteca.get().usarFacade().cadastrarExemplar("09", Biblioteca.get().usarFacade().RetornaLivros().get(i));	
}
		
		
		
	}

	


}
