/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.controller;

import edu.eventos.ifms.model.areaModel;
import edu.eventos.ifms.model.cursoModel;
import edu.eventos.ifms.repository.areaRepository;
import edu.eventos.ifms.repository.cursoRepository;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class cursoController {
    
    private cursoModel cursoModel;
    private  cursoRepository cursoRepository;
    private  areaRepository areaRepository;
    private List<cursoModel> listaDeCurso;
    
    public cursoController() {
        this.cursoModel = new cursoModel();
        this.areaRepository = new areaRepository();
        this.cursoRepository = new cursoRepository();
        this.listaDeCurso = new ArrayList<>();
    }

    public void salvar(){
        this.cursoRepository.salvar(this.cursoModel);
    }
    
    public String salvarEdicao() {
        this.cursoRepository.salvar(this.cursoModel);
        return "buscarCurso.xhtml?faces-redirect=true";
    }
    
    public void remover(long idCurso) {
        this.cursoRepository.remover(idCurso);
    }
    
    public String editar(long idCurso) {
        return "editarCurso.xhtml?faces-redirect=true&idCurso=" + idCurso;
    }
    
    public void buscarCurso() {
        this.cursoModel = this.cursoRepository.buscarPorId(this.cursoModel.getIdCurso());
    }

    public List<SelectItem> getAreas() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<areaModel> listaDeAreas;
        listaDeAreas = this.areaRepository.buscar();
        for (areaModel area : listaDeAreas) {
            itens.add(new SelectItem(area.getIdArea(), area.getAreaNome()));
        }
        return itens;
    }

    public List<SelectItem> getCursos() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<cursoModel> listaDeCursos = this.cursoRepository.buscarTodos();
        for (cursoModel curso : listaDeCursos) {
            itens.add(new SelectItem(curso.getIdCurso(), curso.getCursoNome()));
        }
        return itens;
    }
    
    public void buscarTodosCursos() {
        this.listaDeCurso = this.cursoRepository.buscarTodos();
    }
    
    public cursoModel getCursoModel() {
        return cursoModel;
    }

    public void setCursoModel(cursoModel cursoModel) {
        this.cursoModel = cursoModel;
    }

    public cursoRepository getCursoRepository() {
        return cursoRepository;
    }

    public void setCursoRepository(cursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public areaRepository getAreaRepository() {
        return areaRepository;
    }

    public void setAreaRepository(areaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public List<cursoModel> getListaDeCurso() {
        return listaDeCurso;
    }

    public void setListaDeCurso(List<cursoModel> listaDeCurso) {
        this.listaDeCurso = listaDeCurso;
    }

    
}
