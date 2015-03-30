/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.malinkil.mp3;

import java.util.List;
import edu.iit.sat.itmd4515.malinkil.mp3.Address;
import edu.iit.sat.itmd4515.malinkil.mp3.BookClassification;
import edu.iit.sat.itmd4515.malinkil.mp3.BookPurchaseDetails;
import edu.iit.sat.itmd4515.malinkil.mp3.BookDetails;
import edu.iit.sat.itmd4515.malinkil.mp3.StockDetails;
import edu.iit.sat.itmd4515.malinkil.mp3.VendorDetails;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * This test class contains combined test cases for the following entities
 * StockDetails
 * BookClassificationDetails
 * BookPurchaseDetails
 * BookDetails
 * VendorDetails
 * This contains method for create,read, update and delete and output is verified using assert condition.
 * @author mithun.alinkil
 */
public class BookRelationshipTest {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("malinkilPU");
    private static EntityManager em;
    EntityTransaction Tx;
    
    
    
    public BookRelationshipTest() {
    }
    
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
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        Tx = em.getTransaction();
        // Adding details to STOCK_DETAILS
        StockDetails s = new StockDetails();
        s.setTotalAvailableCount(10);
        s.setTotalNoOfBooks(10);
        s.setBookId(1);
        Tx.begin();
        em.persist(s);
        Tx.commit();
        
        // Reading the values stored in STOCK_DETAILS
        List<StockDetails> sd ;
        sd = em.createQuery("select d from StockDetails d").getResultList();
        
        for(StockDetails d : sd)
        {
            System.out.println(""+d.toString());
            assertEquals(10,d.getTotalAvailableCount());
            assertEquals(10, d.getTotalNoOfBooks());
            assertEquals(1,d.getBookId());
        }
        
        // Updating STOCK_DETAILS
        StockDetails st = em.find(StockDetails.class, 26);
        Tx.begin();
        
        
        st.setTotalAvailableCount(5);
        Tx.commit();
        
        List<StockDetails> stockAfterUpdate = em.createQuery("select d from StockDetails d").getResultList();
        
        for(StockDetails sc : stockAfterUpdate)
        {
            System.out.println(""+sc.toString());
            assertEquals(5, sc.getTotalAvailableCount());
            assertEquals(10,sc.getTotalNoOfBooks());
            assertEquals(1, sc.getBookId());
        }
        
        // Adding values to BOOK_CLASSIFICATION
        BookClassification bc = new BookClassification();
        bc.setBookCategory("Science");
        bc.setBookType("Physics");
        Tx.begin();
        em.persist(bc);
        Tx.commit();
        
        // Reading the values stored in BOOK_CLASSIFICATION
        List<BookClassification> bn;
        bn = em.createQuery("select d from BookClassification d").getResultList();
        for(BookClassification b : bn)
        {
            System.out.println(""+b.toString());
            assertEquals("Science", b.getBookCategory());
            assertEquals("Physics", b.getBookType());
        }
        
        
        // Updating BOOK_CLASSIFICATION
        BookClassification v = em.find(BookClassification.class, 2);
        Tx.begin();
        
        v.setBookType("Chemistry");
        Tx.commit();
        
        List<BookClassification> afterUpdate = em.createQuery("select d from BookClassification d").getResultList();
        
        for(BookClassification cl : afterUpdate)
        {
            assertEquals("Science", cl.getBookCategory());
            assertEquals("Chemistry", cl.getBookType());
            
            
        }
        
        
        // Adding values to BOOK_PURCHASE_DETAILS
        BookPurchaseDetails bp = new BookPurchaseDetails();
        bp.setBookId(1);
        bp.setVendorId(1);
        Tx.begin();
        em.persist(bp);
        Tx.commit();
        
        // Reading the stored values from BOOK_PURCHASE_DETAILS
        List<BookPurchaseDetails> bpd = em.createQuery("select d from BookPurchaseDetails d").getResultList();
        
        for(BookPurchaseDetails bk : bpd)
        {
            System.out.println(""+bk.toString());
            assertEquals(1, bk.getBookId());
            assertEquals(1, bk.getVendorId());
        }
        
        // Setting values to BOOK_DETAILS as VENDOR_DETAILS and BOOK_DETAILS has Many to Many Relationship
        // Adding values to VENDOR_DETAILS
        BookDetails b = new BookDetails();
        b.setAuthor("Goncalves");
        b.setBookClassification(afterUpdate);
        b.setEdition("2011");
        b.setPublication("TataMcGrawhill");
        b.setStockDetails(st);
        b.setTitle("JavaEE");
        b.setPrice(110);
        
