package representation;

public abstract class DecorateurEvent implements Event {
    protected Event decoratedEvent;

    public DecorateurEvent(Event decoratedEvent) {
        this.decoratedEvent = decoratedEvent;
    }

    // Implement the methods by delegating to the decoratedEvent
    @Override
    public void display() {
        decoratedEvent.display();
    }

    @Override
    public Event chooseNext() {
        return decoratedEvent.chooseNext();
    }
}
