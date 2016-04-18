/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.EspecialidadDao;
import java.util.List;
import javax.transaction.Transactional;
import modelo.Clase;
import modelo.Especialidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Isa
 */
@Service("EspecialidadService")
@Transactional
public class EspecialidadServiceImpl implements EspecialidadService {

    @Autowired
    private EspecialidadDao Clase;

    @Override
    public Especialidad findbyId(Long id) {
        return Clase.findbyId(id);
    }

    @Override
    public void save(Especialidad clase) {
        this.Clase.save(clase);
    }

    @Override
    public void DeletebyId(Long id) {
        this.Clase.DeletebyId(id);
    }

    @Override
    public List<Especialidad> findAll() {
        return Clase.findAll();
    }

    @Override
    public void UpdateEspecialidad(Especialidad clase) {
        Especialidad cla = this.Clase.findbyId(clase.getId());
        if (cla != null) {

            cla.setId(clase.getId());
            cla.setNombre(clase.getNombre());
            cla.setProfesor(clase.getProfesor());
            // cla.setNinos(clase.getNinos());
        }
    }
}
