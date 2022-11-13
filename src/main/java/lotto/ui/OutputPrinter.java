package lotto.ui;

import lotto.domain.WinningNumbers;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputPrinter {
    public OutputPrinter() {}

    public void printPurchasedNumbers(long bundleSize, List<List<Integer>> lottoBundle) {
        System.out.println(bundleSize + "개를 구매했습니다.");

        for (List<Integer> singleLotto : lottoBundle) {
            System.out.println(singleLotto);
        }
    }

    public void printWinningStatistics(Map<WinningNumbers, Integer> winningCase) {
        System.out.println("당첨 통계");
        System.out.println("---");

        WinningNumbers[] allWinningNumbers = WinningNumbers.values();
        for (int winningNumberIndex = 0; winningNumberIndex < allWinningNumbers.length - 1; winningNumberIndex++) {
            WinningNumbers key = allWinningNumbers[winningNumberIndex];
            int matches = key.getMatch();
            long reward = key.getReward();
            long winningCounter = winningCase.get(key);
            DecimalFormat commaInMoney = new DecimalFormat("###,###");

            System.out.println(matches + "개 일치 (" + commaInMoney.format(reward) + "원) - " + winningCounter + "개");
        }
    }

    public void printRewardRate(double rawRatio) {
        System.out.println("총 수익률은 "+ String.format("%.1f", rawRatio) + "%입니다.");
    }
}
