/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.controller;

import edu.eventos.ifms.model.areaModel;
import edu.eventos.ifms.model.eventoModel;
import edu.eventos.ifms.repository.areaRepository;
import edu.eventos.ifms.repository.eventoRepository;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class eventoController {

    public void setEventoModel(eventoModel eventoModel) {
        this.eventoModel = eventoModel;
    }

    public void setEventoRepository(eventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public ArrayList<Object> getListaDeEvento() {
        return listaDeEvento;
    }

    private eventoModel eventoModel;
    private eventoRepository eventoRepository;
    private final ArrayList<Object> listaDeEvento;
    
    public eventoController() {
        this.eventoModel = new eventoModel();
        this.eventoRepository = new eventoRepository();
        this.listaDeEvento = new ArrayList<>();
    }

    public void salvar(){
        this.eventoRepository.salvar(this.eventoModel);
    }
    
    public String salvarEdicao() {
        this.eventoRepository.salvar(this.eventoModel);
        return "buscarEvento.xhtml?faces-redirect=true";
    }

    public List<SelectItem> getEventos() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<eventoModel> listaDeEventos = this.eventoRepository.buscar();
        for (eventoModel evento: listaDeEventos) {
            itens.add(new SelectItem(evento.getIdEvento(), evento.getEventoNome()));
        }
        return itens;
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

    public void setAreaRepository(eventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

}
