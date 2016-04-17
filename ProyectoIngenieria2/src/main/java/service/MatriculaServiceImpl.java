/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.MatriculaDao;
import java.util.List;
import javax.transaction.Transactional;
import modelo.Matricula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("matriculaService")
@Transactional
public class MatriculaServiceImpl implements MatriculaService {
    
    @Autowired
    private MatriculaDao matricula;
    
    @Override
    public Matricula findbyCodigo(Long name) {
        return matricula.findbyCodigo(name);
    }
    
    @Override
    public void save(Matricula matricula) {
        this.matricula.save(matricula);
    }
    
    @Override
    public void DeletebyCodigo(Long name) {
        this.matricula.DeletebyCodigo(name);
    }
    
    @Override
    public List<Matricula> findAll() {
        return matricula.findAll();
    }
    
    @Override
    public void UpdateMatricula(Matricula matri) {
        Matricula ki = this.matricula.findbyCodigo(matri.getCodigo());
        if (ki != null) {
           ki.setCodigo(matri.getCodigo());
           ki.setCompeta(matri.getCompeta());
           ki.setCarnet(matri.getCarnet());
           ki.setConstanciaNacimiento(matri.getConstanciaNacimiento());
           ki.setFotos(matri.getFotos());
           ki.setMatricula(matri.getMatricula());
           ki.setCursolectivo(matri.getCursolectivo());
           ki.setRealizadoPor(matri.getRealizadoPor());
           ki.setNino(matri.getNino());
        }
    }
}
