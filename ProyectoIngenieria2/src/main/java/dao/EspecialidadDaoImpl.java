/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Clase;
import modelo.Especialidad;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Isa
 */
@Repository("EspecialidadDao")
public class EspecialidadDaoImpl extends AbstractDao<Long, Especialidad> implements EspecialidadDao {

    @Override
    public Especialidad findbyId(Long id) {
        Especialidad Clase = getByKey(id);
        return Clase;
    }

    @Override
    public void save(Especialidad clase) {
        persist(clase);
    }

    @Override
    public void DeletebyId(Long id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
        Especialidad Clase = (Especialidad) crit.uniqueResult();
        delete(Clase);
    }

    @Override
    public List<Especialidad> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Especialidad> clase = (List<Especialidad>) criteria.list();

        return clase;
    }

}
