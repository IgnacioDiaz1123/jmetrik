package com.itemanalysis.jmetrik.gui;

import com.itemanalysis.jmetrik.sql.DataTableName;
import com.itemanalysis.jmetrik.sql.DatabaseName;
import com.itemanalysis.jmetrik.swing.ExtensionFileFilter;
import com.itemanalysis.jmetrik.workspace.ImportSpssCommand;
import com.itemanalysis.jmetrik.workspace.JmetrikPreferencesManager;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;


public class ImportSpssDialog extends JDialog {

    // Variables declaration - do not modify
    private JButton browseButton;
    private JButton cancelButton;
    private JRadioButton dataValueRadioButton;
    private JLabel descriptionLabel;
    private JScrollPane descriptionScrollPane;
    private JTextArea descriptionTextArea;
    private JButton importButton;
    private JButton pluginButton;
    private JLabel spssFileLabel;
    private JLabel spssFileLabel1;
    private JTextField spssFileTextField;
    private JTextField pluginTextField;
    private JLabel tableNameLabel;
    private JTextField tableNameTextField;
    private JPanel valueLabelPanel;
    private JRadioButton valueLabelRadioButton;
    private ButtonGroup valueLabelsButtonGroup;
    // End of variables declaration

    private DatabaseName dbName = null;
    private DataTableName tableName = null;
    private String currentDirectory  = "";
    private boolean canRun = false;
    private JFileChooser importChooser = null;
    private JFileChooser pluginPathChooser = null;
    private ImportSpssCommand command = null;
    private JmetrikPreferencesManager prefs = null;
    private String currentPluginPath = "";
    static Logger logger = Logger.getLogger("jmetrik-logger");

