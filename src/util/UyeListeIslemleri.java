package util;

import java.sql.*;
import java.util.Vector;

public class UyeListeIslemleri {

    public static Vector<Vector<Object>> getUyeListesi() {
        Vector<Vector<Object>> data = new Vector<>();

        String sql = """
            SELECT u.ad, u.soyad, u.boy, u.kilo, u.yas,
                   u.paket_ay, u.paket_fiyat,
                   a.ad AS antrenor
            FROM uye u
            LEFT JOIN antrenor a ON u.antrenor_id = a.id
        """;

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                int boy = rs.getInt("boy");
                int kilo = rs.getInt("kilo");

                double bmi = kilo / Math.pow(boy / 100.0, 2);
                String durum;
                if (bmi < 18.5)
                	durum = "Zayıf";
                else if (bmi < 25)
                	durum = "Normal";
                else {
					durum = "Obez";
				}
                double protein = kilo * 1.8;
                double karbonhidrat = kilo * 4;
                double yag = kilo * 1;
                row.add(rs.getString("ad"));
                row.add(rs.getString("soyad"));
                row.add(rs.getInt("boy"));
                row.add(rs.getInt("kilo"));
                row.add(rs.getInt("yas"));
                row.add(rs.getInt("paket_ay"));
                row.add(rs.getDouble("paket_fiyat"));
                row.add(rs.getString("antrenor"));
                row.add(durum);
                row.add(String.format("%.1f", protein));
                row.add(String.format("%.1f", karbonhidrat));
                row.add(String.format("%.1f", yag));
                
                data.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}
