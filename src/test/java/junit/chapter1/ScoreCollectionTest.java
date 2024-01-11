package junit.chapter1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreCollectionTest {

    @Mock
    ScoreCollection scoreCollection;

    @Test
    void 배열에_점수를_추가하고_더한_값을_2로_나눈다() {

        // given -> 준비
        ScoreCollection collection = new ScoreCollection();
        Scoreable score1 = () -> 5;
        Scoreable score2 = () -> 7;

        // when -> 싫행
        collection.add(score1);
        collection.add(score2);
        int actual = collection.arithmeticMean();

        // then -> 단언
        assertThat(actual).isEqualTo(6);
    }

    @Test
    void 배열에_점수를_추가할_수_있다() {

        // given
        ScoreCollection collection = new ScoreCollection();
        Scoreable score1 = () -> 5;
        Scoreable score2 = () -> 7;

        // when
        collection.add(score1);
        collection.add(score2);

        // then
        assertThat(collection.getScores().size()).isEqualTo(2);
    }

    @Test
    void 만약_Scoreable_객체가_null이면_예외를_던진다() {

        // given
        ScoreCollection collection = new ScoreCollection();
        Scoreable score = null;


        // when, then
        Assertions.assertThatThrownBy(() -> collection.add(score))
                .isInstanceOf(IllegalArgumentException.class);
    }



}