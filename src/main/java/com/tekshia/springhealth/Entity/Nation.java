package com.tekshia.springhealth.Entity;

import javax.persistence.*;

@Entity
public class Nation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nation")
    private String nation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
    //Last Nation
    public boolean isSelected(Integer userId){
        if (userId != null) {
            return userId.equals(id);
        }
        return false;
    }
}
