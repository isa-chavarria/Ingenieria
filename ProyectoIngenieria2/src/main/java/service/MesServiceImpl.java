/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.MesDao;
import java.util.List;
import javax.transaction.Transactional;
import modelo.Mes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("planillaService")
@Transactional
public class MesServiceImpl implements MesService {

    @Autowired
    private MesDao mes;

    @Override
    public Mes findbyId(Long id) {
        return mes.findbyCodigo(id);
    }

    @Override
    public void save(Mes planilla) {
        this.mes.save(planilla);
    }

    @Override
    public void DeletebyId(Long id) {
        this.mes.findbyCodigo(id);
    }

    @Override
    public List<Mes> findAll() {
        return mes.findAll();
    }

    @Override
    public void UpdatePlanilla(Mes planilla) {
        Mes ki = this.mes.findbyCodigo(planilla.getCodigo());
        if (ki != null) {
            ki.setMes(planilla.getMes());
            ki.setFacturas(planilla.getFacturas());
        }
    }
}
