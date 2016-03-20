/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Mes;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("MesDao")
public class MesDaoImpl extends AbstractDao<Long, Mes> implements MesDao {

   @Override
    public Mes findbyCodigo(Long codigo) {
        Mes contacto = getByKey(codigo);
        return contacto;
    }

    @Override
    public void save(Mes contacto) {
        persist(contacto);
    }

    @Override
    public void DeletebyCodigo(Long codigo) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("codigo", codigo));
        Mes contacto = (Mes) crit.uniqueResult();
        delete(contacto);
    }

    @Override
    public List<Mes> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Mes> contacto = (List<Mes>) criteria.list();

        return contacto;
    }
}
