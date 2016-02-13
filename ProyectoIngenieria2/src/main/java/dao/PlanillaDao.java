/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Planilla;

public interface PlanillaDao {
      Planilla findbyId(String id);
    void save(Planilla planilla);
    void DeletebyId(String id);
    List<Planilla> findAll();
}
