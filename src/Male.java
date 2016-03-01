public class Male implements Gender {
    final private String gender = "Male";

    final private String prefix = "Mr";

    @Override
    public String getPrefix() {
        return prefix;
    }
}
