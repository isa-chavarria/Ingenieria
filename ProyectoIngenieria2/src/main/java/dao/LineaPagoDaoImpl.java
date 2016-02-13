/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.LineaPago;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("lineaPagoDao")
public class LineaPagoDaoImpl extends AbstractDao<String, LineaPago> implements LineaPagoDao {
    @Override
    public LineaPago findbyId(String id) {
        LineaPago lineaPago = getByKey(id);
        return lineaPago;
    }

    @Override
    public void save(LineaPago lineaPago) {
        persist(lineaPago);
    }

    @Override
    public void DeletebyId(String id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
        LineaPago lineaPago = (LineaPago) crit.uniqueResult();
        delete(lineaPago);
    }

    @Override
    public List<LineaPago> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<LineaPago> lineaPago = (List<LineaPago>) criteria.list();

        return lineaPago;
    }

}
