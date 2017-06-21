package sample;

import java.util.ArrayList;
import java.util.Collections;

public class CityCoins {
    private ArrayList<String> output = new ArrayList<String>();

    public ArrayList<String> setCities(String cities_strings) {
        ArrayList<String> input = new ArrayList<String>();

        Collections.addAll(input, cities_strings.split("\n"));

        if(!valid(input)){
            output.add("not valid");
            return output;
        }

        for(int i=0, index=0; input.get(i).charAt(0)!='0';i++,index++) {
            String[] s = new String[Integer.parseInt(input.get(i))];

            for (int j = 0; j < s.length; j++)
                s[j] = input.get(++i);

            makeCoinsMovement(s, index, findMaxX(s), findMaxY(s));
        }
        return output;
    }

    public int findMaxX(String[] strings){
        int max = 0;
        for(String s: strings){
            String[] _tmp = s.split(" ");
            if(Integer.parseInt(_tmp[3])>max)
                max = Integer.parseInt(_tmp[3]);
        }
        return max;
    }

    public int findMaxY(String[] strings){
        int max = 0;
        for(String s: strings){
            String[] _tmp = s.split(" ");
            if(Integer.parseInt(_tmp[4])>max)
                max = Integer.parseInt(_tmp[4]);
        }
        return max;
    }

    public boolean valid(ArrayList<String> input){
        if(!input.get(input.size() - 1).equals("0"))
            return false;

        for(int i=0; i<input.size(); i++){
            int size;
            try {
                size = Integer.parseInt(input.get(i));
            }catch (Exception e){
                return false;
            }
            for(int j=0; j<size; j++, i++)
                if(input.get(i+1).split(" ").length!= 5)
                    return false;
        }

        return true;
    }

    private void makeCoinsMovement(String[] s, int index, int max_x, int max_y){
        Country[] countries = new Country[s.length];
        CityGrid[][] cityGrid = new CityGrid[max_x+2][max_y+2];
        for(int i=0; i< s.length; i++){
            String[] _tmp = s[i].split(" ");

            countries[i] = new Country();
            countries[i].name = _tmp[0];
            countries[i].xl   = Integer.parseInt(_tmp[1]);
            countries[i].yl   = Integer.parseInt(_tmp[2]);
            countries[i].xh   = Integer.parseInt(_tmp[3]);
            countries[i].yh   = Integer.parseInt(_tmp[4]);
        }
        createCountry(countries, cityGrid);
        checkCountriesFilled(cityGrid);

        int i=0;
        for(; !checkCountriesFilled(cityGrid); i++)
            sendCoins(cityGrid);

        output.add("Case Number "+(index+1));
        output.add(""+i);
    }

    private void createCountry(Country[] countries, CityGrid[][] cityGrid){

        for(int i=0; i<cityGrid.length;i++)
            for(int j=0; j<cityGrid[i].length; j++)
                cityGrid[i][j] = new CityGrid();

        for(int n = 0; n<countries.length; n++){
            for(int i=countries[n].xl; i<=countries[n].xh; i++)
                for(int j=countries[n].yl; j<=countries[n].yh; j++){
                    cityGrid[i][j].coins = new Coins[countries.length];
                    for(int m=0; m<countries.length; m++) {
                        cityGrid[i][j].coins[m] = new Coins();
                        cityGrid[i][j].coins[m].count = m==n ? 1000000 : 0;
                        cityGrid[i][j].itUsed = true;
                    }
                }
        }
    }

    private boolean checkCountriesFilled(CityGrid[][] cityGrid){
        for(CityGrid ci[]: cityGrid)
            for(CityGrid c: ci)
                if(c.itUsed)
                    for(Coins i: c.coins)
                        if(i.count == 0)
                            return false;
        return true;
    }

    private void sendCoins(CityGrid[][] cityGrid){
        calculateTransactionAmount(cityGrid);
        makeTransaction(cityGrid);
    }

    private void calculateTransactionAmount(CityGrid[][] cityGrid){
        for(CityGrid ci[]: cityGrid)
            for(CityGrid c: ci)
                if(c.itUsed)
                    for(int i=0; i<c.coins.length; i++)
                        c.coins[i].transaction_amount = c.coins[i].count/1000;
    }

    private void makeTransaction(CityGrid[][] cityGrid){
        for(int i=0; i<cityGrid.length; i++)
            for(int j=0; j<cityGrid[i].length; j++)
                if(cityGrid[i][j].itUsed){

                    if(cityGrid[i][j-1].itUsed){
                        for(int n=0; n<cityGrid[i][j].coins.length; n++){
                            cityGrid[i][j].coins[n].count -= cityGrid[i][j].coins[n].transaction_amount;
                            cityGrid[i][j-1].coins[n].count += cityGrid[i][j].coins[n].transaction_amount;
                        }
                    }

                    if(cityGrid[i][j+1].itUsed){
                        for(int n=0; n<cityGrid[i][j].coins.length; n++){
                            cityGrid[i][j].coins[n].count -= cityGrid[i][j].coins[n].transaction_amount;
                            cityGrid[i][j+1].coins[n].count += cityGrid[i][j].coins[n].transaction_amount;
                        }
                    }

                    if(cityGrid[i-1][j].itUsed){
                        for(int n=0; n<cityGrid[i][j].coins.length; n++){
                            cityGrid[i][j].coins[n].count -= cityGrid[i][j].coins[n].transaction_amount;
                            cityGrid[i-1][j].coins[n].count += cityGrid[i][j].coins[n].transaction_amount;
                        }
                    }

                    if(cityGrid[i+1][j].itUsed){
                        for(int n=0; n<cityGrid[i][j].coins.length; n++){
                            cityGrid[i][j].coins[n].count -= cityGrid[i][j].coins[n].transaction_amount;
                            cityGrid[i+1][j].coins[n].count += cityGrid[i][j].coins[n].transaction_amount;
                        }
                    }
                }
    }
}
