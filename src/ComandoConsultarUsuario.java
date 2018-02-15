
/**
 * Escreva a descrição da classe consultarUsuario aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class ComandoConsultarUsuario implements Comando
{
 public String executar(){
        String usuario = Sistema.get().getEntrada().next();
        
        return Biblioteca.get().usarFacade().consultarUsuario(usuario);
    }
}
