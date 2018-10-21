public class Chess {
    private final String no, name, fidelID, fED, rtg, club;

    Chess(String test_no, String test_name,String test_fidelID,String test_FED,String test_Rtg,String test_Club) {
        this.no = test_no;
        this.name = test_name;
        this.fidelID = test_fidelID;
        this.fED = test_FED;
        this.rtg = test_Rtg;
        this.club = test_Club;
    }

    public String getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public String getFidelID() {
        return fidelID;
    }

    public String getFED() {
        return fED;
    }

    public String getRtg() {
        return rtg;
    }

    public String getClub() {
        return club;
    }
}
