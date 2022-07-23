/*Faça um programa que receba a temperatura média os 6 primeiros meses do ano e armazene-as em uma lista.
Após isto, calcule a média semestral das temperaturas e mostre todas as temperaturas acima desta média,
e em que mês elas ocorreram (mostrar o mês por extenso: 1 – Janeiro, 2 – Fevereiro e etc).
*/


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ExercicioProposto01 {
    public static <Interator> void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Double> ExercicioProposto01 = new ArrayList<>();

        int count = 0;
        while (true){
            if (count == 6) break;

            System.out.print("Digite a temperatura: ");
            double temp = scan.nextDouble();
            ExercicioProposto01.add(temp);
            count++;

        }
        System.out.println("---------------");

        System.out.println("Todas as temperaturas: ");
        ExercicioProposto01.forEach(t -> System.out.println(t + " "));
        
        double media = ExercicioProposto01.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0d);
        System.out.println("\nMédia de temperatura semesttral\n" + media);


        System.out.println("Temperaturas acima da média: ");
        Iterator<Double> iterator = ExercicioProposto01.iterator();
        while (iterator.hasNext()){
            Double next = iterator.next();
            if(next < media) iterator.remove();
        }
        System.out.println(ExercicioProposto01);
        System.out.println("\n\nMeses das temperaturas acima da média");
        Iterator<Double> iterator1 = ExercicioProposto01.iterator();

        count = 0;
        while (iterator1.hasNext()){
            Double temp = iterator1.next();
            if (temp > media){
                switch (count){
                    case (0):
                        System.out.printf("1 - Janeiro: %1f\n", temp);
                        break;
                        case (1):
                        System.out.printf("2 - Fevereiro: %1f\n", temp);
                        break;
                        case (2):
                        System.out.printf("3 - Março: %1f\n", temp);
                        break;
                        case (3):
                        System.out.printf("4 - Abril: %1f\n", temp);
                        break;
                        case (4):
                        System.out.printf("5 - Maio: %1f\n", temp);
                        break;
                        case (5):
                        System.out.printf("6 - Junho: %1f\n", temp);
                        break;
                    default:
                        System.out.println("Não houve temperatura acima da média");
                }
            }
            count++;
        }
    }
}
