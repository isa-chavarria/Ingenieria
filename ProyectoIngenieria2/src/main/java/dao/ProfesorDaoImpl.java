/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Profesor;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Isa
 */
@Repository("ProfesorDao")
public class ProfesorDaoImpl extends AbstractDao<String,Profesor> implements ProfesorDao{
      @Override
    public Profesor findbyId(String id) {
      Profesor  profesor  = getByKey(id);
        return profesor;
    }

    @Override
    public void save(Profesor profesor) {
        persist(profesor);
    }

    @Override
    public void DeletebyId(String id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
        Profesor profesor = (Profesor) crit.uniqueResult();
        delete(profesor);
    }

    @Override
    public List<Profesor> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Profesor> profesor = (List<Profesor>) criteria.list();

        return profesor;
    }
    
}
