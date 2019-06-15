import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;


public class MyApp {
    final static String PATH_LOCAL = "D:\\Projects\\testProject\\data";
    final static String PATH_NET = "https://prom.ua/p895411456-igrovoj-noutbu-omen.html";
   /* enum Action {
        FILE_EXIST_ANOTHER_SIZE,
        FILE_EXISTS,
        FILE_COPY
    }*/

    public static void main(String[] args) {
        new MyApp().runUI();
    }

    private void runUI() {
        JFrame frame = new JFrame();
        frame.setTitle("Save picture from Google page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(700, 200));
        frame.setLocation(100, 100);
        Panel panel = new Panel(new GridBagLayout());
        frame.setLayout(new GridBagLayout());


        JLabel labelNetPath = new JLabel("Path from net:");
        JTextField textLocalPath = new JTextField(PATH_LOCAL, 25);
        textLocalPath.setForeground(Color.GRAY);
        JLabel labelLocalPath = new JLabel("Local path for saving:");
        JTextField textNetPath = new JTextField(PATH_NET, 25);
        textNetPath.setForeground(Color.GRAY);
//        JTextArea textArea = new JTextArea(5, 30);
//        textArea.setBackground(frame.getBackground());
//        textArea.setLineWrap(true);
//        textArea.setWrapStyleWord(true);
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
        saveButton.addActionListener(new ActionListener() {
                                         @Override
                                         public void actionPerformed(ActionEvent e) {
                                             Document doc = null;
                                             try {
                                                 doc = Jsoup.connect(PATH_NET)
                                                         .get();
                                                 SaveProduktInformationAction saveInformation =
                                                         new SaveProduktInformationAction(textLocalPath.getText(), textNetPath.getText());
                                                 saveInformation.getImage(doc);
                                             } catch (IOException e1) {
                                                 e1.printStackTrace();
                                             }
                                         }
                                     });

               // SaveProduktInformationAction(textLocalPath.getText(), textNetPath.getText()));

        panel.add(labelNetPath,new

    GridBagConstraints(0,0,1,1,0.0,0.9,GridBagConstraints.NORTH,
                       GridBagConstraints.HORIZONTAL,
                                    new Insets(1,2,3,4),0,0));

        panel.add(textNetPath,new

    GridBagConstraints(1,0,1,1,0.0,0.9,GridBagConstraints.NORTH,
                       GridBagConstraints.HORIZONTAL,
                        new Insets(1,2,3,4),0,0));
        panel.add(labelLocalPath,new

    GridBagConstraints(0,1,1,1,0.0,0.9,GridBagConstraints.NORTH,
                       GridBagConstraints.HORIZONTAL,
                     new Insets(1,2,3,4),0,0));

        panel.add(textLocalPath,new GridBagConstraints(1,1,1,1,0.0,0.9,GridBagConstraints.NORTH,
                       GridBagConstraints.HORIZONTAL,
                new Insets(1,2,3,4),0,0));
        panel.add(chooseFileFolderButton, new GridBagConstraints(2,1,1,1,0.0,0.9,GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL,
                new Insets(1,2,3,4),0,0));

        panel.add(saveButton,new

    GridBagConstraints(0,3,1,1,0.0,0.9,GridBagConstraints.NORTH,
                       GridBagConstraints.HORIZONTAL,
                new Insets(1,2,3,4),0,0));
    //  panel.add(textArea);
        frame.add(panel);
        frame.setVisible(true);
}


public class SaveProduktInformationAction{

    private final String localPath;

    SaveProduktInformationAction(String textLocalPath, String textNetPath) {
        this.localPath = textLocalPath;
    }
    private void getImage(Document doc) throws IOException {
        String imageURL = "";
        Elements metaOgTitle = doc.select("meta[property=og:image]");
        Elements price = doc.getElementsByClass("x-product-price__value");
        Elements x_title =doc.getElementsByClass("x-title");
        //System.out.println("Title :" + x_title.attr("data-qaprice"));
        System.out.println("Price : " +price.attr("data-qaprice"));
        if (metaOgTitle != null) {
            imageURL = metaOgTitle.attr("content");
        }
        InputStream in = new BufferedInputStream(new URL(imageURL).openStream());


        OutputStream out = new BufferedOutputStream(new FileOutputStream(localPath + "/Image-001.jpg"));

        for (int i; (i = in.read()) != -1; ) {
            out.write(i);
        }
        in.close();
        out.close();
    }

    private File createFile(String path, String fileName) {
        return new File(new File(path), fileName + ".png");
    }

}

}
