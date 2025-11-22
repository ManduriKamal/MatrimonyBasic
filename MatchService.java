package com.Matrimony;

public interface MatchService {
    Candidate[] findMatches(Candidate user, Candidate[] allCandidates, int count);
}

