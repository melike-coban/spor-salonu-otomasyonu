package gui;

import javax.swing.*;

public class WelcomeEkrani extends JFrame {

    public WelcomeEkrani() {
        setTitle("Spor Salonu Otomasyonu");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblBaslik = new JLabel("MEBEYİR SPOR SALONUNA HOŞGELDİNİZ!", SwingConstants.CENTER);
        lblBaslik.setFont(lblBaslik.getFont().deriveFont(16f));

        JButton btnDevam = new JButton("Devam Et");

        btnDevam.addActionListener(e -> {
            new UyeKayitEkrani().setVisible(true);
            dispose(); 
        });

        setLayout(new java.awt.BorderLayout());
        add(lblBaslik, java.awt.BorderLayout.CENTER);
        add(btnDevam, java.awt.BorderLayout.SOUTH);
    }
}
