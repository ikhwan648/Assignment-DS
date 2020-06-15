/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumpy.grof;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.swing.ImageIcon;


/**
 *
 * @author user
 */
public class MapGUI extends javax.swing.JFrame {

    Map map;
    ArrayList<Point> point = new ArrayList<>();
    
    int colonyMin;
    int Index=0;
    
    
    Random rand = new Random();
    int[] place = null;
    int[] num = null;
    
    //Random map
    public MapGUI() {
        initComponents();
        
        this.setTitle("Random Map");
        this.map = new Map();
        this.point = map.getPoint();
        this.colonyMin = map.getColony();
        
        place = new int[point.size()];
        this.num = new int[point.size()];
        
        setup.setVisible(false);
        updated.setVisible(false);
        random.setVisible(true);
        
        System.out.println(map);
        
        p1.setVisible(false);
        p2.setVisible(false);
        p3.setVisible(false);
        p4.setVisible(false);
        p5.setVisible(false);
        p6.setVisible(false);
        p7.setVisible(false);
        p8.setVisible(false);
        p9.setVisible(false);
        p10.setVisible(false);
        p11.setVisible(false);
        p12.setVisible(false);
        p13.setVisible(false);
        p14.setVisible(false);
        p15.setVisible(false);
        p16.setVisible(false);
        p17.setVisible(false);
        p18.setVisible(false);
        p19.setVisible(false);
        p20.setVisible(false);
        
        
        
        //generate unique place
        for(int i=0;i<point.size();i++){
            num[i] = 1+rand.nextInt(20);
            
            for(int j=0;j<i;j++){
                if(num[i]==num[j])
                    i--;
            }
        }
        
        
        
        
        //set visible chosen places
        for(int i=1;i<=point.size();i++){
          
                String nombor = String.valueOf(i);
                
            
                switch(num[i-1]){
               
                case 1: p1.setName(nombor);
                        p1.setVisible(true); break;
                case 2: p2.setName(nombor);
                        p2.setVisible(true); break;
                case 3: p3.setName(nombor);
                        p3.setVisible(true); break;
                case 4: p4.setName(nombor);
                        p4.setVisible(true); break;
                case 5: p5.setName(nombor);
                        p5.setVisible(true); break;
                case 6: p6.setName(nombor);
                        p6.setVisible(true); break;
                case 7: p7.setName(nombor);
                        p7.setVisible(true); break;
                case 8: p8.setName(nombor);
                        p8.setVisible(true); break;
                case 9: p9.setName(nombor);
                        p9.setVisible(true); break;
                case 10: p10.setName(nombor);
                        p10.setVisible(true); break;
                case 11: p11.setName(nombor);
                        p11.setVisible(true); break;
                case 12: p12.setName(nombor);
                        p12.setVisible(true); break;
                case 13: p13.setName(nombor);
                        p13.setVisible(true); break;
                case 14: p14.setName(nombor);
                        p14.setVisible(true); break;
                case 15: p15.setName(nombor);
                        p15.setVisible(true); break;
                case 16: p16.setName(nombor);
                        p16.setVisible(true); break;
                case 17: p17.setName(nombor);
                        p17.setVisible(true); break;
                case 18: p18.setName(nombor);
                        p18.setVisible(true); break;
                case 19: p19.setName(nombor);
                        p19.setVisible(true); break;
                case 20: p20.setName(nombor);
                        p20.setVisible(true); break;
                }
                
           
            
            
        }
        
    }
    
