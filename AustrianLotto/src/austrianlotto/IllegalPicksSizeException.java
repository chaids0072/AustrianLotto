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
 * This prevents invalid inputs                                                *
 *******************************************************************************
 */
package austrianlotto;

/*
 *Exception can be thrown when input size is invalid
 * @param none
 */
public class IllegalPicksSizeException extends Exception {
    public IllegalPicksSizeException(){
            super();
    }
    public IllegalPicksSizeException(String message){
            super(message);
    }
}

