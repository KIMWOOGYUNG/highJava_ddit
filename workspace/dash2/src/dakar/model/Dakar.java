package dakar.model;

public class Dakar {
    private int id;
    private String teamName;
    private String nameSurname;
    private String sponsors;
    private String racingCars;
    private int members;
    private int userid;

    public Dakar(int id, String teamName, String nameSurname, String sponsors, String racingCars, int members, int userid) {
        this.id = id;
        this.teamName = teamName;
        this.nameSurname = nameSurname;
        this.sponsors = sponsors;
        this.racingCars = racingCars;
        this.members = members;
        this.userid = userid;
    }

    public Dakar(String teamName, String nameSurname, String sponsors, String racingCars, int members, int userid) {
        this.teamName = teamName;
        this.nameSurname = nameSurname;
        this.sponsors = sponsors;
        this.racingCars = racingCars;
        this.members = members;
        this.userid = userid;
    }

    public Dakar() {

    }

    public int getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getSponsors() {
        return sponsors;
    }

    public void setSponsors(String sponsors) {
        this.sponsors = sponsors;
    }

    public String getRacingCars() {
        return racingCars;
    }

    public void setRacingCars(String racingCars) {
        this.racingCars = racingCars;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "\nDakar " +
                " teamName='" + teamName + '\'' +
                ", nameSurname='" + nameSurname + '\'' +
                ", sponsors='" + sponsors + '\'' +
                ", racingCars='" + racingCars + '\'' +
                ", members=" + members + '\'' +
                ", ueserid" + userid;
    }
}
