package src.Interfaces;

import src.Bin.Human;
import src.Bin.Place;
import src.Enums.MentalState;
import src.Exceptions.UnderstandException;

public interface HapsAble {

void understand(boolean bool) throws UnderstandException;

void incomeRise( Place place,int in);

void blink( Human policeMan, Place place);

void sane(Human vlad, MentalState state, MentalState state2);

void dontAgreeToShow(Human human);


}
