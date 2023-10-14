import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonListener;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlipperSize extends JFrame{
    public FlipperSize sizeFields;

    public FlipperSize() {
        setTitle("Picture Memory Game");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel sizeField = new JPanel();
        sizeField.setLayout(new GridLayout(1, 2));

        String[] sizeFields = {
                "16", "24"
        };

        for (String field : sizeFields) {
            JButton button = new JButton(field);
            button.addActionListener(new ButtonListener());
            sizeField.add(button);
        }
        add(sizeField, BorderLayout.CENTER);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {


        }
    }

}

