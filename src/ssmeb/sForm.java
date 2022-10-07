package ssmeb;

import java.awt.Desktop;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

public class sForm extends javax.swing.JFrame {

    static String url = "jdbc:sqlite:./src/others//ORTACA_MEB.db";

    static Connection conn = null;
    static ResultSet rs = null, rsFoto = null;
    static Statement st = null;
    static boolean ekle = true, aktifim = false;

    static DefaultTableModel modelimMevcut = new DefaultTableModel();
    static Object[] kolonlarMevcut = {"Öğretim Yılı", "Okul Mevcudu", "Değişim Oranı"};
    static Object[] satirlarMevcut = new Object[20];

    static int ek = 0, f = 0;
    private JFrame frame;
    static List listKkodu = new ArrayList<String>();
    static List listKadi = new ArrayList<String>();
    static List lstFotolar = new ArrayList<String>();

    static ImageIcon icon = new ImageIcon("./src/others/jicon.png");

    public sForm() {
        initComponents();
        this.setIconImage(icon.getImage());
        kurumlarAl();
        txtKurumKodu.setText(listKkodu.get(0).toString());
        baglanListele(txtKurumKodu.getText());
        secimCalistir();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSecimGroup = new javax.swing.ButtonGroup();
        prntDialog = new javax.swing.JDialog();
        btnKurumlariYazdir = new javax.swing.JButton();
        rbYazdirFotosuz = new javax.swing.JRadioButton();
        rbYazdirFotolu = new javax.swing.JRadioButton();
        btnYazdirGroup = new javax.swing.ButtonGroup();
        solPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtMerkezeUzakligi = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtOgretmenSayisi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtYuzolcumu = new javax.swing.JTextField();
        txtDerslikSayisi = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtBlokSayisi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtYapimTarihi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtOnarimTarihi = new javax.swing.JTextField();
        btnSonraki = new javax.swing.JButton();
        txtKurumKodu = new javax.swing.JTextField();
        btnOnceki = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbKurumAdi = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbOnarim = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cmbDisBoya = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cmbicBoya = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cmbElektrik = new javax.swing.JComboBox<>();
        cmbSu = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        cmbSuBaskini = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        cmbTuvalet = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cmbCati = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        cmbKapiPencere = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        cmbBahce = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableMevcut = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        btnMevcutSatirEkle = new javax.swing.JButton();
        btnMevcutSatirSil = new javax.swing.JButton();
        sagAltPanel = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDigerSorunlar = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        taSosyolojik = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rbKurum = new javax.swing.JRadioButton();
        rbic = new javax.swing.JRadioButton();
        rbDis = new javax.swing.JRadioButton();
        rbCati = new javax.swing.JRadioButton();
        rbTuvalet = new javax.swing.JRadioButton();
        rbSu = new javax.swing.JRadioButton();
        rbKapiPencere = new javax.swing.JRadioButton();
        rbBahce = new javax.swing.JRadioButton();
        rbSuBaskini = new javax.swing.JRadioButton();
        rbElektrik = new javax.swing.JRadioButton();
        rbKonum = new javax.swing.JRadioButton();
        btnFotoEkle = new javax.swing.JButton();
        btnSonrakiFoto = new javax.swing.JButton();
        lblFoto = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnGuncelle = new javax.swing.JButton();
        btnKayitEkle = new javax.swing.JButton();
        btnSil = new javax.swing.JButton();
        btnYazdir = new javax.swing.JButton();

        prntDialog.setTitle("made by mADEMatik");
        prntDialog.setResizable(false);

        btnKurumlariYazdir.setText("YAZDIR");
        btnKurumlariYazdir.setToolTipText("Kurumları seçtiğiniz şekilde yazdırmak için tıklayınız.");
        btnKurumlariYazdir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKurumlariYazdirActionPerformed(evt);
            }
        });

        btnYazdirGroup.add(rbYazdirFotosuz);
        rbYazdirFotosuz.setSelected(true);
        rbYazdirFotosuz.setText("Tüm Kurumları Yazdır (Fotosuz)");
        rbYazdirFotosuz.setToolTipText("Tüm kurumları fotoğrafsız olarak yazdırmak için tıklayınız.");

        btnYazdirGroup.add(rbYazdirFotolu);
        rbYazdirFotolu.setText("Seçili Kurumu Yazdır (Fotolu)");
        rbYazdirFotolu.setToolTipText("Seçili kurumu fotoğraflı olarak yazdırmak için tıklayınız.");

        javax.swing.GroupLayout prntDialogLayout = new javax.swing.GroupLayout(prntDialog.getContentPane());
        prntDialog.getContentPane().setLayout(prntDialogLayout);
        prntDialogLayout.setHorizontalGroup(
            prntDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prntDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(prntDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKurumlariYazdir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(prntDialogLayout.createSequentialGroup()
                        .addGroup(prntDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rbYazdirFotosuz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbYazdirFotolu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        prntDialogLayout.setVerticalGroup(
            prntDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, prntDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbYazdirFotosuz)
                .addGap(18, 18, 18)
                .addComponent(rbYazdirFotolu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btnKurumlariYazdir)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ORTACA MEB");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("sForm1"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        solPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fiziki Bilgiler", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 10), new java.awt.Color(0, 102, 204))); // NOI18N
        solPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Merkeze Uzaklığı :");
        solPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 110, -1));

        txtMerkezeUzakligi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtMerkezeUzakligi.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtMerkezeUzakligi.setToolTipText("Merkeze Uzaklığı");
        solPanel.add(txtMerkezeUzakligi, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 166, 110, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Öğretmen Sayısı :");
        solPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 110, -1));

        txtOgretmenSayisi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtOgretmenSayisi.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtOgretmenSayisi.setToolTipText("Öğretmen Sayısı");
        solPanel.add(txtOgretmenSayisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 166, 110, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Yüz Ölçümü :");
        solPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 110, -1));

        txtYuzolcumu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtYuzolcumu.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtYuzolcumu.setToolTipText("Yüz Ölçümü");
        solPanel.add(txtYuzolcumu, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 136, 110, -1));

        txtDerslikSayisi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtDerslikSayisi.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDerslikSayisi.setToolTipText("Derslik Sayısı");
        solPanel.add(txtDerslikSayisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 106, 110, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Derslik Sayısı :");
        solPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 110, -1));

        txtBlokSayisi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtBlokSayisi.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtBlokSayisi.setToolTipText("Blok Sayısı");
        solPanel.add(txtBlokSayisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 136, 110, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Blok Sayısı :");
        solPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 110, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Yapım Tarihi :");
        solPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 110, -1));

        txtYapimTarihi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtYapimTarihi.setToolTipText("Yapım Tarihi");
        solPanel.add(txtYapimTarihi, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 76, 110, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Onarım Tarihi :");
        solPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 110, -1));

        txtOnarimTarihi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtOnarimTarihi.setToolTipText("Onarım Tarihi");
        solPanel.add(txtOnarimTarihi, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 106, 110, -1));

        btnSonraki.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSonraki.setIcon(new javax.swing.ImageIcon(getClass().getResource("/others/bSonraki.png"))); // NOI18N
        btnSonraki.setBorder(null);
        btnSonraki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSonrakiActionPerformed(evt);
            }
        });
        solPanel.add(btnSonraki, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 26, 26));

        txtKurumKodu.setEditable(false);
        txtKurumKodu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtKurumKodu.setForeground(new java.awt.Color(255, 51, 51));
        txtKurumKodu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtKurumKodu.setToolTipText("Kurum kodu");
        txtKurumKodu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKurumKoduKeyPressed(evt);
            }
        });
        solPanel.add(txtKurumKodu, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 40, 272, 26));

        btnOnceki.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnOnceki.setIcon(new javax.swing.ImageIcon(getClass().getResource("/others/bOnceki.png"))); // NOI18N
        btnOnceki.setBorder(null);
        btnOnceki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOncekiActionPerformed(evt);
            }
        });
        solPanel.add(btnOnceki, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 26, 26));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Kurum Kodu :");
        solPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 38, 110, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Kurum Adı :");
        solPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 12, 110, 20));

        cmbKurumAdi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbKurumAdi.setToolTipText("Kurum seçiniz.");
        cmbKurumAdi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbKurumAdiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbKurumAdiFocusLost(evt);
            }
        });
        cmbKurumAdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKurumAdiActionPerformed(evt);
            }
        });
        solPanel.add(cmbKurumAdi, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 12, 350, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Onarım Durumu :");
        solPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, -1));

        cmbOnarim.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbOnarim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Yok", "Güçlendirme", "Onarım" }));
        cmbOnarim.setToolTipText("Onarım Durumu");
        solPanel.add(cmbOnarim, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 76, 110, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Dış Boya :");
        solPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 110, -1));

        cmbDisBoya.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbDisBoya.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "İyi", "Kötü" }));
        cmbDisBoya.setToolTipText("Dış Cephe Boyasının Durumu");
        solPanel.add(cmbDisBoya, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 196, 110, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("İç Boya :");
        solPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 110, -1));

        cmbicBoya.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbicBoya.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "İyi", "Kötü" }));
        cmbicBoya.setToolTipText("İç Cephe Boyasının Durumu");
        solPanel.add(cmbicBoya, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 196, 110, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Su Tesisatı :");
        jLabel16.setToolTipText("");
        solPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 110, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Elektrik Tesisatı :");
        solPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 110, -1));

        cmbElektrik.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbElektrik.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "İyi", "Kötü" }));
        cmbElektrik.setToolTipText("Elektrik Tesisatının Durumu");
        solPanel.add(cmbElektrik, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 226, 110, -1));

        cmbSu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbSu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "İyi", "Kötü" }));
        cmbSu.setToolTipText("Su Tesisatının Durumu");
        solPanel.add(cmbSu, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 226, 110, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Su Baskını :");
        solPanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 110, -1));

        cmbSuBaskini.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbSuBaskini.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Yok", "Her zaman su baskını var", "Sadece aşırı yağışlı günlerde var" }));
        cmbSuBaskini.setToolTipText("Su Baskını Durumu");
        solPanel.add(cmbSuBaskini, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 316, 350, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Tuvaletler :");
        solPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 110, -1));

        cmbTuvalet.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbTuvalet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "İyi", "Kötü" }));
        cmbTuvalet.setToolTipText("Tuvaletlerin Durumu");
        solPanel.add(cmbTuvalet, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 256, 110, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Çatı :");
        solPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 110, -1));

        cmbCati.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbCati.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "İyi", "Kötü" }));
        cmbCati.setToolTipText("Çatının Durumu");
        solPanel.add(cmbCati, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 256, 110, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Kapı - Pencere :");
        solPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 110, -1));

        cmbKapiPencere.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbKapiPencere.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "İyi", "Kötü" }));
        cmbKapiPencere.setToolTipText("Kapı - Pencerelerin Durumu");
        solPanel.add(cmbKapiPencere, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 286, 110, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Bahçe :");
        solPanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 110, -1));

        cmbBahce.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbBahce.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "İyi", "Kötü" }));
        cmbBahce.setToolTipText("Bahçenin Durumu");
        solPanel.add(cmbBahce, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 286, 110, -1));

        tableMevcut.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tableMevcut.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Öğretim Yılı", "Okul Mevcudu", "Değişim Oranı"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMevcut.setToolTipText("Mevcutlar Tablosu");
        tableMevcut.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableMevcut.setRowHeight(30);
        tableMevcut.setShowGrid(true);
        tableMevcut.setSurrendersFocusOnKeystroke(true);
        tableMevcut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableMevcutKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(tableMevcut);

        solPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 374, 470, 280));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("YILLARA GÖRE ÖĞRENCİ SAYILARI");
        solPanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 345, 380, 26));

        btnMevcutSatirEkle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/others/bEkle.png"))); // NOI18N
        btnMevcutSatirEkle.setToolTipText("Mevcutlar tablosuna satır eklemek için tıklayınız.");
        btnMevcutSatirEkle.setMaximumSize(new java.awt.Dimension(38, 38));
        btnMevcutSatirEkle.setMinimumSize(new java.awt.Dimension(38, 38));
        btnMevcutSatirEkle.setPreferredSize(new java.awt.Dimension(26, 26));
        btnMevcutSatirEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMevcutSatirEkleActionPerformed(evt);
            }
        });
        solPanel.add(btnMevcutSatirEkle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 345, -1, -1));

        btnMevcutSatirSil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/others/bCikar.png"))); // NOI18N
        btnMevcutSatirSil.setToolTipText("Mevcutlar tablosundan satır silmek için tıklayınız.");
        btnMevcutSatirSil.setPreferredSize(new java.awt.Dimension(26, 26));
        btnMevcutSatirSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMevcutSatirSilActionPerformed(evt);
            }
        });
        solPanel.add(btnMevcutSatirSil, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 345, -1, -1));

        sagAltPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 10), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Diğer Fiziki Sorunlar");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Kurumun Sosyolojik Yapısı");

        taDigerSorunlar.setColumns(20);
        taDigerSorunlar.setLineWrap(true);
        taDigerSorunlar.setRows(3);
        taDigerSorunlar.setToolTipText("Diğer Fiziki Sorunlar");
        taDigerSorunlar.setWrapStyleWord(true);
        jScrollPane1.setViewportView(taDigerSorunlar);

        taSosyolojik.setColumns(20);
        taSosyolojik.setLineWrap(true);
        taSosyolojik.setRows(3);
        taSosyolojik.setToolTipText("Kurumun Sosyolojik Yapısı");
        taSosyolojik.setWrapStyleWord(true);
        jScrollPane4.setViewportView(taSosyolojik);

        javax.swing.GroupLayout sagAltPanelLayout = new javax.swing.GroupLayout(sagAltPanel);
        sagAltPanel.setLayout(sagAltPanelLayout);
        sagAltPanelLayout.setHorizontalGroup(
            sagAltPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sagAltPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sagAltPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(sagAltPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(sagAltPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        sagAltPanelLayout.setVerticalGroup(
            sagAltPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sagAltPanelLayout.createSequentialGroup()
                .addGroup(sagAltPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sagAltPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fotoğraflar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 10), new java.awt.Color(0, 102, 204))); // NOI18N
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);

        btnSecimGroup.add(rbKurum);
        rbKurum.setSelected(true);
        rbKurum.setText("Kurum");
        rbKurum.setToolTipText("Kurum fotoğrafları için seçiniz.");
        rbKurum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbKurumActionPerformed(evt);
            }
        });

        btnSecimGroup.add(rbic);
        rbic.setText("İç Cephe");
        rbic.setToolTipText("İç cephe fotoğrafları için seçiniz.");
        rbic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbicActionPerformed(evt);
            }
        });

        btnSecimGroup.add(rbDis);
        rbDis.setText("Dış Cephe");
        rbDis.setToolTipText("Dış cephe fotoğrafları için seçiniz.");
        rbDis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDisActionPerformed(evt);
            }
        });

        btnSecimGroup.add(rbCati);
        rbCati.setText("Çatı");
        rbCati.setToolTipText("Çatı fotoğrafları için seçiniz.");
        rbCati.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCatiActionPerformed(evt);
            }
        });

        btnSecimGroup.add(rbTuvalet);
        rbTuvalet.setText("Tuvalet");
        rbTuvalet.setToolTipText("Tuvalet fotoğrafları için seçiniz.");
        rbTuvalet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTuvaletActionPerformed(evt);
            }
        });

        btnSecimGroup.add(rbSu);
        rbSu.setText("Su");
        rbSu.setToolTipText("Su tesisatı fotoğrafları için seçiniz.");
        rbSu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSuActionPerformed(evt);
            }
        });

        btnSecimGroup.add(rbKapiPencere);
        rbKapiPencere.setText("Kapı Pencere");
        rbKapiPencere.setToolTipText("Kapı ve pencere fotoğrafları için seçiniz.");
        rbKapiPencere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbKapiPencereActionPerformed(evt);
            }
        });

        btnSecimGroup.add(rbBahce);
        rbBahce.setText("Bahçe");
        rbBahce.setToolTipText("Bahçe fotoğrafları için seçiniz.");
        rbBahce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbBahceActionPerformed(evt);
            }
        });

        btnSecimGroup.add(rbSuBaskini);
        rbSuBaskini.setText("Su Baskını");
        rbSuBaskini.setToolTipText("Su baskını fotoğrafları için seçiniz.");
        rbSuBaskini.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSuBaskiniActionPerformed(evt);
            }
        });

        btnSecimGroup.add(rbElektrik);
        rbElektrik.setText("Elektrik");
        rbElektrik.setToolTipText("Elektrik tesisatı fotoğrafları için seçiniz.");
        rbElektrik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbElektrikActionPerformed(evt);
            }
        });

        btnSecimGroup.add(rbKonum);
        rbKonum.setText("Konum");
        rbKonum.setToolTipText("Konum fotoğrafları için seçiniz.");
        rbKonum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbKonumActionPerformed(evt);
            }
        });

        btnFotoEkle.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFotoEkle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/others/bEkle.png"))); // NOI18N
        btnFotoEkle.setToolTipText("Seçilen türde fotoğraf eklemek için tıklayınız. İptal ederseniz o türdeki bütün fotoğraflar silinir.");
        btnFotoEkle.setBorder(null);
        btnFotoEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFotoEkleActionPerformed(evt);
            }
        });

        btnSonrakiFoto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSonrakiFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/others/bSonraki.png"))); // NOI18N
        btnSonrakiFoto.setToolTipText("Seçilen türdeki fotoğrafları sıra ile göstermek için tıklayınız.");
        btnSonrakiFoto.setBorder(null);
        btnSonrakiFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSonrakiFotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbElektrik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbSuBaskini, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbBahce, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbKapiPencere, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbSu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbTuvalet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbCati, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbDis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbKurum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbKonum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFotoEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSonrakiFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbKurum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbic)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbDis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbCati)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbTuvalet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbSu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbKapiPencere)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbBahce)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbSuBaskini)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbElektrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbKonum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFotoEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSonrakiFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Kurum Fotoğrafı - 1", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 10), new java.awt.Color(0, 102, 204))); // NOI18N
        lblFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFotoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuncelle.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuncelle.setText("Güncelle");
        btnGuncelle.setToolTipText("Görüntülenen kaydı güncellemek için tıklayınız.");
        btnGuncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuncelleActionPerformed(evt);
            }
        });
        jPanel3.add(btnGuncelle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, -1));

        btnKayitEkle.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKayitEkle.setText("Yeni Kayıt");
        btnKayitEkle.setToolTipText("Yeni kayıt eklemek için tıklayınız. Sadece kurum adı ve kurum kodu girmeniz yeterlidir.");
        btnKayitEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKayitEkleActionPerformed(evt);
            }
        });
        jPanel3.add(btnKayitEkle, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 100, -1));

        btnSil.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSil.setText("Sil");
        btnSil.setToolTipText("Görüntülenen kaydı silmek için tıklayınız.");
        btnSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSilActionPerformed(evt);
            }
        });
        jPanel3.add(btnSil, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 100, -1));

        btnYazdir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnYazdir.setText("Yazdır");
        btnYazdir.setToolTipText("Kurumları yazdırmak için tıklayınız.");
        btnYazdir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYazdirActionPerformed(evt);
            }
        });
        jPanel3.add(btnYazdir, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 100, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(solPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sagAltPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sagAltPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(solPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void btnOncekiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOncekiActionPerformed
        ek = 0;
        kurumlarAl();
        if (txtKurumKodu.getText().equals("")) {
            txtKurumKodu.setText(listKkodu.get(listKkodu.size() - 1).toString());
        } else {
            if (f == 0) {
                f = listKkodu.size() - 1;
                txtKurumKodu.setText(listKkodu.get(f).toString());
            } else {
                f--;
                txtKurumKodu.setText(listKkodu.get(f).toString());
            }
            baglanListele(txtKurumKodu.getText());
        }
        rbKurum.setSelected(true);
        baglanListele(txtKurumKodu.getText());
        secimCalistir();
    }//GEN-LAST:event_btnOncekiActionPerformed
    private void btnSonrakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSonrakiActionPerformed
        ek = 0;
        kurumlarAl();
        if (txtKurumKodu.getText().equals("")) {
            txtKurumKodu.setText(listKkodu.get(0).toString());
        } else {
            if (f == listKkodu.size() - 1) {
                f = 0;
                txtKurumKodu.setText(listKkodu.get(f).toString());
            } else {
                f++;
                txtKurumKodu.setText(listKkodu.get(f).toString());
            }
        }
        rbKurum.setSelected(true);
        baglanListele(txtKurumKodu.getText());
        secimCalistir();
    }//GEN-LAST:event_btnSonrakiActionPerformed
    private void btnMevcutSatirSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMevcutSatirSilActionPerformed
        if (tableMevcut.getSelectedRowCount() > 0) {
            modelimMevcut.removeRow(tableMevcut.getSelectedRow());
            tableMevcut.setModel(modelimMevcut);
        }
    }//GEN-LAST:event_btnMevcutSatirSilActionPerformed
    private void btnMevcutSatirEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMevcutSatirEkleActionPerformed
        modelimMevcut.addRow(new Object[]{"", ""});
        tableMevcut.setModel(modelimMevcut);
    }//GEN-LAST:event_btnMevcutSatirEkleActionPerformed
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
//        frame = new JFrame("Çıkış");
//        if (JOptionPane.showConfirmDialog(frame, "Çıkış yapmak istiyor musunuz?", "mADEMatik", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
//            System.exit(0);
//        }
    }//GEN-LAST:event_formWindowClosing
    private void rbKurumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbKurumActionPerformed
        secimCalistir();
    }//GEN-LAST:event_rbKurumActionPerformed
    private void rbicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbicActionPerformed
        secimCalistir();
    }//GEN-LAST:event_rbicActionPerformed
    private void rbDisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDisActionPerformed
        secimCalistir();
    }//GEN-LAST:event_rbDisActionPerformed
    private void rbCatiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCatiActionPerformed
        secimCalistir();
    }//GEN-LAST:event_rbCatiActionPerformed
    private void rbTuvaletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTuvaletActionPerformed
        secimCalistir();
    }//GEN-LAST:event_rbTuvaletActionPerformed
    private void rbSuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSuActionPerformed
        secimCalistir();
    }//GEN-LAST:event_rbSuActionPerformed
    private void rbKapiPencereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbKapiPencereActionPerformed
        secimCalistir();
    }//GEN-LAST:event_rbKapiPencereActionPerformed
    private void rbBahceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbBahceActionPerformed
        secimCalistir();
    }//GEN-LAST:event_rbBahceActionPerformed
    private void rbSuBaskiniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSuBaskiniActionPerformed
        secimCalistir();
    }//GEN-LAST:event_rbSuBaskiniActionPerformed
    private void rbElektrikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbElektrikActionPerformed
        secimCalistir();
    }//GEN-LAST:event_rbElektrikActionPerformed
    private void rbKonumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbKonumActionPerformed
        secimCalistir();
    }//GEN-LAST:event_rbKonumActionPerformed
    private void btnFotoEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotoEkleActionPerformed
        if (!txtKurumKodu.getText().equals("")) {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("DOSYA SEÇME - made by mADEMatik");
            chooser.setCurrentDirectory(new File(".\\src\\fotolar\\"));
            chooser.setMultiSelectionEnabled(true);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("IMAGES", "jpg", "jpeg", "png");
            chooser.setFileFilter(filter);
            int secim = chooser.showOpenDialog(this);
            String fotoTuru = secimbul();
            baglan();

            if (secim == JFileChooser.APPROVE_OPTION && chooser.getSelectedFiles().length > 0) {
                String silFotolarSQL = "DELETE FROM Fotolar WHERE kurum_kodu = '" + txtKurumKodu.getText() + "' AND turu = '" + fotoTuru + "'";
                sorguCalistir(silFotolarSQL);
                for (File selectedFile : chooser.getSelectedFiles()) {
                    String fotoSQL = "INSERT INTO Fotolar (kurum_kodu, turu, adi) VALUES ('"
                            + txtKurumKodu.getText() + "', '" + fotoTuru + "', '" + selectedFile.getName() + "')";
                    sorguCalistir(fotoSQL);
                }
                secimCalistir();
                JOptionPane.showMessageDialog(null, cmbKurumAdi.getSelectedItem() + " " + fotoTuru + " FOTOĞRAFLARI EKLENDİ.", "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
            } else {
                String silFotolarSQL = "DELETE FROM Fotolar WHERE kurum_kodu = '" + txtKurumKodu.getText() + "' AND turu = '" + fotoTuru + "'";
                sorguCalistir(silFotolarSQL);
                lblFoto.setIcon(null);
                lstFotolar.clear();
                secimCalistir();
                JOptionPane.showMessageDialog(null, cmbKurumAdi.getSelectedItem() + " " + fotoTuru + " FOTOĞRAFLARI SİLİNDİ.", "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        }
    }//GEN-LAST:event_btnFotoEkleActionPerformed
    private void btnSonrakiFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSonrakiFotoActionPerformed
        if (!lstFotolar.isEmpty()) {
            if (ek == lstFotolar.size() - 1) {
                ek = 0;
            } else {
                ek++;
            }
            lblFotoEkle();
        }
    }//GEN-LAST:event_btnSonrakiFotoActionPerformed
    private void btnGuncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuncelleActionPerformed
        guncelle(evt.getActionCommand());
    }//GEN-LAST:event_btnGuncelleActionPerformed
    private void btnKayitEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKayitEkleActionPerformed
        if (ekle) {
            temizleKapat();
            ekle = false;
        } else {
            String kadi;
            int kkodu;

            if (txtKurumKodu.getText().equals("") || cmbKurumAdi.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(null, "KURUM KODU ve KURUM ADI BOŞ OLAMAZ.", "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
            } else {
                baglan();
                kkodu = Integer.parseInt(txtKurumKodu.getText());
                kadi = cmbKurumAdi.getSelectedItem().toString();

                String kurumSQL = "INSERT INTO Kurumlar (kurum_kodu, kurum_adi) VALUES ('" + Math.abs(kkodu) + "', '" + kadi + "')";
                int d = sorguCalistir(kurumSQL);
                switch (d) {
                    case 5 ->
                        JOptionPane.showMessageDialog(null, "Veritabanı kilitlendi. Lütfen programı kapatıp tekrar açın.", "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
                    case 19 ->
                        JOptionPane.showMessageDialog(null, "Bu kayıt zaten var.", "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
                    default -> {
                        kurumlarAl();
                        baglanListele(listKkodu.get(0).toString());
                        temizleAc();
                        ekle = true;
                        JOptionPane.showMessageDialog(null, "KAYIT EKLEME İŞLEMİ BAŞARILI.", "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
                    }
                }

            }
        }
    }//GEN-LAST:event_btnKayitEkleActionPerformed
    private void btnSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilActionPerformed
        if (txtKurumKodu.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "KURUM KODU BOŞ OLAMAZ.", "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
        } else {
            f = 0;
            frame = new JFrame("Kayıt Silme!!!");
            if (JOptionPane.showConfirmDialog(frame, txtKurumKodu.getText() + " numaralı kaydı silmek istiyor musunuz?", "ORTACA DB", JOptionPane.YES_NO_OPTION, 0, icon) == JOptionPane.YES_NO_OPTION) {
                String kurum_kodu = txtKurumKodu.getText();

                baglan();
                String silFotolarSQL = "DELETE FROM Fotolar WHERE kurum_kodu = " + kurum_kodu;
                sorguCalistir(silFotolarSQL);

                String silMevcutlarSQL = "DELETE FROM Mevcutlar WHERE kurum_kodu = " + kurum_kodu;
                sorguCalistir(silMevcutlarSQL);

                String silKurumlarSQL = "DELETE FROM Kurumlar WHERE kurum_kodu = " + kurum_kodu;
                sorguCalistir(silKurumlarSQL);

                JOptionPane.showMessageDialog(null, "KAYIT SİLME İŞLEMİ BAŞARILI.", "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);

                kurumlarAl();
                baglanListele(listKkodu.get(0).toString());
                secimCalistir();
            }
        }
    }//GEN-LAST:event_btnSilActionPerformed
    private void btnYazdirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYazdirActionPerformed
        prntDialog.setSize(new Dimension(260, 160));
        prntDialog.setIconImage(icon.getImage());
        prntDialog.setLocationRelativeTo(null);
        prntDialog.setModal(true);
        prntDialog.setAlwaysOnTop(true);
        //prntDialog.setModalityType(ModalityType.APPLICATION_MODAL);
        prntDialog.setVisible(true);
    }//GEN-LAST:event_btnYazdirActionPerformed
    private void btnKurumlariYazdirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKurumlariYazdirActionPerformed
        if (rbYazdirFotosuz.isSelected()) {
            prntDialog.setVisible(false);
            try {
                baglan();
                String rp = ".\\src\\reports\\rptFotosuz.jrxml";
                JasperReport jr = JasperCompileManager.compileReport(rp);
                JasperPrint pr = JasperFillManager.fillReport(jr, null, conn);
                JasperViewer jasperViewer = new JasperViewer(pr, false, getLocale());
                JDialog dialog = new JDialog(this);
                dialog.setContentPane(jasperViewer.getContentPane());
                dialog.setSize(new Dimension(1024, 768));
                dialog.setLocationRelativeTo(this);
                dialog.setTitle("FOTOĞRAFSIZ KURUM YAZDIRMA - made by mADEMatik");
                dialog.setModal(true);
                dialog.setVisible(true);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        }
        if (rbYazdirFotolu.isSelected()) {
            prntDialog.setVisible(false);
            try {
                baglan();
                String rp = ".\\src\\reports\\rptFotolu.jrxml";
                JasperReport jr = JasperCompileManager.compileReport(rp);
                HashMap<String, Object> param = new HashMap<>();
                param.put("kurumKodu", txtKurumKodu.getText());
                JasperPrint pr = JasperFillManager.fillReport(jr, param, conn);
                JasperViewer jasperViewer = new JasperViewer(pr, false, getLocale());
                JDialog dialog = new JDialog(this);
                dialog.setContentPane(jasperViewer.getContentPane());
                dialog.setSize(new Dimension(1024, 768));
                dialog.setLocationRelativeTo(this);
                dialog.setTitle("FOTOĞRAFLI KURUM YAZDIRMA - made by mADEMatik");
                dialog.setModal(true);
                dialog.setVisible(true);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        }
    }//GEN-LAST:event_btnKurumlariYazdirActionPerformed
    private void cmbKurumAdiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbKurumAdiFocusGained
        aktifim = true;
    }//GEN-LAST:event_cmbKurumAdiFocusGained
    private void cmbKurumAdiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbKurumAdiFocusLost
        aktifim = false;
    }//GEN-LAST:event_cmbKurumAdiFocusLost
    private void cmbKurumAdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKurumAdiActionPerformed
        if (aktifim) {
            f = listKadi.indexOf(cmbKurumAdi.getSelectedItem());
            baglanListele(listKkodu.get(listKadi.indexOf(cmbKurumAdi.getSelectedItem())).toString());
            secimCalistir();
        }
    }//GEN-LAST:event_cmbKurumAdiActionPerformed
    private void lblFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFotoMouseClicked
        if (evt.getClickCount() == 2 & lblFoto.getIcon() != null) {
            try {
                File file = new File("./src/fotolar/" + lstFotolar.get(ek));
                Desktop desktop = Desktop.getDesktop();
                desktop.open(file);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        }

    }//GEN-LAST:event_lblFotoMouseClicked
    private void tableMevcutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableMevcutKeyPressed
        for (int i = 0; i < tableMevcut.getRowCount(); i++) {
            tableMevcut.setValueAt("", i, 2);
        }
        if (evt.getKeyCode() == 10) {
            guncelle("");
            secimCalistir();
        }
    }//GEN-LAST:event_tableMevcutKeyPressed

    private void txtKurumKoduKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKurumKoduKeyPressed
        if (evt.getKeyCode() == 27) {
            iptalEt();
        }
    }//GEN-LAST:event_txtKurumKoduKeyPressed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFotoEkle;
    private javax.swing.JButton btnGuncelle;
    private javax.swing.JButton btnKayitEkle;
    private javax.swing.JButton btnKurumlariYazdir;
    private javax.swing.JButton btnMevcutSatirEkle;
    private javax.swing.JButton btnMevcutSatirSil;
    private javax.swing.JButton btnOnceki;
    private javax.swing.ButtonGroup btnSecimGroup;
    private javax.swing.JButton btnSil;
    private javax.swing.JButton btnSonraki;
    private javax.swing.JButton btnSonrakiFoto;
    private javax.swing.JButton btnYazdir;
    private javax.swing.ButtonGroup btnYazdirGroup;
    private javax.swing.JComboBox<String> cmbBahce;
    private javax.swing.JComboBox<String> cmbCati;
    private javax.swing.JComboBox<String> cmbDisBoya;
    private javax.swing.JComboBox<String> cmbElektrik;
    private javax.swing.JComboBox<String> cmbKapiPencere;
    private javax.swing.JComboBox<String> cmbKurumAdi;
    private javax.swing.JComboBox<String> cmbOnarim;
    private javax.swing.JComboBox<String> cmbSu;
    private javax.swing.JComboBox<String> cmbSuBaskini;
    private javax.swing.JComboBox<String> cmbTuvalet;
    private javax.swing.JComboBox<String> cmbicBoya;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JDialog prntDialog;
    private javax.swing.JRadioButton rbBahce;
    private javax.swing.JRadioButton rbCati;
    private javax.swing.JRadioButton rbDis;
    private javax.swing.JRadioButton rbElektrik;
    private javax.swing.JRadioButton rbKapiPencere;
    private javax.swing.JRadioButton rbKonum;
    private javax.swing.JRadioButton rbKurum;
    private javax.swing.JRadioButton rbSu;
    private javax.swing.JRadioButton rbSuBaskini;
    private javax.swing.JRadioButton rbTuvalet;
    private javax.swing.JRadioButton rbYazdirFotolu;
    private javax.swing.JRadioButton rbYazdirFotosuz;
    private javax.swing.JRadioButton rbic;
    private javax.swing.JPanel sagAltPanel;
    private javax.swing.JPanel solPanel;
    private javax.swing.JTextArea taDigerSorunlar;
    private javax.swing.JTextArea taSosyolojik;
    private javax.swing.JTable tableMevcut;
    private javax.swing.JTextField txtBlokSayisi;
    private javax.swing.JTextField txtDerslikSayisi;
    private javax.swing.JTextField txtKurumKodu;
    private javax.swing.JTextField txtMerkezeUzakligi;
    private javax.swing.JTextField txtOgretmenSayisi;
    private javax.swing.JTextField txtOnarimTarihi;
    private javax.swing.JTextField txtYapimTarihi;
    private javax.swing.JTextField txtYuzolcumu;
    // End of variables declaration//GEN-END:variables
    private void baglanListele(String kkodu) {
        baglan();
        cmbKurumAdi.setEditable(false);
        String listeleSQL = "SELECT * FROM Kurumlar WHERE kurum_kodu = " + kkodu;
        rs = listeAl(listeleSQL);
        lblFoto.setIcon(null);

        try {
            txtKurumKodu.setText(rs.getString("kurum_kodu"));
            cmbKurumAdi.setSelectedIndex(listKadi.indexOf(rs.getString("kurum_adi")));
            txtYapimTarihi.setText(rs.getString("yapim_tarihi"));
            cmbOnarim.setSelectedIndex(rs.getInt("onarim"));
            txtOnarimTarihi.setText(rs.getString("onarim_tarihi"));
            txtYuzolcumu.setText(rs.getString("yuzolcumu"));
            txtMerkezeUzakligi.setText(rs.getString("merkeze_uzakligi"));
            txtBlokSayisi.setText(rs.getString("blok_sayisi"));
            txtDerslikSayisi.setText(rs.getString("derslik_sayisi"));
            txtOgretmenSayisi.setText(rs.getString("ogretmen_sayisi"));
            cmbicBoya.setSelectedIndex(rs.getInt("ic"));
            cmbDisBoya.setSelectedIndex(rs.getInt("dis"));
            cmbCati.setSelectedIndex(rs.getInt("cati"));
            cmbTuvalet.setSelectedIndex(rs.getInt("tuvalet"));
            cmbElektrik.setSelectedIndex(rs.getInt("elektrik"));
            cmbSu.setSelectedIndex(rs.getInt("su"));
            cmbKapiPencere.setSelectedIndex(rs.getInt("kapi_pencere"));
            cmbBahce.setSelectedIndex(rs.getInt("bahce"));
            cmbSuBaskini.setSelectedIndex(rs.getInt("su_baskini"));
            taDigerSorunlar.setText(rs.getString("diger_sorunlar").replace("**", "'"));
            taSosyolojik.setText(rs.getString("sosyolojik").replace("**", "'"));

            String mevcutSQL = "SELECT * FROM Mevcutlar WHERE kurum_kodu = " + kkodu + " ORDER BY yili";
            ResultSet rsM = listeAl(mevcutSQL);
            modelimMevcut.setColumnCount(0);
            modelimMevcut.setRowCount(0);
            modelimMevcut.setColumnIdentifiers(kolonlarMevcut);

            while (rsM.next()) {
                satirlarMevcut[0] = rsM.getString("yili");
                satirlarMevcut[1] = rsM.getString("mevcudu");
                satirlarMevcut[2] = rsM.getString("degisim_orani");
                modelimMevcut.addRow(satirlarMevcut);
            }
            tableMevcut.setModel(modelimMevcut);
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            tableMevcut.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
            tableMevcut.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
            tableMevcut.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
            ((DefaultTableCellRenderer) tableMevcut.getTableHeader().getDefaultRenderer())
                    .setHorizontalAlignment(JLabel.CENTER);

            conn.close();
            st.close();
        } catch (SQLException e) {
            if (e.getErrorCode() == 0) {
                temizleKapat();
                JOptionPane.showMessageDialog(null, kkodu + " NUMARALI KAYIT BULUNAMADI", "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
            } else {
                JOptionPane.showMessageDialog(null, e.getMessage(), "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        }
    }

    static void baglan() {
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
        }
    }

    static ResultSet listeAl(String sorgu) {
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sorgu);
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
            return null;
        }
    }

    static int sorguCalistir(String sorgu) {
        try {
            st = conn.createStatement();
            st.executeUpdate(sorgu);
        } catch (SQLException e) {
            return e.getErrorCode();
        }
        return -1;
    }

    private void temizleKapat() {
        txtKurumKodu.setText(null);
        txtKurumKodu.setEditable(true);
        txtKurumKodu.setToolTipText("Kurum kodu boş olamaz.");
        cmbKurumAdi.removeAllItems();
        cmbKurumAdi.addItem("");
        cmbKurumAdi.setEditable(true);
        cmbKurumAdi.setToolTipText("Kurum adı boş olamaz.");

        txtYapimTarihi.setText(null);
        cmbOnarim.setSelectedIndex(0);
        txtOnarimTarihi.setText(null);
        txtYuzolcumu.setText("0");
        txtMerkezeUzakligi.setText("0");
        txtBlokSayisi.setText("0");
        txtDerslikSayisi.setText("0");
        txtOgretmenSayisi.setText("0");
        cmbicBoya.setSelectedIndex(0);
        cmbDisBoya.setSelectedIndex(0);
        cmbCati.setSelectedIndex(0);
        cmbTuvalet.setSelectedIndex(0);
        cmbElektrik.setSelectedIndex(0);
        cmbSu.setSelectedIndex(0);
        cmbKapiPencere.setSelectedIndex(0);
        cmbBahce.setSelectedIndex(0);
        cmbSuBaskini.setSelectedIndex(0);
        taDigerSorunlar.setText(null);
        taSosyolojik.setText(null);
        lblFoto.setIcon(null);

        modelimMevcut.setColumnIdentifiers(kolonlarMevcut);
        modelimMevcut.setRowCount(0);

        txtYapimTarihi.setEnabled(false);
        cmbOnarim.setEnabled(false);
        txtOnarimTarihi.setEnabled(false);
        txtYuzolcumu.setEnabled(false);
        txtMerkezeUzakligi.setEnabled(false);
        txtBlokSayisi.setEnabled(false);
        txtDerslikSayisi.setEnabled(false);
        txtOgretmenSayisi.setEnabled(false);
        cmbicBoya.setEnabled(false);
        cmbDisBoya.setEnabled(false);
        cmbCati.setEnabled(false);
        cmbTuvalet.setEnabled(false);
        cmbElektrik.setEnabled(false);
        cmbSu.setEnabled(false);
        cmbKapiPencere.setEnabled(false);
        cmbBahce.setEnabled(false);
        cmbSuBaskini.setEnabled(false);
        taDigerSorunlar.setEnabled(false);
        taSosyolojik.setEnabled(false);
        lblFoto.setEnabled(false);
        lblFoto.setIcon(null);
        lblFoto.setText("KURUM KODU VE KURUM ADI BOŞ OLAMAZ.");
        lblFoto.setToolTipText("KURUM KODU VE KURUM ADI BOŞ OLAMAZ.");

        rbBahce.setEnabled(false);
        rbCati.setEnabled(false);
        rbDis.setEnabled(false);
        rbElektrik.setEnabled(false);
        rbKapiPencere.setEnabled(false);
        rbKonum.setEnabled(false);
        rbKurum.setEnabled(false);
        rbSu.setEnabled(false);
        rbSuBaskini.setEnabled(false);
        rbTuvalet.setEnabled(false);
        rbic.setEnabled(false);
        rbYazdirFotosuz.setEnabled(false);
        rbYazdirFotolu.setEnabled(false);

        tableMevcut.setEnabled(false);
        btnKayitEkle.setText("Ekle");
        btnFotoEkle.setEnabled(false);
        btnGuncelle.setEnabled(false);
        btnKurumlariYazdir.setEnabled(false);
        btnMevcutSatirEkle.setEnabled(false);
        btnMevcutSatirSil.setEnabled(false);
        btnOnceki.setEnabled(false);
        btnSil.setEnabled(false);
        btnSonraki.setEnabled(false);
        btnSonrakiFoto.setEnabled(false);
        btnYazdir.setEnabled(false);
    }

    private void temizleAc() {
        txtKurumKodu.setToolTipText("Kurum Kodu");
        txtKurumKodu.setEditable(false);
        cmbKurumAdi.setToolTipText("Kurum seçiniz.");
        txtYapimTarihi.setEnabled(true);
        cmbOnarim.setEnabled(true);
        txtOnarimTarihi.setEnabled(true);
        txtYuzolcumu.setEnabled(true);
        txtMerkezeUzakligi.setEnabled(true);
        txtBlokSayisi.setEnabled(true);
        txtDerslikSayisi.setEnabled(true);
        txtOgretmenSayisi.setEnabled(true);
        cmbicBoya.setEnabled(true);
        cmbDisBoya.setEnabled(true);
        cmbCati.setEnabled(true);
        cmbTuvalet.setEnabled(true);
        cmbElektrik.setEnabled(true);
        cmbSu.setEnabled(true);
        cmbKapiPencere.setEnabled(true);
        cmbBahce.setEnabled(true);
        cmbSuBaskini.setEnabled(true);
        taDigerSorunlar.setEnabled(true);
        taSosyolojik.setEnabled(true);
        lblFoto.setEnabled(true);
        lblFoto.setText(null);
        lblFoto.setToolTipText("Fotoğrafı açmak için çift tıklayınız.");

        rbBahce.setEnabled(true);
        rbCati.setEnabled(true);
        rbDis.setEnabled(true);
        rbElektrik.setEnabled(true);
        rbKapiPencere.setEnabled(true);
        rbKonum.setEnabled(true);
        rbKurum.setEnabled(true);
        rbSu.setEnabled(true);
        rbSuBaskini.setEnabled(true);
        rbTuvalet.setEnabled(true);
        rbic.setEnabled(true);
        rbYazdirFotosuz.setEnabled(true);
        rbYazdirFotolu.setEnabled(true);

        tableMevcut.setEnabled(true);
        btnKayitEkle.setText("Yeni Kayıt");
        btnFotoEkle.setEnabled(true);
        btnGuncelle.setEnabled(true);
        btnKurumlariYazdir.setEnabled(true);
        btnMevcutSatirEkle.setEnabled(true);
        btnMevcutSatirSil.setEnabled(true);
        btnOnceki.setEnabled(true);
        btnSil.setEnabled(true);
        btnSonraki.setEnabled(true);
        btnSonrakiFoto.setEnabled(true);
        btnYazdir.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    private void kurumlarAl() {
        listKkodu.clear();
        listKadi.clear();
        cmbKurumAdi.removeAllItems();
        baglan();
        String listeleSQL = "SELECT * FROM Kurumlar ORDER BY kurum_kodu";
        rs = listeAl(listeleSQL);

        try {
            while (rs.next()) {
                listKkodu.add(rs.getString("kurum_kodu"));
                listKadi.add(rs.getString("kurum_adi"));
            }
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 0) {
                JOptionPane.showMessageDialog(null, "HENÜZ KAYDINIZ YOK.", "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
            } else {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        }
        for (Object object : listKadi) {
            cmbKurumAdi.addItem(object.toString());
        }
    }

    private void guncelle(String evtAction) {
        String kurum_kodu, kurum_adi, yapim_tarihi, onarim_tarihi, diger_sorunlar, sosyolojik, ogretim_yili, degisim_orani, mevcudu;
        int onarim, blok_sayisi, derslik_sayisi, ogretmen_sayisi, ic, dis, cati, tuvalet, elektrik, su, kapi_pencere,
                bahce, su_baskini;
        float yuzolcumu, merkeze_uzakligi;
        if (txtKurumKodu.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "KURUM KODU BOŞ OLAMAZ.", "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
        } else {
            baglan();
            try {
                kurum_kodu = txtKurumKodu.getText();
                kurum_adi = cmbKurumAdi.getSelectedItem().toString().toUpperCase();
                yapim_tarihi = txtYapimTarihi.getText();
                onarim = cmbOnarim.getSelectedIndex();
                onarim_tarihi = txtOnarimTarihi.getText();
                yuzolcumu = Float.parseFloat((txtYuzolcumu.getText()));
                merkeze_uzakligi = Float.parseFloat(txtMerkezeUzakligi.getText());
                blok_sayisi = Integer.parseInt(txtBlokSayisi.getText());
                derslik_sayisi = Integer.parseInt(txtDerslikSayisi.getText());
                ogretmen_sayisi = Integer.parseInt(txtOgretmenSayisi.getText());
                ic = cmbicBoya.getSelectedIndex();
                dis = cmbDisBoya.getSelectedIndex();
                cati = cmbCati.getSelectedIndex();
                tuvalet = cmbTuvalet.getSelectedIndex();
                elektrik = cmbElektrik.getSelectedIndex();
                su = cmbSu.getSelectedIndex();
                kapi_pencere = cmbKapiPencere.getSelectedIndex();
                bahce = cmbBahce.getSelectedIndex();
                su_baskini = cmbSuBaskini.getSelectedIndex();
                diger_sorunlar = taDigerSorunlar.getText();
                sosyolojik = taSosyolojik.getText();

                String kurumSQL = "UPDATE Kurumlar SET kurum_adi = '" + kurum_adi
                        + "', yapim_tarihi = '" + yapim_tarihi
                        + "', onarim = '" + onarim
                        + "', onarim_tarihi = '" + onarim_tarihi
                        + "', yuzolcumu = '" + Math.abs(yuzolcumu)
                        + "', merkeze_uzakligi = '" + Math.abs(merkeze_uzakligi)
                        + "', blok_sayisi = '" + Math.abs(blok_sayisi)
                        + "', derslik_sayisi = '" + Math.abs(derslik_sayisi)
                        + "', ogretmen_sayisi = '" + Math.abs(ogretmen_sayisi)
                        + "', ic = '" + ic
                        + "', dis = '" + dis
                        + "', cati = '" + cati
                        + "', tuvalet = '" + tuvalet
                        + "', elektrik = '" + elektrik
                        + "', su = '" + su
                        + "', kapi_pencere = '" + kapi_pencere
                        + "', bahce = '" + bahce
                        + "', su_baskini = '" + su_baskini
                        + "', diger_sorunlar = '" + diger_sorunlar.replace("'", "**")
                        + "', sosyolojik = '" + sosyolojik.replace("'", "**")
                        + "' WHERE kurum_kodu = " + kurum_kodu;

                sorguCalistir(kurumSQL);

                String silMevcutlarSQL = "DELETE FROM Mevcutlar WHERE kurum_kodu = " + kurum_kodu;
                sorguCalistir(silMevcutlarSQL);
                for (int i = 0; i < tableMevcut.getRowCount(); i++) {
                    if (tableMevcut.getValueAt(i, 0) != "") {
                        ogretim_yili = tableMevcut.getValueAt(i, 0).toString();
                        mevcudu = tableMevcut.getValueAt(i, 1).toString();
                        degisim_orani = tableMevcut.getValueAt(i, 2).toString();
                        String mevcutSQL1 = "INSERT INTO Mevcutlar (kurum_kodu, yili, mevcudu, degisim_orani) VALUES ('"
                                + kurum_kodu + "', '" + ogretim_yili + "', '" + mevcudu + "', '" + degisim_orani + "')";
                        sorguCalistir(mevcutSQL1);
                    }
                }
                baglanListele(kurum_kodu);

                baglan();
                DecimalFormat decF = new DecimalFormat("0.00");
                for (int i = 1; i < tableMevcut.getRowCount(); i++) {
                    float onceki = Float.parseFloat((String) tableMevcut.getValueAt(i - 1, 1));
                    float simdiki = Float.parseFloat((String) tableMevcut.getValueAt(i, 1));
                    float oran = (simdiki / onceki - 1) * 100;
                    String yaz = decF.format((oran)) + " %";
                    if (yaz.equals("NaN %") || yaz.equals("∞ %")) {
                        yaz = "";
                    }
                    tableMevcut.setValueAt(yaz, i, 2);
                }

                sorguCalistir(silMevcutlarSQL);
                for (int i = 0; i < tableMevcut.getRowCount(); i++) {
                    if (tableMevcut.getValueAt(i, 0) != "") {
                        ogretim_yili = tableMevcut.getValueAt(i, 0).toString();
                        mevcudu = tableMevcut.getValueAt(i, 1).toString();
                        degisim_orani = tableMevcut.getValueAt(i, 2).toString();
                        String mevcutSQL = "INSERT INTO Mevcutlar (kurum_kodu, yili, mevcudu, degisim_orani) VALUES ('"
                                + kurum_kodu + "', '" + ogretim_yili + "', '" + mevcudu + "', '" + degisim_orani + "')";
                        sorguCalistir(mevcutSQL);
                    }
                }

                if (evtAction.equals("Güncelle")) {
                    baglanListele(kurum_kodu);
                    secimCalistir();
                    JOptionPane.showMessageDialog(null, kurum_kodu + " NUMARALI KAYIT GÜNCELLENDİ.", "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
                }
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "SAYISAL DEĞERLERİ KONTROL EDİNİZ.", "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        }
    }

    private String secimbul() {
        if (rbKurum.isSelected()) {
            return "KURUM";
        }
        if (rbic.isSelected()) {
            return "İÇ CEPHE";
        }
        if (rbDis.isSelected()) {
            return "DIŞ CEPHE";
        }
        if (rbCati.isSelected()) {
            return "ÇATI";
        }
        if (rbTuvalet.isSelected()) {
            return "TUVALET";
        }
        if (rbElektrik.isSelected()) {
            return "ELEKTRİK TESİSATI";
        }
        if (rbSu.isSelected()) {
            return "SU TESİSATI";
        }
        if (rbKapiPencere.isSelected()) {
            return "KAPI - PENCERE";
        }
        if (rbBahce.isSelected()) {
            return "BAHÇE";
        }
        if (rbSuBaskini.isSelected()) {
            return "SU BASKINI";
        }
        if (rbKonum.isSelected()) {
            return "KONUM";
        }
        return "";
    }

    private void lblFotoEkle() {
        String baslik, tooltextYardim;
        if (!lstFotolar.isEmpty()) {
            ImageIcon iconFoto = new ImageIcon("./src/fotolar/" + lstFotolar.get(ek));
            Image imageFoto = iconFoto.getImage();
            int en;
            if (iconFoto.getIconWidth() * 370 / iconFoto.getIconHeight() > 750) {
                en = 750;
            } else {
                en = iconFoto.getIconWidth() * 370 / iconFoto.getIconHeight();
            }
            Image modFoto = imageFoto.getScaledInstance(en, 370, Image.SCALE_AREA_AVERAGING);
            lblFoto.setIcon(new ImageIcon(modFoto));

            baslik = secimbul() + " FOTOĞRAFI (" + (ek + 1) + " / " + lstFotolar.size() + ")     ";
            tooltextYardim = "Fotoğrafı açmak için çift tıklayınız";
        } else {
            baslik = secimbul() + " FOTOĞRAFI YOK      ";
            tooltextYardim = null;
        }

        TitledBorder titledBorder = new TitledBorder(baslik);
        lblFoto.setBorder(titledBorder);
        lblFoto.setToolTipText(tooltextYardim);
    }

    @SuppressWarnings("unchecked")
    private void secimCalistir() {
        lstFotolar.clear();
        ek = 0;
        try {
            baglan();
            lblFoto.setIcon(null);
            String fotoListeleSQL = "SELECT * FROM Fotolar WHERE kurum_kodu = '" + txtKurumKodu.getText() + "' AND turu = '" + secimbul() + "'";
            rsFoto = listeAl(fotoListeleSQL);

            while (rsFoto.next()) {
                lstFotolar.add(rsFoto.getString("adi"));
            }
            baglanListele(txtKurumKodu.getText());
            lblFotoEkle();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
        }
    }

    private void iptalEt() {
        ekle = true;
        f = 0;
        temizleAc();
        kurumlarAl();
        txtKurumKodu.setText(listKkodu.get(0).toString());
        baglanListele(txtKurumKodu.getText());
        secimCalistir();
    }
}
