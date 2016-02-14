/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Imagen;

/**
 *
 * @author Isa
 */
public interface ImagenDao {
         Imagen  findbyId(String id);
    void save(Imagen imagen);
    void DeletebyId(String id);
    List< Imagen > findAll();
}
