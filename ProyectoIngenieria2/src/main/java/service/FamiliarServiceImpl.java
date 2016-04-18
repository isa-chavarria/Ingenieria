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
    public Familiar findbyCodigo(Long codigo) {
        return Album.findbyCodigo(codigo);
    }

    @Override
    public void save(Familiar album) {
        this.Album.save(album);
    }

    @Override
    public void DeletebyCodigo(Long codigo) {
        this.Album.DeletebyId(codigo);
    }

    @Override
    public List<Familiar> findAll() {
        return Album.findAll();
    }

    @Override
    public void UpdateFamiliar(Familiar familiar) {
        Familiar al = this.Album.findbyCodigo(familiar.getCodigo());
        if (al != null) {
            al.setCodigo(familiar.getCodigo());
            al.setNombre(familiar.getNombre());
            al.setId(familiar.getId());
            al.setEdad(familiar.getEdad());
            al.setLugarTrabajo(familiar.getLugarTrabajo());
            al.setOcupacion(familiar.getOcupacion());
            al.setNino(familiar.getNino());
            al.setParentesco(familiar.getParentesco());
            al.setNumeroTrabajo(familiar.getNumeroTrabajo());
            al.setNumeroPersonal(familiar.getNumeroPersonal());
            //al.setTelefonos(familiar.getTelefonos());
        }
    }
}
