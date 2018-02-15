
public class ComandoConsultarLivro  implements Comando
{
 public String executar(){
        String livro = Sistema.get().getEntrada().next();
        
        return Biblioteca.get().usarFacade().consultarLivro(livro);
    }
}
