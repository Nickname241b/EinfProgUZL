public class Bauer extends Figur {
    public Bauer(int y, int x, boolean black) {
        super(x,y,black);
    }
    
    @Override
    public boolean checkMove(int x, int y) {
        int relX = getX() - x;
        int relY = getY() - y;
        
        // in bounds and goal null or not the same color 
        if(x < 8 && x >= 0 && y < 8 && y >= 0 && (Main.spielfeld[x][y] == null || Main.spielfeld[x][y].isBlack() != isBlack())) {
            if(isBlack()){
                //schwarzer Bauer schlägt  
                if(relX == -1 && Math.abs(relY) == 1) {
                    if(Main.spielfeld[x][y].isBlack() == isBlack() || Main.spielfeld[x][y] == null ){
                        return false;
                    }
                    else{
                        return true;
                    }
                }//schwarz 1 schritt nach vorne
                else if(relX == -1 && Math.abs(relY) == 0) {
                    if(Main.spielfeld[x][y] == null) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }// 1. zug 2
                else if(relX == -2 && Math.abs(relY) == 0 && getX() == 1) {
                    if(Main.spielfeld[x][y] == null && Main.spielfeld[x - 1][y] == null) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
            else if(!isBlack()) {
                // weiß schlägt
                if(relX == 1 && Math.abs(relY) == 1) {
                    if(!Main.spielfeld[x][y].isBlack() == !isBlack() || Main.spielfeld[x][y] == null){
                        return false;
                    }
                    else{
                        return true;
                    }
                }//weiß 1 schritt nach vorne
                else if(relX == 1 && Math.abs(relY) == 0) {
                    if(Main.spielfeld[x][y] == null) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }// 1. zug 2
                else if(relX == 2 && Math.abs(relY) == 0 && getX() == 6) {
                    if(Main.spielfeld[x][y] == null && Main.spielfeld[x + 1][y] == null) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        else {
            return false;
        }
    }
}
