/*******************************************************************************
 *Authorship: Gang Chen 
 *Email: gche8512@gmail.com
 *Time:02/02/2017                                                              *
 *******************************************************************************
 */

/*******************************************************************************
 *                              Declaration                                    *
 * ----------------------------------------------------------------------------*
 * This program is designed by Gang Chen and to be submitted to DonRiver as the*
 * my response to the Coding challenge                                         *
 *******************************************************************************
 */

/*******************************************************************************
 *                         Class Introduction                                  *
 * ----------------------------------------------------------------------------*
 * 1. This class is the main class which will create both drawing and picks    *
 * before its evaluate() method gets called. Picks contains between 1 and 50   *
 * elements. Drawing and each element of picks contains exactly 6 distinct     *
 * integers between 1 and 45.                                                  *
 * 2.The output will be displayed in the format as specified in the coding     *
 * challenge description                                                       *
 *******************************************************************************
 */
package austrianlotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.StringJoiner;

public class AustrianLotto {
    public static final int DRAWING_NUMBER = 6;
    public static final int MIN_PICKABLE_NUMBER = 1;
    public static final int MAX_PICKABLE_NUMBER = 45;
    public static final int MIN_PICKS_PER_GAME = 1;
    public static final int MAX_PICKS_PER_GAME = 50;
    public static final int ARR_SIZE_DRAWING = 7;
    
    /*
     * The entire process can be finished in 4 steps.
     * Step 1 : Parameters initiation - each game has a player and a game state
     * Step 2 : Parameters assignment - assigning values to player and game
     * Step 3 : Picks evaluation - evaluating drawing and picks
     * Step 4 : Result display - display the result in specified format
     *
     * As required, I need to write random number generator into main function.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IllegalPicksSizeException {
        
        System.out.println("=====================================");
        System.out.println("----  Welcome to Austrian Lotto  ----\n"
                + "$$$<- May the luck be with you ->$$$");   
        System.out.println("=====================================");
        

        //Step 1 : Parameters initiation.
        Random rn = new Random();
        GameStats newGameStats = new GameStats();
        GamePlayer addictedPlayer = new GamePlayer();
        int rangePicks = MAX_PICKS_PER_GAME - MIN_PICKS_PER_GAME +1;
        int randomPicks = rn.nextInt(rangePicks) + MIN_PICKS_PER_GAME;
        //Stringbuilder can be used to replace string[]
        //But for convenience I use string array.
        String[] playerPicks = new String[randomPicks];
        
        //Step 2 : Parameters value assignment.
        for(int i = 0; i < randomPicks; i++) {
            playerPicks[i] = pickFactory();
        }
        
        newGameStats.setDrawing(pickFactory());
        addictedPlayer.setPicks(playerPicks);
        addictedPlayer.setNumberOfPicks(randomPicks);
                 
        //Step 3 : Picks evaluation.
        int[] result = evaluate(newGameStats.getDrawing(),
        addictedPlayer.getPicks());
        
        
        //Step 4 : Display picks result.
        display(result,newGameStats.getDrawing(),addictedPlayer.getPicks());

    }
    
    /**
     * Evaluating picks and drawing in order to give feedback to the game player
     * and inform game player of the success rate.
     * 
     * @param drawing game drawing
     * @param picks player's picks
     * @return result A string of integers
     * @throws austrianlotto.IllegalPicksSizeException
     */
    public static int[] evaluate(String drawing, String[] picks) 
            throws IllegalPicksSizeException{
        int[] result = new int[ARR_SIZE_DRAWING];
        int playerPickSize = picks.length;
        
        if(playerPickSize > MAX_PICKS_PER_GAME || drawing.isEmpty()){
            throw new IllegalPicksSizeException("Invalid inputs");     
        }
        
        //Using hashset to speed up the comparing process
        //Time complexity : O(n)
        for(String pick : picks){
            int indexCounter = 0;
            Set<String> setA = new HashSet<>();
            
            String[] pickArr = pick.split(" ");
            String[] drawingArr = drawing.split(" ");     

            setA.addAll(Arrays.asList(pickArr));
            
            for (String current : drawingArr) {
                if (setA.contains(current)) {
                    indexCounter += 1;
                }
            }
            
            result[indexCounter] =result[indexCounter] + 1;
            
            if(indexCounter > 0){
                playerPickSize--;
            }
            
        }
        result[0] = playerPickSize;
        
        return result;
    }

     /**
     * Displaying the result in specified format
     * 
     * @param statics game result 
     * @param drawing game drawing
     * @param picks player's picks
     */
    private static void display(int[] statics, String drawing, String[] picks) {
        String finalPickString = "";
        String finalPickInt = "";
        
        System.out.println('"' + drawing + '"');
        
        for(String currentStr : picks){
            finalPickString = finalPickString + '"' + currentStr + '"' + ",";
        }
        
        finalPickString = finalPickString.substring(0
                , finalPickString.lastIndexOf(","));
        
        System.out.println('{' + finalPickString + '}');
        
        for(int currentInt : statics){
            finalPickInt = finalPickInt + currentInt + ",";
        }
        finalPickInt = finalPickInt.substring(0, finalPickInt.length()-1);
        System.out.println("Returns : {" + finalPickInt + "}");
    }

    /**
     * Randomly generate a set of number choices
     * e.g "1 2 3 4 5 6"
     * 
     * @return finalPick a string of number choices
     */
    private static String pickFactory() {
        StringJoiner temp = new StringJoiner(" ");
        Random rand = new Random();
        int[] eachPick = new int[DRAWING_NUMBER];
        Set<Integer> generated = new HashSet<>();
        
        while (generated.size() < DRAWING_NUMBER)
        {
            Integer next = rand.nextInt(MAX_PICKABLE_NUMBER) + 1;
            generated.add(next);
        }
        
        Iterator<Integer> it = generated.iterator();
        for (int i = 0; i < DRAWING_NUMBER; i++) {
            eachPick[i] = it.next();
        }
        
        Arrays.sort(eachPick);
        
        for(int i = 0; i < DRAWING_NUMBER; i++){
            temp.add(String.valueOf(eachPick[i]));
        }
        
        //String finalPick = '"' + temp.toString() + '"';
        
        return temp.toString();
    }
}