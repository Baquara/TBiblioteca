
public class ComandoReservarLivro implements Comando
{
 public String executar(){
        String usuario = Biblioteca.get().getEntrada().next();
        String livro = Biblioteca.get().getEntrada().next();
        
        return Biblioteca.get().usarFacade().realizarReserva(usuario, livro);
    }
}
