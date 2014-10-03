package org.hms.service;

import org.hms.orm.model.Car;


/**
 * Created by helani on 9/29/14.
 */
public interface CarService {
    void save(Car car);
    void update(Car car);
}
