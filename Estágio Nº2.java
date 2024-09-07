import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        
        // Escolha de iniciação
        System.out.print("Você deseja iniciar com algum valor? 1 - Sim / 2 - Não: ");
        int escolherIniciar = ler.nextInt();
        
        // Escolha de valor para iniciar a sequência de Fibonacci
        if (escolherIniciar == 1) {
            System.out.print("Insira o valor para fazer a sequência de Fibonacci: ");
            int escolhaValor = ler.nextInt();
            
            // Verifica se o valor escolhido é 0 ou 1
            if (escolhaValor == 0 || escolhaValor == 1) {
                System.out.println("O valor " + escolhaValor + " pertence à sequência de Fibonacci.");
                return;
            }

            // Calcula a sequência de Fibonacci para verificar se o número pertence a ela
            int valor1 = 0, valor2 = 1;
            int proximoValor = valor1 + valor2;

            while (proximoValor <= escolhaValor) {
                if (proximoValor == escolhaValor) {
                    System.out.println("O número " + escolhaValor + " pertence à sequência de Fibonacci.");
                    return;
                }
                
                // Avança na sequência
                valor1 = valor2;
                valor2 = proximoValor;
                proximoValor = valor1 + valor2;
            }

            // Se não encontrou o número na sequência
            System.out.println("O número " + escolhaValor + " não pertence à sequência de Fibonacci.");
        
        } else {
            // Iniciar até o valor desejado
            System.out.print("Insira até qual valor você deseja realizar a sequência: ");
            int maiorQuantidade = ler.nextInt();
            
            int valor1 = 0, valor2 = 1;
            System.out.print("Sequência de Fibonacci: " + valor1 + " " + valor2 + " ");
            
            int proximoValor = valor1 + valor2;
            
            while (proximoValor <= maiorQuantidade) {
                System.out.print(proximoValor + " ");
                
                // Avança na sequência
                valor1 = valor2;
                valor2 = proximoValor;
                proximoValor = valor1 + valor2;
            }
            
            System.out.println("\nFim da sequência.");
        }
        ler.close();
    }
}
