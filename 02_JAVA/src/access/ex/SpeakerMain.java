package access.ex;

public class SpeakerMain {
    public static void main(String[] args) {
        Speaker speaker = new Speaker();

        speaker.volumeUp();
        speaker.powerOff();
        speaker.powerOn();
        speaker.volumeDown();
        speaker.volumeUp();
        speaker.volumeUp();
        speaker.volumeDown();
        speaker.powerOn();
        speaker.powerOff();
    }
}
