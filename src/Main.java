import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main extends JFrame {
    private JTextPane questionTextPane;
    private JRadioButton[][] options;
    private JButton nextButton;
    private JButton answersButton;
    private ButtonGroup buttonGroup;
    private Questions questions;
    private int numOfQuestions;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private JPanel panel1;
    private List<String[]> randomQuestions;
    private Font font;

    public Main() {
        setTitle("Kviz znanja");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        questions = new Questions();
        questionTextPane = createQuestionTextPane();
        add(questionTextPane, BorderLayout.NORTH);

        panel1 = new JPanel();
        add(panel1, BorderLayout.WEST);

        JPanel optionsPanel = new JPanel(new GridLayout(2, 2));
        options = new JRadioButton[2][2];
        buttonGroup = new ButtonGroup();

        font = new Font("Century Gothic", Font.BOLD, 20);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                options[i][j] = new JRadioButton();
                optionsPanel.add(options[i][j]);
                buttonGroup.add(options[i][j]);
                options[i][j].setBorder(BorderFactory.createEmptyBorder(0,40,0,0));
            }
        }

        add(optionsPanel, BorderLayout.CENTER);

        displayMainBoard();
        answersButton = new JButton("Pokreni igru");
        answersButton.setFont(font);
        answersButton.setPreferredSize(new Dimension(200, 60));

        answersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numOfQuestions = getNumOfQuestions();
                randomQuestions = questions.getRandomQuestions(numOfQuestions);
                displayQuestion();
                remove(answersButton);
                add(nextButton, BorderLayout.SOUTH);
                revalidate();
                repaint();
            }
        });
        add(answersButton ,BorderLayout.SOUTH);


        nextButton = new JButton("Iduće pitanje");
        nextButton.setFont(new Font("Century Gothic", Font.BOLD, 20));
        nextButton.setPreferredSize(new Dimension(200, 60));
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isAnyRadioButtonSelected()) {
                    JOptionPane.showMessageDialog(Main.this, "Molimo odaberite odgovor.");
                    return;
                }

                checkAnswer();
                currentQuestionIndex++;
                if (currentQuestionIndex < randomQuestions.size()) {
                    displayQuestion();
                } else {
                    JOptionPane.showMessageDialog(Main.this, "Kraj kviza! Vaš rezultat:  " + score + " od " + randomQuestions.size());
                    System.exit(0);
                }
            }
        });

    }

    private JTextPane createQuestionTextPane() {
        JTextPane textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setContentType("text/html");
        return textPane;
    }

    private void displayMainBoard(){
        String mainText = "Dobrodošli u kviz.\nOdaberite broj pitanja.";
        questionTextPane.setText("<html><div style='font-family: Century Gothic; font-size: 25pt; font-weight: bold; text-align: center;'>" + mainText + "</div></html>");
        options[0][0].setText("10");
        options[0][0].setFont(font);
        options[0][1].setText("15");
        options[0][1].setFont(font);
        options[1][0].setText("20");
        options[1][0].setFont(font);
        options[1][1].setText("25");
        options[1][1].setFont(font);
    }

    private void displayQuestion() {
        String questionText = "Pitanje " + (currentQuestionIndex + 1) + "/" + randomQuestions.size() + ": " + randomQuestions.get(currentQuestionIndex)[0];
        questionTextPane.setText("<html><div style='font-family: Century Gothic; font-size: 25pt; font-weight: bold; text-align: center;'>" + questionText + "</div></html>");
        buttonGroup.clearSelection();
        String[] optionsCopy = Arrays.copyOfRange(randomQuestions.get(currentQuestionIndex), 1, randomQuestions.get(currentQuestionIndex).length);
        Collections.shuffle(Arrays.asList(optionsCopy));

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                options[i][j].setText(optionsCopy[i * 2 + j]);
                options[i][j].setFont(font);
            }
        }
    }

    private int getNumOfQuestions(){
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (options[i][j].isSelected()){
                    return numOfQuestions = Integer.parseInt((options[i][j].getText()));
                }
            }
        }
        return 15;
    }

    private void checkAnswer() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (options[i][j].isSelected() && options[i][j].getText().equals(randomQuestions.get(currentQuestionIndex)[1])) {
                    score++;
                    break;
                }
            }
        }
    }

    private boolean isAnyRadioButtonSelected() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (options[i][j].isSelected()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}