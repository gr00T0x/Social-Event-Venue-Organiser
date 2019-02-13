public class Suggestions {

    // attribute of the class Suggestions

    private String newSuggestion;

    //constructor

    public Suggestions(String newSuggestion) {

        this.newSuggestion = newSuggestion;
    }


    // create getters


    public String getNewSuggestion() {

        return this.newSuggestion;
    }

    // create setters

    public void setNewSuggestion(String addedSuggestion) {
        this.newSuggestion = addedSuggestion;
    }
}