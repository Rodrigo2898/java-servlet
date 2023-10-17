package br.com.rodrigofeitosa;

import br.com.rodrigofeitosa.entity.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program {
    /*public static void main(String[] args) {
        Pessoa p1 = new Pessoa(null, "Rodrigo Feitosa", "rodrigo@gmail.com");
        Pessoa p2 = new Pessoa(null, "Vanessa", "vanessa@gmail.com");
        Pessoa p3 = new Pessoa(null, "Son Gohan", "gohan@gmail.com");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("servlet-youtube");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit();
        System.out.println("Pronto");
    }*/
}
