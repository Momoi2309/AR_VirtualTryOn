using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.EventSystems;


public class ColorSelect : MonoBehaviour
{
    public Material band1;
    public Material band2;
    public Material band3;

    // Start is called before the first frame update
    void Start()
    {
        
    }

    public void w1ColorSelect(){
        string buttonName = EventSystem.current.currentSelectedGameObject.name;
        if(buttonName =="black button"){ // has to be the exact name as the button from watch window 1
            //change the color of the band to black
            Color myColor = new Color();
            ColorUtility.TryParseHtmlString("#000000", out myColor);
            band1.color = myColor;

        }
        else if(buttonName =="blue button"){ // change the color of the band to blue
            Color myColor = new Color();
            ColorUtility.TryParseHtmlString("#103B90", out myColor);
            band1.color = myColor;
        }

    }

    public void w2ColorSelect(){
        string buttonName = EventSystem.current.currentSelectedGameObject.name;
        if(buttonName =="black button"){ // has to be the exact name as the button from watch window 2
            //change the color of the band to black
             Color myColor = new Color();
            ColorUtility.TryParseHtmlString("#000000", out myColor);
            band2.color = myColor;
        }
        else if(buttonName =="red button"){ // change the color of the band to red
             Color myColor = new Color();
            ColorUtility.TryParseHtmlString("#740202", out myColor);
            band2.color = myColor;

        } 
    }

    public void w3ColorSelect(){
    string buttonName = EventSystem.current.currentSelectedGameObject.name;
    if(buttonName =="black button"){ // has to be the exact name as the button from watch window 3
            //change the color of the band to black
             Color myColor = new Color();
            ColorUtility.TryParseHtmlString("#464646", out myColor);
            band3.color = myColor;
        }
        else if(buttonName =="silver button"){ // change to silver 
             Color myColor = new Color();
            ColorUtility.TryParseHtmlString("#A1A1A1", out myColor);
            band3.color = myColor;

        }
    }

   
}
