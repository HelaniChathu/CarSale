package org.hms.orm.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by helani on 9/26/14.
 */
@Entity
@Table(name="Wheel")
public class Wheel implements java.io.Serializable{
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;
    @Column(name="wheel_name")
    private String wheelName;
    @Column(name="size")
    private Integer size;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "wheel")
    List<BreakPad> breakPadList=new ArrayList<BreakPad>();

    public Wheel() {
    }
    public Wheel(String wheelName, Integer size) {
        this.wheelName = wheelName;
        this.size = size;
    }

    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getWheelName() {
        return wheelName;
    }
    public void setWheelName(String wheelName) {
        this.wheelName = wheelName;
    }

    public Integer getSize() {
        return size;
    }
    public void setSize(Integer size) {
        this.size = size;
    }

    public List<BreakPad> getBreakPadList() {
        return breakPadList;
    }
    public void setBreakPadList(List<BreakPad> breakPadList) {
        this.breakPadList = breakPadList;
    }
}
