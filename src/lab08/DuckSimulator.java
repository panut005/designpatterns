package lab08;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator=new DuckSimulator();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();
        simulator.simulate();
        simulator.simulate2();
         simulator.simulate3();
         simulator.simulate4(duckFactory);
        simulator.simulate5(duckFactory);
    }
    void simulate(){
        System.out.println("PART 1********************************************************");
        Quackable mallardDuck = new MallardDuck();
        Quackable redheadDuck = new RedheadDuck();
        Quackable duckCall = new DuckCall();
        Quackable rubberDuck = new RubberDuck();
        Quackable gooseDuck =new GooseAdapter(new Goose());
        Quackable pigeonDuck =new PigeonAdapter(new Pigeon());
        System.out.println("Duck Simulator");
        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);
        simulate(pigeonDuck);

    }

    void simulate2(){
        System.out.println("PART 2.1********************************************************");
        Quackable mallardDuck = new QuackEcho(new QuackCounter(new MallardDuck()));
        Quackable redheadDuck = new QuackEcho(new QuackCounter(new RedheadDuck()));
        Quackable duckCall = new QuackEcho(new QuackCounter(new DuckCall()));
        Quackable rubberDuck = new QuackEcho(new QuackCounter(new RubberDuck()));
        Quackable gooseDuck =new GooseAdapter(new Goose());
        Quackable pigeonDuck =new PigeonAdapter(new Pigeon());
        System.out.println("Duck Simulator");
        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);
        simulate(pigeonDuck);
        System.out.println("The ducks quacked "+QuackCounter.getQuacks()+" times.");
    }
    void simulate3(){
        QuackCounter.setQuacks(0);
        System.out.println("PART 2.2********************************************************");
        Quackable mallardDuck = new QuackCounter(new QuackEcho(new MallardDuck()));
        Quackable redheadDuck = new QuackCounter(new QuackEcho(new RedheadDuck()));
        Quackable duckCall = new QuackCounter(new QuackEcho(new DuckCall()));
        Quackable rubberDuck = new QuackCounter(new QuackEcho(new RubberDuck()));
        Quackable gooseDuck =new GooseAdapter(new Goose());
        Quackable pigeonDuck =new PigeonAdapter(new Pigeon());
        System.out.println("Duck Simulator");
        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);
        simulate(pigeonDuck);
        System.out.println("The ducks quacked "+QuackCounter.getQuacks()+" times.");
    }
    void simulate4(AbstractDuckFactory duckFactory){
        QuackCounter.setQuacks(0);
        System.out.println("PART 3********************************************************");
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck =new GooseAdapter(new Goose());
        Quackable pigeonDuck =new PigeonAdapter(new Pigeon());
        System.out.println("Duck Simulator: With Abstract Factory");
        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);
        simulate(pigeonDuck);
        System.out.println("The ducks quacked "+QuackCounter.getQuacks()+" times.");
}
    void simulate5(AbstractDuckFactory duckFactory){
        QuackCounter.setQuacks(0);
        System.out.println("PART 4********************************************************");
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck =new GooseAdapter(new Goose());
        Quackable pigeonDuck =new PigeonAdapter(new Pigeon());
        System.out.println("Duck Simulator: With Composite - Flocks");

        Flock flockOfDucks = new Flock();
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);
        flockOfDucks.add(pigeonDuck);

        Flock flockOfMallards = new Flock();
        Quackable mallardOne = duckFactory.createMallardDuck();
        Quackable mallardTwo = duckFactory.createMallardDuck();
        Quackable mallardThree = duckFactory.createMallardDuck();
        Quackable mallardFour = duckFactory.createMallardDuck();
        flockOfMallards.add(mallardOne);
        flockOfMallards.add(mallardTwo);
        flockOfMallards.add(mallardThree);
        flockOfMallards.add(mallardFour);
        flockOfDucks.add(flockOfMallards);

        System.out.println("Duck Simulator: Whole Flock Simulation");
        simulate(flockOfDucks);
        System.out.println("Duck Simulator: Mallard Flock Simulation");
        simulate(flockOfMallards);
        System.out.println("The ducks quacked "+QuackCounter.getQuacks()+" times.");
    }
    void simulate(Quackable duck){
        duck.quack();
    }


}
