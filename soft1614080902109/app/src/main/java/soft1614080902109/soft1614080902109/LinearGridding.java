package soft1614080902109.soft1614080902109;

import java.sql.Array;
import java.util.Arrays;

/**
 * Created by hasee on 2018/5/31.
 */

public class LinearGridding {
    private int n;
    private int maxN;
    private int weight;
    private LinearGridding[] son;
    private String value;
    public LinearGridding(){
        n = 1;
        maxN = 1;
        weight = 1;
        value = " ";

    }

    public void setValue(String value) {
        this.value = value;
    }
    public void setMaxN(int maxN){
        this.maxN = maxN;
        if(son!=null)son = Arrays.copyOf(son,maxN);
        else son = new LinearGridding[maxN];
    }
    public void setN(int n) {
        if(n>maxN){
            setMaxN(maxN*2);
        }
        this.n = n;
    }

    public int getN() {

        return n;
    }

    public int getMaxN() {
        return maxN;
    }
}
