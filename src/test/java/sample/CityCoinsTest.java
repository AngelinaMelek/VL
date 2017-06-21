package sample;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by vlasov on 21.06.17.
 */
public class CityCoinsTest {
    @Test
    public void findMaxX() throws Exception {
        CityCoins cityCoins = new CityCoins();
        String _s = "France 1 4 4 6 \n" +
                "Spain 3 1 6 3 \n" +
                "Portugal 1 1 2 2 ";
        String[] s = _s.split("\n");

        assertEquals("must be 6: ", 6, cityCoins.findMaxX(s));
        //*/
    }

    @Test
    public void findMaxY() throws Exception {
        CityCoins cityCoins = new CityCoins();
        String _s = "France 1 4 4 6 \n" +
                "Spain 3 1 6 3 \n" +
                "Portugal 1 1 2 2 ";
        String[] s = _s.split("\n");

        assertEquals("must be 6: ", 6, cityCoins.findMaxX(s));
    }

    @Test
    public void findMaxX_1() throws Exception {
        CityCoins cityCoins = new CityCoins();
        String _s = "France 1 4 4 4 \n" +
                "Spain 3 1 4 3 \n" +
                "Portugal 1 1 2 2 ";
        String[] s = _s.split("\n");

        assertEquals("must be 6: ", 4, cityCoins.findMaxX(s));
        //*/
    }

    @Test
    public void findMaxY_2() throws Exception {
        CityCoins cityCoins = new CityCoins();
        String _s = "France 1 4 4 4 \n" +
                "Spain 3 1 4 3 \n" +
                "Portugal 1 1 2 2 ";
        String[] s = _s.split("\n");

        assertEquals("must be 6: ", 4, cityCoins.findMaxX(s));
    }

    @Test
    public void valid_1() throws Exception {
        CityCoins cityCoins = new CityCoins();
        String _s = "3\n" +
                "France 1 4 4 6 \n" +
                "Spain 3 1 6 3 \n" +
                "Portugal 1 1 2 2 \n" +
                "0";
        ArrayList<String> s = new ArrayList<String>();
        for (String __s : _s.split("\n"))
            s.add(__s);

        assertTrue(cityCoins.valid(s));
    }

    @Test
    public void valid_2() throws Exception {
        CityCoins cityCoins = new CityCoins();
        String _s = "3\n" +
                "France 1 4 4 6 \n" +
                "Spain 3 1 6 3 \n" +
                "Portugal 1 1 2 2 \n" +
                "1";
        ArrayList<String> s = new ArrayList<String>();
        for (String __s : _s.split("\n"))
            s.add(__s);

        assertFalse(cityCoins.valid(s));
    }

    @Test
    public void valid_3() throws Exception {
        CityCoins cityCoins = new CityCoins();
        String _s;
        ArrayList<String> s = new ArrayList<String>();

        _s = "3\n" +
                "France 1 4 4 6 \n" +
                "Spain 3 1 6 3 \n" +
                "0";
        s.clear();
        s = new ArrayList<String>();
        for (String __s : _s.split("\n"))
            s.add(__s);

        assertFalse(cityCoins.valid(s));
    }

    @Test
    public void valid_4() throws Exception {
        CityCoins cityCoins = new CityCoins();
        String _s;
        ArrayList<String> s = new ArrayList<String>();


        _s = "3\n" +
                "France 1 4 4 6 \n" +
                "Spain 3 1 6 3 \n" +
                "Portugal 1 1 2 2 \n" +
                "Portugal 1 1 2 2 \n" +
                "0";
        s.clear();
        s = new ArrayList<String>();
        for (String __s : _s.split("\n"))
            s.add(__s);

        assertFalse(cityCoins.valid(s));
    }

    @Test
    public void valid_5() throws Exception {
        CityCoins cityCoins = new CityCoins();
        String _s;
        ArrayList<String> s = new ArrayList<String>();


        _s =
                "France 1 4 4 6 \n" +
                "Spain 3 1 6 3 \n" +
                "Portugal 1 1 2 2 \n" +
                "0";
        s.clear();
        s = new ArrayList<String>();
        for (String __s : _s.split("\n"))
            s.add(__s);

        assertFalse(cityCoins.valid(s));
    }

    @Test
    public void valid_6() throws Exception {
        CityCoins cityCoins = new CityCoins();
        String _s;
        ArrayList<String> s = new ArrayList<String>();

        _s = "3\n" +
                "France 1 4 4 6 \n" +
                "Spain 3 1 6 3 \n" +
                "Portugal 1 1 2 \n" +
                "1";
        s.clear();
        s = new ArrayList<String>();
        for (String __s : _s.split("\n"))
            s.add(__s);

        assertFalse(cityCoins.valid(s));
    }

}