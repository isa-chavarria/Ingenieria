/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Factura;

public interface FacturaDao {
    Factura findbyCodigo(String codigo);
    void save(Factura codigo);
    void DeletebyCodigo(String codigo);
    List<Factura> findAll();
}
