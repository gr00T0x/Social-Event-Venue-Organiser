public class Venue {

    // attributes of the class Venue
    private int id;
    private String venueName;
    private String venueCat;
    private double venueLat;
    private double venueLon;
    private String venueDescr;
    private String venueRes;
    private int venueVotes;

    //constructor

    public Venue(int id, String venueName, String venueCat, double venueLat, double venueLon, String venueDescr, String venueRes, int venueVotes) {

        this.id = id;
        this.venueName = venueName;
        this.venueCat = venueCat;
        this.venueLat = venueLat;
        this.venueLon = venueLon;
        this.venueDescr = venueDescr;
        this.venueRes = venueRes;
        venueVotes = 0;
    }


    // create getters


    public int getID() {

        return this.id;
    }



    public String getVenueName()  {

        return this.venueName;

    }

    public String getVenueCat()  {

        return this.venueCat;

    }
    public double getVenueLat()  {

        return this.venueLat;

    }
    public double getVenueLon()  {

        return this.venueLon;

    }
    public String getVenueDescr()  {

        return this.venueDescr;

    }
    public String getVenueRes()  {

        return this.venueRes;

    }

    public int getVenueVotes() {

        return this.venueVotes;
    }

    // create setters

    public void setID(int newID){


        this.id = newID;
    }


    public void setVenueName(String newVenueName)  {

        this.venueName = newVenueName;

    }

    public void setVenueCat(String newVenueCat)  {

        this.venueCat = newVenueCat;

    }

    public void setVenueLat(double newVenueLat)  {

        this.venueLat = newVenueLat;

    }

    public void setVenueLon(double newVenueLon)  {

        this.venueLon = newVenueLon;

    }

    public void setVenueDescr(String newVenueDescr)  {

        this.venueDescr = newVenueDescr;

    }

    public void setVenueRes(String newVenueRes)  {

        this.venueRes = newVenueRes;

    }

    public void setVenueVotes () {

        // ++ means the votes increment by +1 each time a user votes for an option

        this.venueVotes++;
    }
}