/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlowPrinting;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import java.nio.file.Paths;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.JFileChooser;

/**
 *
 * @author mark
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    private JFileChooser fc;   
    private File  selectedFile ; 
    private File m_file  ;
    private boolean file_flag = false ; 
    private  List<String> lines ;
    private SlowPrinter slow_timer ;
    private final int _delay = 260 ; 
    private int  _counter = 0 ;
    private  Iterator _iterator;
    private int _linesread  = 0 ;        
    private Map<String, String> _mapofparagraphs ;
    private StringBuilder bf ;
    private  String line , instruction;
    private String keys[], temp[] ; 
    private int keyarrayIndex = 0 ;
    private final int charcounter  =0 ;
    private Thread thread  ;
    
    
    public MainForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainframepanel = new javax.swing.JPanel();
        textpanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PText = new javax.swing.JTextArea();
        btnpanel = new javax.swing.JPanel();
        TmrButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        MainMenu = new javax.swing.JMenuBar();
        mainMnuFile = new javax.swing.JMenu();
        subMnuOpen = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        subMnuCodeC = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        mainframepanel.setLayout(new java.awt.BorderLayout(5, 5));

        PText.setColumns(20);
        PText.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        PText.setForeground(new java.awt.Color(0, 51, 255));
        PText.setRows(5);
        jScrollPane1.setViewportView(PText);

        btnpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TmrButton.setText("Start ");
        TmrButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TmrButtonActionPerformed(evt);
            }
        });
        btnpanel.add(TmrButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, -1));

        jLabel1.setText(" Presentation Text");

        javax.swing.GroupLayout textpanelLayout = new javax.swing.GroupLayout(textpanel);
        textpanel.setLayout(textpanelLayout);
        textpanelLayout.setHorizontalGroup(
            textpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textpanelLayout.createSequentialGroup()
                .addGroup(textpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, textpanelLayout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(btnpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(textpanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        textpanelLayout.setVerticalGroup(
            textpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainframepanel.add(textpanel, java.awt.BorderLayout.CENTER);

        mainMnuFile.setText("File");

        subMnuOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Folder-Open-icon.png"))); // NOI18N
        subMnuOpen.setText("Open File");
        subMnuOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMnuOpenActionPerformed(evt);
            }
        });
        mainMnuFile.add(subMnuOpen);
        mainMnuFile.add(jSeparator1);

        subMnuCodeC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Folder-Open-icon.png"))); // NOI18N
        subMnuCodeC.setText("Open Image ");
        mainMnuFile.add(subMnuCodeC);

        MainMenu.add(mainMnuFile);

        setJMenuBar(MainMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainframepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(mainframepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void subMnuOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMnuOpenActionPerformed
        // TODO add your handling code here:
    int a_counter = 0 ;    
    String _line ;    
           file_flag = false ; // set this to false as we are about to open a  file
           // if succesfull then FileDemo will  set this to true 
           int returnVal;
           
           
           fc = new JFileChooser(); // create an instance of file chooser
           
           returnVal = fc.showOpenDialog(this);
 
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                
               try {
                   //This is where a real application would open the file.
                   setFile(fc.getSelectedFile().getCanonicalFile(), true );
                   file_flag= true ;
                                   
                   
               } catch (IOException ex) {
                   Debug("Couldnt open file") ;
                   file_flag=false ;
               }
            
            }
                  
            if(file_flag==true ) // we loaded the file succesfully 
            {
                
                lines = Collections.emptyList();
                try {
                    lines = Files.readAllLines(Paths.get(m_file.toString()), StandardCharsets.UTF_8);
                       _counter = 0 ;
                       _linesread = 0 ;
                       
                    } 
                
                    catch (IOException e) {
                        // TODO Auto-generated catch block
                    file_flag=false ;
                    Debug("Couldn't open file ") ;
                    }
                
                    _iterator  = lines.iterator() ;
                   
                    bf =  new StringBuilder() ;      
                 
                   
                    while(_iterator.hasNext())
                    {
                          _line = _iterator.next().toString() ;
                            _counter ++ ;
                           
                            
                            if(_line.length()>0)    
                            {  
                                bf.append(_line) ;
                                
                            }
                            else 
                            { 
                               if(_counter >1 ){
                                bf.append("\n") ;
                                _linesread+=1 ;
                                }
                                
                            }
                            
                     
                    }
                    
                     
         
                     _mapofparagraphs = new HashMap<>();
                  
                    
                    
                    temp = bf.toString().split("\n");
                    // iterate through the array so we can determine how many  paragraoghs there are 
                         for (String temp1 : temp) 
                         {
                                if (temp1.length() > 0) {
                                    
                                    instruction = " Show " + a_counter ;
                                    a_counter ++ ;
                                    
                                    _mapofparagraphs.put(instruction, temp1) ;
                                }
                          }
                                     
                   
                        /* check to see if we got all paragraphs  

                              _mapofparagraphs.forEach((key, value) -> {
                                 Debug("Key : " + key + " Value : " + value);
                                });
                         */
                         
                         
                        // allocate keys  to String array


                        keys = new String[_mapofparagraphs.size()] ;

                         for(int index = 0 ;index < _mapofparagraphs.size(); index ++)
                         {
                              keys[index]= " Show " + index ;             
                         }
            }

           
    }//GEN-LAST:event_subMnuOpenActionPerformed

    private void TmrButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TmrButtonActionPerformed
        // TODO add your handling code here:

        if(file_flag==true)
        {
                
            setbuttonText("Next");

            // clear the text area
            this.PText.setText("") ;
            // instantiate the slow_timer
            //TimerListener(Map<String, String> aMap , String key ,MainForm m . int keyindex )

            slow_timer  = new SlowPrinter( _mapofparagraphs, keys,  this, keyarrayIndex );
            slow_timer.begin();
            thread = new Thread(slow_timer) ;
            thread.start();

            if( keyarrayIndex< keys.length)
            {
                keyarrayIndex++ ;
            }

        }
    }//GEN-LAST:event_TmrButtonActionPerformed

    
    public void setbuttonText(String Text)
    {
        this.TmrButton.setText(Text);
    }
        
    
    public void  stopTimer()
    {
        Debug("Stopping timer") ;
        this.slow_timer.stop();
    }

    public void setPtext(String c)
    { 
      
      this.PText.append (c) ;
      
      
     
    }
    
    
     public void setFile(File myfile,  boolean f){
      this.m_file = myfile   ;
      this.file_flag = f;
      
              
     }    
    
     
      private void  Debug(String msg )
      {
           System.out.println(msg);
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            MainForm m_mainform  = new  MainForm() ;
            m_mainform.setLocationRelativeTo(null); // cenetres the   form
            m_mainform.setVisible(true) ;
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MainMenu;
    private javax.swing.JTextArea PText;
    private javax.swing.JButton TmrButton;
    private javax.swing.JPanel btnpanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu mainMnuFile;
    private javax.swing.JPanel mainframepanel;
    private javax.swing.JMenuItem subMnuCodeC;
    private javax.swing.JMenuItem subMnuOpen;
    private javax.swing.JPanel textpanel;
    // End of variables declaration//GEN-END:variables

  


}