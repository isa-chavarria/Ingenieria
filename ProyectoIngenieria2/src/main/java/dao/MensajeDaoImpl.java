/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Mensaje;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


@Repository("MensajeDao")
public class MensajeDaoImpl extends AbstractDao<Long, Mensaje> implements MensajeDao{
    @Override
    public Mensaje findbyCodigo(Long codigo) {
        Mensaje contacto = getByKey(codigo);
        return contacto;
    }

    @Override
    public void save(Mensaje contacto) {
        persist(contacto);
    }

    @Override
    public void DeletebyCodigo(Long codigo) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("codigo", codigo));
        Mensaje contacto = (Mensaje) crit.uniqueResult();
        delete(contacto);
    }

    @Override
    public List<Mensaje> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Mensaje> contacto = (List<Mensaje>) criteria.list();

        return contacto;
    }
}
