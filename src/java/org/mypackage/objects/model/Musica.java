/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.objects.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * @author rafael
 * 
 * Classe/entidade com os atributos para cadastro das musicas e 
 * listagem das mesmas
 */

@Entity
@Table(name="musica")
public class Musica implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "nome")
    private String nome;
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name="cantor")
    private Cantor cantor;
    @Column(name = "album")
    private String album;
    @Column(name = "genero")
    private String genero;
    
    public Musica() {
        id = 0;
        nome = null;
        cantor = null;
        album = null;
        genero = null;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cantor
     */
    public Cantor getCantor() {
        return cantor;
    }

    /**
     * @param cantor the cantor to set
     */
    public void setCantor(Cantor cantor) {
        this.cantor = cantor;
    }

    /**
     * @return the album
     */
    public String getAlbum() {
        return album;
    }

    /**
     * @param album the album to set
     */
    public void setAlbum(String album) {
        this.album = album;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public static boolean saveMusica(Musica musica) {
        Configuration conf = new AnnotationConfiguration();
        conf.configure();

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();

        Transaction trans = session.beginTransaction();
        
        Musica nMusica = (Musica)session.merge(musica);
        
        trans.commit();
        
        session.close();
        
        return nMusica.getId() != 0;
    }
}
