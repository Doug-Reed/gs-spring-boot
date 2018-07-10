package hello;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import java.util.ArrayList;

import java.util.Random;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);


        String config;
        String statLine;
        ArrayList<String> statLineLibrary = new ArrayList<String>();


        double tripsTakenToVegas = 0;

        int wicketsWon=0;
        int wicketsLost=0;

        int daysPlayed;
        int gamesPlayedToday=0;

        int todaysTotal=0;

        int gamesPlayed = 0;
        int possibleGamesPerTrip;
        int overtimeGames;

        int spun = 0;
        int rawSpins = 0;


        int bet;


        int chipsOnBoard;

        int bank;

        int consecutiveLosses = 0;
        int totalConsecutiveLosses = 0;
        int consecutiveLossRecord = 0;

        int schroedingersWin = 0;
        int schroedingersLoss = 0;

        int wicketWinnings = 0;
        int totalWicketWins = 0;
        int totalWicketLosses = 0;
        int gameWinnings = 0;
        int gameStartingCash=0;

        double walkAwayTolerance;
        int lowPoint = 0;
        int lowestLowPoint = 0;

        int tripTotal = 0;
        int bestGame = 0;
        int worstGame = 0;

        int supremeTotal=0;
        double losingWeeks = 0;
        int losingWeekAmount=0;
        int winningWeeks=0;
        int winningWeekAmount=0;
        int worstWeek = 100000;
        int bestWeek=0;


        //Number of games config
        int overtimeTolerance = 0;
        double tripsToVegas = 150;
        int possibleGamesPerDay=1;
        int daysPerTrip = 1;

        //money config
        boolean bankResetMode = false;
        int bankStartingCash;

        //Game Config
        int chipsOnBoardDefault = 5;
        int betDefault = 5;
        int perGameSpinCount = 200;
        int fatigue = 400;
        int cutAndRun = 9;
        int numberOfWicketsLossTolerance = 1;
        double quitThisGameInTriumph;
        int standPat = 0;

        //Reporting Config
        boolean spinMode = false;
        boolean gameMode = true;
        boolean weekMode = false;
        boolean statsMode = true;

        double winToleranceMultiplier = 1.6;
        double lossToleranceMultiplier = 7;
        int startingCashMultiplier =1300;


        bankStartingCash = betDefault * 3000;
        System.out.println("STARTING CASH NEEDED " + bankStartingCash);
        bank = bankStartingCash;
        config = "bet= " + betDefault + " spins per game= " + perGameSpinCount;
        lowestLowPoint = 0;

        int wicketLoss = 0;

        //Calculate wicket loss
        for(int i=1; i <= cutAndRun; i++){
            int increment = i * betDefault;
            int bonus = i-chipsOnBoardDefault;
            wicketLoss+=increment*chipsOnBoardDefault;
            if(bonus>0){
                wicketLoss+=bonus*increment;
            }
        }
        if(standPat>0) {
            wicketLoss+=standPat*betDefault*chipsOnBoardDefault;
        }


        walkAwayTolerance = wicketLoss * 10;
        quitThisGameInTriumph = (wicketLoss * 10);
        System.out.println("Wicket value = " + wicketLoss);
        System.out.println("LOSS TOLERANCE = " + walkAwayTolerance);
        System.out.println(("WIN TOLERANCE = ") + quitThisGameInTriumph);


        //Trip loop
        while (tripsTakenToVegas < tripsToVegas) {


            gamesPlayed = 0;
            tripTotal = 0;
            bestGame = 0;
            worstGame = 100000;
            overtimeGames = 0;
            possibleGamesPerTrip = possibleGamesPerDay*daysPerTrip;
            daysPlayed=0;

            if(bankResetMode) {
                bank = bankStartingCash;
            }
            //Game Loop
            while (gamesPlayed < possibleGamesPerTrip) {

                if(gamesPlayedToday==possibleGamesPerDay){
                    daysPlayed++;
                    if(weekMode && overtimeGames==0) {
                        System.out.println("Day " + daysPlayed + " total " + todaysTotal);
                        gamesPlayedToday = 0;
                        todaysTotal = 0;
                    }
                }

                gamesPlayed++;
                gamesPlayedToday++;
                spun = 0;
                bet = betDefault;
                chipsOnBoard = chipsOnBoardDefault;
                consecutiveLossRecord = 0;
                lowPoint = 0;
                rawSpins = 0;
                int standPatAt=0;

//Spin loop
                while (spun <  perGameSpinCount) {
                    spun++;
                    rawSpins++;
                    Random rand = new Random();
                    int spin = rand.nextInt(36);

                    schroedingersWin = ((bet * 35) - ((chipsOnBoard - 1) * bet));
                    schroedingersLoss = (bet * chipsOnBoard) * -1;

                    if(spin==0) {
                        spin=0;
                    }

                    if(spin==37){
                        spin=37;
                    }

                    if (spin < chipsOnBoard) {
                        //WINNING
                        wicketsWon++;
                        bank+=schroedingersWin;
                        wicketWinnings = wicketWinnings + (schroedingersWin);
                        gameWinnings+=wicketWinnings;
                        totalWicketWins+=wicketWinnings;

                        if (gameWinnings > quitThisGameInTriumph) {
                            spun = perGameSpinCount;
                        }
                        if (totalConsecutiveLosses > consecutiveLossRecord) {
                            consecutiveLossRecord = totalConsecutiveLosses;
                        }
                        totalConsecutiveLosses = 0;
                        consecutiveLosses = 0;
                        standPatAt = 0;

                       if(spinMode){ System.out.println("win " + wicketWinnings + " Running total: " + gameWinnings + " Spins = " + rawSpins);}

                        if (wicketWinnings < 0 && spun == perGameSpinCount) {
                            spun = spun - chipsOnBoardDefault;
                        }

                        if(gameWinnings > 0 && spun > (perGameSpinCount * .90)){
                           spun = perGameSpinCount * 2;
                           if(spinMode) {System.out.println("call it a win");}
                        }

                        if(gameWinnings > quitThisGameInTriumph*.90) {
                            spun = perGameSpinCount * 2;
                            if(spinMode) {System.out.println("go buy a steak dinner");}
                        }

                        wicketWinnings = 0;
                        chipsOnBoard = chipsOnBoardDefault;
                        bet = betDefault;
                    } else {

                        //LOSING
                        bank+=schroedingersLoss;
                        if(bank<0){
                            if(!statsMode) {
                                System.out.println("FUUUUUUUUCK!!!!!!");
                                spun = perGameSpinCount;
                                gamesPlayed = possibleGamesPerTrip;
                                if (!bankResetMode) {
                                    tripsTakenToVegas = tripsToVegas;
                                }
                            }
                        }
                        consecutiveLosses++;
                        totalConsecutiveLosses++;
                        if (totalConsecutiveLosses > consecutiveLossRecord) {
                            consecutiveLossRecord = totalConsecutiveLosses;
                        }
                        wicketWinnings += schroedingersLoss;
                        if ((wicketWinnings + gameWinnings) < lowPoint) {
                            lowPoint = gameWinnings+ wicketWinnings;
                        }
                        if(standPatAt < standPat) {
                            standPatAt++;
                        }else{
                            bet = bet + betDefault;
                        }

                        if (spun == perGameSpinCount) {
                            spun--;
                        }
                    }

                    //Wicket - cut and run
                    if (consecutiveLosses > (cutAndRun -1) + standPat) {
                        gameWinnings+=wicketWinnings;
                        wicketsLost++;
                        totalWicketLosses+=wicketWinnings;

                        if(gameWinnings < lowPoint) {
                            lowPoint = gameWinnings;
                        }

                        if(spinMode){System.out.println("loss " + wicketWinnings + " Running total " + gameWinnings + " Spins = " + rawSpins);}
                        chipsOnBoard = chipsOnBoardDefault;
                        bet = betDefault;
                        consecutiveLosses = 0;
                        wicketWinnings = 0;
                        standPatAt=standPat;

                        //Quit past the threshold
                        if(gameWinnings < (walkAwayTolerance * -1)){
                            spun = perGameSpinCount*2;
                        }
                    } else {
                        if (consecutiveLosses - standPat == chipsOnBoard) {
                            chipsOnBoard++;
                        }
                    }


                    //Keep playing if there's still hope.
                    if (gameWinnings < 0 && spun == perGameSpinCount && rawSpins < fatigue) {
                        spun--;
                    }
                }

                tripTotal += gameWinnings;
                todaysTotal += gameWinnings;


                if(gameMode) {
                    System.out.println("%%%%%%%%%%%%%%%");
                    System.out.println("Game end" + " Bank = " + bank);
                    if (gameWinnings<0 ){ System.out.println("LOSS");}
                    System.out.println("    Winnings = " + gameWinnings + " Spins " + rawSpins);
                    System.out.println("        Most consecutive losses " + consecutiveLossRecord);
                    System.out.println("        Low point = " + lowPoint);
                    if(weekMode){ System.out.println("        Running trip total = " + tripTotal);};
                    System.out.println("%%%%%%%%%%%%%%%");
                }


                if (gameWinnings > bestGame) {
                    bestGame = gameWinnings;
                }

                if (gameWinnings < worstGame) {
                    worstGame = gameWinnings;
                }

                if (lowPoint < lowestLowPoint) {
                    lowestLowPoint = lowPoint;
                }



                gameWinnings = 0;
                if(tripTotal<0 && gamesPlayed==possibleGamesPerTrip
                        && (overtimeGames<overtimeTolerance) && bank>0) {
                    gamesPlayed=gamesPlayed-1;
                    overtimeGames++;
                }
            }

            gameWinnings = 0;
            if(weekMode && tripTotal < 0) {
                    System.out.println("lost week: " + tripTotal + " Best game: " + bestGame + " Worst: " + worstGame + " Lowest point = " + lowestLowPoint);
                    System.out.println("***************");
            }
            if(weekMode && tripTotal > 0) {
                System.out.println("WIN: " + tripTotal + " Best game: " + bestGame + " Worst: " + worstGame + " Lowest point = " + lowestLowPoint);
                System.out.println("***************");
            }
            tripsTakenToVegas++;
            supremeTotal+=tripTotal;
            if(tripTotal<0){
                losingWeeks++;
                losingWeekAmount+= tripTotal;
            } else {
                winningWeeks++;
                winningWeekAmount+= tripTotal;
            }
            if(tripTotal<worstWeek){
                worstWeek = tripTotal;
            }
            if(tripTotal>bestWeek){
                bestWeek = tripTotal;
            }
    }

        System.out.println("Total for the sample " + supremeTotal);
        double average = supremeTotal / tripsToVegas;
        System.out.println("Average: " + average);
        System.out.println("Best week " + bestWeek);
        System.out.println("Losing weeks " + losingWeeks + "/" + tripsToVegas + " Worst week " + worstWeek);
        double averageWin = (((winningWeekAmount==0) ? 1:winningWeekAmount)/((winningWeeks==0) ? 1:winningWeeks));
        double averageLoss = ((losingWeekAmount==0) ? 1: losingWeekAmount/(losingWeeks==0 ? 1:losingWeeks));
        double winPct = 100 * (losingWeeks/tripsToVegas);
        System.out.println("Avg win: " + averageWin);
        System.out.println("Avg loss " + averageLoss + " Low Point = " + lowestLowPoint);
        System.out.println(config);
        statLine = betDefault + "," + average + "," + chipsOnBoardDefault + "," + winToleranceMultiplier + "," + lossToleranceMultiplier + "," + averageWin + "," + averageLoss + "," + winPct;
        statLineLibrary.add(statLine);

        if(statsMode) {
            System.out.println("Default bet, Average per game, chipsOnBoard, Win Tolerance, Loss Tolerance, average win, average loss, loss pct");
            for(String line: statLineLibrary) {
                System.out.println(line);
            }

        }

        System.out.println("Wickets won:" + wicketsWon + " Average = " + totalWicketWins/wicketsWon);
        System.out.println("Wickets lost:" + wicketsLost + " Average = " + totalWicketLosses/wicketsLost);

        System.exit(0);
    }



    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
        };
    }

}
