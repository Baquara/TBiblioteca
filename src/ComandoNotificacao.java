
public class ComandoNotificacao  implements Comando
{
 public String executar(){
        String usuario = Biblioteca.get().getEntrada().next();
        return  Biblioteca.get().usarFacade().consultarProfessor(usuario);
    }
}
