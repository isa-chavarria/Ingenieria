/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Contacto;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


@Repository("ContactoDao")
public class ContactoDaoImpl extends AbstractDao<Long, Contacto> implements ContactoDao{
    @Override
    public Contacto findbyCodigo(Long codigo) {
        Contacto contacto = getByKey(codigo);
        return contacto;
    }

    @Override
    public void save(Contacto contacto) {
        persist(contacto);
    }

    @Override
    public void DeletebyCodigo(String codigo) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("codigo", codigo));
        Contacto contacto = (Contacto) crit.uniqueResult();
        delete(contacto);
    }

    @Override
    public List<Contacto> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Contacto> contacto = (List<Contacto>) criteria.list();

        return contacto;
    }
}
