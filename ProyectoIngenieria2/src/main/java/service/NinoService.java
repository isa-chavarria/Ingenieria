/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import modelo.Nino;

/**
 *
 * @author Isa
 */
public interface NinoService {

    Nino findbyId(String id);

    void save(Nino nino);

    void DeletebyId(String id);

    List<Nino> findAll();

    void UpdateNino(Nino nino);
}
