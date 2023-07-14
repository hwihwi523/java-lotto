package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BoughtLottosTest {

    @Test
    @DisplayName("구입한 로또 정상 생성 입력 테스트")
    void boughtLottos_create() {
        /* given */
        List<Lotto> lottos = new ArrayList<>();

        /* when & then */
        assertDoesNotThrow(() -> new BoughtLottos(lottos));
    }

    @Test
    @DisplayName("구입한 로또의 개수 테스트")
    void boughtLottos_count() {
        /* given */
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(LottoTest.getBalls("1", "2", "3", "4", "5", "6")));
        lottos.add(new Lotto(LottoTest.getBalls("1", "2", "3", "4", "5", "6")));

        BoughtLottos boughtLottos = new BoughtLottos(lottos);

        /* when & then */
        assertThat(boughtLottos.getCount()).isEqualTo(lottos.size());
    }

    @Test
    @DisplayName("당첨 확인 테스트")
    void boughtLottos_winning() {
        /* given */
        Lotto winningBalls = new Lotto(LottoTest.getBalls("1", "2", "3", "4", "5", "6"));
        Ball bonusBall = new Ball("7");
        WinningLotto winningLotto = new WinningLotto(winningBalls, bonusBall);

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(LottoTest.getBalls("1", "2", "3", "4", "5", "6")));
        lottos.add(new Lotto(LottoTest.getBalls("1", "2", "3", "4", "5", "7")));
        lottos.add(new Lotto(LottoTest.getBalls("8", "9", "10", "11", "12", "13")));

        BoughtLottos boughtLottos = new BoughtLottos(lottos);

        /* when */
        LottoResults lottoResults =
                boughtLottos.winningResults(winningLotto);

        /* then */
        assertThat(lottoResults.getLottoResults()).containsExactlyInAnyOrder(
                WinningCriteria.FIRST,
                WinningCriteria.SECOND,
                WinningCriteria.NONE
        );
    }
}
