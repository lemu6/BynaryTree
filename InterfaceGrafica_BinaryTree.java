package ArvoreBST;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceGrafica_BinaryTree extends JFrame implements ActionListener {
    private JPanel painelPrincipal;
    private JButton botaoInserir;
    private JTextField nomeInserir;
    private JButton travessiaPreOrdem;
    private JButton travessiaPosOrdem;
    private JButton travessiaEmOrdem;
    private JButton travessiaLevelOrder;
    private JButton tamanhoArvore;
    private JButton alturaArvore;
    private JButton menorElemento;
    private JButton maiorElemento;
    private JTextField resultado;

    public InterfaceGrafica_BinaryTree() {
        BinaryTree bt = new BinaryTree();

        JFrame frame = new JFrame("Arvore Binaria");
        JPanel panel = new JPanel();

        JPanel insertionPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        buttonPanel.setPreferredSize(new Dimension(450, 115));

        frame.add(insertionPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setLayout(new FlowLayout());
        frame.setPreferredSize(new Dimension(700, 275));
        //frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);

        botaoInserir = new JButton("Inserir");
        travessiaEmOrdem = new JButton("Em Ordem");
        travessiaPreOrdem = new JButton("Pré Ordem");
        travessiaPosOrdem = new JButton("Pós Ordem");
        travessiaLevelOrder = new JButton("Level Order");
        tamanhoArvore = new JButton("Tamanho da Árvore");
        alturaArvore = new JButton("Altura da Árvore");
        menorElemento = new JButton("Menor Elemento");
        maiorElemento = new JButton("Maior Elemento");
        resultado = new JTextField();

        JLabel label = new JLabel("Nome");
        JTextField nome = new JTextField();
        nome.setPreferredSize(new Dimension(120, 40));
        nome.setVisible(true);
        resultado.setVisible(false);

        JLabel label2 = new JLabel();

        botaoInserir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nome.getText().equals(""))
                    return;

                label2.setVisible(false);
                resultado.setText("");
                resultado.setVisible(false);
                bt.addElemento(nome.getText());
                JOptionPane.showMessageDialog(null, "Nome inserido:   " + nome.getText());
                nome.setText("");
            }
        });

        travessiaPosOrdem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bt.travessiaPosOrdem(bt.getRoot());
                label2.setText("Travessia Pos Ordem ");
                label2.setVisible(true);
                resultado.setText(bt.getResultadoTravessia());
                resultado.setVisible(true);
                bt.setResultadoTravessia("");
            }
        });

        travessiaEmOrdem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bt.travessiaEmOrdem(bt.getRoot());             
                label2.setText("Travessia Em Ordem ");
                label2.setVisible(true);
                resultado.setText(bt.getResultadoTravessia());
                resultado.setVisible(true);
                bt.setResultadoTravessia("");
            }
        });

        travessiaPreOrdem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bt.travessiaPreOrdem(bt.getRoot());
                label2.setText("Travessia Pre Ordem ");
                label2.setVisible(true);
                resultado.setText(bt.getResultadoTravessia());
                resultado.setVisible(true);
                bt.setResultadoTravessia("");
            }
        });

        travessiaLevelOrder.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		bt.travessiaLevelOrder(bt.getRoot());
        		label2.setText("Travessia Level Order");
        		label2.setVisible(true);
        		resultado.setText(bt.getResultadoTravessia());
        		resultado.setVisible(true);
        		bt.setResultadoTravessia("");  		
        	}
        });

        maiorElemento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String elemento = bt.maiorElemento(bt.getRoot());
                JOptionPane.showMessageDialog(null, "Maior elemento da Árvore:   " + elemento);
                label2.setText("Maior Elemento ");
                label2.setVisible(true);
                resultado.setText(elemento);
                resultado.setVisible(true);
            }
        });

        menorElemento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String elemento = bt.menorElemento(bt.getRoot());
                JOptionPane.showMessageDialog(null, "Menor elemento da Árvore:   " + elemento);
                label2.setText("Menor Elemento ");
                label2.setVisible(true);
                resultado.setText(elemento);
                resultado.setVisible(true);
            }
        });

        tamanhoArvore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tamanho = bt.getTamanho();
                JOptionPane.showMessageDialog(null, "Quantidade de Elementos na Árvore:   " + tamanho);
                label2.setText("Tamanho da Arvore ");
                label2.setVisible(true);
                resultado.setText("" + tamanho);
                resultado.setVisible(true);
            }
        });

        alturaArvore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int altura = bt.calculaAltura(bt.getRoot());
                JOptionPane.showMessageDialog(null, "Altura da Árvore:   " + altura);
                label2.setText("Altura da Arvore");
                label2.setVisible(true);
                resultado.setText("" + altura);
                resultado.setVisible(true);
            }
        });

        resultado.setPreferredSize(new Dimension(450, 30));

        insertionPanel.add(label);
        insertionPanel.add(nome);
        insertionPanel.add(botaoInserir);


        buttonPanel.add(travessiaEmOrdem);
        buttonPanel.add(travessiaPreOrdem);
        buttonPanel.add(travessiaPosOrdem);
        buttonPanel.add(travessiaLevelOrder);
        buttonPanel.add(tamanhoArvore);
        buttonPanel.add(alturaArvore);
        buttonPanel.add(menorElemento);
        buttonPanel.add(maiorElemento);

        panel.add(label2);
        panel.add(resultado);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == travessiaEmOrdem) {

        }
    }
}
