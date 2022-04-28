package graphics;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;

public class InfoDialog extends JDialog{
    private static final String[] columnNames = {"Animal", "Color", "Weight", "Hor speed", "Ver speed", "Eat counter"};
    private Object[][] data;

    private class Table extends JTable {
        public Table() {
            super(data, columnNames);
            this.setFillsViewportHeight(true);
        }
    }

    public static int getColumnNumber(){
        return columnNames.length;
    }

    public InfoDialog(){
        this.setTitle("Info table");
        setModal(true);
        this.setLayout(new FlowLayout());
        data = ZooPanel.getData();
        this.add(new JScrollPane(new Table()));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
