package MementoMethod;

import Class.Publication;

public class Memento {
    
    private Publication state;
    
    public Memento (Publication state) {
        this.state = state;
    }
    
    public Publication getState() {
        return state;
    }
    
}
