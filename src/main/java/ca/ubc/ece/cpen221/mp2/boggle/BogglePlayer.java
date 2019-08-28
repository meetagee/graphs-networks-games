package ca.ubc.ece.cpen221.mp2.boggle;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class BogglePlayer {

    // Rep invariant:
    //     Dictionary is not null, must either be a set or an array.
    //     Board in must be a square board.

    // Abstraction function:
    //     Represents the set of all words found in a given board and the maximum
    //     score can be obtained from the board.

    private static final int SCORE_LENGTH34 = 1;
    private static final int SCORE_LENGTH5 = 2;
    private static final int SCORE_LENGTH6 = 3;
    private static final int SCORE_LENGTH7 = 5;
    private static final int SCORE_LENGTH8 = 11;
    private static final int MAX_LENGTH = 10;

    private Set<String> dictionary;
    private Set<String> avaiWords;
    private int[][] isVisited2;

    /**
     * Constructor for BogglePlayer - accepting dictionary as a Set of Strings
     *
     * @param dictionary
     */
    public BogglePlayer(Set<String> dictionary){
        this.dictionary = dictionary;
    }

    /**
     * Constructor for BogglePlayer - accepting dictionary as an Array of Strings
     *
     * @param dictionary
     */
    public BogglePlayer(String[] dictionary) {
        this.dictionary = Arrays.stream(dictionary).collect(Collectors.toSet()); //handling dictionary input as an array
    }

    /**
     * Find all possible combinations of words from the board
     * @param board - board to be examined
     * @param isVisited2 - 2D array for checking if a cell is visted
     * @param i - row number
     * @param j - column number
     * @param str_b - StringBuilder for words
     */
    private void findWordsUtil(BoggleBoard board, int[][] isVisited2, int i, int j, StringBuilder str_b) {
        String str; //String of word got from board
        char ch; //Character from each run

        if (str_b.length() >= MAX_LENGTH) return;

        isVisited2[i][j] = 1; //check the current dice is visited

        ch = board.getLetter(i, j);
        str_b.append(ch);
        if (ch == 'Q')
            str_b.append('U'); //handling special case "Q" -> "Qu"

        str = str_b.toString();

        if (this.dictionary.contains(str) && str.length() >= 3) { this.avaiWords.add(str);}

        int tempRow1 = i - 1;
        if (tempRow1 < 0) { tempRow1 += board.rows(); }

        int tempRow2 = i + 1;
        if (tempRow2 > board.rows() - 1) { tempRow2 -= board.rows(); }

        int tempCol1 = j - 1;
        if (tempCol1 < 0) { tempCol1 += (board.cols()); }

        int tempCol2 = j + 1;
        if (tempCol2 > board.cols() - 1) { tempCol2 -= (board.cols()); }

        // Traverse 8 adjacent cells of boggle[i][j]
        if (isVisited2[tempRow1][j] == 0) findWordsUtil(board, isVisited2, tempRow1, j, str_b);
        if (isVisited2[tempRow2][j] == 0) findWordsUtil(board, isVisited2, tempRow2, j, str_b);
        if (isVisited2[i][tempCol1] == 0) findWordsUtil(board, isVisited2, i, tempCol1, str_b);
        if (isVisited2[i][tempCol2] == 0) findWordsUtil(board, isVisited2, i, tempCol2, str_b);
        if (isVisited2[tempRow1][tempCol1] == 0) findWordsUtil(board, isVisited2, tempRow1, tempCol1, str_b);
        if (isVisited2[tempRow1][tempCol2] == 0) findWordsUtil(board, isVisited2, tempRow1, tempCol2, str_b);
        if (isVisited2[tempRow2][tempCol1] == 0) findWordsUtil(board, isVisited2, tempRow2, tempCol1, str_b);
        if (isVisited2[tempRow2][tempCol2] == 0) findWordsUtil(board, isVisited2, tempRow2, tempCol2, str_b);

        // Erase current character from string and mark visited
        // of current cell as false
        str_b.deleteCharAt(str_b.length() - 1);
        if (ch == 'Q')
            str_b.deleteCharAt(str_b.length() - 1); //have to delete twice if in special case
        isVisited2[i][j] = 0; //uncheck visited at this cell
    }

    /**
     * Determine all the possible words can be found from a given boggle board
     *
     * @param board - the board to be examined
     * @return avaiWords - a Set of all possible words that can be found
     */
    public Set<String> getAllValidWords(BoggleBoard board) {
        this.avaiWords = new TreeSet<>();
        isVisited2 = new int[board.rows()][board.cols()];
        StringBuilder str_b = new StringBuilder();

        for (int i = 0; i < board.rows(); i++) {
            for (int j = 0; j < board.cols(); j++) {
                isVisited2[i][j] = 0; //populating a visited-check 2D array
            }
        }

        for(int i = 0; i < board.rows(); i++) { //traversing through whole board
            for (int j = 0; j < board.cols(); j++) {
                findWordsUtil(board, isVisited2, i, j, str_b);
            }
        }
        System.out.println(avaiWords);
        return this.avaiWords;
    }


    /**
     * Determine the maximum score that can be achieved from a given board
     *
     * @param board - the board to be examined
     * @return maxScore - the value of maximum score can be achieved
     */
    // Returns the maximum possible score that can be achieved from a given board
    public int getMaximumScore(BoggleBoard board){
        Set<String> possibleWords = getAllValidWords(board); //get all possible words
        int maxScore = 0;

        for(String word : possibleWords) {
            maxScore += scoreOf(word);
        }
        return maxScore;
    }

    /**
     * Returns the score of the given word if it is in the dictionary, zero otherwise
     *
     * @param word - word to be examined.
     * @return score of word based on its' length
     */
    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A through Z.)
    public int scoreOf(String word){
        if(dictionary.contains(word)) {
            if(word.length() <= 2) { return 0; }
            else if(word.length() == 3 || word.length() == 4) { return SCORE_LENGTH34; }
            else if(word.length() == 5) { return SCORE_LENGTH5; }
            else if(word.length() == 6) { return SCORE_LENGTH6; }
            else if(word.length() == 7) { return  SCORE_LENGTH7; }
            else { return SCORE_LENGTH8; }
        }
        else {
            return 0;
        }
    }
}