/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.PlanillaDao;
import java.util.List;
import javax.transaction.Transactional;
import modelo.Planilla;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("planillaService")
@Transactional
public class PlanillaServiceImpl implements PlanillaService{
    @Autowired
    private PlanillaDao planilla;
    @Override
    public Planilla findbyId(String id) {
        return planilla.findbyId(id);
    }

    @Override
    public void save(Planilla planilla) {
       this.planilla.save(planilla);
    }

    @Override
    public void DeletebyId(String id) {
        this.planilla.DeletebyId(id);
    }

    @Override
    public List<Planilla> findAll() {
       return planilla.findAll();
    }

    @Override
    public void UpdatePlanilla(Planilla planilla) {
      Planilla ki = this.planilla.findbyId(planilla.getId());
      if(ki!=null){
          ki.setMontopago(planilla.getMontopago());
          ki.setEstado(planilla.getEstado());
          ki.setFecha(planilla.getFecha());
      }
    }
}
