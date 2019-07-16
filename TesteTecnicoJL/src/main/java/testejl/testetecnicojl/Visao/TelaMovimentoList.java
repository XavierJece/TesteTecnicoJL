

package testejl.testetecnicojl.Visao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import testejl.testetecnicojl.Modelo.RN.GenericRN;
import testejl.testetecnicojl.Modelo.VO.MovimentoEstoque;
import testejl.testetecnicojl.Modelo.VO.Produto;

/**
 *
 * @author Jece Xavier
 */
public class TelaMovimentoList extends javax.swing.JInternalFrame {
    
//    Atributos
    private TelaMovimentoCRUD tmc;
    
    /**
     * Creates new form ProdutoCRUD
     */
    public TelaMovimentoList(TelaMovimentoCRUD tmc ) {
        initComponents();
        
        this.tmc = tmc;
        
        this.populaJtable();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panleFundo = new javax.swing.JPanel();
        btnFechar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMoviento = new javax.swing.JTable();

        panleFundo.setLayout(null);

        btnFechar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        panleFundo.add(btnFechar);
        btnFechar.setBounds(500, 10, 70, 23);

        btnEditar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        panleFundo.add(btnEditar);
        btnEditar.setBounds(10, 80, 120, 30);

        lblTitulo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Lista de Movimentação");
        panleFundo.add(lblTitulo);
        lblTitulo.setBounds(0, 10, 580, 60);

        tblMoviento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Produto", "Quantidade", "Tipo ", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMoviento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblMovientoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblMoviento);

        panleFundo.add(jScrollPane1);
        jScrollPane1.setBounds(10, 120, 560, 400);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panleFundo, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panleFundo, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
        );

        setBounds(0, 0, 600, 570);
    }// </editor-fold>//GEN-END:initComponents

    private void tblMovientoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblMovientoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tblMovientoKeyReleased

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(tblMoviento.getSelectedRow()!= -1){
            long id = (long) tblMoviento.getValueAt(tblMoviento.getSelectedRow(), 0);
            
            GenericRN<MovimentoEstoque>  movimentoRN = new GenericRN<>();
            
            MovimentoEstoque movimento = movimentoRN.findOne("id", id, MovimentoEstoque.class);
            this.abrirTelaEdicao(movimento);
        }else{
            JOptionPane.showMessageDialog(null, "Nenhum movimento selecionado :(", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnFecharActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panleFundo;
    private javax.swing.JTable tblMoviento;
    // End of variables declaration//GEN-END:variables
    
    /*Minhas Funções*/
    public void populaJtable(){
        DefaultTableModel modelo = (DefaultTableModel)(tblMoviento.getModel());
        modelo.setNumRows(0);
        GenericRN<MovimentoEstoque>  movimentoRN = new GenericRN<>();
        DateTimeFormatter formatadordDataBarra = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        for(MovimentoEstoque m : movimentoRN.listAll(MovimentoEstoque.class)){
            modelo.addRow(new Object[] {
                m.getId(),
                m.getProduto(),
                m.getQuantidade(),
                m.getTipoMovimento(),
                m.getDataMovimento().format(formatadordDataBarra)
            });
            
        }
        
        tblMoviento.setRowSorter(new TableRowSorter(modelo));
        
        
    }

    
    private void abrirTelaEdicao(MovimentoEstoque m){
        this.tmc.populaCampos(m);
        this.tmc.setTelaCadastro(false);
        this.tmc.setVisible(true);
        this.setVisible(false);
    }
}
