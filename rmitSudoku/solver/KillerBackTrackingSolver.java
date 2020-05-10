/**
 * @author Jeffrey Chan & Minyi Li, RMIT 2020
 * @studentAuthor Alan Lam s3436174
 */

package solver;

import grid.SudokuGrid;


/**
 * Backtracking solver for Killer Sudoku.
 */
public class KillerBackTrackingSolver extends KillerSudokuSolver {

    public KillerBackTrackingSolver() {

    } // end of KillerBackTrackingSolver()


    @Override
    public boolean solve(SudokuGrid grid) {

        int gridDimension = grid.getGridDimension();
        int[] validSymbolsList = grid.getValidSymbolsList();

        for (int i = 0; i < gridDimension; i++) {
            for (int j = 0; j < gridDimension; j++) {
                if (grid.getGridLoc(i, j) == 0) {
                    for (int k = 0; k < gridDimension; k++) {
                        if (grid.validate(i, j, validSymbolsList[k])) {
                            grid.setGridLoc(i, j, validSymbolsList[k]);
                            if (solve(grid)) {
                                return true;
                            } else {
                                grid.setGridLoc(i, j, 0);
                            }

                        }

                    }
                    return false;
                }

            }

        }
        return true;
    } // end of solve()

} // end of class KillerBackTrackingSolver()
