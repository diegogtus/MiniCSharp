/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minicsharp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author diego
 */
public class Principal_frm extends javax.swing.JFrame {

    /**
     * Creates new form Principal_frm
     */
    public Principal_frm() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        txta_Input = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txta_Output = new javax.swing.JTextArea();
        btn_analizar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_path = new javax.swing.JTextField();
        btn_cargar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal");

        txta_Input.setEditable(false);
        txta_Input.setColumns(20);
        txta_Input.setRows(5);
        jScrollPane1.setViewportView(txta_Input);

        jLabel1.setText("Texto de entrada:");

        jLabel2.setText("Tokens Analizados:");

        txta_Output.setEditable(false);
        txta_Output.setColumns(20);
        txta_Output.setRows(5);
        jScrollPane2.setViewportView(txta_Output);

        btn_analizar.setText("Analizar");
        btn_analizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_analizarActionPerformed(evt);
            }
        });

        jLabel3.setText("Archivo:");

        txt_path.setEditable(false);

        btn_cargar.setText("Cargar");
        btn_cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txt_path, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_cargar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(321, 321, 321)
                        .addComponent(btn_analizar)))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cargar))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(btn_analizar)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        btn_analizar.getAccessibleContext().setAccessibleName("btn_analizar");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_analizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_analizarActionPerformed
         try  {
        ProbarLexerFile();//llamando al metodo ProbarLexerFile();
        }
        catch(IOException ex){
        System.out.println(ex.getMessage());}
    }//GEN-LAST:event_btn_analizarActionPerformed

    private void btn_cargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargarActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode( JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        fc.setFileFilter(filter);
        if( fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION ){
            txt_path.setText(fc.getSelectedFile().getAbsolutePath());
            leer();
        }
    }//GEN-LAST:event_btn_cargarActionPerformed

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
            java.util.logging.Logger.getLogger(Principal_frm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal_frm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal_frm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal_frm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal_frm().setVisible(true);
            }
        });
    }
    
    public void leer(){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File (txt_path.getText());
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
			// Lectura del fichero
			String linea;
			while((linea=br.readLine())!=null)
				txta_Input.append(linea + '\n');           
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
           // En el finally cerramos el fichero, para asegurarnos
           // que se cierra tanto si todo va bien como si salta 
           // una excepcion.
           try{
              if( null != fr ){
                 fr.close();
              }
           }catch (Exception e2){
              e2.printStackTrace();
           }
        }
    }
//empieza mi edicion
          
public void ProbarLexerFile() throws IOException{
    File fichero=new File("fichero.txt");//creando fichero txt en raiz
    PrintWriter writer;
    try{
        writer=new PrintWriter(fichero);
        writer.print(txta_Input.getText());//ingresado ecuacion
        writer.close();
    }
    catch(FileNotFoundException ex){
        Logger.getLogger(Principal_frm.class.getName()).log(Level.SEVERE, null, ex);
    }
    Reader reader;
    reader = new BufferedReader(new FileReader("fichero.txt"));
    Lexer lexer=new Lexer(reader);
    String Resultados="";
    //se comienza a evaluar cada caracter
    while(true){
        Token token=lexer.yylex();
        if(token==null){
            Resultados=Resultados+"FIN";
            txta_Output.setText(Resultados);//mostrando los resultados
            return;
        }//termina evaluacion
        switch(token){
            case ERROR://aqui se guardan los errores de lo que no coincide 
            Resultados=Resultados+"Error, el simbolo no coincide \n";
            break;
            case Variable: 
            case Numero://aqui se guardan las variables y los numeros
            Resultados=Resultados+"Token:"+token+" "+lexer.lexeme+"\n";
            default:
            Resultados=Resultados+"Token:"+token+"\n";//se guardan los operandos +- etc
        }	
    }	
}//termina mi edicion

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_analizar;
    private javax.swing.JButton btn_cargar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txt_path;
    private javax.swing.JTextArea txta_Input;
    private javax.swing.JTextArea txta_Output;
    // End of variables declaration//GEN-END:variables
}