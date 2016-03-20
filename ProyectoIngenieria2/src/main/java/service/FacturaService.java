/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import modelo.Factura;

/**
 *
 * @author david
 */
public interface FacturaService {

    Factura findbyCodigo(Long codigo);

    void save(Factura encargado);

    void DeletebyCodigo(Long codigo);

    List<Factura> findAll();

    void UpdateFactura(Factura Factura);
}
