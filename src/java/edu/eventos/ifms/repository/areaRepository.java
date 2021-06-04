/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.repository;

import edu.eventos.ifms.model.areaModel;
import edu.eventos.ifms.util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class areaRepository {
    private Session session;
    private Transaction transaction;

    public List<areaModel> buscar(){
        this.session = NewHibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        List<areaModel> listaDeAreas = this.session.createQuery("from areaModel").list();
        
        this.transaction.commit();
        this.session.close();
        return listaDeAreas;
    }

    public void salvar(areaModel area) {
         this.session = NewHibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        this.session.saveOrUpdate(area);
        
        this.transaction.commit();
        this.session.close();
    }

    public void remover(long idArea) {
        this.session = NewHibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        areaModel area = (areaModel) this.session.get(areaModel.class, idArea);
        this.session.delete(area);
        
        this.transaction.commit();
        this.session.close();
    }
    
    
     public List<areaModel> buscarTodos(){
        this.session = NewHibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        List<areaModel> listaDeArea = this.session.createQuery("from areaModel").list();
        
        this.transaction.commit();
        this.session.close();
        return listaDeArea;
    }
    

    public areaModel buscarPorId(long idArea) {
          this.session = NewHibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        areaModel campus = (areaModel) this.session.get(areaModel.class, idArea);
        Hibernate.initialize(campus.getIdArea());
        
        this.transaction.commit();
        this.session.close();
        return campus;
    }
}
