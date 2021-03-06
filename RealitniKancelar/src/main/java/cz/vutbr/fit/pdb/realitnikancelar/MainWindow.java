/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vutbr.fit.pdb.realitnikancelar;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.Color;
import java.io.InvalidObjectException;
import java.lang.Math;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import java.awt.BasicStroke;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.geom.AffineTransform;
import javax.swing.JOptionPane;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.lang.IllegalArgumentException;

/**
 * Hlavni okno.
 * @author Honza
 *
 */
public class MainWindow extends javax.swing.JFrame {

    private static final Color DEFAULT_BACK_COLOR = Color.WHITE;
    private static final Color DEFAULT_POINT_COLOR = Color.BLACK;
    private static final Color DEFAULT_LINE_COLOR = Color.BLACK;
    private static final Color DEFAULT_FILL_COLOR = Color.YELLOW;
    private static final Color DEFAULT_SELECTION_LINE_COLOR = Color.RED;
    private static final Color DEFAULT_SELECTION_FILL_COLOR = new Color(255, 0, 0, 50);
    
    private int lastX, lastY;
    
    private Point origin = new Point();
    
    private boolean newPolyline = false;
    private boolean newPolygon = false;
    private boolean newRectangle = false;
    private boolean newCircle = false;
    
    public static DefaultComboBoxModel ownersListModel = new DefaultComboBoxModel();
    public static ArrayList<String> ownersListNames = new ArrayList<String>();
    
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        
        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(ObjectInfo.TYPES));
        
        clearInfo();
        
        saveChangesButton.setEnabled(false);
        saveChangesMenuItem.setEnabled(false);
        selectRadioButton.setEnabled(false);
        addPointRadioButton.setEnabled(false);
        addPolylineRadioButton.setEnabled(false);
        addPolygonRadioButton.setEnabled(false);
        addRectangleRadioButton.setEnabled(false);
        addCircleRadioButton.setEnabled(false);
        ownersList.setEnabled(false);
        ownerNameField.setEnabled(false);
        ownerAddressField.setEnabled(false);
        addOwnerButton.setEnabled(false);
        updateOwnerButton.setEnabled(false);
        deleteOwnerButton.setEnabled(false);
        loadImageButton.setEnabled(false);
        saveImageButton.setEnabled(false);
        rotateImageButton.setEnabled(false);
        similarImagesButton.setEnabled(false);
        createDataButton.setEnabled(false);
        createDataMenuItem.setEnabled(false);
        
        ownersList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ownersList.setModel(ownersListModel);
        
        buttonGroup.add(selectRadioButton);
        buttonGroup.add(addPointRadioButton);
        buttonGroup.add(addPolylineRadioButton);
        buttonGroup.add(addRectangleRadioButton);
        buttonGroup.add(addCircleRadioButton);
        buttonGroup.add(addPolygonRadioButton);
        
        ((DrawingPanel)mapPanel).backColor = DEFAULT_BACK_COLOR;
        ((DrawingPanel)mapPanel).pointColor = DEFAULT_POINT_COLOR;
        ((DrawingPanel)mapPanel).lineColor = DEFAULT_LINE_COLOR;
        ((DrawingPanel)mapPanel).fillColor = DEFAULT_FILL_COLOR;
        ((DrawingPanel)mapPanel).selectionLineColor = DEFAULT_SELECTION_LINE_COLOR;
        ((DrawingPanel)mapPanel).selectionFillColor = DEFAULT_SELECTION_FILL_COLOR;
        ((DrawingPanel)mapPanel).pointThickness = (int)pointThicknessSpinner.getValue();
        ((DrawingPanel)mapPanel).lineThickness = (int)lineThicknessSpinner.getValue();
        
        pointColorPanel.setBackground(DEFAULT_POINT_COLOR);
        backColorPanel.setBackground(DEFAULT_BACK_COLOR);
        lineColorPanel.setBackground(DEFAULT_LINE_COLOR);
        fillColorPanel.setBackground(DEFAULT_FILL_COLOR);
        selectionColorPanel.setBackground(DEFAULT_SELECTION_LINE_COLOR);
        if (Data.defaultData) {
            
            Data.loadDefaultData();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        tabbedPane = new javax.swing.JTabbedPane();
        infoPanel = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        objectNameField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        typeComboBox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        sectorLabel = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        ownersButton = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        ownerNameLabel = new javax.swing.JLabel();
        ownerAddressLabel = new javax.swing.JLabel();
        rekonstrukceField = new javax.swing.JTextField();
        existenceOdField = new javax.swing.JTextField();
        existenceDoField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        descriptionField = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        plocha = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        obvod = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        nejblizsiZastavka = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        centrumVzdalenost = new javax.swing.JLabel();
        editPanel = new javax.swing.JPanel();
        selectRadioButton = new javax.swing.JRadioButton();
        addPointRadioButton = new javax.swing.JRadioButton();
        addPolylineRadioButton = new javax.swing.JRadioButton();
        addRectangleRadioButton = new javax.swing.JRadioButton();
        addCircleRadioButton = new javax.swing.JRadioButton();
        addPolygonRadioButton = new javax.swing.JRadioButton();
        ownersPanel = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        ownerNameField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        ownerAddressField = new javax.swing.JTextField();
        addOwnerButton = new javax.swing.JButton();
        updateOwnerButton = new javax.swing.JButton();
        deleteOwnerButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ownersList = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        loadImageButton = new javax.swing.JButton();
        saveImageButton = new javax.swing.JButton();
        rotateImageButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        imagePanel = new DrawingPanel();
        similarImagesButton = new javax.swing.JButton();
        mapSettingsPanel = new javax.swing.JPanel();
        backColorPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lineColorPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        fillColorPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lineThicknessSpinner = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        pointColorPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        pointThicknessSpinner = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        selectionColorPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        mapScrollPanel = new javax.swing.JScrollPane();
        mapPanel = new DrawingPanel();
        loadDataButton = new javax.swing.JButton();
        saveChangesButton = new javax.swing.JButton();
        positionLabel = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        createDataButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mainMenu = new javax.swing.JMenu();
        loadDataMenuItem = new javax.swing.JMenuItem();
        createDataMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        saveChangesMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Realitní kancelář");

        tabbedPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabbedPane.setMinimumSize(new java.awt.Dimension(100, 130));

        jLabel8.setText("Název objektu:");

        jLabel9.setText("Typ objektu:");

        jLabel10.setText("Sektor:");

        sectorLabel.setText("jLabel11");

        jLabel15.setText("Poslední majitel:");

        ownersButton.setText("Historie a editace majitelů");
        ownersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ownersButtonActionPerformed(evt);
            }
        });

        jLabel16.setText("Datum výstavby:");

        jLabel17.setText("Datum rekonstrukce:");

        jLabel18.setText("Datum demolice:");

        jLabel19.setText("Popis:");

        ownerNameLabel.setText("jLabel14");

        ownerAddressLabel.setText("jLabel14");

        descriptionField.setColumns(20);
        descriptionField.setRows(5);
        jScrollPane2.setViewportView(descriptionField);

        jLabel20.setText("Plocha objektu:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Podrobnosti");

        plocha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel21.setText("Obvod objektu:");

        obvod.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel14.setText("Nejbližší zastávka:");

        nejblizsiZastavka.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel22.setText("Vzdálenost od centra:");

        centrumVzdalenost.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(47, 47, 47))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(30, 30, 30)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(obvod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(plocha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nejblizsiZastavka, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(centrumVzdalenost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(objectNameField)
                                        .addComponent(typeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sectorLabel)
                                    .addGap(87, 87, 87))))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel20)
                                .addComponent(jLabel21)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ownerAddressLabel)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(14, 14, 14)
                                        .addComponent(ownerNameLabel)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(91, 91, 91)
                                    .addComponent(ownersButton))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel17)
                                        .addComponent(jLabel18)
                                        .addComponent(jLabel16))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(existenceOdField)
                                        .addComponent(rekonstrukceField)
                                        .addComponent(existenceDoField, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel19)
                                    .addGap(71, 71, 71)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel11))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(objectNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(sectorLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(ownerNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ownerAddressLabel)
                .addGap(5, 5, 5)
                .addComponent(ownersButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(existenceOdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(rekonstrukceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(existenceDoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20))
                    .addComponent(plocha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(obvod, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(nejblizsiZastavka, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(centrumVzdalenost, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(74, 74, 74))
        );

        plocha.getAccessibleContext().setAccessibleName("plocha");
        obvod.getAccessibleContext().setAccessibleName("obvod");

        infoPanel.setViewportView(jPanel2);

        tabbedPane.addTab("Informace", infoPanel);

        selectRadioButton.setSelected(true);
        selectRadioButton.setText("Posouvání a mazání");

        addPointRadioButton.setText("Přidat bod");
        addPointRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                addPointRadioButtonItemStateChanged(evt);
            }
        });

        addPolylineRadioButton.setText("Přidat lomenou čáru");
        addPolylineRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                addPolylineRadioButtonItemStateChanged(evt);
            }
        });

        addRectangleRadioButton.setText("Přidat obdélník");
        addRectangleRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                addRectangleRadioButtonItemStateChanged(evt);
            }
        });

        addCircleRadioButton.setText("Přidat kružnici");
        addCircleRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                addCircleRadioButtonItemStateChanged(evt);
            }
        });

        addPolygonRadioButton.setText("Přidat polygon");
        addPolygonRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                addPolygonRadioButtonItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout editPanelLayout = new javax.swing.GroupLayout(editPanel);
        editPanel.setLayout(editPanelLayout);
        editPanelLayout.setHorizontalGroup(
            editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(selectRadioButton)
                .addGap(18, 18, 18)
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addPolygonRadioButton)
                    .addComponent(addPolylineRadioButton)
                    .addComponent(addPointRadioButton)
                    .addComponent(addRectangleRadioButton)
                    .addComponent(addCircleRadioButton))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        editPanelLayout.setVerticalGroup(
            editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editPanelLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectRadioButton)
                    .addComponent(addPointRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addPolylineRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addRectangleRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addCircleRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addPolygonRadioButton)
                .addContainerGap(368, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Editace", editPanel);

        jPanel1.setPreferredSize(new java.awt.Dimension(100, 100));

        jLabel12.setText("Jméno:");

        jLabel13.setText("Adresa:");

        addOwnerButton.setText("Přidat");
        addOwnerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOwnerButtonActionPerformed(evt);
            }
        });

        updateOwnerButton.setText("Změnit");
        updateOwnerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateOwnerButtonActionPerformed(evt);
            }
        });

        deleteOwnerButton.setText("Vymazat");
        deleteOwnerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteOwnerButtonActionPerformed(evt);
            }
        });

        ownersList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ownersList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ownersListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(ownersList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(addOwnerButton))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ownerAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ownerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(updateOwnerButton)
                        .addGap(30, 30, 30)
                        .addComponent(deleteOwnerButton)))
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(ownerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ownerAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addOwnerButton)
                    .addComponent(updateOwnerButton)
                    .addComponent(deleteOwnerButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addContainerGap())
        );

        ownersPanel.setViewportView(jPanel1);

        tabbedPane.addTab("Majitelé", ownersPanel);

        loadImageButton.setText("Načíst ze souboru");
        loadImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadImageButtonActionPerformed(evt);
            }
        });

        saveImageButton.setText("Uložit do souboru");
        saveImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveImageButtonActionPerformed(evt);
            }
        });

        rotateImageButton.setText("Rotovat");
        rotateImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rotateImageButtonActionPerformed(evt);
            }
        });

        imagePanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(imagePanel);

        similarImagesButton.setText("Vyhledat podobné");
        similarImagesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                similarImagesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rotateImageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadImageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(saveImageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(similarImagesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(56, 56, 56))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loadImageButton)
                    .addComponent(saveImageButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotateImageButton)
                    .addComponent(similarImagesButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3))
        );

        tabbedPane.addTab("Obrázek", jPanel3);

        backColorPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        backColorPanel.setMaximumSize(new java.awt.Dimension(15, 15));
        backColorPanel.setMinimumSize(new java.awt.Dimension(15, 15));
        backColorPanel.setPreferredSize(new java.awt.Dimension(15, 15));
        backColorPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backColorPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout backColorPanelLayout = new javax.swing.GroupLayout(backColorPanel);
        backColorPanel.setLayout(backColorPanelLayout);
        backColorPanelLayout.setHorizontalGroup(
            backColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );
        backColorPanelLayout.setVerticalGroup(
            backColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );

        jLabel1.setText("Barva pozadí:");

        lineColorPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lineColorPanel.setMaximumSize(new java.awt.Dimension(15, 15));
        lineColorPanel.setMinimumSize(new java.awt.Dimension(15, 15));
        lineColorPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lineColorPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout lineColorPanelLayout = new javax.swing.GroupLayout(lineColorPanel);
        lineColorPanel.setLayout(lineColorPanelLayout);
        lineColorPanelLayout.setHorizontalGroup(
            lineColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );
        lineColorPanelLayout.setVerticalGroup(
            lineColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );

        jLabel2.setText("Barva čar:");

        fillColorPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fillColorPanel.setMaximumSize(new java.awt.Dimension(15, 15));
        fillColorPanel.setMinimumSize(new java.awt.Dimension(15, 15));
        fillColorPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fillColorPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout fillColorPanelLayout = new javax.swing.GroupLayout(fillColorPanel);
        fillColorPanel.setLayout(fillColorPanelLayout);
        fillColorPanelLayout.setHorizontalGroup(
            fillColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );
        fillColorPanelLayout.setVerticalGroup(
            fillColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );

        jLabel3.setText("Barva vyplněných oblastí:");

        lineThicknessSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 5, 1));
        lineThicknessSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                lineThicknessSpinnerStateChanged(evt);
            }
        });

        jLabel4.setText("Tloušťka čar:");

        pointColorPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pointColorPanel.setMaximumSize(new java.awt.Dimension(15, 15));
        pointColorPanel.setMinimumSize(new java.awt.Dimension(15, 15));
        pointColorPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pointColorPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pointColorPanelLayout = new javax.swing.GroupLayout(pointColorPanel);
        pointColorPanel.setLayout(pointColorPanelLayout);
        pointColorPanelLayout.setHorizontalGroup(
            pointColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );
        pointColorPanelLayout.setVerticalGroup(
            pointColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );

        jLabel5.setText("Barva bodů:");

        pointThicknessSpinner.setModel(new javax.swing.SpinnerNumberModel(4, 1, 10, 1));
        pointThicknessSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pointThicknessSpinnerStateChanged(evt);
            }
        });

        jLabel6.setText("Tloušťka bodů:");

        selectionColorPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        selectionColorPanel.setMaximumSize(new java.awt.Dimension(15, 15));
        selectionColorPanel.setMinimumSize(new java.awt.Dimension(15, 15));
        selectionColorPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectionColorPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout selectionColorPanelLayout = new javax.swing.GroupLayout(selectionColorPanel);
        selectionColorPanel.setLayout(selectionColorPanelLayout);
        selectionColorPanelLayout.setHorizontalGroup(
            selectionColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );
        selectionColorPanelLayout.setVerticalGroup(
            selectionColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );

        jLabel7.setText("Barva označených bodů a čar:");

        javax.swing.GroupLayout mapSettingsPanelLayout = new javax.swing.GroupLayout(mapSettingsPanel);
        mapSettingsPanel.setLayout(mapSettingsPanelLayout);
        mapSettingsPanelLayout.setHorizontalGroup(
            mapSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mapSettingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mapSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mapSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pointColorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backColorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lineColorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lineThicknessSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fillColorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectionColorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pointThicknessSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(185, Short.MAX_VALUE))
        );
        mapSettingsPanelLayout.setVerticalGroup(
            mapSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mapSettingsPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(mapSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mapSettingsPanelLayout.createSequentialGroup()
                        .addGroup(mapSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(backColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(mapSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mapSettingsPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pointColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mapSettingsPanelLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel5)))
                        .addGap(7, 7, 7)
                        .addComponent(jLabel2))
                    .addComponent(lineColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mapSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fillColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mapSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(selectionColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addGroup(mapSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(pointThicknessSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mapSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(lineThicknessSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 243, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Nastavení mapy", mapSettingsPanel);

        mapPanel.setBackground(new java.awt.Color(255, 255, 255));
        mapPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mapPanel.setPreferredSize(new java.awt.Dimension(0, 0));
        mapPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                mapPanelMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                mapPanelMouseMoved(evt);
            }
        });
        mapPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mapPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mapPanelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout mapPanelLayout = new javax.swing.GroupLayout(mapPanel);
        mapPanel.setLayout(mapPanelLayout);
        mapPanelLayout.setHorizontalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        mapPanelLayout.setVerticalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 566, Short.MAX_VALUE)
        );

        mapScrollPanel.setViewportView(mapPanel);

        loadDataButton.setText("Připojit k databázi");
        loadDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadDataButtonActionPerformed(evt);
            }
        });

        saveChangesButton.setText("Uložit změny do databáze");
        saveChangesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveChangesButtonActionPerformed(evt);
            }
        });

        positionLabel.setText("Pozice: [0, 0]");

        deleteButton.setText("Vymazat označený objekt");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        createDataButton.setText("Naplnit databázi vzorovými daty");
        createDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createDataButtonActionPerformed(evt);
            }
        });

        mainMenu.setLabel("Menu");

        loadDataMenuItem.setText("Připojit k databázi");
        loadDataMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadDataMenuItemActionPerformed(evt);
            }
        });
        mainMenu.add(loadDataMenuItem);

        createDataMenuItem.setText("Naplnit databázi vzorovými daty");
        createDataMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createDataMenuItemActionPerformed(evt);
            }
        });
        mainMenu.add(createDataMenuItem);

        deleteMenuItem.setText("Vymazat označený objekt");
        deleteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMenuItemActionPerformed(evt);
            }
        });
        mainMenu.add(deleteMenuItem);

        saveChangesMenuItem.setText("Uložit změny do databáze");
        saveChangesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveChangesMenuItemActionPerformed(evt);
            }
        });
        mainMenu.add(saveChangesMenuItem);

        exitMenuItem.setText("Konec");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        mainMenu.add(exitMenuItem);

        jMenuBar1.add(mainMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(loadDataButton)
                        .addGap(18, 18, 18)
                        .addComponent(createDataButton)
                        .addGap(18, 18, 18)
                        .addComponent(saveChangesButton)
                        .addGap(18, 18, 18)
                        .addComponent(deleteButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(positionLabel)
                                .addGap(0, 490, Short.MAX_VALUE))
                            .addComponent(mapScrollPanel))
                        .addGap(18, 18, 18)
                        .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loadDataButton)
                    .addComponent(saveChangesButton)
                    .addComponent(deleteButton)
                    .addComponent(createDataButton))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addComponent(mapScrollPanel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(positionLabel)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Nacte data z DB. Predtim zobrazi prihlasovaci dialog, pokud nejsme prihlaseni.
     */
    private void loadData() {
        if (!ConnectDialog.connected)
        {
            new ConnectDialog(this, true).setVisible(true);
        }
        
        if (ConnectDialog.connected) 
        {
            selectRadioButton.setEnabled(true);
            addPointRadioButton.setEnabled(true);
            addPolylineRadioButton.setEnabled(true);
            addPolygonRadioButton.setEnabled(true);
            addRectangleRadioButton.setEnabled(true);
            addCircleRadioButton.setEnabled(true);
            ownersList.setEnabled(true);
            ownerNameField.setEnabled(true);
            ownerAddressField.setEnabled(true);
            saveChangesButton.setEnabled(true);
            saveChangesMenuItem.setEnabled(true);
            createDataButton.setEnabled(true);
            createDataMenuItem.setEnabled(true);
            
        
            
            
            Data.loadData();
            
            ((DrawingPanel)mapPanel).createImageFromData();
            mapScrollPanel.revalidate();
            
            ownersListModel.removeAllElements();
            ownersListNames.clear();
            
            //pridame majitele do GUIcka
            for (int i = 0; i < Data.owners.size(); i++)
            {
                ownersListModel.addElement(Data.owners.get(i).jmeno);
                ownersListNames.add(Data.owners.get(i).jmeno);
            }
            
            
            if (ownersListModel.getSize() != 0) ownersList.setSelectedIndex(0);
            
            addOwnerButton.setEnabled(true);
        
            
        }
    }
    
    /**
     * Ulozi zmeny do DB.
     */
    private void saveChanges() {
        
        //nejdriv ulozime aktualni info oznaceneho objektu z GUI do data
        
        for (int i = 0; i < Data.points.size(); i++) {
            if (Data.pointsInfo.get(i).selected) {
                saveInfo(Data.pointsInfo.get(i));
            }
        }

        for (int i = 0; i < Data.polylines.size(); i++) {
            if (Data.polylinesInfo.get(i).selected) {
                saveInfo(Data.polylinesInfo.get(i));
            }
        }

        for (int i = 0; i < Data.rectangles.size(); i++) {
            if (Data.rectanglesInfo.get(i).selected) {
                saveInfo(Data.rectanglesInfo.get(i));
            }
        }

        for (int i = 0; i < Data.circles.size(); i++) {
            if (Data.circlesInfo.get(i).selected) {
                saveInfo(Data.circlesInfo.get(i));
            }
        }

        for (int i = 0; i < Data.polygons.size(); i++) {
            if (Data.polygonsInfo.get(i).selected) {
                saveInfo(Data.polygonsInfo.get(i));
            }
        }
        
        //ulozime data do DB
        
        try {
            Data.saveData();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvalidObjectException e) {
            e.printStackTrace();
        }
    }
    
    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        // TODO add your handling code here:
        System.exit(0);
        
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void loadDataMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadDataMenuItemActionPerformed
        // TODO add your handling code here:
        loadData();
    }//GEN-LAST:event_loadDataMenuItemActionPerformed

    private void loadDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadDataButtonActionPerformed
        // TODO add your handling code here:
        loadData();
    }//GEN-LAST:event_loadDataButtonActionPerformed

    private void mapPanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mapPanelMouseMoved
        // TODO add your handling code here:
        
        int x = evt.getX();
        int y = evt.getY();
        
        lastX = x;
        lastY = y;
        
        positionLabel.setText("Pozice: [" + x + ", " + y + "]");
        
        if (selectRadioButton.isSelected()) {
            unhover();
            
            for (int i = 0; i < Data.points.size(); i++) {
                if (Data.pointsInfo.get(i).deletedObject) continue;
                if (Point.distance(x, y, Data.points.get(i).x, Data.points.get(i).y) <= ((DrawingPanel) mapPanel).pointThickness / 2.0) {
                    Data.pointsInfo.get(i).hovered = true;
                    mapPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    ((DrawingPanel) mapPanel).createImageFromData();
                    return;
                }
            }

            BasicStroke bstr = new BasicStroke(1);
            for (int i = 0; i < Data.polylines.size(); i++) {
                if (Data.polylinesInfo.get(i).deletedObject) continue;
                for (int j = 1; j < Data.polylines.get(i).size(); j++) {
                    Line2D line = new Line2D.Double(
                            Data.polylines.get(i).get(j - 1).x,
                            Data.polylines.get(i).get(j - 1).y,
                            Data.polylines.get(i).get(j).x,
                            Data.polylines.get(i).get(j).y);

                    if (bstr.createStrokedShape(line).contains(x, y)) {
                        Data.polylinesInfo.get(i).hovered = true;
                        mapPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        ((DrawingPanel) mapPanel).createImageFromData();
                        return;
                    }
                }
            }

            for (int i = 0; i < Data.rectangles.size(); i++) {
                if (Data.rectanglesInfo.get(i).deletedObject) continue;
                if (Data.rectangles.get(i).contains(x, y)) {
                    Data.rectanglesInfo.get(i).hovered = true;
                    mapPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    ((DrawingPanel) mapPanel).createImageFromData();
                    return;
                }
            }

            for (int i = 0; i < Data.circles.size(); i++) {
                if (Data.circlesInfo.get(i).deletedObject) continue;
                if (Data.circles.get(i).contains(x, y)) {
                    Data.circlesInfo.get(i).hovered = true;
                    mapPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    ((DrawingPanel) mapPanel).createImageFromData();
                    return;
                }
            }

            for (int i = 0; i < Data.polygons.size(); i++) {
                if (Data.polygonsInfo.get(i).deletedObject) continue;
                if (Data.polygons.get(i).contains(x, y)) {
                    Data.polygonsInfo.get(i).hovered = true;
                    mapPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    ((DrawingPanel) mapPanel).createImageFromData();
                    return;
                }
            }

            mapPanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            ((DrawingPanel) mapPanel).createImageFromData();
        }
        else if (addPolylineRadioButton.isSelected())
        {
            if (newPolyline)
            {
                ArrayList<Point> polyline = Data.polylines.get(Data.polylines.size()-1);
                polyline.get(polyline.size()-1).x = x;
                polyline.get(polyline.size()-1).y = y;
                ((DrawingPanel) mapPanel).createImageFromData();
            }
        }
        else if (addPolygonRadioButton.isSelected())
        {
            if (newPolygon)
            {
                ArrayList<Point> polyline = Data.polylines.get(Data.polylines.size()-1);
                polyline.get(polyline.size()-1).x = x;
                polyline.get(polyline.size()-1).y = y;
                ((DrawingPanel) mapPanel).createImageFromData();
            }
        }
        else if (addRectangleRadioButton.isSelected())
        {
            if (newRectangle)
            {
                if (x < origin.x) 
                {
                    Data.rectangles.get(Data.rectangles.size()-1).x = x;
                    Data.rectangles.get(Data.rectangles.size()-1).width = origin.x - x;
                }
                else
                {
                    Data.rectangles.get(Data.rectangles.size()-1).x = origin.x;
                    Data.rectangles.get(Data.rectangles.size()-1).width = x - origin.x;
                }
                if (y < origin.y) 
                {
                    Data.rectangles.get(Data.rectangles.size()-1).y = y;
                    Data.rectangles.get(Data.rectangles.size()-1).height = origin.y - y;
                }
                else
                {
                    Data.rectangles.get(Data.rectangles.size()-1).y = origin.y;
                    Data.rectangles.get(Data.rectangles.size()-1).height = y - origin.y;
                }

                ((DrawingPanel) mapPanel).createImageFromData();
            }
        }
        else if (addCircleRadioButton.isSelected())
        {
            if (newCircle)
            {
                int radius = (int)Math.sqrt(Math.pow(x - origin.x, 2) + Math.pow(y - origin.y, 2));
                
                Data.circles.get(Data.circles.size()-1).setFrame(
                        origin.x - radius, 
                        origin.y - radius, 
                        radius * 2, 
                        radius * 2);
    
                ((DrawingPanel) mapPanel).createImageFromData();
            }
        }
        
    }//GEN-LAST:event_mapPanelMouseMoved

    private void mapPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mapPanelMouseDragged
        // TODO add your handling code here:
       
        if (!selectRadioButton.isSelected())
        {
            mapPanelMouseMoved(evt);
            return;
        }
        
        int x = evt.getX();
        int y = evt.getY();
        
        int xDiff = x - lastX;
        int yDiff = y - lastY;
        
        lastX = x;
        lastY = y;
        
        positionLabel.setText("Pozice: [" + x + ", " + y + "]");
        
        for (int i = 0; i < Data.points.size(); i++)
        {
            if (Data.pointsInfo.get(i).selected && Data.pointsInfo.get(i).editable)
            {
                Data.points.get(i).translate(xDiff, yDiff);
                Data.pointsInfo.get(i).modifiedGeometry = true;
            }
        }
        
        for (int i = 0; i < Data.polylines.size(); i++)
        {
            if (Data.polylinesInfo.get(i).selected && Data.polylinesInfo.get(i).editable)
            {
                for (int j = 0; j < Data.polylines.get(i).size(); j++)
                {
                    Data.polylines.get(i).get(j).translate(xDiff, yDiff);
                }
                
                Data.polylinesInfo.get(i).modifiedGeometry = true;
            }
        }
        
        for (int i = 0; i < Data.rectangles.size(); i++)
        {
            if (Data.rectanglesInfo.get(i).selected && Data.rectanglesInfo.get(i).editable)
            {
                Data.rectangles.get(i).translate(xDiff, yDiff);
                Data.rectanglesInfo.get(i).modifiedGeometry = true;
            }
        }
        
        for (int i = 0; i < Data.circles.size(); i++)
        {
            if (Data.circlesInfo.get(i).selected && Data.circlesInfo.get(i).editable)
            {
                Data.circles.get(i).setFrame(Data.circles.get(i).getX() + xDiff, 
                        Data.circles.get(i).getY() + yDiff,
                        Data.circles.get(i).getWidth(),
                        Data.circles.get(i).getHeight());
                Data.circlesInfo.get(i).modifiedGeometry= true;
            }
        }
        
        for (int i = 0; i < Data.polygons.size(); i++)
        {
            if (Data.polygonsInfo.get(i).selected && Data.polygonsInfo.get(i).editable)
            {
                Data.polygons.get(i).translate(xDiff, yDiff);
                Data.polygonsInfo.get(i).modifiedGeometry = true;
            }
        }
        
        ((DrawingPanel)mapPanel).createImageFromData();
         
    }//GEN-LAST:event_mapPanelMouseDragged

    private void mapPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mapPanelMouseExited
        // TODO add your handling code here:
        positionLabel.setText("Pozice: [0, 0]");
        unhover();
    }//GEN-LAST:event_mapPanelMouseExited

    private void pointThicknessSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pointThicknessSpinnerStateChanged
        // TODO add your handling code here:
        ((DrawingPanel)mapPanel).pointThickness = (int)pointThicknessSpinner.getValue();
        ((DrawingPanel)mapPanel).createImageFromData();
    }//GEN-LAST:event_pointThicknessSpinnerStateChanged

    private void pointColorPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pointColorPanelMouseClicked
        // TODO add your handling code here:
        Color color = JColorChooser.showDialog(this, "Barva bodů", ((DrawingPanel)mapPanel).pointColor);
        if (color != null) {
            pointColorPanel.setBackground(color);
            ((DrawingPanel)mapPanel).pointColor = color;
            ((DrawingPanel)mapPanel).createImageFromData();
        }
    }//GEN-LAST:event_pointColorPanelMouseClicked

    private void lineThicknessSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_lineThicknessSpinnerStateChanged
        // TODO add your handling code here:
        ((DrawingPanel)mapPanel).lineThickness = (int)lineThicknessSpinner.getValue();
        ((DrawingPanel)mapPanel).createImageFromData();
    }//GEN-LAST:event_lineThicknessSpinnerStateChanged

    private void fillColorPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fillColorPanelMouseClicked
        // TODO add your handling code here:
        Color color = JColorChooser.showDialog(this, "Barva vyplněných oblastí", ((DrawingPanel)mapPanel).fillColor);
        if (color != null) {
            fillColorPanel.setBackground(color);
            ((DrawingPanel)mapPanel).fillColor = color;
            ((DrawingPanel)mapPanel).createImageFromData();
        }
    }//GEN-LAST:event_fillColorPanelMouseClicked

    private void lineColorPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lineColorPanelMouseClicked
        // TODO add your handling code here:
        Color color = JColorChooser.showDialog(this, "Barva čar", ((DrawingPanel)mapPanel).lineColor);
        if (color != null) {
            lineColorPanel.setBackground(color);
            ((DrawingPanel)mapPanel).lineColor = color;
            ((DrawingPanel)mapPanel).createImageFromData();
        }
    }//GEN-LAST:event_lineColorPanelMouseClicked

    private void backColorPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backColorPanelMouseClicked
        // TODO add your handling code here:
        Color color = JColorChooser.showDialog(this, "Barva pozadí", Color.WHITE);
        if (color != null) {
            backColorPanel.setBackground(color);
            ((DrawingPanel)mapPanel).backColor = color;
            ((DrawingPanel)mapPanel).createImageFromData();
        }
    }//GEN-LAST:event_backColorPanelMouseClicked

    private void selectionColorPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectionColorPanelMouseClicked
        // TODO add your handling code here:
        Color color = JColorChooser.showDialog(this, "Barva označných bodů a čar", Color.WHITE);
        if (color != null) {
            selectionColorPanel.setBackground(color);
            ((DrawingPanel)mapPanel).selectionLineColor = color;
            ((DrawingPanel)mapPanel).selectionFillColor = new Color(color.getRed(), color.getGreen(), color.getBlue(), DEFAULT_SELECTION_FILL_COLOR.getAlpha());
            ((DrawingPanel)mapPanel).createImageFromData();
        }
    }//GEN-LAST:event_selectionColorPanelMouseClicked

    private void mapPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mapPanelMousePressed
        // TODO add your handling code here:
        
        if (selectRadioButton.isSelected()) {

            unselect();
            
            for (int i = 0; i < Data.points.size(); i++) {
                if (Data.pointsInfo.get(i).hovered) {
                    setInfo(Data.pointsInfo.get(i));
                    Data.pointsInfo.get(i).selected = true;
                    try {
                        Data.pointsInfo.get(i).loadFotoFromDB();
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ((DrawingPanel)imagePanel).image = Data.pointsInfo.get(i).imgIcon;
                    imagePanel.repaint();
                    setInfo(Data.pointsInfo.get(i));
                }
            }

            for (int i = 0; i < Data.polylines.size(); i++) {
                if (Data.polylinesInfo.get(i).hovered) {
                    setInfo(Data.polylinesInfo.get(i));
                    Data.polylinesInfo.get(i).selected = true;
                    try {
                        Data.polylinesInfo.get(i).loadFotoFromDB();
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ((DrawingPanel)imagePanel).image = Data.polylinesInfo.get(i).imgIcon;
                    imagePanel.repaint();
                    setInfo(Data.polylinesInfo.get(i));
                } 
            }

            for (int i = 0; i < Data.rectangles.size(); i++) {
                if (Data.rectanglesInfo.get(i).hovered) {
                    setInfo(Data.rectanglesInfo.get(i));
                    Data.rectanglesInfo.get(i).selected = true;
                    try {
                        Data.rectanglesInfo.get(i).loadFotoFromDB();
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ((DrawingPanel)imagePanel).image = Data.rectanglesInfo.get(i).imgIcon;
                    imagePanel.repaint();
                    setInfo(Data.rectanglesInfo.get(i));
                } 
            }

            for (int i = 0; i < Data.circles.size(); i++) {
                if (Data.circlesInfo.get(i).hovered) {
                    setInfo(Data.circlesInfo.get(i));
                    Data.circlesInfo.get(i).selected = true;
                    try {
                        Data.circlesInfo.get(i).loadFotoFromDB();
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ((DrawingPanel)imagePanel).image = Data.circlesInfo.get(i).imgIcon;
                    imagePanel.repaint();
                    setInfo(Data.circlesInfo.get(i));
                } 
            }

            for (int i = 0; i < Data.polygons.size(); i++) {
                if (Data.polygonsInfo.get(i).hovered) {
                    setInfo(Data.polygonsInfo.get(i));
                    Data.polygonsInfo.get(i).selected = true;
                    try {
                        Data.polygonsInfo.get(i).loadFotoFromDB();
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ((DrawingPanel)imagePanel).image = Data.polygonsInfo.get(i).imgIcon;
                    imagePanel.repaint();
                    setInfo(Data.polygonsInfo.get(i));
                } 
            }
        }
        else if (addPointRadioButton.isSelected())
        {
            Data.points.add(new Point(evt.getX(), evt.getY()));
            ObjectInfo info = new ObjectInfo(false);
            Data.pointsInfo.add(info);
        }
        else if (addPolylineRadioButton.isSelected())
        {
            if (evt.getButton() == MouseEvent.BUTTON1)
            {
                if (newPolyline == false)
                {
                    unselect();
                    Data.polylines.add(new ArrayList<Point>());
                    Data.polylines.get(Data.polylines.size()-1).add(new Point(evt.getX(), evt.getY()));
                    Data.polylines.get(Data.polylines.size()-1).add(new Point(evt.getX(), evt.getY()));
                    ObjectInfo info = new ObjectInfo(false);
                    info.selected = true;
                    Data.polylinesInfo.add(info);
                    newPolyline = true;
                    setInfo(info);
                }
                else
                {
                    Data.polylines.get(Data.polylines.size()-1).add(new Point(evt.getX(), evt.getY()));
                }
            }
            else if (evt.getButton() == MouseEvent.BUTTON3)
            {
                if (newPolyline == true)
                {
                    unselect();
                    newPolyline = false;                    
                }
            }
        }
        else if (addPolygonRadioButton.isSelected())
        {
            if (evt.getButton() == MouseEvent.BUTTON1)
            {
                if (newPolygon == false)
                {
                    unselect();
                    Data.polylines.add(new ArrayList<Point>());
                    Data.polylines.get(Data.polylines.size()-1).add(new Point(evt.getX(), evt.getY()));
                    Data.polylines.get(Data.polylines.size()-1).add(new Point(evt.getX(), evt.getY()));
                    ObjectInfo info = new ObjectInfo(false);
                    info.selected = true;
                    Data.polylinesInfo.add(info);
                    newPolygon = true;
                    setInfo(info);
                }
                else
                {
                    Data.polylines.get(Data.polylines.size()-1).add(new Point(evt.getX(), evt.getY()));
                }
            }
            else if (evt.getButton() == MouseEvent.BUTTON3)
            {
                if (newPolygon == true)
                {
                    unselect();
                    newPolygon = false;
                    
                    Polygon polygon = new Polygon();
                    for (int i = 0; i < Data.polylines.get(Data.polylines.size()-1).size(); i++)
                    {
                        polygon.addPoint(Data.polylines.get(Data.polylines.size()-1).get(i).x, 
                                Data.polylines.get(Data.polylines.size()-1).get(i).y);
                    }
                    Data.polygons.add(polygon);
                    Data.polylines.remove(Data.polylines.size()-1);
                    Data.polygonsInfo.add(Data.polylinesInfo.get(Data.polylinesInfo.size()-1));
                    Data.polylinesInfo.remove(Data.polylinesInfo.size()-1);                   
                }
            }

        }
        else if (addRectangleRadioButton.isSelected())
        {
            if (evt.getButton() == MouseEvent.BUTTON1 && !newRectangle) {

                origin.x = evt.getX();
                origin.y = evt.getY();
                Data.rectangles.add(new Rectangle());
                Data.rectangles.get(Data.rectangles.size() - 1).setRect(origin.x, origin.y, 0, 0);
                ObjectInfo info = new ObjectInfo(false);
                info.selected = true;
                Data.rectanglesInfo.add(info);
                newRectangle = true;
                setInfo(info);


            }
            else if (evt.getButton() == MouseEvent.BUTTON3 ||(evt.getButton() == MouseEvent.BUTTON1 && newRectangle))
            {
                if (newRectangle == true)
                {
                    unselect();
                    newRectangle = false;
            

                    
                }
            }
        }
        else if (addCircleRadioButton.isSelected())
        {
            if (evt.getButton() == MouseEvent.BUTTON1 && !newCircle) {
                origin.x = evt.getX();
                origin.y = evt.getY();
                Data.circles.add(new Ellipse2D.Double());
                Data.circles.get(Data.circles.size() - 1).setFrame(origin.x, origin.y, 0, 0);
                ObjectInfo info = new ObjectInfo(false);
                info.selected = true;
                Data.circlesInfo.add(info);
                newCircle = true;
                setInfo(info);


            }
            else if (evt.getButton() == MouseEvent.BUTTON3 ||(evt.getButton() == MouseEvent.BUTTON1 && newCircle))
            {
                if (newCircle == true)
                {
                    unselect();
                    newCircle = false;
            

                    
                }
            }
        }
        
        ((DrawingPanel)mapPanel).createImageFromData();
    }//GEN-LAST:event_mapPanelMousePressed

    /**
     * Oznaci vybrany objekt jako smazany, ale jeste ho nemaze. Predtim zobrazi varovnou hlasku.
     */
    private void deleteSelectedObject()
    {
        int option = JOptionPane.showConfirmDialog(null, "Opravdu vymazat označený objekt?", "Vymazat objekt?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.YES_OPTION)
        {
            
        
            for (int i = 0; i < Data.points.size(); i++)
            {
                if (Data.pointsInfo.get(i).selected)
                {
                    Data.pointsInfo.get(i).deletedObject = true;
                    Data.pointsInfo.get(i).selected = false;
                    Data.pointsInfo.get(i).hovered = false;
                }
            }
        
            for (int i = 0; i < Data.polylines.size(); i++)
            {
                if (Data.polylinesInfo.get(i).selected)
                {
                    Data.polylinesInfo.get(i).deletedObject = true;
                    Data.polylinesInfo.get(i).selected = false;
                    Data.polylinesInfo.get(i).hovered = false;
                }
            }
        
            for (int i = 0; i < Data.rectangles.size(); i++)
            {
                if (Data.rectanglesInfo.get(i).selected)
                {
                    Data.rectanglesInfo.get(i).deletedObject = true;
                    Data.rectanglesInfo.get(i).selected = false;
                    Data.rectanglesInfo.get(i).hovered= false;
                }
            }
        
            for (int i = 0; i < Data.circles.size(); i++)
            {
                if (Data.circlesInfo.get(i).selected)
                {
                    Data.circlesInfo.get(i).deletedObject = true;
                    Data.circlesInfo.get(i).selected = false;
                    Data.circlesInfo.get(i).hovered = false;
                }
            }
        
            for (int i = 0; i < Data.polygons.size(); i++)
            {
                if (Data.polygonsInfo.get(i).selected)
                {
                    Data.polygonsInfo.get(i).deletedObject = true;
                    Data.polygonsInfo.get(i).selected = false;
                    Data.polygonsInfo.get(i).hovered = false;
                }
            }
            
            clearInfo();
        
            ((DrawingPanel)mapPanel).createImageFromData();
        }
    }
    
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        deleteSelectedObject();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void deleteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMenuItemActionPerformed
        // TODO add your handling code here:
        deleteSelectedObject();
    }//GEN-LAST:event_deleteMenuItemActionPerformed

    private void addPolylineRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_addPolylineRadioButtonItemStateChanged
        // TODO add your handling code here:
        unselect();
        if (newPolyline == true) {
            newPolyline = false;
        }
        
        ((DrawingPanel)mapPanel).createImageFromData();
    }//GEN-LAST:event_addPolylineRadioButtonItemStateChanged

    private void addPolygonRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_addPolygonRadioButtonItemStateChanged
        // TODO add your handling code here:
        unselect();
        if (newPolygon == true) {
            newPolygon = false;

            Polygon polygon = new Polygon();
            for (int i = 0; i < Data.polylines.get(Data.polylines.size() - 1).size(); i++) {
                polygon.addPoint(Data.polylines.get(Data.polylines.size() - 1).get(i).x,
                        Data.polylines.get(Data.polylines.size() - 1).get(i).y);
            }
            Data.polygons.add(polygon);
            Data.polylines.remove(Data.polylines.size() - 1);
            Data.polygonsInfo.add(Data.polylinesInfo.get(Data.polylinesInfo.size() - 1));
            Data.polylinesInfo.remove(Data.polylinesInfo.size() - 1);
        }
    }//GEN-LAST:event_addPolygonRadioButtonItemStateChanged

    private void addRectangleRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_addRectangleRadioButtonItemStateChanged
        // TODO add your handling code here:
        unselect(); 
        if (newRectangle == true)
        {
            newRectangle = false;                  
        }
    }//GEN-LAST:event_addRectangleRadioButtonItemStateChanged

    private void addCircleRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_addCircleRadioButtonItemStateChanged
        // TODO add your handling code here:
        unselect();
        if (newCircle == true)
        {
            newCircle = false;                   
        }
    }//GEN-LAST:event_addCircleRadioButtonItemStateChanged

    private void saveChangesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveChangesButtonActionPerformed
        // TODO add your handling code here:
        saveChanges();
    }//GEN-LAST:event_saveChangesButtonActionPerformed

    private void saveChangesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveChangesMenuItemActionPerformed
        // TODO add your handling code here:
        saveChanges();
    }//GEN-LAST:event_saveChangesMenuItemActionPerformed

    private void addOwnerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOwnerButtonActionPerformed
        // TODO add your handling code here:
        if (ownerNameField.getText().isEmpty() || ownerAddressField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Jméno nebo adresa majitele chybí!", "Chyba!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Data.owners.add(new Owner(ownerNameField.getText(), ownerAddressField.getText(), false));
        ownersListModel.addElement(ownerNameField.getText());
        ownersListNames.add(ownerNameField.getText());
        ownersList.setSelectedIndex(ownersListModel.getSize()-1);
        
    }//GEN-LAST:event_addOwnerButtonActionPerformed

    private void updateOwnerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateOwnerButtonActionPerformed
        // TODO add your handling code here:
        if (ownerNameField.getText().isEmpty() || ownerAddressField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Jméno nebo adresa majitele chybí!", "Chyba!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int index = ownersList.getSelectedIndex();
        
        Data.owners.get(index).jmeno = ownerNameField.getText();
        Data.owners.get(index).adresa = ownerAddressField.getText();
        Data.owners.get(index).modifiedOwner = true;
        
        ownersListNames.set(index, ownerNameField.getText());
        ownersListModel.removeAllElements();
        for (int i = 0; i < ownersListNames.size(); i++)
        {
            ownersListModel.addElement(ownersListNames.get(i));
        }   
    }//GEN-LAST:event_updateOwnerButtonActionPerformed

    private void deleteOwnerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteOwnerButtonActionPerformed
        // TODO add your handling code here:
        int index = ownersList.getSelectedIndex();
        int id = Data.owners.get(index).id;
        boolean used = false;
        
        for (int i = 0; i < Data.points.size(); i++) {
            for (int j = 0; j < Data.pointsInfo.get(i).majitele.size(); j++)
            {
                if (!Data.pointsInfo.get(i).deletedObject && 
                        Data.pointsInfo.get(i).majitele.get(j) != null &&
                        Data.pointsInfo.get(i).majitele.get(j).id == id)
                {
                    used = true;
                }
            }
        }

        for (int i = 0; i < Data.polylines.size(); i++) {
            for (int j = 0; j < Data.polylinesInfo.get(i).majitele.size(); j++)
            {
                if (!Data.polylinesInfo.get(i).deletedObject && 
                        Data.polylinesInfo.get(i).majitele.get(j) != null &&
                        Data.polylinesInfo.get(i).majitele.get(j).id == id)
                {
                    used = true;
                }
            }
        }

        for (int i = 0; i < Data.rectangles.size(); i++) {
            for (int j = 0; j < Data.rectanglesInfo.get(i).majitele.size(); j++)
            {
                if (!Data.rectanglesInfo.get(i).deletedObject && 
                        Data.rectanglesInfo.get(i).majitele.get(j) != null &&
                        Data.rectanglesInfo.get(i).majitele.get(j).id == id)
                {
                    used = true;
                }
            }
        }

        for (int i = 0; i < Data.circles.size(); i++) {
            for (int j = 0; j < Data.circlesInfo.get(i).majitele.size(); j++)
            {
                if (!Data.circlesInfo.get(i).deletedObject && 
                        Data.circlesInfo.get(i).majitele.get(j) != null &&
                        Data.circlesInfo.get(i).majitele.get(j).id == id)
                {
                    used = true;
                }
            }
        }

        for (int i = 0; i < Data.polygons.size(); i++) {
            for (int j = 0; j < Data.polygonsInfo.get(i).majitele.size(); j++)
            {
                if (!Data.polygonsInfo.get(i).deletedObject && 
                        Data.polygonsInfo.get(i).majitele.get(j) != null &&
                        Data.polygonsInfo.get(i).majitele.get(j).id == id)
                {
                    used = true;
                }
            }
        }
        
        if (used)
        {
            JOptionPane.showMessageDialog(null, "Tento majitel je aktuálně vedený jako současný či minulý majitel některého objektu, nelze vymazat!", "Chyba!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Data.owners.get(index).deletedOwner = true;
        ownersListModel.removeElementAt(index);
        ownersListNames.remove(index);
        if (ownersListModel.getSize() == 0)
        {
            ownersList.setSelectedIndex(-1);
            
        }
        else
        {
            ownersList.setSelectedIndex(ownersListModel.getSize()-1);   
        }
        
        
    }//GEN-LAST:event_deleteOwnerButtonActionPerformed

    private void ownersListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ownersListValueChanged
        // TODO add your handling code here:
        if (ownersList.getSelectedIndex() == -1)
        {
            updateOwnerButton.setEnabled(false);
            deleteOwnerButton.setEnabled(false);
            ownerNameField.setText("");
            ownerAddressField.setText("");
        }
        else
        {
            updateOwnerButton.setEnabled(true);
            deleteOwnerButton.setEnabled(true);
        }
        if (ownersListModel.getSize() == 0 || Data.owners.size() == 0 || ownersList.getSelectedIndex() == -1) return;
        int index = -1;
        for (int i = 0; i < Data.owners.size(); i++)
        {
            if (!Data.owners.get(i).deletedOwner) index++;
            if (index == ownersList.getSelectedIndex())
            {
                ownerNameField.setText(Data.owners.get(i).jmeno);
                ownerAddressField.setText(Data.owners.get(i).adresa);
                break;
            }
        }
    }//GEN-LAST:event_ownersListValueChanged

    private void loadImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadImageButtonActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < Data.points.size(); i++) {
            if (Data.pointsInfo.get(i).selected) {
                JFileChooser fc = new JFileChooser();
                int returnVal = fc.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println(fc.getSelectedFile().getAbsolutePath());
                    String path = fc.getSelectedFile().getAbsolutePath();
                    try {
                        ((DrawingPanel)imagePanel).image = ImageIO.read(new File(path));
                        int width = ((DrawingPanel)imagePanel).image.getWidth();
                        int height = ((DrawingPanel)imagePanel).image.getHeight();
                        Dimension dim = new Dimension(width, height);
                        imagePanel.setPreferredSize(dim);
                        imagePanel.setSize(dim);
                        imagePanel.repaint();
                        Data.pointsInfo.get(i).modifiedImage = true;
                    } catch (IOException e) {
                    }   
                    Data.pointsInfo.get(i).imgPath = fc.getSelectedFile().getAbsolutePath();
                } 
                return;
            }
        }

        for (int i = 0; i < Data.polylines.size(); i++) {
            if (Data.polylinesInfo.get(i).selected) {
                JFileChooser fc = new JFileChooser();
                int returnVal = fc.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println(fc.getSelectedFile().getAbsolutePath());
                    String path = fc.getSelectedFile().getAbsolutePath();
                    try {
                        ((DrawingPanel)imagePanel).image = ImageIO.read(new File(path));
                        int width = ((DrawingPanel)imagePanel).image.getWidth();
                        int height = ((DrawingPanel)imagePanel).image.getHeight();
                        Dimension dim = new Dimension(width, height);
                        imagePanel.setPreferredSize(dim);
                        imagePanel.setSize(dim);
                        imagePanel.repaint();
                        Data.polylinesInfo.get(i).modifiedImage = true;
                    } catch (IOException e) {
                    }
                    Data.polylinesInfo.get(i).imgPath = fc.getSelectedFile().getAbsolutePath();
                } 
                return;
            }
        }

        for (int i = 0; i < Data.rectangles.size(); i++) {
            if (Data.rectanglesInfo.get(i).selected) {
                JFileChooser fc = new JFileChooser();
                int returnVal = fc.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println(fc.getSelectedFile().getAbsolutePath());
                    String path = fc.getSelectedFile().getAbsolutePath();
                    try {
                        ((DrawingPanel)imagePanel).image = ImageIO.read(new File(path));
                        int width = ((DrawingPanel)imagePanel).image.getWidth();
                        int height = ((DrawingPanel)imagePanel).image.getHeight();
                        Dimension dim = new Dimension(width, height);
                        imagePanel.setPreferredSize(dim);
                        imagePanel.setSize(dim);
                        imagePanel.repaint();
                        Data.rectanglesInfo.get(i).modifiedImage = true;
                    } catch (IOException e) {
                    }
                    Data.rectanglesInfo.get(i).imgPath = fc.getSelectedFile().getAbsolutePath();
                } 
                return;
            }
        }

        for (int i = 0; i < Data.circles.size(); i++) {
            if (Data.circlesInfo.get(i).selected) {
                JFileChooser fc = new JFileChooser();
                int returnVal = fc.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println(fc.getSelectedFile().getAbsolutePath());
                    String path = fc.getSelectedFile().getAbsolutePath();
                    try {
                        ((DrawingPanel)imagePanel).image = ImageIO.read(new File(path));
                        int width = ((DrawingPanel)imagePanel).image.getWidth();
                        int height = ((DrawingPanel)imagePanel).image.getHeight();
                        Dimension dim = new Dimension(width, height);
                        imagePanel.setPreferredSize(dim);
                        imagePanel.setSize(dim);
                        imagePanel.repaint();
                        Data.circlesInfo.get(i).modifiedImage = true;
                    } catch (IOException e) {
                    }
                    Data.circlesInfo.get(i).imgPath = fc.getSelectedFile().getAbsolutePath();
                } 
                return;
            }
        }

        for (int i = 0; i < Data.polygons.size(); i++) {
            if (Data.polygonsInfo.get(i).selected) {
                JFileChooser fc = new JFileChooser();
                int returnVal = fc.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println(fc.getSelectedFile().getAbsolutePath());
                    String path = fc.getSelectedFile().getAbsolutePath();
                    try {
                        ((DrawingPanel)imagePanel).image = ImageIO.read(new File(path));
                        int width = ((DrawingPanel)imagePanel).image.getWidth();
                        int height = ((DrawingPanel)imagePanel).image.getHeight();
                        Dimension dim = new Dimension(width, height);
                        imagePanel.setPreferredSize(dim);
                        imagePanel.setSize(dim);
                        imagePanel.repaint();
                        Data.polygonsInfo.get(i).modifiedImage = true;
                    } catch (IOException e) {
                    }
                    Data.polygonsInfo.get(i).imgPath = fc.getSelectedFile().getAbsolutePath();
                } 
                return;
            }
        }
    }//GEN-LAST:event_loadImageButtonActionPerformed

    private void saveImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveImageButtonActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < Data.points.size(); i++) {
            if (Data.pointsInfo.get(i).selected) {
                JFileChooser fc = new JFileChooser();
                int returnVal = fc.showSaveDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println(fc.getSelectedFile().getAbsolutePath());
                    try {
                        Data.pointsInfo.get(i).saveFotoFromDB(fc.getSelectedFile().getAbsolutePath());
                    } catch (SQLException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }                    
                } 
                return;
            }
        }

        for (int i = 0; i < Data.polylines.size(); i++) {
            if (Data.polylinesInfo.get(i).selected) {
                JFileChooser fc = new JFileChooser();
                int returnVal = fc.showSaveDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println(fc.getSelectedFile().getAbsolutePath());
                    try {
                        Data.polylinesInfo.get(i).saveFotoFromDB(fc.getSelectedFile().getAbsolutePath());
                    } catch (SQLException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } 
                return;
            }
        }

        for (int i = 0; i < Data.rectangles.size(); i++) {
            if (Data.rectanglesInfo.get(i).selected) {
                JFileChooser fc = new JFileChooser();
                int returnVal = fc.showSaveDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println(fc.getSelectedFile().getAbsolutePath());
                    try {
                        Data.rectanglesInfo.get(i).saveFotoFromDB(fc.getSelectedFile().getAbsolutePath());
                    } catch (SQLException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } 
                return;
            }
        }

        for (int i = 0; i < Data.circles.size(); i++) {
            if (Data.circlesInfo.get(i).selected) {
                JFileChooser fc = new JFileChooser();
                int returnVal = fc.showSaveDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println(fc.getSelectedFile().getAbsolutePath());
                    try {
                        Data.circlesInfo.get(i).saveFotoFromDB(fc.getSelectedFile().getAbsolutePath());
                    } catch (SQLException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }                    
                } 
                return;
            }
        }

        for (int i = 0; i < Data.polygons.size(); i++) {
            if (Data.polygonsInfo.get(i).selected) {
                JFileChooser fc = new JFileChooser();
                int returnVal = fc.showSaveDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println(fc.getSelectedFile().getAbsolutePath());
                    try {
                        Data.polygonsInfo.get(i).saveFotoFromDB(fc.getSelectedFile().getAbsolutePath());
                    } catch (SQLException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }                    
                } 
                return;
            }
        }
    }//GEN-LAST:event_saveImageButtonActionPerformed

    private void rotateImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rotateImageButtonActionPerformed
        // TODO add your handling code here:
        //tady se bude rotovat obrazkem
        int width = ((DrawingPanel)imagePanel).image.getWidth();
        int height = ((DrawingPanel)imagePanel).image.getHeight();
        BufferedImage rotateImg = new BufferedImage(height, width, ((DrawingPanel)imagePanel).image.getType());

        for(int i=0; i<width; i++) {
            for(int j=0; j<height; j++) {
                rotateImg.setRGB(height-1-j, i, ((DrawingPanel)imagePanel).image.getRGB(i, j));
            }
        }
        
        ((DrawingPanel)imagePanel).image = rotateImg;
        imagePanel.repaint();
        
        for (int i = 0; i < Data.points.size(); i++) {
            if (Data.pointsInfo.get(i).selected) {
                Data.pointsInfo.get(i).modifiedImage = true;
                Data.pointsInfo.get(i).rotateImage = true;
                return;
            }
        }

        for (int i = 0; i < Data.polylines.size(); i++) {
            if (Data.polylinesInfo.get(i).selected) {
                Data.polylinesInfo.get(i).modifiedImage = true;
                Data.polylinesInfo.get(i).rotateImage = true;
                return;
            }
        }

        for (int i = 0; i < Data.rectangles.size(); i++) {
            if (Data.rectanglesInfo.get(i).selected) {
                Data.rectanglesInfo.get(i).modifiedImage = true;
                Data.rectanglesInfo.get(i).rotateImage = true;
                return;
            }
        }

        for (int i = 0; i < Data.circles.size(); i++) {
            if (Data.circlesInfo.get(i).selected) {
                Data.circlesInfo.get(i).modifiedImage = true;
                Data.circlesInfo.get(i).rotateImage = true;
                return;
            }
        }

        for (int i = 0; i < Data.polygons.size(); i++) {
            if (Data.polygonsInfo.get(i).selected) {
                Data.polygonsInfo.get(i).modifiedImage = true;
                Data.polygonsInfo.get(i).rotateImage = true;
                return;
            }
        }
    }//GEN-LAST:event_rotateImageButtonActionPerformed

    private void createDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createDataButtonActionPerformed
        // TODO add your handling code here:
        createData();
    }//GEN-LAST:event_createDataButtonActionPerformed

    private void createDataMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createDataMenuItemActionPerformed
        // TODO add your handling code here:
        createData();
    }//GEN-LAST:event_createDataMenuItemActionPerformed

    private void addPointRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_addPointRadioButtonItemStateChanged
        // TODO add your handling code here:
        unselect(); 
    }//GEN-LAST:event_addPointRadioButtonItemStateChanged

    private void ownersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ownersButtonActionPerformed
        // TODO add your handling code here:
        new OwnerHistoryDialog(this, true).setVisible(true);
    }//GEN-LAST:event_ownersButtonActionPerformed

    private void similarImagesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_similarImagesButtonActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < Data.points.size(); i++) {
            if (Data.pointsInfo.get(i).selected) {
                try {
                    new SimilarImagesDialog(this, true, Data.pointsInfo.get(i).findSimilarFoto()).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }              
                return;
            }
        }

        for (int i = 0; i < Data.polylines.size(); i++) {
            if (Data.polylinesInfo.get(i).selected) {
                try {
                    new SimilarImagesDialog(this, true, Data.polylinesInfo.get(i).findSimilarFoto()).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }                
                return;
            }
        }

        for (int i = 0; i < Data.rectangles.size(); i++) {
            if (Data.rectanglesInfo.get(i).selected) {
                try {
                    new SimilarImagesDialog(this, true, Data.rectanglesInfo.get(i).findSimilarFoto()).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }                
                return;
            }
        }

        for (int i = 0; i < Data.circles.size(); i++) {
            if (Data.circlesInfo.get(i).selected) {
                try {
                    new SimilarImagesDialog(this, true, Data.circlesInfo.get(i).findSimilarFoto()).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
                return;
            }
        }

        for (int i = 0; i < Data.polygons.size(); i++) {
            if (Data.polygonsInfo.get(i).selected) {
                try {
                    new SimilarImagesDialog(this, true, Data.polygonsInfo.get(i).findSimilarFoto()).setVisible(true);
                 } catch (SQLException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
                return;
            }
        }
        
    }//GEN-LAST:event_similarImagesButtonActionPerformed

    /**
     * Necha uzivatele vybrat SQL skript pro nacteni vzorovych dat a pak je nacte.
     */
    private void createData()
    {
        JFileChooser fc = new JFileChooser();
                int returnVal = fc.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println(fc.getSelectedFile().getAbsolutePath());
                    Data.defaultDataPath = fc.getSelectedFile().getAbsolutePath();
                }
        Data.loadDefaultData();
        System.out.println("Vykreslování objektů...");
        Data.loadData();
    }
    
    /**
     * Odznaci prave oznaceny objekt a ulozi jeho pripadne modifikace.
     */
    private void unselect()
    {
        for (int i = 0; i < Data.points.size(); i++) {
            if (Data.pointsInfo.get(i).selected) {
                saveInfo(Data.pointsInfo.get(i));
                Data.pointsInfo.get(i).selected = false;
            }
        }

        for (int i = 0; i < Data.polylines.size(); i++) {
            if (Data.polylinesInfo.get(i).selected) {
                saveInfo(Data.polylinesInfo.get(i));
                Data.polylinesInfo.get(i).selected = false;
            }
        }

        for (int i = 0; i < Data.rectangles.size(); i++) {
            if (Data.rectanglesInfo.get(i).selected) {
                saveInfo(Data.rectanglesInfo.get(i));
                Data.rectanglesInfo.get(i).selected = false;
            }
        }

        for (int i = 0; i < Data.circles.size(); i++) {
            if (Data.circlesInfo.get(i).selected) {
                saveInfo(Data.circlesInfo.get(i));
                Data.circlesInfo.get(i).selected = false;
            }
        }

        for (int i = 0; i < Data.polygons.size(); i++) {
            if (Data.polygonsInfo.get(i).selected) {
                saveInfo(Data.polygonsInfo.get(i));
                Data.polygonsInfo.get(i).selected = false;
            }
        }
        
        clearInfo();
        ((DrawingPanel)imagePanel).image = null;
        imagePanel.repaint();
        ((DrawingPanel)mapPanel).createImageFromData();
        
    }
    
    /**
     * Nastavi pro vsechny objekty, ze nad nimi neni mys.
     */
    private void unhover()
    {
        for (int i = 0; i < Data.points.size(); i++)
        {
            Data.pointsInfo.get(i).hovered = false;
        }
        
        for (int i = 0; i < Data.polylines.size(); i++)
        {
            Data.polylinesInfo.get(i).hovered = false;
        }
        
        for (int i = 0; i < Data.rectangles.size(); i++)
        {
            
            Data.rectanglesInfo.get(i).hovered = false;
        }
        
        for (int i = 0; i < Data.circles.size(); i++)
        {
            Data.circlesInfo.get(i).hovered = false;
        }
        
        for (int i = 0; i < Data.polygons.size(); i++)
        {
            Data.polygonsInfo.get(i).hovered = false;
        }
        
        ((DrawingPanel)mapPanel).createImageFromData();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        if (args.length == 2) {
            if (args[0].equals("--load")) {
                Data.defaultData = true;
                Data.defaultDataPath = args[1];
            }
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                new MainWindow().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton addCircleRadioButton;
    private javax.swing.JButton addOwnerButton;
    private javax.swing.JRadioButton addPointRadioButton;
    private javax.swing.JRadioButton addPolygonRadioButton;
    private javax.swing.JRadioButton addPolylineRadioButton;
    private javax.swing.JRadioButton addRectangleRadioButton;
    private javax.swing.JPanel backColorPanel;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JLabel centrumVzdalenost;
    private javax.swing.JButton createDataButton;
    private javax.swing.JMenuItem createDataMenuItem;
    private javax.swing.JButton deleteButton;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JButton deleteOwnerButton;
    private javax.swing.JTextArea descriptionField;
    private javax.swing.JPanel editPanel;
    private javax.swing.JTextField existenceDoField;
    private javax.swing.JTextField existenceOdField;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JPanel fillColorPanel;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JScrollPane infoPanel;
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
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel lineColorPanel;
    private javax.swing.JSpinner lineThicknessSpinner;
    private javax.swing.JButton loadDataButton;
    private javax.swing.JMenuItem loadDataMenuItem;
    private javax.swing.JButton loadImageButton;
    private javax.swing.JMenu mainMenu;
    private javax.swing.JPanel mapPanel;
    private javax.swing.JScrollPane mapScrollPanel;
    private javax.swing.JPanel mapSettingsPanel;
    private javax.swing.JLabel nejblizsiZastavka;
    private javax.swing.JTextField objectNameField;
    private javax.swing.JLabel obvod;
    private javax.swing.JTextField ownerAddressField;
    private javax.swing.JLabel ownerAddressLabel;
    private javax.swing.JTextField ownerNameField;
    private javax.swing.JLabel ownerNameLabel;
    private javax.swing.JButton ownersButton;
    private javax.swing.JList<String> ownersList;
    private javax.swing.JScrollPane ownersPanel;
    private javax.swing.JLabel plocha;
    private javax.swing.JPanel pointColorPanel;
    private javax.swing.JSpinner pointThicknessSpinner;
    private javax.swing.JLabel positionLabel;
    private javax.swing.JTextField rekonstrukceField;
    private javax.swing.JButton rotateImageButton;
    private javax.swing.JButton saveChangesButton;
    private javax.swing.JMenuItem saveChangesMenuItem;
    private javax.swing.JButton saveImageButton;
    private javax.swing.JLabel sectorLabel;
    private javax.swing.JRadioButton selectRadioButton;
    private javax.swing.JPanel selectionColorPanel;
    private javax.swing.JButton similarImagesButton;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JComboBox<String> typeComboBox;
    private javax.swing.JButton updateOwnerButton;
    // End of variables declaration//GEN-END:variables

    /**
     * Zobrazi v GUI informace o danem objektu.
     * @param info Informace o objektu, ktere se maji zobrazit v GUI
     */
    private void setInfo(ObjectInfo info) {
        loadImageButton.setEnabled(info.editable);
        saveImageButton.setEnabled(true);
        rotateImageButton.setEnabled(info.editable);
        similarImagesButton.setEnabled(true);
        
        deleteButton.setEnabled(info.editable);
        deleteMenuItem.setEnabled(info.editable);
        
        objectNameField.setEnabled(info.editable);
        typeComboBox.setEnabled(info.editable);
        ownersButton.setEnabled(info.editable);
        existenceOdField.setEnabled(info.editable);
        existenceDoField.setEnabled(info.editable);
        rekonstrukceField.setEnabled(info.editable);
        descriptionField.setEnabled(info.editable);
        
        objectNameField.setText(info.nazev);
        for (int i = 0; i < ObjectInfo.NUM_TYPES; i++)
        {
            if (info.typ.equals(ObjectInfo.TYPES[i]))
            {
                typeComboBox.setSelectedIndex(i);
                break;
            }
        }
        existenceOdField.setText(dateToString(info.existenceOd));
        existenceDoField.setText(dateToString(info.existenceDo));
        rekonstrukceField.setText(dateToString(info.rekonstrukce));
        descriptionField.setText(info.popis);
        sectorLabel.setText(String.valueOf(info.sektor));
        
        if (info.majitele.size() == 0 || info.majitele.get(info.majitele.size()-1) == null) 
        {
            ownerNameLabel.setText("Bez majitele");
            ownerAddressLabel.setText("");
        }
        else
        {
            ownerNameLabel.setText(info.majitele.get(info.majitele.size()-1).jmeno);
            ownerAddressLabel.setText(info.majitele.get(info.majitele.size()-1).adresa);
        }
        obvod.setText(Integer.toString(info.obvod));
        plocha.setText(Integer.toString(info.plocha));
        nejblizsiZastavka.setText(info.nejblizsiZastavka);
        centrumVzdalenost.setText(Integer.toString(info.centrum));
        
    }
    
    /**
     * Ulozi informace z GUI do daneho ObjectInfo.
     * @param info Sem se ulozi aktualni informace z GUI.
     */
    private void saveInfo(ObjectInfo info)
    {
        if (!info.editable) return;
        
        if (info.nazev != objectNameField.getText())
        {
            info.nazev = objectNameField.getText();
            info.modifiedInfo = true;
        }
        if (info.typ != ObjectInfo.TYPES[typeComboBox.getSelectedIndex()])
        {
            info.typ = ObjectInfo.TYPES[typeComboBox.getSelectedIndex()];
            info.modifiedInfo = true;
        }
        
        Date existenceOd = null;
        Date existenceDo = null;
        Date rekonstrukce = null;
        
        try
        {
            existenceOd = stringToDate(existenceOdField.getText());
            if (info.existenceOd != existenceOd)
            {
                info.existenceOd = existenceOd;
                info.modifiedInfo = true;
            }
        }
        catch (IllegalArgumentException e)
        { 
            existenceOdField.setText(dateToString(info.existenceOd));
        }
        
        try
        {
            existenceDo = stringToDate(existenceDoField.getText());
            if (info.existenceDo != existenceDo)
            {
                info.existenceDo = existenceDo;
                info.modifiedInfo = true;
            }
        }
        catch (IllegalArgumentException e)
        { 
            existenceDoField.setText(dateToString(info.existenceDo));
        }
        
        try
        {
            rekonstrukce = stringToDate(rekonstrukceField.getText());
            if (info.rekonstrukce != rekonstrukce)
            {
                info.rekonstrukce = rekonstrukce;
                info.modifiedInfo = true;
            }
        }
        catch (IllegalArgumentException e)
        { 
            rekonstrukceField.setText(dateToString(info.rekonstrukce));
        }
        
        if (info.popis != descriptionField.getText())
        {
            info.popis = descriptionField.getText();
            info.modifiedInfo = true;
        }
    }
    
    /**
     * Vycisti GUI od vsech informaci.
     */
    private void clearInfo() {
        loadImageButton.setEnabled(false);
        saveImageButton.setEnabled(false);
        rotateImageButton.setEnabled(false);
        similarImagesButton.setEnabled(false);
        
        deleteButton.setEnabled(false);
        deleteMenuItem.setEnabled(false);
        
        objectNameField.setEnabled(false);
        typeComboBox.setEnabled(false);
        ownersButton.setEnabled(false);
        existenceOdField.setEnabled(false);
        existenceDoField.setEnabled(false);
        rekonstrukceField.setEnabled(false);
        descriptionField.setEnabled(false);
        
        objectNameField.setText("");
        existenceOdField.setText("");
        existenceDoField.setText("");
        rekonstrukceField.setText("");
        descriptionField.setText("");
        sectorLabel.setText("");
        ownerNameLabel.setText("");
        ownerAddressLabel.setText("");
        plocha.setText("");
        obvod.setText("");
        nejblizsiZastavka.setText("");
        centrumVzdalenost.setText("");
    }
    
    /**
     * Prevede Date na String. 
     * @param date Date, ktere se ma prevest na String.
     * @return Dane Date jako String. Prazdny retezec, pokud je date null.
     */
    public static String dateToString(Date date)
    {
        if (date == null) return "";
        
        int day = date.getDate();

        int month = date.getMonth() + 1;

        int year = date.getYear() + 1900;

        String sdate = Integer.toString(day) + "." + Integer.toString(month) + "." + Integer.toString(year);

        return sdate;
    }
    
    /**
     * Prevede String na Date. 
     * @param sdate String, ktery se ma prevest na Date.
     * @return Dany String jako Date. null, pokud je sdate null nebo prazdny retezec.
     * @throws IllegalArgumentException
     */
    public static Date stringToDate(String sdate) throws IllegalArgumentException 
    {
        if (sdate.isEmpty() || sdate == null) return null;
        
        int index1 = sdate.indexOf(".", 0);
        if (index1 == -1 || index1 == sdate.length()-1) throw new IllegalArgumentException();
        
        int index2 = sdate.indexOf(".", index1+1);
        if (index2 == -1 || index2 == sdate.length()-1) throw new IllegalArgumentException();
        
        int day, month, year;
        
        try
        {
            day = Integer.parseInt(sdate.substring(0, index1));
            month = Integer.parseInt(sdate.substring(index1+1, index2)) - 1;
            year = Integer.parseInt(sdate.substring(index2+1)) - 1900;
        } 
        catch (NumberFormatException e)
        {
             throw new IllegalArgumentException();
        }
        
        if (day < 1 || day > 31) throw new IllegalArgumentException();
        if (month < 0 || month > 11)  throw new IllegalArgumentException();
        if (year < 0)  throw new IllegalArgumentException();
        
        return new Date(year, month, day); 
    }
    
 

}
