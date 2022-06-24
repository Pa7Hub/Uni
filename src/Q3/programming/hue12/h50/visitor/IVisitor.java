package Q3.programming.hue12.h50.visitor;

import Q3.programming.hue12.h50.areas.Booth;
import Q3.programming.hue12.h50.areas.Gastronomy;
import Q3.programming.hue12.h50.areas.PresentationArea;

public interface IVisitor<T> {
    void handle(Booth booth);
    void handle(Gastronomy gastronomy);
    void handle(PresentationArea presentationArea);
    T getEstablishedData();
}
