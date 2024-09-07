public class Main {
    public static void main(String[] args) {
        double[] faturamentos = {67836.43, 36678.66, 29229.88, 27165.48, 19849.53};
        String[] estados = {"SP", "RJ", "MG", "ES", "OUTROS"};
        
        // Calcular a soma total dos faturamentos
        double somaTotal = 0;
        for (double faturamento : faturamentos) {
            somaTotal += faturamento;
        }
        
        // Exibir a soma total
        System.out.println("Soma total do faturamento: " + somaTotal);
        
        // Calcular e exibir a porcentagem de cada estado
        for (int verificador = 0; verificador < faturamentos.length; verificador++) {
            double porcentagem = (faturamentos[verificador] / somaTotal) * 100;
            System.out.println("Distribuidora " + estados[verificador] + ": " + String.format("%.2f", porcentagem) + "%");
        }
    }
}
