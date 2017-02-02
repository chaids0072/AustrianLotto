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
 * Boundary-value analysis is both a refinement of equivalence partitioning and*
 * an extension of it. Boundary-value analysis selects test cases to explore   *
 * conditions on, and around, the edges of equivalence classes obtained by     *
 * input partitioning.
 *                                                                             *
 * In evaluate() method, we specifically test its boundary-value condition     *
 * that is "playerPickSize" and "drawing.length". For each of these two        *
 * variables, we cane then select on-point and off-point accordingly.          *
 *                                                                             *
 * playerPickSize (open boundary):                                             *
 *  - on-point:                                                                *
 *      playerPickSizeOn = 1                                                   *
 *  - off-point:                                                               *
 *      playerPickSizeOff = 51                                                 *
 *                                                                             *
 * drawing.length (close boundary)                                             *
 *  - on-point:                                                                *
 *      drawing.lengthOn = 0                                                   *
 *  - off-point:                                                               *
 *      drawing.lengthOff = -1 || 6                                            *
 *                                                                             *
 *Now, we use pair-wise combination, in total we have 2 test cases.            *
 *******************************************************************************
 */
package austrianlotto;

import org.junit.Test;

public class AustrianLottoUnitTestBoundaryValueAnalysis {
    
    /**
    *playerPickSizeOn && drawing.lengthOn
    * @throws austrianlotto.IllegalPicksSizeException
    */
    @Test (expected = IllegalPicksSizeException.class)
    public void boundarValueAnalysis1() throws IllegalPicksSizeException{  
        String drawing = "";
        String[] picks = {"1 2 3 4 5 6"};

        AustrianLotto.evaluate(drawing, picks);

    }
    
        /**
    *playerPickSizeOff && drawing.lengthOff
    * @throws austrianlotto.IllegalPicksSizeException
    */
    @Test (expected = IllegalPicksSizeException.class)
    public void boundarValueAnalysis2() throws IllegalPicksSizeException{  
        String[] picks = new String[51];
        
        for(int i = 0; i < 51; i++){
            picks[i] = "7 8 9 10 11 12";
        }
        
        String drawing = "1 2 3 4 5 6";
        AustrianLotto.evaluate(drawing, picks);
    }
}
