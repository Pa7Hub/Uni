package Q3.programming.hue12.h50;

import Q3.programming.hue12.h50.areas.Area;
import Q3.programming.hue12.h50.areas.Booth;
import Q3.programming.hue12.h50.areas.PresentationArea;
import Q3.programming.hue12.h50.people.Person;
import Q3.programming.hue12.h50.topics.Topic;

import java.util.List;

/**
 * All these functions have been moved to the new ExhibitionHallController
 */
@Deprecated
public class ExpertSearcher {
    Topic _topic;
    List<Area> _allAreas;
    List<Person> _responsiblePeople;
    ExhibitionHall _exhibitionHall;

    public ExpertSearcher(ExhibitionHall exhibitionHall) {
        _exhibitionHall = exhibitionHall;
        _allAreas = exhibitionHall.getAreas();
    }

    public List<Person> getExperts(Topic topic) {
        _topic = topic;
        _allAreas.forEach(a -> {
            if (a instanceof Booth && ((Booth) a).getTopic() == _topic) {
                _responsiblePeople.addAll(((Booth) a).getPersonal());
            } else if (a instanceof PresentationArea) {
                ((PresentationArea) a).getPresentations().forEach((p, t) -> {
                    if (t == _topic) {
                        _responsiblePeople.add(p);
                    }
                });
            }
        });
        return _responsiblePeople;
    }

    public List<Person> unclearExpertSearch(String topic) {
        _allAreas.forEach(a -> {
//             FIXME this double getTopic() isn't really good syntax
           if (a instanceof Booth && ((Booth) a).getTopic().getTopic().contains(topic)) {
               _responsiblePeople.addAll(((Booth) a).getPersonal());
           } else if (a instanceof PresentationArea) {
               ((PresentationArea) a).getPresentations().forEach((p,t) -> {
                   if (t.getTopic().contains(topic)) {
                       _responsiblePeople.add(p);
                   }
               });
           }
        });
    return _responsiblePeople;
    }

}
