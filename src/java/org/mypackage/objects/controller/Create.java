package org.mypackage.objects.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * @author rafael
 * 
 * classe para ler o arquivo xml do hibernate e imprimir
 * o script de criação do BD
 */
public class Create {
    public static void main(String[] args) {
        Configuration conf = new AnnotationConfiguration();
        conf.configure(); 
        SchemaExport se = new SchemaExport(conf);
        se.create(true, true);
    }
}
