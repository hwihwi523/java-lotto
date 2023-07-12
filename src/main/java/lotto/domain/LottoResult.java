package lotto.domain;

import java.util.Objects;

public class LottoResult {

    private final int matchCount;
    private final boolean isMatchBonus;
    private final WinningCriteria winningCriteria;

    public LottoResult(final int matchCount, final boolean isMatchBonus, final WinningCriteria winningCriteria) {
        this.matchCount = matchCount;
        this.isMatchBonus = isMatchBonus;
        this.winningCriteria = winningCriteria;
    }

    public LottoResult(final int matchCount, final boolean isMatchBonus) {
        this(matchCount, isMatchBonus, WinningCriteria.winningResult(matchCount, isMatchBonus));
    }

    public WinningCriteria getWinningCriteria() {
        return this.winningCriteria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoResult that = (LottoResult) o;
        return matchCount == that.matchCount && isMatchBonus == that.isMatchBonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount, isMatchBonus);
    }
}
