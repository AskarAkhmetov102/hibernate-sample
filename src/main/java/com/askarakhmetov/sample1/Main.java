package com.askarakhmetov.sample1;

import com.askarakhmetov.sample1.entity.Car;
import com.askarakhmetov.sample1.entity.Engine;
import com.askarakhmetov.sample1.entity.Glass;
import com.askarakhmetov.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

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
                    .glasses(List.of(
                            Glass.builder().number(HibernateUtil.generateAlphanumericStr(9)).build(),
                            Glass.builder().number(HibernateUtil.generateAlphanumericStr(9)).build(),
                            Glass.builder().number(HibernateUtil.generateAlphanumericStr(9)).build(),
                            Glass.builder().number(HibernateUtil.generateAlphanumericStr(9)).build()
                    ))
                    .build();

            session.persist(car);

            session.getTransaction().commit();
        }
    }
}