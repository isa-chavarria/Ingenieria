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
    public Encargado findbyId(String id) {
        return Encargado.findbyId(id);
    }

    @Override
    public void save(Encargado encargado) {
       this.Encargado.save(encargado);
    }

    @Override
    public void DeletebyId(String id) {
        this.Encargado.DeletebyId(id);
    }

    @Override
    public List<Encargado> findAll() {
       return Encargado.findAll();
    }

    @Override
    public void UpdateEncargado(Encargado Encargado) {
      Encargado encargado = this.Encargado.findbyId(Encargado.getNombre());
      if(encargado!=null){
          encargado.setNombre(Encargado.getNombre());
          encargado.setApellido1(Encargado.getApellido1());
          encargado.setApellido2(Encargado.getApellido2());
          encargado.setId(Encargado.getId());
          encargado.setDireccion(Encargado.getDireccion());
          encargado.setEmail(Encargado.getEmail());
          encargado.setFechaNacimiento(Encargado.getFechaNacimiento());
          encargado.setRuta_imagen(Encargado.getRuta_imagen());
          encargado.setTelefono(Encargado.getTelefono());
          encargado.setUsuario(Encargado.getUsuario());
         
      }
    }
}
