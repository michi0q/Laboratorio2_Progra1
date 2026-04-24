

package laboratorio2_mishell;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class login extends javax.swing.JFrame {
    
    public static ArrayList<Usuario> listaUsuariosGlobal = new ArrayList<>();
    int intentos = 0;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(login.class.getName());

    /**
     * Creates new form Menu
     */
    public login() {
        initComponents();
        cargarUsuarios();
    }
    public void cargarUsuarios() {
    try {
        BufferedReader br = new BufferedReader(new FileReader("usuarios.csv"));
        String linea;

        br.readLine();

        while((linea = br.readLine()) != null){
            String datos[] = linea.split(",");

            listaUsuariosGlobal.add(new Usuario(
                datos[0],
                datos[1],
                datos[2],
                Integer.parseInt(datos[3])
            ));
        }

        br.close();

    } catch(Exception e){
        System.out.println(e);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLogin = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        label_user = new javax.swing.JLabel();
        label_pass = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnLogin.setText("Log In");
        btnLogin.setToolTipText("");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        label_user.setText("User");

        label_pass.setText("Password");

        jLabel1.setText("Sing in");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_pass)
                        .addGap(0, 107, Short.MAX_VALUE))
                    .addComponent(label_user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(223, 223, 223))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogin)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
            .addGroup(layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_user))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_pass))
                .addGap(38, 38, 38)
                .addComponent(btnLogin)
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
                                           

    String user = txtUsuario.getText();
    String pass = txtPassword.getText();

    for (Usuario u : listaUsuariosGlobal) {

    if (u.usuario.equals(user) && u.password.equals(pass)) {

        if(u.estado == 0){
            JOptionPane.showMessageDialog(this, "Usuario inactivo");
            return;
        }

        if(u.estado == 2){
            JOptionPane.showMessageDialog(this, "Usuario bloqueado");
            return;
        }

        menu1 menu = new menu1(u);
        menu.setVisible(true);
        this.dispose();
        return;
    }
}

intentos++;

JOptionPane.showMessageDialog(this, "Credenciales incorrectas");

if (intentos == 3) {

    for(Usuario u : listaUsuariosGlobal){

        if(u.usuario.equals(user) && !u.usuario.equals("admin")){
            u.estado = 2;
        }
    }

    JOptionPane.showMessageDialog(this, "Usuario bloqueado por 3 intentos");
}

    intentos++;

    JOptionPane.showMessageDialog(this, "Credenciales incorrectas");

    if (intentos == 3) {
        btnLogin.setEnabled(false);
        JOptionPane.showMessageDialog(this, "Usuario bloqueado por 3 intentos");
    }
    }//GEN-LAST:event_btnLoginActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new login().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel label_pass;
    private javax.swing.JLabel label_user;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
