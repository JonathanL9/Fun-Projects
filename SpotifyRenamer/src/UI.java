import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.DefaultMenuLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;

public class UI extends JFrame{
        public static void main(String[ ] Args) {
            JFrame spotifyUI = new JFrame("Spotify");
            final File[] playList = {null};


            spotifyUI.setVisible(true);
            spotifyUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            spotifyUI.setSize(800, 700);

            ImageIcon icon= new ImageIcon ("Assets/spotify-app-logo-spotify-icon-transparent-free_png.png.png");
            spotifyUI.setIconImage(icon.getImage());
            Font Spotify = null;
            Font SpotifyLight= null;
            Font SpotifyBold=null;
            try{
                Spotify= Font.createFont(Font.TRUETYPE_FONT,new File("Assets/GothamBold.ttf")).deriveFont(40f);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,new File("Assets/GothamBold.ttf")));

                SpotifyLight= Font.createFont(Font.TRUETYPE_FONT,new File("Assets/Gotham-Light.otf")).deriveFont(20f);
                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,new File("Assets/Gotham-Light.otf")));

                SpotifyBold= Font.createFont(Font.TRUETYPE_FONT,new File("Assets/GothamBold.ttf")).deriveFont(15f);
                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,new File("Assets/GothamBold.ttf")));

            }
            catch (Exception e){
                System.out.println(e);
            }

            JPanel myPanel = new JPanel();
            JPanel myPanelTitle = new JPanel();
            JPanel myPanelExecute= new JPanel();

            myPanelTitle.setLayout(new GridLayout(1,1));
            myPanel.setLayout(new GridLayout(1,1));
            myPanel.setBackground(Color.BLACK);
            myPanel.setLayout(new GridLayout(2,2,0,0));


            spotifyUI.getContentPane().setBackground(Color.BLACK);
            myPanelTitle.setBackground(Color.BLACK);
            JLabel Title=new JLabel("Spotify Renamer");
            Title.setHorizontalAlignment(JLabel.CENTER);
            Title.setFont(Spotify);
            Title.setForeground(Color.white);
            Title.setBorder(new EmptyBorder(50, 0, 70, 0));

            JLabel Chooser= new JLabel("Choose your file Directory");
            Chooser.setFont(SpotifyLight);
            Chooser.setForeground(Color.white);
            Chooser.setHorizontalAlignment(JLabel.CENTER);
            JLabel Changer = new JLabel("Word to be Removed");
            Changer.setFont(SpotifyLight);
            Changer.setForeground(Color.white);
            Changer.setHorizontalAlignment(JLabel.CENTER);
            JTextField Word = new JTextField();
            Word.setFont(new Font("Arial", Font.PLAIN, 20));

            JButton chooseButton= new JButton("Choose");
            chooseButton.setFont(SpotifyBold);
            chooseButton.setForeground(Color.WHITE);
            chooseButton.setFocusPainted(false);
            chooseButton.setContentAreaFilled(false);
            chooseButton.setOpaque(false);
            chooseButton.setSize(50, 50);
            chooseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser folderChooser = new JFileChooser();
                    folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    int result = folderChooser.showOpenDialog(null);
                    if (result == JFileChooser.APPROVE_OPTION) {

                        playList[0] = new File(folderChooser.getSelectedFile().getAbsolutePath());
                        System.out.println("Selected folder: " + playList[0].getAbsolutePath());
                    }
                }
            });


            JButton executeButton= new JButton("Execute");
            executeButton.setFont(SpotifyBold);
            executeButton.setForeground(Color.WHITE);
            executeButton.setFocusPainted(false);
            executeButton.setContentAreaFilled(false);
            executeButton.setOpaque(false);
            executeButton.setSize(50, 50);
            executeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String remove = Word.getText();

                    File[] songs= new File(String.valueOf(playList[0])).listFiles();
                    System.out.println("Text to be removed : " + remove);

                    for(File song : songs){
                        String oldName=song.getName();
                        String newName=oldName.replace(remove,"");

                        File newFileName= new File(playList[0] + "/" + newName);
                        if(song.renameTo(newFileName)){
                            System.out.println("Old File Name : " + oldName);
                            System.out.println("New File Name: "+ newName);
                        }
                        else System.out.println("Failed to Rename the File");

                    }

                    JOptionPane.showMessageDialog(null, "Files renamed successfully", "Success", JOptionPane.INFORMATION_MESSAGE);


                }
            });

            spotifyUI.setLayout(new BorderLayout());

            myPanelTitle.add(Title);
            myPanel.add(Chooser);
            myPanel.add(chooseButton);
            myPanel.add(Changer);
            myPanel.add(Word);


            myPanelExecute.setBackground(Color.BLACK);
            myPanelExecute.add(executeButton);

            spotifyUI.add(myPanelTitle, BorderLayout.NORTH);
            spotifyUI.add(myPanel, BorderLayout.CENTER);
            spotifyUI.add(myPanelExecute,BorderLayout.SOUTH);





            spotifyUI.revalidate();
            spotifyUI.setResizable(false);

        }



}




