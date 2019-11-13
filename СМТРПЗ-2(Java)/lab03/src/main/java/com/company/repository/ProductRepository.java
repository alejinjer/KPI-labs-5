package com.company.repository;

import com.company.entity.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProductRepository {
    @PersistenceContext
    public EntityManager em;

    public Product add(Product Product) {
        em.getTransaction().begin();
        Product ProductFromDB = em.merge(Product);
        em.getTransaction().commit();
        return ProductFromDB;
    }

    public void delete(int id){
        em.getTransaction().begin();
        em.remove(findById(id));
        em.getTransaction().commit();
    }

    public Product findById(int id){
        return em.find(Product.class, id);
    }

    public void update(Product Product){
        em.getTransaction().begin();
        em.merge(Product);
        em.getTransaction().commit();
    }

    public List<Product> findAll(){
        return em.createQuery("SELECT p from Product p", Product.class)
                .getResultList();
    }
}
