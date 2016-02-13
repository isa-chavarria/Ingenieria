/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.LineaPagoDao;
import java.util.List;
import javax.transaction.Transactional;
import modelo.LineaPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("lineaPagoService")
@Transactional
public class LineaPagoServiceImpl implements LineaPagoService{
    @Autowired
    private LineaPagoDao lineaPago;
    @Override
    public LineaPago findbyId(String id) {
        return lineaPago.findbyId(id);
    }

    @Override
    public void save(LineaPago lineaPago) {
       this.lineaPago.save(lineaPago);
    }

    @Override
    public void DeletebyId(String id) {
        this.lineaPago.DeletebyId(id);
    }

    @Override
    public List<LineaPago> findAll() {
       return lineaPago.findAll();
    }

    @Override
    public void UpdateLineaPago(LineaPago lineaPago) {
      LineaPago ki = this.lineaPago.findbyId(lineaPago.getId());
      if(ki!=null){
          ki.setMonto(lineaPago.getMonto());
          ki.setDescripcion(lineaPago.getDescripcion());
      }
    }
}
