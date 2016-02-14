/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.AlbumDao;
import java.util.List;
import javax.transaction.Transactional;
import modelo.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Isa
 */
@Service("AlbumService")
@Transactional
public class AlbumServiceImpl implements AlbumService{
       @Autowired
    private AlbumDao Album;
    @Override
    public Album findbyId(String id) {
        return Album.findbyId(id);
    }

    @Override
    public void save(Album album) {
       this.Album.save(album);
    }

    @Override
    public void DeletebyId(String id) {
        this.Album.DeletebyId(id);
    }

    @Override
    public List<Album> findAll() {
       return Album.findAll();
    }

    @Override
    public void UpdateAlbum(Album album) {
      Album al = this.Album.findbyId(album.getNombre());
      if(al!=null){
          al.setNombre(album.getNombre());

      }
    }
}
