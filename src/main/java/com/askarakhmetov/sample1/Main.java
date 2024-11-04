package com.askarakhmetov.sample1;

import com.askarakhmetov.sample1.entity.Car;
import com.askarakhmetov.sample1.entity.Engine;
import com.askarakhmetov.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Sample of using Embeddable class
 */
public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration()
                .addAnnotatedClass(Car.class);
        try (SessionFactory sessionFactory = config.buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            Car car = Car.builder()
                    .vin(HibernateUtil.generateAlphanumericStr(9))
                    .color("White")
                    .brandName("KIA")
                    .modelName("Ceed")
                    .engine(Engine.builder()
                            .number(HibernateUtil.generateAlphanumericStr(9))
                            .horsePower(128)
                            .build())
                    .build();

            session.persist(car);

            session.getTransaction().commit();
        }
    }
}