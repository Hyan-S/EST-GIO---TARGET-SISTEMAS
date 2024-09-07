import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

[
    {"dia": 1, "faturamento": 1000.0},
    {"dia": 2, "faturamento": 0.0},     
    {"dia": 3, "faturamento": 1500.0},
    {"dia": 4, "faturamento": 0.0},     
    {"dia": 5, "faturamento": 2000.0},
    {"dia": 6, "faturamento": 500.0}
]

public class Main {
    public static void main(String[] args) {
        try {
            // Carrega o arquivo JSON com o faturamento
            String caminhoArquivo = "faturamento.json"; // Caminho para o arquivo JSON
            BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo));
            StringBuilder jsonBuilder = new StringBuilder();
            String linha;
            while ((linha = reader.readLine()) != null) {
                jsonBuilder.append(linha);
            }
            reader.close();
            
            // Converte o conteúdo do arquivo JSON para um JSONArray
            JSONArray faturamentos = new JSONArray(jsonBuilder.toString());
            
            // Variáveis para cálculos
            double menorValor = Double.MAX_VALUE;
            double maiorValor = Double.MIN_VALUE;
            double soma = 0;
            int diasComFaturamento = 0;
            
            // Passo 2: Itera sobre os dados do faturamento e calcula menor, maior e soma
            for (int i = 0; i < faturamentos.length(); i++) {
                JSONObject diaFaturamento = faturamentos.getJSONObject(i);
                double valor = diaFaturamento.getDouble("faturamento");

                if (valor > 0) {  // Ignorar dias sem faturamento (0)
                    if (valor < menorValor) menorValor = valor;
                    if (valor > maiorValor) maiorValor = valor;
                    soma += valor;
                    diasComFaturamento++;
                }
            }
            
            // Passo 3: Calcular a média dos dias com faturamento
            double media = soma / diasComFaturamento;
            
            // Passo 4: Contar os dias que tiveram faturamento superior à média
            int diasAcimaDaMedia = 0;
            for (int i = 0; i < faturamentos.length(); i++) {
                double valor = faturamentos.getJSONObject(i).getDouble("faturamento");
                if (valor > media) {
                    diasAcimaDaMedia++;
                }
            }
            
            // Exibir os resultados
            System.out.printf("Menor valor de faturamento: R$ %.2f\n", menorValor);
            System.out.printf("Maior valor de faturamento: R$ %.2f\n", maiorValor);
            System.out.printf("Média de faturamento: R$ %.2f\n", media);
            System.out.println("Número de dias com faturamento superior à média: " + diasAcimaDaMedia);
            
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
