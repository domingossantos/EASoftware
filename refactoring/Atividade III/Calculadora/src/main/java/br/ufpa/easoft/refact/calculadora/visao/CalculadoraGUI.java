package br.ufpa.easoft.refact.calculadora.visao;

/*
 * Pequeno projeto que simula uma calculadora com interface gr�fica.
 E necessario implementar outras funcoes, como segunda memoria, 
 impressao de rolinho papel, e ainda som de teclas ou impressao
 CREDITOS: Edilberto R Vieira
 Em: http://javafree.uol.com.br/artigo/853469/Calculadora-de-Mesa.html
 */
import br.ufpa.easoft.refact.calculadora.controle.CalculadoraControle;
import br.ufpa.easoft.refact.calculadora.util.FuncoesUtil;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class CalculadoraGUI extends JFrame implements KeyListener {

    // variaveis de objetos como botoes, caixa texto, etc...
    private JButton botao1, botao2, botao3, botao4, botao5, botao6, botao7,
            botao8, botao9, botao0, botaoC, botaoCE, botaoDiv, botaoMultip,
            botaoMenos, botaoMais, botaoVirgula, botaoTotal, botaoPerc,
            botaoBackspace;
    private JTextArea roloPapel;
    private JLabel visor, keyCodigo;
    private JScrollPane scroll;

    // variaveis de inicialização do GridBagLayout
    private Container container;
    private GridBagLayout layout;
    private GridBagConstraints constraints;
    private JRadioButton botao2dig, botao4dig, botao6dig;
    private ButtonGroup botaoDecimais;

    private CalculadoraControle calc = new CalculadoraControle();

    // Classe de tratamento e eventos de Acao ==========================
    private class trataEventosAcao implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == botaoC) {
                teclouC();
            } else if (event.getSource() == botaoCE) {
                teclouCE();
            } else if (event.getSource() == botaoPerc) {
                teclouPercentual();
            } else if (event.getSource() == botaoVirgula) {
                teclouVirgula();
            } else if (event.getSource() == botaoBackspace) {
                teclouBackspace();
            } else if (event.getSource() == botao1) {
                teclouNumeros("1");
            } else if (event.getSource() == botao2) {
                teclouNumeros("2");
            } else if (event.getSource() == botao3) {
                teclouNumeros("3");
            } else if (event.getSource() == botao4) {
                teclouNumeros("4");
            } else if (event.getSource() == botao5) {
                teclouNumeros("5");
            } else if (event.getSource() == botao6) {
                teclouNumeros("6");
            } else if (event.getSource() == botao7) {
                teclouNumeros("7");
            } else if (event.getSource() == botao8) {
                teclouNumeros("8");
            } else if (event.getSource() == botao9) {
                teclouNumeros("9");
            } else if (event.getSource() == botao0) {
                teclouNumeros("0");
            } else if (event.getSource() == botaoMais) {
                teclouMais();
            } else if (event.getSource() == botaoMenos) {
                teclouMenos();
            } else if (event.getSource() == botaoDiv) {
                teclouDiv();
            } else if (event.getSource() == botaoMultip) {
                teclouMultip();
            } else if (event.getSource() == botaoTotal) {
                teclouEnter();
            }
        }
    }

    // Classe de tratamento de eventos Focus (nenhum componente vai recebe o
    // foco alem do visor,
    // mas deixo o codigo abaixo pra efeito didatico
    private class trataEventosFocus implements FocusListener {

        // == qdo os campos texto ganham focus
        public void focusGained(FocusEvent event) {// =============
        }

        // == qdo os campos texto perdem o focus
        public void focusLost(FocusEvent event) { // =============
        }
    }

    // Classe de tratamento de eventos Focus (nenhum componente vai recebe o
    // foco alem do visor,
    // mas deixo o codigo abaixo pra efeito didatico
    private class trataEventosRadio implements ItemListener {

        // == qdo os campos texto ganham focus
        public void itemStateChanged(ItemEvent event) {
            if (event.getSource() == botao2dig) {
                // Mudou pra dois digitos decimais
                calc.setCasasDecimais(2);
            }
            if (event.getSource() == botao4dig) {
                // Mudou pra quatro digitos decimais
                calc.setCasasDecimais(4);
            }
            if (event.getSource() == botao6dig) {
                // Mudou pra seis digitos decimais
                calc.setCasasDecimais(6);
            }
        }
    }

    // Tratamento de eventos de teclado
    public void keyPressed(KeyEvent e) {
        // VK_ESCAPE � uma constante est�tica. Tanto faz usar e ou KeyEvent
        if (e.getKeyCode() == e.VK_ESCAPE) {
            // passando this e nao null, mensagem aparece centro da janela
            int selectedOption = JOptionPane.showConfirmDialog(this,
                    "Deseja Sair Realmente?", "Atenção",
                    JOptionPane.YES_NO_OPTION);
            if (selectedOption == JOptionPane.YES_OPTION) {
                dispose();
                System.exit(0);
            }
        }
        if (e.getKeyCode() == 67) {
            teclouC();
        }
        if (e.getKeyCode() == 69) {
            teclouCE();
        }
        if (e.getKeyCode() == 8) {
            teclouBackspace();
        }
        if (e.getKeyCode() == 110) {
            teclouVirgula();
        }
        if (((e.getKeyCode() >= e.VK_0) && (e.getKeyCode() <= e.VK_9))
                || ((e.getKeyCode() >= e.VK_NUMPAD0) && (e.getKeyCode() <= e.VK_NUMPAD9))) {
            teclouNumeros("" + e.getKeyChar());
        }
        if ((e.getKeyCode() == 61) || (e.getKeyCode() == 107)) {
            teclouMais();
        }
        if ((e.getKeyCode() == 45) || (e.getKeyCode() == 109)) {
            teclouMenos();
        }
        if ((e.getKeyCode() == 59) || (e.getKeyCode() == 111)) {
            teclouDiv();
        }
        if (e.getKeyCode() == 106) {
            teclouMultip();
        }
        if (e.getKeyCode() == 80) {
            teclouPercentual();
        }
        if (e.getKeyCode() == 10) {
            teclouEnter();
        }
    }

    public void keyReleased(KeyEvent e) {
        // visor.setText("Tecla liberada");
    }

    public void keyTyped(KeyEvent e) {
        // visor.setText(""+e.getKeyCode());
    }

    // Funcoes logo abaixo sao usadas nos eventos de botoes e teclado
    // Teclou "C" limpa so valor digitado
    public void teclouC() {
        calc.clean();

        visor.setText(FuncoesUtil.formatStrNumerica(calc.getValor(), calc.getCasasDecimais()));
    }

    // Teclou "E" limpa tudo
    public void teclouCE() {
        calc.cleanAndEraser();

        atualizaVisor();
        imprime("\n\n\n\n", true);
        imprime("\n\n\n\n", true);
        imprime("\n\n\n\n", true);
    }

    // Percentagem teclou "P" calcula o percentual
    public void teclouPercentual() {
        imprime(calc.obterValorFormatado()+" %", true);
        if ("*".equals(calc.getOperador())) {
            calc.percentualMult();
            imprimeResultado();
        } else if ("/".equals(calc.getOperador())) {
            calc.percentualDiv();
            imprimeResultado();
        }
        atualizaVisor();
        calc.setValorAnterior("" + calc.getResultado());
        calc.cleanAndEraser();
    }

    // Teclou "," Virgula decimal
    public void teclouVirgula() {
        if (calc.getValor().lastIndexOf(".") == -1) {
            calc.setValor(calc.getValor() + ".");
        }
        visor.setText(calc.getValor());
    }

    // Teclou Backspace remove ultimo carctere do valor
    public void teclouBackspace() {
        if (calc.getValor().length() == 1) {
            calc.setValor("0");
        } else {
            calc.setValor(calc.getValor().substring(0, calc.getValor().length() - 1));
        }
        visor.setText(calc.getValor());
    }

    // Pega somente os Numeros digitados
    public void teclouNumeros(String s) {
        if (calc.getValor().length() <= 14) {
            if ("0".equals(calc.getValor())) {
                calc.setValor("");
            } else {
                calc.setValor(calc.getValor() + s);
            }

            visor.setText(calc.getValor());
        }
    }
    
    private void imprime(String valor, boolean quebraLinha) {
        roloPapel.append(FuncoesUtil.alinhaStringDir(valor));
        if (quebraLinha)
            roloPapel.append("\n");
    }

    private void imprimePapel() {
        imprime(calc.obterValorFormatado()+" "+calc.getOperador(), true);
    }

    private void atualizaVisor() {
        visor.setText(calc.obterResultadoFormatado());
    }

    // Adicao teclou "+"
    public void teclouMais() {
        if ("".equals(calc.getValor())) {
            calc.setValor(calc.getValorAnterior());
        }

        calc.setOperador("+");
        calc.soma();
        imprimePapel();

        atualizaVisor();
        calc.setValorAnterior(calc.getValor());
        calc.clean();
    }

    // Subtracao teclou "-"
    public void teclouMenos() {
        if ("".equals(calc.getValor())) {
            calc.setValor(calc.getValorAnterior());
        }

        calc.setOperador("-");
        calc.subtracao();
        imprimePapel();

        atualizaVisor();
        calc.setValorAnterior(calc.getValor());
        calc.clean();
    }

    // Divisao teclou "/" ou ":"
    public void teclouDiv() {
        if ("".equals(calc.getValor())) {
            calc.setValor(calc.getValorAnterior());
        }

        calc.setOperador("/");
        calc.setResultado(Double.parseDouble(calc.getValor()));
        imprimePapel();

        atualizaVisor();
        calc.clean();
    }

    // Multiplicacao teclou "*"
    public void teclouMultip() {
        if ("".equals(calc.getValor())) {
            calc.setValor(calc.getValorAnterior());
        }

        calc.setOperador("*");
        calc.setResultado(Double.parseDouble(calc.getValor()));
        imprimePapel();

        atualizaVisor();
        calc.clean();
    }

    private void imprimeResultado() {
        imprime("---------------", true);
        imprime(calc.obterResultadoFormatado()+" =", true);
    }

    // Totalizacao ENTER
    public void teclouEnter() {
        if (("+".equals(calc.getOperador())) || ("-".equals(calc.getOperador()))) {
            imprimeResultado();
        }
        if (("/".equals(calc.getOperador())) && (calc.getResultado() != 0)) {
            imprime(calc.obterValorFormatado(), true);
            calc.divisao();
            imprimeResultado();
        }
        if ("*".equals(calc.getOperador())) {
            imprime(calc.obterValorFormatado(), true);
            calc.multiplicacao();
            imprimeResultado();
        }

        imprime("", true);
        atualizaVisor();
        calc.setValorAnterior("" + calc.getResultado());
        calc.cleanAndEraser();
    }

    // Função que adiciona o componente no panel corretamente
    private void addComponent(Component component, int row, int column,
            int width, int height) {
        // addComponent(button1, LINHA, COLUNA, QTDECOLUNAS, QTDELINHAS)
        constraints.gridx = column;
        constraints.gridy = row;
        constraints.gridwidth = width;
        constraints.gridheight = height;
        layout.setConstraints(component, constraints);
        container.add(component);
    }

    /**
     * Creates a new instance of Main
     */
    public CalculadoraGUI() {
        super("Calculadora 1.0 (Beto Teste)");
        // Inicializa as variaveis de gerenciamento de layout ========
        container = getContentPane();
        layout = new GridBagLayout();
        container.setLayout(layout);
        constraints = new GridBagConstraints();

        // inicializa as variaveis dos objetos (componentes)==========
        botao1 = new JButton("  1  ");
        botao2 = new JButton("  2  ");
        botao3 = new JButton("  3  ");
        botao4 = new JButton("  4  ");
        botao5 = new JButton("  5  ");
        botao6 = new JButton("  6  ");
        botao7 = new JButton("  7  ");
        botao8 = new JButton("  8  ");
        botao9 = new JButton("  9  ");
        botao0 = new JButton("  0  ");
        botaoC = new JButton("  C  ");
        botaoC.setToolTipText("Tecle C");
        botaoCE = new JButton(" CE ");
        botaoCE.setToolTipText("Tecle E");
        botaoDiv = new JButton("  /  ");
        botaoMultip = new JButton("  *  ");
        botaoMenos = new JButton("  -  ");
        botaoMais = new JButton("  +  ");
        botaoVirgula = new JButton("  ,  ");
        botaoVirgula.setToolTipText("Tecle , (Virgula)");
        botaoTotal = new JButton("  =  ");
        botaoTotal.setToolTipText("Tecle ENTER");
        botaoPerc = new JButton("  %  ");
        botaoPerc.setToolTipText("Tecle P");
        botaoBackspace = new JButton("  <  ");
        botaoBackspace.setToolTipText("Tecle Backspace");
        keyCodigo = new JLabel("0");
        visor = new JLabel("0.00");
        visor.setHorizontalAlignment(SwingConstants.RIGHT);
        visor.setFont(new Font("Courier New", Font.BOLD, 16));
        visor.setForeground(Color.RED);
        visor.setToolTipText("Valores até 14 digitos");
        // Crio a parte de text area q ira receber os valores e crio as barras
        // de
        // rolagem dom o scroll (que � um container) depois so adiciona o
        // container scroll
        roloPapel = new JTextArea(12, 15);
        roloPapel.setEditable(false);
        roloPapel.setFont(new Font("Courier New", Font.PLAIN, 11));
        scroll = new JScrollPane(roloPapel,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBorder(new LineBorder(Color.pink, 3, true));
        botao2dig = new JRadioButton("2", true);
        botao4dig = new JRadioButton("4", false);
        botao6dig = new JRadioButton("6  : Digitos Decimais", false);
        botaoDecimais = new ButtonGroup();
        botaoDecimais.add(botao2dig);
        botaoDecimais.add(botao4dig);
        botaoDecimais.add(botao6dig);
        // Deixo apenas o label visor com foco pra fazer tratamento eventos
        // teclado so nele
        visor.setFocusable(true);
        botao1.setFocusable(false);
        botao2.setFocusable(false);
        botao3.setFocusable(false);
        botao4.setFocusable(false);
        botao5.setFocusable(false);
        botao6.setFocusable(false);
        botao7.setFocusable(false);
        botao8.setFocusable(false);
        botao9.setFocusable(false);
        botao0.setFocusable(false);
        botaoC.setFocusable(false);
        botaoCE.setFocusable(false);
        botaoMais.setFocusable(false);
        botaoMenos.setFocusable(false);
        botaoDiv.setFocusable(false);
        botaoPerc.setFocusable(false);
        botaoMultip.setFocusable(false);
        roloPapel.setFocusable(false);
        botaoVirgula.setFocusable(false);
        botaoTotal.setFocusable(false);
        botaoBackspace.setFocusable(false);
        botao2dig.setFocusable(false);
        botao4dig.setFocusable(false);
        botao6dig.setFocusable(false);
        // ======anchor=WEST mantem alinhamento dos componetnes a esquerda das
        // celulas
        // ======weightx=0 indica que nao deve aumentar na horizontal pra ocupar
        // celula
        // ======weighty=N indica que dever aumentar na vertical N pixel pra
        // ocupar a celula
        constraints.anchor = GridBagConstraints.WEST;
        constraints.weightx = 0;
        constraints.weighty = 1;
        // adiciona os componente usando a funcao
        // addComponent(button1, LINHA, COLUNA, QTDECOLUNAS, QTDELINHAS)
        constraints.fill = GridBagConstraints.BOTH;
        addComponent(scroll, 0, 0, 5, 1);
        addComponent(visor, 1, 0, 5, 1);
        addComponent(botao2dig, 2, 0, 1, 1);
        addComponent(botao4dig, 2, 1, 1, 1);
        addComponent(botao6dig, 2, 2, 3, 1);
        constraints.weightx = 0;
        constraints.weighty = 5;
        addComponent(botaoPerc, 3, 0, 1, 1);
        addComponent(botaoCE, 3, 4, 1, 1);
        addComponent(botaoC, 4, 4, 1, 1);
        addComponent(botaoBackspace, 5, 4, 1, 1);
        addComponent(botaoDiv, 3, 1, 1, 1);
        addComponent(botaoMultip, 3, 2, 1, 1);
        addComponent(botaoMenos, 3, 3, 1, 1);
        addComponent(botao7, 4, 0, 1, 1);
        addComponent(botao8, 4, 1, 1, 1);
        addComponent(botao9, 4, 2, 1, 1);
        addComponent(botaoMais, 4, 3, 1, 1);
        addComponent(botao4, 5, 0, 1, 1);
        addComponent(botao5, 5, 1, 1, 1);
        addComponent(botao6, 5, 2, 1, 1);
        addComponent(botaoVirgula, 5, 3, 1, 1);
        addComponent(botao1, 6, 0, 1, 1);
        addComponent(botao2, 6, 1, 1, 1);
        addComponent(botao3, 6, 2, 1, 1);
        addComponent(botao0, 6, 3, 1, 1);
        addComponent(botaoTotal, 6, 4, 1, 1);

        // =====tratamento de eventos de botoes====================
        trataEventosAcao handlerAcao = new trataEventosAcao();
        botaoC.addActionListener(handlerAcao);
        botaoCE.addActionListener(handlerAcao);
        botaoPerc.addActionListener(handlerAcao);
        botaoDiv.addActionListener(handlerAcao);
        botaoMultip.addActionListener(handlerAcao);
        botaoMenos.addActionListener(handlerAcao);
        botaoMais.addActionListener(handlerAcao);
        botaoTotal.addActionListener(handlerAcao);
        botaoVirgula.addActionListener(handlerAcao);
        botao1.addActionListener(handlerAcao);
        botao2.addActionListener(handlerAcao);
        botao3.addActionListener(handlerAcao);
        botao4.addActionListener(handlerAcao);
        botao5.addActionListener(handlerAcao);
        botao6.addActionListener(handlerAcao);
        botao7.addActionListener(handlerAcao);
        botao8.addActionListener(handlerAcao);
        botao9.addActionListener(handlerAcao);
        botao0.addActionListener(handlerAcao);

        // =====tratamento de eventos de focus======================
        trataEventosFocus handlerFocus = new trataEventosFocus();
		// botao1.addFocusListener(handlerFocus);

        // =====tratamento de evento de radiobuttons===============
        trataEventosRadio handlerRadio = new trataEventosRadio();
        botao2dig.addItemListener(handlerRadio);
        botao4dig.addItemListener(handlerRadio);
        botao6dig.addItemListener(handlerRadio);

        // =====tratamemto de eventos de teclado ======================
        // addKeyListener(this); Nao funcionou porque o frame nao fica com foco
        visor.addKeyListener(this);

        // ===== Determina o tamanho da janela, inibe o redimencionamento,
        // posiciona meio tela
        setSize(310, 500);
        Dimension resVideo = Toolkit.getDefaultToolkit().getScreenSize();// verifica
        // a
        // resolu��o
        // do
        // v�deo
        Dimension tamForm = getSize();
        setLocation((resVideo.width - tamForm.width) / 2,
                (resVideo.height - tamForm.height) / 2);// coloca o painel bem
        // no centro da tela
        setResizable(false);
        setVisible(true);
    }

}
