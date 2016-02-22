/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.transaction.Transactional;
import modelo.Kinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.KinderDao;

/**
 *
 * @author Isa
 */

@Service("kinderService")
@Transactional
public class kinderServiceImpl implements kinderService{

    @Autowired
    private KinderDao kinder;
    @Override
    public Kinder findbyName(String name) {
        return kinder.findbyName(name);
    }

    @Override
    public void save(Kinder kinder) {
       this.kinder.save(kinder);
    }

    @Override
    public void DeletebyName(String name) {
        this.kinder.DeletebyName(name);
    }

    @Override
    public List<Kinder> findAll() {
       return kinder.findAll();
    }

    @Override
    public void UpdateKinder(Kinder kinder) {
      Kinder ki = this.kinder.findbyName(kinder.getNombre());
      if(ki!=null){
          ki.setVision(kinder.getVision());
          ki.setDireccion(kinder.getDireccion());
          ki.setMision(kinder.getMision());
          ki.setHistoria(kinder.getHistoria());
          ki.setTelefono(kinder.getTelefono());
          ki.setContactos(kinder.getContactos());
          ki.setAlbums(kinder.getAlbums());
          ki.setFacturas(kinder.getFacturas());
      }
    }
    
}
