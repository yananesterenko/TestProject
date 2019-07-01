package com.project.views;


import com.project.services.CollectItemInformation;

import javax.swing.*;
import java.awt.*;


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
        JButton saveButtonToFile = new JButton("Save information about product into file");
        saveButtonToFile.addActionListener(e -> {
                    CollectItemInformation.getItemInformation(pathNet);
                }
        );
        JButton saveButtonToDB = new JButton("Save information into DB");
        saveButtonToDB.addActionListener(e -> {
            CollectItemInformation.saveItemInformation();
        });
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
        panel.add(saveButtonToFile, new
                GridBagConstraints(0, 3, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL,
                new Insets(1, 2, 3, 4), 0, 0));
        panel.add(saveButtonToDB, new
                GridBagConstraints(1, 3, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL,
                new Insets(1, 2, 3, 4), 0, 0));
        //  panel.add(textArea);
        frame.add(panel);
        frame.setVisible(true);
    }

}
