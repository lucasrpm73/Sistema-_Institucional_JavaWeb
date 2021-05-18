/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.repository;

import edu.eventos.ifms.model.eventoModel;
import edu.eventos.ifms.util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class eventoRepository {
    private Session session;
    private Transaction transaction;

    public List<eventoModel> buscar(){
        this.session = NewHibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        List<eventoModel> listaDeEventos = this.session.createQuery("from eventoModel").list();
        
        this.transaction.commit();
        this.session.close();
        return listaDeEventos;
    }

    public void salvar(eventoModel evento) {
        this.session = NewHibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        this.session.saveOrUpdate(evento);
        
        this.transaction.commit();
        this.session.close();
    
    }
}
