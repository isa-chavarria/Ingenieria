/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Nino;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Isa
 */
@Repository("NinoDao")
public class NinoDaoImpl extends AbstractDao<String,Nino> implements NinoDao{
     @Override
    public Nino findbyId(String id) {
      Nino  nino  = getByKey(id);
        return nino;
    }

    @Override
    public void save(Nino nino) {
        persist(nino);
    }

    @Override
    public void DeletebyId(String id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
        Nino nino = (Nino) crit.uniqueResult();
        delete(nino);
    }

    @Override
    public List<Nino> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Nino> nino = (List<Nino>) criteria.list();

        return nino;
    }
    
}
