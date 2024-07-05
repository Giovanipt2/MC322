import java.io.IOException;
import java.util.Scanner;

public class Main {
    /**
     * Método que servirá como um menu que mostra as informações e realiza as ações pedidas
     * Nessa versão final do projeto, pela forma como acontecerá o jogo, o menu não será mais chamado na main
     */
    public static void menu(Tabuleiro tabuleiro) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            //Opções que serão dadas para se escolher no menu
            System.out.println("Digite o número da opção que gostaria de visualizar:");
            System.out.println("1 - Informações de jogador");
            System.out.println("2 - Jogadores da partida");
            System.out.println("3 - Adicionar novo jogador");
            System.out.println("4 - Informações de propriedade");
            System.out.println("5 - Fechar menu");

            String comando = scanner.nextLine();
            
            switch (comando) {
                case "1":
                    System.out.println("Digite o ID do jogador buscado:");
                    String resposta = scanner.nextLine();

                    Jogador jogadorBuscado = tabuleiro.buscarJogador(Integer.parseInt(resposta));

                    if (jogadorBuscado == null)
                        System.out.println("O jogador em questão não está na partida");

                    else {
                        System.out.println("Digite qual das seguintes informações do jogador você gostaria de ver:");
                        System.out.println("1 - Nome");
                        System.out.println("2 - CPF");
                        System.out.println("3 - Email");
                        System.out.println("4 - Foto");
                        System.out.println("5 - Dinheiro atual");
                        System.out.println("6 - Peça");
                        System.out.println("7 - Cartas");
                        System.out.println("8 - Todas as informações");

                        resposta = scanner.nextLine();

                        switch (resposta) {
                            case "1":
                                System.out.println(jogadorBuscado.getNome());
                                break;
                        
                            case "2":
                                System.out.println(jogadorBuscado.getCpf());
                                break;

                            case "3":
                                System.out.println(jogadorBuscado.getEmail());
                                break;

                            case "4":
                                System.out.println(jogadorBuscado.getFoto());
                                break;

                            case "5":
                                System.out.println(jogadorBuscado.getDinheiro());
                                break;

                            case "6":
                                System.out.println(jogadorBuscado.getPeca());
                                break;

                            case "7":
                                System.out.println(jogadorBuscado.getCartas());
                                break;

                            case "8":
                                System.out.println(jogadorBuscado);
                                break;
                        }
                    }
                    break;
            
                case "2":
                    if (tabuleiro.getJogadores().size() > 0)
                        for (Jogador jogador : tabuleiro.getJogadores())
                            System.out.println(jogador.getNome() + " (" + jogador.getId() + ")");

                    else
                        System.out.println("Não há jogadores na partida");
                    
                    break;

                case "3":
                    String nomeLido, cpfLido, emailLido, fotoLida, corPecaLida;
                    System.out.println("Digite as informações do novo jogador:");

                    System.out.println("Nome:");
                    nomeLido = scanner.nextLine();

                    System.out.println("CPF:");
                    cpfLido = scanner.nextLine();

                    while (!Utils.validarCpf(cpfLido)) {
                        System.out.println("O CPF inserido é inválido. Por favor, insira-o novamente");
                        cpfLido = scanner.nextLine();
                    }

                    System.out.println("Email:");
                    emailLido = scanner.nextLine();

                    while (!Utils.validarEmail(emailLido)){
                        System.out.println("O email inserido é inválido. Por favor, insira-o novamente");
                        emailLido = scanner.nextLine();
                    }

                    System.out.println("Caminho para a foto:");
                    fotoLida = scanner.nextLine();

                    System.out.println("Cor da peça do jogador:");
                    corPecaLida = scanner.nextLine();

                    Jogador jogadorNovo = new Jogador(nomeLido, cpfLido, emailLido, fotoLida, new Peca(corPecaLida));
                    tabuleiro.adicionarJogador(jogadorNovo);
                    System.out.println("O jogador criado tem as seguintes características:");
                    System.out.println(jogadorNovo);

                    break;

                case "4":
                    System.out.println("Digite o ID da propriedade buscada:");
                    resposta = scanner.nextLine();

                    Propriedade propriedadeBuscada = tabuleiro.buscarPropriedade(Integer.parseInt(resposta));

                    if (propriedadeBuscada == null)
                        System.out.println("A propriedade em questão não está no tabuleiro");

                    else {
                        System.out.println("Digite qual das seguintes informações do jogador você gostaria de ver:");
                        System.out.println("1 - Nome");
                        System.out.println("2 - Preço");
                        System.out.println("3 - Aluguel");
                        System.out.println("4 - Descrição");
                        System.out.println("5 - Dono");
                        System.out.println("6 - Todas as informações");

                        resposta = scanner.nextLine();

                        switch (resposta) {
                            case "1":
                                System.out.println(propriedadeBuscada.getNome());
                                break;
                        
                            case "2":
                                System.out.println(propriedadeBuscada.getPreco());
                                break;

                            case "3":
                                System.out.println(propriedadeBuscada.getAluguel());
                                break;

                            case "4":
                                System.out.println(propriedadeBuscada.getDescricao());
                                break;

                            case "5":
                                if (propriedadeBuscada.getDono() != null)
                                    System.out.println(propriedadeBuscada.getDono());

                                else
                                    System.out.println("Essa propriedade não pertence a nenhum jogador");

                                break;

                            case "6":
                                System.out.println(propriedadeBuscada);
                                break;
                        }
                    }

                    break;

                case "5":
                    System.out.println("Espero ter ajudado!");
                    scanner.close();
                    return;
            }
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        Tabuleiro tabuleiro = new Tabuleiro();
        //Construção do tabuleiro para que seja possível jogar
        tabuleiro.inicializarTabuleiro();

