/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BookListPannel.java
 *
 * Created on Jan 7, 2014, 5:39:01 PM
 */
package GUI;

import bookviewer.Page;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;
import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

/**
 *
 * @author byang1
 */
public class PageViewer extends javax.swing.JPanel {
    
    MouseListener doubleClickPageListListener;
    KeyListener     keyListstener;  
    boolean       initViewer =false;
    SwingController controller;
    SwingViewBuilder factory;
    
    ArrayList<Page> pageCollection;
    Page            selectedPage;
    /** Creates new form BookListPannel */
    public PageViewer(MouseListener DoubleClicked,KeyListener key,ArrayList<Page> pages) {
        pageCollection = pages;
        doubleClickPageListListener =DoubleClicked;
        keyListstener =key;
        initComponents();
        enableListener();
    }
    
    public JList getPageList(){
        return PageList;
    }
    public JTextField getSearchField(){
        return seachTextField;
    }
    public JButton getSearchButton(){
        return seachButton;
    }
    public void setTittle(String t){
        BookName.setText("Book: "+t);
    }
    public final void enableListener(){
        PageList.addMouseListener(doubleClickPageListListener);
        seachTextField.addKeyListener(this.keyListstener);
    }
    public void disableListener(){
        PageList.removeMouseListener(doubleClickPageListListener);
        seachTextField.removeKeyListener(keyListstener);
    }
    public void openPage(String t){
         
        if(initViewer ==false){
            java.awt.GridBagConstraints gridBagConstraints;
            this.remove(this.viewerPanel);
            //building a controller
               if(controller ==null) controller = new SwingController();
            //Build a SwingViewFactory configured with the controller
               if(factory ==null )  factory = new SwingViewBuilder(controller);
            //Use the factory to build a JPanel that is pre-configured
            //with a complete, active Viewer UI.
               viewerPanel = factory.buildViewerPanel();
               // add copy keyboard command
               ComponentKeyBinding.install(controller, viewerPanel);
               controller.getDocumentViewController().setAnnotationCallback(
                       new org.icepdf.ri.common.MyAnnotationCallback(
                               controller.getDocumentViewController())
                       );
               // add interactive mouse link annotation support via callback
                viewerPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 2;
                gridBagConstraints.gridy = 2;
                gridBagConstraints.gridwidth = 3;
                gridBagConstraints.gridheight = 2;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
                gridBagConstraints.weightx = 2.0;
                gridBagConstraints.weighty = 2.0;
                gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
                add(viewerPanel, gridBagConstraints);
                 initViewer=true;
          }               
                controller.openDocument(t);
                controller.showPage(1);
               
    }
    
    public void setPageList(ArrayList<Page> pages,Page p){
 
         if(pages == null)  pageCollection.removeAll(pageCollection);
        selectedPage = p;
    }
    
    public void updateList(){
        Page pageArray[] = new Page[1]; //just to establish array type
	    getPageList().setListData(((Page []) pageCollection.toArray(pageArray)));
            
           
		if (selectedPage != null)
			getPageList().setSelectedValue(selectedPage, true);
    }
    
    public void update(){
        disableListener();
        updateList();
        enableListener();
    }
    
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        BookListScroll = new javax.swing.JScrollPane();
        PageList = new javax.swing.JList();
        seachTextField = new javax.swing.JTextField();
        seachButton = new javax.swing.JButton();
        BookLabel = new javax.swing.JLabel();
        viewerPanel = new javax.swing.JPanel();
        BookName = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        PageList.setBorder(javax.swing.BorderFactory.createTitledBorder("Page Index"));
        PageList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        BookListScroll.setViewportView(PageList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(BookListScroll, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 150);
        add(seachTextField, gridBagConstraints);

        seachButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/search32.png"))); // NOI18N
        seachButton.setText("Search Book");
        seachButton.setToolTipText("Search Book");
        seachButton.setMinimumSize(new java.awt.Dimension(130, 41));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(seachButton, gridBagConstraints);

        BookLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BookLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/book.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(BookLabel, gridBagConstraints);

        viewerPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.weighty = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(viewerPanel, gridBagConstraints);

        BookName.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        BookName.setText("Book :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 2.0;
        add(BookName, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BookLabel;
    private javax.swing.JScrollPane BookListScroll;
    private javax.swing.JLabel BookName;
    private javax.swing.JList PageList;
    private javax.swing.JButton seachButton;
    private javax.swing.JTextField seachTextField;
    private javax.swing.JPanel viewerPanel;
    // End of variables declaration//GEN-END:variables
}
