package edu.hzuapps.androidlabs.soft1614080902127;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

public class Block extends Button
{
    private boolean isCovered; // is block covered yet
    private boolean isMined; // does the block has a mine underneath
    private boolean isFlagged; // is block flagged as a potential mine
    private boolean isQuestionMarked; // is block question marked
    private boolean isClickable; // can block accept click events
    private int numberOfMinesInSurrounding; // number of mines in nearby blocks

    public Block(Context context)
    {
        super(context);
    }

    public Block(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public Block(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    // set default properties for the block
    public void setDefaults()
    {
        isCovered = true;
        isMined = false;
        isFlagged = false;
        isQuestionMarked = false;
        isClickable = true;
        numberOfMinesInSurrounding = 0;

        this.setBackgroundResource(R.drawable.square_blue);
        setBoldFont();
    }

    // mark the block as disabled/opened
    // update the number of nearby mines
    public void setNumberOfSurroundingMines(int number)
    {
        this.setBackgroundResource(R.drawable.square_grey);

        updateNumber(number);
    }

    // set mine icon for block
    // set block as disabled/opened if false is passed
    public void setMineIcon(boolean enabled)
    {
        this.setText("M");

        if (!enabled)
        {
            this.setBackgroundResource(R.drawable.square_grey);
            this.setTextColor(Color.RED);
        }
        else
        {
            this.setTextColor(Color.BLACK);
        }
    }

    // set mine as flagged
    // set block as disabled/opened if false is passed
    public void setFlagIcon(boolean enabled)
    {
        this.setText("F");

        if (!enabled)
        {
            this.setBackgroundResource(R.drawable.square_grey);
            this.setTextColor(Color.RED);
        }
        else
        {
            this.setTextColor(Color.BLACK);
        }
    }

    // set mine as question mark
    // set block as disabled/opened if false is passed
    public void setQuestionMarkIcon(boolean enabled)
    {
        this.setText("?");

        if (!enabled)
        {
            this.setBackgroundResource(R.drawable.square_grey);
            this.setTextColor(Color.RED);
        }
        else
        {
            this.setTextColor(Color.BLACK);
        }
    }

    // set block as disabled/opened if false is passed
    // else enable/close it
    public void setBlockAsDisabled(boolean enabled)
    {
        if (!enabled)
        {
            this.setBackgroundResource(R.drawable.square_grey);
        }
        else
        {
            this.setBackgroundResource(R.drawable.square_blue);
        }
    }

    // clear all icons/text
    public void clearAllIcons()
    {
        this.setText("");
    }

    // set font as bold
    private void setBoldFont()
    {
        this.setTypeface(null, Typeface.BOLD);
    }

    // uncover this block
    public void OpenBlock()
    {
        // cannot uncover a mine which is not covered
        if (!isCovered)
            return;

        setBlockAsDisabled(false);
        isCovered = false;

        // check if it has mine
        if (hasMine())
        {
            setMineIcon(false);
        }
        // update with the nearby mine count
        else
        {
            setNumberOfSurroundingMines(numberOfMinesInSurrounding);
        }
    }

    // set text as nearby mine count
    public void updateNumber(int text)
    {
        if (text != 0)
        {
            this.setText(Integer.toString(text));

            // select different color for each number
            // we have already skipped 0 mine count
            switch (text)
            {
                case 1:
                    this.setTextColor(Color.BLUE);
                    break;
                case 2:
                    this.setTextColor(Color.rgb(0, 100, 0));
                    break;
                case 3:
                    this.setTextColor(Color.RED);
                    break;
                case 4:
                    this.setTextColor(Color.rgb(85, 26, 139));
                    break;
                case 5:
                    this.setTextColor(Color.rgb(139, 28, 98));
                    break;
                case 6:
                    this.setTextColor(Color.rgb(238, 173, 14));
                    break;
                case 7:
                    this.setTextColor(Color.rgb(47, 79, 79));
                    break;
                case 8:
                    this.setTextColor(Color.rgb(71, 71, 71));
                    break;
                case 9:
                    this.setTextColor(Color.rgb(205, 205, 0));
                    break;
            }
        }
    }

    // set block as a mine underneath
    public void plantMine()
    {
        isMined = true;
    }

    // mine was opened
    // change the block icon and color
    public void triggerMine()
    {
        setMineIcon(true);
        this.setTextColor(Color.RED);
    }

    // is block still covered
    public boolean isCovered()
    {
        return isCovered;
    }

    // does the block have any mine underneath
    public boolean hasMine()
    {
        return isMined;
    }

    // set number of nearby mines
    public void setNumberOfMinesInSurrounding(int number)
    {
        numberOfMinesInSurrounding = number;
    }

    // get number of nearby mines
    public int getNumberOfMinesInSorrounding()
    {
        return numberOfMinesInSurrounding;
    }

    // is block marked as flagged
    public boolean isFlagged()
    {
        return isFlagged;
    }

    // mark block as flagged
    public void setFlagged(boolean flagged)
    {
        isFlagged = flagged;
    }

    // is block marked as a question mark
    public boolean isQuestionMarked()
    {
        return isQuestionMarked;
    }

    // set question mark for the block
    public void setQuestionMarked(boolean questionMarked)
    {
        isQuestionMarked = questionMarked;
    }

    // can block receive click event
    public boolean isClickable()
    {
        return isClickable;
    }

    // disable block for receive click events
    public void setClickable(boolean clickable)
    {
        isClickable = clickable;
    }
}