    /**
     * Creates new form ImportSpssDialog
     */
    public ImportSpssDialog(Jmetrik parent, DatabaseName dbName, String currentDirectory) {
        super(parent,"Import SPSS File",true);
        this.dbName = dbName;
        this.currentDirectory = currentDirectory;

        //prevent running an analysis when window close button is clicked
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                canRun = false;
            }
        });

        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        initComponents();
        getPluginPathFromPreferences();
        setResizable(false);
        setLocationRelativeTo(parent);
    }

    private void getPluginPathFromPreferences(){
        prefs = new JmetrikPreferencesManager();
        currentPluginPath = prefs.getSpssPluginPath();
        if(!"".equals(currentPluginPath)){
            pluginTextField.setText(currentPluginPath);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        valueLabelsButtonGroup = new ButtonGroup();
        tableNameLabel = new JLabel();
        tableNameTextField = new JTextField();
        spssFileTextField = new JTextField();
        spssFileLabel = new JLabel();
        browseButton = new JButton();
        valueLabelPanel = new JPanel();
        dataValueRadioButton = new JRadioButton();
        valueLabelRadioButton = new JRadioButton();
        descriptionScrollPane = new JScrollPane();
        descriptionTextArea = new JTextArea();
        descriptionLabel = new JLabel();
        importButton = new JButton();
        cancelButton = new JButton();
        spssFileLabel1 = new JLabel();
        pluginTextField = new JTextField();
        pluginButton = new JButton();

        setPreferredSize(new Dimension(475, 360));

        dataValueRadioButton.setActionCommand("data");
        valueLabelRadioButton.setActionCommand("vlabels");

        tableNameLabel.setText("Table Name:");

        tableNameTextField.setPreferredSize(new Dimension(300, 28));

        spssFileTextField.setPreferredSize(new Dimension(300, 28));

        spssFileLabel.setText("SPSS File:");

        browseButton.setText("Browse");
        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        valueLabelPanel.setBorder(BorderFactory.createTitledBorder("Use original data or convert to value labels?"));

        valueLabelsButtonGroup.add(dataValueRadioButton);
        dataValueRadioButton.setSelected(true);
        dataValueRadioButton.setText("Original data");
        dataValueRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dataRadioButtonActionPerformed(evt);
            }
        });
        dataValueRadioButton.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                dataValueRadioButtonPropertyChange(evt);
            }
        });

        valueLabelsButtonGroup.add(valueLabelRadioButton);
        valueLabelRadioButton.setText("Convert data to value labels");
        valueLabelRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                valueLabelsRadioButtonActionPerformed(evt);
            }
        });

        GroupLayout valueLabelPanelLayout = new GroupLayout(valueLabelPanel);
        valueLabelPanel.setLayout(valueLabelPanelLayout);
        valueLabelPanelLayout.setHorizontalGroup(
                valueLabelPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(valueLabelPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(dataValueRadioButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(valueLabelRadioButton)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        valueLabelPanelLayout.setVerticalGroup(
                valueLabelPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(valueLabelPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(dataValueRadioButton)
                                .addComponent(valueLabelRadioButton))
        );

        descriptionScrollPane.setPreferredSize(new Dimension(373, 112));

        descriptionTextArea.setColumns(20);
        descriptionTextArea.setRows(5);
        descriptionTextArea.setPreferredSize(new Dimension(275, 100));
        descriptionScrollPane.setViewportView(descriptionTextArea);

        descriptionLabel.setText("Description:");

        importButton.setText("Import");
        importButton.setPreferredSize(new Dimension(72, 28));
        importButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                importButtonActionPerformed(evt);
            }
        });

        cancelButton.setLabel("Cancel");
        cancelButton.setPreferredSize(new Dimension(72, 28));
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        spssFileLabel1.setText("Plugin:");

        pluginTextField.setPreferredSize(new Dimension(300, 28));

        pluginButton.setText("Browse");
        pluginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                pluginButtonActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(spssFileLabel1)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(pluginTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(pluginButton))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(tableNameLabel)
                                                                        .addComponent(spssFileLabel))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(tableNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(spssFileTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(browseButton))))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addComponent(descriptionLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(importButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(descriptionScrollPane, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(valueLabelPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(tableNameLabel)
                                        .addComponent(tableNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(spssFileTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(spssFileLabel)
                                        .addComponent(browseButton))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(pluginTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(spssFileLabel1)
                                        .addComponent(pluginButton))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(descriptionLabel)
                                        .addComponent(descriptionScrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(valueLabelPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(importButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16))
        );
        pack();
    }// </editor-fold>

    public boolean canRun(){
        return canRun;
    }

    public String getCurrentDirectory(){
        return currentDirectory;
    }

    public ImportSpssCommand getCommand(){
        return command;
    }

    private void browseButtonActionPerformed(ActionEvent evt) {
        if(null==importChooser){
            importChooser = new JFileChooser();
            String description = "SPSS Files (*.sav)";
            String[] extension = {"sav"};
            ExtensionFileFilter filter = new ExtensionFileFilter(description, extension);

            importChooser.setAcceptAllFileFilterUsed(true);
            importChooser.addChoosableFileFilter(filter);
            importChooser.setFileFilter(filter);
            importChooser.setDialogType(JFileChooser.OPEN_DIALOG);
            importChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            importChooser.setDialogTitle("Import SPSS File");

        }

        importChooser.setVisible(true);

        if(importChooser.showDialog(ImportSpssDialog.this, "OK") != JFileChooser.APPROVE_OPTION){
            return;
        }

        File f=importChooser.getSelectedFile();
        importChooser.setCurrentDirectory(f);
        spssFileTextField.setText(f.getAbsolutePath());

    }

    private void pluginButtonActionPerformed(ActionEvent evt) {
        if(null==pluginPathChooser){
            pluginPathChooser = new JFileChooser();
            String description = "Java Files (*.jar)";
            String[] extension = {"jar"};
            ExtensionFileFilter filter = new ExtensionFileFilter(description, extension);

            pluginPathChooser.setAcceptAllFileFilterUsed(true);
            pluginPathChooser.addChoosableFileFilter(filter);
            pluginPathChooser.setFileFilter(filter);
            pluginPathChooser.setDialogType(JFileChooser.OPEN_DIALOG);
            pluginPathChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            pluginPathChooser.setDialogTitle("Path to SPSS Plugin");
        }

        pluginPathChooser.setVisible(true);

        if(pluginPathChooser.showDialog(ImportSpssDialog.this, "OK")!=JFileChooser.APPROVE_OPTION){
            return;
        }

        File f=pluginPathChooser.getCurrentDirectory();
        pluginPathChooser.setCurrentDirectory(f);
        pluginTextField.setText(f.getAbsolutePath());

    }

    private void dataRadioButtonActionPerformed(ActionEvent evt) {
        if(dataValueRadioButton.isSelected()){

        }
    }

    private void dataValueRadioButtonPropertyChange(PropertyChangeEvent evt) {
        if(valueLabelRadioButton.isSelected()){

        }
    }



    private void importButtonActionPerformed(ActionEvent evt) {
        String tableName = tableNameTextField.getText().trim();

        File f = new File(pluginTextField.getText().trim());

        if(tableName.equals("")){
            JOptionPane.showMessageDialog(
                    ImportSpssDialog.this,
                    "Please type a value for table name.",
                    "Data Name Error",
                    JOptionPane.ERROR_MESSAGE);
        }else if(!f.exists()){
            JOptionPane.showMessageDialog(
                    ImportSpssDialog.this,
                    "The required plugin was not found. Importing an SPSS file requires\n" +
                    "a licensed copy of IBM SPSS. If you have a licensed copy, make\n" +
                    "sure this path points to the location of the 'spssjavaplugin.jar'\n"+
                    "file. On a Windows machine this file is located in the IBM SPSS\n"+
                    "installation directory. On Mac OSX it is located in the bin directory\n"+
                    "under the Content directory in the IBM SPSS Statistics application\n"+
                    "bundle. On Linux and UNIX it is located in the bin directory under\n"+
                    "the IBM SPSS Statistics installation directory.",
                    "SPSS Plugin Error",
                    JOptionPane.ERROR_MESSAGE);
        }else if(spssFileTextField.getText().trim().equals("")){
            JOptionPane.showMessageDialog(
                    ImportSpssDialog.this,
                    "Please type a value for SPSS file to import.",
                    "Import Data File Error",
                    JOptionPane.ERROR_MESSAGE);
        }else if(pluginTextField.getText().trim().equals("")){
            JOptionPane.showMessageDialog(
                    ImportSpssDialog.this,
                    "Please type the path to the SPSS plugin.",
                    "SPSS Plugin Not Found",
                    JOptionPane.ERROR_MESSAGE);
        }else if(tableName.indexOf("variables")>-1){
            JOptionPane.showMessageDialog(
                    ImportSpssDialog.this,
                    "The data name may not contain the word 'variables'.",
                    "Data Name Error",
                    JOptionPane.ERROR_MESSAGE);
        }else{
            command = new ImportSpssCommand();
            currentDirectory = spssFileTextField.getText().trim().replaceAll("\\\\", "/");

            DataTableName derbyTableName = new DataTableName(tableName);
            tableNameTextField.setText(derbyTableName.toString());

            command.getPairedOptionList("data").addValue("db", dbName.getName());
            command.getPairedOptionList("data").addValue("table", derbyTableName.toString());

            command.getSelectOneOption("use").setSelected(valueLabelsButtonGroup.getSelection().getActionCommand());
            command.getFreeOption("file").add(spssFileTextField.getText().trim());
            command.getFreeOption("pluginpath").add(f.getAbsolutePath());

            if(!"".equals(descriptionTextArea.getText().trim())){
                command.getFreeOption("description").add(descriptionTextArea.getText().trim());
            }

            if(!currentPluginPath.equals(f.getAbsolutePath())){
                prefs.setSpssPluginPath(f.getAbsolutePath());
            }

            if(derbyTableName.nameChanged()){
                JOptionPane.showMessageDialog(
                        ImportSpssDialog.this,
                        derbyTableName.printNameChange(),
                        "Data Name Changed",
                        JOptionPane.INFORMATION_MESSAGE);
            }

            canRun=true;
            setVisible(false);

        }



        
        
    }

    private void cancelButtonActionPerformed(ActionEvent evt) {
        canRun=false;
        setVisible(false);
    }



    private void valueLabelsRadioButtonActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }


                 
}

