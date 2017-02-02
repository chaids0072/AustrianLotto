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
 * This class is the game player class, which mean that each AustrianLotto game*
 * can have multiple players                                                   *
 *******************************************************************************
 */
package austrianlotto;

public class GamePlayer {
    private String[] picks;
    private int numberOfPicks;
    
    /*
     * Consturctor format 1
     */
    public GamePlayer(){
        this.picks = new String[0];
        this.numberOfPicks = 0;
    }
    
    /*
     * Consturctor format 2
     */
    public GamePlayer(String[] picks, int numberOfPicks){
        this.picks = picks;
        this.numberOfPicks = numberOfPicks;
    }
    
    /*
     * Setting picks
     * @param picks a string array of picks
     */
    public void setPicks(String[] picks){
        this.picks = picks;
    }
    
    /*
     * Setting setNumberOfPicks
     * @param numberOfPicks a integer number of picks
     */
    public void setNumberOfPicks(int numberOfPicks){
        this.numberOfPicks = numberOfPicks;
    }
    
    /*
     * Getting picks
     * @return player's picks
     */
    public String[] getPicks(){
        return this.picks;
    }
    
    /*
     * Getting numberOfPicks
     * @return player's numberOfPicks
     */
    public int getNumberOfPicks(){
        return this.numberOfPicks;
    }
}
