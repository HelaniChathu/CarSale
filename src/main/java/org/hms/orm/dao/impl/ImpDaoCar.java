package org.hms.orm.dao.impl;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hms.orm.dao.DaoCar;
import org.hms.orm.model.Car;
import org.hms.util.HibernateUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("daoCar")
public class ImpDaoCar implements DaoCar {

    @Override
    public Long save(Car car) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            session.save(car);

            session.getTransaction().commit();
            return  car.getId();
        }catch (Exception exp){
            return null;
        }finally {
            session.close();
        }

    }
    @Override
    public Long update(Car car) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(car);
            session.getTransaction().commit();
            return car.getId();
        }catch (Exception ex){
            return null;
        }finally {
            session.close();
        }
    }
    @Override
    public Car findByName(String name) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Car car=(Car)session.createCriteria(Car.class)
                    .add(Restrictions.eq("carName",name))
                    .uniqueResult();
            session.getTransaction().commit();
            return car;
        }catch (Exception ex){
            return null;
        }finally {
            session.close();
        }
    }
    @Override
    public List<Car> findCarListByMake(String make) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            List<Car> makerList = (List<Car>) session.createCriteria(Car.class)
                    .add(Restrictions.eq("make", make))
                    .list();
            session.getTransaction().commit();
            return makerList;
        }catch (Exception ex){
            return null;
        }finally {
            session.close();
        }
    }
}
