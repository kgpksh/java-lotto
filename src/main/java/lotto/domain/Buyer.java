package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    public Buyer() {}

    public long countLottos (long money) throws IllegalArgumentException {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위만 가능합니다");
        }

        return money / 1000;
    }

    public List<List<Integer>> receiveLottos(long lottoNumbers) {
        final int minimumNumber = 1;
        final int maximumNumber = 45;
        final int lottoLength = 6;
        List<List<Integer>> bundleOfLottos = new ArrayList<>();

        for (long buyingCounter = 0; buyingCounter < lottoNumbers; buyingCounter++) {
            List<Integer> singleLotto = Randoms.pickUniqueNumbersInRange(minimumNumber,maximumNumber,lottoLength);
            bundleOfLottos.add(singleLotto);
        }
        
        return bundleOfLottos;
    }
}
