package vendingmachine.controller;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;
import static vendingmachine.view.InputView.input;
import static vendingmachine.view.OutputView.printCoins;
import static vendingmachine.view.OutputView.printHavingMoneyMessage;

import java.util.ArrayList;
import java.util.List;
import vendingmachine.model.Coin;

public class CoinController {

    private static final int size = Coin.values().length;
    private static int[] coins = new int[size];

    public void initMoney() {
        printHavingMoneyMessage();
        initCoins(Integer.parseInt(input()));
    }

    public void initCoins(int total) {
        Coin[] coinType = Coin.values();
        int index = 0;
        while (total > 0) {
            //동전 합이 total이 될 때까지 loop
            //0부터 size까지를 왔다갔다할 인덱스
            int coinPrice = coinType[index].getAmount();
            //현재 index에 해당하는 동전의 액면가
            int possibleCoin = total / coinPrice;
            //현재 index의 동전의 최대 개수
            List<Integer> numberRange = makeNumberRange(possibleCoin);
            //pickNumberInList의 매개변수 타입에 맞게 0부터 possibleCoin까지의 모든 수를 넣은 List
            if (possibleCoin > 0) {
                //가능한 코인 개수가 있으면
                int pickedNumber = pickNumberInList(numberRange);
                //랜덤 돌려서
                coins[index] += pickedNumber;
                //코인 개수에 추가
                total -= coinPrice * pickedNumber;
                //while문 조건에 반영하기 위해 동전개수 * 액면가를 total에서 제해줌
            }
            index++;
            if (index == size) {
                //모든 종류의 코인 다 돌았으면
                index = 0;
                //Index 초기화
            }
        }
        //보유 금액만큼 동전 생성 후 출력
        printCoins(coins);
    }

    private static List<Integer> makeNumberRange(int possibleCoin) {
        List<Integer> numberRange = new ArrayList<>();
        for (int i = 0; i <= possibleCoin; i++) {
            numberRange.add(i);
        }
        return numberRange;
    }
}
