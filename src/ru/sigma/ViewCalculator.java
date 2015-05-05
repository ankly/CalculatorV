package ru.sigma;

/**
 * Created by Student08 on 05.05.2015.
 */

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;

    /**
     * Created by vladimir on 28.04.15.
     */
    public class ViewCalculator {
        private JLabel mainLabel;
        private JButton[] numB;
        private Model model;

        public ViewCalculator(Model model) {
            this.model = model;
        }

        public void buildGUI() {
            final JFrame mainFrame = new JFrame("Calculator");
            mainFrame.setBounds(20, 20, 400, 300);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            mainLabel = new JLabel("0");
            //Setting font
            mainLabel.setFont(new Font(mainLabel.getFont().getName(), Font.BOLD, 24));
            //Setting aligment
            mainLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            //Setting border
            mainLabel.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));

            JPanel numBPanel = new JPanel();
            numBPanel.setLayout(new GridLayout(4, 3, 4, 4));
            JPanel rightPanel = new JPanel();
            rightPanel.setLayout(new GridLayout(2, 1, 4, 4));
            JPanel arifmeticPanel = new JPanel();
            arifmeticPanel.setLayout(new GridLayout(2, 2, 4, 4));

            //Number buttons
            numB = new JButton[10];
            NumberButtonListener numBListener = new NumberButtonListener();
            for (int i = 0; i < numB.length; i++) {
                numB[i] = new JButton(Integer.toString(i));
                numB[i].addActionListener(numBListener);
            }

            //Dot button
            JButton dotB = new JButton(".");

            //Arifmetic buttons
            JButton addB = new JButton("+");
            JButton subB = new JButton("-");
            JButton mulB = new JButton("*");
            JButton divB = new JButton("/");

            //String to Char Array
            //String text = "Hello!";
            //char[] array = text.toCharArray();
            //char[0] == 'H'
            //char[1] == 'e'
            //text.charAt(0); //'H'

            addB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton b = (JButton) e.getSource();
                    model.action(mainLabel.getText(), b.getText());
                    mainLabel.setText("0");
                }
            });

            //Result button
            JButton resultB = new JButton("=");
            resultB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //mainLabel.setText(Double.toString(model.calculate(mainLabel.getText())));
                    double result = model.calculate(mainLabel.getText());
                    mainLabel.setText(Double.toString(result));
                }
            });

            //Adding number buttons to panel
            for (int i = 7; i < 10; i++) {
                numBPanel.add(numB[i]);
            }
            for (int i = 4; i < 7; i++) {
                numBPanel.add(numB[i]);
            }
            for (int i = 1; i < 4; i++) {
                numBPanel.add(numB[i]);
            }
            numBPanel.add(dotB);
            numBPanel.add(numB[0]);

            //Adding components to right panel
            arifmeticPanel.add(addB);
            arifmeticPanel.add(subB);
            arifmeticPanel.add(mulB);
            arifmeticPanel.add(divB);
            rightPanel.add(arifmeticPanel);
            rightPanel.add(resultB);

            mainFrame.add(BorderLayout.EAST, rightPanel);
            mainFrame.add(BorderLayout.CENTER, numBPanel);
            mainFrame.add(BorderLayout.NORTH, mainLabel);

            mainFrame.setVisible(true);
        }

        private class NumberButtonListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                mainLabel.setText(mainLabel.getText() + button.getText());
            }
        }

    /*
    1) Убрать 0
    2) Выделить общий обработчик событий для арифметически операций
    3) Избавиться от анонимных классов
    4) Сделать обработчик для кнопки .
    5) На левой панели (доп. действий) кнопки C , <-
    6) Обработка всех ошибок (тестируем по-максимуму)
    7) Накапливание результата
     */
    }

