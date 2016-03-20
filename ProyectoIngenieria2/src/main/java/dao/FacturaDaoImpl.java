/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Factura;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("FacturaDao")
public class FacturaDaoImpl extends AbstractDao<Long, Factura> implements FacturaDao {

    @Override
    public Factura findbyCodigo(Long codigo) {
        Factura factura = getByKey(codigo);
        return factura;
    }

    @Override
    public void save(Factura factura) {
        persist(factura);
    }

    @Override
    public void DeletebyCodigo(Long codigo) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("codigo", codigo));
        Factura factura = (Factura) crit.uniqueResult();
        delete(factura);
    }

    @Override
    public List<Factura> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Factura> factura = (List<Factura>) criteria.list();

        return factura;
    }
}
