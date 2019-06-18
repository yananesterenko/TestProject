package com.project.views;


import com.project.models.ItemInformation;
import com.project.services.FillXMLFileService;
import com.project.services.ItemInformationService;

import javax.swing.*;
import java.awt.*;
import java.io.File;


public class ViewForm {

    public static void runUI(String pathLocal, String pathNet) {

        JFrame frame = new JFrame();
        frame.setTitle("Save picture from Google page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(700, 200));
        frame.setLocation(100, 100);
        Panel panel = new Panel(new GridBagLayout());
        frame.setLayout(new GridBagLayout());
        JLabel labelNetPath = new JLabel("Path from net:");
        JTextField textLocalPath = new JTextField(pathLocal, 25);
        textLocalPath.setForeground(Color.GRAY);
        JLabel labelLocalPath = new JLabel("Local path for saving:");
        JTextField textNetPath = new JTextField(pathNet, 25);
        textNetPath.setForeground(Color.GRAY);

        JButton chooseFileFolderButton = new JButton("Choose file or folder");
        chooseFileFolderButton.addActionListener(e1 -> {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    int ret = fileChooser.showDialog(null, "Open file");
                    File direct = fileChooser.getCurrentDirectory();

                    textLocalPath.setText(fileChooser.getCurrentDirectory().toString());
                }

        );

        JButton saveButton = new JButton("Save information about product:");
        saveButton.addActionListener(e -> {

                    ItemInformation itemInformationObject = ItemInformationService.getItemInformation(pathNet);
                    FillXMLFileService.fillingFileXML(new File(System.getProperty("user.dir") + "/data", "item.xml"), itemInformationObject);
                }
        );

        panel.add(labelNetPath, new

                GridBagConstraints(0, 0, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL,
                new Insets(1, 2, 3, 4), 0, 0));

        panel.add(textNetPath, new

                GridBagConstraints(1, 0, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL,
                new Insets(1, 2, 3, 4), 0, 0));
        panel.add(labelLocalPath, new

                GridBagConstraints(0, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL,
                new Insets(1, 2, 3, 4), 0, 0));

        panel.add(textLocalPath, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL,
                new Insets(1, 2, 3, 4), 0, 0));
      /*  panel.add(chooseFileFolderButton, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL,
                new Insets(1, 2, 3, 4), 0, 0));*/

        panel.add(saveButton, new

                GridBagConstraints(0, 3, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL,
                new Insets(1, 2, 3, 4), 0, 0));
        //  panel.add(textArea);
        frame.add(panel);
        frame.setVisible(true);
    }

}
