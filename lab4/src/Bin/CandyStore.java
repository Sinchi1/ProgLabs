package src.Bin;

public class CandyStore {

    private String name;

    private Place location; 

    private int workerCount;

    private Korshik korshik = new Korshik("Коржик");

    private Candy candy = new Candy("Конфета Крокунов");

    public CandyStore(String name, Place location, int workerCount) {
        this.name = name;
        this.location = location;
        this.workerCount = workerCount;
    }

    public CandyStore(String name, int workerCount) {
        this.name = name;
        this.workerCount = workerCount;
    }

    public CandyStore(String name) {
        this.name = name;
    }

    public void soldOutKor(){
        String name = this.name;
        String candyName = korshik.getName();
        System.out.print("В тот день "+name+ " продал весь свой запас "+ candyName + ". ");
    }
  
    public void soldOutCandy(){
        String name = this.name;
        String candyName = candy.getName();
        System.out.print("В тот день "+name+ " продал весь свой запас "+ candyName);
    }

    public String getName() {
        return name;
    }

    public Place getLocation() {
        return location;
    }

    public int getWorkerCount() {
        return workerCount;
    }

private class Korshik{

        private String name;

        public Korshik(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

private class Candy{

        private String name;

        public Candy(String name) {
            this.name = name;
        }


        public String getName() {
            return name;
        }


    }
}
