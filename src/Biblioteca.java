import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Biblioteca {

	private Fachada fachada = new Fachada();
	private Comando[] commando;
	private ParametrosCommand[] parametrosCommand;
	private static Biblioteca instancia = null;   
    private HashMap<String, Comando> comandos;
    private Scanner entrada;



	public static void main(String[] args) {
		/** O construtor deve preencher o HashMap com os comandos correpondentes **/	     
		Biblioteca.get().initCasosDeTeste();
		while (true) {
			Biblioteca.get().esperarComando();
		}
	}

	private Biblioteca() {
		   entrada = new Scanner(System.in);
	        comandos = new HashMap<String, Comando>();
	        
//	        /** Inicializa comandos: sai, emp, dev, res, obs, liv, usu, ntf**/
	        comandos.put("sai", new ComandoSair());
	        comandos.put("emp", new ComandoFazerEmprestimo());
	        comandos.put("dev", new ComandoDevolverLivro());
        comandos.put("res", new ComandoReservarLivro());
        comandos.put("obs", new ComandoObservar());
        comandos.put("liv", new ComandoConsultarLivro());
        comandos.put("usu", new ComandoConsultarUsuario());
        comandos.put("ntf", new ComandoNotificacao());
	}
	


public static Biblioteca get(){
  if(instancia == null){
      instancia = new Biblioteca();
  }
  return instancia;
}

public Scanner getEntrada(){
  return this.entrada;
}

public void exibir(String mensagem) {
	System.out.println(mensagem);
}
  
public void esperarComando(){
  System.out.println("Digite o comando:");
  
  String comando = entrada.next();
  System.out.println(comandos.get(comando).executar());
 
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
