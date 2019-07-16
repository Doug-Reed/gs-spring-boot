package biz.casino.slot.reelStripper;

import java.util.ArrayList;


public class ReelFragmentListMaker{
    private ArrayList<ReelFragment> reelFragments = new ArrayList<ReelFragment>();
    private ArrayList<ReelFragment> masterList = new ArrayList<ReelFragment>();
    private String wild = "???UNKNOWN";

    private class WildFragment extends ReelFragment{
        @Override
        public String getSymbol(){
            return "WILD";
        }

        @Override
        public int size(){
            return 0;
        }

    }

    public String listPrint() {
        StringBuffer buf = new StringBuffer();
        for(ReelFragment rf: masterList){
            buf.append(rf.toString() + " : ");
        }
        return buf.toString();
    }

    public void addReelFragment(ReelFragment fragment) {
        System.out.println("Adding " + fragment.toString() + " to list maker.");
        reelFragments.add(fragment);
    }

    public ArrayList<ReelFragment> makeMaster() {
        System.out.println("Starting makeMaster " );
        masterList.addAll(reelFragments);
        for(ReelFragment rf: reelFragments) {
            System.out.println("Fetching " + rf.toString());
            compareToList(rf);
        }

        return masterList;
    }

    public ReelFragmentListMaker() {
        masterList.add(new WildFragment());
    }

    public ReelFragment oneFragmentToRuleThemAll(){
        ReelFragment retVal = new ReelFragment();
        for(ReelFragment rf:masterList) {
            if(rf instanceof WildFragment) {

            } else {
                rf.startSearch();
                for(int i =0; i<rf.size(); i++){
                    rf.setSearchIndex(i);
                    String s = rf.getSymbol();
                    retVal.addSymbol(s);
                }
            }
        }
        return retVal;
    }

    private void compareToList(ReelFragment fragment) {
        ReelFragmentMatcher rfm = new ReelFragmentMatcher();

        int ind = 0;
        for(ReelFragment x:masterList){
            System.out.println("In THe LOOP " + ind);
            System.out.println("MasterList = " + masterList.size());
            
            ReelFragment rf = masterList.get(ind);
            ind++;
            if(rf instanceof WildFragment){
                System.out.println("wild");

            } else {
                System.out.println("Compare " + fragment.toString() + " to " + rf.toString());
                if(fragment.toString().equalsIgnoreCase(rf.toString())){
                    System.out.println("Punt");
                } else {
                ReelFragment keith = rfm.doIMatch(fragment, rf);
                if(keith.size() > fragment.size()) {
                     System.out.println("Replacing " + rf.toString() + " with " + keith.toString());
                     masterList.set(ind, keith);
                } else {
                    System.out.println("Adding " + rf.toString() + " to masterList");
                    //masterList.add(new WildFragment());
                    masterList.add(rf);
                    //masterList.add(new WildFragment());
                }
            }
            }
        }


    }

    
}