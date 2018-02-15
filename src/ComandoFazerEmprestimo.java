public class ComandoFazerEmprestimo implements Comando
{
    public String executar(){
        String usuario = Sistema.get().getEntrada().next();
        String  livro = Sistema.get().getEntrada().next();
        
        
        
        return  Biblioteca.get().usarFacade().realizarEmprestimo(usuario, livro);
    }
}
