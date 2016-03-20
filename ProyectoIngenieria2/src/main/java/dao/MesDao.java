/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Mes;

public interface MesDao {

   Mes findbyCodigo(Long codigo);
    void save(Mes codigo);
    void DeletebyCodigo(Long codigo);
    List<Mes> findAll();
}
