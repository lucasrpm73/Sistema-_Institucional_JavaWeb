/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.repository;

import edu.eventos.ifms.model.cidadeModel;
import edu.eventos.ifms.util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class cidadeRepository {
    private Session session;
    private Transaction transaction;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public List<cidadeModel> buscar(long IdEstado){
        this.session = NewHibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        List<cidadeModel> listaDeCidades = this.session.createQuery("from cidadeModel where IdEstado = "+IdEstado).list();
        
        this.transaction.commit();
        this.session.close();
        return listaDeCidades;
    }
}
