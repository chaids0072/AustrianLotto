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
 * Each Austrian Lotto game would have a game "stats" - scoreboard             *
 *******************************************************************************
 */
package austrianlotto;

public class GameStats {
    private String drawing;
    
    /*
     * Consturctor format 1
     */
    public GameStats(){
        this.drawing = "";
    }
    
    /*
     * Consturctor format 2
     */
    public GameStats(String drawing){
        this.drawing = drawing;
    }
    
    /*
     * Setting drawing
     * @param drawing a string of numbers
     */
    public void setDrawing(String drawing){
        this.drawing = drawing;
    }
    
    /*
     * Getting drawing
     * @return game stats
     */
    public String getDrawing(){
        return this.drawing;
    }
}
