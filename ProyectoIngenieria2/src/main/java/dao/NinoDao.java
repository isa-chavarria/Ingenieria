/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Nino;

/**
 *
 * @author Isa
 */
public interface NinoDao {
      Nino  findbyId(String id);
    void save(Nino nino);
    void DeletebyId(String id);
    List< Nino > findAll();
}
