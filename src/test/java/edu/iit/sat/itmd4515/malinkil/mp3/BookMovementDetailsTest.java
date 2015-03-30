/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.malinkil.mp3;

import java.util.GregorianCalendar;
import edu.iit.sat.itmd4515.malinkil.mp3.BookMovementDetails;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This test class is used to test crud operation for
 * BookMovementDetails
 * @author mithun.alinkil
 */
public class BookMovementDetailsTest {
    
    public BookMovementDetailsTest() {}
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("malinkilPU");
    private static EntityManager em;
    EntityTransaction Tx; 
    
    
    @BeforeClass
    public static void setUpClass() {
        
        em = emf.createEntityManager();
    }
    
    @AfterClass
    public static void tearDownClass() {
        
        emf.close();
    }
    
    @Before
    public void initialSetUp() {
        
       Tx = em.getTransaction();
    }
    
    @After
    public void tearDown() {
        if(em != null){
            em.clear();
            em.close();
        }
    }
    
    @Test
    public void crudtest() {
        // Reading values from BOOKMOVEMENTDETAILS
        // TODO review the generated test code and remove the default call to fail.
        BookMovementDetails d = new BookMovementDetails();
        
        d.setBookId(1);
        d.setUserId(1);
        d.setBookReturnDate(new GregorianCalendar(2015,3,20).getTime());
        d.setBookTakenDate(new GregorianCalendar(2015,3,10).getTime());
        d.setOverDueDays(0);
        
        Tx.begin();
        em.persist(d);
        
        Tx.commit();
        
        List<BookMovementDetails> md;
        md = em.createQuery("select d from BookMovementDetails d").getResultList();
        for(BookMovementDetails bmd : md)
        {
            System.out.println(""+bmd.toString());
            assertEquals(1,bmd.getBookId());
            assertEquals(1,bmd.getUserId());
            assertEquals(0,bmd.getOverDueDays());
        }
        
        // Updating BOOKMOVEMENTDETAILS
        BookMovementDetails bm = em.find(BookMovementDetails.class, 1);
        Tx.begin();
        
        bm.setOverDueDays(5);
        Tx.commit();
        
        List<BookMovementDetails> afterUpdate = em.createQuery("select d from BookMovementDetails d").getResultList();
        
        for(BookMovementDetails b : afterUpdate)
        {
            System.out.println(""+b.toString());
            assertEquals(1,b.getBookId());
            assertEquals(1,b.getUserId());
            assertEquals(5,b.getOverDueDays());
        }
        
          Tx.begin();
        // Deleting the values
        for(BookMovementDetails m : afterUpdate)
        {
            em.remove(m);
        }
          Tx.commit();
        
        List<BookMovementDetails> delete = em.createQuery("select d from BookMovementDetails d").getResultList();
        assertTrue(delete.isEmpty());
        
    }
    
}
 