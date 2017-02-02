/*******************************************************************************
 *Authorship: Gang Chen                                                        *
 *Time:02/02/2017                                                              *
 *******************************************************************************
 */

/*******************************************************************************
 *                              TDD                                            *
 *******************************************************************************
 * These test cases were written prior to the AustrianLotto in order to show   *
 * that TDD was considered.                                              *
 *	1.	write test cases													   *
 *	2.	watch test cases fail												   *
 *	3.	write application logic												   *
 *	4.	pass the test														   *
 *	5.	Refractor, Removing duplication										   *
 *	6.	Pass the test again													   *
 *******************************************************************************
 */

/*******************************************************************************
 *                              Testing Strategy                               *
 *******************************************************************************
 *  By using equivalence partitioning (EC) method.                             *
 *  I will develop test cases in the following scenarios. In total, this method*
 *  will generate 4 test cases by all-combination definition.                  *
 * (picks_ECinvalid2 is not testable)                                          *
 *                                                                             *
 *  For drawing                                                                *
 *      -Valid:                                                                *
 *          drawing_ECvalid1 = { drawing | drawing is a valid string}          *
 *      -Invalid:                                                              *
 *          drawing_ECinvalid1 = { drawing | drawing is an invalid string}     *
 *                                                                             *
 *  For picks:                                                                 *
 *      -Valid:                                                                *
 *          picks_ECvalid1 = { s = picks.length | s has 0 < s < 50 picks}      *
 *      -Invalid:                                                              *
 *          picks_ECinvalid1 = {s = picks.length | s has s > 50 picks}         *
 *          picks_ECinvalid2 = {s = picks.length | s has s < 0 picks}          *
 *******************************************************************************
 */
package austrianlotto;

import org.junit.Test;
import static org.junit.Assert.*;

public class AustrianLottoUnitTestEquivalencePartitioning{ 
    
    /**
    *drawing_ECvalid1 && picks_ECvalid1
    */
    @Test
    public void equivalencePartitioning1(){  
        int[] expectedResult = { 2,  0,  0,  0,  0,  0,  1 };
        String drawing = "1 2 3 4 5 6";
        String[] picks = {"1 2 3 4 5 6","7 8 9 10 11 12","13 14 15 16 17 18"};
        
        try {
            int[] actualResult = AustrianLotto.evaluate(drawing, picks);
            assertArrayEquals(expectedResult, actualResult);
        } catch (Exception e) {
        }
    }
    
    /**
    *drawing_ECvalid1 && picks_ECinvalid1
    * 
    * @throws austrianlotto.IllegalPicksSizeException
    */
    @Test (expected = IllegalPicksSizeException.class)
    public void equivalencePartitioning2() throws IllegalPicksSizeException{
        String[] picks = new String[51];

        String drawing = "1 2 3 4 5 6";
        
        for(int i = 0; i < 51; i++){
            picks[i] = "7 8 9 10 11 12";
        }
        
        AustrianLotto.evaluate(drawing, picks); 
    }
    
    /**
    *drawing_ECinvalid1 && picks_ECvalid1
    * 
    * @throws austrianlotto.IllegalPicksSizeException
    */
    @Test (expected = IllegalPicksSizeException.class)
    public void equivalencePartitioning3() throws IllegalPicksSizeException{
        String drawing = "";
        String[] picks = {"1 2 3 4 5 6","7 8 9 10 11 12","13 14 15 16 17 18"};
        
        AustrianLotto.evaluate(drawing, picks); 
    }
    
    /**
    *drawing_ECinvalid1 && picks_ECinvalid1
    * 
    * @throws austrianlotto.IllegalPicksSizeException
    */
    @Test (expected = IllegalPicksSizeException.class)
    public void equivalencePartitioning4() throws IllegalPicksSizeException{
        String drawing = "";
        String[] picks = new String[51];
        
        for(int i = 0; i < 51; i++){
            picks[i] = "7 8 9 10 11 12";
        }
        
        AustrianLotto.evaluate(drawing, picks); 
    }
    
}
