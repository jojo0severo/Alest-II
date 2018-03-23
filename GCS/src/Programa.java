
import java.util.Scanner;

public class Programa {

    static Robot fofo;
    static String nrobo;
    static int count = 0;
    static int xArea;
    static int yArea;
    static String area;
    static String var = "";
    static boolean sair = false;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        nrobo = "robo";


        System.out.println("Informe o tamanho da área que sera percorrida");
        area = in.nextLine();

        criaRobot();


        while (true) {
            if(sair){
                System.out.println("Se deseja sair digite 'sair'");
                String sairS = in.next();
                if(sairS.equalsIgnoreCase("sair")){
                    System.out.println("Bye Bye");

                    return;
                }
                sair = false;
            }
            else {
                criaRobot();
            }
        }
    }

    private static void criaRobot() {
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner (System.in);

        if(!sair){
            sair = true;
        }

        System.out.println("Informe a posição inicial (x e y) para o robozinho fofo");
        String xy = in.nextLine();

        System.out.println("Informe a direção inicial (N, S, L ou O)");
        Robot.Direcao dir = Robot.Direcao.valueOf(in.next());

        String[] valores = xy.split(" ");

        int x = Integer.parseInt(valores[0]);
        int y = Integer.parseInt(valores[1]);

        xArea = Integer.parseInt(area.split(" ")[0]);
        yArea = Integer.parseInt(area.split(" ")[1]);

        fofo = new Robot(x, y, dir, xArea, yArea);

        System.out.println(fofo+"\n");

        var = "";

        System.out.println("Insira os movimentos");
        var = in2.nextLine();

        moveRobo(var);

        System.out.println("\n\n\n\n\n\n"+fofo+"\n\n\n\n\n\n");

    }

    private static void moveRobo(String movimentos) {
        String[] mov = movimentos.split(" ");

        for (int i = 0; i < mov.length; i++) {
            if (mov[i].equals("L")) {
                switch (fofo.getDir()) {
                    case N:
                        fofo.setDir(Robot.Direcao.O);
                        break;
                    case L:
                        fofo.setDir(Robot.Direcao.N);
                        break;
                    case O:
                        fofo.setDir(Robot.Direcao.S);
                        break;
                    case S:
                        fofo.setDir(Robot.Direcao.L);
                        break;
                }
            } else if (mov[i].equals("R")) {
                switch (fofo.getDir()) {
                    case N:
                        fofo.setDir(Robot.Direcao.L);
                        break;
                    case L:
                        fofo.setDir(Robot.Direcao.S);
                        break;
                    case O:
                        fofo.setDir(Robot.Direcao.N);
                        break;
                    case S:
                        fofo.setDir(Robot.Direcao.O);
                        break;
                }
            } else if (mov[i].equals("M")) {
                if (!fofo.anda()) {
                    System.out.println("Houston, temos um problema");
                    return;
                }

            } else {
                System.out.println("Caractere nao reconhecido");
            }
        }
    }
}