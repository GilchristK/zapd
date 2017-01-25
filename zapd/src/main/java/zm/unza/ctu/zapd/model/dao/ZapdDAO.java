/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.unza.ctu.zapd.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Katuta
 */
public abstract class ZapdDAO<T> implements Serializable{
    private final static EntityManagerFactory emf =  Persistence.createEntityManagerFactory("zapdPU");
    private Logger log = Logger.getLogger(ZapdDAO.class.getName());
    private EntityManager em;
    private Class<T> entityClass;
    
    public void beginTransaction(){
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }
    public void commit(){
        em.getTransaction().commit();
    }
    public void rollback(){
        em.getTransaction().rollback();
    }
    public void closeTransaction(){
        em.close();
    }
    public void commitAndCloseTransaction(){
        commit();
        closeTransaction();
    }
    public void flush(){
        em.flush();
    }
    public void joinTransaction(){
        em = emf.createEntityManager();
        em.joinTransaction();
    }
    public ZapdDAO(Class<T> entityClass){
        this.entityClass = entityClass;
    }
    public void save(T entity){
        //log.log(Level.SEVERE,"Entity running...");
        log.info("The logger is excuting !!");
        System.out.println("Running save method");
        em.persist(entity);
    }
    public void delete(T entity){
        T entityToBeRemoved = em.merge(entity);
        em.remove(entityToBeRemoved);
    }
    public T update(T entity){
        return em.merge(entity);
    }
    public T find(int entityID){
        return em.find(entityClass, entityID);
    }
    public List<T> findAll(){
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }
    protected T findOneResult(String namedQuery,Map<String,Object> parameters){
        T result = null;
        try{
            Query query = em.createNamedQuery(namedQuery);
            // Method that will populate parameters if they are passed not null and empty
            if (parameters != null && !parameters.isEmpty()){
                populateQueryParameters(query, parameters);
            }
        }catch (NoResultException e){
            System.out.println("No result found for named query: "+ namedQuery);
        }catch (Exception e) {
            System.out.println("Error while running query: "+e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    private void populateQueryParameters(Query query, Map<String, Object> parameters) {
       for (Map.Entry<String, Object> entry : parameters.entrySet()) {
           query.setParameter(entry.getKey(), entry.getValue());
        }
    }
}
