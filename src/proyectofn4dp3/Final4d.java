
package proyectofn4dp3;
import java.awt.Color;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;


public class Final4d extends javax.swing.JFrame {
Connection conexion;
Statement sentencia;
String nombreBD=" ";
    public Final4d() {
        setBD(); 
        initComponents(); 
        PrepararBD();
        System.out.println("+-----------------------------------------------------------------+");
        System.out.println("MariaBD: Todos los plugins activados, operando en: "+nombreBD);
        System.out.println("+-----------------------------------------------------------------+");
        this.getContentPane().setBackground(Color.DARK_GRAY);
    }

   
void setBD(){
    try{
   nombreBD = (String)JOptionPane.showInputDialog(null, "ENCIENDA SERVIDORES APACHE Y MYSQL. NOMBRE DE LA BD:","Inicio",JOptionPane.QUESTION_MESSAGE,null,null,null);        
    nombreBD.trim().toLowerCase();
   if(nombreBD.equals("")||nombreBD.equals(null)){
        JOptionPane.showMessageDialog(null, "Se elegirá mcroy como default");
        nombreBD="mcroy";
    }
    }catch(Exception Ex){
        JOptionPane.showMessageDialog(null, "FALLO DE ACTIVACION");
        System.exit(0);
    }
   
}
void PrepararBD(){
        try{//CARGAR DRIVER
            String driver="com.mysql.jdbc.Driver";
            Class.forName(driver).newInstance();
        }catch (Exception Ex){ 
            JOptionPane.showMessageDialog(null, "ERROR al cargar el driver");
        } 
            String user="root", pwd="";
            
            String url="jdbc:mysql://localhost/"+nombreBD;
        try{//CREAR CONEXION
           conexion=DriverManager.getConnection(url,user,pwd);
           this.setTitle("BASE DE DATOS: "+nombreBD); 
        }catch(Exception Ex){
            JOptionPane.showMessageDialog(null, "ERROR al conectar");
            this.setTitle("ERROR"); 
        }
        try{//CREAR SENTENCIA
            sentencia=conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        }catch(Exception Ex){
            JOptionPane.showMessageDialog(null, "ERROR en la sentencia");
        }
    }
    
    void showAllDepas(){
        String info="";
        String a, b, c;
        try{
            ResultSet r= sentencia.executeQuery("SELECT *FROM departamento ORDER BY DEP;");
            r.beforeFirst();
            while(r.next()){
                a = r.getString("DEP");
                b= r.getString("Nombre");
                c = r.getString("Proveedor");

                info= info+a+" -- "+b+" -- "+c+"\n";
                
            }
            vista.setText(info);
            
        }catch(Exception Ex){
            vista.setText("ERROR AL CONSULTAR TABLA: \n("+Ex+")");
        }
    }
    
    void showAllPasteleros(){
    String info="";
        String a = null,b = null,c = null,d = null,e = null;
        try{
            ResultSet r= sentencia.executeQuery("SELECT *FROM pastelero ORDER BY ID;");
            r.beforeFirst();
            while(r.next()){
                a = r.getString("ID");
                b = r.getString("Nombre");
                c = r.getString("ApePat");
                d = r.getString("ApeMat");
                e= r.getString("Departamento");
                info=info+a+" -- "+b+" -- "+c+" -- "+d+" -- "+e+"\n";
                }
                
            
            vista.setText(info);
            
        }catch(Exception Ex){
            vista.setText("ERROR AL CONSULTAR TABLA: \n("+Ex+")");
}

}
    
    void showAllPasteles(){
        String info="";
        String a, b, c;
        try{
            ResultSet r= sentencia.executeQuery("SELECT *FROM pasteles ORDER BY Numero;");
            r.beforeFirst();
            while(r.next()){
                a = r.getString("Numero");
                b= r.getString("Sabor");
                c = r.getString("Pastelero");

                info= info+a+" -- "+b+" -- "+c+"\n";
                
            }
            vista.setText(info);
            
        }catch(Exception Ex){
            vista.setText("ERROR AL CONSULTAR TABLA: \n("+Ex+")");
        }
    }
    
