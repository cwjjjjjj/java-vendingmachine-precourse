package vendingmachine.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;

import java.util.ArrayList;
import java.util.List;

public class Coins {

    int size = Coin.values().length;

    private int[] Coins = new int[size];

    public void initCoins(int total) {
        Coin[] coinType = Coin.values();
        while(total > 0) {
            for(int i = 0; i < size; i++) {
                int possibleCoin = total / coinType[i].getAmount();
                if(possibleCoin > 1) {
                    Coins[i] += pickNumberInList();
                }
            }
        }
    }
}
