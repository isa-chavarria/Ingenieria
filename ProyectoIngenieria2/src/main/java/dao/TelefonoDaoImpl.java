/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Telefono;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("TelefonoDao")
public class TelefonoDaoImpl extends AbstractDao<String, Telefono> implements TelefonoDao {

    @Override
    public Telefono findbyId(String id) {
        Telefono planilla = getByKey(id);
        return planilla;
    }

    @Override
    public void save(Telefono planilla) {
        persist(planilla);
    }

    @Override
    public void DeletebyId(String id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
        Telefono planilla = (Telefono) crit.uniqueResult();
        delete(planilla);
    }

    @Override
    public List<Telefono> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Telefono> planilla = (List<Telefono>) criteria.list();

        return planilla;
    }

}
