package lk.ijse.dep12.jpa.relationships;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.relationships.entity.Module;
import lk.ijse.dep12.jpa.relationships.entity.*;
import lk.ijse.dep12.jpa.relationships.util.JpaUtil;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class StudentManagementDemo2 {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();

                /* Find Modules */
                Module m001 = em.find(Module.class,"M001");
                Module m002 =  em.find(Module.class,"M002");
                Module m003 =  em.find(Module.class,"M003");
                Module m004 =  em.find(Module.class,"M004");
                Module m005 =  em.find(Module.class,"M005");
                Module m006 =  em.find(Module.class,"M006");


                /* Find Courses */
                Course dep = em.find(Course.class,"C001");
                Course cmjd = em.find(Course.class,"C002");
                Course gdse = em.find(Course.class,"C003");
                Course ai = em.find(Course.class,"C004");

                /* Save Batch */
                Batch dep12 = new Batch("B001", dep, "6 Months", new BigDecimal("200000"));
                Batch cmjd300 = new Batch("CMJD0300", cmjd, "12 Months", new BigDecimal("80000"));
                Batch cmjd301 = new Batch("CMJD0301", cmjd, "12 Months", new BigDecimal("80000"));
                Batch ai1 = new Batch("AI1", ai, "4 Years", new BigDecimal("500000"));
                Batch gdse81 = new Batch("GDSE0081", gdse, "2 Years", new BigDecimal("400000"));

                /* Save Course-Module */
                CourseModule cm1 = new CourseModule(dep, m001);
                CourseModule cm2 = new CourseModule(dep, m002);
                CourseModule cm3 = new CourseModule(dep, m004);

                CourseModule cm4 = new CourseModule(cmjd, m001);
                CourseModule cm5 = new CourseModule(cmjd, m002);

                CourseModule cm6 = new CourseModule(gdse, m001);
                CourseModule cm7 = new CourseModule(gdse, m002);
                CourseModule cm8 = new CourseModule(gdse, m003);
                CourseModule cm9 = new CourseModule(gdse, m004);

                CourseModule cm10 = new CourseModule(ai, m005);
                CourseModule cm11 = new CourseModule(ai, m006);
                CourseModule cm12 = new CourseModule(ai, m002);

                List.of(dep12,cmjd300,cmjd301,ai1,gdse81,cm1,cm2,cm3,cm4,cm5,cm6,cm7,cm8,cm9,cm10,cm11,cm12).forEach(em::persist);


                tx.commit();
            } catch (Throwable t) {
                tx.rollback();
                t.printStackTrace();
            }
        }

    }
}
