
public class ComandoReservarLivro implements Comando
{
 public String executar(ParametrosCommand parametros){
	 String codigoUsuario = parametros.getAtributo1();
     String codigoLivro = parametros.getAtributo2();
     return Fachada.getInstancia().realizarReserva(codigoUsuario, codigoLivro);
    }
}
