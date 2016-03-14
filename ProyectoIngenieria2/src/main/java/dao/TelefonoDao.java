/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Telefono;

public interface TelefonoDao {

    Telefono findbyId(String id);

    void save(Telefono planilla);

    void DeletebyId(String id);

    List<Telefono> findAll();
}
