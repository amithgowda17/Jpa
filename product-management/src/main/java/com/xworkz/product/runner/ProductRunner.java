package com.xworkz.product.runner;

import com.xworkz.product.dao.Product;
import com.xworkz.product.dao.ProductImpl;
import com.xworkz.product.entity.ProductDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductRunner {

    public static void main(String[] args) {

        ProductDto productDto=new ProductDto();
        Product product=new ProductImpl();
        product.addProduct(productDto);

        Configuration configuration= new Configuration();
        configuration.addAnnotatedClass(ProductDto.class);
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(productDto);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
