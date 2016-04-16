/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Enfermedad;
import modelo.Informacion;
import modelo.Matricula;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Isa
 */
@Repository("informacionDao")
public class InformacionDaoImpl extends AbstractDao<Long, Informacion> implements InformacionDao {

    @Override
    public Informacion findbyCodigo(Long codigo) {
        Informacion matricula = getByKey(codigo);
        return matricula;
    }

    @Override
    public void save(Informacion matricula) {
        persist(matricula);
    }

    @Override
    public void DeletebyCodigo(Long codigo) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("codigo", codigo));
        Informacion matricula = (Informacion) crit.uniqueResult();
        delete(matricula);
    }

    @Override
    public List<Informacion> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Informacion> matricula = (List<Informacion>) criteria.list();

        return matricula;
    }

}
