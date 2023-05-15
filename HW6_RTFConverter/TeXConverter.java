public class TeXConverter implements FormatConverter{
    @Override
    public String convertCharacter() {
        return "c";

    }

    @Override
    public String convertFontChange() {
        return "_";
    }

    @Override
    public String convertParagraph() {
        return "|";
    }
}
