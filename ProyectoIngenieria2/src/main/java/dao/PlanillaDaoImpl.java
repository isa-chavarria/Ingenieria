/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Planilla;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("planillaDao")
public class PlanillaDaoImpl extends AbstractDao<String, Planilla> implements PlanillaDao {
    @Override
    public Planilla findbyId(String id) {
        Planilla planilla = getByKey(id);
        return planilla;
    }

    @Override
    public void save(Planilla planilla) {
        persist(planilla);
    }

    @Override
    public void DeletebyId(String id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
        Planilla planilla = (Planilla) crit.uniqueResult();
        delete(planilla);
    }

    @Override
    public List<Planilla> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Planilla> planilla = (List<Planilla>) criteria.list();

        return planilla;
    }

}
