import java.util.HashMap;
import java.util.Scanner;

public class Programa {

    static Robot fofo;
    public static HashMap<String, String> robos;
    static String nrobo;
    static int count = 0;
    static int xArea;
    static int yArea;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        nrobo = "robo";
        robos = new HashMap<>();

        String var = "";

        criaRobot();

        System.out.println("Digite 'sair' para sair do programa");
        System.out.println("Informe o tamanho da área que sera percorrida");
        String area = in.nextLine();

        xArea = Integer.parseInt(area.split(" ")[0]);
        yArea = Integer.parseInt(area.split(" ")[1]);

        while (var != "sair") {
            System.out.println("Insira os movimentos");
            var = in.nextLine();

            moveRobo(var);

            System.out.println("Digite 'outro' para adicionar um robozinho fofo");
            var = in.nextLine();

            if (var.equals("outro")) {
                criaRobot();
            }
        }
    }

    private static void criaRobot() {
        Scanner in = new Scanner(System.in);

        System.out.println("Informe a posição inicial (x e y) para o robozinho fofo");
        String xy = in.nextLine();

        System.out.println("Informe a direção inicial (N, S, L ou O)");
        Robot.Direcao dir = Robot.Direcao.valueOf(in.next());

        String[] valores = xy.split(" ");

        int x = Integer.parseInt(valores[0]);
        int y = Integer.parseInt(valores[1]);

        fofo = new Robot(x, y, dir, xArea, yArea);

        String coord = x + "" + y;
        nrobo = nrobo + count;
        robos.put(coord, nrobo);
        count++;
    }

    private static void moveRobo(String movimentos) {
        String[] mov = movimentos.split(" ");

        for (int i = 0; i < mov.length; i++) {
            if (mov[i].equals("L")) {
                fofo.setDir(Robot.Direcao.valueOf("L"));
            } else if (mov[i].equals("O")) {
                fofo.setDir(Robot.Direcao.valueOf("O"));
            } else if (mov[i].equals("N")) {
                fofo.setDir(Robot.Direcao.valueOf("N"));
            } else if (mov[i].equals("S")) {
                fofo.setDir(Robot.Direcao.valueOf("S"));
            } else if (mov[i].equals("M")) {
                if (!fofo.anda(Integer.parseInt(mov[i]))) {
                    System.out.println("Houston, temos um problema");
                    return;
                }

            } else {
                System.out.println("Caractere nao reconhecido");
            }
        }
    }
}
