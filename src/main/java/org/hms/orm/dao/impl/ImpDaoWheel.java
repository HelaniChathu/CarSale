package org.hms.orm.dao.impl;

import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hms.orm.dao.DaoWheel;
import org.hms.orm.model.BreakPad;
import org.hms.orm.model.Car;
import org.hms.orm.model.Wheel;
import org.hms.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by helani on 9/26/14.
 */
public class ImpDaoWheel implements DaoWheel {
    @Override
    public Long saveWheel(Wheel wheel) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(wheel);
            session.getTransaction().commit();
            return wheel.getId();
        }catch (Exception ex){
            return null;
        }finally {
            session.close();
        }
    }
    @Override
    public Long updateWheel(Wheel wheel) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(wheel);
            session.getTransaction().commit();
            return wheel.getId();
        }catch (Exception ex){
            return null;
        }finally {
            session.close();
        }
    }
    @Override
    public Wheel findByName(String name) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Wheel wheel=(Wheel)session.createCriteria(Wheel.class)
                    .add(Restrictions.eq("wheelName",name))
                    .uniqueResult();
            session.getTransaction().commit();
            return wheel;
        }catch (Exception ex){
            return null;
        }finally {
            session.close();
        }
    }
    @Override
    public List<Wheel> findWheelsOfTheCar(Long carId) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Car car= (Car) session.createCriteria(Car.class)
                    .add(Restrictions.eq("id",carId))
                    .setFetchMode("wheelList", FetchMode.JOIN)
                    .uniqueResult();
            session.getTransaction().commit();
            return car.getWheelList();
        }catch (Exception ex){
            return null;
        }finally {
            session.close();
        }
    }
    @Override
    public List<BreakPad> findBreakPadListOfTheCar(Long carId){
        Session session=HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Car car=(Car) session.createCriteria(Car.class)
                    .add(Restrictions.eq("id",carId))
                    .setFetchMode("wheelList",FetchMode.JOIN)
                    .setFetchMode("wheelList.breakPadList",FetchMode.JOIN)
                    .uniqueResult();
            session.getTransaction().commit();

            //ANOTHR WAY USING ALIAS
//            Criteria criteria = session.createCriteria(Car.class, "car");
//            criteria.add(Restrictions.eq("id", carId));
//            criteria.createAlias("car.wheels", "wheel");
//            criteria.createAlias("wheel.breakPads", "breakPad");
//            criteria.setFetchMode("car.wheels", FetchMode.JOIN);
//            criteria.setFetchMode("car.wheels.breakPad", FetchMode.JOIN);

            List<BreakPad> breakPadList = new ArrayList<BreakPad>();
            for (Wheel w : car.getWheelList()) {
                breakPadList.addAll(w.getBreakPadList());
            }
            return breakPadList;

        }catch(Exception ex){
            return null;
        }finally {
            session.close();
        }
    }
}
