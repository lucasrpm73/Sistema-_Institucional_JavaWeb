/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.controller;

import edu.eventos.ifms.model.eventoModel;
import edu.eventos.ifms.repository.eventoRepository;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class eventoController {
    
    private eventoModel eventoModel;
    private eventoRepository eventoRepository;
    private List<eventoModel> listaDeEvento;
    

    public void setEventoModel(eventoModel eventoModel) {
        this.eventoModel = eventoModel;
    }

    public void setEventoRepository(eventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public List<eventoModel> getListaDeEvento() {
        return listaDeEvento;
    }
    public eventoController() {
        this.eventoModel = new eventoModel();
        this.eventoRepository = new eventoRepository();
        this.listaDeEvento = new ArrayList<>();
    }

    public void salvar(){
        this.eventoRepository.salvar(this.eventoModel);
    }
    
      public void buscarEvento() {
        this.eventoModel = this.eventoRepository.buscarPorId(this.eventoModel.getIdEvento());
    }
      
       public String editar(long idEvento) {
        return "editarEvento.xhtml?faces-redirect=true&idEvento=" + idEvento;
    }
      
    public String salvarEdicao() {
        this.eventoRepository.salvar(this.eventoModel);
        return "buscarEvento.xhtml?faces-redirect=true";
    }

     public void remover(long idEvento) {
        this.eventoRepository.remover(idEvento);
    }
     
      public void getEvento() {
        this.eventoModel = this.eventoRepository.buscarPorId(this.eventoModel.getIdEvento());
    }
    
    public List<SelectItem> getEventos() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<eventoModel> listaDeEventos = this.eventoRepository.buscar();
        for (eventoModel evento: listaDeEventos) {
            itens.add(new SelectItem(evento.getIdEvento(), evento.getEventoNome()));
        }
        return itens;
    }
    
    public void buscarTodosEventos() {
        this.listaDeEvento = this.eventoRepository.buscarTodos();
    }
 
    public eventoModel getEventoModel() {
        return eventoModel;
    }

    public void eventoModel(eventoModel eventoModel) {
        this.eventoModel = eventoModel;
    }

    public eventoRepository getEventoRepository() {
        return eventoRepository;
    }
}
