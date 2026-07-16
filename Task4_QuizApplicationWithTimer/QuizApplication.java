import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizApplication extends JFrame implements ActionListener {

    private Question[] questions;
    private JLabel questionLabel, timerLabel;
    private JRadioButton[] options;
    private ButtonGroup group;
    private JButton nextButton;

    private int currentQuestion = 0;
    private int score = 0;
    private int timeLeft = 10;

    private Timer timer;

    public QuizApplication() {

        setTitle("Quiz Application");
        setSize(600, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        timerLabel = new JLabel("Time Left: 10 sec", SwingConstants.CENTER);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 18));

        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        questionLabel.setHorizontalAlignment(SwingConstants.LEFT);
        
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4, 1, 10, 15));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(5, 30, 10, 30));

        options = new JRadioButton[4];
        group = new ButtonGroup();

        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            options[i].setFont(new Font("Arial", Font.PLAIN, 16));
            group.add(options[i]);
            centerPanel.add(options[i]);
        }

        nextButton = new JButton("Next");
        nextButton.addActionListener(this);

        JPanel topPanel = new JPanel(new BorderLayout());

        topPanel.setBorder(
            BorderFactory.createEmptyBorder(10,20,10,20)
        );

        topPanel.add(timerLabel, BorderLayout.NORTH);
        topPanel.add(questionLabel, BorderLayout.WEST);

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(nextButton, BorderLayout.SOUTH);

        loadQuestions();
        displayQuestion();

        setVisible(true);
    }

    private void loadQuestions() {
        
        questions = new Question[] {

            new Question(
                "Which language is used for Android Development?",
                new String[]{"Python", "Java", "C++", "PHP"},
                1
            ),

            new Question(
                "Which company developed Java?",
                new String[]{"Microsoft", "Google", "Oracle", "Apple"},
                2
            ),

            new Question(
                "Size of int in Java?",
                new String[]{"2 Bytes", "4 Bytes", "8 Bytes", "16 Bytes"},
                1
            ),

            new Question(
                "Keyword used for inheritance?",
                new String[]{"this", "super", "extends", "implements"},
                2
            ),

            new Question(
                "Scanner class belongs to?",
                new String[]{"java.util", "java.io", "java.net", "java.awt"},
                0
            )
        };
    }

    private void displayQuestion() {

        if (currentQuestion >= questions.length) {
            showResult();
            return;
        }

        group.clearSelection();

        Question q = questions[currentQuestion];

        questionLabel.setText((currentQuestion + 1) + ". " + q.getQuestion());

        String[] option = q.getOptions();

        for (int i = 0; i < 4; i++) {
            options[i].setText(option[i]);
        }

        startTimer();
    }

    private void startTimer() {

        if (timer != null) {
            timer.stop();
        }

        timeLeft = 10;
        timerLabel.setText("Time Left: " + timeLeft + " sec");

        timer = new Timer(1000, e -> {

            timeLeft--;
            timerLabel.setText("Time Left: " + timeLeft + " sec");

            if (timeLeft == 0) {
                timer.stop();
                checkAnswer();
                currentQuestion++;
                displayQuestion();
            }
        });

        timer.start();
    }

    private void checkAnswer() {

        Question q = questions[currentQuestion];

        for (int i = 0; i < 4; i++) {

            if (options[i].isSelected()) {

                if (i == q.getCorrectAnswer()) {
                    score++;
                }

                break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        timer.stop();

        checkAnswer();

        currentQuestion++;

        displayQuestion();
    }

    private void showResult() {

        JOptionPane.showMessageDialog(
                this,
                "Quiz Completed!\n\nYour Score: "
                        + score + " / " + questions.length);

        System.exit(0);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new QuizApplication());

    }

}