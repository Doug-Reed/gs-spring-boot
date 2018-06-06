package biz.casino.roulette.model;

import org.json.*;

public class Wheel {
    private WheelMode wheelMode = null;
    private WheelPocket[] wheelPockets;
    private String testString = "SINATRA";

    public String getTestString() {
        return testString;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }

    String numberArray = "{\"wheelPockets\":[" +
    " {\"name\":\"ZERO\", " +
    " \"color\":\"GREEN\", " + 
            " \"numberValue\":0," +
            " \"evenOdd\":\"Neither\", " +
            " \"americanWheelPosition\":0, " +
            " \"europeanWheelPosition\":0}, " +
    " {\"name\":\"ONE\", " +
            " \"color\":\"RED\", " +
            " \"numberValue\":1, " +
            " \"evenOdd\":\"ODD\", " +
            " \"americanWheelPosition\":18, " +
            " \"europeanWheelPosition\":23}, " +
    " {\"name\":\"TWO\", " +
            " \"color\":\"BLACK\", " +
            " \"numberValue\":2, " +
            " \"evenOdd\":\"EVEN\", " +
            " \"americanWheelPosition\":37, " +
            " \"europeanWheelPosition\":6}, " +
    " {\"name\":\"THREE\", " +
            " \"color\":\"RED\", " +
            " \"numberValue\":3, " +
            " \"evenOdd\":\"ODD\", " +
            " \"americanWheelPosition\":14, " +
            " \"europeanWheelPosition\":35}, " +
    " {\"name\":\"FOUR\", " +
            " \"color\":\"BLACK\", " +
            " \"numberValue\":4, " +
            " \"evenOdd\":\"EVEN\", " +
            " \"americanWheelPosition\":33, " +
            " \"europeanWheelPosition\":4}, " +
    " {\"name\":\"FIVE\", " +
            " \"color\":\"RED\", " +
            " \"numberValue\":5, " +
            " \"evenOdd\":\"ODD\", " +
            " \"americanWheelPosition\":10, " +
            " \"europeanWheelPosition\":19}, " +
    " {\"name\":\"SIX\", " +
            " \"color\":\"BLACK\", " +
            " \"numberValue\":6, " +
            " \"evenOdd\":\"EVEN\", " +
            " \"americanWheelPosition\":29, " +
            " \"europeanWheelPosition\":10}, " +
    " {\"name\":\"SEVEN\", " +
            " \"color\":\"RED\", " +
            " \"numberValue\":7, " +
            " \"evenOdd\":\"ODD\", " +
            " \"americanWheelPosition\":6, " +
            " \"europeanWheelPosition\":31}, " +
    " {\"name\":\"EIGHT\", " +
            " \"color\":\"BLACK\", " +
            " \"numberValue\":8, " +
            " \"evenOdd\":\"EVEN\", " +
            " \"americanWheelPosition\":25, " +
            " \"europeanWheelPosition\":16}, " +
    " {\"name\":\"NINE\", " +
            " \"color\":\"RED\", " +
            " \"numberValue\":9, " +
            " \"evenOdd\":\"ODD\", " +
            " \"americanWheelPosition\":2, " +
            " \"europeanWheelPosition\":27}, " +
    " {\"name\":\"TEN\", " +
            " \"color\":\"BLACK\", " +
            " \"numberValue\":10, " +
            " \"evenOdd\":\"EVEN\", " +
            " \"americanWheelPosition\":21, " +
            " \"europeanWheelPosition\":18}, " +
    " {\"name\":\"ELEVEN\", " +
            " \"color\":\"BLACK\", " +
            " \"numberValue\":11, " +
            " \"evenOdd\":\"ODD\", " +
            " \"americanWheelPosition\":5, " +
            " \"europeanWheelPosition\":14}, " +
    " {\"name\":\"TWELVE\", " +
            " \"color\":\"RED\", " +
            " \"numberValue\":12, " +
            " \"evenOdd\":\"EVEN\", " +
            " \"americanWheelPosition\":24, " +
            " \"europeanWheelPosition\":33}, " +
    " {\"name\":\"THIRTEEN\", " +
            " \"color\":\"BLACK\", " +
            " \"numberValue\":13, " +
            " \"evenOdd\":\"ODD\", " +
            " \"americanWheelPosition\":17, " +
            " \"europeanWheelPosition\":12}, " +
    " {\"name\":\"FOURTEEN\", " +
            " \"color\":\"RED\", " +
            " \"numberValue\":14, " +
            " \"evenOdd\":\"EVEN\", " +
            " \"americanWheelPosition\":36, " +
            " \"europeanWheelPosition\":25}, " +
    " {\"name\":\"FIFTEEN\", " +
            " \"color\":\"BLACK\", " +
            " \"numberValue\":15, " +
            " \"evenOdd\":\"ODD\", " +
            " \"americanWheelPosition\":13, " +
            " \"europeanWheelPosition\":2}, " +
    " {\"name\":\"SIXTEEN\", " +
            " \"color\":\"RED\", " +
            " \"numberValue\":16, " +
            " \"evenOdd\":\"EVEN\", " +
            " \"americanWheelPosition\":32, " +
            " \"europeanWheelPosition\":21}, " +
    " {\"name\":\"SEVENTEEN\", " +
            " \"color\":\"BLACK\", " +
            " \"numberValue\":17, " +
            " \"evenOdd\":\"ODD\", " +
            " \"americanWheelPosition\":9, " +
            " \"europeanWheelPosition\":8}, " +
    " {\"name\":\"EIGHTEEN\", " +
            " \"color\":\"RED\", " +
            " \"numberValue\":18, " +
            " \"evenOdd\":\"EVEN\", " +
            " \"americanWheelPosition\":28, " +
            " \"europeanWheelPosition\":29}, " +
    " {\"name\":\"NINETEEN\", " +
            " \"color\":\"RED\", " +
            " \"numberValue\":19, " +
            " \"evenOdd\":\"ODD\", " +
            " \"americanWheelPosition\":26, " +
            " \"europeanWheelPosition\":29}, " +
    " {\"name\":\"TWENTY\", " +
            " \"color\":\"BLACK\", " +
            " \"numberValue\":20, " +
            " \"evenOdd\":\"EVEN\", " +
            " \"americanWheelPosition\":7, " +
            " \"europeanWheelPosition\":24}, " +
    " {\"name\":\"TWENTY-ONE\", " +
            " \"color\":\"RED\", " +
            " \"numberValue\":21, " +
            " \"evenOdd\":\"ODD\", " +
            " \"americanWheelPosition\":30, " +
            " \"europeanWheelPosition\":5}, " +
    " {\"name\":\"TWENTY-TWO\", " +
            " \"color\":\"BLACK\", " +
            " \"numberValue\":22, " +
            " \"evenOdd\":\"EVEN\", " +
            " \"americanWheelPosition\":11, " +
            " \"europeanWheelPosition\":28}, " +
    " {\"name\":\"TWENTY-THREE\", " +
            " \"color\":\"RED\", " +
            " \"numberValue\":23, " +
            " \"evenOdd\":\"ODD\", " +
            " \"americanWheelPosition\":34, " +
            " \"europeanWheelPosition\":17}, " +
    " {\"name\":\"TWENTY-FOUR\", " +
            " \"color\":\"BLACK\", " +
            " \"numberValue\":24, " +
            " \"evenOdd\":\"EVEN\", " +
            " \"americanWheelPosition\":15, " +
            " \"europeanWheelPosition\":20}, " +
    " {\"name\":\"TWENTY-FIVE\", " +
            " \"color\":\"RED\", " +
            " \"numberValue\":25, " +
            " \"evenOdd\":\"ODD\", " +
            " \"americanWheelPosition\":22, " +
            " \"europeanWheelPosition\":7}, " +
    " {\"name\":\"TWENTY-SIX\", " +
            " \"color\":\"BLACK\", " +
            " \"numberValue\":26, " +
            " \"evenOdd\":\"EVEN\", " +
            " \"americanWheelPosition\":3, " +
            " \"europeanWheelPosition\":36}, " +
    " {\"name\":\"TWENTY-SEVEN\", " +
            " \"color\":\"RED\", " +
            " \"numberValue\":27, " +
            " \"evenOdd\":\"ODD\", " +
            " \"americanWheelPosition\":20, " +
            " \"europeanWheelPosition\":11}, " +
    " {\"name\":\"TWENTY-EIGHT\", " +
            " \"color\":\"BLACK\", " +
            " \"numberValue\":28, " +
            " \"evenOdd\":\"EVEN\", " +
            " \"americanWheelPosition\":1, " +
            " \"europeanWheelPosition\":32}, " +
    " {\"name\":\"TWENTY-NINE\", " +
            " \"color\":\"BLACK\", " +
            " \"numberValue\":29, " +
            " \"evenOdd\":\"ODD\", " +
            " \"americanWheelPosition\":23, " +
            " \"europeanWheelPosition\":30}, " +
    " {\"name\":\"THIRTY\", " +
            " \"color\":\"RED\", " +
            " \"numberValue\":30, " +
            " \"evenOdd\":\"EVEN\", " +
            " \"americanWheelPosition\":4, " +
            " \"europeanWheelPosition\":15}, " +
    " {\"name\":\"THIRTY-ONE\", " +
            " \"color\":\"BLACK\", " +
            " \"numberValue\":31, " +
            " \"evenOdd\":\"ODD\", " +
            " \"americanWheelPosition\":27, " +
            " \"europeanWheelPosition\":26}, " +
    " {\"name\":\"THIRTY-TWO\", " +
            " \"color\":\"RED\", " +
            " \"numberValue\":32, " +
            " \"evenOdd\":\"EVEN\", " +
            " \"americanWheelPosition\":8, " +
            " \"europeanWheelPosition\":1}, " +
    " {\"name\":\"THIRTY-THREE\", " +
            " \"color\":\"BLACK\", " +
            " \"numberValue\":33, " +
            " \"evenOdd\":\"ODD\", " +
            " \"americanWheelPosition\":31, " +
            " \"europeanWheelPosition\":22}, " +
    " {\"name\":\"THIRTY-FOUR\", " +
            " \"color\":\"RED\", " +
            " \"numberValue\":34, " +
            " \"evenOdd\":\"EVEN\", " +
            " \"americanWheelPosition\":12, " +
            " \"europeanWheelPosition\":9}, " +
    " {\"name\":\"THIRTY-FIVE\", " +
            " \"color\":\"BLACK\", " +
            " \"numberValue\":35, " +
            " \"evenOdd\":\"ODD\", " +
            " \"americanWheelPosition\":35, " +
            " \"europeanWheelPosition\":34}, " +
    " {\"name\":\"THIRTY-SIX\", " +
            " \"color\":\"RED\", " +
            " \"numberValue\":36, " +
            " \"evenOdd\":\"EVEN\", " +
            " \"americanWheelPosition\":16, " +
            " \"europeanWheelPosition\":13}, " +
    " {\"name\":\"DOUBLE-ZERO\", " +
            " \"color\":\"GREEN\", " +
            " \"numberValue\":37, " +
            " \"evenOdd\":\"neither\", " +
            " \"americanWheelPosition\":19," +
            " \"europeanWheelPosition\":null} " +
  "]}";

    public Wheel() {
        setWheelMode(WheelMode.AMERICAN);
        JSONObject wheel = new JSONObject(numberArray);
    }



    public WheelMode getWheelMode() {
        return wheelMode;
    }

    public void setWheelMode(WheelMode wm) {
        this.wheelMode = wm;
    }
}