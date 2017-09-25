package el1000mile.tpd2.b5twa.navdrawer;

/**
 * Created by KeMoOoOoO on 9/18/2017.
 */

class News {
    String title;
    String desc;
    String by;
    String date;
    String img;
    String URL;








    public News(String title, String desc, String by, String date, String img , String URL) {
        this.title = title;
        this.desc = desc;
        this.by = by;
        this.date = date;
        this.img = img;
        this.URL = URL;
    }


    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
