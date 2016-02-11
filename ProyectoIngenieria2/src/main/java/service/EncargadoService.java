/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import modelo.Encargado;

/**
 *
 * @author Isa
 */
public interface EncargadoService {
     Encargado findbyName(String name);
    void save(Encargado kinder);
    void DeletebyName(String name);
    List<Encargado> findAll();
    void UpdateKinder(Encargado Encargado);
}
