/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import modelo.Familiar;

/**
 *
 * @author Isa
 */
public interface FamiliarService {

    Familiar findbyId(String id);

    void save(Familiar album);

    void DeletebyId(String id);

    List<Familiar> findAll();

    void UpdateFamiliar(Familiar album);
}
