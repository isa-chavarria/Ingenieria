/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Encargado;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Isa
 */
@Repository("EncargadoDao")
public class EncargadoDaoImpl extends AbstractDao<String, Encargado> implements EncargadoDao{
     @Override
    public Encargado findbyId(String id) {
        Encargado encargado = getByKey(id);
        return encargado;
    }

    @Override
    public void save(Encargado encargado) {
        persist(encargado);
    }

    @Override
    public void DeletebyId(String id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
        Encargado encargado = (Encargado) crit.uniqueResult();
        delete(encargado);
    }

    @Override
    public List<Encargado> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Encargado> encargado = (List<Encargado>) criteria.list();

        return encargado;
    }
    
}
