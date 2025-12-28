package gui;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import model.Antrenor;
import model.Uye;
import util.AntrenorIslemleri;
import util.UyeIslemleri;

public class UyeKayitEkrani extends JFrame {

    JTextField txtAd, txtSoyad, txtTelefon, txtEmail, txtBoy, txtKilo, txtYas;
    JComboBox<String> cmbPaket;
    JCheckBox chkOgrenci;
    JComboBox<Antrenor> cmbAntrenor;
    JButton btnKaydet, btnUyeleriGor;

    public UyeKayitEkrani() {
        setTitle("Spor Salonu - Üye Kayıt");
        setSize(500, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));

        panel.add(new JLabel("Ad:"));
        txtAd = new JTextField();
        panel.add(txtAd);

        panel.add(new JLabel("Soyad:"));
        txtSoyad = new JTextField();
        panel.add(txtSoyad);

        panel.add(new JLabel("Telefon:"));
        txtTelefon = new JTextField();
        panel.add(txtTelefon);

        panel.add(new JLabel("E-posta:"));
        txtEmail = new JTextField();
        panel.add(txtEmail);

        panel.add(new JLabel("Boy (cm):"));
        txtBoy = new JTextField();
        panel.add(txtBoy);

        panel.add(new JLabel("Kilo (kg):"));
        txtKilo = new JTextField();
        panel.add(txtKilo);

        panel.add(new JLabel("Yaş:"));
        txtYas = new JTextField();
        panel.add(txtYas);

        panel.add(new JLabel("Paket Seçimi:"));
        cmbPaket = new JComboBox<>(new String[]{
                "1 Ay - 500 TL",
                "3 Ay - 1400 TL",
                "6 Ay - 2700 TL"
        });
        panel.add(cmbPaket);

        panel.add(new JLabel("Öğrenci mi?"));
        chkOgrenci = new JCheckBox();
        panel.add(chkOgrenci);

        panel.add(new JLabel("Antrenör Seçimi:"));
        cmbAntrenor = new JComboBox<>();
        List<Antrenor> antrenorler = AntrenorIslemleri.getAntrenorler();
        for (Antrenor a : antrenorler) {
            cmbAntrenor.addItem(a);
        }
        panel.add(cmbAntrenor);

        btnKaydet = new JButton("Üye Kaydet");
        btnUyeleriGor = new JButton("Üyeleri Görüntüle");

        panel.add(btnKaydet);
        panel.add(btnUyeleriGor);

        add(panel);

        btnKaydet.addActionListener(e -> {
            try {
                Uye u = new Uye();

                u.setAd(txtAd.getText());
                u.setSoyad(txtSoyad.getText());
                u.setTelefon(txtTelefon.getText());
                u.setEmail(txtEmail.getText());
                u.setBoy(Integer.parseInt(txtBoy.getText()));
                u.setKilo(Integer.parseInt(txtKilo.getText()));
                u.setYas(Integer.parseInt(txtYas.getText()));
                u.setOgrenciMi(chkOgrenci.isSelected());
                u.setAntrenor((Antrenor) cmbAntrenor.getSelectedItem());

                int paketAy = 1;
                if (cmbPaket.getSelectedIndex() == 1) paketAy = 3;
                if (cmbPaket.getSelectedIndex() == 2) paketAy = 6;
                u.setPaketAy(paketAy);

                UyeIslemleri.uyeEkle(u);

                JOptionPane.showMessageDialog(this,
                        "Üye Kaydedildi\nToplam Ücret: " + u.fiyatHesapla() + " TL");

                formTemizle();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Hatalı giriş!");
            }
        });

        // 🔹 ÜYELERİ GÖRÜNTÜLE
        btnUyeleriGor.addActionListener(e -> {
            new UyeListeEkrani().setVisible(true);
        });
    }

    private void formTemizle() {
        txtAd.setText("");
        txtSoyad.setText("");
        txtTelefon.setText("");
        txtEmail.setText("");
        txtBoy.setText("");
        txtKilo.setText("");
        txtYas.setText("");
        chkOgrenci.setSelected(false);
        cmbPaket.setSelectedIndex(0);
        cmbAntrenor.setSelectedIndex(0);
    }
}