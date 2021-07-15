import java.util.Scanner;

public class JogoDaVelha {
    Mapa jogoMapa;
    PC jogoPC = new PC(jogoMapa);
    Jogador jogoJogador = new Jogador(jogoMapa);

    private JogoDaVelha(){
        Scanner teclado = new Scanner(System.in);
        
        jogoMapa = new Mapa();
        jogoPC = new PC(jogoMapa);
        jogoJogador = new Jogador(jogoMapa);

        char opcao = '0';

        do{
            jogar(teclado);

            System.out.print("Deseja jogar novamente? S/N");
            opcao = teclado.next().toUpperCase().trim().charAt(0);

        }while(opcao == 'S');

    }

    private void jogar(Scanner teclado) {
        jogoMapa.limpar();

        int jogadorRodada = jogoMapa.sortear(0, 2);
        int numeroRodada = 0;

        jogoMapa.desenhar(numeroRodada);

        while (numeroRodada++ < 9) {
            if (numeroRodada % 2 == jogadorRodada) {
                boolean jogadorVenceu = jogoJogador.jogar(teclado);
                jogoMapa.desenhar(numeroRodada);

                if (jogadorVenceu) {
                    System.out.println("Jogador venceu!");
                    break;
                }
                if (numeroRodada == 9) {
                    System.out.println("Empate!");
                } else {
                    boolean computadorVenceu = jogoPC.jogar();
                    jogoMapa.desenhar(numeroRodada);

                    if (computadorVenceu) {
                        System.out.println("Computador venceu!");
                    }
                    if (numeroRodada == 9) {
                        System.out.println("Empate!");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new JogoDaVelha();
    } 
}  
