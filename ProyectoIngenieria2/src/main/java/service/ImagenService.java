/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import modelo.Imagen;

/**
 *
 * @author Isa
 */
public interface ImagenService {
       Imagen findbyId(Long id);
    void save(Imagen imagen);
    void DeletebyId(Long id);
    List<Imagen> findAll();
    void UpdateImagen(Imagen imagen);
}
