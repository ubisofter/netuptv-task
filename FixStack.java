import java.util.Arrays;

public class FixStack {

  private final Object[] buf;
  private int position;

  public FixStack(int size) {
    buf = new Object[size];
    position = 0;
  }

  public void push(Object o) {
    if (position < buf.length) {
      buf[position++] = o;
    } else {
      throw new StackOverflowError();
    }
  }

  public Object pop() {
    if (position > 0) {
      return buf[--position];
    } else {
      throw new IllegalStateException("FixStack is empty");
    }
  }

  public boolean isEmpty() {
    return (position == 0);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof FixStack)) return false;
    FixStack otherStack = (FixStack) o;
    return Arrays.equals(buf, otherStack.buf) && position == otherStack.position;
  }
}
