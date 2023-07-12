package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class BoughtLottos {

    private final int count;
    private final List<Lotto> lottos;

    public BoughtLottos(final List<Lotto> lottos) {
        this.count = lottos.size();
        this.lottos = lottos;
    }

    public LottoResults winningResults(final Lotto winningLotto, final Ball bonusBall) {
        return new LottoResults(lottos.stream()
                .map(lotto -> lotto.compareWinningLotto(winningLotto, bonusBall))
                .collect(Collectors.toList()));
    }

    public int getCount() {
        return this.count;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
