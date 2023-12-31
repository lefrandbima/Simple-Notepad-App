
package notepad.view;



import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;


import static notepad.Notepad.EMF;
import notepad.controller.CatatanJpaController;
import notepad.controller.exceptions.NonexistentEntityException;
import notepad.model.Catatan;
import notepad.view.BukaDanEditCatatan;
/**
 *
 * @author USER
 */
public class AntarmukaPengguna extends javax.swing.JFrame {
    
    Catatan ctn;
    
    CatatanJpaController ctnCtrl = new CatatanJpaController(EMF);

    /**
     * Creates new form AntarmukaPengguna
     */
    public AntarmukaPengguna() {
        
        initComponents();
        this.setLocationRelativeTo(null);
        refreshTable();
       
    }
    
    BukaDanEditCatatan bukaAndedit = new BukaDanEditCatatan();
    
    class jPanelGradient extends JPanel {
        @Override
        protected void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D)g;
            int width = getWidth();
            int height = getHeight();
            
            Color color1 = new Color(153,0,153);
            Color color2 = new Color(41,144,182);
            GradientPaint gp = new GradientPaint(0, 0, color1,110, 280, color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, width, height);        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        notepadPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("notepadPU").createEntityManager();
        catatanQuery = java.beans.Beans.isDesignTime() ? null : notepadPUEntityManager.createQuery("SELECT c FROM Catatan c");
        catatanList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : catatanQuery.getResultList();
        catatanQuery1 = java.beans.Beans.isDesignTime() ? null : notepadPUEntityManager.createQuery("SELECT c FROM Catatan c");
        catatanList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : catatanQuery1.getResultList();
        jPanel2 = new jPanelGradient();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCatatan = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnTambahCatatan = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        txtJudul = new javax.swing.JTextField();
        dcTanggal = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtIsi = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 255)));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NOTEPAD");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addGap(274, 274, 274))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, catatanList1, tblCatatan);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${judul}"));
        columnBinding.setColumnName("Judul");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${isi}"));
        columnBinding.setColumnName("Isi");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tanggal}"));
        columnBinding.setColumnName("Tanggal");
        columnBinding.setColumnClass(java.util.Date.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        tblCatatan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCatatanMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblCatatanMousePressed(evt);
            }
        });
        tblCatatan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblCatatanKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblCatatanKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblCatatan);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Daftar Catatan ");

        btnTambahCatatan.setBackground(new java.awt.Color(51, 51, 255));
        btnTambahCatatan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTambahCatatan.setForeground(new java.awt.Color(255, 255, 255));
        btnTambahCatatan.setText("Tambah Catatan Baru");
        btnTambahCatatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahCatatanActionPerformed(evt);
            }
        });

        btnRefresh.setBackground(new java.awt.Color(51, 51, 255));
        btnRefresh.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        txtIsi.setColumns(20);
        txtIsi.setRows(5);
        jScrollPane2.setViewportView(txtIsi);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(dcTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTambahCatatan)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(207, 207, 207)
                                .addComponent(btnRefresh)))
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTambahCatatan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(txtJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahCatatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahCatatanActionPerformed
        // TODO add your handling code here:
        TambahCatatan next = new TambahCatatan();
        next.show();
        dispose();
    }//GEN-LAST:event_btnTambahCatatanActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        
        refreshTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tblCatatanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblCatatanKeyReleased
       
         tblCatatanMouseClicked(null);
    }//GEN-LAST:event_tblCatatanKeyReleased

    private void tblCatatanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCatatanMouseClicked
        
        int row = tblCatatan.getSelectedRow();
        String judul = tblCatatan.getValueAt(row, 0).toString();
        ctn = ctnCtrl.findCatatan(judul);
        if(ctn != null){
            txtJudul.setText(ctn.getJudul());
            txtIsi.setText(ctn.getIsi());
            dcTanggal.setDate(ctn.getTanggal());
            
            //untuk mentransfer nilai tabel ke Frame BukaDanEditCatatan
            bukaAndedit.setVisible(true);
            bukaAndedit.pack();
            bukaAndedit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            bukaAndedit.txtJudule.setText(ctn.getJudul());
            bukaAndedit.txtIsie.setText(ctn.getIsi());
            bukaAndedit.dcTanggale.setDate(ctn.getTanggal());
            
        }
        
    }//GEN-LAST:event_tblCatatanMouseClicked

    private void tblCatatanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCatatanMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblCatatanMousePressed

    private void tblCatatanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblCatatanKeyPressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_tblCatatanKeyPressed
    
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
            java.util.logging.Logger.getLogger(AntarmukaPengguna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AntarmukaPengguna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AntarmukaPengguna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AntarmukaPengguna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AntarmukaPengguna().setVisible(true);
            }
        });
    }
    
    private void refreshTable(){
        catatanList.clear();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Judul");
        model.addColumn("Isi");
        model.addColumn("Tanggal");
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd,MM,yyyy");
        Object[] obj = new Object[3];
        for(Catatan ctn : ctnCtrl.findCatatanEntities()){
        obj[0] = ctn.getJudul();
        obj[1] = ctn.getIsi();
        obj[2] = ctn.getTanggal();
        model.addRow(obj);
        }
        tblCatatan.setModel(model);
    }
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnTambahCatatan;
    private java.util.List<notepad.model.Catatan> catatanList;
    private java.util.List<notepad.model.Catatan> catatanList1;
    private javax.persistence.Query catatanQuery;
    private javax.persistence.Query catatanQuery1;
    private com.toedter.calendar.JDateChooser dcTanggal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.persistence.EntityManager notepadPUEntityManager;
    private javax.swing.JTable tblCatatan;
    private javax.swing.JTextArea txtIsi;
    private javax.swing.JTextField txtJudul;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
