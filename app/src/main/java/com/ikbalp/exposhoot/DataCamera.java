package com.ikbalp.exposhoot;

public class DataCamera {
    // Model Class
    String type;
    String spek;
    String img;
    String harga;

    // Constructor
    public DataCamera() {

    }

    public DataCamera(String type, String spek, String img, String harga) {
        this.type = type;
        this.spek = spek;
        this.img = img;
        this.harga = harga;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpek() {
        return spek;
    }

    public void setSpek(String spek) {
        this.spek = spek;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}






