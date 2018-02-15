
public class ComandoObservar  implements Comando
{
  public String executar(){
        String usuario = Biblioteca.get().getEntrada().next();
        String livro = Biblioteca.get().getEntrada().next();
        
        Biblioteca.get().usarFacade().cadastrarObservador2(usuario, livro);
        
        return null;
    }
}
