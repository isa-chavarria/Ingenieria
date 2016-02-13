/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import modelo.LineaPago;

/**
 *
 * @author david
 */
public interface LineaPagoService {
    LineaPago findbyId(String id);
    void save(LineaPago lineaPago);
    void DeletebyId(String id);
    List<LineaPago> findAll();
    void UpdateLineaPago(LineaPago lineaPago);
}
