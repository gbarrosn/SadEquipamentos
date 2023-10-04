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
class ImageRendererNormalUser extends DefaultTableCellRenderer {

    ImageIcon Icon;

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean selected, boolean focus,
            int row, int col) {

        
        Icon = new ImageIcon(getClass().getResource("/resources/Icons/administrator_32.png"));

        this.setIcon(Icon);
        return this;
    }
}
