import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;
import java.util.List;

public class Jogo {

    public static void main(String[] args) {
        new Jogo().telaInicial();
    }

    public void telaInicial() {
        JFrame frame = new JFrame("Tela Inicial");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,300);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel painelHome = new JPanel();
        painelHome.setLayout(new GridLayout(5,2));
        painelHome.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        JLabel nomeLabel = new JLabel("Digite seu nome");
        JTextField nomeField = new JTextField();

        JLabel apostaLabel = new JLabel("Quantidade que deseja Apostar: R$");
        JTextField apostaField = new JTextField();

        JLabel multiplicadorLabel = new JLabel("Quantidade de Bombas (1 à 5): ");
        JTextField multiplicadorField = new JTextField();

        JButton iniciarButton = new JButton("Jogar");

        painelHome.add(nomeLabel);
        painelHome.add(nomeField);
        painelHome.add(apostaLabel);
        painelHome.add(apostaField);
        painelHome.add(multiplicadorLabel);
        painelHome.add(multiplicadorField);
        painelHome.add(new JLabel()); //espaço
        painelHome.add(iniciarButton);

        frame.add(painelHome, BorderLayout.CENTER);

        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                double aposta = Double.parseDouble(apostaField.getText());
                int multiplicador = Integer.parseInt(multiplicadorField.getText());

                new Jogo().telaJogo(nome, aposta, multiplicador);

                frame.dispose();
            }
        });
        frame.setVisible(true);
    }

    public void telaJogo(String nome, double aposta, int multiplicador) {
        JFrame frame = new JFrame("Jogo Diamond");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,700);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        frame.setLayout(new BorderLayout(20,20));

        JPanel painelJogo = new JPanel();
        painelJogo.setLayout(new GridLayout(3,5));
        painelJogo.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        JPanel painelBotao = new JPanel();
        painelBotao.setLayout(new GridLayout(5,5));
        painelBotao.setBorder(BorderFactory.createEmptyBorder(20,20,0,20));

        JButton[] botoes = new JButton[25];

        String imagemDiamante =
                "C:\\Users\\Leonardo\\Documents\\Projetos\\Exercicios Java Fixação\\Jogo Cassino JFrame\\src\\assets\\Diamante.png";

        String imagemBomba =
                "C:\\Users\\Leonardo\\Documents\\Projetos\\Exercicios Java Fixação\\Jogo Cassino JFrame\\src\\assets\\Bomba.png";

        String imagemLogo =
                "C:\\Users\\Leonardo\\Documents\\Projetos\\Exercicios Java Fixação\\Jogo Cassino JFrame\\src\\assets\\LogoLeoBet.png";

        ImageIcon iconeDiamante = new ImageIcon(imagemDiamante);
        ImageIcon iconeBomba = new ImageIcon(imagemBomba);
        ImageIcon iconeLogo = new ImageIcon(imagemLogo);

        for (int i=0; i < 25; i++) {
            JButton botao = new JButton();
            botao.setPreferredSize(new Dimension(110,110));
            botoes[i] = botao;
            botoes[i].setIcon(iconeLogo);
            painelBotao.add(botao);
        }

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        JLabel nomeLabel = new JLabel("Nome do Jogador: " + nome + " | Aposta: " + currencyFormat.format(aposta), SwingConstants.CENTER);

        JPanel nomePainel = new JPanel(new BorderLayout());
        nomePainel.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));
        nomePainel.add(nomeLabel, BorderLayout.CENTER);

        JButton botaoSacar = new JButton("Sacar Dinheiro");

        JPanel painelBotaoSacar = new JPanel(new BorderLayout());
        painelBotaoSacar.setBorder(BorderFactory.createEmptyBorder(0,200,0,200));

        painelBotaoSacar.add(botaoSacar);


        frame.add(painelBotao, BorderLayout.CENTER);
        painelJogo.add(nomePainel);
        painelJogo.add(painelBotaoSacar);
        frame.add(painelJogo, BorderLayout.SOUTH);

        Random random = new Random();
        List<Integer> bomba = new ArrayList<>(Collections.nCopies(5,30));
        List<Integer> botoesClicados = new ArrayList<>();

        for (int j=0; j < multiplicador; j++) {
            bomba.set(j, random.nextInt(25));
        }

        final double[] apostaAtual = {aposta};

        botaoSacar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Jogo().telaGanho(apostaAtual);

                frame.dispose();
            }
        });

        for (int k=0; k < 25; k++) {
            final int numero = k;
            botoes[numero].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (
                            numero == bomba.get(0) ||
                                    numero == bomba.get(1) ||
                                    numero == bomba.get(2) ||
                                    numero == bomba.get(3) ||
                                    numero == bomba.get(4)
                    ) {
                        botoes[numero].setIcon(iconeBomba);

                        new Jogo().telaPerca(aposta);

                        frame.dispose();
                    } else {
                        botoes[numero].setIcon(iconeDiamante);
                        botoesClicados.add(1);

                        if (botoesClicados.size() == 3) {
                            switch (multiplicador) {
                                case 1:
                                    apostaAtual[0] *= 1.25;
                                    botoesClicados.clear();
                                    break;
                                case 2:
                                    apostaAtual[0] *= 2;
                                    botoesClicados.clear();
                                    break;
                                case 3:
                                    apostaAtual[0] *= 3;
                                    botoesClicados.clear();
                                    break;
                                case 4:
                                    apostaAtual[0] *= 4;
                                    botoesClicados.clear();
                                    break;
                                case 5:
                                    apostaAtual[0] *= 5;
                                    botoesClicados.clear();
                                    break;
                            }
                            nomeLabel.setText("Nome do Jogador: " + nome + " | Aposta: " + currencyFormat.format(apostaAtual[0]));
                        }
                        //Atualiza as informações do Jogador.
                        frame.revalidate();
                        frame.repaint();
                    }
                }
            });
        }
        frame.setVisible(true);
    }

    public void telaPerca(double aposta) {
        JFrame frame = new JFrame("Você perdeu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,300);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel painelPerca = new JPanel();
        painelPerca.setLayout(new GridLayout(3,2));
        painelPerca.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        JLabel texto1 = new JLabel("Que pena! Você perdeu XD", SwingConstants.CENTER);
        JLabel texto2 = new JLabel("Obrigado pelo seu dinheiro! " + currencyFormat.format(aposta), SwingConstants.CENTER);
        JButton botao = new JButton("JOGUE NOVAMENTE");

        painelPerca.add(texto1);
        painelPerca.add(texto2);
        painelPerca.add(botao);
        frame.add(painelPerca);

        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Jogo().telaInicial();

                frame.dispose();
            }
        });
        frame.setVisible(true);
    }

    public void telaGanho(double[] apostaAtual) {
        JFrame frame = new JFrame("Você Ganhou XC");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,300);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel painelGanho = new JPanel();
        painelGanho.setLayout(new GridLayout(3,2));
        painelGanho.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        JLabel texto1 = new JLabel("Eba :C, você ganhou.", SwingConstants.CENTER);
        JLabel texto2 = new JLabel("Você retirou seu dinheiro: " + currencyFormat.format(apostaAtual[0]), SwingConstants.CENTER);
        JButton botao = new JButton("GANHE MAIS DINHEIRO");

        painelGanho.add(texto1);
        painelGanho.add(texto2);
        painelGanho.add(botao);
        frame.add(painelGanho);

        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Jogo().telaInicial();

                frame.dispose();
            }
        });
        frame.setVisible(true);
    }
}