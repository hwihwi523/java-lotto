package lotto.controller;

import java.util.List;
import lotto.domain.Ball;
import lotto.domain.BoughtLottos;
import lotto.domain.BoughtResult;
import lotto.domain.Count;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResults;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.LottoReader;
import lotto.view.LottoWriter;
import lotto.view.WinningStatistics;

public class LottoController {

    private final LottoReader lottoReader;
    private final LottoWriter lottoWriter;
    private final LottoGenerator lottoGenerator;

    public LottoController(
            final LottoReader lottoReader,
            final LottoWriter lottoWriter,
            final LottoGenerator lottoGenerator
    ) {
        this.lottoReader = lottoReader;
        this.lottoWriter = lottoWriter;
        this.lottoGenerator = lottoGenerator;
    }

    public void startLotto() {
        Money money = lottoReader.readMoney();
        Count count = lottoReader.readCount(money);
        List<Lotto> manualLottos = lottoReader.readManualLottos(count);
        BoughtResult manualBoughtResult = lottoGenerator.generateManually(money, manualLottos);

        BoughtResult boughtResult = lottoGenerator.generate(manualBoughtResult.getChange());

        BoughtLottos boughtLottos = BoughtLottos.merge(
                manualBoughtResult.getBoughtLottos(), boughtResult.getBoughtLottos());
        lottoWriter.printBoughtLottos(boughtLottos);

        Lotto winningBalls = lottoReader.readWinningLotto();
        Ball bonusBall = lottoReader.readBonusBall();
        WinningLotto winningLotto = new WinningLotto(winningBalls, bonusBall);

        LottoResults lottoResults = boughtLottos.winningResults(winningLotto);
        WinningStatistics winningStatistics = new WinningStatistics(lottoResults);
        lottoWriter.printLottoStatistics(winningStatistics);
    }
}