    //updated map
    public MapGUI(Map map,ArrayList<Point> points,int colonyMin,int[] num) {
        initComponents();
        
        
        
        this.setTitle("Updated Map");
        jButton1.setVisible(false);
        this.map=map;
        point = points;
        
        
        this.colonyMin=colonyMin;
        place = new int[point.size()];
        this.num = new int[point.size()];
        
        setup.setVisible(false);
        updated.setVisible(true);
        random.setVisible(false);
        
        
        System.out.println(map);
        
        p1.setVisible(false);
        p2.setVisible(false);
        p3.setVisible(false);
        p4.setVisible(false);
        p5.setVisible(false);
        p6.setVisible(false);
        p7.setVisible(false);
        p8.setVisible(false);
        p9.setVisible(false);
        p10.setVisible(false);
        p11.setVisible(false);
        p12.setVisible(false);
        p13.setVisible(false);
        p14.setVisible(false);
        p15.setVisible(false);
        p16.setVisible(false);
        p17.setVisible(false);
        p18.setVisible(false);
        p19.setVisible(false);
        p20.setVisible(false);
        
        //set visible chosen places
        for(int i=1;i<=point.size();i++){
          
                String nombor = String.valueOf(i);
                
            
                switch(num[i-1]){
               
                case 1: p1.setName(nombor);
                        p1.setVisible(true); break;
                case 2: p2.setName(nombor);
                        p2.setVisible(true); break;
                case 3: p3.setName(nombor);
                        p3.setVisible(true); break;
                case 4: p4.setName(nombor);
                        p4.setVisible(true); break;
                case 5: p5.setName(nombor);
                        p5.setVisible(true); break;
                case 6: p6.setName(nombor);
                        p6.setVisible(true); break;
                case 7: p7.setName(nombor);
                        p7.setVisible(true); break;
                case 8: p8.setName(nombor);
                        p8.setVisible(true); break;
                case 9: p9.setName(nombor);
                        p9.setVisible(true); break;
                case 10: p10.setName(nombor);
                        p10.setVisible(true); break;
                case 11: p11.setName(nombor);
                        p11.setVisible(true); break;
                case 12: p12.setName(nombor);
                        p12.setVisible(true); break;
                case 13: p13.setName(nombor);
                        p13.setVisible(true); break;
                case 14: p14.setName(nombor);
                        p14.setVisible(true); break;
                case 15: p15.setName(nombor);
                        p15.setVisible(true); break;
                case 16: p16.setName(nombor);
                        p16.setVisible(true); break;
                case 17: p17.setName(nombor);
                        p17.setVisible(true); break;
                case 18: p18.setName(nombor);
                        p18.setVisible(true); break;
                case 19: p19.setName(nombor);
                        p19.setVisible(true); break;
                case 20: p20.setName(nombor);
                        p20.setVisible(true); break;
                }
        }
    }
        
