import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);


        //Parte de testes dos construtores e instanciação de alguns objetos das classes
        Jogador jogador1 = new Jogador("Popó", "526413728", "p200246@dac.unicamp.br" , "Minha foto");
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
        //Fim da parte de testes


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

        while(jogador2.validarCPF() == false){
            System.out.println("CPF inválido. Digite-o novamente: ");
            cpfLido = scanner.nextLine();
            jogador2.setCpf(cpfLido);
        }

        while(jogador2.validarEmail() == false){
            System.out.println("Email inválido. Digite-o novamente: ");
            emailLido = scanner.nextLine();
            jogador2.setCpf(emailLido);
        }

        System.out.println(jogador2);
        System.out.println("");

        scanner.close();        //Fecha o objeto Scanner para liberar os recursos


    }
}
