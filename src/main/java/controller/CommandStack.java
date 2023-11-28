package controller;

import command.Command;

import java.util.Stack;

public class CommandStack {
    private final Stack<Command> undoStack;
    private final Stack<Command> redoStack;

    public CommandStack(){
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public void push(Command command){
        redoStack.clear();
        undoStack.push(command);
    }

    public Command undo(){
        if (!undoStack.isEmpty()){
            redoStack.push(undoStack.pop());
        }

        return undoStack.peek();
    }

    public Command redo(){
        if (!redoStack.isEmpty()){
            undoStack.push(redoStack.pop());
        }
        return undoStack.peek();
    }
}
