import java.util.Scanner;

public class Main {
    /**
     * Método que servirá como um menu que mostra as informações e realiza as ações pedidass
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

                    Jogador jogadorNovo = new Jogador(nomeLido, cpfLido, emailLido, fotoLida, new Peca(corPecaLida, 0));
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

        //Parte de testes dos construtores e instanciação de alguns objetos das classes
        Peca peca1 = new Peca("ciano", 3);
        Jogador jogador1 = new Jogador("Giovani", "526413728", "p200246@dac.unicamp.br" , "Minha foto", peca1);
        CartaSorte carta1 = new CartaSorte(1, "Avanço", jogador1, "Avançe 3 casas", "Positivo",
         0, null, 0, "Essa carta só pode ser usada após alguma compra");
        Propriedade propriedade1 = new Propriedade(1, "tutstuts", jogador1, "Propriedade 1", 400, jogador1, 50.0);
        ServicoPublico servicoPublico1 = new ServicoPublico(2, "tutstuts", jogador1,"Serviço Público 1", 200, jogador1, 30.0);
        Estacao estacao1 = new Estacao(0, "tutstuts", jogador1,"Estação 1", 300, jogador1, 40.0);
        Terreno terreno1 = new Terreno(1, "tutstuts", jogador1,"Propriedade 1", 400, jogador1, 50.0, 100, 200);
        Tabuleiro tabuleiro = new Tabuleiro();

        System.out.println(carta1);
        System.out.println(propriedade1);
        System.out.println(terreno1);
        System.out.println(servicoPublico1);
        System.out.println(estacao1);
        System.out.println(tabuleiro);
        System.out.println(peca1);

        //Testes das funcionalidades do tabuleiro
        tabuleiro.adicionarJogador(jogador1);
        tabuleiro.adicionarPropriedade(terreno1);
        
        //Parte de testes da compra e venda de casas e hotéis para o jogador
        if (terreno1.comprarCasa())
            System.out.println("O jogador " + terreno1.getDono().getNome() + " comprou uma casa no(a) " + terreno1.getNome());
        
        else
            System.out.println("O jogador " + terreno1.getDono().getNome() + " não conseguiu comprar uma casa no(a) " + terreno1.getNome());

        if (terreno1.comprarHotel())
            System.out.println("O jogador " + terreno1.getDono().getNome() + " comprou um hotel no(a) " + terreno1.getNome());

        else
            System.out.println("O jogador " + terreno1.getDono().getNome() + " naõ conseguiu comprar um hotel no(a) " + terreno1.getNome());
        
        //Testes das novas funcionalidades que relacionam as cartas aos jogadores
        jogador1.adicionaCarta(carta1);
        System.out.println(jogador1);

        jogador1.removeCarta(carta1);
        System.out.println(jogador1);

        //Testes relacionados ao uso do menu
        System.out.println("Gostaria de visualizar o menu? Digite 1 em caso afirmativo, ou 0, caso não queira");
        String resposta = scanner.nextLine();

        if (resposta.equals("1"))
            menu(tabuleiro);

        scanner.close();        //Fecha o objeto Scanner para liberar os recursos

    }
}
