package org.hms.service.impl;

import org.hms.orm.dao.DaoWheel;
import org.hms.orm.model.Wheel;
import org.hms.service.WheelService;

/**
 * Created by helani on 9/29/14.
 */
public class WheelServiceImpl implements WheelService{
    public void setDaoWheel(DaoWheel daoWheel) {
        this.daoWheel = daoWheel;
    }

    private DaoWheel daoWheel;

    @Override
    public void save(Wheel wheel) {
        daoWheel.saveWheel(wheel);
    }
}
