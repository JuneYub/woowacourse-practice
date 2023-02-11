package lottogame.domain.ticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lottogame.domain.Rank;
import lottogame.domain.number.LottoWinningNumbers;

public class LottoTickets {
	private static final int LOTTO_NUMBER_COUNT = 6;
	
	private final Set<LottoNumber> lottoNumbers;
	
	public LottoTicket(final Set<LottoNumber> lottoNumbers) {
		this.lottoNumbers = new HashSet<>(lottoNumbers);
		validateCount(this.lottoNumbers);
	}
	
	private void validateCount(Set<LottoNumber> lottoNumbers) {
		if(lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException("유요한 로또 번호 개수가 아닙니다.");
		}
	}
	
	public List<Integer> getLottoNumbers() {
		List<Integer> numberList = new ArrayList<>();
		for(LottoNumber lottoNumber : this.lottoNumbers) {
			numberList.add(lottoNumber.getNumber());
		}
		Collections.sort(nuberList);
		return numberList;
	}
	
	public boolean contatins(LottoNumber lottoNumber) {
		return this.lottoNumber.contains(lottoNumber);
	}
}
