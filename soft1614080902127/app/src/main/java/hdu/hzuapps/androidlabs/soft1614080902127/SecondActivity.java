package edu.hzuapps.androidlabs.soft1614080902127;


import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class SecondActivity extends Activity
{
    private TextView txtMineCount;
    private TextView txtTimer;
    private ImageButton btnSmile;

    private TableLayout mineField;

    private Block blocks[][];
    private int blockDimension = 24;
    private int blockPadding = 2;

    private int numberOfRowsInMineField = 9;
    private int numberOfColumnsInMineField = 9;
    private int totalNumberOfMines = 10;


    private Handler timer = new Handler();
    private int secondsPassed = 0;

    private boolean isTimerStarted;
    private boolean areMinesSet;
    private boolean isGameOver;
    private int minesToFind;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtMineCount = (TextView) findViewById(R.id.MineCount);
        txtTimer = (TextView) findViewById(R.id.Timer);

        // set font style for timer and mine count to LCD style
        Typeface lcdFont = Typeface.createFromAsset(getAssets(),
                "fonts/lcd2mono.ttf");
        txtMineCount.setTypeface(lcdFont);
        txtTimer.setTypeface(lcdFont);

        btnSmile = (ImageButton) findViewById(R.id.Smiley);
        btnSmile.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                endExistingGame();
                startNewGame();
            }
        });

        mineField = (TableLayout)findViewById(R.id.MineField);

        showDialog("Click smiley to start New Game", 2000, true, false);
    }

    private void startNewGame()
    {
        // plant mines and do rest of the calculations
        createMineField();
        // display all blocks in UI
        showMineField();

        minesToFind = totalNumberOfMines;
        isGameOver = false;
        secondsPassed = 0;
    }

    private void showMineField()
    {
        // remember we will not show 0th and last Row and Columns
        // they are used for calculation purposes only
        for (int row = 1; row < numberOfRowsInMineField + 1; row++)
        {
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableRow.LayoutParams((blockDimension + 2 * blockPadding) * numberOfColumnsInMineField, blockDimension + 2 * blockPadding));

            for (int column = 1; column < numberOfColumnsInMineField + 1; column++)
            {
                blocks[row][column].setLayoutParams(new TableRow.LayoutParams(
                        blockDimension + 2 * blockPadding,
                        blockDimension + 2 * blockPadding));
                blocks[row][column].setPadding(blockPadding, blockPadding, blockPadding, blockPadding);
                tableRow.addView(blocks[row][column]);
            }
            mineField.addView(tableRow,new TableLayout.LayoutParams(
                    (blockDimension + 2 * blockPadding) * numberOfColumnsInMineField, blockDimension + 2 * blockPadding));
        }
    }

    private void endExistingGame()
    {
        stopTimer(); // stop if timer is running
        txtTimer.setText("000"); // revert all text
        txtMineCount.setText("000"); // revert mines count
        btnSmile.setBackgroundResource(R.drawable.smile);

        // remove all rows from mineField TableLayout
        mineField.removeAllViews();

        // set all variables to support end of game
        isTimerStarted = false;
        areMinesSet = false;
        isGameOver = false;
        minesToFind = 0;
    }

    private void createMineField()
    {
        // we take one row extra row for each side
        // overall two extra rows and two extra columns
        // first and last row/column are used for calculations purposes only
        //	 x|xxxxxxxxxxxxxx|x
        //	 ------------------
        //	 x|              |x
        //	 x|              |x
        //	 ------------------
        //	 x|xxxxxxxxxxxxxx|x
        // the row and columns marked as x are just used to keep counts of near by mines

        blocks = new Block[numberOfRowsInMineField + 2][numberOfColumnsInMineField + 2];

        for (int row = 0; row < numberOfRowsInMineField + 2; row++)
        {
            for (int column = 0; column < numberOfColumnsInMineField + 2; column++)
            {
                blocks[row][column] = new Block(this);
                blocks[row][column].setDefaults();

                // pass current row and column number as final int's to event listeners
                // this way we can ensure that each event listener is associated to
                // particular instance of block only
                final int currentRow = row;
                final int currentColumn = column;

                // add Click Listener
                // this is treated as Left Mouse click
                blocks[row][column].setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        // start timer on first click
                        if (!isTimerStarted)
                        {
                            startTimer();
                            isTimerStarted = true;
                        }

                        // set mines on first click
                        if (!areMinesSet)
                        {
                            areMinesSet = true;
                            setMines(currentRow, currentColumn);
                        }

                        // this is not first click
                        // check if current block is flagged
                        // if flagged the don't do anything
                        // as that operation is handled by LongClick
                        // if block is not flagged then uncover nearby blocks
                        // till we get numbered mines
                        if (!blocks[currentRow][currentColumn].isFlagged())
                        {
                            // open nearby blocks till we get numbered blocks
                            rippleUncover(currentRow, currentColumn);

                            // did we clicked a mine
                            if (blocks[currentRow][currentColumn].hasMine())
                            {
                                // Oops, game over
                                finishGame(currentRow,currentColumn);
                            }

                            // check if we win the game
                            if (checkGameWin())
                            {
                                // mark game as win
                                winGame();
                            }
                        }
                    }
                });

                // add Long Click listener
                // this is treated as right mouse click listener
                blocks[row][column].setOnLongClickListener(new View.OnLongClickListener()
                {
                    public boolean onLongClick(View view)
                    {
                        // simulate a left-right (middle) click
                        // if it is a long click on an opened mine then
                        // open all surrounding blocks
                        if (!blocks[currentRow][currentColumn].isCovered() && (blocks[currentRow][currentColumn].getNumberOfMinesInSorrounding() > 0) && !isGameOver)
                        {
                            int nearbyFlaggedBlocks = 0;
                            for (int previousRow = -1; previousRow < 2; previousRow++)
                            {
                                for (int previousColumn = -1; previousColumn < 2; previousColumn++)
                                {
                                    if (blocks[currentRow + previousRow][currentColumn + previousColumn].isFlagged())
                                    {
                                        nearbyFlaggedBlocks++;
                                    }
                                }
                            }

                            // if flagged block count is equal to nearby mine count
                            // then open nearby blocks
                            if (nearbyFlaggedBlocks == blocks[currentRow][currentColumn].getNumberOfMinesInSorrounding())
                            {
                                for (int previousRow = -1; previousRow < 2; previousRow++)
                                {
                                    for (int previousColumn = -1; previousColumn < 2; previousColumn++)
                                    {
                                        // don't open flagged blocks
                                        if (!blocks[currentRow + previousRow][currentColumn + previousColumn].isFlagged())
                                        {
                                            // open blocks till we get numbered block
                                            rippleUncover(currentRow + previousRow, currentColumn + previousColumn);

                                            // did we clicked a mine
                                            if (blocks[currentRow + previousRow][currentColumn + previousColumn].hasMine())
                                            {
                                                // oops game over
                                                finishGame(currentRow + previousRow, currentColumn + previousColumn);
                                            }

                                            // did we win the game
                                            if (checkGameWin())
                                            {
                                                // mark game as win
                                                winGame();
                                            }
                                        }
                                    }
                                }
                            }

                            // as we no longer want to judge this gesture so return
                            // not returning from here will actually trigger other action
                            // which can be marking as a flag or question mark or blank
                            return true;
                        }

                        // if clicked block is enabled, clickable or flagged
                        if (blocks[currentRow][currentColumn].isClickable() &&
                                (blocks[currentRow][currentColumn].isEnabled() || blocks[currentRow][currentColumn].isFlagged()))
                        {

                            // for long clicks set:
                            // 1. empty blocks to flagged
                            // 2. flagged to question mark
                            // 3. question mark to blank

                            // case 1. set blank block to flagged
                            if (!blocks[currentRow][currentColumn].isFlagged() && !blocks[currentRow][currentColumn].isQuestionMarked())
                            {
                                blocks[currentRow][currentColumn].setBlockAsDisabled(false);
                                blocks[currentRow][currentColumn].setFlagIcon(true);
                                blocks[currentRow][currentColumn].setFlagged(true);
                                minesToFind--; //reduce mine count
                                updateMineCountDisplay();
                            }
                            // case 2. set flagged to question mark
                            else if (!blocks[currentRow][currentColumn].isQuestionMarked())
                            {
                                blocks[currentRow][currentColumn].setBlockAsDisabled(true);
                                blocks[currentRow][currentColumn].setQuestionMarkIcon(true);
                                blocks[currentRow][currentColumn].setFlagged(false);
                                blocks[currentRow][currentColumn].setQuestionMarked(true);
                                minesToFind++; // increase mine count
                                updateMineCountDisplay();
                            }
                            // case 3. change to blank square
                            else
                            {
                                blocks[currentRow][currentColumn].setBlockAsDisabled(true);
                                blocks[currentRow][currentColumn].clearAllIcons();
                                blocks[currentRow][currentColumn].setQuestionMarked(false);
                                // if it is flagged then increment mine count
                                if (blocks[currentRow][currentColumn].isFlagged())
                                {
                                    minesToFind++; // increase mine count
                                    updateMineCountDisplay();
                                }
                                // remove flagged status
                                blocks[currentRow][currentColumn].setFlagged(false);
                            }

                            updateMineCountDisplay(); // update mine display
                        }

                        return true;
                    }
                });
            }
        }
    }

    private boolean checkGameWin()
    {
        for (int row = 1; row < numberOfRowsInMineField + 1; row++)
        {
            for (int column = 1; column < numberOfColumnsInMineField + 1; column++)
            {
                if (!blocks[row][column].hasMine() && blocks[row][column].isCovered())
                {
                    return false;
                }
            }
        }
        return true;
    }

    private void updateMineCountDisplay()
    {
        if (minesToFind < 0)
        {
            txtMineCount.setText(Integer.toString(minesToFind));
        }
        else if (minesToFind < 10)
        {
            txtMineCount.setText("00" + Integer.toString(minesToFind));
        }
        else if (minesToFind < 100)
        {
            txtMineCount.setText("0" + Integer.toString(minesToFind));
        }
        else
        {
            txtMineCount.setText(Integer.toString(minesToFind));
        }
    }

    private void winGame()
    {
        stopTimer();
        isTimerStarted = false;
        isGameOver = true;
        minesToFind = 0; //set mine count to 0

        //set icon to cool dude
        btnSmile.setBackgroundResource(R.drawable.cool);

        updateMineCountDisplay(); // update mine count

        // disable all buttons
        // set flagged all un-flagged blocks
        for (int row = 1; row < numberOfRowsInMineField + 1; row++)
        {
            for (int column = 1; column < numberOfColumnsInMineField + 1; column++)
            {
                blocks[row][column].setClickable(false);
                if (blocks[row][column].hasMine())
                {
                    blocks[row][column].setBlockAsDisabled(false);
                    blocks[row][column].setFlagIcon(true);
                }
            }
        }

        // show message
        showDialog("You won in " + Integer.toString(secondsPassed) + " seconds!", 1000, false, true);
    }

    private void finishGame(int currentRow, int currentColumn)
    {
        isGameOver = true; // mark game as over
        stopTimer(); // stop timer
        isTimerStarted = false;
        btnSmile.setBackgroundResource(R.drawable.sad);

        // show all mines
        // disable all blocks
        for (int row = 1; row < numberOfRowsInMineField + 1; row++)
        {
            for (int column = 1; column < numberOfColumnsInMineField + 1; column++)
            {
                // disable block
                blocks[row][column].setBlockAsDisabled(false);

                // block has mine and is not flagged
                if (blocks[row][column].hasMine() && !blocks[row][column].isFlagged())
                {
                    // set mine icon
                    blocks[row][column].setMineIcon(false);
                }

                // block is flagged and doesn't not have mine
                if (!blocks[row][column].hasMine() && blocks[row][column].isFlagged())
                {
                    // set flag icon
                    blocks[row][column].setFlagIcon(false);
                }

                // block is flagged
                if (blocks[row][column].isFlagged())
                {
                    // disable the block
                    blocks[row][column].setClickable(false);
                }
            }
        }

        // trigger mine
        blocks[currentRow][currentColumn].triggerMine();

        // show message
        showDialog("You tried for " + Integer.toString(secondsPassed) + " seconds!", 1000, false, false);
    }


    private void setMines(int currentRow, int currentColumn)
    {
        // set mines excluding the location where user clicked
        Random rand = new Random();
        int mineRow, mineColumn;

        for (int row = 0; row < totalNumberOfMines; row++)
        {
            mineRow = rand.nextInt(numberOfColumnsInMineField);
            mineColumn = rand.nextInt(numberOfRowsInMineField);
            if ((mineRow + 1 != currentColumn) || (mineColumn + 1 != currentRow))
            {
                if (blocks[mineColumn + 1][mineRow + 1].hasMine())
                {
                    row--; // mine is already there, don't repeat for same block
                }
                // plant mine at this location
                blocks[mineColumn + 1][mineRow + 1].plantMine();
            }
            // exclude the user clicked location
            else
            {
                row--;
            }
        }

        int nearByMineCount;

        // count number of mines in surrounding blocks
        for (int row = 0; row < numberOfRowsInMineField + 2; row++)
        {
            for (int column = 0; column < numberOfColumnsInMineField + 2; column++)
            {
                // for each block find nearby mine count
                nearByMineCount = 0;
                if ((row != 0) && (row != (numberOfRowsInMineField + 1)) && (column != 0) && (column != (numberOfColumnsInMineField + 1)))
                {
                    // check in all nearby blocks
                    for (int previousRow = -1; previousRow < 2; previousRow++)
                    {
                        for (int previousColumn = -1; previousColumn < 2; previousColumn++)
                        {
                            if (blocks[row + previousRow][column + previousColumn].hasMine())
                            {
                                // a mine was found so increment the counter
                                nearByMineCount++;
                            }
                        }
                    }

                    blocks[row][column].setNumberOfMinesInSurrounding(nearByMineCount);
                }
                // for side rows (0th and last row/column)
                // set count as 9 and mark it as opened
                else
                {
                    blocks[row][column].setNumberOfMinesInSurrounding(9);
                    blocks[row][column].OpenBlock();
                }
            }
        }
    }

    private void rippleUncover(int rowClicked, int columnClicked)
    {
        // don't open flagged or mined rows
        if (blocks[rowClicked][columnClicked].hasMine() || blocks[rowClicked][columnClicked].isFlagged())
        {
            return;
        }

        // open clicked block
        blocks[rowClicked][columnClicked].OpenBlock();

        // if clicked block have nearby mines then don't open further
        if (blocks[rowClicked][columnClicked].getNumberOfMinesInSorrounding() != 0 )
        {
            return;
        }

        // open next 3 rows and 3 columns recursively
        for (int row = 0; row < 3; row++)
        {
            for (int column = 0; column < 3; column++)
            {
                // check all the above checked conditions
                // if met then open subsequent blocks
                if (blocks[rowClicked + row - 1][columnClicked + column - 1].isCovered()
                        && (rowClicked + row - 1 > 0) && (columnClicked + column - 1 > 0)
                        && (rowClicked + row - 1 < numberOfRowsInMineField + 1) && (columnClicked + column - 1 < numberOfColumnsInMineField + 1))
                {
                    rippleUncover(rowClicked + row - 1, columnClicked + column - 1 );
                }
            }
        }
        return;
    }

    public void startTimer()
    {
        if (secondsPassed == 0)
        {
            timer.removeCallbacks(updateTimeElasped);
            // tell timer to run call back after 1 second
            timer.postDelayed(updateTimeElasped, 1000);
        }
    }

    public void stopTimer()
    {
        // disable call backs
        timer.removeCallbacks(updateTimeElasped);
    }

    // timer call back when timer is ticked
    private Runnable updateTimeElasped = new Runnable()
    {
        public void run()
        {
            long currentMilliseconds = System.currentTimeMillis();
            ++secondsPassed;

            if (secondsPassed < 10)
            {
                txtTimer.setText("00" + Integer.toString(secondsPassed));
            }
            else if (secondsPassed < 100)
            {
                txtTimer.setText("0" + Integer.toString(secondsPassed));
            }
            else
            {
                txtTimer.setText(Integer.toString(secondsPassed));
            }

            // add notification
            timer.postAtTime(this, currentMilliseconds);
            // notify to call back after 1 seconds
            // basically to remain in the timer loop
            timer.postDelayed(updateTimeElasped, 1000);
        }
    };

    private void showDialog(String message, int milliseconds, boolean useSmileImage, boolean useCoolImage)
    {
        // show message
        Toast dialog = Toast.makeText(
                getApplicationContext(),
                message,
                Toast.LENGTH_LONG);

        dialog.setGravity(Gravity.CENTER, 0, 0);
        LinearLayout dialogView = (LinearLayout) dialog.getView();
        ImageView coolImage = new ImageView(getApplicationContext());
        if (useSmileImage)
        {
            coolImage.setImageResource(R.drawable.smile);
        }
        else if (useCoolImage)
        {
            coolImage.setImageResource(R.drawable.cool);
        }
        else
        {
            coolImage.setImageResource(R.drawable.sad);
        }
        dialogView.addView(coolImage, 0);
        dialog.setDuration(milliseconds);
        dialog.show();
    }
}
