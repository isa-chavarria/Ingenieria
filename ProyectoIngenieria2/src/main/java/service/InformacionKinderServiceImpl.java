/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ContactoDao;
import dao.InformacionKinderDao;
import java.util.List;
import javax.transaction.Transactional;
import modelo.Contacto;
import modelo.InformacionKinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("InformacionKinderService")
@Transactional
public class InformacionKinderServiceImpl implements InformacionKinderService {
    
    @Autowired
    private InformacionKinderDao contacto;
    
    @Override
    public InformacionKinder findbyCodigo(Long codigo) {
        return contacto.findbyCodigo(codigo);
    }
    
    @Override
    public void save(InformacionKinder contacto) {
        this.contacto.save(contacto);
    }
    
    @Override
    public void DeletebyCodigo(Long name) {
        this.contacto.DeletebyCodigo(name);
    }
    
    @Override
    public List<InformacionKinder> findAll() {
        return contacto.findAll();
    }
    
    @Override
    public void UpdateInformacionkinder(InformacionKinder contacto) {
        InformacionKinder ki = this.contacto.findbyCodigo(contacto.getCodigo());
        if (ki != null) {
            ki.setCodigo(contacto.getCodigo());
            ki.setFecha(contacto.getFecha());
            ki.setMonto(contacto.getMonto());
            ki.setMontoMatricula(contacto.getMontoMatricula());
            ki.setKinder(contacto.getKinder());
        }
    }
}
