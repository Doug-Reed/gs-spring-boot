package biz.casino.slot.reelStripper;

import java.util.ArrayList;

public class ReelFragment {
    private long groupID;
    private ArrayList<String> symbols = new ArrayList<String>();
    private int index = 0;

    
    public ReelFragment() {
        this.groupID = System.currentTimeMillis();
    }
    
    public void addSymbol(String symbol){
        this.symbols.add(symbol);
    }

    public void startSearch(){
          index = 0;
    }

    public void setSearchIndex(int newIndex) {
        this.index = newIndex;
    }

    public String getSymbol(){
        try{
            String retVal = symbols.get(index);
            index++;
            return retVal;
        } catch (Exception e) {
            System.out.println("INDEX exception");
            return null;
        }
    }

    public int size(){
        return symbols.size();
    }

    public String toString(){
        StringBuffer buffer = new StringBuffer();
        for (String s: symbols) {
              buffer.append(s + " ");
        }
        return buffer.toString();
    }

}