package Q3.programming.hue3.src;

/**
 * Container objects provide storage facility for Data objects.
 * Only one data object is removable.
 */
public interface Container {
/**
 * Returns true, if this container is empty
 */
	public boolean isEmpty();
/**
 * Effects: Returns the accessible element of the container and removes it
 * Requires: isEmpty() == false
 */
	public Data remove();
/**
 * Adds <d> to this container
 */
	public void push(Data d);
}
