public class Female implements Gender{
    final private String gender = "Female";

    final private String prefix = "Ms";

    @Override
    public String getPrefix() {
        return prefix;
    }
}
