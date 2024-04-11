import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //Parte de testes dos construtores e instanciação de alguns objetos das classes
        Jogador jogador1 = new Jogador("Giovani", "526413728", "p200246@dac.unicamp.br" , "Minha foto");
        System.out.println(jogador1);
        System.out.println("");

        CartaSorte carta1 = new CartaSorte(1, "Avanço", "Avançe 3 casas", "Positivo",
         0, null, 0, "Essa carta só pode ser usada após alguma compra");
        System.out.println("ID da carta: " + carta1.getId());
        System.out.println("Descrição: " + carta1.getDescricao());
        System.out.println("Movimento: " + carta1.getMovimento());
        System.out.println("Efeito: " + carta1.getEfeito());
        System.out.println("Restrição: " + carta1.getRestricao());
        System.out.println("");
        
        Peca peca1 = new Peca("ciano", 3);
        System.out.println("A peça é da cor " + peca1.getCor() + " e está na posição " + peca1.getPosicao());
        System.out.println("");

        //Parte que representaria a coleta dos dados de um jogador e sua criação
        System.out.println("Digite o seu nome: ");
        String nomeLido = scanner.nextLine();

        System.out.println("Digite o seu CPF: ");
        String cpfLido = scanner.nextLine();

        System.out.println("Digite o seu email: ");
        String emailLido = scanner.nextLine();

        System.out.println("Digite o caminho para sua foto: ");
        String fotoLida = scanner.nextLine();

        Jogador jogador2 = new Jogador(nomeLido, cpfLido, emailLido, fotoLida);

        System.out.println(jogador2);
        System.out.println("");

        scanner.close();        //Fecha o objeto Scanner para liberar os recursos

        //Parte que testa as funções de validar cpf e validar email
        System.out.println(Utils.validarCpf("63728346712"));
        System.out.println(Utils.validarEmail("giovani@gmail.com"));
        System.out.println("");

        //Parte de testes das propriedades
        Propriedade propriedade1 = new Propriedade(1, "Propriedade 1", 400, jogador1, 50.0);
        System.out.println("ID da propriedade: " + propriedade1.getId());
        System.out.println("Nome da propriedade: " + propriedade1.getNome());
        System.out.println("Preço: " + propriedade1.getPreco());
        System.out.println("Proprietário: " + propriedade1.getProprietario());
        System.out.println("Aluguel: " + propriedade1.getAluguel());
        System.out.println("");

        //Parte de testes dos serviços públicos
        ServicoPublico servicoPublico1 = new ServicoPublico(2, "Serviço Público 1", 200, jogador1, 30.0);
        System.out.println("ID do serviço: " + servicoPublico1.getId());
        System.out.println("Nome do serviço: " + servicoPublico1.getNome());
        System.out.println("Preço: " + servicoPublico1.getPreco());
        System.out.println("Proprietário: " + servicoPublico1.getProprietario());
        System.out.println("Aluguel: " + servicoPublico1.getAluguel());
        System.out.println("");

        //Parte de testes das estações
        Estacao estacao1 = new Estacao(0, "Estação 1", 300, jogador1, 40.0);
        System.out.println("ID da estação: " + estacao1.getId());
        System.out.println("Nome da estação: " + estacao1.getNome());
        System.out.println("Preço: " + estacao1.getPreco());
        System.out.println("Proprietário: " + estacao1.getProprietario());
        System.out.println("Aluguel: " + estacao1.getAluguel());
        System.out.println("");

        //Parte de testes dos terrenos
        Terreno terreno1 = new Terreno(1, "Propriedade 1", 400, jogador1, 50.0, 100, 200);
        System.out.println("ID do terreno: " + terreno1.getId());
        System.out.println("Nome do terreno: " + terreno1.getNome());
        System.out.println("Preço: " + terreno1.getPreco());
        System.out.println("Proprietário: " + terreno1.getProprietario());
        System.out.println("Aluguel: " + terreno1.getAluguel());
        System.out.println("Valor da casa: " + terreno1.getValorCasa());
        System.out.println("Valor do hotel: " + terreno1.getValorHotel());
        System.out.println("");

        //Parte de testes do tabuleiro
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.adicionarJogador(jogador1);
        tabuleiro.adicionarPropriedade(terreno1);
        System.out.println("O jogador " + jogador1.getNome() + " está no tabuleiro");
        System.out.println("O terreno: " + terreno1.getNome() + " está no tabuleiro");

        //Parte de testes da compra e venda de casas e hotéis para o jogador
        if (terreno1.comprarCasa())
            System.out.println("O jogador " + terreno1.getProprietario().getNome() + " comprou uma casa no(a) " + terreno1.getNome());
        
        else
            System.out.println("O jogador " + terreno1.getProprietario().getNome() + " não conseguiu comprar uma casa no(a) " + terreno1.getNome());

        if (terreno1.comprarHotel())
            System.out.println("O jogador " + terreno1.getProprietario().getNome() + " comprou um hotel no(a) " + terreno1.getNome());

        else
            System.out.println("O jogador " + terreno1.getProprietario().getNome() + " naõ conseguiu comprar um hotel no(a) " + terreno1.getNome());
    }
}
