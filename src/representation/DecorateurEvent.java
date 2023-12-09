package representation;
/**
 * The DecorateurEvent class is an abstract class that implements the Event interface
 * by delegating the implementation to a decoratedEvent. It serves as a base class for
 * decorators that add additional behavior to an existing Event.
 */

public abstract class DecorateurEvent implements Event {
	/**
     * The decoratedEvent instance that this decorator wraps.
     */
    protected Event decoratedEvent;

    /**
     * Constructs a DecorateurEvent with the specified decoratedEvent.
     *
     * @param decoratedEvent The Event to be decorated.
     */
    public DecorateurEvent(Event decoratedEvent) {
        this.decoratedEvent = decoratedEvent;
    }

    /**
     * Delegates the display method to the decoratedEvent.
     */
    @Override
    public void display() {
        decoratedEvent.display();
    }
    
    
    /**
     * Delegates the chooseNext method to the decoratedEvent.
     *
     * @return The next Event chosen by the decoratedEvent.
     */
    @Override
    public Event chooseNext() {
        return decoratedEvent.chooseNext();
    }
}