    //setup map
    public MapGUI(Map map,Point[] points,int colonyMin) {
        initComponents();
        
        this.setTitle("Setup Map");
        this.num =num;
        
        setup.setVisible(true);
        updated.setVisible(false);
        random.setVisible(false);
        
        this.map=map;
        point = new ArrayList<Point>(Arrays.asList(points));
        this.colonyMin=colonyMin;
        place = new int[point.size()];
        this.num = new int[point.size()];
        
        
        System.out.println(map);
        
        p1.setVisible(false);
        p2.setVisible(false);
        p3.setVisible(false);
        p4.setVisible(false);
        p5.setVisible(false);
        p6.setVisible(false);
        p7.setVisible(false);
        p8.setVisible(false);
        p9.setVisible(false);
        p10.setVisible(false);
        p11.setVisible(false);
        p12.setVisible(false);
        p13.setVisible(false);
        p14.setVisible(false);
        p15.setVisible(false);
        p16.setVisible(false);
        p17.setVisible(false);
        p18.setVisible(false);
        p19.setVisible(false);
        p20.setVisible(false);
        
        
        
        //generate unique place
        for(int i=0;i<point.size();i++){
            num[i] = 1+rand.nextInt(20);
            
            for(int j=0;j<i;j++){
                if(num[i]==num[j])
                    i--;
            }
        }
        
        
        
        
        //set visible chosen places
        for(int i=1;i<=point.size();i++){
          
                String nombor = String.valueOf(i);
                
            
                switch(num[i-1]){
               
                case 1: p1.setName(nombor);
                        p1.setVisible(true); break;
                case 2: p2.setName(nombor);
                        p2.setVisible(true); break;
                case 3: p3.setName(nombor);
                        p3.setVisible(true); break;
                case 4: p4.setName(nombor);
                        p4.setVisible(true); break;
                case 5: p5.setName(nombor);
                        p5.setVisible(true); break;
                case 6: p6.setName(nombor);
                        p6.setVisible(true); break;
                case 7: p7.setName(nombor);
                        p7.setVisible(true); break;
                case 8: p8.setName(nombor);
                        p8.setVisible(true); break;
                case 9: p9.setName(nombor);
                        p9.setVisible(true); break;
                case 10: p10.setName(nombor);
                        p10.setVisible(true); break;
                case 11: p11.setName(nombor);
                        p11.setVisible(true); break;
                case 12: p12.setName(nombor);
                        p12.setVisible(true); break;
                case 13: p13.setName(nombor);
                        p13.setVisible(true); break;
                case 14: p14.setName(nombor);
                        p14.setVisible(true); break;
                case 15: p15.setName(nombor);
                        p15.setVisible(true); break;
                case 16: p16.setName(nombor);
                        p16.setVisible(true); break;
                case 17: p17.setName(nombor);
                        p17.setVisible(true); break;
                case 18: p18.setName(nombor);
                        p18.setVisible(true); break;
                case 19: p19.setName(nombor);
                        p19.setVisible(true); break;
                case 20: p20.setName(nombor);
                        p20.setVisible(true); break;
                }
                
           
            
            
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

        jPanel1 = new javax.swing.JPanel();
        p1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        p2 = new javax.swing.JLabel();
        p3 = new javax.swing.JLabel();
        p4 = new javax.swing.JLabel();
        p5 = new javax.swing.JLabel();
        p15 = new javax.swing.JLabel();
        p12 = new javax.swing.JLabel();
        p6 = new javax.swing.JLabel();
        p7 = new javax.swing.JLabel();
        p10 = new javax.swing.JLabel();
        p9 = new javax.swing.JLabel();
        p17 = new javax.swing.JLabel();
        p16 = new javax.swing.JLabel();
        p18 = new javax.swing.JLabel();
        p19 = new javax.swing.JLabel();
        p13 = new javax.swing.JLabel();
        p14 = new javax.swing.JLabel();
        p20 = new javax.swing.JLabel();
        p11 = new javax.swing.JLabel();
        p8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        updated = new javax.swing.JLabel();
        setup = new javax.swing.JLabel();
        random = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 255, 51));

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        p1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        p1.setForeground(new java.awt.Color(0, 0, 0));
        p1.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\output-onlinepngtools.png")); // NOI18N
        p1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p1MouseClicked(evt);
            }
        });
        jPanel1.add(p1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 50, 70));

        jLabel1.setFont(new java.awt.Font("Magneto", 2, 80)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("MAP ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 320, 140));

        p2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        p2.setForeground(new java.awt.Color(0, 0, 0));
        p2.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\output-onlinepngtools.png")); // NOI18N
        p2.setText("2");
        p2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p2MouseClicked(evt);
            }
        });
        jPanel1.add(p2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 340, 50, -1));

        p3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        p3.setForeground(new java.awt.Color(0, 0, 0));
        p3.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\output-onlinepngtools.png")); // NOI18N
        p3.setText("3");
        p3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p3MouseClicked(evt);
            }
        });
        jPanel1.add(p3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 50, 60));

        p4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        p4.setForeground(new java.awt.Color(0, 0, 0));
        p4.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\output-onlinepngtools.png")); // NOI18N
        p4.setText("4");
        p4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p4MouseClicked(evt);
            }
        });
        jPanel1.add(p4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 170, 50, -1));

        p5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        p5.setForeground(new java.awt.Color(0, 0, 0));
        p5.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\output-onlinepngtools.png")); // NOI18N
        p5.setText("5");
        p5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p5MouseClicked(evt);
            }
        });
        jPanel1.add(p5, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 310, 50, -1));

        p15.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        p15.setForeground(new java.awt.Color(0, 0, 0));
        p15.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\output-onlinepngtools.png")); // NOI18N
        p15.setText("15");
        p15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p15MouseClicked(evt);
            }
        });
        jPanel1.add(p15, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 440, 50, -1));

        p12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        p12.setForeground(new java.awt.Color(0, 0, 0));
        p12.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\output-onlinepngtools.png")); // NOI18N
        p12.setText("12");
        p12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p12MouseClicked(evt);
            }
        });
        jPanel1.add(p12, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, -10, 50, -1));

        p6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        p6.setForeground(new java.awt.Color(0, 0, 0));
        p6.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\output-onlinepngtools.png")); // NOI18N
        p6.setText("6");
        p6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p6MouseClicked(evt);
            }
        });
        jPanel1.add(p6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 410, 50, -1));

        p7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        p7.setForeground(new java.awt.Color(0, 0, 0));
        p7.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\output-onlinepngtools.png")); // NOI18N
        p7.setText("7");
        p7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p7MouseClicked(evt);
            }
        });
        jPanel1.add(p7, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 480, 50, -1));

        p10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        p10.setForeground(new java.awt.Color(0, 0, 0));
        p10.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\output-onlinepngtools.png")); // NOI18N
        p10.setText("10");
        p10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p10MouseClicked(evt);
            }
        });
        jPanel1.add(p10, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 120, 50, -1));

        p9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        p9.setForeground(new java.awt.Color(0, 0, 0));
        p9.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\output-onlinepngtools.png")); // NOI18N
        p9.setText("9");
        p9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p9MouseClicked(evt);
            }
        });
        jPanel1.add(p9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 50, -1));

        p17.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        p17.setForeground(new java.awt.Color(0, 0, 0));
        p17.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\output-onlinepngtools.png")); // NOI18N
        p17.setText("17");
        p17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p17MouseClicked(evt);
            }
        });
        jPanel1.add(p17, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 450, 50, 70));

        p16.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        p16.setForeground(new java.awt.Color(0, 0, 0));
        p16.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\output-onlinepngtools.png")); // NOI18N
        p16.setText("16");
        p16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p16MouseClicked(evt);
            }
        });
        jPanel1.add(p16, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 350, 50, -1));

        p18.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        p18.setForeground(new java.awt.Color(0, 0, 0));
        p18.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\output-onlinepngtools.png")); // NOI18N
        p18.setText("18");
        p18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p18MouseClicked(evt);
            }
        });
        jPanel1.add(p18, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 170, 50, -1));

        p19.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        p19.setForeground(new java.awt.Color(0, 0, 0));
        p19.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\output-onlinepngtools.png")); // NOI18N
        p19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p19MouseClicked(evt);
            }
        });
        jPanel1.add(p19, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, -10, 50, 70));

        p13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        p13.setForeground(new java.awt.Color(0, 0, 0));
        p13.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\output-onlinepngtools.png")); // NOI18N
        p13.setText("13");
        p13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p13MouseClicked(evt);
            }
        });
        jPanel1.add(p13, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 210, 50, -1));

        p14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        p14.setForeground(new java.awt.Color(0, 0, 0));
        p14.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\output-onlinepngtools.png")); // NOI18N
        p14.setText("14");
        p14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p14MouseClicked(evt);
            }
        });
        jPanel1.add(p14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 270, 50, -1));

        p20.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        p20.setForeground(new java.awt.Color(0, 0, 0));
        p20.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\output-onlinepngtools.png")); // NOI18N
        p20.setText("20");
        p20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p20MouseClicked(evt);
            }
        });
        jPanel1.add(p20, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 530, 50, -1));

        p11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        p11.setForeground(new java.awt.Color(0, 0, 0));
        p11.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\output-onlinepngtools.png")); // NOI18N
        p11.setText("11");
        p11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p11MouseClicked(evt);
            }
        });
        jPanel1.add(p11, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 50, 50, -1));

        p8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        p8.setForeground(new java.awt.Color(0, 0, 0));
        p8.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\output-onlinepngtools.png")); // NOI18N
        p8.setText("8");
        p8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p8MouseClicked(evt);
            }
        });
        jPanel1.add(p8, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 400, 50, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jumpy/grof/photo_2020-06-14_11-23-15.jpg"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 700, 630));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 470, 250));

        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, -1, -1));

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 90, 40));

        updated.setFont(new java.awt.Font("Edwardian Script ITC", 1, 70)); // NOI18N
        updated.setForeground(new java.awt.Color(153, 0, 51));
        updated.setText("updated ");
        jPanel1.add(updated, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 180, 90));

        setup.setFont(new java.awt.Font("Edwardian Script ITC", 1, 80)); // NOI18N
        setup.setForeground(new java.awt.Color(153, 0, 51));
        setup.setText("setup ");
        jPanel1.add(setup, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 190, -1));

        random.setFont(new java.awt.Font("Goudy Stout", 1, 48)); // NOI18N
        random.setForeground(new java.awt.Color(0, 51, 51));
        random.setText("RANDOM");
        jPanel1.add(random, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void p1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p1MouseClicked
        String nombor = p1.getName();
        int index = Integer.parseInt(nombor)-1;
        
        Point p = point.get(index);
            jTextArea1.setText(p.toString());
        
    }//GEN-LAST:event_p1MouseClicked

    private void p2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p2MouseClicked
        String nombor = p2.getName();
        int index = Integer.parseInt(nombor)-1;
        Point p = point.get(index);
            jTextArea1.setText(p.toString());
    }//GEN-LAST:event_p2MouseClicked

    private void p3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p3MouseClicked
        String nombor = p3.getName();
        int index = Integer.parseInt(nombor)-1;
        Point p = point.get(index);
            jTextArea1.setText(p.toString());
    }//GEN-LAST:event_p3MouseClicked

    private void p4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p4MouseClicked
        String nombor = p4.getName();
        int index = Integer.parseInt(nombor)-1;
        Point p = point.get(index);
            jTextArea1.setText(p.toString());
    }//GEN-LAST:event_p4MouseClicked

    private void p5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p5MouseClicked
        String nombor = p5.getName();
        int index = Integer.parseInt(nombor)-1;
        Point p = point.get(index);
            jTextArea1.setText(p.toString());
    }//GEN-LAST:event_p5MouseClicked

    private void p6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p6MouseClicked
        String nombor = p6.getName();
        int index = Integer.parseInt(nombor)-1;
       Point p = point.get(index);
            jTextArea1.setText(p.toString());
    }//GEN-LAST:event_p6MouseClicked

    private void p7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p7MouseClicked
        String nombor = p7.getName();
        int index = Integer.parseInt(nombor)-1;
        Point p = point.get(index);
            jTextArea1.setText(p.toString());
    }//GEN-LAST:event_p7MouseClicked

    private void p8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p8MouseClicked
        String nombor = p8.getName();
        int index = Integer.parseInt(nombor)-1;
        Point p = point.get(index);
            jTextArea1.setText(p.toString());
    }//GEN-LAST:event_p8MouseClicked

    private void p9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p9MouseClicked
        String nombor = p9.getName();
        int index = Integer.parseInt(nombor)-1;
        Point p = point.get(index);
            jTextArea1.setText(p.toString());
    }//GEN-LAST:event_p9MouseClicked

    private void p10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p10MouseClicked
        String nombor = p10.getName();
        int index = Integer.parseInt(nombor)-1;
        Point p = point.get(index);
            jTextArea1.setText(p.toString());
    }//GEN-LAST:event_p10MouseClicked
                                   

    private void p12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p12MouseClicked
        String nombor = p12.getName();
        int index = Integer.parseInt(nombor)-1;
        Point p = point.get(index);
            jTextArea1.setText(p.toString());
    }//GEN-LAST:event_p12MouseClicked

    private void p13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p13MouseClicked
        String nombor = p13.getName();
        int index = Integer.parseInt(nombor)-1;
        Point p = point.get(index);
            jTextArea1.setText(p.toString());
    }//GEN-LAST:event_p13MouseClicked

    private void p14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p14MouseClicked
        String nombor = p14.getName();
        int index = Integer.parseInt(nombor)-1;
        Point p = point.get(index);
            jTextArea1.setText(p.toString());
    }//GEN-LAST:event_p14MouseClicked

    private void p15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p15MouseClicked
        String nombor = p15.getName();
        int index = Integer.parseInt(nombor)-1;
        Point p = point.get(index);
            jTextArea1.setText(p.toString());
    }//GEN-LAST:event_p15MouseClicked

    private void p16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p16MouseClicked
        String nombor = p16.getName();
        int index = Integer.parseInt(nombor)-1;
        Point p = point.get(index);
            jTextArea1.setText(p.toString());
    }//GEN-LAST:event_p16MouseClicked

    private void p17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p17MouseClicked
        String nombor = p17.getName();
        int index = Integer.parseInt(nombor)-1;
        Point p = point.get(index);
            jTextArea1.setText(p.toString());
    }//GEN-LAST:event_p17MouseClicked

    private void p18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p18MouseClicked
        String nombor = p18.getName();
        int index = Integer.parseInt(nombor)-1;
        Point p = point.get(index);
            jTextArea1.setText(p.toString());
    }//GEN-LAST:event_p18MouseClicked

    private void p19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p19MouseClicked
        String nombor = p19.getName();
        int index = Integer.parseInt(nombor)-1;
        Point p = point.get(index);
            jTextArea1.setText(p.toString());
    }//GEN-LAST:event_p19MouseClicked

    private void p20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p20MouseClicked
        String nombor = p20.getName();
        int index = Integer.parseInt(nombor)-1;
        Point p = point.get(index);
            jTextArea1.setText(p.toString());
    }//GEN-LAST:event_p20MouseClicked

    private void p11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p11MouseClicked
        String nombor = p11.getName();
        int index = Integer.parseInt(nombor)-1;
        
            Point p = point.get(index);
            jTextArea1.setText(p.toString());
        
    }//GEN-LAST:event_p11MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        Map map2 = map;
        map2.update();
        MapGUI mapGUI2 = new MapGUI(map2,map2.getPoint(),map2.getColony(),num);
        mapGUI2.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MapGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MapGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MapGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MapGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MapGUI().setVisible(true);
            }
        });
    }
    
    public static boolean checkID(int id, Point[] points)
    {
        for(Point point : points)
            if(point == null) break;
            else if(point.getID() == id) return true;
        return false;
    }
    
    
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel p1;
    private javax.swing.JLabel p10;
    private javax.swing.JLabel p11;
    private javax.swing.JLabel p12;
    private javax.swing.JLabel p13;
    private javax.swing.JLabel p14;
    private javax.swing.JLabel p15;
    private javax.swing.JLabel p16;
    private javax.swing.JLabel p17;
    private javax.swing.JLabel p18;
    private javax.swing.JLabel p19;
    private javax.swing.JLabel p2;
    private javax.swing.JLabel p20;
    private javax.swing.JLabel p3;
    private javax.swing.JLabel p4;
    private javax.swing.JLabel p5;
    private javax.swing.JLabel p6;
    private javax.swing.JLabel p7;
    private javax.swing.JLabel p8;
    private javax.swing.JLabel p9;
    private javax.swing.JLabel random;
    private javax.swing.JLabel setup;
    private javax.swing.JLabel updated;
    // End of variables declaration//GEN-END:variables
}
