/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import modelo.Planilla;

/**
 *
 * @author david
 */
public interface PlanillaService {
    Planilla findbyId(String id);
    void save(Planilla planilla);
    void DeletebyId(String id);
    List<Planilla> findAll();
    void UpdatePlanilla(Planilla planilla);
}
