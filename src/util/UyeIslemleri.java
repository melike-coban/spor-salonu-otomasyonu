package util;

import model.Uye;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class UyeIslemleri {

    public static void uyeEkle(Uye u) {

        String sql = "INSERT INTO uye(ad, soyad, telefon, email, boy, kilo, yas, paket_ay, paket_fiyat, ogrenci_mi, antrenor_id, kayit_tarihi) " +
                     "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, u.getAd());
            ps.setString(2, u.getSoyad());
            ps.setString(3, u.getTelefon());
            ps.setString(4, u.getEmail());
            ps.setInt(5, u.getBoy());
            ps.setInt(6, u.getKilo());
            ps.setInt(7, u.getYas());
            ps.setInt(8, u.getPaketAy());
            ps.setDouble(9, u.fiyatHesapla());
            ps.setBoolean(10, u.isOgrenciMi());
            ps.setInt(11, u.getAntrenor().getId());
            ps.setDate(12, java.sql.Date.valueOf(LocalDate.now()));

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
