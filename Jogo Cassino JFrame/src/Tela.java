import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;

public class Tela {

    public static void main(String[] args) {
        new Tela().telaInicial();
    }

    public void telaInicial() {
        JFrame frame = new JFrame("Tela Inicial");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        frame.setLayout(new GridLayout(5, 2, 10, 10)); // 5 linhas, 2 colunas com espaçamento

        JLabel nomeLabel = new JLabel("Digite seu nome:");
        JTextField nomeField = new JTextField();

        JLabel apostaLabel = new JLabel("Quantidade a apostar:");
        JTextField apostaField = new JTextField();

        JLabel multipicadorLabel = new JLabel("Multiplicador (1 a 5):");
        JTextField multiplicadorField = new JTextField();

        JButton iniciarButton = new JButton("Iniciar");

        frame.add(nomeLabel);
        frame.add(nomeField);
        frame.add(apostaLabel);
        frame.add(apostaField);
        frame.add(multipicadorLabel);
        frame.add(multiplicadorField);
        frame.add(new JLabel());
        frame.add(iniciarButton);

        iniciarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                double aposta = Double.parseDouble(apostaField.getText());
                int multiplicador = Integer.parseInt(multiplicadorField.getText());

                // Cria uma nova instância da classe TelaJogo
                new Tela().telaJogo(nome, aposta, multiplicador);

                // Fecha a tela inicial (opcional)
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }

    public void telaJogo(String nome, double aposta, int multiplicador) {
        JFrame frame = new JFrame("Campo Minado");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        frame.setLayout(new BorderLayout(20, 20));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton[] buttons = new JButton[25];

        String imageDiamante = "C:\\Users\\Leonardo\\Desktop\\CampoMinado\\src\\assets\\diamante.png";
        String imageBomba = "C:\\Users\\Leonardo\\Desktop\\CampoMinado\\src\\assets\\bomba.png";
        String imageLogo = "C:\\Users\\Leonardo\\Desktop\\CampoMinado\\src\\assets\\LogoLeoBet.png";

        ImageIcon iconeDiamante = new ImageIcon(imageDiamante);
        ImageIcon iconeBomba = new ImageIcon(imageBomba);
        ImageIcon iconeLogo = new ImageIcon(imageLogo);

        // Formato de moeda brasileira
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        // Label para mostrar o nome e a aposta atualizada
        JLabel nomeLabel = new JLabel("Nome do Jogador: " + nome + " | Aposta: " + currencyFormat.format(aposta), SwingConstants.CENTER);

        for (int i = 0; i < 25; i++) {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(130, 130));
            buttons[i] = button;
            button.setIcon(iconeLogo);
            button.setBackground(new Color(173, 216, 230));
            buttonPanel.add(button);
        }


        JPanel nomePanel = new JPanel(new BorderLayout());
        nomePanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0)); // Adiciona espaçamento superior e inferior
        nomePanel.add(nomeLabel, BorderLayout.CENTER);

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(nomePanel, BorderLayout.SOUTH);

        Random random = new Random();
        int bomba1 = random.nextInt(25);
        int bomba2;
        do {
            bomba2 = random.nextInt(25);
        } while (bomba2 == bomba1);

        int bomba3;
        do {
            bomba3 = random.nextInt(25);
        } while (bomba3 == bomba1 || bomba3 == bomba2);

        final double[] apostaAtual = {aposta};

        for (int i = 0; i < 25; i++) {
            final int numero = i;
            int finalBomba2 = bomba2;
            int finalBomba3 = bomba3;
            buttons[i].addActionListener(new ActionListener() {
                int contador = 0;
                public void actionPerformed(ActionEvent e) {
                    if (numero == bomba1 || numero == finalBomba2 || numero == finalBomba3) {
                        buttons[numero].setIcon(iconeBomba);
                        JOptionPane.showMessageDialog(frame, "Você acertou uma bomba! Aposta perdida.");
                    } else {
                        buttons[numero].setIcon(iconeDiamante);

                        contador++;

                        if (numero % 4 == 0) {
                            if (multiplicador == 1) {
                                apostaAtual[0] *= 1.5;
                                nomeLabel.setText("Nome do Jogador: " + nome + " | Aposta: " + currencyFormat.format(apostaAtual[0]));
                                contador = 0;
                            } else if (multiplicador == 2) {
                                apostaAtual[0] *= 2;
                                nomeLabel.setText("Nome do Jogador: " + nome + " | Aposta: " + currencyFormat.format(apostaAtual[0]));
                                contador = 0;
                            } else if (multiplicador == 3) {
                                apostaAtual[0] *= 3;
                                nomeLabel.setText("Nome do Jogador: " + nome + " | Aposta: " + currencyFormat.format(apostaAtual[0]));
                                contador = 0;
                            }
                        }

                        // Atualiza a interface
                        frame.revalidate();
                        frame.repaint();
                    }
                    buttons[numero].setBackground(new Color(0, 102, 204));
                }
            });
        }
        frame.setVisible(true);
    }
}
