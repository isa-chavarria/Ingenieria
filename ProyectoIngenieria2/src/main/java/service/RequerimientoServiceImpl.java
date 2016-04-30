/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ContactoDao;
import dao.RequerimientoDao;
import java.util.List;
import javax.transaction.Transactional;
import modelo.Contacto;
import modelo.Requerimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("requerimientoService")
@Transactional
public class RequerimientoServiceImpl implements RequerimientoService {

    @Autowired
    private RequerimientoDao requerimiento;

    @Override
    public Requerimiento findbyCodigo(Long codigo) {
        return requerimiento.findbyCodigo(codigo);
    }

    @Override
    public void save(Requerimiento contacto) {
        this.requerimiento.save(contacto);
    }

    @Override
    public void DeletebyCodigo(Long name) {
        this.requerimiento.DeletebyCodigo(name);
    }

    @Override
    public List<Requerimiento> findAll() {
        return requerimiento.findAll();
    }

    @Override
    public void UpdateRequerimiento(Requerimiento contacto) {
        Requerimiento ki = this.requerimiento.findbyCodigo(contacto.getCodigo());
        if (ki != null) {
            ki.setDescripcion(contacto.getDescripcion());
            ki.setKinder(contacto.getKinder());
        }
    }
}
