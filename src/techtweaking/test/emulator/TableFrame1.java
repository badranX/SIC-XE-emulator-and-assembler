package techtweaking.test.emulator;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import javax.swing.JScrollPane;

public class TableFrame1 extends javax.swing.JFrame {

    /**
     * Creates new form TableFrame1
     */
    public TableFrame1() {
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     public TableFrame1(ArrayList<OpjectCode> searchList,ArrayList<Line> Ilines){
    
    setTitle("Table");
    JScrollPane incomePane = new JScrollPane();  
    ProgramWithOpjectCode panel = new ProgramWithOpjectCode(searchList,Ilines);
        incomePane.getViewport().add(panel);  
    this.add(incomePane);
    incomePane.add(panel);
        incomePane.setViewportView(panel);  
    incomePane.setVisible(true);
    this.add(incomePane);
    pack();

    }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

