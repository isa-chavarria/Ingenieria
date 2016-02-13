/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import modelo.Contacto;

/**
 *
 * @author david
 */
public interface ContactoService {
    Contacto findbyCodigo(String codigo);
    void save(Contacto encargado);
    void DeletebyCodigo(String codigo);
    List<Contacto> findAll();
    void UpdateContacto(Contacto contacto);
}
