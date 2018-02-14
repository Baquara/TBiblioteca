public class ComandoDevolverLivro implements Comando
{
    public void executar(){
        String usuario = Sistema.get().getEntrada().next();
        String livro = Sistema.get().getEntrada().next();
        
        Biblioteca.get().usarFacade().realizarDevolucao(usuario, livro);
    }
}
