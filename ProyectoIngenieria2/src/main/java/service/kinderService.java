/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import modelo.Kinder;

/**
 *
 * @author Isa
 */
public interface kinderService {

    Kinder findbyName(String name);

    void save(Kinder kinder);

    void DeletebyName(String name);

    List<Kinder> findAll();

    void UpdateKinder(Kinder kinder);
}
