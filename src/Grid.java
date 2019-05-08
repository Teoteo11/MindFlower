public class Grid {
    private int[][] Grid=new int[9][9];
    public int[][] mine;

    public void uncoverGrid() {
        int x,y;
        for(int[] i : this.mine){
            x=i[0];
            y=i[1];
            if (x - 1 >= 0)
                this.Grid[x - 1][y]++;
            if (x - 1 >= 0 && y - 1 >= 0)
                this.Grid[x - 1][y - 1]++;
            if (y - 1 >= 0)
                this.Grid[x][y - 1]++;
            if (x - 1 >= 0 && y + 1 < this.Grid.length)
                this.Grid[x - 1][y + 1]++;
            if (x + 1 < this.Grid.length)
                this.Grid[x + 1][y]++;
            if (y + 1 < this.Grid.length && x + 1 < this.Grid.length)
                this.Grid[x + 1][y + 1]++;
            if (y + 1 < this.Grid.length)
                this.Grid[x][y + 1]++;
            if (x + 1 < this.Grid.length && y-1>=0)
                this.Grid[x + 1][y - 1]++;
        }
        for(int[]i : this.mine) {
            x=i[0];
            y=i[1];
            this.Grid[x][y]=-1;
        }
    }

    public void addMine(int s,int x,int y) throws Exception {
        if(x<0 || x>this.Grid.length && y<0 || y>this.Grid.length){
            for(int j=0;j<s;j++) {
                if(x==this.mine[j][0] && y==this.mine[j][1])
                    throw new Exception("Value already exists");
            }
            this.mine[s][0]=x;
            this.mine[s][1]=y;
            this.Grid[x][y]=-1;
        }
        else
            throw new Exception("Value not correct");
    }

    public void insertMine(int num) throws Exception{
        if(num==0)
            throw new Exception ("Alert! You insert 0 mine");
        else if(num<=this.Grid.length*this.Grid.length)
            this.mine=new int[num][2];
        for(int i=0;i<num;i++)
            for(int j=0;j<2;j++)
                this.mine[i][j]=-1;
    }

    public int clickAt(int x,int y){
        return this.Grid[x][y];
   }

    @Override
    public String toString() {
        StringBuilder s= new StringBuilder();
        for(int i=this.Grid.length-1;i>=0;i--) {
            for (int j = 0; j < this.Grid[i].length; j++)
                if(j<this.Grid[i].length-1) s.append(" ").append(this.Grid[j][i]).append(" |");
                else s.append(" ").append(this.Grid[j][i]);


            if(i<this.Grid[i].length) s.append("\n-----------------------------------\n");
        }
        return s.toString();
    }
}

