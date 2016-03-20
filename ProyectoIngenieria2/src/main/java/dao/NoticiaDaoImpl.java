/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Noticia;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Isa
 */
@Repository("NoticiaDao")
public class NoticiaDaoImpl extends AbstractDao<Long, Noticia> implements NoticiaDao{
    @Override
    public Noticia findbyCodigo(Long codigo) {
        Noticia noticia = getByKey(codigo);
        return noticia;
    }

    @Override
    public void save(Noticia noticia) {
        persist(noticia);
    }

    @Override
    public void DeletebyCodigo(Long codigo) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("codigo", codigo));
        Noticia noticia = (Noticia) crit.uniqueResult();
        delete(noticia);
    }

    @Override
    public List<Noticia> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Noticia> noticia = (List<Noticia>) criteria.list();

        return noticia;
    }
    
}
