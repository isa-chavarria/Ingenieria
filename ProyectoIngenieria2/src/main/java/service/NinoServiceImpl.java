/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.NinoDao;
import java.util.List;
import javax.transaction.Transactional;
import modelo.Nino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Isa
 */
@Service("NinoService")
@Transactional
public class NinoServiceImpl implements NinoService {

    @Autowired
    private NinoDao Nino;

    @Override
    public Nino findbyId(String id) {
        return Nino.findbyId(id);
    }

    @Override
    public void save(Nino nino) {
        this.Nino.save(nino);
    }

    @Override
    public void DeletebyId(String id) {
        this.Nino.DeletebyId(id);
    }

    @Override
    public List<Nino> findAll() {
        return Nino.findAll();
    }

    @Override
    public void UpdateNino(Nino nino) {
        Nino ni = this.Nino.findbyId(nino.getId());
        if (ni != null) {
            ni.setClase(nino.getClase());
            ni.setId(nino.getId());
            ni.setEstado(nino.getEstado());
            // ni.setFamiliares(nino.getFamiliares());
            ni.setEncargado(nino.getEncargado());
           // ni.setInformacion(nino.getInformacion());
           //  ni.setMatricula(nino.getMatricula());
        }
    }
}
