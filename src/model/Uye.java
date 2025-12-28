package model;

import java.time.LocalDate;

public class Uye extends Kisi implements Hesaplanabilir {

    private String telefon;
    private String email;
    private int boy;
    private int kilo;
    private int yas;
    private int paketAy;
    private boolean ogrenciMi;
    private Antrenor antrenor;
    private LocalDate kayitTarihi;



    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBoy() {
        return boy;
    }

    public void setBoy(int boy) {
        this.boy = boy;
    }

    public int getKilo() {
        return kilo;
    }

    public void setKilo(int kilo) {
        this.kilo = kilo;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public int getPaketAy() {
        return paketAy;
    }

    public void setPaketAy(int paketAy) {
        this.paketAy = paketAy;
    }

    public boolean isOgrenciMi() {
        return ogrenciMi;
    }

    public void setOgrenciMi(boolean ogrenciMi) {
        this.ogrenciMi = ogrenciMi;
    }

    public Antrenor getAntrenor() {
        return antrenor;
    }

    public void setAntrenor(Antrenor antrenor) {
        this.antrenor = antrenor;
    }

    public LocalDate getKayitTarihi() {
        return kayitTarihi;
    }

    public void setKayitTarihi(LocalDate kayitTarihi) {
        this.kayitTarihi = kayitTarihi;
    }

  

    @Override
    public double fiyatHesapla() {
        double fiyat = paketAy * 500;
        if (ogrenciMi) {
            fiyat *= 0.8; 
        }
        return fiyat;
    }

    public double bmiHesapla() {
        return kilo / Math.pow(boy / 100.0, 2);
    }

    public double proteinHesapla() {
        return kilo * 1.8;
    }

    public double karbonhidratHesapla() {
        return kilo * 4;
    }

    public double yagHesapla() {
        return kilo * 1;
    }
}
