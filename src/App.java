import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner read = new Scanner(System.in);

        int age = 0;
        int salario;
        String gender;

        ArrayList<Morador> moradores = new ArrayList<Morador>();
        do {
            System.out.println("Insira próximo morador: ");
        
            Morador m = new Morador();
            
            System.out.print("Idade: ");
            age = read.nextInt();
            
            if (age > 0) {
                System.out.print("Salário: ");
                salario = read.nextInt();
            
                System.out.print("Sexo (M/F): ");
                gender = read.next();
            
                m.setAge(age);
                m.setSalario(salario);
                m.setGender(gender);;
            
                moradores.add(m);
                read.nextLine(); // clear the buffer
            }
            
        } while (age > 0);

        //Calcular média dos salários
        double averageSalary = Morador.getAverageSalary();
        
        //Requisitar maior valor e menor valor do atributo idade
        int maxAge = Integer.MIN_VALUE;
        int minAge = Integer.MAX_VALUE;
        for (Morador morador : moradores) {
            int idade = morador.getAge();
            if (idade > maxAge) {
                maxAge = idade;
            }
            if (idade < minAge) {
                minAge = idade;
            }
        }

        //Calcular porcentagem de mulheres com salário acima de 3000
        int countFemale = 0;
        int countSalarioOver3000 = 0;
        for (Morador morador : moradores) {
            if (morador.getGender().equalsIgnoreCase("F")) {
                countFemale++;
                if (morador.getSalario() > 3000) {
                    countSalarioOver3000++;
                }
            }
        }

        double percentage = 0.0;
        if (countFemale > 0) {
            percentage = ((double) countSalarioOver3000 / countFemale) * 100;
        }

        //Calcular total de homens
        int countMale = 0;
        for (Morador morador : moradores) {
            if (morador.getGender().equalsIgnoreCase("M")) {
                countMale++;
            }
        }
        
        System.out.println("Média dos salários: " + averageSalary);
        System.out.println("Maior idade: " + maxAge);
        System.out.println("Menor idade: " + minAge);
        System.out.println("Porcentagem de mulheres com salário acima de 3000 " + percentage + "%");
        System.out.println("Total de homens: " + countMale);
    }
}
