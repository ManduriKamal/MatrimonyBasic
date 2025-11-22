package com.Matrimony;

public class MatrimonyManager implements MatchService {

    private Candidate[] candidates = new Candidate[50]; // max 50 profiles
    private int count = 0;

    public void registerCandidate(Candidate c) {
        if (count < candidates.length) {
            candidates[count] = c;
            count++;
        } else {
            System.out.println("Database is full!");
        }
    }

    public void showAll() {
        if (count == 0) {
            System.out.println("No profiles available.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(candidates[i]);
        }
    }

    @Override
    public Candidate[] findMatches(Candidate user, Candidate[] list, int total) {

        Candidate[] results = new Candidate[50];
        int matchCount = 0;

        for (int i = 0; i < total; i++) {
            Candidate c = list[i];

            // Skip same gender
            if (c.getGender().equalsIgnoreCase(user.getGender()))
                continue;

            boolean ageMatch = Math.abs(c.getAge() - user.getAge()) <= 5;
            boolean cityMatch = c.getCity().equalsIgnoreCase(user.getPreferenceCity());

            if (ageMatch || cityMatch) {
                results[matchCount] = c;
                matchCount++;
            }
        }

        return results;
    }

    public Candidate[] getCandidates() {
        return candidates;
    }

    public int getCount() {
        return count;
    }
}

