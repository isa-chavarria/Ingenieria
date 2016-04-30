/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Requerimiento;


public interface RequerimientoDao {
    Requerimiento findbyCodigo(Long codigo);
    void save(Requerimiento codigo);
    void DeletebyCodigo(Long codigo);
    List<Requerimiento> findAll();
}
