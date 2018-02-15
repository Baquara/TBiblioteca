
public class ComandoNotificacao  implements Comando
{
 public String executar(){
        String usuario = Sistema.get().getEntrada().next();
        return  Biblioteca.get().usarFacade().consultarProfessor(usuario);
    }
}
