/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Noticia;


/**
 *
 * @author Isa
 */
public interface NoticiaDao {
    Noticia findbyCodigo(Long codigo);
    void save(Noticia codigo);
    void DeletebyCodigo(Long codigo);
    List<Noticia> findAll();
}
