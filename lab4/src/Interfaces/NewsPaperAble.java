package src.Interfaces;

import src.Bin.City;
import src.Bin.Human;
import src.Enums.Times;

public interface NewsPaperAble {

    void appearance(Human human);

    void newsApper(Times time, City city, Human human);
}
