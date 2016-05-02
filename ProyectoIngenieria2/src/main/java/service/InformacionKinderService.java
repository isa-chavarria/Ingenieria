/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import modelo.InformacionKinder;

/**
 *
 * @author david
 */
public interface InformacionKinderService {
    InformacionKinder findbyCodigo(Long codigo);
    void save(InformacionKinder contacto);
    void DeletebyCodigo(Long codigo);
    List<InformacionKinder> findAll();
    void UpdateInformacionkinder(InformacionKinder contacto);
}
