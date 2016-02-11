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
    public Encargado findbyName(String name) {
        Encargado Encargado = getByKey(name);
        return Encargado;
    }

    @Override
    public void save(Encargado Encargado) {
        persist(Encargado);
    }

    @Override
    public void DeletebyName(String name) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("nombre", name));
        Encargado Encargado = (Encargado) crit.uniqueResult();
        delete(Encargado);
    }

    @Override
    public List<Encargado> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Encargado> Encargado = (List<Encargado>) criteria.list();

        return Encargado;
    }
    
}
