package au.edu.unsw.infs3634.tourismguide;

import java.util.ArrayList;

public class Attraction {

    private String name;
    private int icon;
    private String rating;
    private String type;
    private String price;
    private String location;
    private String address;
    private String blurb;
    private String comments;
    private String website;
    private String phoneNo;


    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Attraction (String name, int icon, String rating, String type, String location, String price,
                       String address, String blurb, String comments, String website, String phoneNo) {
        this.name = name;
        this.icon = icon;
        this.rating = rating;
        this.type = type;
        this.location = location;
        this.price = price;
        this.address = address;
        this.blurb = blurb;
        this.comments = comments;
        this.website = website;
        this.phoneNo = phoneNo;
    }

    public static ArrayList<Attraction> getAttractions() {
        ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction("Marrickville Pork Roll", R.drawable.pork_roll, "5.0", "Vietnamese restaurant", "Marrickville", "$", "236 Illawarra Rd, Marrickville NSW 2204", "Popular counter-service nook, specialising in Vietnamese rolls filled with pork and other meats.", "Where else can you get a healthy & fufilling lunch for less than 5 bucks?", "https://bit.ly/37CXg6f", "0479 000 445"));
        attractions.add(new Attraction("Messina", R.drawable.messina, "5.0", "Ice cream shop", "Haymarket", "$", "Shop 02/3 Little Hay St, Haymarket NSW 2000", "Popular gelato store, offering over 40 flavours, gelato cakes and weekly specials", "Did you know all gelato at Messina is homemade!", "gelatomessina.com", "9188 6259"));
        attractions.add(new Attraction("Koi Dessert Bar", R.drawable.koi , "4.5", "Dessert restaurant", "Chippendale", "$$$", "46 Kensington St, Chippendale NSW 2008", "KOI Dessert Bar is Sydney’s leading dessert-focused restaurant offering both a casual patisserie-style café and a dining room experience.", "Head Chef Reynold was featured on Masterchef Australia!", "https://www.koidessertbar.com.au", "9212 1230"));
        attractions.add(new Attraction("Royal National Park", R.drawable.royal_national, "4.5", "National Park", "Sutherland", "$", "Sir Bertram Stevens Dr, Royal National Park NSW 2233", "The Royal National Park was established in 1879 and spans 160 square kilometers. Many Sydneysiders treat it an extended backyard, where they can enjoy nature at its finest.", "Best place in Sydney for a bushwalk", "https://www.nationalparks.nsw.gov.au/visit-a-park/parks/royal-national-park", "9542 0648"));
        attractions.add(new Attraction("Darling Square", R.drawable.darling_square, "4.5", "Shopping mall", "Haymarket", "$$", "35 Tumbalong Bvd, Haymarket NSW 2000", "Hip, modern complex of specialty shops, diverse eateries & bars in vibrant, urban surrounds.", "One of Sydney's best places to chill in the CBD", "https://www.darlingsq.com", "0491 159 283"));
        attractions.add(new Attraction("Taronga Zoo", R.drawable.taronga, "4.5", "Zoo", "Mosman", "$$", "Bradleys Head Rd, Mosman NSW 2088", "Harbourside animal attraction with over 340 separate species and a ferry service to the city centre", "Amazing place to take the kids!", "https://taronga.org.au/sydney-zoo", "9969 2777"));
        attractions.add(new Attraction("Bar Luca", R.drawable.bar_luca, "4.0", "Bar", "CBD", "$$", "52 Phillip St, Sydney NSW 2000", "Smart space with comfy leather booths, a wood floor and a terrace, for creative burgers & drinks", "Blame Canada is a must try!", "barluca.com.au", "9247 9700"));
        attractions.add(new Attraction("Royal Botanic Garden", R.drawable.royal_botanic, "4.0", "Botanic Garden", "CBD", "$", "Mrs Macquaries Rd, Sydney NSW 2000", "Harbourside haven for city wildlife with a rose garden, fernery and 'Jurassic Jungle' for kids", "Garden in the heart of Sydney", "https://www.rbgsyd.nsw.gov.au", "9231 8111"));
        attractions.add(new Attraction("Sydney Opera House", R.drawable.opera_house, "3.5", "Performing Arts Centre", "CBD", "$$", "Bennelong Point, Sydney NSW 2000", "Landmark, skyline-dominating arts centre for opera, theatre, music and dance, plus guided tours", "Expensive but Bennelong is one of the best restaurants in Sydney!", "https://www.sydneyoperahouse.com/", "9250 7111"));
        attractions.add(new Attraction("The Grounds", R.drawable.grounds, "3.5", "Cafe", "Alexandria", "$$", "7a/2 Huntley St, Alexandria NSW 2015", "Homestyle food and specialty coffee in a former pie factory with brick walls and an organic garden.", "Perfect for Instagram!", "https://thegrounds.com.au/", "9699 2225"));
        return attractions;
    }
}
