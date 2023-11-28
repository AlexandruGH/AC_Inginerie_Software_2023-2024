package command;

import model.SimpleModel;

public class ChangeFieldCommand implements Command{
    private final String text;
    private final SimpleModel model;

    public ChangeFieldCommand(String text, SimpleModel sampleModel){
        this.text = text;
        this.model = sampleModel;
    }

    @Override
    public void execute() {
        model.setField(text);
    }
}
