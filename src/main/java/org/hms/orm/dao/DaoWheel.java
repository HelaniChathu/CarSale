package org.hms.orm.dao;

import org.hms.orm.model.BreakPad;
import org.hms.orm.model.Wheel;

import java.util.List;

/**
 * Created by helani on 9/26/14.
 */
public interface DaoWheel {
    Long saveWheel(Wheel wheel);
    Long updateWheel(Wheel wheel);
    Wheel findByName(String name);
    List<Wheel> findWheelsOfTheCar(Long id);
    List<BreakPad> findBreakPadListOfTheCar(Long id);
}
