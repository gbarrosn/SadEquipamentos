/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author airton.oliveira
 */
class ImageRendererADM extends DefaultTableCellRenderer {

    ImageIcon Icon;
    int qtd;

public ImageRendererADM(int qtdADM){
    this.qtd=qtdADM;
}
    
    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean selected, boolean focus,
            int row, int col) {

        
        if (row <qtd){
        Icon = new ImageIcon(getClass().getResource("/resources/Icons/administrator_32.png"));
        }else{
        Icon = new ImageIcon(getClass().getResource("/resources/Icons/student_32.png"));    
        }
        
        this.setIcon(Icon);
        
        return this;
    }
}
