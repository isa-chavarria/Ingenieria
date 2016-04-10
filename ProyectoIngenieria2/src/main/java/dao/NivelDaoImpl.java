/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Clase;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Isa
 */
@Repository("ClaseDao")
public class ClaseDaoImpl extends AbstractDao<String, Clase> implements ClaseDao {

    @Override
    public Clase findbyId(String id) {
        Clase Clase = getByKey(id);
        return Clase;
    }

    @Override
    public void save(Clase clase) {
        persist(clase);
    }

    @Override
    public void DeletebyId(String id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
        Clase Clase = (Clase) crit.uniqueResult();
        delete(Clase);
    }

    @Override
    public List<Clase> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Clase> clase = (List<Clase>) criteria.list();

        return clase;
    }

}
