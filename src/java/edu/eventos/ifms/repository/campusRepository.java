/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.repository;

import edu.eventos.ifms.model.campusModel;
import edu.eventos.ifms.util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class campusRepository {
    private Session session;
    private Transaction transaction;

    public void salvar(campusModel campus){
        this.session = NewHibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        this.session.saveOrUpdate(campus);
        
        this.transaction.commit();
        this.session.close();
    }
    
    public List<campusModel> buscarTodos(){
        this.session = NewHibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        List<campusModel> listaDeCampus = this.session.createQuery("from campusModel").list();
        
        this.transaction.commit();
        this.session.close();
        return listaDeCampus;
    }
               
    public void remover(long idCampus){
        this.session = NewHibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        campusModel campus = (campusModel) this.session.get(campusModel.class, idCampus);
        this.session.delete(campus);
        
        this.transaction.commit();
        this.session.close();
    }
    
    public campusModel buscarPorId(long idCampus){
        this.session = NewHibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        campusModel campus = (campusModel) this.session.get(campusModel.class, idCampus);
        Hibernate.initialize(campus.getServidores());
        
        this.transaction.commit();
        this.session.close();
        return campus;
    }
    
}
