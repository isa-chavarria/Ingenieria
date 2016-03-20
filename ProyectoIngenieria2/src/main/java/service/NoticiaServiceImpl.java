/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import dao.NoticiaDao;
import java.util.List;
import javax.transaction.Transactional;
import modelo.Noticia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Isa
 */
@Service("noticiaService")
@Transactional
public class NoticiaServiceImpl implements NoticiaService{

     @Autowired
    private NoticiaDao noticia;

    @Override
    public Noticia findbyCodigo(Long codigo) {
        return noticia.findbyCodigo(codigo);
    }

    @Override
    public void save(Noticia noticia) {
        this.noticia.save(noticia);
    }

    @Override
    public void DeletebyCodigo(Long name) {
        this.noticia.DeletebyCodigo(name);
    }

    @Override
    public List<Noticia> findAll() {
        return noticia.findAll();
    }
  @Override
    public void UpdateNoticia(Noticia noticia) {
        Noticia ki = this.noticia.findbyCodigo(noticia.getCodigo());
        if (ki != null) {
            ki.setDescripcion(noticia.getDescripcion());
            ki.setTitulo(noticia.getTitulo());
            ki.setKinder(noticia.getKinder());
        }
    }
    
}
