/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.malinkil.mp3;

import java.util.GregorianCalendar;
import edu.iit.sat.itmd4515.malinkil.mp3.Address;
import edu.iit.sat.itmd4515.malinkil.mp3.MembershipDetails;
import edu.iit.sat.itmd4515.malinkil.mp3.UserDetails;
import java.util.List;
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
 * This test class is used to perform crud operation on following table. Both classes have relationship
 * so single class is used to test and assert condition is used to check operations
 * USERDETAILS
 * MEMBERSHIPDETAILS
 *
 * @author mithun.alinkil
 */
public class UserandMembershipDetailsTest {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("malinkilPU");
    private static EntityManager em;
    EntityTransaction Tx;
    
    
    
    
    public UserandMembershipDetailsTest() {
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
        setupTestData();
    }
    
    @After
    public void tearDown() {
        
        if(em!=null) {
            em.clear();
            em.close();
        }
        
    }

    /**
     * Method to create data in MEMBRSHIPDETAILS table
     */
    private void setupTestData() {
        
        Address a = new Address();
        MembershipDetails md = new MembershipDetails();
        UserDetails ud = new UserDetails();
        
        a.setCity("Chicago");
        a.setCountry("United States");
        a.setState("Illinois");
        a.setStreet("2738 S Wentworth");
        a.setZip(60616);
        
        md.setMemberType("Premium");
        md.setDuration("2 years");
        md.setCost(100);
        
        em.persist(md);
        
        
        ud.setAddress(a);
        ud.setContactNumber("123456789");
        ud.setDateofBirth(new GregorianCalendar(1991, 5, 27).getTime());
        ud.setDateofJoining(new GregorianCalendar(2015, 3, 3).getTime());
        ud.setFirstName("ABC");
        ud.setLastName("XYZ");
        ud.setMailId("abc@gmail.com");
        ud.setMemebershipDetail(md);
        ud.setRenewalDate(new GregorianCalendar(2017, 3, 2).getTime());
        
        Tx.begin();
        em.persist(ud);
        Tx.commit();
        
        
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void crudUserandMembershipDetailsTest(){
        
        List<MembershipDetails> m;
        m = em.createQuery("select d from MembershipDetails d").getResultList();
        
        for(MembershipDetails d : m) 
        {
         System.out.println(""+d.toString());
         assertEquals(100,d.getCost());
         assertEquals("Premium", d.getMemberType());
         assertEquals("2 years", d.getDuration());
         
        }
        
        List<UserDetails> u = em.createQuery("select d from UserDetails d").getResultList();
        for(UserDetails d : u)
        {
            assertEquals("ABC",d.getFirstName());
            assertEquals("XYZ",d.getLastName());
            assertEquals("123456789",d.getContactNumber());
            assertEquals("abc@gmail.com",d.getMailId());
            assertEquals("Chicago",d.getAddress().getCity());
            assertEquals("United States",d.getAddress().getCountry());
            assertEquals("Illinois",d.getAddress().getState());
            assertEquals("2738 S Wentworth",d.getAddress().getStreet());
            assertEquals(60616,d.getAddress().getZip());
        }
        
        
        UserDetails d = em.find(UserDetails.class, 1);
        Tx.begin();
        
        d.setFirstName("PQR");
        d.setLastName("LMN");
        d.setContactNumber("987654321");
        
        Address ad = new Address();
        ad.setState("California");
        ad.setCity("Los Angeles");
        ad.setCountry("United States");
        ad.setStreet("1234 Lakeshore");
        ad.setZip(80856);
        d.setAddress(ad);
        Tx.commit();
        
        List<UserDetails> nd = em.createQuery("select d from UserDetails d").getResultList();
        
        for(UserDetails r : nd)
        {
            System.out.println(""+r.toString());
            assertEquals("PQR",r.getFirstName());
            assertEquals("LMN",r.getLastName());
            assertEquals("987654321",r.getContactNumber());
            assertEquals("California",d.getAddress().getState());
            assertEquals("Los Angeles",d.getAddress().getCity());
            assertEquals("United States",d.getAddress().getCountry());
            assertEquals("1234 Lakeshore",d.getAddress().getStreet());
            assertEquals(80856,d.getAddress().getZip());
            
        }
       Tx.begin();
        
        List<UserDetails> delUser = em.createQuery("select d from UserDetails d").getResultList();
        for(UserDetails del : delUser)
        {
            em.remove(del);
        }
        
       List<UserDetails> user = em.createQuery("select d from UserDetails d").getResultList();
        List<MembershipDetails> memDetails = em.createQuery("select d from MembershipDetails d").getResultList();
        
        for(MembershipDetails mDetail : memDetails)
        {
            System.out.println(""+mDetail.toString());
            em.remove(mDetail);
            
            List<MembershipDetails> member = em.createQuery("select d from MembershipDetails d").getResultList();
            
            assertTrue(user.isEmpty());
            assertTrue(member.isEmpty());
            
            Tx.commit();
            
        }
    }
    
}
