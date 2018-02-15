public class ComandoDevolverLivro implements Comando
{
    public String executar(){
        String usuario = Biblioteca.get().getEntrada().next();
        String livro = Biblioteca.get().getEntrada().next();
        
        return  Biblioteca.get().usarFacade().realizarDevolucao(usuario, livro);
    }
}
