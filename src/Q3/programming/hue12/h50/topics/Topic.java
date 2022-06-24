package Q3.programming.hue12.h50.topics;

import java.util.Objects;

public class Topic {
    String _topic;

    public Topic(String topic) {
        _topic = topic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topic topic = (Topic) o;
        return Objects.equals(_topic, topic._topic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_topic);
    }

    public void setTopic(String topic) {
        _topic = topic;
    }

    public String getTopic() {
        return _topic;
    }
}
