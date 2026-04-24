
package laboratorio2_mishell;

public class menu1 extends javax.swing.JFrame {
    
    Usuario usuarioActual;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(menu1.class.getName());

    public menu1(Usuario u) {
        initComponents();

        usuarioActual = u;

        cmbOpciones.removeAllItems();
        cmbOpciones.addItem("Mantenimiento Usuarios");

        if(usuarioActual.rol.equals("ADMIN")){
            cmbOpciones.addItem("Reinicio Clave");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmbOpciones = new javax.swing.JComboBox<>();
        btnAbrir = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("MAIN MENU");

        cmbOpciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAbrir.setText("OPEN");
        btnAbrir.addActionListener(this::btnAbrirActionPerformed);

        btnCerrarSesion.setText("LOG OUT");
        btnCerrarSesion.addActionListener(this::btnCerrarSesionActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(227, 227, 227))
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(btnAbrir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion)
                .addGap(110, 110, 110))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(62, 62, 62)
                .addComponent(cmbOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbrir)
                    .addComponent(btnCerrarSesion))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        
        String opcion = cmbOpciones.getSelectedItem().toString();

        if(opcion.equals("Mantenimiento Usuarios")){
            new MantenimientoUsuarios().setVisible(true);
        }

        if(opcion.equals("Reinicio Clave")){
            new ReinicioClave().setVisible(true);
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        new login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(() -> 
        new menu1(new Usuario("admin","Admin123!","ADMIN",1)).setVisible(true)
        );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JComboBox<String> cmbOpciones;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
