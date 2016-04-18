/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Enfermedad;
import modelo.Matricula;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Isa
 */
@Repository("EnfermedadDao")
public class EnfermedadDaoImpl extends AbstractDao<Long, Enfermedad> implements EnfermedadDao {

    @Override
    public Enfermedad findbyCodigo(Long codigo) {
        Enfermedad matricula = getByKey(codigo);
        return matricula;
    }

    @Override
    public void save(Enfermedad matricula) {
        persist(matricula);
    }

    @Override
    public void DeletebyCodigo(Long codigo) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("codigo", codigo));
        Enfermedad matricula = (Enfermedad) crit.uniqueResult();
        delete(matricula);
    }

    @Override
    public List<Enfermedad> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Enfermedad> matricula = (List<Enfermedad>) criteria.list();

        return matricula;
    }

}
