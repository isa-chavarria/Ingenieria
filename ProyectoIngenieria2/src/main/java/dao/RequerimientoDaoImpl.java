/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Contacto;
import modelo.Requerimiento;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


@Repository("RequerimientoDao")
public class RequerimientoDaoImpl extends AbstractDao<Long, Requerimiento> implements RequerimientoDao{
    @Override
    public Requerimiento findbyCodigo(Long codigo) {
        Requerimiento contacto = getByKey(codigo);
        return contacto;
    }

    @Override
    public void save(Requerimiento contacto) {
        persist(contacto);
    }

    @Override
    public void DeletebyCodigo(Long codigo) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("codigo", codigo));
        Requerimiento contacto = (Requerimiento) crit.uniqueResult();
        delete(contacto);
    }

    @Override
    public List<Requerimiento> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Requerimiento> contacto = (List<Requerimiento>) criteria.list();

        return contacto;
    }
}
