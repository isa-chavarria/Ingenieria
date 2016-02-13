/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ProfesorDao;
import java.util.List;
import javax.transaction.Transactional;
import modelo.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Isa
 */
@Service("ProfesorService")
@Transactional
public class ProfesorServiceImpl implements ProfesorService {
     @Autowired
    private ProfesorDao Profesor;
    @Override
    public Profesor findbyId(String id) {
        return Profesor.findbyId(id);
    }

    @Override
    public void save(Profesor Profesor) {
       this.Profesor.save(Profesor);
    }

    @Override
    public void DeletebyId(String id) {
        this.Profesor.DeletebyId(id);
    }

    @Override
    public List<Profesor> findAll() {
       return Profesor.findAll();
    }

    @Override
    public void UpdateEncargado(Profesor Encargado) {
      Profesor Profesor = this.Profesor.findbyId(Encargado.getNombre());
      if(Profesor!=null){
          Profesor.setNombre(Profesor.getNombre());
          Profesor.setApellido1(Profesor.getApellido1());
          Profesor.setApellido2(Profesor.getApellido2());
          Profesor.setId(Profesor.getId());
          Profesor.setEmail(Profesor.getEmail());
          Profesor.setFechanacimiento(Profesor.getFechanacimiento());
          Profesor.setRol(Profesor.getRol());
          Profesor.setTelefono(Profesor.getTelefono());
          Profesor.setDireccion(Profesor.getDireccion());
          
      }
    }
}
