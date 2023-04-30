import java.util.concurrent.Delayed;

public interface CommandReader {
    public void reader(String command, Composition delegator);
}

class TextCommandReader implements CommandReader{
    public void reader(String command, Composition delegator){
        String[] splitWords = command.split(" ");
        int id =  Integer.parseInt(splitWords[1]);
        int naturalSize =  Integer.parseInt(splitWords[2]);
        int shrinkability =  Integer.parseInt(splitWords[3]);
        int stretchability =  Integer.parseInt(splitWords[4]);
        String content = splitWords[5];
        delegator.addComponent(new TextComponent(id, naturalSize, shrinkability, stretchability, content));

    }
}


class GraphicalElementCommandReader implements CommandReader{
    public void reader(String command, Composition delegator){
        String[] splitWords = command.split(" ");
        int id =  Integer.parseInt(splitWords[1]);
        int naturalSize =  Integer.parseInt(splitWords[2]);
        int shrinkability =  Integer.parseInt(splitWords[3]);
        int stretchability =  Integer.parseInt(splitWords[4]);
        String content = splitWords[5];
        delegator.addComponent(new GraphicalElementComponent(id, naturalSize, shrinkability, stretchability, content));

    }
}

class ChangeSizeCommandReader implements CommandReader{
    public void reader(String command, Composition delegator){
        String[] splitWords = command.split(" ");
        int id =  Integer.parseInt(splitWords[1]);
        int newSize =  Integer.parseInt(splitWords[2]);
        delegator.changeSizeByComponentId(id, newSize);

    }
}

class RequireCommandReader implements CommandReader{
    public void reader(String command, Composition delegator){
        String[] splitWords = command.split(" ");
        String breakStrategy = splitWords[1];
        BreakStrategy strategy = null;
        if(breakStrategy.equals("SimpleComposition")){
            strategy = new SimpleCompositionStrategy();
        }else if (breakStrategy.equals("TexComposition")){
            strategy = new TexCompositionStrategy();
        }else if (breakStrategy.equals("ArrayComposition")){
            strategy = new ArrayCompositionStrategy();
        }
        delegator.requireNewLayout(strategy);


    }
}