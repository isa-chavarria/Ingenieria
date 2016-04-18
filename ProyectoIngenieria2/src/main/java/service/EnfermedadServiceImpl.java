/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.EnfermedadDao;
import dao.MatriculaDao;
import java.util.List;
import javax.transaction.Transactional;
import modelo.Enfermedad;
import modelo.Matricula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("enfermedadService")
@Transactional
public class EnfermedadServiceImpl implements EnfermedadService {

    @Autowired
    private EnfermedadDao matricula;

    @Override
    public Enfermedad findbyCodigo(Long name) {
        return matricula.findbyCodigo(name);
    }

    @Override
    public void save(Enfermedad matricula) {
        this.matricula.save(matricula);
    }

    @Override
    public void DeletebyCodigo(Long name) {
        this.matricula.DeletebyCodigo(name);
    }

    @Override
    public List<Enfermedad> findAll() {
        return matricula.findAll();
    }

    @Override
    public void UpdateEnfermedad(Enfermedad matri) {
        Enfermedad ki = this.matricula.findbyCodigo(matri.getCodigo());
        if (ki != null) {
            ki.setCodigo(matri.getCodigo());
            ki.setNombre(matri.getNombre());
            ki.setDescripcion(matri.getDescripcion());
            ki.setNino(matri.getNino());
        }
    }
}
