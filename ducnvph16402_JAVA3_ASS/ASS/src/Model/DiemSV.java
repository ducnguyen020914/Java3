/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author 84985
 */
public class DiemSV {
   private String maSV;
   private float tiengAnh;
   private float tinHoc;
   private float GDTC;
   private String hoTen;

    public DiemSV() {
    }

    public DiemSV(String maSV, float tiengAnh, float tinHoc, float GDTC, String hoTen) {
        this.maSV = maSV;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.GDTC = GDTC;
       
        this.hoTen = hoTen;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

   

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public float getTiengAnh() {
        return tiengAnh;
    }

    public void setTiengAnh(float tiengAnh) {
        this.tiengAnh = tiengAnh;
    }

    public float getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(float tinHoc) {
        this.tinHoc = tinHoc;
    }

    public float getGDTC() {
        return GDTC;
    }

    public void setGDTC(float GDTC) {
        this.GDTC = GDTC;
    }    
    public float getmark(float tiengAnh,float tinHoc,float GDTC){
        return (tiengAnh + tinHoc + GDTC)/3;
    }
}
