import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("---------- Sistema de cadastro de funcionarios ---------- ");
        System.out.println("Informe o nome do funcionario: ");
        String name = input.nextLine();
        System.out.println("Informe o cargo: ");
        String carge = input.nextLine();
        System.out.println("Informe o salario do funcionario: ");
        double sal = input.nextDouble();
        
        Funcionario cadastro = new Funcionario(name, carge, sal); 
        cadastro.MostrarDados();
        
        System.out.println("Deseja fazer um rejuste no salario do funcionario: " + cadastro.getNome() + " (s/n)? ");
        String reajuste = input.next();
        
        if(reajuste.equalsIgnoreCase("s")){
            System.out.println("Informe o valor do reajuste: ");
            double valor = input.nextDouble();
            cadastro.aumentarSalario(valor);
            System.out.println("Salario atualizado: " + cadastro.getSalario());
        }
        
        input.close();
	}
}

class Funcionario { // classe funcionario
    private String nome;
    private String cargo;
    private double salario;
    
    public Funcionario(String nomefun, String cargofun, double salariofun) { // construtor
        this.nome = nomefun;
        this.cargo = cargofun;
        this.salario = salariofun;
    }
    // Metodos especiais
    
    public String getNome(){
        return this.nome;
    }
    
    public String getCargo(){
        return this.cargo;
    }
    
    public double getSalario(){
        return this.salario;
    }
    // Metodo publicos
    public void aumentarSalario(double porcentagem){
        if(porcentagem > 0){
            this.salario += this.salario * (porcentagem/ 100);
            System.out.println("Aumento realizado!");
        }else{
            System.out.println("Erro: a porcentagem dever ser positiva.");
        }
    }
    
    public void MostrarDados(){
        System.out.println("Nome: " + this.nome + "| Cargo: " + this.cargo + "| Salario: R$ " + this.salario);
    }
}
