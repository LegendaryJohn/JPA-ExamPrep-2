/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author kann
 */
public class tester {
    
    public static void main(String[] args) {
        
        Persistence.generateSchema("JPAExamPrep2", null);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "JPAExamPrep2" );
        EntityManager em = emf.createEntityManager();
        
    }
    
}
