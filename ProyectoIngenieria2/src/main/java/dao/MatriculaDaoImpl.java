/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Matricula;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Isa
 */
@Repository("MatriculaDao")
public class MatriculaDaoImpl extends AbstractDao<Long, Matricula> implements MatriculaDao {

    @Override
    public Matricula findbyCodigo(Long codigo) {
        Matricula matricula = getByKey(codigo);
        return matricula;
    }

    @Override
    public void save(Matricula matricula) {
        persist(matricula);
    }

    @Override
    public void DeletebyCodigo(Long codigo) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("codigo", codigo));
        Matricula matricula = (Matricula) crit.uniqueResult();
        delete(matricula);
    }

    @Override
    public List<Matricula> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Matricula> matricula = (List<Matricula>) criteria.list();

        return matricula;
    }

}
