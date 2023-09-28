/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad.controller;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import notepad.controller.exceptions.NonexistentEntityException;
import notepad.controller.exceptions.PreexistingEntityException;
import notepad.model.Catatan;

/**
 *
 * @author USER
 */
public class CatatanJpaController implements Serializable {

    public CatatanJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Catatan catatan) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(catatan);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCatatan(catatan.getJudul()) != null) {
                throw new PreexistingEntityException("Catatan " + catatan + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Catatan catatan) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            catatan = em.merge(catatan);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = catatan.getJudul();
                if (findCatatan(id) == null) {
                    throw new NonexistentEntityException("The catatan with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Catatan catatan;
            try {
                catatan = em.getReference(Catatan.class, id);
                catatan.getJudul();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The catatan with id " + id + " no longer exists.", enfe);
            }
            em.remove(catatan);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Catatan> findCatatanEntities() {
        return findCatatanEntities(true, -1, -1);
    }

    public List<Catatan> findCatatanEntities(int maxResults, int firstResult) {
        return findCatatanEntities(false, maxResults, firstResult);
    }

    private List<Catatan> findCatatanEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Catatan.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Catatan findCatatan(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Catatan.class, id);
        } finally {
            em.close();
        }
    }

    public int getCatatanCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Catatan> rt = cq.from(Catatan.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
