
public class ComandoReservarLivro implements Comando
{
 public String executar(){
        String usuario = Sistema.get().getEntrada().next();
        String livro = Sistema.get().getEntrada().next();
        
        return Biblioteca.get().usarFacade().realizarReserva(usuario, livro);
    }
}
