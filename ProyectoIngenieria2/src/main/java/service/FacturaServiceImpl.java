/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.FacturaDao;
import java.util.List;
import javax.transaction.Transactional;
import modelo.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("facturaService")
@Transactional
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaDao factura;

    @Override
    public Factura findbyCodigo(String name) {
        return factura.findbyCodigo(name);
    }

    @Override
    public void save(Factura factura) {
        this.factura.save(factura);
    }

    @Override
    public void DeletebyCodigo(String name) {
        this.factura.DeletebyCodigo(name);
    }

    @Override
    public List<Factura> findAll() {
        return factura.findAll();
    }

    @Override
    public void UpdateFactura(Factura factura) {
        Factura ki = this.factura.findbyCodigo(factura.getCodigo());
        if (ki != null) {
            ki.setFechaActual(factura.getFechaActual());
            ki.setMontoFinal(factura.getMontoFinal());
            ki.setLineasDePago(factura.getLineasDePago());
        }
    }
}
