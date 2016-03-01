public class Name {
    private String first;

    private String last;

    private String gender;

    public Name(String firstName, String lastName, String gender) {
        this.first = firstName;
        this.last = lastName;
        this.gender = gender;
    }

    private String getPrefix(){
        if(gender.equals("Male"))
            return "Mr";
        return "Ms";
    }

    private String addPrefix(String fullname){
        return getPrefix() + " " + fullname;
    }

    @Override
    public String toString(){
        return firstNameFirst();
    }

    public String firstNameFirst(){
        return addPrefix(first + " " + last);
    }

    public String lastNameFirst(){
        return addPrefix(last + ", " + first);
    }
}
