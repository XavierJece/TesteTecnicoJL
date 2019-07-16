/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testejl.testetecnicojl.Visao;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import javafx.util.converter.LocalDateStringConverter;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import testejl.testetecnicojl.Modelo.DAO.GenericDAO;
import testejl.testetecnicojl.Modelo.DAO.GenericDAOImpl;
import testejl.testetecnicojl.Modelo.RN.GenericRN;
import testejl.testetecnicojl.Modelo.VO.MovimentoEstoque;
import testejl.testetecnicojl.Modelo.VO.Produto;
import testejl.testetecnicojl.Modelo.VO.TipoMovimentacao;

/**
 *
 * @author Jece Xavier
 */
public class TelaProdutoCRUD extends javax.swing.JInternalFrame {
    
//    Atributos
    private Produto produto;
    private boolean telaCadastro;
    private TelaProdutoList tpl;
    
//    Construtor
    public TelaProdutoCRUD(String titulo, boolean telaCadastro) {
        initComponents();
        
        this.telaCadastro = telaCadastro;
        this.setTitle(titulo);
        
        this.limpaCampos();
        
        if(telaCadastro){
            this.lblCodigo.setVisible(false);
            this.txtCodigo.setVisible(false);
            
            this.lblDataCadastro.setVisible(false);
            this.txtDataCadastro.setVisible(false);
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

        panelFundo = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblDataCadastro = new javax.swing.JLabel();
        lblQuantidade = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        lblDescricao = new javax.swing.JLabel();
        txtDataCadastro = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        lblValor = new javax.swing.JLabel();
        txtValor = new javax.swing.JFormattedTextField();

        setToolTipText("");

        panelFundo.setLayout(null);

        lblCodigo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblCodigo.setText("Código da Produto: ");
        panelFundo.add(lblCodigo);
        lblCodigo.setBounds(10, 10, 200, 20);

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        panelFundo.add(txtCodigo);
        txtCodigo.setBounds(10, 40, 200, 30);

        lblDataCadastro.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblDataCadastro.setText("Data de Cadastro:");
        panelFundo.add(lblDataCadastro);
        lblDataCadastro.setBounds(290, 220, 140, 30);

        lblQuantidade.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblQuantidade.setText("Quantidade: ");
        panelFundo.add(lblQuantidade);
        lblQuantidade.setBounds(10, 220, 140, 30);

        txtQuantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtQuantidade.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQuantidadeFocusLost(evt);
            }
        });
        panelFundo.add(txtQuantidade);
        txtQuantidade.setBounds(10, 250, 210, 30);

        btnSalvar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        panelFundo.add(btnSalvar);
        btnSalvar.setBounds(430, 480, 140, 40);

        btnFechar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        panelFundo.add(btnFechar);
        btnFechar.setBounds(490, 10, 70, 23);

        lblDescricao.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblDescricao.setText("Descrição:");
        panelFundo.add(lblDescricao);
        lblDescricao.setBounds(10, 140, 140, 30);

        txtDataCadastro.setEditable(false);
        txtDataCadastro.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        panelFundo.add(txtDataCadastro);
        txtDataCadastro.setBounds(280, 250, 210, 30);

        txtDescricao.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        panelFundo.add(txtDescricao);
        txtDescricao.setBounds(10, 170, 210, 30);

        lblValor.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblValor.setText("Valor:");
        panelFundo.add(lblValor);
        lblValor.setBounds(280, 140, 140, 30);

        txtValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txtValor.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorFocusLost(evt);
            }
        });
        panelFundo.add(txtValor);
        txtValor.setBounds(280, 170, 210, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
        );

        setBounds(0, 0, 600, 570);
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(this.validarCampos()){
          
//            Lendo os dados inseridos;
            String descricao = this.txtDescricao.getText();
            int quantidade = Integer.parseInt(this.txtQuantidade.getText());
            double valor = converteValor();
            LocalDate data = LocalDate.now();
            
            GenericDAO<Produto> produtoRN = new GenericDAOImpl<>();
            
            if(this.telaCadastro){
                
                this.produto = new Produto(descricao, quantidade, data, valor);
                
                if(produtoRN.save(this.produto)){
                    JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Sucesso :)", 0,new ImageIcon(getClass().getResource("/icones/sucesso.png")));
                    this.limpaCampos();
                    this.tpl.populaJtable();
                }else{
                    JOptionPane.showMessageDialog(null, "Erro ao salvar", "Falha :(", 0,new ImageIcon(getClass().getResource("/icones/errado.png")));
                }
                
            }else{
               
                this.produto.setDescricao(descricao);
                this.produto.setQuatidadeMinima(quantidade);
                this.produto.setValor(valor);
                
                if(produtoRN.update(this.produto)){
                   JOptionPane.showMessageDialog(null, "Editado com sucesso!", "Sucesso :)", 0,new ImageIcon(getClass().getResource("/icones/sucesso.png")));
                   this.tpl.populaJtable();
                   this.tpl.setVisible(true);
                   this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Erro ao editar", "Falha :(", 0,new ImageIcon(getClass().getResource("/icones/errado.png")));
                }
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Dados Invalidos :(", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.setVisible(false);
        this.limpaCampos();
        this.escondeCampos();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void txtValorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorFocusLost
        converteValor();
    }//GEN-LAST:event_txtValorFocusLost

    private void txtQuantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantidadeFocusLost
        String quatidade = this.txtQuantidade.getText();
        quatidade = quatidade.replace("-", "");
        this.txtQuantidade.setText(quatidade);
        
    }//GEN-LAST:event_txtQuantidadeFocusLost

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDataCadastro;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblValor;
    private javax.swing.JPanel panelFundo;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDataCadastro;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JFormattedTextField txtQuantidade;
    private javax.swing.JFormattedTextField txtValor;
    // End of variables declaration//GEN-END:variables
    
    /*Minhas Funções*/
    private boolean validarCampos(){
        if( (this.txtDescricao.getText().isEmpty()) || (this.txtQuantidade.getText().isEmpty()) || (this.txtValor.getText().isEmpty())){
            return false;
        }else if( (Integer.parseInt(this.txtQuantidade.getText()) < 0) || (converteValor() <= 0) ){
            return false;
        }
        return true;
    }
    
    public void populaCampos(Produto p){
        this.txtCodigo.setText(String.valueOf(p.getId()));
        this.txtDescricao.setText(p.getDescricao());
        this.txtDataCadastro.setText(localDateToString(p.getDataCadastro()));
        this.txtQuantidade.setText(String.valueOf(p.getQuatidadeMinima()));
        this.txtValor.setText(String.valueOf(p.getValor()));
    }
    
    private double converteValor(){
        String vd = this.txtValor.getText();
        String vdf = vd.replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".").replace("-", "");
        double valor = Double.parseDouble(vdf);
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String vf = nf.format(valor);
        this.txtValor.setText(vf);
        
        return valor;
    }
    
    private void limpaCampos(){
        this.txtCodigo.setText("");
        this.txtDescricao.setText("");
        this.txtDataCadastro.setText("");
        this.txtQuantidade.setText("");
        this.txtValor.setText(""); 
        
    }
    
    public void apresentaCampos(){
        this.txtCodigo.setVisible(true);
        this.txtDataCadastro.setVisible(true);
        
        this.lblCodigo.setVisible(true);
        this.lblDataCadastro.setVisible(true);
    }
    
    public void escondeCampos(){
        this.txtCodigo.setVisible(false);
        this.txtDataCadastro.setVisible(false);
        
        this.lblCodigo.setVisible(false);
        this.lblDataCadastro.setVisible(false);
    }
    
    private String localDateToString(LocalDate d){
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       return d.format(formatter);
    }
    
    /*Gets and Sets*/

    public boolean isTelaCadastro() {
        return telaCadastro;
    }

    public void setTelaCadastro(boolean telaCadastro) {
        this.telaCadastro = telaCadastro;
    }

    public TelaProdutoList getTml() {
        return tpl;
    }

    public void setTml(TelaProdutoList tpl) {
        this.tpl = tpl;
    }
    
}
