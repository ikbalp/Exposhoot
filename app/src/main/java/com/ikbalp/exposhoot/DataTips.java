package com.ikbalp.exposhoot;

public class DataTips {

    // model Class
     String judul;
     String image;
     String desc;

    public DataTips(String judul, String image, String desc) {
        this.judul = judul;
        this.image = image;
        this.desc = desc;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public DataTips()
    {

    }
}



