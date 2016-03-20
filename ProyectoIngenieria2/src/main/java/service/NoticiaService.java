/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import modelo.Noticia;

/**
 *
 * @author Isa
 */
public interface NoticiaService {
    Noticia findbyCodigo(Long codigo);
    void save(Noticia noticia);
    void DeletebyCodigo(Long codigo);
    List<Noticia> findAll();
    void UpdateNoticia(Noticia noticia);
}
