

using UnityEngine;
using UnityEngine.UI;
using UnityEngine.XR.ARFoundation;

public class CameraSwitcher : MonoBehaviour
{
    [SerializeField] private ARCameraManager arCameraManager;
    [SerializeField] public Button switchCameraButton;
    [SerializeField] private Canvas frontCanvas;
    [SerializeField] private Canvas backCanvas;

    private bool isFrontCameraActive = true;

    private void Awake()
    {
        // Add a listener to the switchCameraButton to call the SwitchCamera function when clicked
        switchCameraButton.onClick.AddListener(SwitchCamera);

        // Set the frontCanvas to be visible and the backCanvas to be hidden at startup
        frontCanvas.enabled = true;
        backCanvas.enabled = false;

        // Set the active camera to the front camera at startup
        isFrontCameraActive = true;
        arCameraManager.requestedFacingDirection = CameraFacingDirection.User;
    }

    private void SwitchCamera()
    {
        // Switch the active camera and canvas based on the current camera
        if (isFrontCameraActive)
        {
            arCameraManager.requestedFacingDirection = CameraFacingDirection.World;

            // Show the backCanvas and hide the frontCanvas
            backCanvas.enabled = true;
            frontCanvas.enabled = false;

            // Update the active camera flag
            isFrontCameraActive = false;
        }
        else
        {
            arCameraManager.requestedFacingDirection = CameraFacingDirection.User;

            // Show the frontCanvas and hide the backCanvas
            frontCanvas.enabled = true;
            backCanvas.enabled = false;

            // Update the active camera flag
            isFrontCameraActive = true;
        }
    }
}


