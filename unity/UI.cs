using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.EventSystems;

public class UI : MonoBehaviour
{

    public GameObject glasses1info;
    public GameObject glasses2info;
    public GameObject glasses3info;

    // variable for 3 materials of the color of frames (glasses)
    public Material glasses1color; // material
    public Material glasses2color;
    public Material glasses3color;


    
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    public void Glasses1InfoBoxEnable() // for the glasses1btn from hierarchy
    {

    glasses1info.SetActive(true);
    }

    public void Glasses1InfoBoxDisable() //for the glasses1info->cancelbtn
    {

    glasses1info.SetActive(false);
    }

    public void Glasses2InfoBoxEnable()
    {
    glasses2info.SetActive(true);

    }

    public void Glasses2InfoBoxDisable()
    {
    glasses2info.SetActive(false);
    }
    public void Glasses3InfoBoxEnable()
    {
    glasses3info.SetActive(true);

    }

    public void Glasses3InfoBoxDisable()
    {
    glasses3info.SetActive(false);
    }

    public void Glasses1ColorChange()
    {
       string buttonName = EventSystem.current.currentSelectedGameObject.name;
       if(buttonName == "color1"){
        //change color to blue
        glasses1color.color= new Color(0.1f,0.3f,0.8f);
       }
       else if (buttonName == "color2"){
        //change color to black
        glasses1color.color= new Color(0,0,0);
       }
    }

    public void Glasses2ColorChange()
    {
         string buttonName = EventSystem.current.currentSelectedGameObject.name;
       if(buttonName == "color1"){
        //change color to blue
        glasses2color.color= new Color(0.1f,0.3f,0.8f);
       }
       else if (buttonName == "color2"){
        //change color to black
        glasses2color.color= new Color(0,0,0);
       }
    }

    public void Glasses3ColorChange()
    {
         string buttonName = EventSystem.current.currentSelectedGameObject.name;
       if(buttonName == "color1"){
        //change color to blue
        glasses3color.color= new Color(0.1f,0.3f,0.8f);
       }
       else if (buttonName == "color2"){
        //change color to black
        glasses3color.color= new Color(0,0,0);
       }

    }
}
