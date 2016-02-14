/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ImagenDao;
import java.util.List;
import javax.transaction.Transactional;
import modelo.Imagen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Isa
 */
@Service("ImagenService")
@Transactional
public class ImagenServiceImpl implements ImagenService{
       @Autowired
    private ImagenDao Imagen;
    @Override
    public Imagen findbyId(String id) {
        return Imagen.findbyId(id);
    }

    @Override
    public void save(Imagen imagen) {
       this.Imagen.save(imagen);
    }

    @Override
    public void DeletebyId(String id) {
        this.Imagen.DeletebyId(id);
    }

    @Override
    public List<Imagen> findAll() {
       return Imagen.findAll();
    }

    @Override
    public void UpdateImagen(Imagen imagen) {
      Imagen ima = this.Imagen.findbyId(imagen.getCodigo());
      if(ima!=null){
          ima.setCodigo(imagen.getCodigo());
          ima.setAlbum(imagen.getAlbum());
          ima.setRutaImagen(imagen.getRutaImagen());
          
      }
    }
}
