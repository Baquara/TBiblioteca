
public class ComandoConsultarLivro  implements Comando
{
 public String executar(){
        String livro = Biblioteca.get().getEntrada().next();
        
        return Biblioteca.get().usarFacade().consultarLivro(livro);
    }
}
