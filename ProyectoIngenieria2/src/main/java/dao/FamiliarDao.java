/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Familiar;

/**
 *
 * @author Isa
 */
public interface FamiliarDao {

    Familiar findbyCodigo(Long codigo);

    void save(Familiar album);

    void DeletebyId(Long codigo);

    List< Familiar> findAll();
}
