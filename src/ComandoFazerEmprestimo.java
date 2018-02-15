public class ComandoFazerEmprestimo implements Comando
{
    public String executar(){
        String usuario = Biblioteca.get().getEntrada().next();
        String  livro = Biblioteca.get().getEntrada().next();
        
        
        
        return  Biblioteca.get().usarFacade().realizarEmprestimo(usuario, livro);
    }
}
