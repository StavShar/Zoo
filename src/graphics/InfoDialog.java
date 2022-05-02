package graphics;

import javax.swing.*;
import java.awt.*;

/**
 * Dialog to see info table about the animals
 *
 * @version 1.0 1 May 2022
 * @author Stav Sharabi
 * */
public class InfoDialog extends JDialog{
    private static final String[] columnNames = {"Animal", "Color", "Weight", "Hor speed", "Ver speed", "Eat counter"};
    private Object[][] data;

    /**
     * Table to see info about the animals
     *
     * @version 1.0 1 May 2022
     * @author Stav Sharabi
     * */
    private class Table extends JTable {

        /**
         * Table constructor
         */
        public Table() {
            super(data, columnNames);
            this.setFillsViewportHeight(true);
        }
    }

    /**
     * returning the number of columns
     * @return number of columns
     */
    public static int getColumnNumber(){
        return columnNames.length;
    }

    /**
     * Info dialog constructor
     * @param list
     */
    public InfoDialog(Object[][] list){
        this.setTitle("Info table");
        setModal(true);
        this.setLayout(new FlowLayout());
        data = list;
        this.add(new JScrollPane(new Table()));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
