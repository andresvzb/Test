/** Title:           Sudoku Puzzle
** Files:            Sudoku, SudokuSimulation
** Semester:         COP3804 - Summer 2016
**
** Author:           3323611
** Lecturers Name:  Maria Charters
**
** Description of Program’s Functionality: Creates and prints 3 Sudokus puzzles
**                       The program checks if the puzzles are valid or not
**                      valid sudoku Puzzles.                                
*/

/**
 *
 * @author 3323611
 */
public class Sudoku {
    
    /*
    Array of boolean to check if the rows, columns and sqaures are latin
    */
    public boolean [] sudokuArray = {true, false, false, false, false,
                       false, false, false, false, false};
            
    /**
     * This method constructs the sudoku 
     * @param s
     * @return 
     */
    public String[][] makeSudoku(String s) {
        int SIZE = 9;
        int k = 0;
        String[][] x = new String[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                x[i][j] = s.substring(k, k + 1);
                k++;
            }
        }
        return x;
    }
    /**
     * This method prints the sudoku
     * @param x
     * @return 
     */
    public String getPrintableSudoku(String[][] x) {
        int SIZE = 9;
        String temp = "";
        for (int i = 0; i < SIZE; i++) {
            if ((i == 3) || (i == 6)) {
                temp = temp + "=================\n";
            }
            for (int j = 0; j < SIZE; j++) {
                if ((j == 3) || (j == 6)) {
                    temp = temp + " || ";
                }
                temp = temp + x[i][j];
            }
            temp = temp + "\n";
        }
        return temp;
    }
    /**This method checks if all the rows and columns and subsquares are Laatin 
     * @param x
     * @return 3 booleans 
     */
    public boolean isValidSudoku(String[][] x) {
        return rowsAreLatin(x) && colsAreLatin(x) && goodSubsquares(x);
    }
    /**
     * This method checks if all the rows in the sudoku are Latin
     * @param x
     * @return 
     */
    public boolean rowsAreLatin(String[][] x) {
              
        boolean test = true;
        for (int i = 0; i < x.length; i++) {
            test = test && rowIsLatin(x,i);
        }
        return test;
    }
    /**
     * This method checks if a row specified by the int i passed in the sudoku
     * is Latin
     * @param x
     * @param i
     * @return 
     */
    public boolean rowIsLatin(String[][] x, int i) {
       // fill in your code here    
       //Resets the array to all false.
       resetSudokuArray();
       //Goes through every row in the array
        for(int k = 0; k < x.length; k++)
        {
        setSudokuArray(Integer.parseInt(x[i][k]));    
        }
        return sudokuArray[1] && sudokuArray[2] && sudokuArray[3] && sudokuArray[4] 
                && sudokuArray[5] && sudokuArray[6] && sudokuArray[7] && sudokuArray[8]
                && sudokuArray[9];
    }
    /**
     * This method checks if all the columns in the sudoku are Latin
     * @param x
     * @return boolean
     */
    public boolean colsAreLatin(String[][] x) {
        // fill in your code here
        boolean test = true;
        for (int j = 0; j < x.length; j++) {
            test = test && colIsLatin(x,j);
        }
        return test;
    }
    /**
     * This method checks if a columns specified by the int j 
     * passed in the sudoku is Latin
     * @param x
     * @param j
     * @return boolean
     */
    public boolean colIsLatin(String[][] x, int j) {
        //fill in your code here
        //Resets the array to all false.
        resetSudokuArray();
        //Goes through every col in the array
        for(int k = 0; k < x.length; k++)
        {
        setSudokuArray(Integer.parseInt(x[k][j]));    
        }
        return sudokuArray[1] && sudokuArray[2] && sudokuArray[3] && sudokuArray[4] 
                && sudokuArray[5] && sudokuArray[6] && sudokuArray[7] && sudokuArray[8]
                && sudokuArray[9];
    }
    /**
     * This method checks if the subsquares are latin
     * @param x
     * @return boolean
     */
    public boolean goodSubsquares(String[][] x) {
        
        boolean test = true;
        for (int i = 0; i < x.length; i+=3)
        {
           for (int j = 0; j < x.length; j+=3)
           {            
            test = test && goodSubsquare(x,i,j);
           }
        }
        return test;
    }
    /**
     * This method checks if the subsquares contains the numners 1-9
     * @param x
     * @param i
     * @param j
     * @return boolean
     */
    public boolean goodSubsquare(String[][] x, int i, int j) {
        // fill in your code here
        //Resetting the array
        resetSudokuArray();
        for(int k = 0; k <= i+2; k++)
        {
            for(int m = 0; m <= j+2; m++)
            {
                setSudokuArray(Integer.parseInt(x[k][m]));    
            }
        }        
        return sudokuArray[1] && sudokuArray[2] && sudokuArray[3] && sudokuArray[4] 
                && sudokuArray[5] && sudokuArray[6] && sudokuArray[7] && sudokuArray[8]
                && sudokuArray[9];
    }
    /**
     * This method is to check if the numbers 1-9 are in the row, column or squares.
     * @param x 
     */
    public void setSudokuArray(int x)
    {
     sudokuArray[x] = true; 
    }
    /**
     * This method resets the array sudokuArray to all false.
     */
    public void resetSudokuArray()
    {
      for(int a = 1; a < sudokuArray.length; a++)
      {   
       sudokuArray[a] = false;
      }
    }

}


