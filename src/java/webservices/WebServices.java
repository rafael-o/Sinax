/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.mypackage.objects.model.Cantor;
import org.mypackage.objects.model.Musica;

/**
 *
 * @author Zeller
 */
@WebService(serviceName = "WebServices")
public class WebServices {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Operação de Web service
     * @param musica
     * @param cantor
     * @param album
     * @param genero
     * @return 
     */
    @WebMethod(operationName = "AdicionarMusica")
    public String AdicionarMusica(@WebParam(name = "musica") String musica, 
                                  @WebParam(name = "cantor") String cantor, 
                                  @WebParam(name = "album") String album,
                                  @WebParam(name = "genero") String genero) {

        Musica objMusica = new Musica();
        Cantor objCantor = new Cantor();
        
        objCantor.setNome(cantor);
        objMusica.setNome(musica);
        objMusica.setGenero(genero);
        objMusica.setAlbum(album);
        objMusica.setCantor(objCantor);

       return Musica.saveMusica(objMusica)? "Música salva com sucesso.":"Não foi possivél salvar a música";
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "BuscarMusicas")
    public List BuscarMusicas() {
        List<Musica> musicas = Musica.listarMusicas();
        return musicas;
    }


}
