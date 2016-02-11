/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.EncargadoDao;
import java.util.List;
import javax.transaction.Transactional;
import modelo.Encargado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Isa
 */
@Service("EncargadoService")
@Transactional
public class EncargadoServiceImpl implements EncargadoService {
     @Autowired
    private EncargadoDao Encargado;
    @Override
    public Encargado findbyName(String name) {
        return Encargado.findbyName(name);
    }

    @Override
    public void save(Encargado Encargado) {
       this.Encargado.save(Encargado);
    }

    @Override
    public void DeletebyName(String name) {
        this.Encargado.DeletebyName(name);
    }

    @Override
    public List<Encargado> findAll() {
       return Encargado.findAll();
    }

    @Override
    public void UpdateKinder(Encargado Encargado) {
      Encargado encargado = this.Encargado.findbyName(Encargado.getNombre());
      if(encargado!=null){
          encargado.setNombre(Encargado.getNombre());
          encargado.setApellido1(Encargado.getApellido1());
          encargado.setApellido2(Encargado.getApellido2());
          encargado.setId(Encargado.getId());
          encargado.setDireccion(Encargado.getDireccion());
          encargado.setEmail(Encargado.getEmail());
          encargado.setFechaNacimiento(Encargado.getFechaNacimiento());
          encargado.setRol(Encargado.getRol());
          encargado.setTelefono(Encargado.getTelefono());
          
      }
    }
}
