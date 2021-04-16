package ohtu;

public class TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            m_score1 += 1;
        } else {
            m_score2 += 1;
        }
    }

    public String getScore() {
        String score;
        if (m_score1 == m_score2) {
            score = this.tie();
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            score = this.getScoreIfScoreIsMoreThan4();
        } else {
            score = getNameOfScoreForOnePlayer(m_score1) + "-" + getNameOfScoreForOnePlayer(m_score2);
        }
        return score;
    }
    
    private String getNameOfScoreForOnePlayer(int score) {
        String result = "";
        switch(score) {
            case 0:
                result+="Love";
                break;
            case 1:
                result+="Fifteen";
                break;
            case 2:
                result+="Thirty";
                break;
            case 3:
                result+="Forty";
                break;
        }
        return result;
    }
    
    private String getScoreIfScoreIsMoreThan4() {
        String score;
        int minusResult = m_score1-m_score2;
        if (minusResult == 1) {
            score ="Advantage player1";
        } else if (minusResult ==-1) {
            score ="Advantage player2";
        } else if (minusResult>=2) {
            score = "Win for player1";
        } else {
            score ="Win for player2";
        }
        return score;
    }
    
    private String tie() {
        String score;
        switch (m_score1) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }
}