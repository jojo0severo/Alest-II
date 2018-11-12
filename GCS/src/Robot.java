public class Robot {

    private int x;
    private int y;
    private int min;
    private int max;
    private DIRECTION direction;
    static enum DIRECTION {N, S, L, O}

    public Robot(int x, int y, DIRECTION d, int max, int min){
        this.x = x;
        this.y = y;
        this.direction = d;
        this.max = max;
        this.min = min;
    }

    public boolean move(){
        switch(direction){
            case N:
                if (this.x + 1 > max)
                    return false;

                this.x += 1;break;

            case L:
                if (this.y + 1 > max)
                    return false;

                this.y +=1; break;

            case S:
                if (this.x - 1 < min)
                    return false;

                this.x -= 1; break;

            case O:
                if (this.y - 1 < min)
                    return false;

                this.y -= 1; break;
        }

        return true;
    }

    public void setDirection(String d){
        switch (direction){
            case N:
                if (d.equalsIgnoreCase("left"))
                    this.direction = DIRECTION.O;

                else if (d.equalsIgnoreCase("right"))
                    this.direction = DIRECTION.L;

            case L:
                if (d.equalsIgnoreCase("left"))
                    this.direction = DIRECTION.N;

                else if (d.equalsIgnoreCase("right"))
                    this.direction = DIRECTION.S;

            case S:
                if (d.equalsIgnoreCase("left"))
                    this.direction = DIRECTION.L;

                else if (d.equalsIgnoreCase("right"))
                    this.direction = DIRECTION.O;

            case O:
                if (d.equalsIgnoreCase("left"))
                    this.direction = DIRECTION.S;

                else if (d.equalsIgnoreCase("right"))
                    this.direction = DIRECTION.N;

        }
    }


    public String toString(){
        return "Coordenadas: " + x + " " + y + "\nDirecao: " + direction;
    }
}
