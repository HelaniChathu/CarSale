package org.hms.orm.dao;

import org.hms.orm.model.Car;

import java.util.List;

/**
 * Created by helani on 9/26/14.
 */
public interface DaoCar {
    Long save(Car car);
    Long update(Car car);
    Car findByName(String name);
    List<Car> findCarListByMake(String make);
}

