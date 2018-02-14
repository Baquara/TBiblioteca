
public class ComandoConsultarLivro  implements Comando
{
 public void executar(){
        String livro = Sistema.get().getEntrada().next();
        
        Biblioteca.get().usarFacade().consultarLivro(livro);
    }
}
