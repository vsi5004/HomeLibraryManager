/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbClasses;

import dbClasses.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Ivan
 */
public class AppMediaJpaController implements Serializable
{

    public AppMediaJpaController(EntityManagerFactory emf)
    {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }

    public void create(AppMedia appMedia)
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(appMedia);
            em.getTransaction().commit();
        } finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public void edit(AppMedia appMedia) throws NonexistentEntityException, Exception
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            appMedia = em.merge(appMedia);
            em.getTransaction().commit();
        } catch (Exception ex)
        {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0)
            {
                Integer id = appMedia.getMediaId();
                if (findAppMedia(id) == null)
                {
                    throw new NonexistentEntityException("The appMedia with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            AppMedia appMedia;
            try
            {
                appMedia = em.getReference(AppMedia.class, id);
                appMedia.getMediaId();
            } catch (EntityNotFoundException enfe)
            {
                throw new NonexistentEntityException("The appMedia with id " + id + " no longer exists.", enfe);
            }
            em.remove(appMedia);
            em.getTransaction().commit();
        } finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public List<AppMedia> findAppMediaEntities()
    {
        return findAppMediaEntities(true, -1, -1);
    }

    public List<AppMedia> findAppMediaEntities(int maxResults, int firstResult)
    {
        return findAppMediaEntities(false, maxResults, firstResult);
    }

    private List<AppMedia> findAppMediaEntities(boolean all, int maxResults, int firstResult)
    {
        EntityManager em = getEntityManager();
        try
        {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AppMedia.class));
            Query q = em.createQuery(cq);
            if (!all)
            {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally
        {
            em.close();
        }
    }

    public AppMedia findAppMedia(Integer id)
    {
        EntityManager em = getEntityManager();
        try
        {
            return em.find(AppMedia.class, id);
        } finally
        {
            em.close();
        }
    }

    public int getAppMediaCount()
    {
        EntityManager em = getEntityManager();
        try
        {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AppMedia> rt = cq.from(AppMedia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally
        {
            em.close();
        }
    }
    
}
