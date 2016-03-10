/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Isa
 */
@Repository("UsuarioDao")
public class UsuarioDaoImpl extends AbstractDao<String, Usuario> implements UsuarioDao {

    @Override
    public Usuario findbyId(String id) {
        Usuario user = getByKey(id);

        if(user!=null){
			Hibernate.initialize(user.getEncargado());
		}
        return user;
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

    @Override
    public Usuario findbyLogin(String email, String password) {
        System.out.println("Email : " + email);
        System.out.println("Password : " + password);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("email", email));
        Usuario user = (Usuario) crit.uniqueResult();
        if (user != null) {
            if (user.getContrasena().equals(password)) {
                Hibernate.initialize(user.getEncargado());
                return user;
            }

        }
        return null;
    }
}
