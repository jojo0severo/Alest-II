public class App {
    public static void main(String[] args) {
        Robot r = new Robot(0, 1, Robot.DIRECTION.N, 10, 0);

        String movements = "MMMLMMMRMLMRMLLLM";

        for (Character c: movements.toCharArray()){
            if (c == 'M'){
                r.move();
            }
            else if(c == 'L'){
                r.setDirection("left");
            }
            else if(c == 'R'){
                r.setDirection("right");
            }
        }

        System.out.println(r.toString());
    }
}
