package gui;

import javax.swing.*;
import java.util.Vector;
import util.UyeListeIslemleri;

public class UyeListeEkrani extends JFrame {

    public UyeListeEkrani() {
        setTitle("Üye Listesi");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Vector<String> columns = new Vector<>();
        columns.add("Ad");
        columns.add("Soyad");
        columns.add("Boy");
        columns.add("Kilo");
        columns.add("Yaş");
        columns.add("Paket (Ay)");
        columns.add("Fiyat");
        columns.add("Antrenör");
        columns.add("Vücut Durumu");
        columns.add("Protein (g)");
        columns.add("Karbonhidrat (g)");
        columns.add("Yağ (g)");
        Vector<Vector<Object>> data = UyeListeIslemleri.getUyeListesi();

        JTable table = new JTable(data, columns);
        add(new JScrollPane(table));
    }
}