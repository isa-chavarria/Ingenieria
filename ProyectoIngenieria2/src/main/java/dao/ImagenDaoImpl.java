/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Imagen;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Isa
 */
@Repository("ImagenDao")
public class ImagenDaoImpl extends AbstractDao<String, Imagen> implements ImagenDao{
     @Override
    public Imagen findbyId(String id) {
      Imagen  imagen  = getByKey(id);
        return imagen;
    }

    @Override
    public void save(Imagen imagen) {
        persist(imagen);
    }

    @Override
    public void DeletebyId(String id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
        Imagen imagen= (Imagen) crit.uniqueResult();
        delete(imagen);
    }

    @Override
    public List<Imagen> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Imagen> imagen = (List<Imagen>) criteria.list();

        return imagen;
    }
}
