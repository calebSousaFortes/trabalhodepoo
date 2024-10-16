package ImpostoDeRenda;

import java.util.Scanner;

public class ImpostoDeRenda {

    public static double calcularImpostoSalario(double rendaAnual) {
        double rendaMensal = rendaAnual / 12;
        if (rendaMensal < 3000) {
            return 0;
        } else if (rendaMensal < 5000) {
            return rendaAnual * 0.10;
        } else {
            return rendaAnual * 0.20;
        }
    }

    public static double calcularImpostoServico(double rendaServico) {
        return rendaServico * 0.15;
    }

    public static double calcularImpostoGanhoCapital(double rendaCapital) {
        return rendaCapital * 0.20;
    }

    public static double calcularDeducoes(double impostoBruto, double gastosMedicos, double gastosEducacionais) {
        double gastosDedutiveis = gastosMedicos + gastosEducacionais;
        double maximoDedutivel = impostoBruto * 0.30;
        return Math.min(maximoDedutivel, gastosDedutiveis);
    }

    public static void gerarRelatorio(
        double rendaSalario, double rendaServico, double rendaCapital, 
        double gastosMedicos, double gastosEducacionais
    ) {
        // Cálculo dos impostos
        double impostoSalario = calcularImpostoSalario(rendaSalario);
        double impostoServico = calcularImpostoServico(rendaServico);
        double impostoGanhoCapital = calcularImpostoGanhoCapital(rendaCapital);

        // Cálculo do imposto bruto total
        double impostoBrutoTotal = impostoSalario + impostoServico + impostoGanhoCapital;

        // Cálculo das deduções
        double abatimento = calcularDeducoes(impostoBrutoTotal, gastosMedicos, gastosEducacionais);

        // Cálculo do imposto devido
        double impostoDevido = impostoBrutoTotal - abatimento;

        // Geração do relatório
        System.out.println("### RELATÓRIO DE IMPOSTO DE RENDA ###");
        System.out.println("* CONSOLIDADO DE RENDA:");
        System.out.printf("Imposto sobre salário: %.2f%n", impostoSalario);
        System.out.printf("Imposto sobre serviços: %.2f%n", impostoServico);
        System.out.printf("Imposto sobre ganho de capital: %.2f%n", impostoGanhoCapital);
        System.out.println("* DEDUÇÕES:");
        System.out.printf("Máximo dedutível: %.2f%n", impostoBrutoTotal * 0.30);
        System.out.printf("Gastos dedutíveis: %.2f%n", gastosMedicos + gastosEducacionais);
        System.out.println("* RESUMO:");
        System.out.printf("Imposto bruto total: %.2f%n", impostoBrutoTotal);
        System.out.printf("Abatimento: %.2f%n", abatimento);
        System.out.printf("Imposto devido: %.2f%n", impostoDevido);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada de dados
        System.out.print("Renda anual com salário: ");
        double rendaSalario = scanner.nextDouble();

        System.out.print("Renda anual com prestação de serviço: ");
        double rendaServico = scanner.nextDouble();

        System.out.print("Renda anual com ganho de capital: ");
        double rendaCapital = scanner.nextDouble();

        System.out.print("Gastos médicos: ");
        double gastosMedicos = scanner.nextDouble();

        System.out.print("Gastos educacionais: ");
        double gastosEducacionais = scanner.nextDouble();

        // Geração do relatório
        gerarRelatorio(rendaSalario, rendaServico, rendaCapital, gastosMedicos, gastosEducacionais);

        scanner.close();
    }
}
