/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Familiar;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Isa
 */
@Repository("FamiliarDao")
public class FamiliarDaoImpl extends AbstractDao<Long, Familiar> implements FamiliarDao {

    @Override
    public Familiar findbyCodigo(Long codigo) {
        Familiar familiar = getByKey(codigo);
        return familiar;
    }

    @Override
    public void save(Familiar familiar) {
        persist(familiar);
    }

    @Override
    public void DeletebyId(Long codigo) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("codigo", codigo));
        Familiar familiar = (Familiar) crit.uniqueResult();
        delete(familiar);
    }

    @Override
    public List<Familiar> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Familiar> familiar = (List<Familiar>) criteria.list();

        return familiar;
    }
}
