
public class ComandoReservarLivro implements Comando
{
 public void executar(){
        String usuario = Sistema.get().getEntrada().next();
        String livro = Sistema.get().getEntrada().next();
        
        Biblioteca.get().usarFacade().realizarReserva(usuario, livro);
    }
}
