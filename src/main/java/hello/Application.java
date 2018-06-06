package hello;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);


        String config;


        int tripsTakenToVegas = 0;


        int daysPlayed;
        int gamesPlayedToday=0;

        int todaysTotal=0;

        int gamesPlayed = 0;
        int possibleGamesPerTrip;
        int overtimeGames;

        int spun = 0;
        int rawSpins = 0;


        int bet;

        int chipsOnBoardDefault = 5;
        int chipsOnBoard;

        int bank;

        int consecutiveLosses = 0;
        int totalConsecutiveLosses = 0;
        int consecutiveLossRecord = 0;

        int schroedingersWin = 0;
        int schroedingersLoss = 0;

        int wicketWinnings = 0;
        int gameWinnings = 0;
        int gameStartingCash=0;

        double walkAwayTolerance;
        int lowPoint = 0;
        int lowestLowPoint = 0;

        int tripTotal = 0;
        int bestGame = 0;
        int worstGame = 0;

        int supremeTotal=0;
        int losingWeeks = 0;
        int losingWeekAmount=0;
        int winningWeeks=0;
        int winningWeekAmount=0;
        int worstWeek = 100000;
        int bestWeek=0;


        //Number of games config
        int overtimeTolerance = 0;
        int tripsToVegas = 10000;
        int possibleGamesPerDay=1;
        int daysPerTrip = 1;

        //money config
        boolean bankResetMode = false;
        int bankStartingCash;

        //Game Config
        int betDefault = 1;
        int perGameSpinCount = 1000;
        int fatigue = 4000;
        int cutAndRun = 9;
        int numberOfWicketsLossTolerance = 1;
        double quitThisGameInTriumph;

        //Reporting Config
        boolean spinMode = false;
        boolean gameMode = false;
        boolean weekMode = false;

        bankStartingCash = betDefault * 2000;
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

        walkAwayTolerance = (numberOfWicketsLossTolerance * wicketLoss) * .9;
        quitThisGameInTriumph = wicketLoss * 1.5;
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

//Spin loop
                while (spun <  perGameSpinCount) {
                    spun++;
                    rawSpins++;
                    Random rand = new Random();
                    int spin = rand.nextInt(38);

                    schroedingersWin = ((bet * 35) - ((chipsOnBoard - 1) * bet));
                    schroedingersLoss = (bet * chipsOnBoard) * -1;

                    if (spin <=  chipsOnBoard) {
                        //WINNING
                        bank+=schroedingersWin;
                        wicketWinnings = wicketWinnings + (schroedingersWin);
                        gameWinnings+=wicketWinnings;

                        if (gameWinnings > quitThisGameInTriumph) {
                            spun = perGameSpinCount;
                        }
                        if (totalConsecutiveLosses > consecutiveLossRecord) {
                            consecutiveLossRecord = totalConsecutiveLosses;
                        }
                        totalConsecutiveLosses = 0;
                        consecutiveLosses = 0;

                       if(spinMode){ System.out.println("win " + wicketWinnings + " Running total: " + gameWinnings + " Spins = " + rawSpins);}

                        if (wicketWinnings < 0 && spun == perGameSpinCount) {
                            spun = spun - chipsOnBoardDefault;
                        }

                        wicketWinnings = 0;
                        chipsOnBoard = chipsOnBoardDefault;
                        bet = betDefault;
                    } else {

                        //LOSING
                        bank+=schroedingersLoss;
                        consecutiveLosses++;
                        totalConsecutiveLosses++;
                        if (totalConsecutiveLosses > consecutiveLossRecord) {
                            consecutiveLossRecord = totalConsecutiveLosses;
                        }
                        wicketWinnings += schroedingersLoss;
                        if ((wicketWinnings + gameWinnings) < lowPoint) {
                            lowPoint = gameWinnings+ wicketWinnings;
                        }
                        bet = bet + betDefault;
                        if (spun == perGameSpinCount) {
                            spun--;
                        }
                    }

                    //Wicket - cut and run
                    if (consecutiveLosses > (cutAndRun -1)) {
                        gameWinnings+=wicketWinnings;
                        if(gameWinnings < lowPoint) {
                            lowPoint = gameWinnings;
                        }

                        if(spinMode){System.out.println("loss " + wicketWinnings + " Running total " + gameWinnings + " Spins = " + rawSpins);}
                        chipsOnBoard = chipsOnBoardDefault;
                        bet = betDefault;
                        consecutiveLosses = 0;
                        wicketWinnings = 0;

                        //Quit past the threshold
                        if(gameWinnings < (walkAwayTolerance * -1)){
                            spun = perGameSpinCount*2;
                        }
                    } else {
                        if (consecutiveLosses == chipsOnBoard) {
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

                if(bank<0){
                    System.out.println("FUUUUUUUUCK!!!!!!");
                    spun = perGameSpinCount;
                    gamesPlayed = possibleGamesPerTrip;
                    if(!bankResetMode) {
                        tripsTakenToVegas = tripsToVegas;
                    }
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
        System.out.println("Average: " + supremeTotal / tripsToVegas);
        System.out.println("Best week " + bestWeek);
        System.out.println("Losing weeks " + losingWeeks + "/" + tripsToVegas + " Worst week " + worstWeek);
        System.out.println("Avg win: " + (((winningWeekAmount==0) ? 1:winningWeekAmount)/((winningWeeks==0) ? 1:winningWeeks)));
        System.out.println("Avg loss " + ((losingWeekAmount==0) ? 1: losingWeekAmount/(losingWeeks==0 ? 1:losingWeeks)) + " Low Point = " + lowestLowPoint);
        System.out.println(config);

        System.exit(0);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
        };
    }

}
