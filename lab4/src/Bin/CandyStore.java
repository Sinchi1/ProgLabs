package src.Bin;

public class CandyStore {

    private String name;

    private Place location; 

    private int workerCount;

    private Korshik korshik = new Korshik("Коржик");


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
        System.out.print("В тот день "+name+ " продал весь свой запас "+ candyName );
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

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) return true;
      if (!(obj instanceof CandyStore)) return false;

      CandyStore human = (CandyStore) obj;

      return name != null ? name.equals(human.name) : null;

    }

    @Override
    public String toString() {
    return "Character [name=" + name + "]";
    }



private class Korshik {

        private String name;

        public Korshik(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }
}

