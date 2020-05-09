/*
 * @author Jeffrey Chan & Minyi Li, RMIT 2020
 */

package solver;

import grid.SudokuGrid;


/**
 * Backtracking solver for Killer Sudoku.
 */
public class KillerBackTrackingSolver extends KillerSudokuSolver
{
    // TODO: Add attributes as needed.

    public KillerBackTrackingSolver() {
        // TODO: any initialisation you want to implement.
    } // end of KillerBackTrackingSolver()


    @Override
    public boolean solve(SudokuGrid grid) {
        // TODO: your implementation of a backtracking solver for Killer Sudoku.

        int gridDimension = grid.getGridDimension();
        int[] validSymbolsList = grid.getValidSymbolsList();

        for (int i = 0; i < gridDimension; i++) {
            for (int j = 0; j < gridDimension; j++) {
                if(grid.getGridLoc(i, j) == 0) {
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
