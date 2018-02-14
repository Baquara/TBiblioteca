
public class ComandoNotificacao  implements Comando
{
 public void executar(){
        String usuario = Sistema.get().getEntrada().next();
        Biblioteca.get().usarFacade().consultarProfessor(usuario);
    }
}
