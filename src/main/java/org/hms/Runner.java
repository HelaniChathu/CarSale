package org.hms;

import org.hms.orm.dao.DaoCar;
import org.hms.orm.dao.DaoWheel;
import org.hms.orm.dao.impl.ImpDaoCar;
import org.hms.orm.dao.impl.ImpDaoWheel;
import org.hms.orm.model.BreakPad;
import org.hms.orm.model.Car;
import org.hms.orm.model.Wheel;
import org.hms.service.CarService;
import org.hms.service.WheelService;
import org.hms.util.HibernateUtil;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by helani on 9/26/14.
 */
public class Runner {
    public static void main(String[] args) {
        Car c = saveCar("EK5m","Toyota","22");
        saveWheel("Acede",33, c);
        updateCar(1l,"TATA");
        updateWheel(2l,"Squre2",23, c);
//        findByName("EK5m");
//        findByWName("Squre2");
//        findCarListByMake("Toyota");
//        findWheelsOfTheCar(52l);
//        findBreakPadListOfTheCar(8l);

        HibernateUtil.shutdown();
    }

    private static Car saveCar(String name,String make,String cc){
        Car car=new Car(name,make,cc);
//        DaoCar daoCar=new ImpDaoCar();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        CarService carService = (CarService) context.getBean("carService");
        carService.save(car);
        context.close();
        /////////////////////////////////////////////////////////////////////////////
//        String carName;
/*        Wheel w1 = new Wheel(name+"_FR", 22l); w1.setCar(car);
        Wheel w2 = new Wheel(name+"_FL", 22l); w2.setCar(car);
        Wheel w3 = new Wheel(name+"_RR", 22l); w3.setCar(car);
        Wheel w4 = new Wheel(name+"_RL", 22l); w4.setCar(car);

        car.getWheelList().add(w1);
        car.getWheelList().add(w2);
        car.getWheelList().add(w3);
        car.getWheelList().add(w4);


        BreakPad b1 = new BreakPad(w1.getBreakPadList().+"_B"); b1.setWheel(w1);
        BreakPad b2 = new BreakPad(w2.getName()+"_B"); b2.setWheel(w2);
        BreakPad b3 = new BreakPad(w3.getName()+"_B"); b3.setWheel(w3);
        BreakPad b4 = new BreakPad(w4.getName()+"_B"); b4.setWheel(w4);

        w1.getBreakPads().add(b1);
        w2.getBreakPads().add(b2);
        w3.getBreakPads().add(b3);
        w4.getBreakPads().add(b4);*/
        ////////////////////////////////////////////////////////////////////////////

        return car;
    }
    private static void saveWheel(String name, int size, Car c){
        Wheel wheel=new Wheel(name,size);
        wheel.setCar(c);

        BreakPad b1 = new BreakPad();
        b1.setBpName(wheel.getWheelName()+"_B");
        b1.setWheel(wheel);
        wheel.getBreakPadList().add(b1);


//        DaoWheel daoWheel=new ImpDaoWheel();
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
        WheelService wheelService=(WheelService)context.getBean("wheelService");
        wheelService.save(wheel);
        context.close();
//        return wheel;
//        daoWheel.saveWheel(wheel);
    }
    private static void updateCar(Long id,String name){
        Car car=new Car();
//        DaoCar daoCar=new ImpDaoCar();
//        car.setId(id);
//        car.setCarName(name);
//        daoCar.update(car);
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
        CarService carService=(CarService) context.getBean("carService");
        carService.update(car);
        context.close();
    }
    private static void updateWheel(Long id, String name, Integer size, Car car){
        Wheel wheel=new Wheel();
        DaoWheel daoWheel=new ImpDaoWheel();
        wheel.setId(id);
        wheel.setWheelName(name);
        wheel.setSize(size);
        wheel.setCar(car);
        daoWheel.updateWheel(wheel);
    }
    private static void findByName(String name){
        DaoCar daocar=new ImpDaoCar();
        Car car=daocar.findByName(name);
        System.out.println("Car Id: "+car.getId());
    }
    private static void findByWName(String name){
        DaoWheel daoWheel=new ImpDaoWheel();
        Wheel wheel=daoWheel.findByName(name);
        System.out.println("Wheel Id: "+wheel.getId());
    }
    private static void findCarListByMake(String make){
        DaoCar daoCar=new ImpDaoCar();
        List<Car> carList=daoCar.findCarListByMake(make);
        for(int i=0;i<carList.size();i++){
            System.out.println(carList.get(i).getMake() +i+" = "+carList.get(i).getCarName()+"\tID:"+carList.get(i).getId());
        }
//        for(Car c : carList){
//            System.out.println(c.getMake());
//        }
//        System.out.println(make+" makes cars which got the IDs: "+car.getId());
    }
    private static void findWheelsOfTheCar(Long id){
        DaoWheel daoWheel=new ImpDaoWheel();
        List<Wheel> wheelList=daoWheel.findWheelsOfTheCar(id);
        for(Wheel w : wheelList){
            System.out.println("Wheel ID: "+w.getId());
        }
    }
    private static void findBreakPadListOfTheCar(Long id){
        DaoWheel daoWheel=new ImpDaoWheel();
        List<BreakPad> breakPadList=daoWheel.findBreakPadListOfTheCar(id);
        for(BreakPad bl : breakPadList){
            System.out.println("BreakPad: "+bl.getBpName());
        }
    }


}

