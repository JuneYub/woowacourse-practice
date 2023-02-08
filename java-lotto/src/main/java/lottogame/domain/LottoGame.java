package lottogame.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lottogame.domain.machine.LottoTicketIssueMachine;
import lottogame.domain.number.LottoWinningNumbers;
import lottogame.domain.ticket.LottoTickets;

public class LottoGame {
	private static final int INIT_COUNT = 0;
	
	private final LottoTicketIssueMachine lottoTicketIssueMachine;
	
	public LottoGame(final LottoTicketIssueMachine lottoTicketIssueMAchine) {
		this.lottoTicketIssueMachine = lottoTicketIssueMachine;
	}
	
	public LottoTickets issueManualTickets(final List<List<Integer>> manualTicketNumbers) {
		return this.lottoTicketIssueMachine.issuManualTickets(manualTicketNumbers);
	}
	
	public LottoTickets issueAutoTickets() {
		return this.lottoTicketIssueMachine.issueAutoTickets();
	}
	
	public MatchResult getMatchingResult(final LottoTickets lottoTickets, final LottoWinningNumbers lottoWinningNumbers) {
		return new MatchResults(lottoTickets.getMatchingResult(lottoWinningNumbers, initMatchingResults()));
	}
	
	public double getYield(final MatchResults matchResults) {
		return matchResults.totalWinningPrice() / matchResults.totalInvestment();
	}
	
	private Map<Rank, Inreger> initMatchingResult() {
		Map<Rank, Integer> matchingResults = new EnumMap<>(Rank.class);
		for(Rank rank : Rank.values()) {
			mathcingResult.put(rank, INIT_COUNT);
		}
		return matchingResults;
	}
  
}