    void showAllProveedores(){
        String info="";
        String a, b, c, d;
        try{
            ResultSet r= sentencia.executeQuery("SELECT *FROM proveedores ORDER BY CURP;");
            r.beforeFirst();
            while(r.next()){
                a = r.getString("CURP");
                b= r.getString("Nombre");
                c = r.getString("ApePat");
                d = r.getString("ApeMat");

                info= info+a+" -- "+b+" -- "+c+"--"+d+"\n";
                
            }
            vista.setText(info);
            
        }catch(Exception Ex){
            vista.setText("ERROR AL CONSULTAR TABLA: \n("+Ex+")");
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

        AltaDepa = new javax.swing.JFrame();
        ALTA = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtProvee = new javax.swing.JTextField();
        txtDep = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        btnAlt = new javax.swing.JButton();
        btnCLOSEALTA = new javax.swing.JButton();
        DelDepa = new javax.swing.JFrame();
        DELETE = new javax.swing.JPanel();
        txtDelDepa = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnDel = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        UpdDepa = new javax.swing.JFrame();
        UPDATE = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtProvMod = new javax.swing.JTextField();
        txtDepMod = new javax.swing.JTextField();
        txtNameMod = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        btnBUSC = new javax.swing.JButton();
        modbtn = new javax.swing.JButton();
        AltaPastelero = new javax.swing.JFrame();
        ALTA1 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtApePat = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtApeMat = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnAlt1 = new javax.swing.JButton();
        btnCLOSEALTA1 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        txtDepto = new javax.swing.JTextField();
        UpdPastelero = new javax.swing.JFrame();
        UPDATE1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtApePatMod = new javax.swing.JTextField();
        txtIDMod = new javax.swing.JTextField();
        txtApeMatMod = new javax.swing.JTextField();
        txtNameMod1 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        btnBUSC1 = new javax.swing.JButton();
        modbtnC = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        txtDeptoMod = new javax.swing.JTextField();
        DeletePastelero = new javax.swing.JFrame();
        DELETE1 = new javax.swing.JPanel();
        txtDelID = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        btnDel1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        AltaPastel = new javax.swing.JFrame();
        ALTA2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPastelero = new javax.swing.JTextField();
        txtNum = new javax.swing.JTextField();
        txtSabor = new javax.swing.JTextField();
        btnAlt2 = new javax.swing.JButton();
        btnCLOSEALTA2 = new javax.swing.JButton();
        DelPastel = new javax.swing.JFrame();
        DELETE2 = new javax.swing.JPanel();
        txtNumDel = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnDel2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        UpdPatel = new javax.swing.JFrame();
        UPDATE2 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtdeptoMod = new javax.swing.JTextField();
        txtNumeroMod = new javax.swing.JTextField();
        txtSaborMod = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        btnBUSC2 = new javax.swing.JButton();
        modbtn1 = new javax.swing.JButton();
        AltaProveedor = new javax.swing.JFrame();
        ALTA3 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtApePat1 = new javax.swing.JTextField();
        txtCURP = new javax.swing.JTextField();
        txtApeMat1 = new javax.swing.JTextField();
        txtNombre1 = new javax.swing.JTextField();
        btnAlt3 = new javax.swing.JButton();
        btnCLOSEALTA3 = new javax.swing.JButton();
        UpdProvee = new javax.swing.JFrame();
        UPDATE3 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txtApePatMod1 = new javax.swing.JTextField();
        txtIDMod1 = new javax.swing.JTextField();
        txtApeMatMod1 = new javax.swing.JTextField();
        txtNameMod2 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        btnBUSC3 = new javax.swing.JButton();
        modbtnC1 = new javax.swing.JButton();
        DelProvee = new javax.swing.JFrame();
        DELETE3 = new javax.swing.JPanel();
        txtDelID1 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        btnDel3 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        out = new javax.swing.JScrollPane();
        vista = new javax.swing.JTextPane();
        jButton5 = new javax.swing.JButton();
        menu = new javax.swing.JMenuBar();
        depa = new javax.swing.JMenu();
        vertrab = new javax.swing.JMenuItem();
        upd = new javax.swing.JMenuItem();
        del = new javax.swing.JMenuItem();
        ins = new javax.swing.JMenuItem();
        past = new javax.swing.JMenu();
        vercl = new javax.swing.JMenuItem();
        updcl = new javax.swing.JMenuItem();
        delcl = new javax.swing.JMenuItem();
        inscl = new javax.swing.JMenuItem();
        cake = new javax.swing.JMenu();
        vercl1 = new javax.swing.JMenuItem();
        updcl1 = new javax.swing.JMenuItem();
        delcl1 = new javax.swing.JMenuItem();
        inscl1 = new javax.swing.JMenuItem();
        prove = new javax.swing.JMenu();
        vercl2 = new javax.swing.JMenuItem();
        updcl2 = new javax.swing.JMenuItem();
        delcl2 = new javax.swing.JMenuItem();
        inscl2 = new javax.swing.JMenuItem();

        AltaDepa.setAlwaysOnTop(true);

        ALTA.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Alta", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jLabel1.setText("Dep");

        jLabel2.setText("Nombre");

        jLabel3.setText("Proveedor");

        txtProvee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProveeActionPerformed(evt);
            }
        });

        txtDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepActionPerformed(evt);
            }
        });

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        btnAlt.setText("Alta");
        btnAlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltActionPerformed(evt);
            }
        });

        btnCLOSEALTA.setText("Cerrar");
        btnCLOSEALTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCLOSEALTAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ALTALayout = new javax.swing.GroupLayout(ALTA);
        ALTA.setLayout(ALTALayout);
        ALTALayout.setHorizontalGroup(
            ALTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ALTALayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(txtProvee, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
            .addGroup(ALTALayout.createSequentialGroup()
                .addGroup(ALTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ALTALayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ALTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ALTALayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDep, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ALTALayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)))
                    .addGroup(ALTALayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnAlt)
                        .addGap(28, 28, 28)
                        .addComponent(btnCLOSEALTA)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ALTALayout.setVerticalGroup(
            ALTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ALTALayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(ALTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(ALTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(ALTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtProvee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ALTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlt)
                    .addComponent(btnCLOSEALTA))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AltaDepaLayout = new javax.swing.GroupLayout(AltaDepa.getContentPane());
        AltaDepa.getContentPane().setLayout(AltaDepaLayout);
        AltaDepaLayout.setHorizontalGroup(
            AltaDepaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AltaDepaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ALTA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AltaDepaLayout.setVerticalGroup(
            AltaDepaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AltaDepaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ALTA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        DELETE.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Eliminar Departamento"));

        txtDelDepa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDelDepaActionPerformed(evt);
            }
        });

        jLabel10.setText("DEP");

        btnDel.setText("ELIMINAR");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DELETELayout = new javax.swing.GroupLayout(DELETE);
        DELETE.setLayout(DELETELayout);
        DELETELayout.setHorizontalGroup(
            DELETELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DELETELayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDelDepa, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(DELETELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(btnDel))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        DELETELayout.setVerticalGroup(
            DELETELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DELETELayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(DELETELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDelDepa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(btnDel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DelDepaLayout = new javax.swing.GroupLayout(DelDepa.getContentPane());
        DelDepa.getContentPane().setLayout(DelDepaLayout);
        DelDepaLayout.setHorizontalGroup(
            DelDepaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DelDepaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        DelDepaLayout.setVerticalGroup(
            DelDepaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DelDepaLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        UpdDepa.setAlwaysOnTop(true);

        UPDATE.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Modificacion del Departamento"));

        jButton2.setText("Cerrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel11.setText("Nombre");

        jLabel12.setText("Proveedor");

        txtProvMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProvModActionPerformed(evt);
            }
        });

        txtDepMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepModActionPerformed(evt);
            }
        });

        txtNameMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameModActionPerformed(evt);
            }
        });

        jLabel19.setText("DEP");

        btnBUSC.setText("BUSCAR");
        btnBUSC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBUSCActionPerformed(evt);
            }
        });

        modbtn.setText("MODIFICAR");
        modbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UPDATELayout = new javax.swing.GroupLayout(UPDATE);
        UPDATE.setLayout(UPDATELayout);
        UPDATELayout.setHorizontalGroup(
            UPDATELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UPDATELayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UPDATELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UPDATELayout.createSequentialGroup()
                        .addGroup(UPDATELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(UPDATELayout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDepMod, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(UPDATELayout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNameMod, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(modbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(UPDATELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBUSC)
                            .addComponent(jButton2)))
                    .addGroup(UPDATELayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(27, 27, 27)
                        .addComponent(txtProvMod, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        UPDATELayout.setVerticalGroup(
            UPDATELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UPDATELayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UPDATELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtDepMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBUSC))
                .addGap(18, 18, 18)
                .addGroup(UPDATELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtNameMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(UPDATELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtProvMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(UPDATELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modbtn)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout UpdDepaLayout = new javax.swing.GroupLayout(UpdDepa.getContentPane());
        UpdDepa.getContentPane().setLayout(UpdDepaLayout);
        UpdDepaLayout.setHorizontalGroup(
            UpdDepaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdDepaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UPDATE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        UpdDepaLayout.setVerticalGroup(
            UpdDepaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdDepaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UPDATE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        AltaPastelero.setAlwaysOnTop(true);

        ALTA1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Alta", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jLabel20.setText("ID");

        jLabel21.setText("Nombre");

        jLabel22.setText("ApePat");

        jLabel23.setText("ApeMat");

        txtApePat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApePatActionPerformed(evt);
            }
        });

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        txtApeMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApeMatActionPerformed(evt);
            }
        });

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        btnAlt1.setText("Alta");
        btnAlt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlt1ActionPerformed(evt);
            }
        });

        btnCLOSEALTA1.setText("Cerrar");
        btnCLOSEALTA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCLOSEALTA1ActionPerformed(evt);
            }
        });

        jLabel24.setText("Depto");

        txtDepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDeptoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ALTA1Layout = new javax.swing.GroupLayout(ALTA1);
        ALTA1.setLayout(ALTA1Layout);
        ALTA1Layout.setHorizontalGroup(
            ALTA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ALTA1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ALTA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ALTA1Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApeMat, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(btnAlt1))
                    .addGroup(ALTA1Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDepto, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCLOSEALTA1))
                    .addGroup(ALTA1Layout.createSequentialGroup()
                        .addGroup(ALTA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ALTA1Layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ALTA1Layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ALTA1Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtApePat, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(16, 16, 16))
        );
        ALTA1Layout.setVerticalGroup(
            ALTA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ALTA1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(ALTA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(ALTA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(ALTA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtApePat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ALTA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtApeMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlt1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ALTA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtDepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCLOSEALTA1))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AltaPasteleroLayout = new javax.swing.GroupLayout(AltaPastelero.getContentPane());
        AltaPastelero.getContentPane().setLayout(AltaPasteleroLayout);
        AltaPasteleroLayout.setHorizontalGroup(
            AltaPasteleroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AltaPasteleroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ALTA1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        AltaPasteleroLayout.setVerticalGroup(
            AltaPasteleroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AltaPasteleroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ALTA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        UpdPastelero.setAlwaysOnTop(true);

        UPDATE1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Modificacion del Pastelero"));

        jButton4.setText("Cerrar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel26.setText("Nombre");

        jLabel27.setText("ApePat");

        jLabel28.setText("ApeMat");

        txtApePatMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApePatModActionPerformed(evt);
            }
        });

        txtIDMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDModActionPerformed(evt);
            }
        });

        txtApeMatMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApeMatModActionPerformed(evt);
            }
        });

        txtNameMod1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameMod1ActionPerformed(evt);
            }
        });

        jLabel34.setText("ID");

        btnBUSC1.setText("BUSCAR");
        btnBUSC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBUSC1ActionPerformed(evt);
            }
        });

        modbtnC.setText("MODIFICAR");
        modbtnC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modbtnCActionPerformed(evt);
            }
        });

        jLabel35.setText("Departamento");

        txtDeptoMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDeptoModActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UPDATE1Layout = new javax.swing.GroupLayout(UPDATE1);
        UPDATE1.setLayout(UPDATE1Layout);
        UPDATE1Layout.setHorizontalGroup(
            UPDATE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UPDATE1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UPDATE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(UPDATE1Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDeptoMod, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UPDATE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(UPDATE1Layout.createSequentialGroup()
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtApeMatMod, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(UPDATE1Layout.createSequentialGroup()
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtIDMod, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(UPDATE1Layout.createSequentialGroup()
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtNameMod1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(UPDATE1Layout.createSequentialGroup()
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtApePatMod, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(UPDATE1Layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addComponent(modbtnC, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(UPDATE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UPDATE1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addGroup(UPDATE1Layout.createSequentialGroup()
                        .addComponent(btnBUSC1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        UPDATE1Layout.setVerticalGroup(
            UPDATE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UPDATE1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UPDATE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txtIDMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBUSC1))
                .addGap(18, 18, 18)
                .addGroup(UPDATE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtNameMod1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(UPDATE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtApePatMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UPDATE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtApeMatMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(UPDATE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txtDeptoMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(UPDATE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(modbtnC))
                .addContainerGap())
        );

        javax.swing.GroupLayout UpdPasteleroLayout = new javax.swing.GroupLayout(UpdPastelero.getContentPane());
        UpdPastelero.getContentPane().setLayout(UpdPasteleroLayout);
        UpdPasteleroLayout.setHorizontalGroup(
            UpdPasteleroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdPasteleroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UPDATE1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        UpdPasteleroLayout.setVerticalGroup(
            UpdPasteleroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdPasteleroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UPDATE1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        DeletePastelero.setSize(new java.awt.Dimension(600, 250));

        DELETE1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Eliminar Pastelero"));

        txtDelID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDelIDActionPerformed(evt);
            }
        });

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("ID");

        btnDel1.setText("ELIMINAR");
        btnDel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDel1ActionPerformed(evt);
            }
        });

        jButton3.setText("Cerrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DELETE1Layout = new javax.swing.GroupLayout(DELETE1);
        DELETE1.setLayout(DELETE1Layout);
        DELETE1Layout.setHorizontalGroup(
            DELETE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DELETE1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DELETE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DELETE1Layout.createSequentialGroup()
                        .addGroup(DELETE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(134, 134, 134))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DELETE1Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDelID, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))))
        );
        DELETE1Layout.setVerticalGroup(
            DELETE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DELETE1Layout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addGroup(DELETE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDelID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(18, 18, 18)
                .addComponent(btnDel1)
                .addGap(40, 40, 40)
                .addComponent(jButton3)
                .addGap(104, 104, 104))
        );

        javax.swing.GroupLayout DeletePasteleroLayout = new javax.swing.GroupLayout(DeletePastelero.getContentPane());
        DeletePastelero.getContentPane().setLayout(DeletePasteleroLayout);
        DeletePasteleroLayout.setHorizontalGroup(
            DeletePasteleroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeletePasteleroLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(DELETE1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        DeletePasteleroLayout.setVerticalGroup(
            DeletePasteleroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeletePasteleroLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(DELETE1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        AltaPastel.setAlwaysOnTop(true);

        ALTA2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Alta", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jLabel4.setText("Numero");

        jLabel5.setText("Sabor");

        jLabel6.setText("Pastelero");

        txtPastelero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasteleroActionPerformed(evt);
            }
        });

        txtNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumActionPerformed(evt);
            }
        });

        txtSabor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaborActionPerformed(evt);
            }
        });

        btnAlt2.setText("Alta");
        btnAlt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlt2ActionPerformed(evt);
            }
        });

        btnCLOSEALTA2.setText("Cerrar");
        btnCLOSEALTA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCLOSEALTA2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ALTA2Layout = new javax.swing.GroupLayout(ALTA2);
        ALTA2.setLayout(ALTA2Layout);
        ALTA2Layout.setHorizontalGroup(
            ALTA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ALTA2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnAlt2)
                .addGap(28, 28, 28)
                .addComponent(btnCLOSEALTA2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ALTA2Layout.createSequentialGroup()
                .addGroup(ALTA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(ALTA2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ALTA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(ALTA2Layout.createSequentialGroup()
                                .addGroup(ALTA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                                .addGroup(ALTA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ALTA2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSabor, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ALTA2Layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ALTA2Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(txtPastelero, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        ALTA2Layout.setVerticalGroup(
            ALTA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ALTA2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(ALTA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(ALTA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSabor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(ALTA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPastelero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ALTA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlt2)
                    .addComponent(btnCLOSEALTA2))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AltaPastelLayout = new javax.swing.GroupLayout(AltaPastel.getContentPane());
        AltaPastel.getContentPane().setLayout(AltaPastelLayout);
        AltaPastelLayout.setHorizontalGroup(
            AltaPastelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AltaPastelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ALTA2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AltaPastelLayout.setVerticalGroup(
            AltaPastelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AltaPastelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ALTA2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        DELETE2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Eliminar Pastel"));

        txtNumDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumDelActionPerformed(evt);
            }
        });

        jLabel13.setText("Numero");

        btnDel2.setText("ELIMINAR");
        btnDel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDel2ActionPerformed(evt);
            }
        });

        jButton6.setText("Cerrar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DELETE2Layout = new javax.swing.GroupLayout(DELETE2);
        DELETE2.setLayout(DELETE2Layout);
        DELETE2Layout.setHorizontalGroup(
            DELETE2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DELETE2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNumDel, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(DELETE2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6)
                    .addComponent(btnDel2))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        DELETE2Layout.setVerticalGroup(
            DELETE2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DELETE2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(DELETE2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumDel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(btnDel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DelPastelLayout = new javax.swing.GroupLayout(DelPastel.getContentPane());
        DelPastel.getContentPane().setLayout(DelPastelLayout);
        DelPastelLayout.setHorizontalGroup(
            DelPastelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DelPastelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(DELETE2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        DelPastelLayout.setVerticalGroup(
            DelPastelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DelPastelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(DELETE2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        UpdPatel.setAlwaysOnTop(true);

        UPDATE2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Modificacion del Pastel"));

        jButton7.setText("Cerrar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel14.setText("Sabor");

        jLabel15.setText("Pastelero");

        txtdeptoMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdeptoModActionPerformed(evt);
            }
        });

        txtNumeroMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroModActionPerformed(evt);
            }
        });

        txtSaborMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaborModActionPerformed(evt);
            }
        });

        jLabel29.setText("Numero");

        btnBUSC2.setText("BUSCAR");
        btnBUSC2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBUSC2ActionPerformed(evt);
            }
        });

        modbtn1.setText("MODIFICAR");
        modbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modbtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UPDATE2Layout = new javax.swing.GroupLayout(UPDATE2);
        UPDATE2.setLayout(UPDATE2Layout);
        UPDATE2Layout.setHorizontalGroup(
            UPDATE2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UPDATE2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UPDATE2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UPDATE2Layout.createSequentialGroup()
                        .addGroup(UPDATE2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(UPDATE2Layout.createSequentialGroup()
                                .addGroup(UPDATE2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(UPDATE2Layout.createSequentialGroup()
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSaborMod, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(modbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31))
                            .addGroup(UPDATE2Layout.createSequentialGroup()
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNumeroMod, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(UPDATE2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBUSC2)
                            .addComponent(jButton7)))
                    .addGroup(UPDATE2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(27, 27, 27)
                        .addComponent(txtdeptoMod, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        UPDATE2Layout.setVerticalGroup(
            UPDATE2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UPDATE2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UPDATE2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtNumeroMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBUSC2))
                .addGap(18, 18, 18)
                .addGroup(UPDATE2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtSaborMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(UPDATE2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtdeptoMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(UPDATE2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modbtn1)
                    .addComponent(jButton7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout UpdPatelLayout = new javax.swing.GroupLayout(UpdPatel.getContentPane());
        UpdPatel.getContentPane().setLayout(UpdPatelLayout);
        UpdPatelLayout.setHorizontalGroup(
            UpdPatelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdPatelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UPDATE2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        UpdPatelLayout.setVerticalGroup(
            UpdPatelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdPatelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UPDATE2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        AltaProveedor.setAlwaysOnTop(true);

        ALTA3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Alta", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jLabel30.setText("CURP");

        jLabel31.setText("Nombre");

        jLabel32.setText("ApePat");

        jLabel33.setText("ApeMat");

        txtApePat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApePat1ActionPerformed(evt);
            }
        });

        txtCURP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCURPActionPerformed(evt);
            }
        });

        txtApeMat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApeMat1ActionPerformed(evt);
            }
        });

        txtNombre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombre1ActionPerformed(evt);
            }
        });

        btnAlt3.setText("Alta");
        btnAlt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlt3ActionPerformed(evt);
            }
        });

        btnCLOSEALTA3.setText("Cerrar");
        btnCLOSEALTA3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCLOSEALTA3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ALTA3Layout = new javax.swing.GroupLayout(ALTA3);
        ALTA3.setLayout(ALTA3Layout);
        ALTA3Layout.setHorizontalGroup(
            ALTA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ALTA3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ALTA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ALTA3Layout.createSequentialGroup()
                        .addGroup(ALTA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ALTA3Layout.createSequentialGroup()
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtApeMat1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ALTA3Layout.createSequentialGroup()
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCURP, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(133, Short.MAX_VALUE))
                    .addGroup(ALTA3Layout.createSequentialGroup()
                        .addGroup(ALTA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ALTA3Layout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ALTA3Layout.createSequentialGroup()
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtApePat1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ALTA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAlt3)
                            .addComponent(btnCLOSEALTA3))
                        .addGap(15, 15, 15))))
        );
        ALTA3Layout.setVerticalGroup(
            ALTA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ALTA3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(ALTA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtCURP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(ALTA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ALTA3Layout.createSequentialGroup()
                        .addComponent(btnAlt3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCLOSEALTA3))
                    .addGroup(ALTA3Layout.createSequentialGroup()
                        .addGroup(ALTA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ALTA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApePat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32))
                        .addGap(12, 12, 12)
                        .addGroup(ALTA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(txtApeMat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        javax.swing.GroupLayout AltaProveedorLayout = new javax.swing.GroupLayout(AltaProveedor.getContentPane());
        AltaProveedor.getContentPane().setLayout(AltaProveedorLayout);
        AltaProveedorLayout.setHorizontalGroup(
            AltaProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AltaProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ALTA3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        AltaProveedorLayout.setVerticalGroup(
            AltaProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AltaProveedorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ALTA3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        UpdProvee.setAlwaysOnTop(true);

        UPDATE3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Modificacion del Proveedor"));

        jButton8.setText("Cerrar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel37.setText("Nombre");

        jLabel38.setText("ApePat");

        jLabel39.setText("ApeMat");

        txtApePatMod1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApePatMod1ActionPerformed(evt);
            }
        });

        txtIDMod1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDMod1ActionPerformed(evt);
            }
        });

        txtApeMatMod1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApeMatMod1ActionPerformed(evt);
            }
        });

        txtNameMod2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameMod2ActionPerformed(evt);
            }
        });

        jLabel40.setText("CURP");

        btnBUSC3.setText("BUSCAR");
        btnBUSC3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBUSC3ActionPerformed(evt);
            }
        });

        modbtnC1.setText("MODIFICAR");
        modbtnC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modbtnC1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UPDATE3Layout = new javax.swing.GroupLayout(UPDATE3);
        UPDATE3.setLayout(UPDATE3Layout);
        UPDATE3Layout.setHorizontalGroup(
            UPDATE3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UPDATE3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UPDATE3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UPDATE3Layout.createSequentialGroup()
                        .addGroup(UPDATE3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(UPDATE3Layout.createSequentialGroup()
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtApeMatMod1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(UPDATE3Layout.createSequentialGroup()
                                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIDMod1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(UPDATE3Layout.createSequentialGroup()
                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNameMod2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(UPDATE3Layout.createSequentialGroup()
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtApePatMod1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31)
                        .addComponent(btnBUSC3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(UPDATE3Layout.createSequentialGroup()
                        .addComponent(modbtnC1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(jButton8)))
                .addContainerGap())
        );
        UPDATE3Layout.setVerticalGroup(
            UPDATE3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UPDATE3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(UPDATE3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(txtIDMod1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBUSC3))
                .addGap(18, 18, 18)
                .addGroup(UPDATE3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(txtNameMod2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(UPDATE3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(txtApePatMod1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UPDATE3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(txtApeMatMod1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(UPDATE3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(modbtnC1)))
        );

        javax.swing.GroupLayout UpdProveeLayout = new javax.swing.GroupLayout(UpdProvee.getContentPane());
        UpdProvee.getContentPane().setLayout(UpdProveeLayout);
        UpdProveeLayout.setHorizontalGroup(
            UpdProveeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdProveeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UPDATE3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        UpdProveeLayout.setVerticalGroup(
            UpdProveeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdProveeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UPDATE3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        DelProvee.setSize(new java.awt.Dimension(600, 250));

        DELETE3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Eliminar Proveedor"));

        txtDelID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDelID1ActionPerformed(evt);
            }
        });

        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("CURP");

        btnDel3.setText("ELIMINAR");
        btnDel3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDel3ActionPerformed(evt);
            }
        });

        jButton9.setText("Cerrar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DELETE3Layout = new javax.swing.GroupLayout(DELETE3);
        DELETE3.setLayout(DELETE3Layout);
        DELETE3Layout.setHorizontalGroup(
            DELETE3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DELETE3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DELETE3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DELETE3Layout.createSequentialGroup()
                        .addGroup(DELETE3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(134, 134, 134))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DELETE3Layout.createSequentialGroup()
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDelID1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))))
        );
        DELETE3Layout.setVerticalGroup(
            DELETE3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DELETE3Layout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addGroup(DELETE3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDelID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addGap(18, 18, 18)
                .addComponent(btnDel3)
                .addGap(40, 40, 40)
                .addComponent(jButton9)
                .addGap(104, 104, 104))
        );

        javax.swing.GroupLayout DelProveeLayout = new javax.swing.GroupLayout(DelProvee.getContentPane());
        DelProvee.getContentPane().setLayout(DelProveeLayout);
        DelProveeLayout.setHorizontalGroup(
            DelProveeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DelProveeLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(DELETE3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        DelProveeLayout.setVerticalGroup(
            DelProveeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DelProveeLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(DELETE3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        vista.setEditable(false);
        out.setViewportView(vista);

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setForeground(new java.awt.Color(255, 102, 0));
        jButton5.setText("Cambiar BD");
        jButton5.setBorder(new javax.swing.border.MatteBorder(null));
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        menu.setBackground(new java.awt.Color(0, 0, 0));
        menu.setForeground(new java.awt.Color(0, 0, 0));

        depa.setText("Departamento");
        depa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        vertrab.setText("Ver Todos");
        vertrab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vertrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vertrabActionPerformed(evt);
            }
        });
        depa.add(vertrab);

        upd.setText("UPDATE");
        upd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        upd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updActionPerformed(evt);
            }
        });
        depa.add(upd);

        del.setText("DELETE");
        del.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delActionPerformed(evt);
            }
        });
        depa.add(del);

        ins.setText("INSERT");
        ins.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insActionPerformed(evt);
            }
        });
        depa.add(ins);

        menu.add(depa);

        past.setText("Pastelero");
        past.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        vercl.setText("Ver Todos");
        vercl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vercl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verclActionPerformed(evt);
            }
        });
        past.add(vercl);

        updcl.setText("UPDATE");
        updcl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updcl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updclActionPerformed(evt);
            }
        });
        past.add(updcl);

        delcl.setText("DELETE");
        delcl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delcl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delclActionPerformed(evt);
            }
        });
        past.add(delcl);

        inscl.setText("INSERT");
        inscl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inscl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insclActionPerformed(evt);
            }
        });
        past.add(inscl);

        menu.add(past);

        cake.setText("Pasteles");
        cake.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        vercl1.setText("Ver Todos");
        vercl1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vercl1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vercl1ActionPerformed(evt);
            }
        });
        cake.add(vercl1);

        updcl1.setText("UPDATE");
        updcl1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updcl1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updcl1ActionPerformed(evt);
            }
        });
        cake.add(updcl1);

        delcl1.setText("DELETE");
        delcl1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delcl1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delcl1ActionPerformed(evt);
            }
        });
        cake.add(delcl1);

        inscl1.setText("INSERT");
        inscl1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inscl1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inscl1ActionPerformed(evt);
            }
        });
        cake.add(inscl1);

        menu.add(cake);

        prove.setText("Proveedores");
        prove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        vercl2.setText("Ver Todos");
        vercl2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vercl2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vercl2ActionPerformed(evt);
            }
        });
        prove.add(vercl2);

        updcl2.setText("UPDATE");
        updcl2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updcl2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updcl2ActionPerformed(evt);
            }
        });
        prove.add(updcl2);

        delcl2.setText("DELETE");
        delcl2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delcl2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delcl2ActionPerformed(evt);
            }
        });
        prove.add(delcl2);

        inscl2.setText("INSERT");
        inscl2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inscl2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inscl2ActionPerformed(evt);
            }
        });
        prove.add(inscl2);

        menu.add(prove);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(out)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(out, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        try{
            conexion.close();
        }catch(Exception Ex){
            vista.setText("Valio");
        }
    }//GEN-LAST:event_formWindowClosing

    private void txtProveeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProveeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProveeActionPerformed

    private void txtDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnAltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltActionPerformed
        // TODO add your handling code here:
        String consulta="";
        try{
            
            consulta ="INSERT INTO departamento (DEP,Nombre,Proveedor)VALUES('";
            consulta+=txtDep.getText()+"','";
            consulta+=txtName.getText()+"','";
            consulta+=txtProvee.getText()+"');";
            
            sentencia.executeUpdate(consulta);
            showAllDepas();
            txtDep.setText("");txtName.setText("");txtProvee.setText("");
            AltaDepa.dispose();
            
        }catch(Exception Ex){
            vista.setText("ERROR de Alta"+ "\n"+"("+Ex+")");
        }
        
    }//GEN-LAST:event_btnAltActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        // TODO add your handling code here:
        String CadCurp="";
        String consulta="";
        int ans=0;
        try{
            consulta="SELECT * FROM departamento WHERE DEP='"+txtDelDepa.getText()+"';";
            ResultSet r= sentencia.executeQuery(consulta);
            if(!r.first()){
                JOptionPane.showMessageDialog(null, "Departamento INVALIDO");
            }else{
                ans = JOptionPane.showConfirmDialog(null,"ESTA SEGURO DE QUE QUIERE ELIMINAR AL DEPARTAMENTO?","BORRAR",JOptionPane.YES_NO_OPTION);
                if(ans==JOptionPane.YES_OPTION){
                    consulta="DELETE FROM departamento WHERE DEP='"+txtDelDepa.getText()+"';";
                    sentencia.executeUpdate(consulta);
                    showAllDepas();
                }else{
                    JOptionPane.showMessageDialog(null, "OPERACION CANCELADA");
                }
            }
            
            
            txtDelDepa.setText("");
            DelDepa.dispose();
        }catch(Exception Ex){
            JOptionPane.showMessageDialog(null,"ERROR de DELETE"+ "\n"+"("+Ex+")");
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DelDepa.dispose();
        txtDelDepa.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCLOSEALTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLOSEALTAActionPerformed
        // TODO add your handling code here:
        AltaDepa.dispose();
       
        txtDep.setText("");txtName.setText("");txtProvee.setText("");
    }//GEN-LAST:event_btnCLOSEALTAActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        UpdDepa.dispose();
        txtDepMod.setText("");txtNameMod.setText("");txtProvMod.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtProvModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProvModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProvModActionPerformed

    private void txtDepModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepModActionPerformed

    private void txtNameModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameModActionPerformed

    private void btnBUSCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBUSCActionPerformed
        // TODO add your handling code here:
        String CadFecha="";
        String consulta="";
        try{
            consulta="SELECT * FROM departamento WHERE DEP='"+txtDepMod.getText()+"';";
            ResultSet r= sentencia.executeQuery(consulta);
            if(!r.first()){
                JOptionPane.showMessageDialog(null, "DEPARTAMENTO INVALIDO");
                txtDepMod.setText("");
            }else{
                txtNameMod.setText(r.getString("Nombre"));
                txtProvMod.setText(r.getString("Proveedor"));
            }
        }catch(Exception Ex){
            JOptionPane.showMessageDialog(null,"ERROR de UPDATE"+ "\n"+"("+Ex+")");
        }
        
    }//GEN-LAST:event_btnBUSCActionPerformed

    private void modbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modbtnActionPerformed
        // TODO add your handling code here
        String consulta="";
        try{
            
            consulta ="UPDATE departamento SET ";
            consulta+="Nombre='"+txtNameMod.getText()+"',";
            consulta+="Proveedor='"+txtProvMod.getText()+"' ";
            consulta+="WHERE DEP='"+txtDepMod.getText()+"';";
            sentencia.executeUpdate(consulta);
            showAllDepas();
            txtDepMod.setText("");txtNameMod.setText("");txtProvMod.setText("");
            
        }catch(Exception Ex){
            vista.setText("ERROR de Update"+ "\n"+"("+Ex+")");
        }
    }//GEN-LAST:event_modbtnActionPerformed

    private void txtDelDepaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDelDepaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDelDepaActionPerformed

    private void btnCLOSEALTA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLOSEALTA1ActionPerformed
        // TODO add your handling code here:
        AltaPastelero.dispose();
        txtID.setText("");txtNombre.setText("");txtApePat.setText("");txtApeMat.setText("");txtDepto.setText("");
    }//GEN-LAST:event_btnCLOSEALTA1ActionPerformed

    private void btnAlt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlt1ActionPerformed
        // TODO add your handling code here:
        String consulta="";
        try{
            
            consulta ="INSERT INTO pastelero (ID,Nombre,ApePat,ApeMat,Departamento)VALUES('";
            consulta+=txtID.getText()+"','";
            consulta+=txtNombre.getText()+"','";
            consulta+=txtApePat.getText()+"','";
            consulta+=txtApeMat.getText()+"','";
            consulta+=txtDepto.getText()+"');";
            
            sentencia.executeUpdate(consulta);
            showAllPasteleros();
            txtID.setText("");txtNombre.setText("");txtApePat.setText("");txtApeMat.setText("");txtDepto.setText("");
            AltaPastelero.dispose();
            
        }catch(Exception Ex){
            vista.setText("ERROR de Alta"+ "\n"+"("+Ex+")");
        }
    }//GEN-LAST:event_btnAlt1ActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApeMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApeMatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApeMatActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtApePatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApePatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApePatActionPerformed

    private void txtDeptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDeptoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDeptoActionPerformed

    private void txtDelIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDelIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDelIDActionPerformed

    private void btnDel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDel1ActionPerformed
        // TODO add your handling code here:
        String consulta="";
        int ans=0;
        try{
            consulta="SELECT * FROM pastelero WHERE ID='"+txtDelID.getText()+"';";
            ResultSet r= sentencia.executeQuery(consulta);
            if(!r.first()){
                JOptionPane.showMessageDialog(null, "ID INVALIDA");
            }else{
                ans = JOptionPane.showConfirmDialog(null,"ESTA SEGURO DE QUE QUIERE ELIMINAR AL PASTELERO?","BORRAR",JOptionPane.YES_NO_OPTION);
                if(ans==JOptionPane.YES_OPTION){
                    consulta="DELETE FROM pastelero WHERE ID='"+txtDelID.getText()+"';";
                    sentencia.executeUpdate(consulta);
                    showAllPasteleros();
                }else{
                    JOptionPane.showMessageDialog(null, "OPERACION CANCELADA");
                }
            }
            
            
            txtDelID.setText("");
            DeletePastelero.dispose();
        }catch(Exception Ex){
            JOptionPane.showMessageDialog(null,"ERROR de DELETE"+ "\n"+"("+Ex+")");
        }
    }//GEN-LAST:event_btnDel1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DeletePastelero.dispose();
        txtDelID.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        UpdPastelero.dispose();
        txtIDMod.setText("");txtNameMod1.setText("");txtApePatMod.setText("");txtApeMatMod.setText("");txtDeptoMod.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtApePatModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApePatModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApePatModActionPerformed

    private void txtIDModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDModActionPerformed

    private void txtApeMatModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApeMatModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApeMatModActionPerformed

    private void txtNameMod1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameMod1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameMod1ActionPerformed

    private void btnBUSC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBUSC1ActionPerformed
        // TODO add your handling code here:
        String consulta="";
        try{
            consulta="SELECT * FROM pastelero WHERE ID='"+txtIDMod.getText()+"';";
            ResultSet r= sentencia.executeQuery(consulta);
            if(!r.first()){
                JOptionPane.showMessageDialog(null, "ID INVALIDA");
                txtIDMod.setText("");
            }else{
                txtNameMod1.setText(r.getString("Nombre"));
                txtApePatMod.setText(r.getString("ApePat"));
                txtApeMatMod.setText(r.getString("ApeMat"));
                txtDeptoMod.setText(r.getString("Departamento"));
                
            }
        }catch(Exception Ex){
            JOptionPane.showMessageDialog(null,"ERROR de UPDATE"+ "\n"+"("+Ex+")");
        }
    }//GEN-LAST:event_btnBUSC1ActionPerformed

    private void modbtnCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modbtnCActionPerformed
        // TODO add your handling code here:
        String consulta="";
        try{
            
            consulta ="UPDATE pastelero SET ";
            consulta+="Nombre='"+txtNameMod1.getText()+"',";
            consulta+="ApePat='"+txtApePatMod.getText()+"',";
            consulta+="ApeMat='"+txtApeMatMod.getText()+"',";
            consulta+="Departamento='"+txtDeptoMod.getText()+"' ";
           consulta+="WHERE ID='"+txtIDMod.getText()+"';";
            sentencia.executeUpdate(consulta);
            showAllPasteleros();
            txtIDMod.setText("");txtNameMod1.setText("");txtApePatMod.setText("");txtApeMatMod.setText("");txtDeptoMod.setText("");
            
        }catch(Exception Ex){
            vista.setText("ERROR de Update"+ "\n"+"("+Ex+")");
        }
    }//GEN-LAST:event_modbtnCActionPerformed

    private void txtDeptoModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDeptoModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDeptoModActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        vista.setText("");
        try{
            conexion.close();
        }catch(Exception Ex){
            vista.setText("Valio");
        }
        dispose();
        setBD();
        PrepararBD();
        this.setVisible(true);
        System.out.println("MariaBD: Todos los plugins activados, operando en: "+nombreBD);
        System.out.println("+-----------------------------------------------------------------+");     
    }//GEN-LAST:event_jButton5ActionPerformed

    private void vertrabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vertrabActionPerformed
        // TODO add your handling code here:
        showAllDepas();
    }//GEN-LAST:event_vertrabActionPerformed

    private void updActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updActionPerformed
        // TODO add your handling code here:
        showAllDepas();
        UpdDepa.setVisible(true);
        UpdDepa.setSize(400,400);
        UpdDepa.setLocation(300, 300);
        DelDepa.dispose();
        AltaDepa.dispose();     
    }//GEN-LAST:event_updActionPerformed

    private void delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delActionPerformed
        // TODO add your handling code here:
        showAllDepas();
        DelDepa.setVisible(true);
        DelDepa.setSize(600,250);
        DelDepa.setLocation(300, 300);
        UpdDepa.dispose();
        AltaDepa.dispose();     
    }//GEN-LAST:event_delActionPerformed

    private void insActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insActionPerformed
        // TODO add your handling code here:
         AltaDepa.setVisible(true);
        AltaDepa.setSize(350,300);
        AltaDepa.setLocation(300, 300);
        DelDepa.dispose();
        UpdDepa.dispose();  
    }//GEN-LAST:event_insActionPerformed

    private void updclActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updclActionPerformed
        // TODO add your handling code here:
         showAllPasteleros();
        UpdPastelero.setVisible(true);
        UpdPastelero.setSize(400,400);
        UpdPastelero.setLocation(300, 300);
        DeletePastelero.dispose();
        AltaPastelero.dispose();      
    }//GEN-LAST:event_updclActionPerformed

    private void insclActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insclActionPerformed
        // TODO add your handling code here:
        AltaPastelero.setVisible(true);
        AltaPastelero.setSize(500,300);
        AltaPastelero.setLocation(300, 300);
        UpdPastelero.dispose();
        DeletePastelero.dispose();
    }//GEN-LAST:event_insclActionPerformed

    private void verclActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verclActionPerformed
        // TODO add your handling code here:
        showAllPasteleros();
    }//GEN-LAST:event_verclActionPerformed

    private void delclActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delclActionPerformed
        // TODO add your handling code here:
        showAllPasteleros();
        DeletePastelero.setVisible(true);
        DeletePastelero.setSize(400,400);
        DeletePastelero.setLocation(300, 300);
        UpdPastelero.dispose();
        AltaPastelero.dispose();   
    }//GEN-LAST:event_delclActionPerformed

    private void vercl1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vercl1ActionPerformed
        // TODO add your handling code here:
        showAllPasteles();
    }//GEN-LAST:event_vercl1ActionPerformed

    private void updcl1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updcl1ActionPerformed
        // TODO add your handling code here:
        showAllPasteles();
        UpdPatel.setVisible(true);
        UpdPatel.setSize(400,300);
        UpdPatel.setLocation(300, 300);
        DelPastel.dispose();
        AltaPastel.dispose();  
    }//GEN-LAST:event_updcl1ActionPerformed

    private void delcl1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delcl1ActionPerformed
        // TODO add your handling code here:
         showAllPasteles();
        DelPastel.setVisible(true);
        DelPastel.setSize(500,200);
        DelPastel.setLocation(300, 300);
        UpdPatel.dispose();
        AltaPastel.dispose();  
    }//GEN-LAST:event_delcl1ActionPerformed

    private void inscl1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inscl1ActionPerformed
        // TODO add your handling code here:
        AltaPastel.setVisible(true);
        AltaPastel.setSize(380,300);
        AltaPastel.setLocation(300, 300);
        DelPastel.dispose();
        UpdPatel.dispose();  
    }//GEN-LAST:event_inscl1ActionPerformed

    private void vercl2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vercl2ActionPerformed
        // TODO add your handling code here:
        showAllProveedores();
    }//GEN-LAST:event_vercl2ActionPerformed

    private void updcl2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updcl2ActionPerformed
        // TODO add your handling code here:
         showAllProveedores();
        UpdProvee.setVisible(true);
        UpdProvee.setSize(400,300);
        UpdProvee.setLocation(300, 300);
        DelProvee.dispose();
        AltaProveedor.dispose();
    }//GEN-LAST:event_updcl2ActionPerformed

    private void delcl2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delcl2ActionPerformed
        // TODO add your handling code here:
        showAllProveedores();
        DelProvee.setVisible(true);
        DelProvee.setSize(400,400);
        DelProvee.setLocation(300, 300);
        UpdProvee.dispose();
        AltaProveedor.dispose(); 
    }//GEN-LAST:event_delcl2ActionPerformed

    private void inscl2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inscl2ActionPerformed
        // TODO add your handling code here:
        AltaProveedor.setVisible(true);
        AltaProveedor.setSize(400,250);
        AltaProveedor.setLocation(300, 300);
        UpdProvee.dispose();
        DelProvee.dispose();
    }//GEN-LAST:event_inscl2ActionPerformed

    private void txtPasteleroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasteleroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasteleroActionPerformed

    private void txtNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumActionPerformed

    private void txtSaborActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaborActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaborActionPerformed

    private void btnAlt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlt2ActionPerformed
        // TODO add your handling code here:
        String consulta="";
        try{
            
            consulta ="INSERT INTO pasteles (Numero,Sabor,Pastelero)VALUES('";
            consulta+=txtNum.getText()+"','";
            consulta+=txtSabor.getText()+"','";
            consulta+=txtPastelero.getText()+"');";
            
            sentencia.executeUpdate(consulta);
            showAllPasteles();
            txtNum.setText("");txtSabor.setText("");txtPastelero.setText("");
            AltaPastel.dispose();
            
        }catch(Exception Ex){
            vista.setText("ERROR de Alta"+ "\n"+"("+Ex+")");
        }
    }//GEN-LAST:event_btnAlt2ActionPerformed

    private void btnCLOSEALTA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLOSEALTA2ActionPerformed
        // TODO add your handling code here:
         AltaPastel.dispose();
       
        txtNum.setText("");txtSabor.setText("");txtPastelero.setText("");
    }//GEN-LAST:event_btnCLOSEALTA2ActionPerformed

    private void txtNumDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumDelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumDelActionPerformed

    private void btnDel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDel2ActionPerformed
        // TODO add your handling code here:
        String consulta="";
        int ans=0;
        try{
            consulta="SELECT * FROM pasteles WHERE Numero='"+txtNumDel.getText()+"';";
            ResultSet r= sentencia.executeQuery(consulta);
            if(!r.first()){
                JOptionPane.showMessageDialog(null, "Pastel INVALIDO");
            }else{
                ans = JOptionPane.showConfirmDialog(null,"ESTA SEGURO DE QUE QUIERE ELIMINAR AL Pastel?","BORRAR",JOptionPane.YES_NO_OPTION);
                if(ans==JOptionPane.YES_OPTION){
                    consulta="DELETE FROM pasteles WHERE Numero='"+txtNumDel.getText()+"';";
                    sentencia.executeUpdate(consulta);
                    showAllPasteles();
                }else{
                    JOptionPane.showMessageDialog(null, "OPERACION CANCELADA");
                }
            }
            
            
            txtNumDel.setText("");
            DelPastel.dispose();
        }catch(Exception Ex){
            JOptionPane.showMessageDialog(null,"ERROR de DELETE"+ "\n"+"("+Ex+")");
        }
    }//GEN-LAST:event_btnDel2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        DelPastel.dispose();
        txtNumDel.setText("");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
         UpdPatel.dispose();
        txtNumeroMod.setText("");txtSaborMod.setText("");txtdeptoMod.setText("");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void txtdeptoModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdeptoModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdeptoModActionPerformed

    private void txtNumeroModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroModActionPerformed

    private void txtSaborModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaborModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaborModActionPerformed

    private void btnBUSC2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBUSC2ActionPerformed
        // TODO add your handling code here:
        String consulta="";
        try{
            consulta="SELECT * FROM pasteles WHERE Numero='"+txtNumeroMod.getText()+"';";
            ResultSet r= sentencia.executeQuery(consulta);
            if(!r.first()){
                JOptionPane.showMessageDialog(null, "PASTEL INVALIDO");
                txtNumeroMod.setText("");
            }else{
                txtSaborMod.setText(r.getString("Sabor"));
                txtdeptoMod.setText(r.getString("Pastelero"));
            }
        }catch(Exception Ex){
            JOptionPane.showMessageDialog(null,"ERROR de UPDATE"+ "\n"+"("+Ex+")");
        }
    }//GEN-LAST:event_btnBUSC2ActionPerformed

    private void modbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modbtn1ActionPerformed
        // TODO add your handling code here:
        String consulta="";
        try{
            
            consulta ="UPDATE pasteles SET ";
            consulta+="Sabor='"+txtSaborMod.getText()+"',";
            consulta+="Pastelero='"+txtdeptoMod.getText()+"' ";
            consulta+="WHERE Numero='"+txtNumeroMod.getText()+"';";
            sentencia.executeUpdate(consulta);
            showAllPasteles();
            txtSaborMod.setText("");txtdeptoMod.setText("");txtNumeroMod.setText("");
            
        }catch(Exception Ex){
            vista.setText("ERROR de Update"+ "\n"+"("+Ex+")");
        }
    }//GEN-LAST:event_modbtn1ActionPerformed

    private void txtApePat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApePat1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApePat1ActionPerformed

    private void txtCURPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCURPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCURPActionPerformed

    private void txtApeMat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApeMat1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApeMat1ActionPerformed

    private void txtNombre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre1ActionPerformed

    private void btnAlt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlt3ActionPerformed
        // TODO add your handling code here:
        String consulta="";
        try{
            
            consulta ="INSERT INTO proveedores (CURP,Nombre,ApePat,ApeMat)VALUES('";
            consulta+=txtCURP.getText()+"','";
            consulta+=txtNombre1.getText()+"','";
            consulta+=txtApePat1.getText()+"','";
            consulta+=txtApeMat1.getText()+"');";

            sentencia.executeUpdate(consulta);
            showAllProveedores();
            txtCURP.setText("");txtNombre1.setText("");txtApePat1.setText("");txtApeMat1.setText("");
            AltaProveedor.dispose();
            
        }catch(Exception Ex){
            vista.setText("ERROR de Alta"+ "\n"+"("+Ex+")");
        }
    }//GEN-LAST:event_btnAlt3ActionPerformed

    private void btnCLOSEALTA3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLOSEALTA3ActionPerformed
        // TODO add your handling code here:
        AltaProveedor.dispose();
        txtCURP.setText("");txtNombre1.setText("");txtApePat1.setText("");txtApeMat1.setText("");
    }//GEN-LAST:event_btnCLOSEALTA3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        UpdProvee.dispose();
        txtIDMod1.setText("");txtNameMod2.setText("");txtApePatMod1.setText("");txtApeMatMod1.setText("");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void txtApePatMod1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApePatMod1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApePatMod1ActionPerformed

    private void txtIDMod1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDMod1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDMod1ActionPerformed

    private void txtApeMatMod1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApeMatMod1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApeMatMod1ActionPerformed

    private void txtNameMod2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameMod2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameMod2ActionPerformed

    private void btnBUSC3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBUSC3ActionPerformed
        // TODO add your handling code here:
        String consulta="";
        try{
            consulta="SELECT * FROM proveedores WHERE CURP='"+txtIDMod1.getText()+"';";
            ResultSet r= sentencia.executeQuery(consulta);
            if(!r.first()){
                JOptionPane.showMessageDialog(null, "CURP INVALIDA");
                txtIDMod1.setText("");
            }else{
                txtNameMod2.setText(r.getString("Nombre"));
                txtApePatMod1.setText(r.getString("ApePat"));
                txtApeMatMod1.setText(r.getString("ApeMat"));
                
            }
        }catch(Exception Ex){
            JOptionPane.showMessageDialog(null,"ERROR de UPDATE"+ "\n"+"("+Ex+")");
        }
    }//GEN-LAST:event_btnBUSC3ActionPerformed

    private void modbtnC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modbtnC1ActionPerformed
        // TODO add your handling code here:
        String consulta="";
        try{
            
            consulta ="UPDATE proveedores SET ";
            consulta+="Nombre='"+txtNameMod2.getText()+"',";
            consulta+="ApePat='"+txtApePatMod1.getText()+"',";
            consulta+="ApeMat='"+txtApeMatMod1.getText()+"' ";
           consulta+="WHERE CURP='"+txtIDMod1.getText()+"';";
            sentencia.executeUpdate(consulta);
            showAllProveedores();
            txtIDMod1.setText("");txtNameMod2.setText("");txtApePatMod1.setText("");txtApeMatMod1.setText("");
            
        }catch(Exception Ex){
            vista.setText("ERROR de Update"+ "\n"+"("+Ex+")");
        }
    }//GEN-LAST:event_modbtnC1ActionPerformed

    private void txtDelID1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDelID1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDelID1ActionPerformed

    private void btnDel3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDel3ActionPerformed
        // TODO add your handling code here:
        String consulta="";
        int ans=0;
        try{
            consulta="SELECT * FROM proveedores WHERE CURP='"+txtDelID1.getText()+"';";
            ResultSet r= sentencia.executeQuery(consulta);
            if(!r.first()){
                JOptionPane.showMessageDialog(null, "CURP INVALIDA");
            }else{
                ans = JOptionPane.showConfirmDialog(null,"ESTA SEGURO DE QUE QUIERE ELIMINAR AL PROVEEDOR?","BORRAR",JOptionPane.YES_NO_OPTION);
                if(ans==JOptionPane.YES_OPTION){
                    consulta="DELETE FROM proveedores WHERE CURP='"+txtDelID1.getText()+"';";
                    sentencia.executeUpdate(consulta);
                    showAllPasteleros();
                }else{
                    JOptionPane.showMessageDialog(null, "OPERACION CANCELADA");
                }
            }
            
            
            txtDelID1.setText("");
            DelProvee.dispose();
        }catch(Exception Ex){
            JOptionPane.showMessageDialog(null,"ERROR de DELETE"+ "\n"+"("+Ex+")");
        }
    }//GEN-LAST:event_btnDel3ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        DelProvee.dispose();
        txtDelID1.setText("");
    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(Final4d.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Final4d.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Final4d.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Final4d.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Final4d().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ALTA;
    private javax.swing.JPanel ALTA1;
    private javax.swing.JPanel ALTA2;
    private javax.swing.JPanel ALTA3;
    private javax.swing.JFrame AltaDepa;
    private javax.swing.JFrame AltaPastel;
    private javax.swing.JFrame AltaPastelero;
    private javax.swing.JFrame AltaProveedor;
    private javax.swing.JPanel DELETE;
    private javax.swing.JPanel DELETE1;
    private javax.swing.JPanel DELETE2;
    private javax.swing.JPanel DELETE3;
    private javax.swing.JFrame DelDepa;
    private javax.swing.JFrame DelPastel;
    private javax.swing.JFrame DelProvee;
    private javax.swing.JFrame DeletePastelero;
    private javax.swing.JPanel UPDATE;
    private javax.swing.JPanel UPDATE1;
    private javax.swing.JPanel UPDATE2;
    private javax.swing.JPanel UPDATE3;
    private javax.swing.JFrame UpdDepa;
    private javax.swing.JFrame UpdPastelero;
    private javax.swing.JFrame UpdPatel;
    private javax.swing.JFrame UpdProvee;
    private javax.swing.JButton btnAlt;
    private javax.swing.JButton btnAlt1;
    private javax.swing.JButton btnAlt2;
    private javax.swing.JButton btnAlt3;
    private javax.swing.JButton btnBUSC;
    private javax.swing.JButton btnBUSC1;
    private javax.swing.JButton btnBUSC2;
    private javax.swing.JButton btnBUSC3;
    private javax.swing.JButton btnCLOSEALTA;
    private javax.swing.JButton btnCLOSEALTA1;
    private javax.swing.JButton btnCLOSEALTA2;
    private javax.swing.JButton btnCLOSEALTA3;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnDel1;
    private javax.swing.JButton btnDel2;
    private javax.swing.JButton btnDel3;
    private javax.swing.JMenu cake;
    private javax.swing.JMenuItem del;
    private javax.swing.JMenuItem delcl;
    private javax.swing.JMenuItem delcl1;
    private javax.swing.JMenuItem delcl2;
    private javax.swing.JMenu depa;
    private javax.swing.JMenuItem ins;
    private javax.swing.JMenuItem inscl;
    private javax.swing.JMenuItem inscl1;
    private javax.swing.JMenuItem inscl2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar menu;
    private javax.swing.JButton modbtn;
    private javax.swing.JButton modbtn1;
    private javax.swing.JButton modbtnC;
    private javax.swing.JButton modbtnC1;
    private javax.swing.JScrollPane out;
    private javax.swing.JMenu past;
    private javax.swing.JMenu prove;
    private javax.swing.JTextField txtApeMat;
    private javax.swing.JTextField txtApeMat1;
    private javax.swing.JTextField txtApeMatMod;
    private javax.swing.JTextField txtApeMatMod1;
    private javax.swing.JTextField txtApePat;
    private javax.swing.JTextField txtApePat1;
    private javax.swing.JTextField txtApePatMod;
    private javax.swing.JTextField txtApePatMod1;
    private javax.swing.JTextField txtCURP;
    private javax.swing.JTextField txtDelDepa;
    private javax.swing.JTextField txtDelID;
    private javax.swing.JTextField txtDelID1;
    private javax.swing.JTextField txtDep;
    private javax.swing.JTextField txtDepMod;
    private javax.swing.JTextField txtDepto;
    private javax.swing.JTextField txtDeptoMod;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDMod;
    private javax.swing.JTextField txtIDMod1;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNameMod;
    private javax.swing.JTextField txtNameMod1;
    private javax.swing.JTextField txtNameMod2;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtNum;
    private javax.swing.JTextField txtNumDel;
    private javax.swing.JTextField txtNumeroMod;
    private javax.swing.JTextField txtPastelero;
    private javax.swing.JTextField txtProvMod;
    private javax.swing.JTextField txtProvee;
    private javax.swing.JTextField txtSabor;
    private javax.swing.JTextField txtSaborMod;
    private javax.swing.JTextField txtdeptoMod;
    private javax.swing.JMenuItem upd;
    private javax.swing.JMenuItem updcl;
    private javax.swing.JMenuItem updcl1;
    private javax.swing.JMenuItem updcl2;
    private javax.swing.JMenuItem vercl;
    private javax.swing.JMenuItem vercl1;
    private javax.swing.JMenuItem vercl2;
    private javax.swing.JMenuItem vertrab;
    private javax.swing.JTextPane vista;
    // End of variables declaration//GEN-END:variables
}