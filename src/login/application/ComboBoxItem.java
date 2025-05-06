package login.application;

public class ComboBoxItem {
    private int userId;
    private String username;

    public ComboBoxItem(int userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return username;  // This is what shows in the combo box
    }
}
