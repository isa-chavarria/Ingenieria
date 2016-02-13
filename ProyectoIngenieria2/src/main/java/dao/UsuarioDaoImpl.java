/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Usuario;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Isa
 */
@Repository("UsuarioDao")
public class UsuarioDaoImpl extends AbstractDao<String,Usuario> implements UsuarioDao{
      @Override
    public Usuario findbyId(String id) {
      Usuario  usuario  = getByKey(id);
        return usuario;
    }

    @Override
    public void save(Usuario usuario) {
        persist(usuario);
    }

    @Override
    public void DeletebyId(String id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
        Usuario usuario = (Usuario) crit.uniqueResult();
        delete(usuario);
    }

    @Override
    public List<Usuario> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Usuario> usuario = (List<Usuario>) criteria.list();

        return usuario;
    }
}
