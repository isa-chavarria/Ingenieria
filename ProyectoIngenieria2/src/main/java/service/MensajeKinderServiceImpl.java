/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.MensajeKinderDao;
import java.util.List;
import javax.transaction.Transactional;
import modelo.MensajeKinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mensajeKinderService")
@Transactional
public class MensajeKinderServiceImpl implements MensajeKinderService {
    
    @Autowired
    private MensajeKinderDao contacto;
    
    @Override
    public MensajeKinder findbyCodigo(Long codigo) {
        return contacto.findbyCodigo(codigo);
    }
    
    @Override
    public void save(MensajeKinder contacto) {
        this.contacto.save(contacto);
    }
    
    @Override
    public void DeletebyCodigo(Long name) {
        this.contacto.DeletebyCodigo(name);
    }
    
    @Override
    public List<MensajeKinder> findAll() {
        return contacto.findAll();
    }
    
    @Override
    public void UpdateMensajeKinder(MensajeKinder contacto) {
        MensajeKinder ki = this.contacto.findbyCodigo(contacto.getCodigo());
        if (ki != null) {
            ki.setCodigo(contacto.getCodigo());
            ki.setPersona(contacto.getPersona());
            ki.setMensaje(contacto.getMensaje());
            ki.setAsunto(contacto.getAsunto());
            ki.setContent(contacto.getContent());
            ki.setEstado(contacto.getEstado());
            ki.setKin(contacto.getKin());
            ki.setUsu(contacto.getUsu());
            ki.setType(contacto.getType());
            ki.setName(contacto.getName());
        }
    }
}
