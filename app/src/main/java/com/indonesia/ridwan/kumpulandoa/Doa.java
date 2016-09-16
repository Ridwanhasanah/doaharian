package com.indonesia.ridwan.kumpulandoa;

/**
 * Created by hasanah on 9/16/16.
 */
public class Doa {
    public int doaId;
    public String doaTitle = "";
    public String doaIsi = "";
    public String doaArti = "";
    public String doaKet = "";

    public int getDoaId (){
        return this.doaId;
    }

    public String getDoaIsi(){
        return this.doaIsi;
    }

    public String getDoaTitle(){
        return this.doaTitle;
    }

    public String getDoaArti (){
        return this.doaArti;
    }

    public String getDoaKet(){
        return this.doaKet;
    }

    public void setDoaId(int doaId){
        this.doaId = doaId;
    }

    public void setDoaTitle(String doaTitle){
        this.doaTitle=doaTitle;
    }

    public void setDoaIsi(String doaIsi){
        this.doaIsi=doaIsi;
    }

    public void setDoaArti(String doaArti){
        this.doaArti = doaArti;
    }

    public void setDoaKet (String doaKet){
        this.doaArti = doaArti;
    }
}
