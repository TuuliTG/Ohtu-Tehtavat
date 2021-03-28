
package ohtu;

public class Player {
    private String name;
    private String team;
    private String nationality;
    private int assists;
    private int goals;
    private int penalties;
    private int games;
    private int score;
    

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getNationality() {
        return nationality;
    }

    public int getAssists() {
        return assists;
    }

    public int getGoals() {
        return goals;
    }

    public int getPenalties() {
        return penalties;
    }

    public int getGames() {
        return games;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }

    public void setGames(int games) {
        this.games = games;
    }
    
    public int getScore() {
        return goals + assists;
    }
    
    

    @Override
    public String toString() {
        return name + "\tteam " + team + "\t" + goals + " + " + assists + " = " + this.getScore(); 
    }
    
    
      
}
