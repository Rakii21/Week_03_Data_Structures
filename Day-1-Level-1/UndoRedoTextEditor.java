class TextState {
    String content;
    TextState prev;
    TextState next;

    public TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor {
    private TextState current;
    private int size = 0;
    private final int MAX_HISTORY = 10;

    public void type(String newText) {
        TextState newState = new TextState(newText);

        if (current != null) {
            current.next = newState;
            newState.prev = current;
        }

        current = newState;
        size++;

        if (size > MAX_HISTORY) {
            TextState temp = current;
            while (temp.prev != null && size > MAX_HISTORY) {
                if (temp.prev.prev == null) {
                    temp.prev = null;
                    size--;
                    break;
                }
                temp = temp.prev;
            }
        }
        current.next = null; 
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("No more undo available.");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("No more redo available.");
        }
    }

    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text: " + current.content);
        } else {
            System.out.println("Editor is empty.");
        }
    }
}

public class UndoRedoTextEditor {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.type("Hello");
        editor.displayCurrentState();

        editor.type("Hello, World");
        editor.displayCurrentState();

        editor.type("Hello, World!");
        editor.displayCurrentState();

        System.out.println("Performing Undo...");
        editor.undo();
        editor.displayCurrentState();

        System.out.println("Performing Redo...");
        editor.redo();
        editor.displayCurrentState();

        System.out.println("Typing new text (invalidates redo)...");
        editor.type("Hello, Java World!");
        editor.displayCurrentState();

        System.out.println("Performing Undo...");
        editor.undo();
        editor.displayCurrentState();
    }
}