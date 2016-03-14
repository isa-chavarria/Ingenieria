/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import modelo.Telefono;

/**
 *
 * @author david
 */
public interface TelefonoService {
    Telefono findbyId(String id);
    void save(Telefono planilla);
    void DeletebyId(String id);
    List<Telefono> findAll();
    void UpdateTelefono(Telefono planilla);
}
