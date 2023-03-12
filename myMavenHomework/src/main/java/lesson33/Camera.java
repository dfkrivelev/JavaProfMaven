package lesson33;

public class Camera {
    private CameraRoll CameraRoll;

    public void setCameraRoll(CameraRoll CameraRoll) {
        this.CameraRoll = CameraRoll;
    }

    public void takePicture() {
        System.out.println("Click!");
        CameraRoll.processing();
    }
}
