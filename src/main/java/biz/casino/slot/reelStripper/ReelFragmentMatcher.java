package biz.casino.slot.reelStripper;

import java.util.ArrayList;

public class ReelFragmentMatcher {
    private String wild = "WILD";
    private ArrayList<ReelFragment> rawData;
    private ArrayList<ReelFragment> levelTwo = new ArrayList<ReelFragment>();
    private int reelFragmentSize = 3;
    private int reelFragmentMatchTolerance = 2;

    public void setReelFragmentSize(int reelFragmentSize ){
        this.reelFragmentSize = reelFragmentSize;
    }

    public void setReelFragmentMatchTolerance(int reelFragmentMatchTolerance){
        this.reelFragmentMatchTolerance = reelFragmentMatchTolerance;
    }

    public ReelFragment doIMatch(ReelFragment searcher, ReelFragment searched){
        System.out.println("Searcher = " + searcher.toString());
        System.out.println("searched = " + searched.toString());
         searcher.startSearch();
         searched.startSearch();
         boolean potentialMatch = false;
         int substringCounter = 0;
         int searcherGraftPoint = 0;
         int searchedGraftPoint = 0;
         ReelFragment levelTwo = new ReelFragment();

         for(int i=0;i<reelFragmentSize;i++){
             System.out.println("SEARCHING - OUTER LOOP");
             String searchSymbol = searcher.getSymbol();
             System.out.println("Search symbol = " + searchSymbol);
             for(int j=0; j<searched.size(); j++) {
                System.out.println("    SEARCHING INNER LOOP"); 
                String searchedSymbol = searched.getSymbol();
                System.out.println("      Searching for " + searchedSymbol);
                if(searchedSymbol.equalsIgnoreCase(searchSymbol)){
                    System.out.println("--match--");
                    substringCounter++;
                    System.out.println("Substring counter = " + substringCounter);
                    if(!potentialMatch) {
                        potentialMatch = true;
                        searcherGraftPoint = i;
                        searchedGraftPoint = j;
                    }
                } else {
                    potentialMatch = false;
                }
             }
             searched.startSearch();
         }

         System.out.println("END search");

         if(substringCounter>= reelFragmentMatchTolerance) {
             System.out.println("Make new fragment");
              ReelFragment startFragment;
              ReelFragment endFragment;
              int startGraftPoint = 0;
              int endGraftPoint = 0;
              System.out.println("searcher graft: " + searcherGraftPoint + " Searched graft: " + searchedGraftPoint);
              if(searcherGraftPoint > searchedGraftPoint) {
                  startFragment = searcher;
                  endFragment = searched;
                  startGraftPoint = searcherGraftPoint;
                  endGraftPoint = searchedGraftPoint;
              } else {
                  startFragment = searched;
                  endFragment = searcher;
                  startGraftPoint = searchedGraftPoint;
                  endGraftPoint = searcherGraftPoint;
              }
              System.out.println("Starting sequence " + startFragment.toString());
              System.out.println("Ending sequence " + endFragment.toString());
              System.out.println("Start graft index " + startGraftPoint);
              System.out.println("End graft index " + endGraftPoint); 
              startFragment.startSearch();
              for(int i=0; i<startGraftPoint; i++ ){
                  levelTwo.addSymbol(startFragment.getSymbol());
                  System.out.println(levelTwo.toString());
              }

              endFragment.setSearchIndex(endGraftPoint);
              System.out.println("Appending ");
              for(int j = endGraftPoint+1; j<=reelFragmentSize; j++) {
                  levelTwo.addSymbol(endFragment.getSymbol());
                  System.out.println(levelTwo.toString());
              }

              return levelTwo;
         }
         System.out.println("No match");
         return searcher;
    }
    
    // dea
    // cde
    // bcd
    // eab
    // abc

    //1st pass

    /*
      WILD
      d
      e
      a
      WILD
      WILD
      c
      d
      e
      WILD 
      WILD
      b
      c
      d
      WILD
      WILD
      e
      a
      b
      WILD
      WILD
      a
      b
      c
      WILD

      dea looks for match, finds cde & eab
      cde & eab are surrounded by wilds

      WILD
        c
        d
        e
        a
        b
      WILD
    WILD
    b
    c
    d
    WILD
    WILD
    a
    b
    c
    WILD

    bcd looks for match, finds 2nd level string & abc surrounded by wilds

     WILD
        b
        c
        d
        e
        a
        b
        c
     WILD

    all 1st level strings processed
    trim duplicate on end of reel
    sanity check, do all 1st level strings fit?
      
    */
}