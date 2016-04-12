/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import modelo.Album;

/**
 *
 * @author Isa
 */
public interface AlbumService {
    Album findbyId(String id);
    void save(Album album);
    void DeletebyId(String id);
    List<Album> findAll();
    void UpdateAlbum(Album album);
}
