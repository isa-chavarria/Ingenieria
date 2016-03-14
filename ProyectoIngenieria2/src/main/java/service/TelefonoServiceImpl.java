/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.TelefonoDao;
import java.util.List;
import javax.transaction.Transactional;
import modelo.Telefono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("TelefonoService")
@Transactional
public class TelefonoServiceImpl implements TelefonoService {

    @Autowired
    private TelefonoDao planilla;

    @Override
    public Telefono findbyId(String id) {
        return planilla.findbyId(id);
    }
    
    @Override
    public void save(Telefono planilla) {
        this.planilla.save(planilla);
    }
    
    @Override
    public void DeletebyId(String id) {
        this.planilla.DeletebyId(id);
    }
    
    @Override
    public List<Telefono> findAll() {
        return planilla.findAll();
    }
    
    @Override
    public void UpdateTelefono(Telefono planilla) {
        Telefono ki = this.planilla.findbyId(planilla.getNumero());
        if (ki != null) {
            ki.setNumero(planilla.getNumero());
            ki.setFamiliar(planilla.getFamiliar());
        }
    }
}
