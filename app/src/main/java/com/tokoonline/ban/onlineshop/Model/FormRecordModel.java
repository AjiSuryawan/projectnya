package com.tokoonline.ban.onlineshop.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class FormRecordModel extends RealmObject {

    @PrimaryKey
    private String id;
    private String meteran;
    private String imagePath;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMeteran() {
        return meteran;
    }

    public void setMeteran(String meteran) {
        this.meteran = meteran;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
