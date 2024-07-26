package lk.ijse.dep12.jpa.relationships;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.relationships.entity.*;
import lk.ijse.dep12.jpa.relationships.entity.Module;
import lk.ijse.dep12.jpa.relationships.util.JpaUtil;

import java.util.List;

public class StudentManagementDemo1 {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();

                /* Save Modules */
                Module m001 = new Module("M001", "Programming Fundamentals", 2, Module.Type.Mandatory);
                Module m002 = new Module("M002", "Object Oriented Programming", 3, Module.Type.Mandatory);
                Module m003 = new Module("M003", "Database Systems", 1, Module.Type.Mandatory);
                Module m004 = new Module("M004", "Web Development", 2, Module.Type.Optional);
                Module m005 = new Module("M005", "Robotics and Autonomous Systems", 2, Module.Type.Optional);
                Module m006 = new Module("M006", "AI-Driven Software Development", 2, Module.Type.Optional);

                /* Save Students */
                Student tharindu = new Student("123456789V", "Tharindu Rukshan", "Galle");
                Student buddika = new Student("987654321V", "Buddhika Sandakelum", "Bandarawela");
                Student ravindya = new Student("543216789V", "Ravindya Jayasooriya", "Gampaha");
                Student kavindu = new Student("678954321V", "Kavindu Dilanka", "Pugoda");
                Student kasun = new Student("937863796V", "Kasun Sampath", "Panadura");

                /* Save Student's contacts */
                Contact kavindu1 = new Contact(kavindu, "071-1234567");
                Contact kavindu2 = new Contact(kavindu, "072-1234567");
                Contact ravindya1 = new Contact(ravindya, "077-1234567");
                Contact tharindu1 = new Contact(tharindu, "088-1234567");
                Contact kasun1 = new Contact(kasun, "075-1234567");
                Contact kasun2 = new Contact(kasun, "076-1234567");
                Contact kasun3 = new Contact(kasun, "033-1234567");
                Contact buddhika1 = new Contact(buddika, "011-1234567");

                kavindu.getContactList().add(kavindu1);
                kavindu.getContactList().add(kavindu2);
                ravindya.getContactList().add(ravindya1);
                tharindu.getContactList().add(tharindu1);
                kasun.getContactList().add(kasun1);
                kasun.getContactList().add(kasun2);
                kasun.getContactList().add(kasun3);
                buddika.getContactList().add(buddhika1);

                /* Save Users */
                User yasiya = new User("yasithperera", "Yasith Perera", "yasi123");
                User asiri = new User("asiri", "Asiri Sampath", "asiri123");

                /* Save Courses */
                Course dep = new Course("C001", "DEP");
                Course cmjd = new Course("C002", "CMJD");
                Course gdse = new Course("C003", "GDSE");
                Course ai = new Course("C004", "AI");

                List.of(m001,m002,m003,m004,m005,m006,tharindu,buddika,kavindu,ravindya,kasun,
                        kavindu1,kavindu2,ravindya1,tharindu1,kasun1,kasun2,kasun3,buddhika1,
                        yasiya,asiri,dep,cmjd,gdse,ai).forEach(em::persist);

                tx.commit();
            } catch (Throwable t) {
                tx.rollback();
                t.printStackTrace();
            }
        }

    }
}
