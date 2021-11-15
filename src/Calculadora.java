import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculadora {

    int a;
    int b;
    int operador;

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getOperador() {
        return operador;
    }

    public void setOperador(int operador) {
        this.operador = operador;
    }

    public void digite_a() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite el primer número entero: ");
        try {
            setA(scanner.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("Error en el método --> (digite_a): No digitó un número entero. Se escribirá un 0 en el lugar del primer número.");
            setA(0);
        }
    }

    public void digite_b() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite el segundo número entero: ");
        try {
            setB(scanner.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("Error en el método --> (digite_b): No digitó un número entero. Se escribirá un 0 en el lugar del segundo número.");
            setB(0);
        }
    }

    public void seleccionar_Operador() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. +");
        System.out.println("2. -");
        System.out.println("3. *");
        System.out.println("4. /");
        System.out.print("Digite el operador: ");
        try {
            setOperador(scanner.nextInt());
            if (getOperador()<1 || getOperador()>4) {
                throw new IllegalArgumentException("El número digitado debe estar entre 1 y 4.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error en el método --> (seleccionar_Operador): No digitó un número entero.");
            setOperador(1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error en el método --> (seleccionar_Operador): " + e + " Se realizará la operación de suma por defecto.");
            setOperador(1);
        } finally {
            System.out.println("*** Si desea realizar otra operación reinicie el programa ***");
        }
    }

    public int calcular() {
        if (getOperador() == 1) {
            return a+b;
        } else if (getOperador() == 2) {
            return a-b;
        }
        else if (getOperador() == 3) {
            return a*b;
        }
        else if (getOperador() == 4) {
            return a/b;
        }
        return 0;
    }

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        calculadora.digite_a();
        calculadora.digite_b();
        calculadora.seleccionar_Operador();
        System.out.println("El resultado de la operación es:"+ calculadora.calcular());
    }

}
