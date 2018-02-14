import java.util.HashMap;
import java.util.Scanner;

//Invoker

public class Sistema
{
    private static Sistema instancia = null;
    
    private HashMap<String, Comando> comandos;
    private Scanner entrada;
    
    /** O construtor deve preencher o HashMap com os comandos correpondentes **/
    private Sistema(){
        entrada = new Scanner(System.in);
        comandos = new HashMap<String, Comando>();
        
        /** Inicializa comandos: sai, emp, dev, res, obs, liv, usu, ntf**/
        comandos.put("sai", new ComandoSair());
        comandos.put("emp", new ComandoFazerEmprestimo());
        comandos.put("dev", new ComandoDevolverLivro());
        comandos.put("res", new ComandoReservarLivro());
        comandos.put("obs", new ComandoObservar());
        comandos.put("liv", new ComandoConsultarLivro());
        comandos.put("usu", new ComandoConsultarUsuario());
        comandos.put("ntf", new ComandoNotificacao());
        
        
        /** ... **/
    } 
    
    public static Sistema get(){
        if(instancia == null){
            instancia = new Sistema();
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
        comandos.get(comando).executar();
       
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
