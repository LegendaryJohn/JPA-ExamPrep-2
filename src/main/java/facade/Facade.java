/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author kann
 */
public class Facade {
    
    EntityManagerFactory emf;
    
    public Facade(EntityManagerFactory emf){
        this.emf = emf;
    }
    
    public Person addPerson(Person p){
        EntityManager em = emf.createEntityManager();
        
        try{
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return p;
        }
        finally{
            em.close();
        }
    }
    
    public Person findPerson(int id){
        EntityManager em = emf.createEntityManager();
        
        Person p = null;
        
        try{
            em.getTransaction().begin();
            p = em.find(Person.class, id);
            em.getTransaction().commit();
            return p;
        }
        finally{
            em.close();
        }
        
    }
    
    public List<Person> findPersons(){
        EntityManager em = emf.createEntityManager();
        
        List<Person> persons = null;
        
        try{
            em.getTransaction().begin();
            persons = em.createQuery("Select p from Person p").getResultList();
            em.getTransaction().commit();
            return persons;
        }
        finally{
            em.close();
        }
    }
    
    public Person editPerson(Person pers)
    {
        EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();
            Person p = em.find(Person.class, pers.getId());
            if(p != null)
            {
                p = pers;
                em.merge(p);
                em.getTransaction().commit();
                return p;
            }
        }
        finally
        {
            em.close();
        }  
        
        return null;
    }

    
    public Person deletePerson(int id)
    {
        EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();
            Person p = em.find(Person.class, id);
            em.remove(p);
            em.getTransaction().commit();
            return p;
        }
        finally
        {
            em.close();
        }
    }

    
}
