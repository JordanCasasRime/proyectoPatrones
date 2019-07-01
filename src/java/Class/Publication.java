package Class;

public class Publication {

    private String title;
    private String description;
    private String date;
    private String categoria;
    private int publicactionId;

    public Publication(String title, String description, String date, String categoria, int publicactionId) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.categoria = categoria;
        this.publicactionId = publicactionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String Title) {
        this.title = Title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String Date) {
        this.date = Date;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getPublicactionId() {
        return publicactionId;
    }

    public void setPublicactionId(int publicactionId) {
        this.publicactionId = publicactionId;
    }
    
}
