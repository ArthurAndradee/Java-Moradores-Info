public class Morador {
    
    private int age;
    private String gender;
    private int salario;
    private static int totalSalario = 0;
    private static int count = 0;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        totalSalario += salario; 
        count++; 
        this.salario = salario;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static double getAverageSalary() {
        if (count == 0) {
            return 0; 
        }
        return (double) totalSalario / count; 
    }

    public static void resetStatistics() {
        totalSalario = 0;
        count = 0;
    }
}
