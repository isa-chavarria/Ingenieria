/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Kinder;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Isa
 */
@Repository("kinderDao")
public class KinderDaoImpl extends AbstractDao<String, Kinder> implements KinderDao {

    @Override
    public Kinder findbyName(String name) {
        Kinder kinder = getByKey(name);
        return kinder;
    }

    @Override
    public void save(Kinder kinder) {
        persist(kinder);
    }

    @Override
    public void DeletebyName(String name) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("nombre", name));
        Kinder kinder = (Kinder) crit.uniqueResult();
        delete(kinder);
    }

    @Override
    public List<Kinder> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Kinder> kinder = (List<Kinder>) criteria.list();

        return kinder;
    }

    

}
