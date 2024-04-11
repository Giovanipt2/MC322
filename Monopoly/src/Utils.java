import java.util.regex.Pattern;

/**
 * Essa classe funcionará como uma biblioteca de funções úteis para o jogo
 */
public class Utils {
    /**
     * Esse método valida o CPF de um jogador com base nas regras estabelecidas para o jogo e convenções padrão
     * Passo 1: a expressão regular busca por caracteres não numéricos no CPF e os remove, se existirem
     * Passo 2: a quantidade de dígitos é verificada, para garantir que seja 11
     * Passo 3: verifica se todos os dígitos do CPF são iguais, o que o tornaria inválido
     * Passo 4: utiliza um algoritmo apropriado para calcular os dígitos verificadores do CPF
     * Passo 5: verifica se os dígitos verificadores calculados são os mesmos que estão no CPF de fato
     * @param cpf String que representa o cpf de um jogador
     * @return Se o cpf é válido ou não (booleano)
     */
    public static boolean validarCpf(String cpf) {
        //Passo 1
        //String que representará o CPF formatado, fazendo as mudanças necessárias
        String cpfFormat = cpf.replaceAll("[^0-9]", "");

        //Passo 2
        if (cpfFormat.length() != 11) {
            return false;
        }

        //Passo 3
        //Procura por uma sequência de 11 dígitos consecutivos, vendo se o primeiro se repete mais 10 vezes
        if (cpfFormat.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Passo 4
        //Vetor que guardará a informação numérica do CPF, possibilitando os cálculos com seus dígitos
        int[] vetorCpf = new int[11];  
        for (int i = 0; i < 11; i++) {
            //Pega o caractere que está na posição i da string e guarda na posição i do vetor, já na forma de int
            vetorCpf[i] = Character.getNumericValue(cpfFormat.charAt(i));
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += vetorCpf[i] * (10 - i);
        }

        int resto = soma % 11;
        int digito1 = (resto < 2) ? 0 : (11 - resto);   //Primeiro dígito verificador do CPF

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += vetorCpf[i] * (11 - i);
        }

        resto = soma % 11;
        int digito2 = (resto < 2) ? 0 : (11 - resto);   //Segundo dígito verificador do CPF

        // Passo 5
        return (digito1 == vetorCpf[9]) && (digito2 == vetorCpf[10]);
    }


     /**
     * Utiliza uma expressão regular para verificar se o email está na formatação correta
     * Antes do '@', permite letras, números e os caracteres especiais: '+', '_', '.' e '-'
     * Depois do '@', permite letras, números e, apenas, os caracteres especiais '.' e '-'
     * O objeto "Patern" é a representação compilada do padrão da expressão regular usada
     * O método "matcher" cria um objeto que nos permite comparar o email passado como parâmetro com os padrões de string estabelecidos
     * O método "matches" retorna um booleano que indica se os padrões estabelecidos foram atendidos ou não
     * @param email String que representa o email de um jogador
     * @return Se o email é válido ou não (booleano)
     */
    public static boolean validarEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.compile(regex).matcher(email).matches();
    }
}
