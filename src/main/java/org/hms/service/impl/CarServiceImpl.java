package org.hms.service.impl;

import org.hms.orm.dao.DaoCar;
import org.hms.orm.model.Car;
import org.hms.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by helani on 9/29/14.
 */
@Service("carService")
public class CarServiceImpl implements CarService {
    @Autowired
    private DaoCar daoCar;

    @Override
    public void save(Car car) {
       daoCar.save(car);
    }

    @Override
    public void update(Car car) {
        daoCar.update(car);
    }
}
