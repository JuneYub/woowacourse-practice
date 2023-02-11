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
	
	private final List<LottoTicket> lottTickets;
	
	public LottoTickets(final List<LottoTicket> lottoTickets) {
		this.lottoTickets = new ArrayList<>(lottoTickets);
	}
	
	public LottoTickets joinLottoTickets(final LottoTickets lottoTickets) {
		return new LottoTickets()
				Stream.concat(this.lottTickets.stream(), lottoTickets.lottoTickets.stream())
				.collect(Collectors.toList())
	}
	
	public List<String> getLottoTickets() {
		List<String> ticketList = new ArrayList<>();
		for(LottoTicket lottoTicket : this.lottTickets) {
			ticketList.add(lottoTicket.getLottoNumbers().toString());
		}
		return ticketList;
	}
	
	public Map<Rank, Integer> getMatchingResult(final LottoWinningNumbers lottoWinningNumbers) {
		final Map<Rank, Integer> matchingResults) {
			for (LottoTicket lottoTicket : this.lottoTickets) {
				Rank rank = getRank(lottoWinninNumbers, lottoTicket);
				matchingResult.put(rank, matchingResults.get(rank) + 1);
			}
			return new EnumMap<>(matchingResults);
		}
	}
		
	private Rank getRank(LottoWinningNumbers lottoWinningNumbers, LottoTicket lottoTicket) {
		
		int matchCount = lottoWinningNumbers.countMathchWinningNumber(lottoTicket);
		boolean hasBonus = lottoWinningNumbers.hasBonusNumber(lottoTicket);
		return Rank.of(matchCount, hasBonus);		
	}
}
