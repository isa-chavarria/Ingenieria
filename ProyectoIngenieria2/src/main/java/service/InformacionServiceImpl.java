/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.EnfermedadDao;
import dao.InformacionDao;
import dao.MatriculaDao;
import java.util.List;
import javax.transaction.Transactional;
import modelo.Enfermedad;
import modelo.Informacion;
import modelo.Matricula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("InformacionService")
@Transactional
public class InformacionServiceImpl implements InformacionService {

    @Autowired
    private InformacionDao matricula;

    @Override
    public Informacion findbyCodigo(Long name) {
        return matricula.findbyCodigo(name);
    }

    @Override
    public void save(Informacion matricula) {
        this.matricula.save(matricula);
    }

    @Override
    public void DeletebyCodigo(Long name) {
        this.matricula.DeletebyCodigo(name);
    }

    @Override
    public List<Informacion> findAll() {
        return matricula.findAll();
    }

    @Override
    public void UpdateInformacion(Informacion matri) {
        Informacion ki = this.matricula.findbyCodigo(matri.getCodigo());
        if (ki != null) {
          ki.setCodigo(matri.getCodigo());
          ki.setTitulo(matri.getTitulo());
          ki.setDescripcion(matri.getDescripcion());
          ki.setNino(matri.getNino());
        }
    }
}
