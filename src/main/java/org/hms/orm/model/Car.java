package org.hms.orm.model;

import javax.persistence.*;
//import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by helani on 9/26/14.
 */
@Entity
@Table(name="Car")
public class Car implements java.io.Serializable{
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;
    @Column(name="car_name")
    private String carName;
    @Column(name="make")
    private String make;
    @Column(name="engine_cc")
    private String engineCC;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
    List<Wheel> wheelList=new ArrayList<Wheel>();

    public Car() {
    }
    public Car(String carName, String make, String engineCC) {
        this.carName = carName;
        this.make = make;
        this.engineCC = engineCC;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }
    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }

    public String getEngineCC() {
        return engineCC;
    }
    public void setEngineCC(String engineCC) {
        this.engineCC = engineCC;
    }

    public List<Wheel> getWheelList() {
        return wheelList;
    }
    public void setWheelList(List<Wheel> wheelList) {
        this.wheelList = wheelList;
    }
}
