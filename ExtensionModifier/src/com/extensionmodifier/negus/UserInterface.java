package com.extensionmodifier.negus;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
public class UserInterface extends JFrame{
    private JLabel folderPathLabel, newExtensionLabel;
    static protected JTextField folderPath, newExtension;
    private JButton selectFolder, modifyExtension; 
    SelectButton selectButtonHandler;
    Modify modifyButtonHandler;

static String filePath, extension;

static UserInterface UI = new UserInterface(); //creates object of the Userinterface class to help display the frame
/* This constructor is used to define the frame properties*/   
public UserInterface(){
        Container container = getContentPane();
        GridBagConstraints object = new GridBagConstraints();
        container = getContentPane();
        object = new GridBagConstraints();
        container.setBackground(Color.LIGHT_GRAY);
        container.setLayout(new GridBagLayout());
        object.insets = new Insets(5,5,0,0);
        
        folderPathLabel = new JLabel("Folder Path");
        object.gridx = 0;
        object.gridy = 0;
        container.add(folderPathLabel, object);
        
        folderPath = new JTextField(20);
        object.gridx = 1;
        object.gridy = 0;
        container.add(folderPath, object);
        
        newExtensionLabel = new JLabel("New Extension");
        object.gridx = 0;
        object.gridy = 1;
        container.add(newExtensionLabel, object);
        
        newExtension = new JTextField(20);
        object.gridx = 1;
        object.gridy = 1;
        container.add(newExtension, object);
        
        selectFolder = new JButton("Select");
        object.gridx = 1;
        object.gridy = 2;
        container.add(selectFolder, object);
        selectButtonHandler = new SelectButton();
        selectFolder.addActionListener(selectButtonHandler);
        
        modifyExtension = new JButton("Modify");
        object.gridx = 1;
        object.gridy = 3;
        container.add(modifyExtension, object);
        modifyButtonHandler = new Modify();
        modifyExtension.addActionListener(modifyButtonHandler);
        
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Extension Modifier");
        setResizable(true);
    }
    
/*
 * The select button enables you to be able to select a folder 
 * containing the files to be renamed*/
    public class SelectButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            int result = fileChooser.showOpenDialog(null);
            
            folderPath.setText(fileChooser.getSelectedFile().getAbsolutePath());
            if(result == JFileChooser.CANCEL_OPTION)
                System.exit(1);
            
        }
        
    }
    /*
     * The modify inner class invokes the fileModifier class to rename the 
     * files in the selected folder upon pressing the modify button
     * */
    public class Modify implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            filePath = folderPath.getText();
            extension = newExtension.getText();
            fileModifier modify = new fileModifier();
            modify.fileExtensionChanger();
            JOptionPane.showMessageDialog(null, "Files renamed successfully");
            
        }
        
    }
    
    public static void main(String[] args) {
        UI.setVisible(true);
    }

}
