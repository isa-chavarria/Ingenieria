/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.InformacionKinder;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


@Repository("InformacionKinderDao")
public class InformacionKinderDaoImpl extends AbstractDao<Long, InformacionKinder> implements InformacionKinderDao{
    @Override
    public InformacionKinder findbyCodigo(Long codigo) {
        InformacionKinder contacto = getByKey(codigo);
        return contacto;
    }

    @Override
    public void save(InformacionKinder contacto) {
        persist(contacto);
    }

    @Override
    public void DeletebyCodigo(Long codigo) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("codigo", codigo));
        InformacionKinder contacto = (InformacionKinder) crit.uniqueResult();
        delete(contacto);
    }

    @Override
    public List<InformacionKinder> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<InformacionKinder> contacto = (List<InformacionKinder>) criteria.list();

        return contacto;
    }
}
