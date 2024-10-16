package BarConta;

import java.util.Scanner;

public class BarConta {
	
    public static void main(String[] args) {
        // Definindo os preços
        final double PRECO_INGRESSO_HOMEM = 10.00;
        final double PRECO_INGRESSO_MULHER = 8.00;
        final double PRECO_CERVEJA = 5.00;
        final double PRECO_REFRIGERANTE = 3.00;
        final double PRECO_ESPETINHO = 7.00;
        final double PRECO_COUVERT = 4.00;

        // Criando o Scanner para entrada de dados
        Scanner scanner = new Scanner(System.in);

        // Lendo os dados do cliente
        System.out.print("Sexo (F ou M): ");
        char sexo = scanner.next().trim().toUpperCase().charAt(0);

        System.out.print("Quantidade de cervejas: ");
        int qtdCervejas = scanner.nextInt();

        System.out.print("Quantidade de refrigerantes: ");
        int qtdRefrigerantes = scanner.nextInt();

        System.out.print("Quantidade de espetinhos: ");
        int qtdEspetinhos = scanner.nextInt();

        // Calculando o consumo total
        double consumo = (qtdCervejas * PRECO_CERVEJA) +
                         (qtdRefrigerantes * PRECO_REFRIGERANTE) +
                         (qtdEspetinhos * PRECO_ESPETINHO);

        // Verificando se há isenção do couvert
        double couvert = consumo > 30.00 ? 0.00 : PRECO_COUVERT;

        // Definindo o valor do ingresso com base no sexo
        double ingresso = (sexo == 'M') ? PRECO_INGRESSO_HOMEM : PRECO_INGRESSO_MULHER;

        // Calculando o valor total a pagar
        double valorTotal = consumo + couvert + ingresso;

        // Exibindo o relatório
        System.out.println("\nRELATÓRIO:");
        System.out.printf("Consumo = R$ %.2f%n", consumo);
        if (couvert == 0.00) {
            System.out.println("Isento de Couvert");
        } else {
            System.out.printf("Couvert = R$ %.2f%n", couvert);
        }
        System.out.printf("Ingresso = R$ %.2f%n", ingresso);
        System.out.printf("Valor a pagar = R$ %.2f%n", valorTotal);

        // Fechando o scanner
        scanner.close();
    }
}
