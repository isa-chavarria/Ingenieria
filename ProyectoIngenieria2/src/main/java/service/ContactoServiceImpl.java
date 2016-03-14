/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ContactoDao;
import java.util.List;
import javax.transaction.Transactional;
import modelo.Contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("contactoService")
@Transactional
public class ContactoServiceImpl implements ContactoService{
    
    @Autowired
    private ContactoDao contacto;

    @Override
    public Contacto findbyCodigo(Long codigo) {
        return contacto.findbyCodigo(codigo);
    }

    @Override
    public void save(Contacto contacto) {
        this.contacto.save(contacto);
    }

    @Override
    public void DeletebyCodigo(Long name) {
        this.contacto.DeletebyCodigo(name);
    }

    @Override
    public List<Contacto> findAll() {
        return contacto.findAll();
    }

    @Override
    public void UpdateContacto(Contacto contacto) {
        Contacto ki = this.contacto.findbyCodigo(contacto.getCodigo());
        if (ki != null) {
            ki.setDescripcion(contacto.getDescripcion());
            ki.setTitulo(contacto.getTitulo());
            ki.setKinder(contacto.getKinder());
        }
    }
}
