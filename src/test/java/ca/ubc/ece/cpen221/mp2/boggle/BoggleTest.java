package ca.ubc.ece.cpen221.mp2.boggle;

import ca.ubc.ece.cpen221.utils.In;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Set;

public class BoggleTest {


    @Test
    public void testBoggle1() {
        String[] dictionary = new String[]{"HEY", "YES", "INTERNET", "YIKES", "EXPENSIVE", "A", "YOU", "ATE", "ATAP"};
        String[] validWords = new String[]{"YOU", "ATAP", "ATE", "A"};
        BoggleBoard board = new BoggleBoard("datasets/board4x4.txt");
        BogglePlayer player = new BogglePlayer(dictionary);
        Set<String> myValidWords = player.getAllValidWords(board);
        Assert.assertEquals(4, player.getMaximumScore(board));
        System.out.println(player.scoreOf("YES"));
        System.out.println(player.scoreOf("EXPENSIVE"));
    }



    @Test
    public void testBoggle2() {
        In in = new In(new File("datasets/dictionary-common.txt"));
        String[] dictionary = in.readAllStrings();
        BoggleBoard board = new BoggleBoard("datasets/board6x6.txt");
        BogglePlayer player = new BogglePlayer(dictionary);

        Assert.assertEquals(2923, player.getMaximumScore(board));
        System.out.println("Max score: " + player.getMaximumScore(board));
    }

    @Test
    public void testBoggle3() {
        In in = new In(new File("datasets/dictionary-common.txt"));
        String[] dictionary = in.readAllStrings();
        BoggleBoard board = new BoggleBoard("datasets/board4x4.txt");
        BogglePlayer player = new BogglePlayer(dictionary);

        int num = player.getMaximumScore(board);
        System.out.println("Max score: " + num);
    }

    @Test
    public void testBoggle4() {
        String[] dictionary = new String[]{"DEI", "ATAP", "ATE", "RIGHT", "WRITE", "DOT", "SOCCER", "FOOT", "DETAINS", "YOU", "NO", "UNO","ON", "SUN", "SUNSET"};
        String[] validWords = new String[]{"ATE", "DETAINS", "UNO", "DEI", "ATAP", "YOU"};
        BoggleBoard board = new BoggleBoard("datasets/board4x4.txt");
        BogglePlayer player = new BogglePlayer(dictionary);
        Set<String> myValidWords = player.getAllValidWords(board);
        Assert.assertEquals(10, player.getMaximumScore(board));
        System.out.println(player.scoreOf("DETAINS"));
        System.out.println(player.scoreOf("ATE"));
    }

}