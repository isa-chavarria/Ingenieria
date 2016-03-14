/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Profesor;

/**
 *
 * @author Isa
 */
public interface ProfesorDao {
     Profesor  findbyId(String id);
    void save(Profesor profesor);
    void DeletebyId(String id);
    List< Profesor > findAll();
}
