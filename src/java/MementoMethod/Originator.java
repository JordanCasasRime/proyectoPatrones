package MementoMethod;

import Class.Publication;

public class Originator {

    private Publication state;

    public Publication getSaveState() {
        return state;
    }

    public void setSaveState(Publication saveState) {
        this.state = saveState;
    }

    public Memento guardar() {
        return new Memento(state);
    }
    
    public void restaure(Memento m) {
        this.state = m.getState();
    }
}
