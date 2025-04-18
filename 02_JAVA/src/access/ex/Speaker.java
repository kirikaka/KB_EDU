package access.ex;

public class Speaker {
    private boolean power=false;
    private int volume=0;

    public Speaker() {

    }
    public void powerOn(){
        if(isPower()){
            System.out.println("이미 전원이 켜져있습니다.");
            return;
        }
        this.power=true;
        System.out.println("전원을 킵니다.");
    }
    public void powerOff(){
        if(!isPower()){
            System.out.println("전원을 먼저 켜야 합니다.");
            return;
        }
        this.power=false;
        System.out.println("전원을 끕니다.");
    }
    public boolean isPower(){
        return this.power;
    }
    public void volumeUp(){
        if(!isPower()){
            System.out.println("전원을 먼저 켜야 합니다.");
            return;
        }
        this.volume++;
        if(this.volume > 100){
            this.volume--;
            System.out.println("더이상 볼륨을 올릴 수 없습니다");
            return;
        }

        System.out.println("현재 Volume : "+this.volume);
    }
    public void volumeDown(){
        if(!isPower()){
            System.out.println("전원을 먼저 켜야 합니다.");
            return;
        }
        this.volume--;
        if(this.volume <0){
            this.volume++;
            System.out.println("더이상 볼륨을 낮출 수 없습니다");
            return;
        }
        System.out.println("현재 Volume : "+this.volume);

    }

}
