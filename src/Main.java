import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main extends JFrame {
    private JTextPane questionTextPane;
    private JRadioButton[] options;
    private JButton nextButton;
    private ButtonGroup buttonGroup;

    private String[][] questions = {
            {"Koji je glavni grad Austrije?", "Beč", "London", "Berlin", "Madrid"},
            {"Kada je završio drugi Svjetski rat?", "1945.", "1946.", "1944.", "1939."},
            {"Kako se zove poznati film baziran na knjizi Stephena Kinga u kojem je glumio Jack Nicholson?", "Isijavanje", "Vještice iz Salema", "Egzorcist", "1922"},
            {"Kako se zove grčka božica lova?", "Artemida", "Hera", "Afrodita", "Atena" },
            {"Koji kemijski element na latinskom predstavlja sunce?", "Helij", "Dušik", "Ugljik", "Platina"},
            {"Kako se zove poznata pjevačica koja glumi u filmu sa Bradley Cooper-om?", "Lady Gaga", "Beyonce", "Rihanna", "Shakira"},
            {"Koliko čovječuljaka ima svaki igrač na početku igre imena Čovječe ne ljuti se?", "4", "3", "5", "6"},
            {"Koja je službena valuta u Hrvatskoj?", "Euro", "Kuna", "Funta", "Dolar"},
            {"Kako se zove najpoznatiji portugalski nogometaš koji je igrao u Real Madridu?", "Cristiano Ronaldo", "Lionel Messi", "Neymar", "Paul Pogba"},
            {"Koja od slijedećih glumica nosi jednu od glavnih uloga u Marvelovom filmu 'Avengers'?", "Scarlet Johansson", "Jessica Alba", "Kate Hudson", "Anna Faris"},
            {"Koja biljka se nalazi na zastavi Kanade?", "Javor", "Peršin", "Jasen", "Ruža"},
            {"Kako se nazivaju ćelije zaslužne za razvoj kostiju?", "Osteoblasti", "Lizosomi", "Citoplazme", "Trombociti"},
            {"Mn je simbol kojeg kemijskog elementa?", "Mangana", "Magnezija", "Mendelevija", "Mitohondrija"},
            {"Koje je boje klorofil?", "Zelene", "Žute", "Crvene", "Plave"},
            {"Koji je glavni grad Japana?", "Tokio", "Kyoto", "Osaka", "Sapporo"},
            {"Gdje se nalazi Eiffelov toranj?", "Pariz", "London", "Berlin", "New York"}
    };

    private int currentQuestionIndex = 0;
    private int score = 0;

    private JPanel panel1;

    public Main() {
        setTitle("Kviz znanja");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        questionTextPane = createQuestionTextPane();
        add(questionTextPane, BorderLayout.NORTH);

        panel1 = new JPanel();
        add(panel1, BorderLayout.WEST);

        JPanel optionsPanel = new JPanel(new GridLayout(4, 1));
        options = new JRadioButton[4];
        buttonGroup = new ButtonGroup();

        for (int i = 0; i < options.length; i++) {
            options[i] = new JRadioButton();
            optionsPanel.add(options[i]);
            buttonGroup.add(options[i]);
        }

        add(optionsPanel, BorderLayout.CENTER);

        nextButton = new JButton("Iduće pitanje");
        nextButton.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        nextButton.setPreferredSize(new Dimension(200, 60));
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
                currentQuestionIndex++;
                if (currentQuestionIndex < questions.length) {
                    displayQuestion();
                } else {
                    JOptionPane.showMessageDialog(Main.this, "Kraj kviza! Vaš rezultat:  " + score + " od " + questions.length);
                    System.exit(0);
                }
            }
        });
        add(nextButton, BorderLayout.SOUTH);


        List<String[]> questionsList = Arrays.asList(questions);
        Collections.shuffle(questionsList);
        questionsList = questionsList.subList(0, 7);
        questions = questionsList.toArray(new String[0][]);

        displayQuestion();
    }

    private JTextPane createQuestionTextPane() {
        JTextPane textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setContentType("text/html");
        return textPane;
    }

    private void displayQuestion() {
        String questionText = "Pitanje " + (currentQuestionIndex + 1) + "/" + questions.length + ": " + questions[currentQuestionIndex][0];
        questionTextPane.setText("<html><div style='font-family: Century Gothic; font-size: 25pt; font-weight: bold; text-align: center;'>" + questionText + "</div></html>");
        buttonGroup.clearSelection();
        String[] optionsCopy = Arrays.copyOfRange(questions[currentQuestionIndex], 1, questions[currentQuestionIndex].length);
        Collections.shuffle(Arrays.asList(optionsCopy));

        for (int i = 0; i < options.length; i++) {
            options[i].setText(optionsCopy[i]);
            options[i].setFont(new Font("Century Gothic", Font.PLAIN, 20));
        }
    }

    private void checkAnswer() {
        for (int i = 0; i < options.length; i++) {
            if (options[i].isSelected() && options[i].getText().equals(questions[currentQuestionIndex][1])) {
                score++;
                break;
            }
        }
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