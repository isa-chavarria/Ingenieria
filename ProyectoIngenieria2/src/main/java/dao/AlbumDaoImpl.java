/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Album;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Isa
 */
@Repository("AlbumDao")
public class AlbumDaoImpl extends AbstractDao<String, Album> implements AlbumDao{
     @Override
    public Album findbyId(String id) {
      Album  nino  = getByKey(id);
        return nino;
    }

    @Override
    public void save(Album album) {
        persist(album);
    }

    @Override
    public void DeletebyId(String id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
        Album album = (Album) crit.uniqueResult();
        delete(album);
    }

    @Override
    public List<Album> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Album> album = (List<Album>) criteria.list();

        return album;
    }
}
