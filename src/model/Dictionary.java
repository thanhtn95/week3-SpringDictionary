package model;

public class Dictionary {
    private int id;
    private String englishWord,vnMeaning;

    public Dictionary() {
    }

    public Dictionary(int id, String englishWord, String vnMeaning) {
        this.id = id;
        this.englishWord = englishWord;
        this.vnMeaning = vnMeaning;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    public String getVnMeaning() {
        return vnMeaning;
    }

    public void setVnMeaning(String vnMeaning) {
        this.vnMeaning = vnMeaning;
    }
}
