package util;

import model.Antrenor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AntrenorIslemleri {

    public static List<Antrenor> getAntrenorler() {
        List<Antrenor> liste = new ArrayList<>();

        String sql = "SELECT * FROM antrenor";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Antrenor a = new Antrenor(
                        rs.getInt("id"),
                        rs.getString("ad"),
                        rs.getString("uzmanlik")
                );
                liste.add(a);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return liste;
    }
}
