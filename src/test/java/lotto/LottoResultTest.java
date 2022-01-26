package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class LottoResultTest {

    @Test
    void 로또_수익률() {
        Lotto winningLotto = new Lotto(new LottoNumbers(Arrays.stream(IntStream.rangeClosed(1, 6).toArray()).boxed().map(LottoNumber::new).collect(Collectors.toList())));
        Lottos lottos = new Lottos(
                Arrays.asList(
                        new Lotto(new LottoNumbers(Arrays.stream(new int[]{1, 2, 3, 11, 12, 13}).boxed().map(LottoNumber::new).collect(Collectors.toList()))),
                        new Lotto(new LottoNumbers(Arrays.stream(new int[]{1, 2, 3, 21, 22, 23}).boxed().map(LottoNumber::new).collect(Collectors.toList())))
                )
        );
        LottoResult lottoPrizes = new LottoResult(lottos, winningLotto);
        assertThat(lottoPrizes.rateOfReturn()).isEqualTo(5.0f);
    }
}
