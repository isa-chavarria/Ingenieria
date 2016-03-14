/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.FamiliarDao;
import java.util.List;
import javax.transaction.Transactional;
import modelo.Album;
import modelo.Familiar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Isa
 */
@Service("FamiliarService")
@Transactional
public class FamiliarServiceImpl implements FamiliarService {

    @Autowired
    private FamiliarDao Album;

    @Override
    public Familiar findbyId(String id) {
        return Album.findbyId(id);
    }

    @Override
    public void save(Familiar album) {
        this.Album.save(album);
    }

    @Override
    public void DeletebyId(String id) {
        this.Album.DeletebyId(id);
    }

    @Override
    public List<Familiar> findAll() {
        return Album.findAll();
    }

    @Override
    public void UpdateFamiliar(Familiar familiar) {
        Familiar al = this.Album.findbyId(familiar.getId());
        if (al != null) {
            al.setNombre(familiar.getNombre());
            al.setId(familiar.getId());
            al.setApellido1(familiar.getApellido1());
            al.setApellido2(familiar.getApellido2());
            al.setEdad(familiar.getEdad());
            al.setLugarTrabajo(familiar.getLugarTrabajo());
            al.setOcupacion(familiar.getOcupacion());
            al.setNino(familiar.getNino());
            al.setParentesco(familiar.getParentesco());
            //al.setTelefonos(familiar.getTelefonos());
        }
    }

}
