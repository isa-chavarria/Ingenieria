/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import modelo.Requerimiento;


/**
 *
 * @author david
 */
public interface RequerimientoService {
    Requerimiento findbyCodigo(Long codigo);
    void save(Requerimiento contacto);
    void DeletebyCodigo(Long codigo);
    List<Requerimiento> findAll();
    void UpdateRequerimiento(Requerimiento contacto);
}
