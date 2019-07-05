package com.project.views;


import com.project.services.impl.ItemServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class ViewForm {

    public static void runUI(String pathLocal, String pathNet) {
        JFrame frame = new JFrame();
        frame.setTitle("Save picture from Google page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(700, 300));
        frame.setLocation(100, 100);
        Panel panel = new Panel(new GridBagLayout());
        frame.setLayout(new GridBagLayout());
        JLabel labelNetPath = new JLabel("Path from net:");
        JTextField textLocalPath = new JTextField(pathLocal, 25);
        textLocalPath.setForeground(Color.GRAY);
        JLabel labelLocalPath = new JLabel("Local path for saving:");
        JTextField textNetPath = new JTextField(pathNet, 25);
        textNetPath.setForeground(Color.GRAY);
        JButton saveButtonToFile = new JButton("Save item into file.xml");
        saveButtonToFile.addActionListener((ActionEvent e) -> {
            ItemServiceImpl.getItemInformation(pathNet);
                }
        );
        String[] columnNames = {
                "ID",
                "Name",
                "price",
                "imageUrl"
        };

        String[][] data = {
                {"12", " it", "Folder", ""}};

        JTable tableItem = new JTable(data, columnNames);

        JScrollPane scrollPane = new JScrollPane(tableItem);
        JButton saveButtonToDB = new JButton("Save ");
        saveButtonToDB.addActionListener(e -> {
            ItemServiceImpl.addItemInformation();
        });


        JButton updateButtonToDB = new JButton("Update");
        updateButtonToDB.addActionListener(e -> {
            ItemServiceImpl.addItemInformation();
        });

        JButton deleteButtonToDB = new JButton("Delete");
        deleteButtonToDB.addActionListener(e -> {
            ItemServiceImpl.addItemInformation();
        });
        JButton selectButtonToDB = new JButton("Select");
        selectButtonToDB.addActionListener(e -> {
            ItemServiceImpl.addItemInformation();
        });

        panel.add(labelNetPath, new
                GridBagConstraints(0, 0, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL,
                new Insets(1, 2, 3, 4), 0, 0));
        panel.add(textNetPath, new
                GridBagConstraints(1, 0, 40, 1, 50.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL,
                new Insets(1, 2, 3, 4), 0, 0));
        panel.add(labelLocalPath, new
                GridBagConstraints(0, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL,
                new Insets(1, 2, 3, 4), 0, 0));
        panel.add(textLocalPath, new GridBagConstraints(1, 1, 40, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL,
                new Insets(1, 2, 3, 4), 0, 0));
      /*  panel.add(chooseFileFolderButton, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL,
                new Insets(1, 2, 3, 4), 0, 0));*/
        panel.add(saveButtonToFile, new
                GridBagConstraints(7, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL,
                new Insets(1, 2, 3, 4), 0, 0));
        panel.add(scrollPane, new
                GridBagConstraints(1, 2, 40, 4, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL,
                new Insets(1, 2, 3, 4), 0, 0));
        panel.add(saveButtonToDB, new
                GridBagConstraints(5, 3, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL,
                new Insets(1, 2, 3, 4), 0, 0));
        panel.add(updateButtonToDB, new
                GridBagConstraints(5, 4, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL,
                new Insets(1, 2, 3, 4), 0, 0));

        panel.add(deleteButtonToDB, new
                GridBagConstraints(5, 5, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL,
                new Insets(1, 2, 3, 4), 0, 0));        //  panel.add(textArea);
        panel.add(selectButtonToDB, new
                GridBagConstraints(5, 6, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL,
                new Insets(1, 2, 3, 4), 0, 0));
        frame.add(panel);
        frame.setVisible(true);
    }

}
