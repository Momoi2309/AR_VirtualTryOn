using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;


public class ChooseGlasses : MonoBehaviour
{

    
    public GameObject glasses1; //game object for the 3 glasses 3d models
    public GameObject glasses2;
    public GameObject glasses3;

    Button glasses1btn; // the ui buttons from canvas for each glasses model
    Button glasses2btn; // i imported unityengine.ui to use these
    Button glasses3btn;

    // Start is called before the first frame update
    void Start()
    {
        glasses1btn = GameObject.Find("Canvas/glasses1btn").GetComponent<Button>(); // store the object into the variables
        glasses2btn = GameObject.Find("Canvas/glasses2btn").GetComponent<Button>();
        glasses3btn = GameObject.Find("Canvas/glasses3btn").GetComponent<Button>();

        glasses1btn.onClick.AddListener(ChooseGlasses1);
        glasses2btn.onClick.AddListener(ChooseGlasses2);
        glasses3btn.onClick.AddListener(ChooseGlasses3);

    }
  
    // Update is called once per frame
    void Update()
    {
        // if (glasses1btn.IsPressed()) // if the button is pressed, activate the game object
        // {
        //     glasses1.SetActive(true);
        //     glasses2.SetActive(false);
        //     glasses3.SetActive(false);
        // }
        // else if (glasses2btn.IsPressed())
        // {
        //     glasses1.SetActive(false);
        //     glasses2.SetActive(true);
        //     glasses3.SetActive(false);
        // }
        // else if (glasses3btn.IsPressed())
        // {
        //     glasses1.SetActive(false);
        //     glasses2.SetActive(false);
        //     glasses3.SetActive(true);
        // }
    }

    public void ChooseGlasses1()
    {
        glasses1.SetActive(true);
        glasses2.SetActive(false);
        glasses3.SetActive(false);
    }

    public void ChooseGlasses2()
    {
        glasses1.SetActive(false);
        glasses2.SetActive(true);
        glasses3.SetActive(false);
    }

    public void ChooseGlasses3()
    {
        glasses1.SetActive(false);
        glasses2.SetActive(false);
        glasses3.SetActive(true);
    }

    
}
