/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.MensajeDao;
import java.util.List;
import javax.transaction.Transactional;
import modelo.Contacto;
import modelo.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mensajeService")
@Transactional
public class MensajeServiceImpl implements MensajeService {
    
    @Autowired
    private MensajeDao contacto;
    
    @Override
    public Mensaje findbyCodigo(Long codigo) {
        return contacto.findbyCodigo(codigo);
    }
    
    @Override
    public void save(Mensaje contacto) {
        this.contacto.save(contacto);
    }
    
    @Override
    public void DeletebyCodigo(Long name) {
        this.contacto.DeletebyCodigo(name);
    }
    
    @Override
    public List<Mensaje> findAll() {
        return contacto.findAll();
    }
    
    @Override
    public void UpdateMensaje(Mensaje contacto) {
        Mensaje ki = this.contacto.findbyCodigo(contacto.getCodigo());
        if (ki != null) {
            ki.setCodigo(contacto.getCodigo());
            ki.setPersona(contacto.getPersona());
            ki.setMensaje(contacto.getMensaje());
            ki.setAsunto(contacto.getAsunto());
            ki.setContent(contacto.getContent());
            ki.setEstado(contacto.getEstado());
            ki.setKin(contacto.getKin());
            ki.setUsu(contacto.getUsu());
        }
    }
}
