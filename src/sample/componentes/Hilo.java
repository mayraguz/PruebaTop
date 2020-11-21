package sample.componentes;

public class Hilo extends Thread {

    @Override
    public void run(){
        super.run();
        for (int i = 1; i <= 10 ; i++) {
            System.out.println("Vuelta" + 1 + "-->" + getName());
            try{
                sleep((long)(Math.random()*5000));
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(getName() + "Llego a la meta");
    }
}
