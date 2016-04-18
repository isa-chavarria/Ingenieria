/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ProfesorDao;
import java.util.List;
import javax.transaction.Transactional;
import modelo.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Isa
 */
@Service("ProfesorService")
@Transactional
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    private ProfesorDao Profesor;

    @Override
    public Profesor findbyId(String id) {
        return Profesor.findbyId(id);
    }

    @Override
    public void save(Profesor profesor) {
        this.Profesor.save(profesor);
    }

    @Override
    public void DeletebyId(String id) {
        this.Profesor.DeletebyId(id);
    }

    @Override
    public List<Profesor> findAll() {
        return Profesor.findAll();
    }

    @Override
    public boolean isIdUnique(String id) {
        return Profesor.isIdUnique(id);
    }

    @Override
    public void UpdateProfesor(Profesor profesor) {
        Profesor profe = this.Profesor.findbyId(profesor.getId());
        if (profe != null) {
            profe.setNombre(profesor.getNombre());
            profe.setId(profesor.getId());
            profe.setEmail(profesor.getEmail());
            profe.setRol(profesor.getRol());
            profe.setTelefono(profesor.getTelefono());
            profe.setSalario(profesor.getSalario());
           // profe.setGrupo(profesor.getGrupo());

        }
    }
}
