import java.util.Scanner;
import java.util.Random;

public class CampoMinado {
static Scanner sc = new Scanner(System.in);
static Random rand = new Random();
static char[][] campo = new char[10][10]; // Tabuleiro do jogo
static String jogador;

    public static void main(String[] args) {
        boasVindas();
        solicitarNome();
        mostrarRegras();
        inicializarCampo();
        sortearMinas(15); // Sorteando 15 minas aleatórias

        jogar();
}

    public static void boasVindas() {
    System.out.println("🔰 Bem-vindo ao Campo Minado 🔰");
}

    public static void solicitarNome() {
        System.out.printf("Digite o nome do jogador: ");
            jogador = sc.nextLine();
        System.out.println("Boa sorte, " + jogador + "!");
}

    public static void mostrarRegras() {
        System.out.println("\n🎮 Regras do Campo Minado:");
        System.out.println("- O campo é 10x10 (A a J, 1 a 10).");
        System.out.println("- Você deve tentar descobrir as casas sem minas.");
        System.out.println("- Se encontrar uma mina, o jogo acaba.");
        System.out.println("- Boa sorte!\n");
}

    public static void inicializarCampo() {
    for (int i = 0; i < 10; i++) {
    for (int j = 0; j < 10; j++) {
    campo[i][j] = '-'; // Campo vazio
    }
  }
}

    public static void sortearMinas(int quantidade) {
        int minasSorteadas = 0;
        while (minasSorteadas < quantidade) {
        int linha = rand.nextInt(10);
        int coluna = rand.nextInt(10);
        if (campo[linha][coluna] != '*') {
            campo[linha][coluna] = '*'; // Coloca uma mina
            minasSorteadas++;
     }
   }
}

    public static void exibirCampo(boolean revelarMinas) {
        System.out.println(" 1 2 3 4 5 6 7 8 9 10");
    for (int i = 0; i < 10; i++) {
        System.out.print((char)('A' + i) + " | ");
    for (int j = 0; j < 10; j++) {
        if (campo[i][j] == '*' && !revelarMinas) {
        System.out.print("- ");
    } else {
        System.out.print(campo[i][j] + " ");
    }
}
        System.out.println();
    }
}

        public static void jogar() {
            int jogadas = 0;
            boolean vivo = true;

        while (vivo) {
        exibirCampo(false);
        System.out.print("\nEscolha a linha (A-J): ");
        char linhaLetra = sc.next().toUpperCase().charAt(0);
        int linha = linhaLetra - 'A';

        System.out.print("Escolha a coluna (1-10): ");
            int coluna = sc.nextInt() - 1;

            if (linha < 0 || linha >= 10 || coluna < 0 || coluna >= 10) {
        System.out.println("Posição inválida! Tente novamente.");
        continue;
}

        if (campo[linha][coluna] == '*') {
        System.out.println("💥 Você pisou em uma mina! Fim de jogo!");
            exibirCampo(true);
                vivo = false;
        } else if (campo[linha][coluna] == '-') {
    campo[linha][coluna] = 'O'; // Marca a casa segura
        jogadas++;
            System.out.println("✅ Casa segura! Continue assim!");
        } else {
            System.out.println("⚠ Você já tentou essa posição!");
}

        if (jogadas == (100 - 15)) {
        System.out.println("🎉 Parabéns, " + jogador + "! Você venceu o jogo!");
            exibirCampo(true);
                        break;
            }
        }   
    }
}