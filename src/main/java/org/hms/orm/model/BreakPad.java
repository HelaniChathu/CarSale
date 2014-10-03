package org.hms.orm.model;

import javax.persistence.*;

/**
 * Created by helani on 9/26/14.
 */
@Entity
@Table(name="breakpad")
public class BreakPad implements java.io.Serializable{
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;
    @Column(name="bp_name")
    private String bpName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wheel_id" ,nullable = false)
    private Wheel wheel;

    public Wheel getWheel() {
        return wheel;
    }
    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getBpName() {
        return bpName;
    }
    public void setBpName(String bpName) {
        this.bpName = bpName;
    }
}
