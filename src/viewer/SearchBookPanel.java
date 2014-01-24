/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viewer;

/**
 *
 * @author brianyang
 */
public class SearchBookPanel extends javax.swing.JPanel {

    /**
     * Creates new form SearchBookPanel
     */
    public SearchBookPanel() {
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

        typeButtonGroup = new javax.swing.ButtonGroup();
        searchLabel = new javax.swing.JLabel();
        searchContentField = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        titleRadioButton = new javax.swing.JRadioButton();
        codeRadioButton = new javax.swing.JRadioButton();
        pathRadioButton = new javax.swing.JRadioButton();
        authorRadioButton = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultList = new javax.swing.JList();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchLabel.setText("Search book: ");
        add(searchLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        searchContentField.setText("jTextField1");
        add(searchContentField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 273, 40));

        submitButton.setText("Search");
        add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 67, -1, -1));

        titleLabel.setText("Book Search Dialog");
        add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        typeButtonGroup.add(titleRadioButton);
        titleRadioButton.setText("Book Title");
        add(titleRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        typeButtonGroup.add(codeRadioButton);
        codeRadioButton.setText("Book Code");
        add(codeRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        typeButtonGroup.add(pathRadioButton);
        pathRadioButton.setText("Book Path");
        add(pathRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, -1, -1));

        typeButtonGroup.add(authorRadioButton);
        authorRadioButton.setText("Book Author");
        add(authorRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, -1));

        resultList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(resultList);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 470, 280));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton authorRadioButton;
    private javax.swing.JRadioButton codeRadioButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton pathRadioButton;
    private javax.swing.JList resultList;
    private javax.swing.JTextField searchContentField;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JRadioButton titleRadioButton;
    private javax.swing.ButtonGroup typeButtonGroup;
    // End of variables declaration//GEN-END:variables

    

    public javax.swing.JRadioButton getAuthorRadioButton() {
        return authorRadioButton;
    }

    public javax.swing.JRadioButton getCodeRadioButton() {
        return codeRadioButton;
    }

    public javax.swing.JRadioButton getPathRadioButton() {
        return pathRadioButton;
    }

    public javax.swing.JTextField getSearchContentField() {
        return searchContentField;
    }

    public javax.swing.JButton getSubmitButton() {
        return submitButton;
    }

    public javax.swing.JRadioButton getTitleRadioButton() {
        return titleRadioButton;
    }

    public javax.swing.ButtonGroup getTypeButtonGroup() {
        return typeButtonGroup;
    }

    public javax.swing.JList getResult() {
        return resultList;
    }
}