        Tx.begin();
        em.persist(b);
        Tx.commit();
        
        //Reading values from BOOK_DETAILS
        List<BookDetails> bd = null;
        bd = em.createQuery("select d from BookDetails d").getResultList();
        
        for(BookDetails bs :bd)
        {
            System.out.println("" +bs.toString());
            assertEquals("JavaEE", bs.getTitle());
            assertEquals("TataMcGrawhill", bs.getPublication());
            assertEquals("Goncalves", bs.getAuthor());
            assertEquals(1, bs.getBookId());
        }
        
        Address a = new Address();
        a.setCity("Glenview");
        a.setCountry("United States");
        a.setState("Illinois");
        a.setStreet("1234 ABC Avenue");
        a.setZip(60606);
        
        VendorDetails vd = new VendorDetails();
        vd.setFirstName("GHI");
        vd.setLastName("DFG");
        vd.setAddress(a);
        vd.setBookPurchaseDetails(bpd);
        vd.setBooks(bd);
        vd.setContactNumber("987456321");
        vd.setEmailId("lmn@gmail.com");
        
        Tx.begin();
        em.persist(vd);
        Tx.commit();
        
        
        //Updating BOOK_DETAILS
        BookDetails bk = em.find(BookDetails.class, 1);
        Tx.begin();
        
        bk.setAuthor("DSW");
        bk.setEdition("2014");
        Tx.commit();
        
        List<BookDetails> update = em.createQuery("select d from BookDetails d").getResultList();
        
        for(BookDetails ba : update)
        {
            System.out.println(""+ba.toString());
            assertEquals("DSW", ba.getAuthor());
            assertEquals("2014", ba.getEdition());
        }
        //Reading values of BOOK_DETAILS
        List<VendorDetails> vs = null;
        vs = em.createQuery("select d from VendorDetails d").getResultList();
        
        for(VendorDetails vr : vs)
        {
            System.out.println("" +vr.toString());
            assertEquals("GHI", vr.getFirstName());
            assertEquals("DFG", vr.getLastName());
            assertEquals("lmn@gmail.com", vr.getEmailId());
            assertEquals("987456321", vr.getContactNumber());
            
        }
        //Updating VENDOR_DETAILS
        VendorDetails vendor = em.find(VendorDetails.class, 1);
        Tx.begin();
        
        vendor.setContactNumber("564987321");
        vendor.setEmailId("hij@gmail.com");
        Tx.commit();
        
        List<VendorDetails> updateVendor = em.createQuery("select d from VendorDetails d").getResultList();
        
        for(VendorDetails ve : updateVendor)
        {
            assertEquals("hij@gmail.com", ve.getEmailId());
            assertEquals("564987321", ve.getContactNumber());
            
        }
        
        Tx.begin();
        // Removing values and checking assert condition
        for(VendorDetails r : updateVendor)
        {
            em.remove(r);
        }
        
        for(BookDetails dt : update)
        {
            em.remove(dt);
        }
        
        for(BookPurchaseDetails pu : bpd )
        {
            em.remove(pu);
        }
        
        for(BookClassification cls : afterUpdate)
        {
            em.remove(cls);
        }
        
        for(StockDetails sl : stockAfterUpdate )
        {
            em.remove(sl);
        }
        
        List<VendorDetails> deleteVendors = em.createQuery("select d from VendorDetails d").getResultList();
        assertTrue(deleteVendors.isEmpty());
        
        List<BookDetails> deleteBooks = em.createQuery("select d from BookDetails d").getResultList();
        assertTrue(deleteBooks.isEmpty());
        
        List<BookPurchaseDetails> deleteBookPurchaseDetails = em.createQuery("select d from BookPurchaseDetails d").getResultList();
        assertTrue(deleteBookPurchaseDetails.isEmpty());
        
        List<BookClassification> deleteBookClassification = em.createQuery("select d from BookClassification d").getResultList();
        assertTrue(deleteBookClassification.isEmpty());
        
        List<StockDetails> deleteStockDetails = em.createQuery("select d from StockDetails d").getResultList();
        assertTrue(deleteStockDetails.isEmpty());
        
        Tx.commit();
        
        
        
    }
    
    
}
