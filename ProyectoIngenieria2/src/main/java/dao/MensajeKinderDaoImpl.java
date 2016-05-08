/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.MensajeKinder;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


@Repository("MensajeKinderDao")
public class MensajeKinderDaoImpl extends AbstractDao<Long, MensajeKinder> implements MensajeKinderDao{
    @Override
    public MensajeKinder findbyCodigo(Long codigo) {
        MensajeKinder contacto = getByKey(codigo);
        return contacto;
    }

    @Override
    public void save(MensajeKinder contacto) {
        persist(contacto);
    }

    @Override
    public void DeletebyCodigo(Long codigo) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("codigo", codigo));
        MensajeKinder contacto = (MensajeKinder) crit.uniqueResult();
        delete(contacto);
    }

    @Override
    public List<MensajeKinder> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<MensajeKinder> contacto = (List<MensajeKinder>) criteria.list();

        return contacto;
    }
}
