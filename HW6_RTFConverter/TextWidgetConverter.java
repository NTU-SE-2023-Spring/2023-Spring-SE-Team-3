public class TextWidgetConverter implements FormatConverter{
    @Override
    public String convertCharacter() {
        return "<Char>";

    }

    @Override
    public String convertFontChange() {
        return "<Font>";
    }

    @Override
    public String convertParagraph() {
        return "<Paragraph>";
    }
}
