import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class CardFlipper extends JFrame {
    private ArrayList<String> imagePaths;
    private ArrayList<String> cardImages;
    private JButton[] cardButtons;
    private int fieldSize;
    public int moves = 0;
    private int numberOfMatches;
    private int firstCardIndex = -1;
    private int secondCardIndex;
    public long gameStart = System.currentTimeMillis();

    public CardFlipper() {
        setTitle("Color Memory Game");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        imagePaths = new ArrayList<>();

        cardImages = new ArrayList<>();
        for (String imagePath : imagePaths) {
            cardImages.add("");
        }

        Collections.shuffle(imagePaths);
        Collections.shuffle(cardImages);

        String[] size = {"12", "24"};
        int fieldSize = JOptionPane.showOptionDialog(null, "Press the size of the field you want: ",
                "Color Memory Game", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, null,
                size, size[1]);

        if (fieldSize == 0) {
            imagePaths.add("blue.png");
            imagePaths.add("dark blue.png");
            imagePaths.add("green.png");
            imagePaths.add("orange.png");
            imagePaths.add("pink.png");
            imagePaths.add("purple.png");
            imagePaths.add("blue.png");
            imagePaths.add("dark blue.png");
            imagePaths.add("green.png");
            imagePaths.add("orange.png");
            imagePaths.add("pink.png");
            imagePaths.add("purple.png");

            for (String imagePath : imagePaths) {
                cardImages.add("");
            }

            Collections.shuffle(imagePaths);
            Collections.shuffle(cardImages);

            JPanel cardPanel0 = new JPanel(new GridLayout(3, 4));
            cardButtons = new JButton[12];

            for (int i = 0; i < cardButtons.length; i++) {
                final int index = i;
                cardButtons[i] = new JButton();
                cardButtons[i].setIcon(new ImageIcon("silver.png"));
                cardButtons[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        handleCardClick(index);
                    }
                });
                cardPanel0.add(cardButtons[i]);
            }

            add(cardPanel0);

        } else if (fieldSize == 1) {
            imagePaths.add("blue.png");
            imagePaths.add("dark blue.png");
            imagePaths.add("green.png");
            imagePaths.add("orange.png");
            imagePaths.add("pink.png");
            imagePaths.add("purple.png");
            imagePaths.add("red.png");
            imagePaths.add("yellow.png");
            imagePaths.add("gray.png");
            imagePaths.add("light orange.png");
            imagePaths.add("light green.png");
            imagePaths.add("lavender.png");
            imagePaths.add("blue.png");
            imagePaths.add("dark blue.png");
            imagePaths.add("green.png");
            imagePaths.add("orange.png");
            imagePaths.add("pink.png");
            imagePaths.add("purple.png");
            imagePaths.add("red.png");
            imagePaths.add("yellow.png");
            imagePaths.add("gray.png");
            imagePaths.add("light orange.png");
            imagePaths.add("light green.png");
            imagePaths.add("lavender.png");

            for (String imagePath : imagePaths) {
                cardImages.add("");
            }

            Collections.shuffle(imagePaths);
            Collections.shuffle(cardImages);

            JPanel cardPanel1 = new JPanel(new GridLayout(4, 6));
            cardButtons = new JButton[24];

            for (int i = 0; i < cardButtons.length; i++) {
                final int index = i;
                cardButtons[i] = new JButton();
                cardButtons[i].setIcon(new ImageIcon("silver.png"));
                cardButtons[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        handleCardClick(index);
                    }
                });
                cardPanel1.add(cardButtons[i]);
            }

            add(cardPanel1);

        }

    }

    private void movesMade(ActionEvent e) {
        moves++;
    }

    private void handleCardClick(int index) {
        if (cardButtons[index].getIcon() == null) {
            return;
        }

        if (firstCardIndex == -1) {
            firstCardIndex = index;
            cardButtons[firstCardIndex].setIcon(new ImageIcon(imagePaths.get(index)));
        } else {
            secondCardIndex = index;
            cardButtons[secondCardIndex].setIcon(new ImageIcon(imagePaths.get(index)));

            Timer timer = new Timer(5000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (imagePaths.get(firstCardIndex).equals(imagePaths.get(secondCardIndex))) {
                        cardButtons[firstCardIndex].setIcon(null);
                        cardButtons[secondCardIndex].setIcon(null);
                        cardImages.set(firstCardIndex, null);
                        cardImages.set(secondCardIndex, null);
                        numberOfMatches++;
                        movesMade(e);

                        if ((fieldSize == 0 & numberOfMatches == 6) || (fieldSize == 1 && numberOfMatches == 12)) {
                            long gameEnd = System.currentTimeMillis();
                            long gameTime = gameEnd - gameStart;
                            double overallTime = gameTime / 1000.0;
                            JOptionPane.showMessageDialog(null, "Congrats! You completed the memory game!");
                            JOptionPane.showMessageDialog(null, "You made " + moves + " moves!\nTime elapsed: " + overallTime + " seconds.");
                            System.exit(0);
                        }
                    } else {
                        cardButtons[firstCardIndex].setIcon(new ImageIcon("silver.png"));
                        cardButtons[secondCardIndex].setIcon(new ImageIcon("silver.png"));
                        movesMade(e);
                    }
                    firstCardIndex = -1;
                }
            });
            timer.start();
            timer.setRepeats(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CardFlipper().setVisible(true);
            }
        });
    }
}
