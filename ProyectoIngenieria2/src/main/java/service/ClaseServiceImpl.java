/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ClaseDao;
import java.util.List;
import javax.transaction.Transactional;
import modelo.Clase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Isa
 */
@Service("ClaseService")
@Transactional
public class ClaseServiceImpl implements ClaseService{
      @Autowired
    private ClaseDao Clase;
    @Override
    public Clase findbyId(String id) {
        return Clase.findbyId(id);
    }

    @Override
    public void save(Clase clase) {
       this.Clase.save(clase);
    }

    @Override
    public void DeletebyId(String id) {
        this.Clase.DeletebyId(id);
    }

    @Override
    public List<Clase> findAll() {
       return Clase.findAll();
    }

    @Override
    public void UpdateClase(Clase clase) {
      Clase cla = this.Clase.findbyId(clase.getNombre());
      if(cla!=null){
          cla.setNombre(clase.getNombre());
          cla.setId(clase.getId());
          
      }
    }
}
