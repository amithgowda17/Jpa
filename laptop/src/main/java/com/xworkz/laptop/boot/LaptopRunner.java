package com.xworkz.laptop.boot;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.laptop.entity.LaptopEntity;

public class LaptopRunner {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {

			entityTransaction.begin();

			LaptopEntity entity = new LaptopEntity();

			entity.setId(1);
			entity.setLaptopName("dell");
			entity.setAddress("Bengaluru");

			entityManager.persist(entity);

			entityTransaction.commit();

		} catch (Exception e) {

			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
			e.printStackTrace();
		} finally {

			entityManager.close();
			entityManagerFactory.close();
		}
	}

}
