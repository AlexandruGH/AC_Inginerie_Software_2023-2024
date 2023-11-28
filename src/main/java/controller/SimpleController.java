package controller;

import command.ChangeFieldCommand;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.SimpleModel;
import view.SampleView;

import java.util.Observable;
import java.util.Observer;

public class SimpleController implements Observer {
    private final CommandStack commandStack;
    private final SampleView view;
    private final SimpleModel model;

    public SimpleController(SampleView view, SimpleModel model){
        this.commandStack = new CommandStack();

        this.view = view;
        this.model = model;
        view.addUpdateButtonListener(new UpdateButtonListener());
        view.addUndoButtonListener(new UndoButtonListener());
        view.addRedoButtonListener(new RedoButtonListener());

        model.addObserver(this);
        commandStack.push(new ChangeFieldCommand("", model));
    }

    @Override
    public void update(Observable o, Object arg) {
        view.updateFirstFieldText(model.getField());
        view.updateSecondFieldText(model.getField());
    }

    private class UpdateButtonListener implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            ChangeFieldCommand command = new ChangeFieldCommand(view.getFirstFieldText(), model);
            commandStack.push(command);
            command.execute();
        }
    }

    private class UndoButtonListener implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            commandStack.undo().execute();
        }
    }

    private class RedoButtonListener implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            commandStack.redo().execute();
        }
    }

}
