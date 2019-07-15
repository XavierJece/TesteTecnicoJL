/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testejl.testetecnicojl.Visao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import testejl.testetecnicojl.Modelo.RN.GenericRN;
import testejl.testetecnicojl.Modelo.VO.Produto;

/**
 *
 * @author Jece Xavier
 */
public class ProdutoCRUD extends javax.swing.JInternalFrame {
    
//    Atributos
    private Produto produto;
    private boolean telaCadastro;
    
    /**
     * Creates new form ProdutoCRUD
     */
    public ProdutoCRUD(String titulo, boolean telaCadastro ) {
        initComponents();
        
        this.telaCadastro = telaCadastro;
        
        this.setTitle(titulo);
        this.lblDataCadastro.setVisible(false);
        this.txtDataCasdastro.setVisible(false);
        this.lblCodigo.setVisible(false);
        this.txtCodigo.setVisible(false);
    }
    
    public ProdutoCRUD( String titulo, Produto p, boolean telaCadastro) {
        initComponents();
        
        this.produto = p;
        
        this.telaCadastro = telaCadastro;
        
        this.setTitle(titulo);
        
        this.populaCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFundo = new javax.swing.JPanel();
        lblValor = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        lblQuantidadeMinima = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        txtValor = new javax.swing.JFormattedTextField();
        lblDataCadastro = new javax.swing.JLabel();
        txtQuantidadeMinima = new javax.swing.JFormattedTextField();
        txtDataCasdastro = new javax.swing.JFormattedTextField();

        setClosable(true);

        panelFundo.setLayout(null);

        lblValor.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblValor.setText("Valor:");
        panelFundo.add(lblValor);
        lblValor.setBounds(20, 240, 80, 22);

        lblCodigo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblCodigo.setText("Código Produto: ");
        panelFundo.add(lblCodigo);
        lblCodigo.setBounds(300, 20, 140, 20);

        lblDescricao.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblDescricao.setText("Descrição:");
        panelFundo.add(lblDescricao);
        lblDescricao.setBounds(20, 100, 80, 22);

        lblQuantidadeMinima.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblQuantidadeMinima.setText("Quantidade Minima: ");
        panelFundo.add(lblQuantidadeMinima);
        lblQuantidadeMinima.setBounds(20, 170, 170, 22);

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        panelFundo.add(txtCodigo);
        txtCodigo.setBounds(270, 50, 200, 30);

        txtDescricao.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        panelFundo.add(txtDescricao);
        txtDescricao.setBounds(20, 130, 280, 30);

        btnSalvar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        panelFundo.add(btnSalvar);
        btnSalvar.setBounds(330, 380, 140, 40);

        txtValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        panelFundo.add(txtValor);
        txtValor.setBounds(20, 270, 280, 30);

        lblDataCadastro.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblDataCadastro.setText("Data de Cadastro:");
        panelFundo.add(lblDataCadastro);
        lblDataCadastro.setBounds(70, 330, 140, 20);

        txtQuantidadeMinima.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        panelFundo.add(txtQuantidadeMinima);
        txtQuantidadeMinima.setBounds(20, 200, 280, 30);

        txtDataCasdastro.setEditable(false);
        txtDataCasdastro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss"))));
        panelFundo.add(txtDataCasdastro);
        txtDataCasdastro.setBounds(10, 360, 280, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 500, 470);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(this.validarCampos()){
            String descricao = this.txtDescricao.getText();
            int quatidadeMinima = Integer.parseInt(this.txtQuantidadeMinima.getText());
            double valor = Double.parseDouble(txtValor.getText());
            
            GenericRN<Produto> produtoRN = new GenericRN<>();
            
            if(telaCadastro){
                
                this.produto = new Produto(descricao, quatidadeMinima, LocalDate.now(), valor);
                
                if(produtoRN.save(produto)){
                    JOptionPane.showMessageDialog(null, "Cadastrado Com Sucesso :)", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Erro ao Salvar :(", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                
            }else{
                this.produto.setDrescricao(descricao);
                this.produto.setQuatidadeMinima(quatidadeMinima);
                this.produto.setValor(valor);
                
                if(produtoRN.update(produto)){
                    JOptionPane.showMessageDialog(null, "Editado Com Sucesso :)", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Erro ao Etidar :(", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Dados Invalidos :(", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDataCadastro;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblQuantidadeMinima;
    private javax.swing.JLabel lblValor;
    private javax.swing.JPanel panelFundo;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtDataCasdastro;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JFormattedTextField txtQuantidadeMinima;
    private javax.swing.JFormattedTextField txtValor;
    // End of variables declaration//GEN-END:variables
    
    /*Minhas Funções*/
    private boolean validarCampos(){
        if ( (txtDescricao.getText().isEmpty()) || (txtQuantidadeMinima.getText().isEmpty()) || txtValor.getText().isEmpty()) {
            return false;
        }
        return true;
    }
    
    private void populaCampos(){
        txtCodigo.setText(String.valueOf(produto.getId()));
        
        DateTimeFormatter formatadordDataBarra = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        txtDataCasdastro.setText(produto.getDataCadastro().format(formatadordDataBarra));
        
        txtDescricao.setText(produto.getDrescricao());
        txtQuantidadeMinima.setText(String.valueOf(produto.getQuatidadeMinima()));
        txtValor.setText(String.valueOf(produto.getValor()));
        
    }

}