        //Loop para simular o jogo
        //Os jogadores que falirem serão retirados do jogo, por isso a condição no while
        while(tabuleiro.getJogadores().size() > 1) {    
            for (Jogador jogador : tabuleiro.getJogadores()){
                int n_dado = tabuleiro.rolarDado();     //Número sorteado no dado
                tabuleiro.moverJogador(jogador, n_dado);
                //Carta que está na posição atingida pelo jogador
                Carta cartaDaPosicao = tabuleiro.getPosicoes().get(jogador.getPeca().getPosicao());

                switch (cartaDaPosicao.getTipo()) {
                    case INICIO:
                        jogador.setDinheiro(jogador.getDinheiro() + tabuleiro.getBonus());
                        System.out.println(jogador.getNome() + " passou pela posição inicial e ganhou " + tabuleiro.getBonus() + "!");
                        try {
                            tabuleiro.salvaLog(jogador.getNome() + " passou pela posição inicial e ganhou " + tabuleiro.getBonus() + "!");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    
                    case ESTACAO:
                        Estacao estacao = (Estacao) cartaDaPosicao;
                        if (estacao.getDono() == null) {
                            String mensagem = jogador.getNome() + ", gostaria de comprar a estação " + estacao.getNome() + " por R$" + estacao.getPreco() + "?";
                            System.out.println(mensagem);
                            System.out.println("[1] Sim");
                            System.out.println("[2] Não");
    
                            int escolha = scanner.nextInt();
                            if (escolha == 1) {
                                if (jogador.temDinheiro(estacao.getPreco())) {
                                    try {
                                        jogador.compra(estacao);
                                        estacao.setDono(jogador);
                                        jogador.setNEstacoes(jogador.getNEstacoes() + 1);
                                        System.out.println(jogador.getNome() + " comprou a estação " + estacao.getNome() + " por R$" + estacao.getPreco());
                                        tabuleiro.salvaLog(jogador.getNome() + " comprou a estação " + estacao.getNome() + " por R$" + estacao.getPreco());
                                    } catch (DinheiroInsuficienteException e) {
                                        System.out.println(e.getMessage());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    System.out.println("Saldo insuficiente para comprar esta propriedade.");
                                }
                            }
                        } else {
                            Jogador dono = estacao.getDono();
                            //Se o próprio jogador for o dono, nada acontece
                            if (jogador != dono) {
                                int valorASerPago = estacao.calcularAluguel();

                                if (jogador.temDinheiro(valorASerPago)) {
                                    dono.setDinheiro(dono.getDinheiro() + valorASerPago);
                                    jogador.debitarSaldo(valorASerPago);
                                    String mensagem = "O jogador " + jogador.getNome() + " pagou R$" + valorASerPago + " de aluguel ao jogador "
                                        + dono.getNome();
                                    System.out.println(mensagem);
                                    try {
                                        tabuleiro.salvaLog(mensagem);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    if (jogador.faliu()){
                                        System.out.println("O jogador " + jogador.getNome() + " faliu e está fora do jogo!");
                                        try {
                                            tabuleiro.salvaLog("O jogador " + jogador.getNome() + " faliu e está fora do jogo!");
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        tabuleiro.removerJogador(jogador);
                                    }
                                }
                                else{
                                    System.out.println("O jogador " + jogador.getNome() + " não tem dinheiro para pagar; portanto, está fora do jogo!");
                                    try {
                                        tabuleiro.salvaLog("O jogador " + jogador.getNome() + " não tem dinheiro para pagar; portanto, está fora do jogo!");
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    tabuleiro.removerJogador(jogador);
                                }
                            }
                        }
                        break;
                    
                    case SERVICOPUBLICO:
                        ServicoPublico servicoPublico = (ServicoPublico) cartaDaPosicao;
                        int multiplicador = n_dado;
                        servicoPublico.setMultiplicador(multiplicador);
                        if (servicoPublico.getDono() == null) {
                            String mensagem = jogador.getNome() + ", gostaria de comprar o serviço público " + servicoPublico.getNome() + " por R$"
                             + servicoPublico.getPreco() + "?";
                            System.out.println(mensagem);
                            System.out.println("[1] Sim");
                            System.out.println("[2] Não");

                            int escolha = scanner.nextInt();
                            if (escolha == 1) {
                                if (jogador.temDinheiro(servicoPublico.getPreco())) {
                                    try {
                                        jogador.compra(servicoPublico);
                                        servicoPublico.setDono(jogador);
                                        System.out.println(jogador.getNome() + " comprou o serviço público " + servicoPublico.getNome() + " por R$"
                                        + servicoPublico.getPreco());
                                        tabuleiro.salvaLog(jogador.getNome() + " comprou o serviço público " + servicoPublico.getNome() + " por R$"
                                         + servicoPublico.getPreco());
                                    } catch (DinheiroInsuficienteException e) {
                                        System.out.println(e.getMessage());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    System.out.println("Saldo insuficiente para comprar esta propriedade.");
                                }
                            }
                        } else {
                            Jogador dono = servicoPublico.getDono();
                            //Se o próprio jogador for o dono, nada acontece
                            if (jogador != dono) {
                                int valorASerPago = servicoPublico.calcularAluguel();

                                if (jogador.temDinheiro(valorASerPago)) {
                                    dono.setDinheiro(dono.getDinheiro() + valorASerPago);
                                    jogador.debitarSaldo(valorASerPago);
                                    String mensagem = "O jogador " + jogador.getNome() + " pagou R$" + valorASerPago + " de aluguel ao jogador "
                                        + dono.getNome();
                                    System.out.println(mensagem);
                                    try {
                                        tabuleiro.salvaLog(mensagem);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    if (jogador.faliu()){
                                        System.out.println("O jogador " + jogador.getNome() + " faliu e está fora do jogo!");
                                        try {
                                            tabuleiro.salvaLog("O jogador " + jogador.getNome() + " faliu e está fora do jogo!");
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        tabuleiro.removerJogador(jogador);
                                    }
                                }
                                else{
                                    System.out.println("O jogador " + jogador.getNome() + " não tem dinheiro para pagar; portanto, está fora do jogo!");
                                    try {
                                        tabuleiro.salvaLog("O jogador " + jogador.getNome() + " não tem dinheiro para pagar; portanto, está fora do jogo!");
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    tabuleiro.removerJogador(jogador);
                                }
                            }
                        }
                        servicoPublico.setMultiplicador(1);

                        break;

                    case TERRENO:
                        Terreno terreno = (Terreno) cartaDaPosicao;
                        if (terreno.getDono() == null) {
                            String mensagem = jogador.getNome() + ", gostaria de comprar o terreno " + terreno.getNome() + " por R$" + terreno.getPreco() + "?";
                            System.out.println(mensagem);
                            System.out.println("[1] Sim");
                            System.out.println("[2] Não");

                            int escolha = scanner.nextInt();
                            if (escolha == 1) {
                                if (jogador.temDinheiro(terreno.getPreco())) {
                                    try {
                                        jogador.compra(terreno);
                                        terreno.setDono(jogador);
                                        System.out.println(jogador.getNome() + " comprou o terreno " + terreno.getNome() + " por R$" + terreno.getPreco());
                                        tabuleiro.salvaLog(jogador.getNome() + " comprou o terreno " + terreno.getNome() + " por R$" + terreno.getPreco());
                                    } catch (DinheiroInsuficienteException e) {
                                        System.out.println(e.getMessage());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    System.out.println("Saldo insuficiente para comprar esta propriedade.");
                                }
                            }
                        } else {
                            Jogador dono = terreno.getDono();
                            //Se o próprio jogador for o dono, nada acontece
                            if (jogador != dono) {
                                int valorASerPago = terreno.calcularAluguel();

                                if (jogador.temDinheiro(valorASerPago)) {
                                    dono.setDinheiro(dono.getDinheiro() + valorASerPago);
                                    jogador.debitarSaldo(valorASerPago);
                                    String mensagem = "O jogador " + jogador.getNome() + " pagou R$" + valorASerPago + " de aluguel ao jogador "
                                        + dono.getNome();
                                    System.out.println(mensagem);
                                    try {
                                        tabuleiro.salvaLog(mensagem);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    if (jogador.faliu()){
                                        System.out.println("O jogador " + jogador.getNome() + " faliu e está fora do jogo!");
                                        try {
                                            tabuleiro.salvaLog("O jogador " + jogador.getNome() + " faliu e está fora do jogo!");
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        tabuleiro.removerJogador(jogador);
                                    }
                                }
                                else{
                                    System.out.println("O jogador " + jogador.getNome() + " não tem dinheiro para pagar; portanto, está fora do jogo!");
                                    try {
                                        tabuleiro.salvaLog("O jogador " + jogador.getNome() + " não tem dinheiro para pagar; portanto, está fora do jogo!");
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    tabuleiro.removerJogador(jogador);
                                }
                            }
                            else {
                                //Caso o jogador ainda não tenha o número máximo de casas em seu terreno
                                if (terreno.getNumCasas() < 4) {
                                    String mensagem = jogador.getNome() + ", gostaria de comprar uma casa no terreno" + terreno.getNome() + " por R$"
                                        + terreno.getValorCasa() + "?";
                                    System.out.println(mensagem);
                                    System.out.println("[1] Sim");
                                    System.out.println("[2] Não");

                                    int escolha = scanner.nextInt();
                                    if (escolha == 1) {
                                        if (jogador.temDinheiro(terreno.getValorCasa())) {
                                            try {
                                                terreno.comprarCasa();
                                                System.out.println(jogador.getNome() + " comprou uma casa no terreno " 
                                                + terreno.getNome() + " por R$" + terreno.getValorCasa());
                                                tabuleiro.salvaLog(jogador.getNome() + " comprou uma casa no terreno " 
                                                    + terreno.getNome() + " por R$" + terreno.getValorCasa());
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                        } else {
                                            System.out.println("Saldo insuficiente para comprar uma casa.");
                                        }
                                    }
                                }
                                else {
                                    String mensagem = jogador.getNome() + ", gostaria de comprar um hotel no terreno" + terreno.getNome() + " por R$"
                                        + terreno.getValorHotel() + "?";
                                    System.out.println(mensagem);
                                    System.out.println("[1] Sim");
                                    System.out.println("[2] Não");

                                    int escolha = scanner.nextInt();
                                    if (escolha == 1) {
                                        if (jogador.temDinheiro(terreno.getValorHotel())) {
                                            try {
                                                terreno.comprarHotel();
                                                System.out.println(jogador.getNome() + " comprou um hotel no terreno " 
                                                + terreno.getNome() + " por R$" + terreno.getValorHotel());
                                                tabuleiro.salvaLog(jogador.getNome() + " comprou um hotel no terreno " 
                                                    + terreno.getNome() + " por R$" + terreno.getValorHotel());
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                        } else {
                                            System.out.println("Saldo insuficiente para comprar um hotel.");
                                        }
                                    }
                                }
                            }
                        }

                        break;

                    case SORTE:
                        //A posição apenas indicava que uma carta sorte deveria ser sorteada, mas não continha a carta
                        CartaSorte cartaSorte = tabuleiro.sortearCartaSorte();

                        if (cartaSorte.getTipo() == TipoCarta.SORTE){
                            String mensagem = "O jogador " + jogador.getNome() + " teve sorte, e acabou de ganhar R$" +
                                cartaSorte.getValor() + "!";
                            System.out.println(mensagem);
                            try {
                                tabuleiro.salvaLog(mensagem);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            cartaSorte.executaAcao(jogador);
                        }
                        else{
                            String mensagem = "O jogador " + jogador.getNome() + " teve azar, e acabou de perder R$" +
                                Math.abs(cartaSorte.getValor()) + "!";
                            System.out.println(mensagem);
                            try {
                                tabuleiro.salvaLog(mensagem);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            cartaSorte.executaAcao(jogador);
                            if (jogador.faliu()){
                                System.out.println("O jogador " + jogador.getNome() + " faliu e está fora do jogo!");
                                try {
                                    tabuleiro.salvaLog("O jogador " + jogador.getNome() + " faliu e está fora do jogo!");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                tabuleiro.removerJogador(jogador);
                            }
                        }

                        break;

                    case REVES:
                        //Esse caso específico não ocorrerá, já que as posições no tabuleiro só indicam que 
                        //Uma carta de sorte deve ser sorteada, mas ainda não se sabe se ela é de sorte ou revés
                        //No entanto, a estrutra do switch pede que haja um case para cada uma das opções possíveis
                        //Inclusive, note que o caso de uma carta de revés é tratado na situação acima
                        break;
                }
            }
        }

        scanner.close();        //Fecha o objeto Scanner para liberar os recursos
        //Impressão do vencedor (último jogador restante no tabuleiro)
        Jogador vencedor = tabuleiro.getJogadores().get(0);
        String mensagem = "O jogador vencedor é o " + vencedor.getNome() + "!";
        System.out.println(mensagem);
        try {
            tabuleiro.salvaLog(mensagem);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
