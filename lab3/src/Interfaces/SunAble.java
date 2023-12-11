package src.Interfaces;
import src.Bin.Sun;
import src.Bin.Swell;
import src.Enums.Colors;
import src.Enums.Disntance;
import src.Enums.Places;
import src.Enums.Speeds;
import src.Enums.Times;


public interface SunAble {

void slope(Speeds insertSpeed, Sun insertSmth,Times insertTimes);
void setColour(Swell insertSwell, Colors insertColour, Colors inserColour2);
void blazed(Times insertTimes,Sun insertSmth,Places insertPlace,Places insertPlace1,Disntance insertDisntance);

}
